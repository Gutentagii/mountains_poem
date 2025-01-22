
package net.mcreator.mountainspoem.enchantment;

import net.mcreator.mountainspoem.init.MountainsPoemModItems;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentCategory;
import net.minecraft.world.item.enchantment.Enchantments;
import org.jetbrains.annotations.NotNull;

import java.util.List;
import java.util.Objects;

public class RockAttachedEnchantment extends Enchantment {
	public RockAttachedEnchantment(EquipmentSlot... slots) {
		super(Enchantment.Rarity.COMMON, EnchantmentCategory.WEAPON, slots);
	}

	@Override
	protected boolean checkCompatibility(@NotNull Enchantment ench) {
		return this != ench && !Objects.equals(Enchantments.FIRE_ASPECT, ench);
	}

	@Override
	public boolean canApplyAtEnchantingTable(@NotNull ItemStack itemstack) {
		return !Ingredient.of(new ItemStack(MountainsPoemModItems.JUFU_HUMERUS_GLAIVE.get())).test(itemstack);
	}
}
