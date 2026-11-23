
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

public class WroughtPatternZunItem extends Item {
	public WroughtPatternZunItem() {
		super(new Item.Properties().stacksTo(64).rarity(Rarity.UNCOMMON));
	}

	@Override
	public void appendHoverText(ItemStack itemstack, Level world, List<Component> list, TooltipFlag flag) {
		super.appendHoverText(itemstack, world, list, flag);
		list.add(Component.translatable("item.mountains_poem.item.decsr.zun"));
	}

	@Override
	public void inventoryTick(ItemStack itemstack, Level world, Entity entity, int slot, boolean selected) {
		super.inventoryTick(itemstack, world, entity, slot, selected);
        if (entity instanceof ServerPlayer _player) {
            Advancement advancement = _player.server.getAdvancements().getAdvancement(ResourceLocation.fromNamespaceAndPath(MountainsPoemMod.MOD_ID,"collect_any_wrought_pattern"));
            AdvancementProgress apap = _player.getAdvancements().getOrStartProgress(advancement);
            if (!apap.isDone())
                for (String criteria : apap.getRemainingCriteria())
                    _player.getAdvancements().award(advancement, criteria);
        }
    }
}
