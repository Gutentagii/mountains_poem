
package net.mcreator.mountainspoem.item;

import net.mcreator.mountainspoem.procedures.BakedMooncakeB11Procedure;
import net.mcreator.mountainspoem.procedures.BakedMooncakeA11Procedure;

public class ClassicSuperDarkCuisineMooncakeItem extends Item {
	public ClassicSuperDarkCuisineMooncakeItem() {
		super(new Item.Properties().stacksTo(16).rarity(Rarity.UNCOMMON).food((new FoodProperties.Builder()).nutrition(10).saturationMod(0.5f).alwaysEat().build()));
	}

	@Override
	public int getUseDuration(ItemStack itemstack) {
		return 64;
	}

	@Override
	public ItemStack finishUsingItem(ItemStack itemstack, Level world, LivingEntity entity) {
		ItemStack retval = new ItemStack(Items.SPIDER_EYE);
		super.finishUsingItem(itemstack, world, entity);
		double x = entity.getX();
		double y = entity.getY();
		double z = entity.getZ();
		BakedMooncakeB11Procedure.execute(entity);
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
		BakedMooncakeA11Procedure.execute(entity);
	}
}
