
package net.mcreator.mountainspoem.item;

import net.mcreator.mountainspoem.procedures.RedRuFishYouJiFangKuaiShiFangKuaiDeWeiZhiProcedure;

public class RedRuFishItem extends Item {
	public RedRuFishItem() {
		super(new Item.Properties().stacksTo(64).rarity(Rarity.COMMON).food((new FoodProperties.Builder()).nutrition(4).saturationMod(0.5f).meat().build()));
	}

	@Override
	public InteractionResult useOn(UseOnContext context) {
		super.useOn(context);
		RedRuFishYouJiFangKuaiShiFangKuaiDeWeiZhiProcedure.execute(context.getPlayer());
		return InteractionResult.SUCCESS;
	}
}
