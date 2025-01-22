
package net.mcreator.mountainspoem.item;

import net.mcreator.mountainspoem.procedures.LeiMeatSauceYouJiFangKuaiShiFangKuaiDeWeiZhiProcedure;
import net.mcreator.mountainspoem.init.MountainsPoemModBlocks;

public class LeiMeatSauceItem extends Item {
	public LeiMeatSauceItem() {
		super(new Item.Properties().stacksTo(1).rarity(Rarity.COMMON).food((new FoodProperties.Builder()).nutrition(13).saturationMod(4f).meat().build()));
	}

	@Override
	public ItemStack finishUsingItem(ItemStack itemstack, Level world, LivingEntity entity) {
		ItemStack retval = new ItemStack(MountainsPoemModBlocks.COPPER_DOU.get());
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
	public InteractionResult useOn(UseOnContext context) {
		super.useOn(context);
		LeiMeatSauceYouJiFangKuaiShiFangKuaiDeWeiZhiProcedure.execute(context.getLevel(), context.getClickedPos().getX(), context.getClickedPos().getY(), context.getClickedPos().getZ(), context.getPlayer(), context.getItemInHand());
		return InteractionResult.SUCCESS;
	}
}
