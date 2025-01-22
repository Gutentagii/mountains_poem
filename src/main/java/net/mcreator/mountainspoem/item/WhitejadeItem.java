
package net.mcreator.mountainspoem.item;

import net.mcreator.mountainspoem.procedures.WhitejadeWuPinZaiBeiBaoZhongShiMeiKeFaShengProcedure;

public class WhitejadeItem extends Item {
	public WhitejadeItem() {
		super(new Item.Properties().stacksTo(64).rarity(Rarity.COMMON));
	}

	@Override
	public void inventoryTick(ItemStack itemstack, Level world, Entity entity, int slot, boolean selected) {
		super.inventoryTick(itemstack, world, entity, slot, selected);
		WhitejadeWuPinZaiBeiBaoZhongShiMeiKeFaShengProcedure.execute(entity);
	}
}
