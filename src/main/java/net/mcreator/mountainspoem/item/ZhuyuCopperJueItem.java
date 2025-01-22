
package net.mcreator.mountainspoem.item;

import net.mcreator.mountainspoem.procedures.ZhuyuGrassJuiceWanJiaWanChengShiYongWuPinShiProcedure;
import net.mcreator.mountainspoem.init.MountainsPoemModItems;

public class ZhuyuCopperJueItem extends Item {
	public ZhuyuCopperJueItem() {
		super(new Item.Properties().stacksTo(1).rarity(Rarity.COMMON).food((new FoodProperties.Builder()).nutrition(8).saturationMod(3f).alwaysEat().build()));
	}

	@Override
	public UseAnim getUseAnimation(ItemStack itemstack) {
		return UseAnim.DRINK;
	}

	@Override
	public ItemStack finishUsingItem(ItemStack itemstack, Level world, LivingEntity entity) {
		ItemStack retval = new ItemStack(MountainsPoemModItems.COPPER_JUE.get());
		super.finishUsingItem(itemstack, world, entity);
		double x = entity.getX();
		double y = entity.getY();
		double z = entity.getZ();
		ZhuyuGrassJuiceWanJiaWanChengShiYongWuPinShiProcedure.execute(entity);
		if (itemstack.isEmpty()) {
			return retval;
		} else {
			if (entity instanceof Player player && !player.getAbilities().instabuild) {
				if (!player.getInventory().add(retval))
					player.drop(retval, false);
			}
			return itemstack;
		}
	}
}
