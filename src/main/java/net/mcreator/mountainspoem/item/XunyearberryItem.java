
package net.mcreator.mountainspoem.item;

import net.mcreator.mountainspoem.procedures.XunyearberryYouJiFangKuaiShiFangKuaiDeWeiZhiProcedure;
import net.mcreator.mountainspoem.procedures.XunyearberryWuPinZaiBeiBaoZhongShiMeiKeFaShengProcedure;

public class XunyearberryItem extends Item {
	public XunyearberryItem() {
		super(new Item.Properties().stacksTo(64).rarity(Rarity.COMMON).food((new FoodProperties.Builder()).nutrition(3).saturationMod(0.3f).build()));
	}

	@Override
	public InteractionResult useOn(UseOnContext context) {
		super.useOn(context);
		XunyearberryYouJiFangKuaiShiFangKuaiDeWeiZhiProcedure.execute(context.getLevel(), context.getClickedPos().getX(), context.getClickedPos().getY(), context.getClickedPos().getZ(), context.getPlayer(), context.getItemInHand());
		return InteractionResult.SUCCESS;
	}

	@Override
	public void inventoryTick(ItemStack itemstack, Level world, Entity entity, int slot, boolean selected) {
		super.inventoryTick(itemstack, world, entity, slot, selected);
		XunyearberryWuPinZaiBeiBaoZhongShiMeiKeFaShengProcedure.execute(entity);
	}
}
