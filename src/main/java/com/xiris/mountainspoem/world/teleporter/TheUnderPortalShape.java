package com.xiris.mountainspoem.world.teleporter;

import com.xiris.mountainspoem.init.MountainsPoemModBlocks;
import net.minecraft.BlockUtil;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityDimensions;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.NetherPortalBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.portal.PortalInfo;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;

import javax.annotation.Nullable;
import java.util.Optional;
import java.util.function.Predicate;

public class TheUnderPortalShape {
    private static final int MIN_WIDTH = 2;
    public static final int MAX_WIDTH = 21;
    private static final int MIN_HEIGHT = 3;
    public static final int MAX_HEIGHT = 21;

    private static final Predicate<BlockState> FRAME = state ->
            state.is(MountainsPoemModBlocks.UNDER_ROCK_BRICKS.get());

    private static final float SAFE_TRAVEL_MAX_ENTITY_XY = 4.0F;
    private static final double SAFE_TRAVEL_MAX_VERTICAL_DELTA = 1.0D;

    private final LevelAccessor level;
    private final Direction.Axis axis;
    private final Direction rightDir;
    private int numPortalBlocks;

    @Nullable
    private BlockPos bottomLeft;
    private int height;
    private final int width;

    public static Optional<TheUnderPortalShape> findEmptyPortalShape(LevelAccessor level, BlockPos pos, Direction.Axis axis) {
        return findPortalShape(level, pos, shape -> shape.isValid() && shape.numPortalBlocks == 0, axis);
    }

    public static Optional<TheUnderPortalShape> findPortalShape(LevelAccessor level, BlockPos pos, Predicate<TheUnderPortalShape> predicate, Direction.Axis axis) {
        Optional<TheUnderPortalShape> shape = Optional.of(new TheUnderPortalShape(level, pos, axis)).filter(predicate);
        if (shape.isPresent()) return shape;
        Direction.Axis other = axis == Direction.Axis.X ? Direction.Axis.Z : Direction.Axis.X;
        return Optional.of(new TheUnderPortalShape(level, pos, other)).filter(predicate);
    }

    public TheUnderPortalShape(LevelAccessor level, BlockPos pos, Direction.Axis axis) {
        this.level = level;
        this.axis = axis;
        this.rightDir = axis == Direction.Axis.X ? Direction.WEST : Direction.SOUTH;

        this.bottomLeft = calculateBottomLeft(pos);
        if (this.bottomLeft == null) {
            this.bottomLeft = pos;
            this.width = 1;
            this.height = 1;
            return;
        }

        this.width = calculateWidth();
        this.height = this.width > 0 ? calculateHeight() : 1;
    }

    @Nullable
    private BlockPos calculateBottomLeft(BlockPos pos) {
        int minY = Math.max(this.level.getMinBuildHeight(), pos.getY() - MAX_HEIGHT);
        while (pos.getY() > minY && isEmpty(this.level.getBlockState(pos.below()))) {
            pos = pos.below();
        }

        Direction left = rightDir.getOpposite();
        int dist = getDistanceUntilEdgeAboveFrame(pos, left) - 1;
        return dist < 0 ? null : pos.relative(left, dist);
    }

    private int calculateWidth() {
        int w = getDistanceUntilEdgeAboveFrame(bottomLeft, rightDir);
        return (w >= MIN_WIDTH && w <= MAX_WIDTH) ? w : 0;
    }

    private int getDistanceUntilEdgeAboveFrame(BlockPos pos, Direction dir) {
        BlockPos.MutableBlockPos m = new BlockPos.MutableBlockPos();
        for (int i = 0; i <= MAX_WIDTH; i++) {
            m.set(pos).move(dir, i);
            BlockState state = level.getBlockState(m);
            if (!isEmpty(state)) {
                return FRAME.test(state) ? i : 0;
            }
            m.move(Direction.DOWN);
            BlockState belowState = level.getBlockState(m);
            if (!FRAME.test(belowState)) {
                break;
            }
        }
        return 0;
    }

    private int calculateHeight() {
        BlockPos.MutableBlockPos m = new BlockPos.MutableBlockPos();
        int h = getDistanceUntilTop(m);
        return (h >= MIN_HEIGHT && h <= MAX_HEIGHT && hasTopFrame(m, h)) ? h : 0;
    }

    private boolean hasTopFrame(BlockPos.MutableBlockPos m, int h) {
        for (int i = 0; i < width; i++) {
            m.set(bottomLeft).move(Direction.UP, h).move(rightDir, i);
            if (!FRAME.test(level.getBlockState(m))) return false;
        }
        return true;
    }

    private int getDistanceUntilTop(BlockPos.MutableBlockPos m) {
        for (int h = 0; h < MAX_HEIGHT; h++) {
            m.set(bottomLeft).move(Direction.UP, h).move(rightDir, -1);
            if (!FRAME.test(level.getBlockState(m))) return h;

            m.set(bottomLeft).move(Direction.UP, h).move(rightDir, width);
            if (!FRAME.test(level.getBlockState(m))) return h;

            for (int w = 0; w < width; w++) {
                m.set(bottomLeft).move(Direction.UP, h).move(rightDir, w);
                BlockState state = level.getBlockState(m);
                if (!isEmpty(state)) return h;
                if (state.is(MountainsPoemModBlocks.THE_UNDER_PORTAL.get())) {
                    numPortalBlocks++;
                }
            }
        }
        return MAX_HEIGHT;
    }

    private static boolean isEmpty(BlockState state) {
        return state.isAir() || state.is(MountainsPoemModBlocks.THE_UNDER_PORTAL.get());
    }

    public boolean isValid() {
        return bottomLeft != null && width >= MIN_WIDTH && width <= MAX_WIDTH
                && height >= MIN_HEIGHT && height <= MAX_HEIGHT;
    }

    public boolean isComplete() {
        return isValid() && numPortalBlocks == width * height;
    }

    public void createPortalBlocks() {
        BlockState state = MountainsPoemModBlocks.THE_UNDER_PORTAL.get()
                .defaultBlockState()
                .setValue(NetherPortalBlock.AXIS, axis);

        BlockPos.betweenClosed(bottomLeft, bottomLeft.relative(Direction.UP, height - 1).relative(rightDir, width - 1))
                .forEach(pos -> {
                    level.setBlock(pos, state, 18);
                    if (level instanceof ServerLevel sl && TheUnderTeleporter.poi != null) {
                        sl.getPoiManager().add(pos, TheUnderTeleporter.poi);
                    }
                });
    }

    public static Vec3 getRelativePosition(BlockUtil.FoundRectangle r, Direction.Axis a, Vec3 v, EntityDimensions d) {
        double d0 = (double) r.axis1Size - d.width;
        double d1 = (double) r.axis2Size - d.height;
        BlockPos blockpos = r.minCorner;
        double d2;

        if (d0 > 0.0D) {
            float f = (float) blockpos.get(a) + d.width / 2.0F;
            d2 = Mth.clamp(Mth.inverseLerp(v.get(a) - f, 0.0D, d0), 0.0D, 1.0D);
        } else {
            d2 = 0.5D;
        }

        double d4;
        if (d1 > 0.0D) {
            Direction.Axis yAxis = Direction.Axis.Y;
            d4 = Mth.clamp(Mth.inverseLerp(v.get(yAxis) - blockpos.getY(), 0.0D, d1), 0.0D, 1.0D);
        } else {
            d4 = 0.0D;
        }

        Direction.Axis otherAxis = a == Direction.Axis.X ? Direction.Axis.Z : Direction.Axis.X;
        double d3 = v.get(otherAxis) - (blockpos.get(otherAxis) + 0.5D);
        return new Vec3(d2, d4, d3);
    }

    public static PortalInfo createPortalInfo(ServerLevel level, BlockUtil.FoundRectangle r, Direction.Axis axis, Vec3 rel, Entity entity, Vec3 motion, float yaw, float xRot) {
        BlockPos pos = r.minCorner;
        BlockState state = level.getBlockState(pos);
        Direction.Axis portalAxis = state.getOptionalValue(BlockStateProperties.HORIZONTAL_AXIS).orElse(Direction.Axis.X);

        double w = r.axis1Size;
        double h = r.axis2Size;
        EntityDimensions dims = entity.getDimensions(entity.getPose());

        int rot = axis == portalAxis ? 0 : 90;
        Vec3 newMotion = axis == portalAxis ? motion : new Vec3(motion.z, motion.y, -motion.x);

        double d2 = dims.width / 2.0 + (w - dims.width) * rel.x();
        double d3 = (h - dims.height) * rel.y();
        double d4 = 0.5D + rel.z();
        boolean isX = portalAxis == Direction.Axis.X;

        Vec3 spawnPos = new Vec3(
                pos.getX() + (isX ? d2 : d4),
                pos.getY() + d3,
                pos.getZ() + (isX ? d4 : d2)
        );

        Vec3 safePos = findCollisionFreePosition(spawnPos, level, entity, dims);
        return new PortalInfo(safePos, newMotion, yaw + rot, xRot);
    }

    private static Vec3 findCollisionFreePosition(Vec3 pos, ServerLevel level, Entity entity, EntityDimensions dims) {
        if (dims.width > SAFE_TRAVEL_MAX_ENTITY_XY || dims.height > SAFE_TRAVEL_MAX_ENTITY_XY) {
            return pos;
        }

        double halfHeight = dims.height / 2.0D;
        Vec3 center = pos.add(0.0D, halfHeight, 0.0D);
        AABB aabb = AABB.ofSize(center, dims.width, 0.0D, dims.width).expandTowards(0.0D, 1.0D, 0.0D).inflate(1.0E-6D);
        VoxelShape shape = Shapes.create(aabb);

        Optional<Vec3> safe = level.findFreePosition(entity, shape, center, dims.width, dims.height, dims.width);
        return safe.map(v -> v.subtract(0.0D, halfHeight, 0.0D)).orElse(pos);
    }
}