
package com.xiris.mountainspoem.potion;

import com.xiris.mountainspoem.init.MountainsPoemModMobEffects;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.AttributeMap;
import net.minecraft.world.level.LevelAccessor;

public class PestilenceMobEffect extends MobEffect {
	public PestilenceMobEffect() {
		super(MobEffectCategory.HARMFUL, -13088714);
	}

	@Override
	public void addAttributeModifiers(LivingEntity entity, AttributeMap attributeMap, int amplifier) {
		entity.setMaxUpStep((float) (((Entity) entity).maxUpStep() - 0.5));
		entity.setAirSupply(0);
		if ((Entity) entity instanceof LivingEntity _entity)
			_entity.swing(InteractionHand.MAIN_HAND, true);
	}

	@Override
	public void applyEffectTick(LivingEntity entity, int amplifier) {
		LevelAccessor world = entity.level();
		entity.setAirSupply((int) (entity.getAirSupply() - 0.5));
		((Entity) entity).hurt(new DamageSource(world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(DamageTypes.GENERIC)), 1);
		if ((Entity) entity instanceof LivingEntity _entity && !_entity.level().isClientSide()) {
			_entity.addEffect(new MobEffectInstance(MountainsPoemModMobEffects.DEHYDRATION.get(), 1, 1));
			_entity.addEffect(new MobEffectInstance(MobEffects.BLINDNESS, 1, 1));
		}
	}

	@Override
	public void removeAttributeModifiers(LivingEntity entity, AttributeMap attributeMap, int amplifier) {
		super.removeAttributeModifiers(entity, attributeMap, amplifier);
        entity.setMaxUpStep((float) (((Entity) entity).maxUpStep() + 0.5));
    }

	@Override
	public boolean isDurationEffectTick(int duration, int amplifier) {
		return true;
	}
}
