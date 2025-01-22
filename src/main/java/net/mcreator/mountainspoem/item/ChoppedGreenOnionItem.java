
package net.mcreator.mountainspoem.item;

import net.mcreator.mountainspoem.procedures.GreenOnionWuPinZaiBeiBaoZhongShiMeiKeFaShengProcedure;

public class ChoppedGreenOnionItem extends Item {
	public ChoppedGreenOnionItem() {
		super(new Item.Properties().stacksTo(64).rarity(Rarity.COMMON).food((new FoodProperties.Builder()).nutrition(1).saturationMod(0.2f).build()));
	}

	@Override
	public void inventoryTick(ItemStack itemstack, Level world, Entity entity, int slot, boolean selected) {
		super.inventoryTick(itemstack, world, entity, slot, selected);
		GreenOnionWuPinZaiBeiBaoZhongShiMeiKeFaShengProcedure.execute(entity);
	}
}
