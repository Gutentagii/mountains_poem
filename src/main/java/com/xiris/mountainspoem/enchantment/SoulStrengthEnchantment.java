
package com.xiris.mountainspoem.enchantment;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentCategory;

public class SoulStrengthEnchantment extends Enchantment {
	public SoulStrengthEnchantment(EquipmentSlot... slots) {
		super(Rarity.RARE, EnchantmentCategory.ARMOR_FEET, slots);
	}

	@Override
	public boolean canApplyAtEnchantingTable(ItemStack itemstack) {
		return Ingredient.of(ItemTags.create(ResourceLocation.fromNamespaceAndPath("forge", "armors/boots"))).test(itemstack);
	}

	@Override
	public boolean isTreasureOnly() {
		return true;
	}
}
