package com.xiris.mountainspoem.block.entity;


import com.xiris.mountainspoem.init.MountainsPoemModBlockEntities;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;

public class JianmeibambooBlockEntity extends BlockEntity {
    public JianmeibambooBlockEntity(BlockPos pos, BlockState state) {
        super(MountainsPoemModBlockEntities.JIANMEIBAMBOO.get(), pos, state);
    }
}
