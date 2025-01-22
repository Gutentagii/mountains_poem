
package net.mcreator.mountainspoem.item;

import net.mcreator.mountainspoem.procedures.JufuHumerusWuPinZaiBeiBaoZhongShiMeiKeFaShengProcedure;
import net.mcreator.mountainspoem.init.MountainsPoemModItems;

public class JufuHumerusItem extends Item {
	public JufuHumerusItem() {
		super(new Item.Properties().stacksTo(64).rarity(Rarity.COMMON).food((new FoodProperties.Builder()).nutrition(1).saturationMod(1.1f).meat().build()));
	}

	@Override
	public int getUseDuration(ItemStack itemstack) {
		return 40;
	}

	@Override
	public ItemStack finishUsingItem(ItemStack itemstack, Level world, LivingEntity entity) {
		ItemStack retval = new ItemStack(MountainsPoemModItems.JUFU_HUMERUS.get());
		super.finishUsingItem(itemstack, world, entity);
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

	@Override
	public void inventoryTick(ItemStack itemstack, Level world, Entity entity, int slot, boolean selected) {
		super.inventoryTick(itemstack, world, entity, slot, selected);
		JufuHumerusWuPinZaiBeiBaoZhongShiMeiKeFaShengProcedure.execute(entity);
	}
}
