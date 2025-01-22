
package net.mcreator.mountainspoem.item;

import net.mcreator.mountainspoem.procedures.RawBoshiLegWuPinZaiBeiBaoZhongShiMeiKeFaShengProcedure;

public class RawBoshiLegItem extends Item {
	public RawBoshiLegItem() {
		super(new Item.Properties().stacksTo(64).rarity(Rarity.COMMON).food((new FoodProperties.Builder()).nutrition(5).saturationMod(0.5f).meat().build()));
	}

	@Override
	public void inventoryTick(ItemStack itemstack, Level world, Entity entity, int slot, boolean selected) {
		super.inventoryTick(itemstack, world, entity, slot, selected);
		RawBoshiLegWuPinZaiBeiBaoZhongShiMeiKeFaShengProcedure.execute(entity);
	}
}
