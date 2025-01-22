
package net.mcreator.mountainspoem.item;

import net.mcreator.mountainspoem.procedures.GarlicGetRecipeProcedure;

public class GarlicClovesItem extends Item {
	public GarlicClovesItem() {
		super(new Item.Properties().stacksTo(64).rarity(Rarity.COMMON).food((new FoodProperties.Builder()).nutrition(1).saturationMod(0.3f).build()));
	}

	@Override
	public int getUseDuration(ItemStack itemstack) {
		return 28;
	}

	@Override
	public void inventoryTick(ItemStack itemstack, Level world, Entity entity, int slot, boolean selected) {
		super.inventoryTick(itemstack, world, entity, slot, selected);
		GarlicGetRecipeProcedure.execute(entity);
	}
}
