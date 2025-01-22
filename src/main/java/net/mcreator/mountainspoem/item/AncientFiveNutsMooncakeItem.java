
package net.mcreator.mountainspoem.item;

import net.mcreator.mountainspoem.procedures.BakedMooncakeB6Procedure;
import net.mcreator.mountainspoem.procedures.BakedMooncakeA6Procedure;

public class AncientFiveNutsMooncakeItem extends Item {
	public AncientFiveNutsMooncakeItem() {
		super(new Item.Properties().stacksTo(16).rarity(Rarity.COMMON).food((new FoodProperties.Builder()).nutrition(10).saturationMod(0.5f).alwaysEat().build()));
	}

	@Override
	public ItemStack finishUsingItem(ItemStack itemstack, Level world, LivingEntity entity) {
		ItemStack retval = super.finishUsingItem(itemstack, world, entity);
		double x = entity.getX();
		double y = entity.getY();
		double z = entity.getZ();
		BakedMooncakeB6Procedure.execute(entity);
		return retval;
	}

	@Override
	public void inventoryTick(ItemStack itemstack, Level world, Entity entity, int slot, boolean selected) {
		super.inventoryTick(itemstack, world, entity, slot, selected);
		BakedMooncakeA6Procedure.execute(entity);
	}
}
