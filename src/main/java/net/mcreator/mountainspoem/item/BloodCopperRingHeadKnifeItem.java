
package net.mcreator.mountainspoem.item;

import net.mcreator.mountainspoem.procedures.WoodenRingHeadKnifeShiTiHuiDongWuPinShiProcedure;
import net.mcreator.mountainspoem.procedures.WoodenRingHeadKnifeShiTiBeiGongJuJiZhongShiProcedure;
import net.mcreator.mountainspoem.procedures.RingHead6Procedure;
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

public class BloodCopperRingHeadKnifeItem extends SwordItem {
	public BloodCopperRingHeadKnifeItem() {
		super(new Tier() {
			public int getUses() {
				return 1342;
			}

			public float getSpeed() {
				return 4f;
			}

			public float getAttackDamageBonus() {
				return 11f;
			}

			public int getLevel() {
				return 1;
			}

			public int getEnchantmentValue() {
				return 16;
			}

			public @NotNull Ingredient getRepairIngredient() {
				return Ingredient.of(new ItemStack(MountainsPoemModItems.BLOODCOPPERPLATE.get()));
			}
		}, 3, -2f, new Item.Properties().fireResistant());
	}

	@Override
	public boolean hurtEnemy(@NotNull ItemStack itemstack, @NotNull LivingEntity entity, @NotNull LivingEntity sourceentity) {
		boolean retval = super.hurtEnemy(itemstack, entity, sourceentity);
		WoodenRingHeadKnifeShiTiBeiGongJuJiZhongShiProcedure.execute(entity.level(), entity.getX(), entity.getY(), entity.getZ(), entity);
		return retval;
	}

	@Override
	public boolean hasCraftingRemainingItem(ItemStack stack) {
		return true;
	}

	@Override
	public ItemStack getCraftingRemainingItem(ItemStack itemstack) {
		return new ItemStack(this);
	}

	@Override
	public boolean isRepairable(@NotNull ItemStack itemstack) {
		return false;
	}

	@Override
	public boolean onEntitySwing(ItemStack itemstack, LivingEntity entity) {
		boolean retval = super.onEntitySwing(itemstack, entity);
		WoodenRingHeadKnifeShiTiHuiDongWuPinShiProcedure.execute(entity.level(), entity.getX(), entity.getY(), entity.getZ());
		return retval;
	}

	@Override
	public void inventoryTick(@NotNull ItemStack itemstack, @NotNull Level world, @NotNull Entity entity, int slot, boolean selected) {
		super.inventoryTick(itemstack, world, entity, slot, selected);
		RingHead6Procedure.execute(entity);
	}
}
