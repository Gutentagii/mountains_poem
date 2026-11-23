package com.xiris.mountainspoem.block;

import com.xiris.mountainspoem.init.MountainsPoemModBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.BonemealableBlock;
import net.minecraft.world.level.block.FlowerBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.material.PushReaction;

public class XunyearBlock extends FlowerBlock implements BonemealableBlock {
    public XunyearBlock() {
        super(MobEffects.DIG_SPEED, 94, BlockBehaviour.Properties.of().mapColor(MapColor.PLANT).sound(SoundType.GRASS).instabreak().noOcclusion().offsetType(BlockBehaviour.OffsetType.NONE).pushReaction(PushReaction.DESTROY));
    }

    @Override
    public boolean mayPlaceOn(BlockState groundState, BlockGetter worldIn, BlockPos pos) {
        return groundState.is(Blocks.GRASS_BLOCK) ||
                groundState.is(MountainsPoemModBlocks.LUSH_GRASS_BLOCK.get()) ||
                groundState.is(MountainsPoemModBlocks.LUSH_DIRT.get()) ||
                groundState.is(Blocks.DIRT) ||
                groundState.is(Blocks.COARSE_DIRT);
    }

    @Override
    public boolean canSurvive(BlockState blockstate, LevelReader worldIn, BlockPos pos) {
        BlockPos blockpos = pos.below();
        BlockState groundState = worldIn.getBlockState(blockpos);
        return this.mayPlaceOn(groundState, worldIn, blockpos);
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
        if (Math.random() < 0.7 && world.isEmptyBlock(pos.above()))
            world.setBlock(pos.above(), MountainsPoemModBlocks.XUN_LEAVES_BERRY.get().defaultBlockState(), 3);
    }
}
