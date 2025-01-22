
package net.mcreator.mountainspoem.item;

import net.mcreator.mountainspoem.procedures.PeachwoodSwordShiTiBeiGongJuJiZhongShiProcedure;
import net.mcreator.mountainspoem.procedures.PeachBlossomStickWuPinZaiBeiBaoZhongShiMeiKeFaShengProcedure;
import net.mcreator.mountainspoem.init.MountainsPoemModBlocks;

public class PeachwoodSwordItem extends SwordItem {
	public PeachwoodSwordItem() {
		super(new Tier() {
			public int getUses() {
				return 63;
			}

			public float getSpeed() {
				return 4f;
			}

			public float getAttackDamageBonus() {
				return 4f;
			}

			public int getLevel() {
				return 1;
			}

			public int getEnchantmentValue() {
				return 2;
			}

			public Ingredient getRepairIngredient() {
				return Ingredient.of(new ItemStack(MountainsPoemModBlocks.PEACH_BLOSSOM_PLANKS.get()));
			}
		}, 3, -2.2f, new Item.Properties());
	}

	@Override
	public boolean hurtEnemy(ItemStack itemstack, LivingEntity entity, LivingEntity sourceentity) {
		boolean retval = super.hurtEnemy(itemstack, entity, sourceentity);
		PeachwoodSwordShiTiBeiGongJuJiZhongShiProcedure.execute(entity.level(), entity.getX(), entity.getY(), entity.getZ(), entity);
		return retval;
	}

	@Override
	public void inventoryTick(ItemStack itemstack, Level world, Entity entity, int slot, boolean selected) {
		super.inventoryTick(itemstack, world, entity, slot, selected);
		PeachBlossomStickWuPinZaiBeiBaoZhongShiMeiKeFaShengProcedure.execute(entity);
	}
}
