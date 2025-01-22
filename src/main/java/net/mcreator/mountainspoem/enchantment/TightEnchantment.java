
package net.mcreator.mountainspoem.enchantment;

import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentCategory;

public class TightEnchantment extends Enchantment {
	public TightEnchantment(EquipmentSlot... slots) {
		super(Enchantment.Rarity.UNCOMMON, EnchantmentCategory.ARMOR_CHEST, slots);
	}

	@Override
	public int getDamageProtection(int level, DamageSource source) {
		return level * 1;
	}
}
