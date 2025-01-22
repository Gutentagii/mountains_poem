
package net.mcreator.mountainspoem.item;

import net.mcreator.mountainspoem.procedures.BakedMooncakeB9Procedure;
import net.mcreator.mountainspoem.procedures.BakedMooncakeA9Procedure;

public class EternalHeartMooncakeItem extends Item {
	public EternalHeartMooncakeItem() {
		super(new Item.Properties().stacksTo(16).rarity(Rarity.COMMON).food((new FoodProperties.Builder()).nutrition(10).saturationMod(5f).alwaysEat().build()));
	}

	@Override
	public ItemStack finishUsingItem(ItemStack itemstack, Level world, LivingEntity entity) {
		ItemStack retval = super.finishUsingItem(itemstack, world, entity);
		double x = entity.getX();
		double y = entity.getY();
		double z = entity.getZ();
		BakedMooncakeB9Procedure.execute(entity);
		return retval;
	}

	@Override
	public void inventoryTick(ItemStack itemstack, Level world, Entity entity, int slot, boolean selected) {
		super.inventoryTick(itemstack, world, entity, slot, selected);
		BakedMooncakeA9Procedure.execute(entity);
	}
}
