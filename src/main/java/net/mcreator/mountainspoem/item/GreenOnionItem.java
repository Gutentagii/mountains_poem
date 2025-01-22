
package net.mcreator.mountainspoem.item;

import net.mcreator.mountainspoem.procedures.GreenOnionWuPinZaiBeiBaoZhongShiMeiKeFaShengProcedure;

public class GreenOnionItem extends Item {
	public GreenOnionItem() {
		super(new Item.Properties().stacksTo(64).rarity(Rarity.COMMON).food((new FoodProperties.Builder()).nutrition(3).saturationMod(0.6f).build()));
	}

	@Override
	public void inventoryTick(ItemStack itemstack, Level world, Entity entity, int slot, boolean selected) {
		super.inventoryTick(itemstack, world, entity, slot, selected);
		GreenOnionWuPinZaiBeiBaoZhongShiMeiKeFaShengProcedure.execute(entity);
	}
}
