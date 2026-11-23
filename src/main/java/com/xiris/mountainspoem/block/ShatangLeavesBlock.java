package com.xiris.mountainspoem.block;

import com.xiris.mountainspoem.init.MountainsPoemModBlocks;
import com.xiris.mountainspoem.util.BlockStateUtil;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.BonemealableBlock;
import net.minecraft.world.level.block.LeavesBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;

public class ShatangLeavesBlock extends LeavesBlock implements BonemealableBlock {
    public ShatangLeavesBlock() {
        super(BlockBehaviour.Properties.of().ignitedByLava().sound(SoundType.GRASS).strength(0.5f).lightLevel(s -> 1).noOcclusion());
    }

    @Override
    public boolean isValidBonemealTarget(LevelReader worldIn, BlockPos pos, BlockState blockstate, boolean clientSide) {
        return true;
    }

    @Override
    public boolean isBonemealSuccess(Level world, RandomSource random, BlockPos pos, BlockState blockstate) {
        return true;
    }

    @Override
    public void performBonemeal(ServerLevel world, RandomSource random, BlockPos pos, BlockState blockstate) {
        if (Math.random() < 0.7)
            BlockStateUtil.replaceBlock(world, pos, MountainsPoemModBlocks.FRUITFUL_SHATANG_LEAVES.get(), false);
    }
}
