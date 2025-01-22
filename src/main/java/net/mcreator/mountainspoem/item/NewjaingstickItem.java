
package net.mcreator.mountainspoem.item;

import net.mcreator.mountainspoem.procedures.ZhiZuoJiShiTiShiProcedure;

public class NewjaingstickItem extends Item {
	public NewjaingstickItem() {
		super(new Item.Properties().stacksTo(64).rarity(Rarity.COMMON));
	}

	@Override
	public boolean hurtEnemy(ItemStack itemstack, LivingEntity entity, LivingEntity sourceentity) {
		boolean retval = super.hurtEnemy(itemstack, entity, sourceentity);
		ZhiZuoJiShiTiShiProcedure.execute(entity);
		return retval;
	}
}
