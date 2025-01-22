
package net.mcreator.mountainspoem.item;

import net.mcreator.mountainspoem.procedures.XuanscaleWuPinZaiBeiBaoZhongShiMeiKeFaShengProcedure;
import net.mcreator.mountainspoem.procedures.XuanscaleItemInBagProcedure;

public class XuanscaleItem extends Item {
	public XuanscaleItem() {
		super(new Item.Properties().stacksTo(64).rarity(Rarity.UNCOMMON));
	}

	@Override
	public void inventoryTick(ItemStack itemstack, Level world, Entity entity, int slot, boolean selected) {
		super.inventoryTick(itemstack, world, entity, slot, selected);
		if (selected)
			XuanscaleWuPinZaiBeiBaoZhongShiMeiKeFaShengProcedure.execute(entity);
		XuanscaleItemInBagProcedure.execute(entity);
	}
}
