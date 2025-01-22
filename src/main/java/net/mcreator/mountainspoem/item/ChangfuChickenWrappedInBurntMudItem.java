
package net.mcreator.mountainspoem.item;

import net.mcreator.mountainspoem.procedures.ChangfuChickenInBurntMudProcedure;

public class ChangfuChickenWrappedInBurntMudItem extends Item {
	public ChangfuChickenWrappedInBurntMudItem() {
		super(new Item.Properties().stacksTo(64).rarity(Rarity.COMMON).food((new FoodProperties.Builder()).nutrition(5).saturationMod(2f).build()));
	}

	@Override
	public ItemStack finishUsingItem(ItemStack itemstack, Level world, LivingEntity entity) {
		ItemStack retval = super.finishUsingItem(itemstack, world, entity);
		double x = entity.getX();
		double y = entity.getY();
		double z = entity.getZ();
		ChangfuChickenInBurntMudProcedure.execute(entity);
		return retval;
	}
}
