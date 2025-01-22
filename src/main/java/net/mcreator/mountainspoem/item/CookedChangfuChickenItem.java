
package net.mcreator.mountainspoem.item;

import net.mcreator.mountainspoem.procedures.CookedChangfuChickenWuPinZaiBeiBaoZhongShiMeiKeFaShengProcedure;
import net.mcreator.mountainspoem.procedures.ChangfuChickenWanJiaWanChengShiYongWuPinShiProcedure;

public class CookedChangfuChickenItem extends Item {
	public CookedChangfuChickenItem() {
		super(new Item.Properties().stacksTo(64).rarity(Rarity.COMMON).food((new FoodProperties.Builder()).nutrition(3).saturationMod(1f).meat().build()));
	}

	@Override
	public int getUseDuration(ItemStack itemstack) {
		return 28;
	}

	@Override
	public ItemStack finishUsingItem(ItemStack itemstack, Level world, LivingEntity entity) {
		ItemStack retval = super.finishUsingItem(itemstack, world, entity);
		double x = entity.getX();
		double y = entity.getY();
		double z = entity.getZ();
		ChangfuChickenWanJiaWanChengShiYongWuPinShiProcedure.execute(entity);
		return retval;
	}

	@Override
	public void inventoryTick(ItemStack itemstack, Level world, Entity entity, int slot, boolean selected) {
		super.inventoryTick(itemstack, world, entity, slot, selected);
		CookedChangfuChickenWuPinZaiBeiBaoZhongShiMeiKeFaShengProcedure.execute(entity);
	}
}
