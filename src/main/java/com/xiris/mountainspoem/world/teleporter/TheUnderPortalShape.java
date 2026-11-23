package com.xiris.mountainspoem.world.teleporter;

import com.xiris.mountainspoem.init.MountainsPoemModBlocks;
import net.minecraft.BlockUtil;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityDimensions;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.portal.PortalInfo;
import net.minecraft.world.level.portal.PortalShape;
import net.minecraft.world.phys.Vec3;

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

    public static Optional<TheUnderPortalShape> findPortalShape(LevelAccessor level, BlockPos pos,
                                                                 Predicate<TheUnderPortalShape> predicate,
                                                                 Direction.Axis axis) {
        Optional<TheUnderPortalShape> shape = Optional.of(new TheUnderPortalShape(level, pos, axis)).filter(predicate);
        if (shape.isPresent()) {
            return shape;
        }
        Direction.Axis other = axis == Direction.Axis.X ? Direction.Axis.Z : Direction.Axis.X;
        return Optional.of(new TheUnderPortalShape(level, pos, other)).filter(predicate);
    }

    public TheUnderPortalShape(LevelAccessor level, BlockPos pos, Direction.Axis axis) {
        this.level = level;
        this.axis = axis;
        this.rightDir = axis == Direction.Axis.X ? Direction.WEST : Direction.SOUTH;
        this.bottomLeft = this.calculateBottomLeft(pos);
        if (this.bottomLeft == null) {
            this.bottomLeft = pos;
            this.width = 1;
            this.height = 1;
        } else {
            this.width = this.calculateWidth();
            this.height = this.width > 0 ? this.calculateHeight() : 1;
        }
    }

    @Nullable
    private BlockPos calculateBottomLeft(BlockPos pos) {
        int minY = Math.max(this.level.getMinBuildHeight(), pos.getY() - MAX_HEIGHT);
        while (pos.getY() > minY && isEmpty(this.level.getBlockState(pos.below()))) {
            pos = pos.below();
        }
        Direction left = this.rightDir.getOpposite();
        int distance = this.getDistanceUntilEdgeAboveFrame(pos, left) - 1;
        return distance < 0 ? null : pos.relative(left, distance);
    }

    private int calculateWidth() {
        int width = this.getDistanceUntilEdgeAboveFrame(this.bottomLeft, this.rightDir);
        return width >= MIN_WIDTH && width <= MAX_WIDTH ? width : 0;
    }

    private int getDistanceUntilEdgeAboveFrame(BlockPos pos, Direction direction) {
        BlockPos.MutableBlockPos mutable = new BlockPos.MutableBlockPos();
        for (int i = 0; i <= MAX_WIDTH; i++) {
            mutable.set(pos).move(direction, i);
            BlockState state = this.level.getBlockState(mutable);
            if (!isEmpty(state)) {
                return FRAME.test(state) ? i : 0;
            }
            mutable.move(Direction.DOWN);
            if (!FRAME.test(this.level.getBlockState(mutable))) {
                break;
            }
        }
        return 0;
    }

    private int calculateHeight() {
        BlockPos.MutableBlockPos mutable = new BlockPos.MutableBlockPos();
        int height = this.getDistanceUntilTop(mutable);
        return height >= MIN_HEIGHT && height <= MAX_HEIGHT && this.hasTopFrame(mutable, height) ? height : 0;
    }

    private boolean hasTopFrame(BlockPos.MutableBlockPos mutable, int height) {
        for (int i = 0; i < this.width; i++) {
            mutable.set(this.bottomLeft).move(Direction.UP, height).move(this.rightDir, i);
            if (!FRAME.test(this.level.getBlockState(mutable))) {
                return false;
            }
        }
        return true;
    }

    private int getDistanceUntilTop(BlockPos.MutableBlockPos mutable) {
        for (int i = 0; i < MAX_HEIGHT; i++) {
            mutable.set(this.bottomLeft).move(Direction.UP, i).move(this.rightDir, -1);
            if (!FRAME.test(this.level.getBlockState(mutable))) {
                return i;
            }

            mutable.set(this.bottomLeft).move(Direction.UP, i).move(this.rightDir, this.width);
            if (!FRAME.test(this.level.getBlockState(mutable))) {
                return i;
            }

            for (int j = 0; j < this.width; j++) {
                mutable.set(this.bottomLeft).move(Direction.UP, i).move(this.rightDir, j);
                BlockState state = this.level.getBlockState(mutable);
                if (!isEmpty(state)) {
                    return i;
                }
                if (state.is(MountainsPoemModBlocks.THE_UNDER_PORTAL.get())) {
                    this.numPortalBlocks++;
                }
            }
        }
        return MAX_HEIGHT;
    }

    private static boolean isEmpty(BlockState state) {
        return state.isAir()
                || state.is(BlockTags.FIRE)
                || state.is(MountainsPoemModBlocks.THE_UNDER_PORTAL.get());
    }

    public boolean isValid() {
        return this.bottomLeft != null
                && this.width >= MIN_WIDTH && this.width <= MAX_WIDTH
                && this.height >= MIN_HEIGHT && this.height <= MAX_HEIGHT;
    }

    public boolean isComplete() {
        return this.isValid() && this.numPortalBlocks == this.width * this.height;
    }

    public void createPortalBlocks() {
        BlockState state = MountainsPoemModBlocks.THE_UNDER_PORTAL.get()
                .defaultBlockState()
                .setValue(net.minecraft.world.level.block.NetherPortalBlock.AXIS, this.axis);
        BlockPos.betweenClosed(this.bottomLeft,
                        this.bottomLeft.relative(Direction.UP, this.height - 1).relative(this.rightDir, this.width - 1))
                .forEach(pos -> {
                    this.level.setBlock(pos, state, 18);
                    if (this.level instanceof ServerLevel serverLevel && TheUnderTeleporter.poi != null) {
                        serverLevel.getPoiManager().add(pos, TheUnderTeleporter.poi);
                    }
                });
    }

    public static Vec3 getRelativePosition(BlockUtil.FoundRectangle rectangle, Direction.Axis axis, Vec3 pos,
                                           EntityDimensions dimensions) {
        return PortalShape.getRelativePosition(rectangle, axis, pos, dimensions);
    }

    public static PortalInfo createPortalInfo(ServerLevel level, BlockUtil.FoundRectangle rectangle, Direction.Axis axis,
                                              Vec3 relative, Entity entity, Vec3 motion, float yaw, float xRot) {
        return PortalShape.createPortalInfo(level, rectangle, axis, relative, entity, motion, yaw, xRot);
    }
}
