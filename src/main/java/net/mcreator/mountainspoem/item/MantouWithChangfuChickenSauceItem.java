
package net.mcreator.mountainspoem.item;

import net.mcreator.mountainspoem.procedures.FoodWithChangfuProcedure;

public class MantouWithChangfuChickenSauceItem extends Item {
	public MantouWithChangfuChickenSauceItem() {
		super(new Item.Properties().stacksTo(64).rarity(Rarity.COMMON).food((new FoodProperties.Builder()).nutrition(5).saturationMod(1.4f).alwaysEat().build()));
	}

	@Override
	public ItemStack finishUsingItem(ItemStack itemstack, Level world, LivingEntity entity) {
		ItemStack retval = super.finishUsingItem(itemstack, world, entity);
		double x = entity.getX();
		double y = entity.getY();
		double z = entity.getZ();
		FoodWithChangfuProcedure.execute(entity);
		return retval;
	}
}
