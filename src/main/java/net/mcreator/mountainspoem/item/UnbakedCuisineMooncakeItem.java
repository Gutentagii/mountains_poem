
package net.mcreator.mountainspoem.item;

import net.mcreator.mountainspoem.procedures.BakedMooncakeB10Procedure;
import net.mcreator.mountainspoem.procedures.BakedMooncakeA10Procedure;

public class UnbakedCuisineMooncakeItem extends Item {
	public UnbakedCuisineMooncakeItem() {
		super(new Item.Properties().stacksTo(64).rarity(Rarity.COMMON).food((new FoodProperties.Builder()).nutrition(5).saturationMod(1f).alwaysEat().build()));
	}

	@Override
	public ItemStack finishUsingItem(ItemStack itemstack, Level world, LivingEntity entity) {
		ItemStack retval = super.finishUsingItem(itemstack, world, entity);
		double x = entity.getX();
		double y = entity.getY();
		double z = entity.getZ();
		BakedMooncakeB10Procedure.execute(entity);
		return retval;
	}

	@Override
	public void inventoryTick(ItemStack itemstack, Level world, Entity entity, int slot, boolean selected) {
		super.inventoryTick(itemstack, world, entity, slot, selected);
		BakedMooncakeA10Procedure.execute(entity);
	}
}
