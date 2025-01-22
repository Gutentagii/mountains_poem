
package net.mcreator.mountainspoem.item;

import net.mcreator.mountainspoem.procedures.CopperYueShiTiBeiGongJuJiZhongShiProcedure;

public class CopperYueItem extends AxeItem {
	public CopperYueItem() {
		super(new Tier() {
			public int getUses() {
				return 450;
			}

			public float getSpeed() {
				return 5f;
			}

			public float getAttackDamageBonus() {
				return 12f;
			}

			public int getLevel() {
				return 3;
			}

			public int getEnchantmentValue() {
				return 16;
			}

			public Ingredient getRepairIngredient() {
				return Ingredient.of(ItemTags.create(new ResourceLocation("forge:ingots/copper")));
			}
		}, 1, -3.4f, new Item.Properties());
	}

	@Override
	public boolean hurtEnemy(ItemStack itemstack, LivingEntity entity, LivingEntity sourceentity) {
		boolean retval = super.hurtEnemy(itemstack, entity, sourceentity);
		CopperYueShiTiBeiGongJuJiZhongShiProcedure.execute(entity);
		return retval;
	}
}
