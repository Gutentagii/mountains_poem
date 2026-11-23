
package com.xiris.mountainspoem.item;

import com.xiris.mountainspoem.MountainsPoemMod;
import com.xiris.mountainspoem.init.MountainsPoemModMobEffects;
import net.minecraft.advancements.Advancement;
import net.minecraft.advancements.AdvancementProgress;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.level.Level;

public class ClassicSuperDarkCuisineMooncakeItem extends Item {
	public ClassicSuperDarkCuisineMooncakeItem() {
		super(new Item.Properties().stacksTo(16).rarity(Rarity.UNCOMMON).food((new FoodProperties.Builder()).nutrition(10).saturationMod(0.5f).alwaysEat().build()));
	}

	@Override
	public int getUseDuration(ItemStack itemstack) {
		return 64;
	}

	@Override
	public ItemStack finishUsingItem(ItemStack itemstack, Level world, LivingEntity entity) {
		ItemStack retval = new ItemStack(Items.SPIDER_EYE);
		super.finishUsingItem(itemstack, world, entity);
		if ((Entity) entity instanceof LivingEntity _entity && !_entity.level().isClientSide()) {
			_entity.addEffect(new MobEffectInstance(MountainsPoemModMobEffects.SUFFOCATE.get(), 100, 0));
			_entity.addEffect(new MobEffectInstance(MobEffects.CONFUSION, 1000, 1));
			_entity.addEffect(new MobEffectInstance(MobEffects.WEAKNESS, 10000, 2));
			_entity.addEffect(new MobEffectInstance(MobEffects.SLOW_FALLING, 10000, 3));
			_entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 10000, 4));
			_entity.addEffect(new MobEffectInstance(MountainsPoemModMobEffects.LOST_SOULS.get(), 10000, 5));
			_entity.addEffect(new MobEffectInstance(MobEffects.DARKNESS, 10000, 6));
		}
		if (itemstack.isEmpty()) {
			return retval;
		} else {
            Player player = (Player) entity;
            if (!player.getAbilities().instabuild) {
				if (!player.getInventory().add(retval))
					player.drop(retval, false);
			}
			return itemstack;
		}
	}

	@Override
	public void inventoryTick(ItemStack itemstack, Level world, Entity entity, int slot, boolean selected) {
		super.inventoryTick(itemstack, world, entity, slot, selected);
		if (entity instanceof ServerPlayer player) {
			player.awardRecipesByKey(new ResourceLocation[]{ResourceLocation.fromNamespaceAndPath(MountainsPoemMod.MOD_ID,"item_mooncake_crust")});
				player.awardRecipesByKey(new ResourceLocation[]{ResourceLocation.fromNamespaceAndPath(MountainsPoemMod.MOD_ID,"item_classic_super_dark_cuisine_mooncake")});
			Advancement advancement = player.server.getAdvancements().getAdvancement(ResourceLocation.fromNamespaceAndPath(MountainsPoemMod.MOD_ID,"make_mooncake"));
			AdvancementProgress ap = player.getAdvancements().getOrStartProgress(advancement);
			if (!ap.isDone())
				for (String criteria : ap.getRemainingCriteria())
					player.getAdvancements().award(advancement, criteria);
			Advancement _adv = player.server.getAdvancements().getAdvancement(ResourceLocation.fromNamespaceAndPath(MountainsPoemMod.MOD_ID,"make_classic_super_dark_cuisine_mooncake"));
			AdvancementProgress _ap = player.getAdvancements().getOrStartProgress(_adv);
			if (!_ap.isDone())
				for (String criteria : _ap.getRemainingCriteria())
					player.getAdvancements().award(_adv, criteria);
		}
	}
}
