
package com.xiris.mountainspoem.item;

import com.xiris.mountainspoem.MountainsPoemMod;
//import dev.architectury.platform.Platform;
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

public class MantouSoakedInMuttonSoupItem extends Item {
	public MantouSoakedInMuttonSoupItem() {
		super(new Item.Properties().stacksTo(1).rarity(Rarity.COMMON).food((new FoodProperties.Builder()).nutrition(12).saturationMod(2.5f).build()));
	}

	@Override
	public ItemStack finishUsingItem(ItemStack itemstack, Level world, LivingEntity entity) {
		ItemStack retval = new ItemStack(Items.BOWL);
		super.finishUsingItem(itemstack, world, entity);
		double x = entity.getX();
		double y = entity.getY();
		double z = entity.getZ();
        if ((Entity) entity instanceof LivingEntity _entity && !_entity.level().isClientSide()) {
            _entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 160, 0));
            _entity.addEffect(new MobEffectInstance(MobEffects.HEALTH_BOOST, 160, 0));
            _entity.addEffect(new MobEffectInstance(MobEffects.JUMP, 160, 0));
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
		if (entity instanceof ServerPlayer _serverPlayer) {
			_serverPlayer.awardRecipesByKey(new ResourceLocation[]{ResourceLocation.fromNamespaceAndPath(MountainsPoemMod.MOD_ID,"mantou_soaked_in_mutton_soup_item")});
            if (net.minecraftforge.fml.ModList.get().isLoaded("farmersdelight")) {
                _serverPlayer.awardRecipesByKey(new ResourceLocation[]{ResourceLocation.fromNamespaceAndPath("farmersdelight", "cooking/mantou_soaked_in_mutton_soup")});
            }
		}
	}
}
