
package net.mcreator.mountainspoem.item;

import net.mcreator.mountainspoem.procedures.JinyuJadeWuPinZaiShouShangShiMeiKeFaShengProcedure;

public class JinyuJadeItem extends Item {
	public JinyuJadeItem() {
		super(new Item.Properties().stacksTo(64).rarity(Rarity.RARE).food((new FoodProperties.Builder()).nutrition(4).saturationMod(4f).alwaysEat().build()));
	}

	@Override
	public void inventoryTick(ItemStack itemstack, Level world, Entity entity, int slot, boolean selected) {
		super.inventoryTick(itemstack, world, entity, slot, selected);
		if (selected)
			JinyuJadeWuPinZaiShouShangShiMeiKeFaShengProcedure.execute(entity);
	}
}
