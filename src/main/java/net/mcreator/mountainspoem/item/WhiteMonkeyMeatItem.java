
package net.mcreator.mountainspoem.item;

import net.mcreator.mountainspoem.procedures.WhiteMonkeyMeatWuPinZaiBeiBaoZhongShiMeiKeFaShengProcedure;

public class WhiteMonkeyMeatItem extends Item {
	public WhiteMonkeyMeatItem() {
		super(new Item.Properties().stacksTo(64).rarity(Rarity.COMMON).food((new FoodProperties.Builder()).nutrition(4).saturationMod(1.3f).meat().build()));
	}

	@Override
	public void inventoryTick(ItemStack itemstack, Level world, Entity entity, int slot, boolean selected) {
		super.inventoryTick(itemstack, world, entity, slot, selected);
		WhiteMonkeyMeatWuPinZaiBeiBaoZhongShiMeiKeFaShengProcedure.execute(entity);
	}
}
