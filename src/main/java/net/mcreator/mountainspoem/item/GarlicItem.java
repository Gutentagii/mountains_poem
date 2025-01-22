
package net.mcreator.mountainspoem.item;

import net.mcreator.mountainspoem.procedures.GarlicGetRecipeProcedure;

public class GarlicItem extends Item {
	public GarlicItem() {
		super(new Item.Properties().stacksTo(64).rarity(Rarity.COMMON).food((new FoodProperties.Builder()).nutrition(3).saturationMod(0.9f).build()));
	}

	@Override
	public void inventoryTick(ItemStack itemstack, Level world, Entity entity, int slot, boolean selected) {
		super.inventoryTick(itemstack, world, entity, slot, selected);
		GarlicGetRecipeProcedure.execute(entity);
	}
}
