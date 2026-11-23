
package com.xiris.mountainspoem.item;

import com.xiris.mountainspoem.MountainsPoemMod;
//import dev.architectury.platform.Platform;
import com.xiris.mountainspoem.init.MountainsPoemModMobEffects;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.level.Level;

public class CookedChangfuChickenItem extends Item {
	public CookedChangfuChickenItem() {
		super(new Item.Properties().stacksTo(64).rarity(Rarity.COMMON).food((new FoodProperties.Builder()).nutrition(3).saturationMod(1f).meat().build()));
	}

	@Override
	public int getUseDuration(ItemStack itemstack) {
		return 28;
	}

	@Override
	public ItemStack finishUsingItem(ItemStack itemstack, Level world, LivingEntity entity) {
		ItemStack retval = super.finishUsingItem(itemstack, world, entity);
		double x = entity.getX();
		double y = entity.getY();
		double z = entity.getZ();
        if ((Entity) entity instanceof LivingEntity living && !living.level().isClientSide())
            living.addEffect(new MobEffectInstance(MountainsPoemModMobEffects.NOCTURNAL_JOURNEYMAN.get(), 600, 1));
        return retval;
	}

	@Override
	public void inventoryTick(ItemStack itemstack, Level world, Entity entity, int slot, boolean selected) {
		super.inventoryTick(itemstack, world, entity, slot, selected);
        if (entity instanceof ServerPlayer player){
            player.awardRecipesByKey(new ResourceLocation[]{ResourceLocation.fromNamespaceAndPath(MountainsPoemMod.MOD_ID,"changfu_meats")});
            player.awardRecipesByKey(new ResourceLocation[]{ResourceLocation.fromNamespaceAndPath(MountainsPoemMod.MOD_ID,"meat_5")});
            player.awardRecipesByKey(new ResourceLocation[]{ResourceLocation.fromNamespaceAndPath(MountainsPoemMod.MOD_ID,"meats_4")});

            if (net.minecraftforge.fml.ModList.get().isLoaded("farmersdelight")) {
                player.awardRecipesByKey(new ResourceLocation[]{ResourceLocation.fromNamespaceAndPath("farmersdelight", "cutting/changfu_chicken_sauce")});
            }
        }
    }
}
