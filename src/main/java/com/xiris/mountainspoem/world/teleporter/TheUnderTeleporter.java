package com.xiris.mountainspoem.world.teleporter;

import com.google.common.collect.ImmutableSet;
import com.xiris.mountainspoem.init.MountainsPoemModBlocks;
import net.minecraft.BlockUtil;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.Direction.Axis;
import net.minecraft.core.Direction.AxisDirection;
import net.minecraft.core.Holder;
import net.minecraft.core.Vec3i;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.level.TicketType;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.ai.village.poi.PoiManager;
import net.minecraft.world.entity.ai.village.poi.PoiRecord;
import net.minecraft.world.entity.ai.village.poi.PoiType;
import net.minecraft.world.level.ChunkPos;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.NetherPortalBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.border.WorldBorder;
import net.minecraft.world.level.dimension.DimensionType;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraft.world.level.portal.PortalInfo;
import net.minecraft.world.level.portal.PortalShape;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.common.util.ITeleporter;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegisterEvent;

import javax.annotation.Nullable;
import java.util.Comparator;
import java.util.Optional;
import java.util.function.Function;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class TheUnderTeleporter implements ITeleporter {
    public static final TicketType<BlockPos> CUSTOM_PORTAL =
            TicketType.create("the_under_portal", Vec3i::compareTo, 300);
    public static Holder<PoiType> poi = null;

    @SubscribeEvent
    public static void registerPointOfInterest(RegisterEvent event) {
        event.register(ForgeRegistries.Keys.POI_TYPES, helper -> {
            PoiType poiType = new PoiType(
                    ImmutableSet.copyOf(MountainsPoemModBlocks.THE_UNDER_PORTAL.get().getStateDefinition().getPossibleStates()),
                    0, 1);
            helper.register("the_under_portal", poiType);
            poi = ForgeRegistries.POI_TYPES.getHolder(poiType).orElseThrow();
        });
    }

    private final ServerLevel level;
    private final BlockPos entityEnterPos;

    public TheUnderTeleporter(ServerLevel level, BlockPos entityEnterPos) {
        this.level = level;
        this.entityEnterPos = entityEnterPos;
    }

    public Optional<BlockUtil.FoundRectangle> findPortalAround(BlockPos pos, boolean nearby, WorldBorder border) {
        if (poi == null) {
            return Optional.empty();
        }
        PoiManager poiManager = this.level.getPoiManager();
        int radius = nearby ? 16 : 128;
        poiManager.ensureLoadedAndValid(this.level, pos, radius);

        Optional<BlockPos> found = poiManager.getInSquare(
                        holder -> holder.is(poi.unwrapKey().orElseThrow()),
                        pos, radius, PoiManager.Occupancy.ANY)
                .filter(record -> border.isWithinBounds(record.getPos()))
                .sorted(Comparator.comparingDouble((PoiRecord record) -> record.getPos().distSqr(pos))
                        .thenComparingInt(record -> record.getPos().getY()))
                .filter(record -> this.level.getBlockState(record.getPos())
                        .hasProperty(BlockStateProperties.HORIZONTAL_AXIS))
                .map(PoiRecord::getPos)
                .findFirst();

        if (found.isEmpty()) {
            return Optional.empty();
        }

        BlockPos portalPos = found.get();
        this.level.getChunkSource().addRegionTicket(CUSTOM_PORTAL, new ChunkPos(portalPos), 3, portalPos);
        BlockState state = this.level.getBlockState(portalPos);
        return Optional.of(BlockUtil.getLargestRectangleAround(
                portalPos,
                state.getValue(BlockStateProperties.HORIZONTAL_AXIS),
                21,
                Direction.Axis.Y,
                21,
                p -> this.level.getBlockState(p) == state
        ));
    }

    public Optional<BlockUtil.FoundRectangle> createPortal(BlockPos pos, Axis axis) {
        Direction direction = Direction.get(AxisDirection.POSITIVE, axis);
        double bestDistance = -1.0D;
        BlockPos bestPos = null;
        double fallbackDistance = -1.0D;
        BlockPos fallbackPos = null;
        WorldBorder border = this.level.getWorldBorder();
        int maxY = Math.min(this.level.getMaxBuildHeight(),
                this.level.getMinBuildHeight() + this.level.getLogicalHeight()) - 1;
        BlockPos.MutableBlockPos mutable = pos.mutable();

        for (BlockPos.MutableBlockPos candidate : BlockPos.spiralAround(pos, 16, Direction.EAST, Direction.SOUTH)) {
            int surfaceY = Math.min(maxY, this.level.getHeight(Heightmap.Types.MOTION_BLOCKING,
                    candidate.getX(), candidate.getZ()));
            if (!border.isWithinBounds(candidate) || !border.isWithinBounds(candidate.move(direction, 1))) {
                continue;
            }
            candidate.move(direction.getOpposite(), 1);

            for (int y = surfaceY; y >= this.level.getMinBuildHeight(); y--) {
                candidate.setY(y);
                if (!this.canPortalReplaceBlock(candidate)) {
                    continue;
                }

                int top = y;
                while (y > this.level.getMinBuildHeight() && this.canPortalReplaceBlock(candidate.move(Direction.DOWN))) {
                    y--;
                }

                if (y + 4 > maxY) {
                    continue;
                }

                int height = top - y;
                if (height <= 0 || height >= 3) {
                    candidate.setY(y);
                    if (this.canHostFrame(candidate, mutable, direction, 0)) {
                        double distance = pos.distSqr(candidate);
                        if (this.canHostFrame(candidate, mutable, direction, -1)
                                && this.canHostFrame(candidate, mutable, direction, 1)
                                && (bestDistance == -1.0D || bestDistance > distance)) {
                            bestDistance = distance;
                            bestPos = candidate.immutable();
                        }
                        if (bestDistance == -1.0D && (fallbackDistance == -1.0D || fallbackDistance > distance)) {
                            fallbackDistance = distance;
                            fallbackPos = candidate.immutable();
                        }
                    }
                }
            }
        }

        if (bestDistance == -1.0D && fallbackDistance != -1.0D) {
            bestPos = fallbackPos;
            bestDistance = fallbackDistance;
        }

        if (bestDistance == -1.0D) {
            int minY = Math.max(this.level.getMinBuildHeight() + 1, 70);
            int maxPortalY = maxY - 9;
            if (maxPortalY < minY) {
                return Optional.empty();
            }

            bestPos = new BlockPos(pos.getX(), Mth.clamp(pos.getY(), minY, maxPortalY), pos.getZ()).immutable();
            Direction side = direction.getClockWise();
            if (!border.isWithinBounds(bestPos)) {
                return Optional.empty();
            }

            for (int a = -1; a < 2; a++) {
                for (int b = 0; b < 2; b++) {
                    for (int c = -1; c < 3; c++) {
                        BlockState state = c < 0
                                ? MountainsPoemModBlocks.UNDER_ROCK_BRICKS.get().defaultBlockState()
                                : Blocks.AIR.defaultBlockState();
                        mutable.setWithOffset(bestPos,
                                b * direction.getStepX() + a * side.getStepX(),
                                c,
                                b * direction.getStepZ() + a * side.getStepZ());
                        this.level.setBlockAndUpdate(mutable, state);
                    }
                }
            }
        }

        if (bestPos == null) {
            return Optional.empty();
        }

        for (int a = -1; a < 3; a++) {
            for (int b = -1; b < 4; b++) {
                if (a == -1 || a == 2 || b == -1 || b == 3) {
                    mutable.setWithOffset(bestPos, a * direction.getStepX(), b, a * direction.getStepZ());
                    this.level.setBlock(mutable,
                            MountainsPoemModBlocks.UNDER_ROCK_BRICKS.get().defaultBlockState(), 3);
                }
            }
        }

        BlockState portalState = MountainsPoemModBlocks.THE_UNDER_PORTAL.get()
                .defaultBlockState()
                .setValue(NetherPortalBlock.AXIS, axis);
        for (int a = 0; a < 2; a++) {
            for (int b = 0; b < 3; b++) {
                mutable.setWithOffset(bestPos, a * direction.getStepX(), b, a * direction.getStepZ());
                this.level.setBlock(mutable, portalState, 18);
                if (poi != null) {
                    this.level.getPoiManager().add(mutable, poi);
                }
            }
        }

        return Optional.of(new BlockUtil.FoundRectangle(bestPos.immutable(), 2, 3));
    }

    @Nullable
    @Override
    public PortalInfo getPortalInfo(Entity entity, ServerLevel destination,
                                    Function<ServerLevel, PortalInfo> defaultPortalInfo) {
        WorldBorder border = destination.getWorldBorder();
        double scale = DimensionType.getTeleportationScale(entity.level().dimensionType(),
                destination.dimensionType());
        BlockPos target = border.clampToBounds(
                entity.getX() * scale,
                entity.getY(),
                entity.getZ() * scale);

        Optional<BlockUtil.FoundRectangle> exit = this.getExitPortal(entity, target, border);
        if (exit.isEmpty()) {
            return null;
        }

        BlockUtil.FoundRectangle rectangle = exit.get();
        BlockState sourceState = entity.level().getBlockState(this.entityEnterPos);
        Axis axis = sourceState.getOptionalValue(BlockStateProperties.HORIZONTAL_AXIS).orElse(Axis.X);

        Vec3 relative;
        if (sourceState.hasProperty(BlockStateProperties.HORIZONTAL_AXIS)) {
            BlockUtil.FoundRectangle sourceRectangle = BlockUtil.getLargestRectangleAround(
                    this.entityEnterPos, axis, 21, Direction.Axis.Y, 21,
                    p -> entity.level().getBlockState(p) == sourceState);
            relative = PortalShape.getRelativePosition(
                    sourceRectangle, axis, entity.position(), entity.getDimensions(entity.getPose()));
        } else {
            relative = new Vec3(0.5D, 0.0D, 0.5D);
        }

        return PortalShape.createPortalInfo(destination, rectangle, axis, relative, entity,
                entity.getDeltaMovement(), entity.getYRot(), entity.getXRot());
    }

    private Optional<BlockUtil.FoundRectangle> getExitPortal(Entity entity, BlockPos pos, WorldBorder border) {
        Optional<BlockUtil.FoundRectangle> existing = this.findPortalAround(pos, false, border);
        if (existing.isPresent()) {
            return existing;
        }
        if (entity instanceof ServerPlayer) {
            Axis axis = entity.level().getBlockState(this.entityEnterPos)
                    .getOptionalValue(NetherPortalBlock.AXIS).orElse(Axis.X);
            return this.createPortal(pos, axis);
        }
        return Optional.empty();
    }

    private boolean canPortalReplaceBlock(BlockPos.MutableBlockPos pos) {
        BlockState state = this.level.getBlockState(pos);
        return state.canBeReplaced() && state.getFluidState().isEmpty();
    }

    private boolean canHostFrame(BlockPos pos, BlockPos.MutableBlockPos mutable, Direction direction, int offset) {
        Direction side = direction.getClockWise();
        for (int i = -1; i < 3; i++) {
            for (int j = -1; j < 4; j++) {
                mutable.setWithOffset(pos,
                        direction.getStepX() * i + side.getStepX() * offset,
                        j,
                        direction.getStepZ() * i + side.getStepZ() * offset);
                if (j < 0 && !this.level.getBlockState(mutable).isSolid()) {
                    return false;
                }
                if (j >= 0 && !this.canPortalReplaceBlock(mutable)) {
                    return false;
                }
            }
        }
        return true;
    }
}
