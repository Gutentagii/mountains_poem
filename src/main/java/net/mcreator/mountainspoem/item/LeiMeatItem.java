
package net.mcreator.mountainspoem.item;

import net.mcreator.mountainspoem.procedures.LeiMeatWuPinZaiBeiBaoZhongShiMeiKeFaShengProcedure;

public class LeiMeatItem extends Item {
	public LeiMeatItem() {
		super(new Item.Properties().stacksTo(64).rarity(Rarity.COMMON).food((new FoodProperties.Builder()).nutrition(3).saturationMod(0.8f).meat().build()));
	}

	@Override
	public int getUseDuration(ItemStack itemstack) {
		return 28;
	}

	@Override
	public void inventoryTick(ItemStack itemstack, Level world, Entity entity, int slot, boolean selected) {
		super.inventoryTick(itemstack, world, entity, slot, selected);
		LeiMeatWuPinZaiBeiBaoZhongShiMeiKeFaShengProcedure.execute(entity);
	}
}
