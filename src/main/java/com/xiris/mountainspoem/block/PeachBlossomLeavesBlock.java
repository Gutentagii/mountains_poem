package com.xiris.mountainspoem.block;

import com.xiris.mountainspoem.init.MountainsPoemModParticleTypes;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.block.LeavesBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;

public class PeachBlossomLeavesBlock extends LeavesBlock {
    public PeachBlossomLeavesBlock() {
        super(BlockBehaviour.Properties.of().ignitedByLava().sound(SoundType.GRASS).strength(0.18f).lightLevel(s -> 1).noOcclusion());
    }

    @Override
    public void tick(BlockState blockstate, ServerLevel world, BlockPos pos, RandomSource random) {
        super.tick(blockstate, world, pos, random);
        if (world.isEmptyBlock(pos.below()))
            world.sendParticles((Math.random() < 0.7 ? MountainsPoemModParticleTypes.PEACH_BLOSSOMS : MountainsPoemModParticleTypes.PEACH_BLOSSOMS_2).get(), pos.getX(), pos.getY(), pos.getZ(), 3, 0.2, 0.2, 0.2, 0.5);
    }
}
