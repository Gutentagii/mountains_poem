package com.xiris.mountainspoem.enchantment;

import com.xiris.mountainspoem.init.MountainsPoemModItems;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentCategory;
import net.minecraft.world.item.enchantment.Enchantments;

import java.util.Objects;

public class RockAttachedEnchantment extends Enchantment {
    public RockAttachedEnchantment(EquipmentSlot... slots) {
        super(Rarity.COMMON, EnchantmentCategory.WEAPON, slots);
    }

    @Override
    protected boolean checkCompatibility(Enchantment ench) {
        return this != ench && !Objects.equals(Enchantments.FIRE_ASPECT, ench);
    }

    @Override
    public boolean canApplyAtEnchantingTable(ItemStack itemstack) {
        return !Ingredient.of(new ItemStack(MountainsPoemModItems.JUFU_HUMERUS_GLAIVE.get())).test(itemstack);
    }
}
