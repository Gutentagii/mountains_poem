package com.xiris.mountainspoem.block;

import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.Nullable;

public class LushDirtBlock extends Block {
    public LushDirtBlock() {
        super(BlockBehaviour.Properties.of()
                .sound(SoundType.GRAVEL)
                .strength(1f, 9f)
                .lightLevel(s -> 15)
        );
    }

    @Override
    public void playerDestroy(Level world, Player player, BlockPos pos, BlockState blockState,
                              @Nullable BlockEntity blockEntity, ItemStack itemStack) {
        super.playerDestroy(world, player, pos, blockState, blockEntity, itemStack);


        if (Math.random() < 0.2 && world instanceof ServerLevel serverLevel) {
            double x = pos.getX() + 0.5;
            double y = pos.getY() + 0.5;
            double z = pos.getZ() + 0.5;

            if (serverLevel.isDay()) {
                spawnItem(serverLevel, x, y, z, Items.WHEAT_SEEDS);
            }

            if (serverLevel.isThundering()) {
                spawnItem(serverLevel, x, y, z, Items.PUMPKIN_SEEDS);
            }

            if (serverLevel.isRaining() && !serverLevel.isThundering()) {
                spawnItem(serverLevel, x, y, z, Items.BEETROOT_SEEDS);
            }
        }
    }

    private void spawnItem(ServerLevel level, double x, double y, double z, net.minecraft.world.item.Item item) {
        ItemEntity itemEntity = new ItemEntity(level, x, y, z, new ItemStack(item));
        level.addFreshEntity(itemEntity);
    }
}