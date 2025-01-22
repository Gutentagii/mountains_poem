
package net.mcreator.mountainspoem.item;

import net.mcreator.mountainspoem.procedures.GoldenXunLeavesBerriesWanJiaWanChengShiYongWuPinShiProcedure;

public class GoldenXunLeavesBerriesItem extends Item {
	public GoldenXunLeavesBerriesItem() {
		super(new Item.Properties().stacksTo(64).rarity(Rarity.RARE).food((new FoodProperties.Builder()).nutrition(5).saturationMod(1.2f).alwaysEat().build()));
	}

	@Override
	public ItemStack finishUsingItem(ItemStack itemstack, Level world, LivingEntity entity) {
		ItemStack retval = super.finishUsingItem(itemstack, world, entity);
		double x = entity.getX();
		double y = entity.getY();
		double z = entity.getZ();
		GoldenXunLeavesBerriesWanJiaWanChengShiYongWuPinShiProcedure.execute(entity);
		return retval;
	}
}
