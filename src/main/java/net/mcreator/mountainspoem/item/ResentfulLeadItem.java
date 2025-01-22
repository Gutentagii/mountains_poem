
package net.mcreator.mountainspoem.item;

import net.mcreator.mountainspoem.procedures.ResentfulLeadShiTiHuiDongWuPinShiProcedure;

public class ResentfulLeadItem extends Item {
	public ResentfulLeadItem() {
		super(new Item.Properties().stacksTo(64).rarity(Rarity.COMMON));
	}

	@Override
	public boolean onEntitySwing(ItemStack itemstack, LivingEntity entity) {
		boolean retval = super.onEntitySwing(itemstack, entity);
		ResentfulLeadShiTiHuiDongWuPinShiProcedure.execute(entity, itemstack);
		return retval;
	}
}
