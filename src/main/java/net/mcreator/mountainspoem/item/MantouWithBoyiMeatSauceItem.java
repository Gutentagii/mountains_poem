
package net.mcreator.mountainspoem.item;

import net.mcreator.mountainspoem.procedures.MantouWithLeiMeatSauceWanJiaWanChengShiYongWuPinShiProcedure;

public class MantouWithBoyiMeatSauceItem extends Item {
	public MantouWithBoyiMeatSauceItem() {
		super(new Item.Properties().stacksTo(64).rarity(Rarity.COMMON).food((new FoodProperties.Builder()).nutrition(7).saturationMod(0.9f).meat().build()));
	}

	@Override
	public ItemStack finishUsingItem(ItemStack itemstack, Level world, LivingEntity entity) {
		ItemStack retval = super.finishUsingItem(itemstack, world, entity);
		double x = entity.getX();
		double y = entity.getY();
		double z = entity.getZ();
		MantouWithLeiMeatSauceWanJiaWanChengShiYongWuPinShiProcedure.execute(entity);
		return retval;
	}
}
