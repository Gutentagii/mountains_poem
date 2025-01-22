
package net.mcreator.mountainspoem.item;

import net.mcreator.mountainspoem.procedures.MantouWithMeatWuPingZaiWuPingLanShiProcedure;

public class MantouWithMeatItem extends Item {
	public MantouWithMeatItem() {
		super(new Item.Properties().stacksTo(64).rarity(Rarity.COMMON).food((new FoodProperties.Builder()).nutrition(5).saturationMod(0.8f).alwaysEat().build()));
	}

	@Override
	public void inventoryTick(ItemStack itemstack, Level world, Entity entity, int slot, boolean selected) {
		super.inventoryTick(itemstack, world, entity, slot, selected);
		MantouWithMeatWuPingZaiWuPingLanShiProcedure.execute(entity);
	}
}
