
package net.mcreator.mountainspoem.item;

import net.mcreator.mountainspoem.procedures.RongGrassssProcedure;
import net.mcreator.mountainspoem.procedures.PureedRongGrassTuberWuPinZaiBeiBaoZhongShiMeiKeFaShengProcedure;
import net.mcreator.mountainspoem.procedures.PureedRongGrassTuberWanJiaWanChengShiYongWuPinShiProcedure;

public class PureedRongGrassTuberItem extends Item {
	public PureedRongGrassTuberItem() {
		super(new Item.Properties().stacksTo(64).rarity(Rarity.COMMON).food((new FoodProperties.Builder()).nutrition(3).saturationMod(0.5f).build()));
	}

	@Override
	public ItemStack finishUsingItem(ItemStack itemstack, Level world, LivingEntity entity) {
		ItemStack retval = super.finishUsingItem(itemstack, world, entity);
		double x = entity.getX();
		double y = entity.getY();
		double z = entity.getZ();
		PureedRongGrassTuberWanJiaWanChengShiYongWuPinShiProcedure.execute(entity);
		return retval;
	}

	@Override
	public InteractionResult useOn(UseOnContext context) {
		super.useOn(context);
		RongGrassssProcedure.execute(context.getLevel(), context.getClickedPos().getX(), context.getClickedPos().getY(), context.getClickedPos().getZ(), context.getItemInHand());
		return InteractionResult.SUCCESS;
	}

	@Override
	public void inventoryTick(ItemStack itemstack, Level world, Entity entity, int slot, boolean selected) {
		super.inventoryTick(itemstack, world, entity, slot, selected);
		PureedRongGrassTuberWuPinZaiBeiBaoZhongShiMeiKeFaShengProcedure.execute(entity);
	}
}
