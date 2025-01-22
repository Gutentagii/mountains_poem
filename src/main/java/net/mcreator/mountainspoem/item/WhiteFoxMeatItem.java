
package net.mcreator.mountainspoem.item;

import net.mcreator.mountainspoem.procedures.WhiteFoxMeatWuPinZaiBeiBaoZhongShiMeiKeFaShengProcedure;
import net.mcreator.mountainspoem.procedures.CookedFoxMeatWanJiaWanChengShiYongWuPinShiProcedure;

public class WhiteFoxMeatItem extends Item {
	public WhiteFoxMeatItem() {
		super(new Item.Properties().stacksTo(64).rarity(Rarity.UNCOMMON).food((new FoodProperties.Builder()).nutrition(4).saturationMod(1.1f).meat().build()));
	}

	@Override
	public ItemStack finishUsingItem(ItemStack itemstack, Level world, LivingEntity entity) {
		ItemStack retval = super.finishUsingItem(itemstack, world, entity);
		double x = entity.getX();
		double y = entity.getY();
		double z = entity.getZ();
		CookedFoxMeatWanJiaWanChengShiYongWuPinShiProcedure.execute(entity);
		return retval;
	}

	@Override
	public void inventoryTick(ItemStack itemstack, Level world, Entity entity, int slot, boolean selected) {
		super.inventoryTick(itemstack, world, entity, slot, selected);
		WhiteFoxMeatWuPinZaiBeiBaoZhongShiMeiKeFaShengProcedure.execute(entity);
	}
}
