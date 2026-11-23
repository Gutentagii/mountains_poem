
package com.xiris.mountainspoem.potion;

import com.xiris.mountainspoem.init.MountainsPoemModMobEffects;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.AttributeMap;

public class CrazyMobEffect extends MobEffect {
	public CrazyMobEffect() {
		super(MobEffectCategory.HARMFUL, -15859455);
	}

	@Override
	public void addAttributeModifiers(LivingEntity entity, AttributeMap attributeMap, int amplifier) {
		entity.setSecondsOnFire(5);
		entity.setShiftKeyDown(true);
	}

	@Override
	public void applyEffectTick(LivingEntity entity, int amplifier) {
		if ((Entity) entity instanceof LivingEntity _entity && !_entity.level().isClientSide()) {
			_entity.addEffect(new MobEffectInstance(MountainsPoemModMobEffects.LOST_SOULS.get(), 3, 2, false, false));
			_entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 3, 2, false, false));
			_entity.addEffect(new MobEffectInstance(MobEffects.WEAKNESS, 3, 2, false, false));
		}
	}

	@Override
	public void removeAttributeModifiers(LivingEntity entity, AttributeMap attributeMap, int amplifier) {
		super.removeAttributeModifiers(entity, attributeMap, amplifier);
        entity.setShiftKeyDown(false);
    }

	@Override
	public boolean isDurationEffectTick(int duration, int amplifier) {
		return true;
	}
}
