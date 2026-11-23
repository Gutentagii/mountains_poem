
package com.xiris.mountainspoem.potion;

import com.xiris.mountainspoem.init.MountainsPoemModMobEffects;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;

public class EvilQiMobEffect extends MobEffect {
	public EvilQiMobEffect() {
		super(MobEffectCategory.HARMFUL, -10408586);
	}

	@Override
	public void applyEffectTick(LivingEntity entity, int amplifier) {
        if ((Entity) entity instanceof LivingEntity _entity && !_entity.level().isClientSide()) {
            _entity.addEffect(new MobEffectInstance(MountainsPoemModMobEffects.CRAZY.get(), 60, 0, false, false));
            _entity.addEffect(new MobEffectInstance(MountainsPoemModMobEffects.CHAOS.get(), 60, 0, false, false));
        }
    }

	@Override
	public boolean isDurationEffectTick(int duration, int amplifier) {
		return true;
	}
}
