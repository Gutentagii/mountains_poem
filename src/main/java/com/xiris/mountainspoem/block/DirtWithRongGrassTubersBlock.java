package com.xiris.mountainspoem.block;

import com.xiris.mountainspoem.MountainsPoemMod;
import com.xiris.mountainspoem.init.MountainsPoemModBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.BonemealableBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;

public class DirtWithRongGrassTubersBlock extends Block implements BonemealableBlock {
    public DirtWithRongGrassTubersBlock() {
        super(BlockBehaviour.Properties.of().sound(SoundType.GRAVEL).strength(1f, 5f));
    }

    @Override
    public int getLightBlock(BlockState state, BlockGetter worldIn, BlockPos pos) {
        return 15;
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
        if (Math.random() < 0.7) {
            if (world.isEmptyBlock(pos.above()))
                world.setBlock(pos.above(), MountainsPoemModBlocks.RONG_GRASS.get().defaultBlockState(), 3);
            if (world.getBlockState(pos.below()).is(BlockTags.create(ResourceLocation.fromNamespaceAndPath(MountainsPoemMod.MOD_ID, "rong_grass_replaceable"))))
                world.setBlock(pos.below(), MountainsPoemModBlocks.DIRT_WITH_RONG_GRASS_TUBERS.get().defaultBlockState(), 3);
        }
    }
}
