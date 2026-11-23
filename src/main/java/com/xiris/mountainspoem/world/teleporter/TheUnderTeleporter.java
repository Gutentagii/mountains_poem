package com.xiris.mountainspoem.world.teleporter;

import com.google.common.collect.ImmutableSet;
import com.xiris.mountainspoem.init.MountainsPoemModBlocks;
import net.minecraft.BlockUtil;
import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.Holder;
import net.minecraft.core.Vec3i;
import net.minecraft.core.Direction.Axis;
import net.minecraft.core.Direction.AxisDirection;
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
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.common.util.ITeleporter;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegisterEvent;

import java.util.Comparator;
import java.util.Optional;
import java.util.function.Function;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class TheUnderTeleporter implements ITeleporter {

    public static final TicketType<BlockPos> CUSTOM_PORTAL = TicketType.create("the_under_portal", Vec3i::compareTo, 300);
    public static Holder<PoiType> poi = null;

    @SubscribeEvent
    public static void registerPointOfInterest(RegisterEvent event) {
        event.register(ForgeRegistries.Keys.POI_TYPES, registerHelper -> {
            PoiType poiType = new PoiType(ImmutableSet.copyOf(MountainsPoemModBlocks.THE_UNDER_PORTAL.get().getStateDefinition().getPossibleStates()), 0, 1);
            registerHelper.register("the_under_portal", poiType);
            poi = ForgeRegistries.POI_TYPES.getHolder(poiType).orElseThrow();
        });
    }

    private final ServerLevel level;
    private final BlockPos entityEnterPos;

    public TheUnderTeleporter(ServerLevel worldServer, BlockPos entityEnterPos) {
        this.level = worldServer;
        this.entityEnterPos = entityEnterPos;
    }

    public Optional<BlockUtil.FoundRectangle> findPortalAround(BlockPos pos, boolean flag, WorldBorder border) {
        PoiManager poimanager = this.level.getPoiManager();
        int i = flag ? 16 : 128;
        poimanager.ensureLoadedAndValid(this.level, pos, i);

        Optional<BlockPos> foundPos = poimanager.getInSquare((p) -> p.is(poi.unwrapKey().orElseThrow()), pos, i, PoiManager.Occupancy.ANY)
                .filter((r) -> border.isWithinBounds(r.getPos()))
                .sorted(Comparator.comparingDouble((r) -> r.getPos().distSqr(pos)))
                .filter((r) -> this.level.getBlockState(r.getPos()).hasProperty(BlockStateProperties.HORIZONTAL_AXIS))
                .map(PoiRecord::getPos)
                .findFirst();

        if (foundPos.isEmpty())
            return Optional.empty();

        BlockPos blockpos = foundPos.get();
        this.level.getChunkSource().addRegionTicket(CUSTOM_PORTAL, new ChunkPos(blockpos), 3, blockpos);
        BlockState state = this.level.getBlockState(blockpos);
        return Optional.of(BlockUtil.getLargestRectangleAround(
                blockpos, state.getValue(BlockStateProperties.HORIZONTAL_AXIS), 21,
                Direction.Axis.Y, 21,
                (p) -> this.level.getBlockState(p) == state
        ));
    }

    public Optional<BlockUtil.FoundRectangle> createPortal(BlockPos pos, Axis axis) {
        Direction direction = Direction.get(AxisDirection.POSITIVE, axis);
        double d0 = -1.0D;
        BlockPos blockpos = null;
        double d1 = -1.0D;
        BlockPos blockpos1 = null;
        WorldBorder border = this.level.getWorldBorder();
        int i = Math.min(this.level.getMaxBuildHeight(), this.level.getMinBuildHeight() + this.level.getLogicalHeight()) - 1;
        BlockPos.MutableBlockPos mutable = pos.mutable();

        for (BlockPos.MutableBlockPos mut : BlockPos.spiralAround(pos, 16, Direction.EAST, Direction.SOUTH)) {
            int j = Math.min(i, this.level.getHeight(Heightmap.Types.MOTION_BLOCKING, mut.getX(), mut.getZ()));
            if (border.isWithinBounds(mut) && border.isWithinBounds(mut.move(direction, 1))) {
                mut.move(direction.getOpposite(), 1);
                for (int l = j; l >= this.level.getMinBuildHeight(); --l) {
                    mut.setY(l);
                    if (this.canPortalReplaceBlock(mut)) {
                        int i1;
                        for (i1 = l; l > this.level.getMinBuildHeight() && this.canPortalReplaceBlock(mut.move(Direction.DOWN)); --l) {}
                        if (l + 4 <= i) {
                            int j1 = i1 - l;
                            if (j1 >= 3) {
                                mut.setY(l);
                                if (this.canHostFrame(mut, mutable, direction, 0)) {
                                    double dist = pos.distSqr(mut);
                                    if (this.canHostFrame(mut, mutable, direction, -1) && this.canHostFrame(mut, mutable, direction, 1)
                                            && (d0 == -1 || d0 > dist)) {
                                        d0 = dist;
                                        blockpos = mut.immutable();
                                    }
                                    if (d0 == -1 && (d1 == -1 || d1 > dist)) {
                                        d1 = dist;
                                        blockpos1 = mut.immutable();
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }

        if (d0 == -1 && d1 != -1) {
            blockpos = blockpos1;
        }
        if (d0 == -1) {
            int k1 = Math.max(this.level.getMinBuildHeight(), 70);
            int i2 = i - 9;
            if (i2 < k1) return Optional.empty();
            blockpos = new BlockPos(pos.getX(), Mth.clamp(pos.getY(), k1, i2), pos.getZ()).immutable();
            Direction dirCW = direction.getClockWise();
            if (!border.isWithinBounds(blockpos)) return Optional.empty();

            for (int a = -1; a < 2; a++) {
                for (int b = 0; b < 2; b++) {
                    for (int c = -1; c < 3; c++) {
                        BlockState state = c < 0 ? MountainsPoemModBlocks.UNDER_ROCK_BRICKS.get().defaultBlockState() : Blocks.AIR.defaultBlockState();
                        mutable.setWithOffset(blockpos,
                                b * direction.getStepX() + a * dirCW.getStepX(),
                                c,
                                b * direction.getStepZ() + a * dirCW.getStepZ());
                        this.level.setBlockAndUpdate(mutable, state);
                    }
                }
            }
        }

        for (int a = -1; a < 3; a++) {
            for (int b = -1; b < 4; b++) {
                if (a == -1 || a == 2 || b == -1 || b == 3) {
                    mutable.setWithOffset(blockpos, a * direction.getStepX(), b, a * direction.getStepZ());
                    this.level.setBlock(mutable, MountainsPoemModBlocks.UNDER_ROCK_BRICKS.get().defaultBlockState(), 3);
                }
            }
        }

        BlockState portalState = MountainsPoemModBlocks.THE_UNDER_PORTAL.get().defaultBlockState().setValue(NetherPortalBlock.AXIS, axis);
        for (int a = 0; a < 2; a++) {
            for (int b = 0; b < 3; b++) {
                mutable.setWithOffset(blockpos, a * direction.getStepX(), b, a * direction.getStepZ());
                this.level.setBlock(mutable, portalState, 18);
                this.level.getPoiManager().add(mutable, poi);
            }
        }

        return Optional.of(new BlockUtil.FoundRectangle(blockpos.immutable(), 2, 3));
    }

    private boolean canHostFrame(BlockPos pos, BlockPos.MutableBlockPos mut, Direction dir, int offset) {
        Direction clock = dir.getClockWise();
        for (int i = -1; i < 3; i++) {
            for (int j = -1; j < 4; j++) {
                mut.setWithOffset(pos,
                        dir.getStepX() * i + clock.getStepX() * offset,
                        j,
                        dir.getStepZ() * i + clock.getStepZ() * offset);
                if (j < 0 && !this.level.getBlockState(mut).isSolid()) return false;
                if (j >= 0 && !this.canPortalReplaceBlock(mut)) return false;
            }
        }
        return true;
    }

    @Override
    public Entity placeEntity(Entity entity, ServerLevel currentWorld, ServerLevel destWorld, float yaw, Function<Boolean, Entity> repositionEntity) {
        PortalInfo info = this.getPortalInfo(entity, destWorld);

        if (entity instanceof ServerPlayer player) {
            player.setServerLevel(destWorld);
            destWorld.addDuringPortalTeleport(player);
            player.connection.teleport(info.pos.x, info.pos.y, info.pos.z, info.yRot, info.xRot);
            player.connection.resetPosition();
            CriteriaTriggers.CHANGED_DIMENSION.trigger(player, currentWorld.dimension(), destWorld.dimension());
            return entity;
        } else {
            Entity copy = entity.getType().create(destWorld);
            if (copy != null) {
                copy.restoreFrom(entity);
                copy.moveTo(info.pos.x, info.pos.y, info.pos.z, info.yRot, copy.getXRot());
                copy.setDeltaMovement(info.speed);
                destWorld.addDuringTeleport(copy);
            }
            return copy;
        }
    }

    private PortalInfo getPortalInfo(Entity entity, ServerLevel server) {
        WorldBorder border = server.getWorldBorder();
        double scale = DimensionType.getTeleportationScale(entity.level().dimensionType(), server.dimensionType());
        BlockPos pos = border.clampToBounds(entity.getX() * scale, entity.getY(), entity.getZ() * scale);

        return this.getExitPortal(entity, pos, border).map(reposition -> {
            BlockState state = entity.level().getBlockState(this.entityEnterPos);
            Axis axis;
            Vec3 relative;

            if (state.hasProperty(BlockStateProperties.HORIZONTAL_AXIS)) {
                axis = state.getValue(BlockStateProperties.HORIZONTAL_AXIS);
                BlockUtil.FoundRectangle rect = BlockUtil.getLargestRectangleAround(this.entityEnterPos, axis, 21, Axis.Y, 21,
                        p -> entity.level().getBlockState(p) == state);
                relative = TheUnderPortalShape.getRelativePosition(rect, axis, entity.position(), entity.getDimensions(entity.getPose()));
            } else {
                axis = Axis.X;
                relative = new Vec3(0.5, 0, 0.5);
            }

            return TheUnderPortalShape.createPortalInfo(server, reposition, axis, relative,
                    entity, entity.getDeltaMovement(), entity.getYRot(), entity.getXRot());
        }).orElse(new PortalInfo(entity.position(), Vec3.ZERO, entity.getYRot(), entity.getXRot()));
    }

    protected Optional<BlockUtil.FoundRectangle> getExitPortal(Entity entity, BlockPos pos, WorldBorder border) {
        Optional<BlockUtil.FoundRectangle> exist = this.findPortalAround(pos, false, border);
        if (entity instanceof ServerPlayer) {
            if (exist.isPresent()) return exist;
            Axis axis = entity.level().getBlockState(this.entityEnterPos)
                    .getOptionalValue(NetherPortalBlock.AXIS).orElse(Axis.X);
            return this.createPortal(pos, axis);
        }
        return exist;
    }

    private boolean canPortalReplaceBlock(BlockPos.MutableBlockPos pos) {
        BlockState state = this.level.getBlockState(pos);
        return state.canBeReplaced() && state.getFluidState().isEmpty();
    }
}