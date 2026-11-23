
package com.xiris.mountainspoem.item;

import com.xiris.mountainspoem.MountainsPoemMod;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.context.UseOnContext;

public class RedRuFishItem extends Item {
	public RedRuFishItem() {
		super(new Item.Properties().stacksTo(64).rarity(Rarity.COMMON).food((new FoodProperties.Builder()).nutrition(4).saturationMod(0.5f).meat().build()));
	}

	@Override
	public InteractionResult useOn(UseOnContext context) {
		super.useOn(context);
        if ((Entity) context.getPlayer() instanceof ServerPlayer _serverPlayer) {
            _serverPlayer.awardRecipesByKey(new ResourceLocation[]{ResourceLocation.fromNamespaceAndPath(MountainsPoemMod.MOD_ID,"meat_11")});
            _serverPlayer.awardRecipesByKey(new ResourceLocation[]{ResourceLocation.fromNamespaceAndPath(MountainsPoemMod.MOD_ID,"meats_11")});
            _serverPlayer.awardRecipesByKey(new ResourceLocation[]{ResourceLocation.fromNamespaceAndPath(MountainsPoemMod.MOD_ID,"redru_fish_meat")});
        }
        return InteractionResult.SUCCESS;
	}
}
