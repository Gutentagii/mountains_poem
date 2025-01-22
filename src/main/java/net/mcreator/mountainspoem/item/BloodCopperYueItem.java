
package net.mcreator.mountainspoem.item;

import net.mcreator.mountainspoem.procedures.CopperYueShiTiBeiGongJuJiZhongShiProcedure;
import net.mcreator.mountainspoem.procedures.BloodCopperYueGongJuChuXianZaiWuPinLanShiMeiKeFaShengProcedure;
import net.mcreator.mountainspoem.init.MountainsPoemModItems;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.AxeItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;

public class BloodCopperYueItem extends AxeItem {
	public BloodCopperYueItem() {
		super(new Tier() {
			public int getUses() {
				return 946;
			}

			public float getSpeed() {
				return 6f;
			}

			public float getAttackDamageBonus() {
				return 16f;
			}

			public int getLevel() {
				return 4;
			}

			public int getEnchantmentValue() {
				return 25;
			}

			public @NotNull Ingredient getRepairIngredient() {
				return Ingredient.of(new ItemStack(MountainsPoemModItems.BLOODCOPPERPLATE.get()));
			}
		}, 1, -3.4f, new Item.Properties());
	}

	@Override
	public boolean hurtEnemy(@NotNull ItemStack itemstack, @NotNull LivingEntity entity, @NotNull LivingEntity sourceentity) {
		boolean retval = super.hurtEnemy(itemstack, entity, sourceentity);
		CopperYueShiTiBeiGongJuJiZhongShiProcedure.execute(entity);
		return retval;
	}

	@Override
	public void inventoryTick(@NotNull ItemStack itemstack, @NotNull Level world, @NotNull Entity entity, int slot, boolean selected) {
		super.inventoryTick(itemstack, world, entity, slot, selected);
		BloodCopperYueGongJuChuXianZaiWuPinLanShiMeiKeFaShengProcedure.execute(entity);
	}
}
