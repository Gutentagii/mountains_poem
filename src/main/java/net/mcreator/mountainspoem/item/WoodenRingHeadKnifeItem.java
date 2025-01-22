
package net.mcreator.mountainspoem.item;

import net.mcreator.mountainspoem.procedures.WoodenRingHeadKnifeShiTiHuiDongWuPinShiProcedure;
import net.mcreator.mountainspoem.procedures.WoodenRingHeadKnifeShiTiBeiGongJuJiZhongShiProcedure;
import net.mcreator.mountainspoem.procedures.RingHead1Procedure;

public class WoodenRingHeadKnifeItem extends SwordItem {
	public WoodenRingHeadKnifeItem() {
		super(new Tier() {
			public int getUses() {
				return 120;
			}

			public float getSpeed() {
				return 4f;
			}

			public float getAttackDamageBonus() {
				return 3f;
			}

			public int getLevel() {
				return 1;
			}

			public int getEnchantmentValue() {
				return 15;
			}

			public Ingredient getRepairIngredient() {
				return Ingredient.of(ItemTags.create(new ResourceLocation("minecraft:planks")));
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
	public boolean onEntitySwing(ItemStack itemstack, LivingEntity entity) {
		boolean retval = super.onEntitySwing(itemstack, entity);
		WoodenRingHeadKnifeShiTiHuiDongWuPinShiProcedure.execute(entity.level(), entity.getX(), entity.getY(), entity.getZ());
		return retval;
	}

	@Override
	public void inventoryTick(ItemStack itemstack, Level world, Entity entity, int slot, boolean selected) {
		super.inventoryTick(itemstack, world, entity, slot, selected);
		RingHead1Procedure.execute(entity);
	}
}
