
package net.mcreator.mountainspoem.item;

import net.mcreator.mountainspoem.procedures.CopperJueYouJiFangKuaiShiFangKuaiDeWeiZhiProcedure;

public class CopperJueItem extends Item {
	public CopperJueItem() {
		super(new Item.Properties().stacksTo(64).rarity(Rarity.COMMON));
	}

	@Override
	public InteractionResultHolder<ItemStack> use(Level world, Player entity, InteractionHand hand) {
		InteractionResultHolder<ItemStack> ar = super.use(world, entity, hand);
		CopperJueYouJiFangKuaiShiFangKuaiDeWeiZhiProcedure.execute(world, entity.getX(), entity.getY(), entity.getZ(), entity, ar.getObject());
		return ar;
	}

	@Override
	public InteractionResult useOn(UseOnContext context) {
		super.useOn(context);
		CopperJueYouJiFangKuaiShiFangKuaiDeWeiZhiProcedure.execute(context.getLevel(), context.getClickedPos().getX(), context.getClickedPos().getY(), context.getClickedPos().getZ(), context.getPlayer(), context.getItemInHand());
		return InteractionResult.SUCCESS;
	}
}
