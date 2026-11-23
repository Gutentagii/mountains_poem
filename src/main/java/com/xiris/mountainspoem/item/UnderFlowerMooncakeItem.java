
package com.xiris.mountainspoem.item;

import net.minecraft.advancements.Advancement;
import net.minecraft.advancements.AdvancementProgress;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.level.Level;

public class UnderFlowerMooncakeItem extends Item {
	public UnderFlowerMooncakeItem() {
		super(new Item.Properties().stacksTo(16).rarity(Rarity.COMMON).food((new FoodProperties.Builder()).nutrition(8).saturationMod(1.5f).alwaysEat().build()));
	}

	@Override
	public ItemStack finishUsingItem(ItemStack itemstack, Level world, LivingEntity entity) {
		ItemStack retval = super.finishUsingItem(itemstack, world, entity);
		double x = entity.getX();
		double y = entity.getY();
		double z = entity.getZ();
        if ((Entity) entity instanceof LivingEntity _entity && !_entity.level().isClientSide()) {
            _entity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_BOOST, 360, 2));
            _entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 480, 2));
            _entity.addEffect(new MobEffectInstance(MobEffects.GLOWING, 480, 0));
        }
        return retval;
	}

	@Override
	public void inventoryTick(ItemStack itemstack, Level world, Entity entity, int slot, boolean selected) {
		super.inventoryTick(itemstack, world, entity, slot, selected);
        if (entity instanceof ServerPlayer player) {
            player.awardRecipesByKey(new ResourceLocation[]{ResourceLocation.fromNamespaceAndPath("mountains_poem", "baked_under_flower_mooncake_recipe_2")});
            player.awardRecipesByKey(new ResourceLocation[]{ResourceLocation.fromNamespaceAndPath("mountains_poem", "item_mooncake_crust")});
            player.awardRecipesByKey(new ResourceLocation[]{ResourceLocation.fromNamespaceAndPath("mountains_poem", "baked_under_flower_mooncake_recipe")});
            player.awardRecipesByKey(new ResourceLocation[]{ResourceLocation.fromNamespaceAndPath("mountains_poem", "item_under_flower_mooncake")});
            Advancement advancement = player.server.getAdvancements().getAdvancement(ResourceLocation.fromNamespaceAndPath("mountains_poem", "make_mooncake"));
            AdvancementProgress ap = player.getAdvancements().getOrStartProgress(advancement);
            if (!ap.isDone())
                for (String criteria : ap.getRemainingCriteria())
                    player.getAdvancements().award(advancement, criteria);
        }
    }
}
