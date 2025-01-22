
package net.mcreator.mountainspoem.item;

import net.mcreator.mountainspoem.procedures.RawLufishWanJiaWanChengShiYongWuPinShiProcedure;

public class CookedLufishItem extends Item {
	public CookedLufishItem() {
		super(new Item.Properties().stacksTo(64).rarity(Rarity.COMMON).food((new FoodProperties.Builder()).nutrition(4).saturationMod(1.5f).meat().build()));
	}

	@Override
	public ItemStack finishUsingItem(ItemStack itemstack, Level world, LivingEntity entity) {
		ItemStack retval = super.finishUsingItem(itemstack, world, entity);
		double x = entity.getX();
		double y = entity.getY();
		double z = entity.getZ();
		RawLufishWanJiaWanChengShiYongWuPinShiProcedure.execute(entity);
		return retval;
	}
}
