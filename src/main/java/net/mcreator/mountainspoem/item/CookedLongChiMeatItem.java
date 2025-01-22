
package net.mcreator.mountainspoem.item;

import net.mcreator.mountainspoem.procedures.LongChiMeatWuPinZaiBeiBaoZhongShiMeiKeFaShengProcedure;
import net.mcreator.mountainspoem.procedures.LongChiMeatWanJiaWanChengShiYongWuPinShiProcedure;

public class CookedLongChiMeatItem extends Item {
	public CookedLongChiMeatItem() {
		super(new Item.Properties().stacksTo(64).rarity(Rarity.COMMON).food((new FoodProperties.Builder()).nutrition(3).saturationMod(1.2f).meat().build()));
	}

	@Override
	public ItemStack finishUsingItem(ItemStack itemstack, Level world, LivingEntity entity) {
		ItemStack retval = super.finishUsingItem(itemstack, world, entity);
		double x = entity.getX();
		double y = entity.getY();
		double z = entity.getZ();
		LongChiMeatWanJiaWanChengShiYongWuPinShiProcedure.execute(entity);
		return retval;
	}

	@Override
	public void inventoryTick(ItemStack itemstack, Level world, Entity entity, int slot, boolean selected) {
		super.inventoryTick(itemstack, world, entity, slot, selected);
		LongChiMeatWuPinZaiBeiBaoZhongShiMeiKeFaShengProcedure.execute(entity);
	}
}
