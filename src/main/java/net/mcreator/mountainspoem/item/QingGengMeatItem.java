
package net.mcreator.mountainspoem.item;

import net.mcreator.mountainspoem.procedures.QingGengMeatWuPinZaiBeiBaoZhongShiMeiKeFaShengProcedure;

public class QingGengMeatItem extends Item {
	public QingGengMeatItem() {
		super(new Item.Properties().stacksTo(64).rarity(Rarity.COMMON).food((new FoodProperties.Builder()).nutrition(3).saturationMod(0.4f).meat().build()));
	}

	@Override
	public void inventoryTick(ItemStack itemstack, Level world, Entity entity, int slot, boolean selected) {
		super.inventoryTick(itemstack, world, entity, slot, selected);
		QingGengMeatWuPinZaiBeiBaoZhongShiMeiKeFaShengProcedure.execute(entity);
	}
}
