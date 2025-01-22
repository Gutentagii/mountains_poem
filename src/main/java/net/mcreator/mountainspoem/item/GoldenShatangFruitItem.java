
package net.mcreator.mountainspoem.item;

import net.mcreator.mountainspoem.procedures.GoldenYanFruitWanJiaWanChengShiYongWuPinShiProcedure;

public class GoldenShatangFruitItem extends Item {
	public GoldenShatangFruitItem() {
		super(new Item.Properties().stacksTo(64).rarity(Rarity.UNCOMMON).food((new FoodProperties.Builder()).nutrition(6).saturationMod(1.2f).alwaysEat().build()));
	}

	@Override
	public int getUseDuration(ItemStack itemstack) {
		return 24;
	}

	@Override
	public ItemStack finishUsingItem(ItemStack itemstack, Level world, LivingEntity entity) {
		ItemStack retval = super.finishUsingItem(itemstack, world, entity);
		double x = entity.getX();
		double y = entity.getY();
		double z = entity.getZ();
		GoldenYanFruitWanJiaWanChengShiYongWuPinShiProcedure.execute(entity);
		return retval;
	}
}
