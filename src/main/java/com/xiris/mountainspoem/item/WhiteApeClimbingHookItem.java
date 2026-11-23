
package com.xiris.mountainspoem.item;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class WhiteApeClimbingHookItem extends Item {
    private static final Logger LOGGER = LoggerFactory.getLogger(WhiteApeClimbingHookItem.class);

    public WhiteApeClimbingHookItem() {
        super(new Item.Properties()
                .durability(200)
                .rarity(Rarity.COMMON)
        );
    }

    @Override
    public boolean canApplyAtEnchantingTable(ItemStack stack, Enchantment enchantment) {
        return enchantment == Enchantments.UNBREAKING || enchantment == Enchantments.MENDING;
    }

    @Override
    public int getEnchantmentValue() {
        return 10;
    }

    @Override
    public boolean isEnchantable(ItemStack stack) {
        return true;
    }

    @Override
    public void inventoryTick(ItemStack stack, Level world, net.minecraft.world.entity.Entity entity, int slot, boolean selected) {
        super.inventoryTick(stack, world, entity, slot, selected);

        if (!(entity instanceof Player player) || !selected) return;
        if (player.getCooldowns().isOnCooldown(stack.getItem())) return;

        if (player.onGround() || player.isInWater() || player.isFallFlying()) return;

        BlockPos frontPos = BlockPos.containing(player.getEyePosition().add(player.getLookAngle().normalize()));
        boolean hasWall = !world.isEmptyBlock(frontPos);

        if (!hasWall) return;

        if (entity.getDeltaMovement().x() != 0 || entity.getDeltaMovement().y() != 0 || entity.getLookAngle().z != 0) {
            player.push(0, 0.22, 0);
            player.fallDistance = 0.0F;

            player.getCooldowns().addCooldown(stack.getItem(), 3);

            if (player.tickCount % 500 == 0) {
                int unbreakingLevel = stack.getEnchantmentLevel(Enchantments.UNBREAKING);
                double chance = Math.max(0.0D, 0.1D - unbreakingLevel * 0.02D);

                if (player.getRandom().nextDouble() < chance) {
                    stack.hurtAndBreak(1, player, p -> p.broadcastBreakEvent(EquipmentSlot.MAINHAND));
                }
            }
        }
    }
}