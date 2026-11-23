
package com.xiris.mountainspoem.potion;

import com.xiris.mountainspoem.init.MountainsPoemModMobEffects;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;

public class CarbunclesResistanceMobEffect extends MobEffect {
	public CarbunclesResistanceMobEffect() {
		super(MobEffectCategory.BENEFICIAL, -14817472);
	}

	@Override
	public void applyEffectTick(LivingEntity entity, int amplifier) {
        if ((Entity) entity instanceof LivingEntity living)
            living.removeEffect(MountainsPoemModMobEffects.CARBUNCLES.get());
    }

	@Override
	public boolean isDurationEffectTick(int duration, int amplifier) {
		return true;
	}
}
