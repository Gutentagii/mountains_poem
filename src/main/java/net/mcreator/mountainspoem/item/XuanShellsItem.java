
package net.mcreator.mountainspoem.item;

import net.mcreator.mountainspoem.procedures.XuanShellsWuPinZaiBeiBaoZhongShiMeiKeFaShengProcedure;

public class XuanShellsItem extends Item {
	public XuanShellsItem() {
		super(new Item.Properties().stacksTo(64).rarity(Rarity.UNCOMMON));
	}

	@Override
	public void inventoryTick(ItemStack itemstack, Level world, Entity entity, int slot, boolean selected) {
		super.inventoryTick(itemstack, world, entity, slot, selected);
		XuanShellsWuPinZaiBeiBaoZhongShiMeiKeFaShengProcedure.execute(entity);
	}
}
