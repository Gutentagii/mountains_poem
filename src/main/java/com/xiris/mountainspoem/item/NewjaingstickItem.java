
package com.xiris.mountainspoem.item;

import com.xiris.mountainspoem.MountainsPoemMod;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Rarity;

public class NewjaingstickItem extends Item {
	public NewjaingstickItem() {
		super(new Item.Properties().stacksTo(64).rarity(Rarity.COMMON));
	}

	@Override
	public boolean hurtEnemy(ItemStack itemstack, LivingEntity entity, LivingEntity sourceentity) {
		boolean retval = super.hurtEnemy(itemstack, entity, sourceentity);
        if ((Entity) entity instanceof LivingEntity _entity && !_entity.level().isClientSide()) {
            boolean isSmall = entity.getType().is(TagKey.create(Registries.ENTITY_TYPE, ResourceLocation.fromNamespaceAndPath(MountainsPoemMod.MOD_ID,"small_mobs")));
            _entity.addEffect(new MobEffectInstance(MobEffects.BLINDNESS, isSmall ? 600 : 140, 1));
            _entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, isSmall ? 600 : 140, 5));
        }
        return retval;
	}
}
