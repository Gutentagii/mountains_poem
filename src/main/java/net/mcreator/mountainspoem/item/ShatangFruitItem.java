
package net.mcreator.mountainspoem.item;

import net.mcreator.mountainspoem.procedures.ShatangFruitWanJiaWanChengShiYongWuPinShiProcedure;

public class ShatangFruitItem extends Item {
	public ShatangFruitItem() {
		super(new Item.Properties().stacksTo(64).rarity(Rarity.COMMON).food((new FoodProperties.Builder()).nutrition(3).saturationMod(0.8f).alwaysEat().build()));
	}

	@Override
	public int getUseDuration(ItemStack itemstack) {
		return 25;
	}

	@Override
	public ItemStack finishUsingItem(ItemStack itemstack, Level world, LivingEntity entity) {
		ItemStack retval = super.finishUsingItem(itemstack, world, entity);
		double x = entity.getX();
		double y = entity.getY();
		double z = entity.getZ();
		ShatangFruitWanJiaWanChengShiYongWuPinShiProcedure.execute(entity);
		return retval;
	}
}
