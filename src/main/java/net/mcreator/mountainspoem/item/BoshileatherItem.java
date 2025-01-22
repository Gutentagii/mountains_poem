
package net.mcreator.mountainspoem.item;

import net.mcreator.mountainspoem.procedures.BoshileatherWuPinZaiBeiBaoZhongShiMeiKeFaShengProcedure;
import net.mcreator.mountainspoem.procedures.BoshiBlessingXiaoGuoChiXuShiMeiKeFaShengProcedure;

public class BoshileatherItem extends Item {
	public BoshileatherItem() {
		super(new Item.Properties().stacksTo(64).rarity(Rarity.UNCOMMON));
	}

	@Override
	public void inventoryTick(ItemStack itemstack, Level world, Entity entity, int slot, boolean selected) {
		super.inventoryTick(itemstack, world, entity, slot, selected);
		if (selected)
			BoshiBlessingXiaoGuoChiXuShiMeiKeFaShengProcedure.execute(entity);
		BoshileatherWuPinZaiBeiBaoZhongShiMeiKeFaShengProcedure.execute(entity);
	}
}
