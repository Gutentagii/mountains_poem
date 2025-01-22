
package net.mcreator.mountainspoem.item;

import net.mcreator.mountainspoem.procedures.ColdCrimsonFungusSaladWuPinZaiBeiBaoZhongShiMeiKeFaShengProcedure;
import net.mcreator.mountainspoem.procedures.ColdCrimsonFungusSaladWanJiaWanChengShiYongWuPinShiProcedure;

public class ColdCrimsonFungusSaladItem extends Item {
	public ColdCrimsonFungusSaladItem() {
		super(new Item.Properties().stacksTo(16).rarity(Rarity.COMMON).food((new FoodProperties.Builder()).nutrition(4).saturationMod(0.4f).build()));
	}

	@Override
	public ItemStack finishUsingItem(ItemStack itemstack, Level world, LivingEntity entity) {
		ItemStack retval = super.finishUsingItem(itemstack, world, entity);
		double x = entity.getX();
		double y = entity.getY();
		double z = entity.getZ();
		ColdCrimsonFungusSaladWanJiaWanChengShiYongWuPinShiProcedure.execute(entity);
		return retval;
	}

	@Override
	public void inventoryTick(ItemStack itemstack, Level world, Entity entity, int slot, boolean selected) {
		super.inventoryTick(itemstack, world, entity, slot, selected);
		ColdCrimsonFungusSaladWuPinZaiBeiBaoZhongShiMeiKeFaShengProcedure.execute(entity);
	}
}
