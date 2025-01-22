
package net.mcreator.mountainspoem.item;

import net.mcreator.mountainspoem.procedures.ConcoctedChangfuProcedure;

public class ConcoctedChangfuChickenItem extends Item {
	public ConcoctedChangfuChickenItem() {
		super(new Item.Properties().stacksTo(64).rarity(Rarity.COMMON).food((new FoodProperties.Builder()).nutrition(16).saturationMod(3f).build()));
	}

	@Override
	public ItemStack finishUsingItem(ItemStack itemstack, Level world, LivingEntity entity) {
		ItemStack retval = super.finishUsingItem(itemstack, world, entity);
		double x = entity.getX();
		double y = entity.getY();
		double z = entity.getZ();
		ConcoctedChangfuProcedure.execute(entity);
		return retval;
	}
}
