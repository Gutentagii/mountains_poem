
package net.mcreator.mountainspoem.item;

import net.mcreator.mountainspoem.procedures.GingerGetRecipeProcedure;

public class GingerItem extends Item {
	public GingerItem() {
		super(new Item.Properties().stacksTo(64).rarity(Rarity.COMMON).food((new FoodProperties.Builder()).nutrition(3).saturationMod(0.3f).build()));
	}

	@Override
	public void inventoryTick(ItemStack itemstack, Level world, Entity entity, int slot, boolean selected) {
		super.inventoryTick(itemstack, world, entity, slot, selected);
		GingerGetRecipeProcedure.execute(entity);
	}
}
