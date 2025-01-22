
package net.mcreator.mountainspoem.item;

import net.minecraft.world.level.Level;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.network.chat.Component;

import net.mcreator.mountainspoem.procedures.KnowledgeBambooSlipsShiTiHuiDongWuPinShiProcedure;

import java.util.List;

public class KnowledgeBambooSlipsItem extends Item {
	public KnowledgeBambooSlipsItem() {
		super(new Item.Properties().stacksTo(64).rarity(Rarity.COMMON));
	}

	@Override
	public void appendHoverText(ItemStack itemstack, Level world, List<Component> list, TooltipFlag flag) {
		super.appendHoverText(itemstack, world, list, flag);
		list.add(Component.translatable("item.mountains_poem.item.decsr.knowledge"));
	}

	@Override
	public boolean onEntitySwing(ItemStack itemstack, LivingEntity entity) {
		boolean retval = super.onEntitySwing(itemstack, entity);
		KnowledgeBambooSlipsShiTiHuiDongWuPinShiProcedure.execute(entity, itemstack);
		return retval;
	}
}
