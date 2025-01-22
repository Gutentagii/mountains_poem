
package net.mcreator.mountainspoem.item;

import net.mcreator.mountainspoem.procedures.MilkCopperJueWanJiaWanChengShiYongWuPinShiProcedure;
import net.mcreator.mountainspoem.init.MountainsPoemModItems;

public class MilkCopperJueItem extends Item {
	public MilkCopperJueItem() {
		super(new Item.Properties().stacksTo(64).rarity(Rarity.COMMON).food((new FoodProperties.Builder()).nutrition(3).saturationMod(0.4f).alwaysEat().build()));
	}

	@Override
	public UseAnim getUseAnimation(ItemStack itemstack) {
		return UseAnim.DRINK;
	}

	@Override
	public boolean hasCraftingRemainingItem() {
		return true;
	}

	@Override
	public ItemStack getCraftingRemainingItem(ItemStack itemstack) {
		return new ItemStack(MountainsPoemModItems.COPPER_JUE.get());
	}

	@Override
	public ItemStack finishUsingItem(ItemStack itemstack, Level world, LivingEntity entity) {
		ItemStack retval = new ItemStack(MountainsPoemModItems.COPPER_JUE.get());
		super.finishUsingItem(itemstack, world, entity);
		double x = entity.getX();
		double y = entity.getY();
		double z = entity.getZ();
		MilkCopperJueWanJiaWanChengShiYongWuPinShiProcedure.execute(entity);
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
