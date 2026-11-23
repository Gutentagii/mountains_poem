package com.xiris.mountainspoem.block;

import com.xiris.mountainspoem.init.MountainsPoemModBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.DoublePlantBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.DoubleBlockHalf;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.material.PushReaction;

public class UnderOrchidBlock extends DoublePlantBlock {
    public UnderOrchidBlock() {
        super(BlockBehaviour.Properties.of().mapColor(MapColor.PLANT).sound(SoundType.GRASS).strength(1f, 1f).hasPostProcess((bs, br, bp) -> true).emissiveRendering((bs, br, bp) -> true).lightLevel(s -> 3).noCollission()
                .offsetType(BlockBehaviour.OffsetType.XZ).pushReaction(PushReaction.DESTROY));
    }

    @Override
    public boolean mayPlaceOn(BlockState groundState, BlockGetter worldIn, BlockPos pos) {
        return groundState.is(MountainsPoemModBlocks.SANGUINE_SAND.get()) ||
                groundState.is(MountainsPoemModBlocks.UNDER_GRASS_BLOCK.get()) ||
                groundState.is(MountainsPoemModBlocks.UNDER_DIRT.get()) ||
                groundState.is(Blocks.NETHERRACK) ||
                groundState.is(Blocks.CRIMSON_NYLIUM) ||
                groundState.is(Blocks.WARPED_NYLIUM) ||
                groundState.is(MountainsPoemModBlocks.SANGUINE_SOIL.get());
    }

    @Override
    public boolean canSurvive(BlockState blockstate, LevelReader worldIn, BlockPos pos) {
        BlockPos blockpos = pos.below();
        BlockState groundState = worldIn.getBlockState(blockpos);
        if (blockstate.getValue(HALF) == DoubleBlockHalf.UPPER)
            return groundState.is(this) && groundState.getValue(HALF) == DoubleBlockHalf.LOWER;
        else
            return this.mayPlaceOn(groundState, worldIn, blockpos);
    }
}
