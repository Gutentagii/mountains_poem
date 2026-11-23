package com.xiris.mountainspoem.procedures;

import com.xiris.mountainspoem.entity.BronzeDevourerEntity;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.LevelAccessor;

public class BronzeDevourerEntityRemovalWaxProcedure {
    public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, Entity sourceentity) {
        if (!(entity instanceof BronzeDevourerEntity devourer) || !(sourceentity instanceof Player player)) {
            return;
        }

        if (entity.getPersistentData().getBoolean("Waxed")) {
            return;
        } else {

            if (player.getMainHandItem().getItem() == Items.HONEYCOMB) {

                player.getInventory().clearOrCountMatchingItems(
                        p -> p.getItem() == Items.HONEYCOMB,
                        1,
                        player.inventoryMenu.getCraftSlots()
                );

                entity.getPersistentData().putBoolean("Waxed", true);

                if (world instanceof ServerLevel _level) {
                    _level.sendParticles(ParticleTypes.INSTANT_EFFECT, x, y + 1, z, 8, 0.5, 0.5, 0.5, 0.1);
                }
            }
        }
        if ((entity.getPersistentData().getBoolean("Weathered") || entity.getPersistentData().getBoolean("Exposed"))
                && (player.getMainHandItem().getItem() == Items.WOODEN_AXE
                || player.getMainHandItem().getItem() == Items.STONE_AXE
                || player.getMainHandItem().getItem() == Items.IRON_AXE
                || player.getMainHandItem().getItem() == Items.GOLDEN_AXE
                || player.getMainHandItem().getItem() == Items.DIAMOND_AXE
                || player.getMainHandItem().getItem() == Items.NETHERITE_AXE)) {

            if (entity.getPersistentData().getBoolean("Weathered")) {
                entity.getPersistentData().putBoolean("Weathered", false);
                entity.getPersistentData().putBoolean("Exposed", true);
            }
            else if (entity.getPersistentData().getBoolean("Exposed")) {
                entity.getPersistentData().putBoolean("Exposed", false);
            }
            player.getMainHandItem().hurtAndBreak(1, player, (p) -> {
                p.broadcastBreakEvent(player.getUsedItemHand());
            });
            if (world instanceof ServerLevel _level) {
                _level.sendParticles(ParticleTypes.CRIT, x, y, z, 10, 0.3, 0.3, 0.3, 0.1);
            }
        }
    }
}
