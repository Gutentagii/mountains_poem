
package net.mcreator.mountainspoem.item;

import net.mcreator.mountainspoem.procedures.CopperDaggerAxeShiTiBeiGongJuJiZhongShiProcedure;

public class CopperDaggerAxeItem extends SwordItem {
	public CopperDaggerAxeItem() {
		super(new Tier() {
			public int getUses() {
				return 460;
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
				return 16;
			}

			public Ingredient getRepairIngredient() {
				return Ingredient.of(ItemTags.create(new ResourceLocation("forge:ingots/copper")));
			}
		}, 3, -3.2f, new Item.Properties());
	}

	@Override
	public boolean hurtEnemy(ItemStack itemstack, LivingEntity entity, LivingEntity sourceentity) {
		boolean retval = super.hurtEnemy(itemstack, entity, sourceentity);
		CopperDaggerAxeShiTiBeiGongJuJiZhongShiProcedure.execute(entity.level(), entity.getX(), entity.getY(), entity.getZ(), entity);
		return retval;
	}
}
