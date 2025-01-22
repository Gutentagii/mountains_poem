
package net.mcreator.mountainspoem.item;

import net.minecraft.world.level.Level;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.network.chat.Component;

import net.mcreator.mountainspoem.procedures.LushuLeatherShiTiHuiDongWuPinShiProcedure;
import net.mcreator.mountainspoem.procedures.LushuLeatherGongJuChuXianZaiShouZhongShiMeiKeFaShengProcedure;

import java.util.List;

public class LushuLeatherItem extends Item {
	public LushuLeatherItem() {
		super(new Item.Properties().stacksTo(64).rarity(Rarity.COMMON));
	}

	@Override
	public void appendHoverText(ItemStack itemstack, Level world, List<Component> list, TooltipFlag flag) {
		super.appendHoverText(itemstack, world, list, flag);
		list.add(Component.translatable("item.mountains_poem.item.decsr.lushu_leather"));
	}

	@Override
	public boolean onEntitySwing(ItemStack itemstack, LivingEntity entity) {
		boolean retval = super.onEntitySwing(itemstack, entity);
		LushuLeatherShiTiHuiDongWuPinShiProcedure.execute(entity.level(), entity.getX(), entity.getY(), entity.getZ(), entity, itemstack);
		return retval;
	}

	@Override
	public void inventoryTick(ItemStack itemstack, Level world, Entity entity, int slot, boolean selected) {
		super.inventoryTick(itemstack, world, entity, slot, selected);
		if (selected)
			LushuLeatherGongJuChuXianZaiShouZhongShiMeiKeFaShengProcedure.execute(itemstack);
		LushuLeatherGongJuChuXianZaiShouZhongShiMeiKeFaShengProcedure.execute(itemstack);
	}
}
