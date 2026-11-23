package com.xiris.mountainspoem.procedures;

import com.xiris.mountainspoem.init.MountainsPoemModBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;

public class BronzeDevourerBlockRemovalWaxProcedure {
    public static void execute(LevelAccessor world, double x, double y, double z, Block block, Player player) {
        BlockPos pos = BlockPos.containing(x, y, z);
        BlockState currentState = world.getBlockState(pos);

        if (player.getMainHandItem().getItem() == Items.HONEYCOMB) {
            if (block == MountainsPoemModBlocks.BRONZE_DEVOURER_STATUE_WAXED.get()
                    || block == MountainsPoemModBlocks.BRONZE_DEVOURER_STATUE_EXPOSED_WAXED.get()
                    || block == MountainsPoemModBlocks.BRONZE_DEVOURER_STATUE_WEATHERED_WAXED.get()) {
                return;
            }

            if (!player.isCreative()) {
                player.getInventory().clearOrCountMatchingItems(
                        p -> p.getItem() == Items.HONEYCOMB,
                        1,
                        player.inventoryMenu.getCraftSlots()
                );
            }

            Block waxedBlock = block;
            if (block == MountainsPoemModBlocks.BRONZE_DEVOURER_STATUE.get()) {
                waxedBlock = MountainsPoemModBlocks.BRONZE_DEVOURER_STATUE_WAXED.get();
            } else if (block == MountainsPoemModBlocks.BRONZE_DEVOURER_STATUE_EXPOSED.get()) {
                waxedBlock = MountainsPoemModBlocks.BRONZE_DEVOURER_STATUE_EXPOSED_WAXED.get();
            } else if (block == MountainsPoemModBlocks.BRONZE_DEVOURER_STATUE_WEATHERED.get()) {
                waxedBlock = MountainsPoemModBlocks.BRONZE_DEVOURER_STATUE_WEATHERED_WAXED.get();
            }

            world.setBlock(pos, waxedBlock.defaultBlockState(), 3);

            if (world instanceof ServerLevel serverLevel) {
                serverLevel.sendParticles(ParticleTypes.INSTANT_EFFECT,
                        x + 0.5, y + 1, z + 0.5,
                        8, 0.5, 0.5, 0.5, 0.1);
            }
            return;
        }

        if (player.getMainHandItem().getItem() == Items.WOODEN_AXE
                || player.getMainHandItem().getItem() == Items.STONE_AXE
                || player.getMainHandItem().getItem() == Items.IRON_AXE
                || player.getMainHandItem().getItem() == Items.GOLDEN_AXE
                || player.getMainHandItem().getItem() == Items.DIAMOND_AXE
                || player.getMainHandItem().getItem() == Items.NETHERITE_AXE) {

            BlockState newState = null;

            if (currentState.is(MountainsPoemModBlocks.BRONZE_DEVOURER_STATUE_WEATHERED.get())) {
                newState = MountainsPoemModBlocks.BRONZE_DEVOURER_STATUE_EXPOSED.get().defaultBlockState();
            } else if (currentState.is(MountainsPoemModBlocks.BRONZE_DEVOURER_STATUE_WEATHERED_WAXED.get())) {
                newState = MountainsPoemModBlocks.BRONZE_DEVOURER_STATUE_EXPOSED_WAXED.get().defaultBlockState();
            } else if (currentState.is(MountainsPoemModBlocks.BRONZE_DEVOURER_STATUE_EXPOSED.get())) {
                newState = MountainsPoemModBlocks.BRONZE_DEVOURER_STATUE.get().defaultBlockState();
            } else if (currentState.is(MountainsPoemModBlocks.BRONZE_DEVOURER_STATUE_EXPOSED_WAXED.get())) {
                newState = MountainsPoemModBlocks.BRONZE_DEVOURER_STATUE_WAXED.get().defaultBlockState();
            }

            if (newState != null) {
                world.setBlock(pos, newState, 3);

                if (!player.isCreative()) {
                    player.getMainHandItem().hurtAndBreak(1, player,
                            p -> p.broadcastBreakEvent(player.getUsedItemHand()));
                }

                if (world instanceof ServerLevel serverLevel) {
                    serverLevel.sendParticles(ParticleTypes.CRIT,
                            x + 0.5, y + 0.5, z + 0.5,
                            10, 0.3, 0.3, 0.3, 0.1);
                }
            }
        }
    }
}