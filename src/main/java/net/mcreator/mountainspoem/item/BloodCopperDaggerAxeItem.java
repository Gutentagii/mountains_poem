
package net.mcreator.mountainspoem.item;

import net.mcreator.mountainspoem.procedures.CopperDaggerAxeShiTiBeiGongJuJiZhongShiProcedure;
import net.mcreator.mountainspoem.procedures.BloodCopperDaggerAxeGongJuChuXianZaiWuPinLanShiMeiKeFaShengProcedure;
import net.mcreator.mountainspoem.init.MountainsPoemModItems;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;

public class BloodCopperDaggerAxeItem extends SwordItem {
	public BloodCopperDaggerAxeItem() {
		super(new Tier() {
			public int getUses() {
				return 940;
			}

			public float getSpeed() {
				return 5f;
			}

			public float getAttackDamageBonus() {
				return 9.5f;
			}

			public int getLevel() {
				return 1;
			}

			public int getEnchantmentValue() {
				return 24;
			}

			public @NotNull Ingredient getRepairIngredient() {
				return Ingredient.of(new ItemStack(MountainsPoemModItems.BLOODCOPPERPLATE.get()));
			}
		}, 3, -3.2f, new Item.Properties());
	}

	@Override
	public boolean hurtEnemy(@NotNull ItemStack itemstack, @NotNull LivingEntity entity, @NotNull LivingEntity sourceentity) {
		boolean retval = super.hurtEnemy(itemstack, entity, sourceentity);
		CopperDaggerAxeShiTiBeiGongJuJiZhongShiProcedure.execute(entity.level(), entity.getX(), entity.getY(), entity.getZ(), entity);
		return retval;
	}

	@Override
	public void inventoryTick(@NotNull ItemStack itemstack, @NotNull Level world, @NotNull Entity entity, int slot, boolean selected) {
		super.inventoryTick(itemstack, world, entity, slot, selected);
		BloodCopperDaggerAxeGongJuChuXianZaiWuPinLanShiMeiKeFaShengProcedure.execute(entity);
	}
}
