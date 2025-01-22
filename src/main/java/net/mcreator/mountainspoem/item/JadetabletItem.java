
package net.mcreator.mountainspoem.item;

import net.mcreator.mountainspoem.procedures.JadetabletWuPinZaiBeiBaoZhongShiMeiKeFaShengProcedure;
import net.mcreator.mountainspoem.procedures.JadetabletShiTiHuiDongWuPinShiProcedure;

public class JadetabletItem extends Item {
	public JadetabletItem() {
		super(new Item.Properties().durability(20).rarity(Rarity.UNCOMMON));
	}

	@Override
	public boolean onEntitySwing(ItemStack itemstack, LivingEntity entity) {
		boolean retval = super.onEntitySwing(itemstack, entity);
		JadetabletShiTiHuiDongWuPinShiProcedure.execute(entity.level(), entity.getX(), entity.getY(), entity.getZ(), entity);
		return retval;
	}

	@Override
	public void inventoryTick(ItemStack itemstack, Level world, Entity entity, int slot, boolean selected) {
		super.inventoryTick(itemstack, world, entity, slot, selected);
		if (selected)
			JadetabletWuPinZaiBeiBaoZhongShiMeiKeFaShengProcedure.execute(entity, itemstack);
		JadetabletWuPinZaiBeiBaoZhongShiMeiKeFaShengProcedure.execute(entity, itemstack);
	}
}
