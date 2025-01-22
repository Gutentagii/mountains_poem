
package net.mcreator.mountainspoem.item;

import net.mcreator.mountainspoem.procedures.ShatangFruitWanJiaWanChengShiYongWuPinShiProcedure;

public class ShatangFruitCookieItem extends Item {
	public ShatangFruitCookieItem() {
		super(new Item.Properties().stacksTo(64).rarity(Rarity.COMMON).food((new FoodProperties.Builder()).nutrition(5).saturationMod(0.4f).build()));
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
