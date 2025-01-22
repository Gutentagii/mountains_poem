
package net.mcreator.mountainspoem.item;

import net.mcreator.mountainspoem.procedures.PaperPulpBucketYouJiFangKuaiShiFangKuaiDeWeiZhiProcedure;

public class PaperPulpBucketItem extends Item {
	public PaperPulpBucketItem() {
		super(new Item.Properties().stacksTo(16).rarity(Rarity.COMMON));
	}

	@Override
	public InteractionResult useOn(UseOnContext context) {
		super.useOn(context);
		PaperPulpBucketYouJiFangKuaiShiFangKuaiDeWeiZhiProcedure.execute(context.getLevel(), context.getClickedPos().getX(), context.getClickedPos().getY(), context.getClickedPos().getZ(), context.getItemInHand());
		return InteractionResult.SUCCESS;
	}
}
