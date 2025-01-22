
package net.mcreator.mountainspoem.item;

import net.mcreator.mountainspoem.procedures.MantouSoakedInMuttonSoupWuPinZaiBeiBaoZhongShiMeiKeFaShengProcedure;
import net.mcreator.mountainspoem.procedures.MantouSoakedInMuttonSoupWanJiaWanChengShiYongWuPinShiProcedure;

public class MantouSoakedInMuttonSoupItem extends Item {
	public MantouSoakedInMuttonSoupItem() {
		super(new Item.Properties().stacksTo(1).rarity(Rarity.COMMON).food((new FoodProperties.Builder()).nutrition(12).saturationMod(2.5f).build()));
	}

	@Override
	public ItemStack finishUsingItem(ItemStack itemstack, Level world, LivingEntity entity) {
		ItemStack retval = new ItemStack(Items.BOWL);
		super.finishUsingItem(itemstack, world, entity);
		double x = entity.getX();
		double y = entity.getY();
		double z = entity.getZ();
		MantouSoakedInMuttonSoupWanJiaWanChengShiYongWuPinShiProcedure.execute(entity);
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
		MantouSoakedInMuttonSoupWuPinZaiBeiBaoZhongShiMeiKeFaShengProcedure.execute(entity);
	}
}
