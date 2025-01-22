
package net.mcreator.mountainspoem.item;

import net.mcreator.mountainspoem.procedures.IcyFangsWuPinZaiBeiBaoZhongShiMeiKeFaShengProcedure;

public class IcyFangsItem extends Item {
	public IcyFangsItem() {
		super(new Item.Properties().stacksTo(64).rarity(Rarity.UNCOMMON));
	}

	@Override
	public void inventoryTick(ItemStack itemstack, Level world, Entity entity, int slot, boolean selected) {
		super.inventoryTick(itemstack, world, entity, slot, selected);
		IcyFangsWuPinZaiBeiBaoZhongShiMeiKeFaShengProcedure.execute(entity);
	}
}
