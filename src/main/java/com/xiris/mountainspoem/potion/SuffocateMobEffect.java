
package com.xiris.mountainspoem.potion;

import com.xiris.mountainspoem.MountainsPoemMod;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.LevelAccessor;

public class SuffocateMobEffect extends MobEffect {
	public SuffocateMobEffect() {
		super(MobEffectCategory.NEUTRAL, -11988726);
	}

	@Override
	public void applyEffectTick(LivingEntity entity, int amplifier) {
        LevelAccessor world = entity.level();
        if (!((Entity) entity instanceof LivingEntity _livEnt0 && _livEnt0.hasEffect(MobEffects.WATER_BREATHING)))
            ((Entity) entity).hurt(new DamageSource(world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(ResourceKey.create(Registries.DAMAGE_TYPE, ResourceLocation.fromNamespaceAndPath(MountainsPoemMod.MOD_ID,"hanging")))), (float) 0.5);
    }

	@Override
	public boolean isDurationEffectTick(int duration, int amplifier) {
		return true;
	}
}
