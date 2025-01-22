
package net.mcreator.mountainspoem.item;

import net.minecraft.world.level.Level;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.entity.Entity;
import net.minecraft.network.chat.Component;

import net.mcreator.mountainspoem.procedures.Blood1Procedure;

import java.util.List;

public class BloodCopperUpgradeSmithingTemplateItem extends Item {
	public BloodCopperUpgradeSmithingTemplateItem() {
		super(new Item.Properties().stacksTo(64).rarity(Rarity.UNCOMMON));
	}

	@Override
	public void appendHoverText(ItemStack itemstack, Level world, List<Component> list, TooltipFlag flag) {
		super.appendHoverText(itemstack, world, list, flag);
		list.add(Component.translatable("mountains_poem:blood_copper_upgrade_smithing_template_dscr"));
		list.add(Component.literal(""));
		list.add(Component.translatable("item.mountains_poem.under_armor_trim.base_slot_description"));
		list.add(Component.translatable("item.mountains_poem.blood_copper_upgrade.applies_to"));
		list.add(Component.translatable("item.mountains_poem.under_armor_trim.upgrade_description"));
		list.add(Component.translatable("item.mountains_poem.blood_copper_upgrade.ingredients"));
	}

	@Override
	public void inventoryTick(ItemStack itemstack, Level world, Entity entity, int slot, boolean selected) {
		super.inventoryTick(itemstack, world, entity, slot, selected);
		Blood1Procedure.execute(entity);
	}
}
