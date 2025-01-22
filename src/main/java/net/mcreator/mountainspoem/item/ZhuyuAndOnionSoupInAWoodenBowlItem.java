
package net.mcreator.mountainspoem.item;

import net.mcreator.mountainspoem.procedures.ZhuyuAndOnionSoupInAWoodenBowlWanJiaWanChengShiYongWuPinShiProcedure;

public class ZhuyuAndOnionSoupInAWoodenBowlItem extends Item {
	public ZhuyuAndOnionSoupInAWoodenBowlItem() {
		super(new Item.Properties().stacksTo(1).rarity(Rarity.COMMON).food((new FoodProperties.Builder()).nutrition(20).saturationMod(20f).alwaysEat().build()));
	}

	@Override
	public ItemStack finishUsingItem(ItemStack itemstack, Level world, LivingEntity entity) {
		ItemStack retval = new ItemStack(Items.BOWL);
		super.finishUsingItem(itemstack, world, entity);
		double x = entity.getX();
		double y = entity.getY();
		double z = entity.getZ();
		ZhuyuAndOnionSoupInAWoodenBowlWanJiaWanChengShiYongWuPinShiProcedure.execute(entity);
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
