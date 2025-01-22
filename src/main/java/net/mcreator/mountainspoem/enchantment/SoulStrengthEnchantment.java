
package net.mcreator.mountainspoem.enchantment;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentCategory;
import org.jetbrains.annotations.NotNull;

public class SoulStrengthEnchantment extends Enchantment {
	public SoulStrengthEnchantment(EquipmentSlot... slots) {
		super(Enchantment.Rarity.RARE, EnchantmentCategory.ARMOR_FEET, slots);
	}

	@Override
	public boolean canApplyAtEnchantingTable(@NotNull ItemStack itemstack) {
		return Ingredient.of(ItemTags.create(new ResourceLocation("forge:armors/boots"))).test(itemstack);
	}

	@Override
	public boolean isTreasureOnly() {
		return true;
	}
}
