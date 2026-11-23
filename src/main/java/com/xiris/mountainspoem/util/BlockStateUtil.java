package com.xiris.mountainspoem.util;

import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.Property;

import java.util.Map;

public class BlockStateUtil {
    @SuppressWarnings("all")
    public static BlockState copyWithBlock(BlockState from, Block to) {
        BlockState state = to.defaultBlockState();

        for (Map.Entry<Property<?>, Comparable<?>> entry : from.getValues().entrySet()) {
            Property<?> property = entry.getKey();
            Property<?> targetProperty = to.getStateDefinition().getProperty(property.getName());

            if (targetProperty != null) {
                state = setValueSafe(state, targetProperty, entry.getValue());
            }
        }
        return state;
    }

    @SuppressWarnings("unchecked")
    private static <T extends Comparable<T>, V extends T> BlockState setValueSafe(
            BlockState state, Property<?> property, Comparable<?> value
    ) {
        try {
            return state.setValue((Property<T>) property, (V) value);
        } catch (Exception e) {
            return state;
        }
    }

    public static void replaceBlock(LevelAccessor world, BlockPos pos, Block to, boolean withNbt) {
        BlockState from = world.getBlockState(pos);
        BlockState state = copyWithBlock(from, to);
        CompoundTag nbt = null;
        BlockEntity blockEntity = world.getBlockEntity(pos);
        if (blockEntity != null) nbt = blockEntity.saveWithFullMetadata();
        world.setBlock(pos, state, 3);
        if (withNbt && nbt != null) {
            blockEntity = world.getBlockEntity(pos);
            if (blockEntity != null) {
                try {
                    blockEntity.load(nbt);
                } catch (Exception ignored) {
                }
            }
        }
    }
}
