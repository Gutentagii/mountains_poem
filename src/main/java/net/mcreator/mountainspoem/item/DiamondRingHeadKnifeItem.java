
package net.mcreator.mountainspoem.item;

import net.mcreator.mountainspoem.procedures.WoodenRingHeadKnifeShiTiHuiDongWuPinShiProcedure;
import net.mcreator.mountainspoem.procedures.WoodenRingHeadKnifeShiTiBeiGongJuJiZhongShiProcedure;
import net.mcreator.mountainspoem.procedures.RingHead4Procedure;

public class DiamondRingHeadKnifeItem extends SwordItem {
	public DiamondRingHeadKnifeItem() {
		super(new Tier() {
			public int getUses() {
				return 1677;
			}

			public float getSpeed() {
				return 4f;
			}

			public float getAttackDamageBonus() {
				return 7.5f;
			}

			public int getLevel() {
				return 1;
			}

			public int getEnchantmentValue() {
				return 10;
			}

			public Ingredient getRepairIngredient() {
				return Ingredient.of(new ItemStack(Items.DIAMOND));
			}
		}, 3, -2f, new Item.Properties());
	}

	@Override
	public boolean hurtEnemy(ItemStack itemstack, LivingEntity entity, LivingEntity sourceentity) {
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
	public boolean isRepairable(ItemStack itemstack) {
		return false;
	}

	@Override
	public boolean onEntitySwing(ItemStack itemstack, LivingEntity entity) {
		boolean retval = super.onEntitySwing(itemstack, entity);
		WoodenRingHeadKnifeShiTiHuiDongWuPinShiProcedure.execute(entity.level(), entity.getX(), entity.getY(), entity.getZ());
		return retval;
	}

	@Override
	public void inventoryTick(ItemStack itemstack, Level world, Entity entity, int slot, boolean selected) {
		super.inventoryTick(itemstack, world, entity, slot, selected);
		RingHead4Procedure.execute(entity);
	}
}
