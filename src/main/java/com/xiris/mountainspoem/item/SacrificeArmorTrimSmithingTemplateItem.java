
package com.xiris.mountainspoem.item;

import com.xiris.mountainspoem.MountainsPoemMod;
import net.minecraft.advancements.Advancement;
import net.minecraft.advancements.AdvancementProgress;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;

import java.util.List;

public class SacrificeArmorTrimSmithingTemplateItem extends Item {
	public SacrificeArmorTrimSmithingTemplateItem() {
		super(new Item.Properties().stacksTo(64).rarity(Rarity.COMMON));
	}

	@Override
	public void appendHoverText(ItemStack itemstack, Level world, List<Component> list, TooltipFlag flag) {
		super.appendHoverText(itemstack, world, list, flag);
		list.add(Component.translatable("mountains_poem:sacrifice_armor_trim_smithing_template_dscr"));
		list.add(Component.literal(""));
		list.add(Component.translatable("item.mountains_poem.under_armor_trim.base_slot_description"));
		list.add(Component.translatable("item.mountains_poem.under_armor_trim.applies_to"));
		list.add(Component.translatable("item.mountains_poem.under_armor_trim.upgrade_description"));
		list.add(Component.translatable("item.mountains_poem.under_armor_trim.ingredients"));
	}

	@Override
	public void inventoryTick(ItemStack itemstack, Level world, Entity entity, int slot, boolean selected) {
		super.inventoryTick(itemstack, world, entity, slot, selected);
        if (entity instanceof ServerPlayer player) {
            Advancement advancement = player.server.getAdvancements().getAdvancement(ResourceLocation.fromNamespaceAndPath("minecraft", "adventure/trim_with_any_armor_pattern"));
            AdvancementProgress ap = player.getAdvancements().getOrStartProgress(advancement);
            if (!ap.isDone())
                for (String criteria : ap.getRemainingCriteria())
                    player.getAdvancements().award(advancement, criteria);
            player.awardRecipesByKey(new ResourceLocation[]{ResourceLocation.fromNamespaceAndPath(MountainsPoemMod.MOD_ID,"sacrifice_armor_trim_smithing_templates")});
        }
    }
}
