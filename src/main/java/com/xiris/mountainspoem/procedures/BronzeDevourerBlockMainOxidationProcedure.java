package com.xiris.mountainspoem.procedures;

import com.xiris.mountainspoem.init.MountainsPoemModBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;

public class BronzeDevourerBlockMainOxidationProcedure {

    private static int emm = 0;

    public static void execute(LevelAccessor world, double x, double y, double z) {
        if (world.isClientSide())
            return;
        if (!(world instanceof Level level))
            return;

        BlockPos pos = BlockPos.containing(x, y, z);
        BlockState state = level.getBlockState(pos);
        Block block = state.getBlock();

        if (block == MountainsPoemModBlocks.BRONZE_DEVOURER_STATUE_WAXED.get()
                || block == MountainsPoemModBlocks.BRONZE_DEVOURER_STATUE_EXPOSED_WAXED.get()
                || block == MountainsPoemModBlocks.BRONZE_DEVOURER_STATUE_WEATHERED_WAXED.get()) {
            return;
        }

        emm++;
        if (emm > 15) {
            emm = 0;
            return;
        }

        if (block != MountainsPoemModBlocks.BRONZE_DEVOURER_STATUE.get()
                && block != MountainsPoemModBlocks.BRONZE_DEVOURER_STATUE_EXPOSED.get()) {
            return;
        }

        RandomSource random = level.random;
        if (random.nextFloat() >= 1.0F / 300.0F)
            return;

        if (canOxidizeFast(level, pos)) {
            upgrade(level, pos, state);
        }
    }

    private static void upgrade(Level world, BlockPos pos, BlockState state) {
        Block current = state.getBlock();
        BlockState newState = null;

        if (current == MountainsPoemModBlocks.BRONZE_DEVOURER_STATUE.get()) {
            newState = MountainsPoemModBlocks.BRONZE_DEVOURER_STATUE_EXPOSED.get().withPropertiesOf(state);
        } else if (current == MountainsPoemModBlocks.BRONZE_DEVOURER_STATUE_EXPOSED.get()) {
            newState = MountainsPoemModBlocks.BRONZE_DEVOURER_STATUE_WEATHERED.get().withPropertiesOf(state);
        }

        if (newState == null)
            return;

        world.setBlock(pos, newState, 3);
    }

    private static boolean canOxidizeFast(Level world, BlockPos pos) {
        Block weatheredBlock = MountainsPoemModBlocks.BRONZE_DEVOURER_STATUE_WEATHERED.get();

        for (BlockPos checkPos : BlockPos.betweenClosed(pos.offset(-4, -4, -4), pos.offset(4, 4, 4))) {
            if (world.getBlockState(checkPos).is(weatheredBlock)) {
                return false;
            }
        }
        return true;
    }
}