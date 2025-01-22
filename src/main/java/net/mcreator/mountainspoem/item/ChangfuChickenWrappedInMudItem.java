
package net.mcreator.mountainspoem.item;

import net.mcreator.mountainspoem.procedures.GetChangfuChickenInBurntMudRecipeProcedure;
import net.mcreator.mountainspoem.procedures.ChangfuChickenInMudProcedure;

public class ChangfuChickenWrappedInMudItem extends Item {
	public ChangfuChickenWrappedInMudItem() {
		super(new Item.Properties().stacksTo(64).rarity(Rarity.COMMON).food((new FoodProperties.Builder()).nutrition(3).saturationMod(0.3f).build()));
	}

	@Override
	public ItemStack finishUsingItem(ItemStack itemstack, Level world, LivingEntity entity) {
		ItemStack retval = super.finishUsingItem(itemstack, world, entity);
		double x = entity.getX();
		double y = entity.getY();
		double z = entity.getZ();
		ChangfuChickenInMudProcedure.execute(entity);
		return retval;
	}

	@Override
	public boolean onEntitySwing(ItemStack itemstack, LivingEntity entity) {
		boolean retval = super.onEntitySwing(itemstack, entity);
		GetChangfuChickenInBurntMudRecipeProcedure.execute(entity);
		return retval;
	}
}
