
package net.mcreator.mountainspoem.item;

import net.mcreator.mountainspoem.procedures.RawBoshiLegWuPinZaiBeiBaoZhongShiMeiKeFaShengProcedure;

public class CookedBoshiLegItem extends Item {
	public CookedBoshiLegItem() {
		super(new Item.Properties().stacksTo(64).rarity(Rarity.COMMON).food((new FoodProperties.Builder()).nutrition(12).saturationMod(0.6f).meat().build()));
	}

	@Override
	public void inventoryTick(ItemStack itemstack, Level world, Entity entity, int slot, boolean selected) {
		super.inventoryTick(itemstack, world, entity, slot, selected);
		RawBoshiLegWuPinZaiBeiBaoZhongShiMeiKeFaShengProcedure.execute(entity);
	}
}
