
package net.mcreator.mountainspoem.item;

import net.mcreator.mountainspoem.procedures.HunMeatWuPinZaiBeiBaoZhongShiMeiKeFaShengProcedure;

public class HunMeatItem extends Item {
	public HunMeatItem() {
		super(new Item.Properties().stacksTo(64).rarity(Rarity.COMMON).food((new FoodProperties.Builder()).nutrition(4).saturationMod(1f).meat().build()));
	}

	@Override
	public int getUseDuration(ItemStack itemstack) {
		return 28;
	}

	@Override
	public void inventoryTick(ItemStack itemstack, Level world, Entity entity, int slot, boolean selected) {
		super.inventoryTick(itemstack, world, entity, slot, selected);
		HunMeatWuPinZaiBeiBaoZhongShiMeiKeFaShengProcedure.execute(entity);
	}
}
