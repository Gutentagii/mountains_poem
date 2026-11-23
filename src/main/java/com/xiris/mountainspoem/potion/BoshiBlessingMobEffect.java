
package com.xiris.mountainspoem.potion;

import com.xiris.mountainspoem.init.MountainsPoemModMobEffects;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;

public class BoshiBlessingMobEffect extends MobEffect {
	public BoshiBlessingMobEffect() {
		super(MobEffectCategory.BENEFICIAL, -6113090);
	}

	@Override
	public void applyEffectTick(LivingEntity entity, int amplifier) {
        if ((Entity) entity instanceof LivingEntity _entity)
            _entity.removeEffect(MountainsPoemModMobEffects.LOST_SOULS.get());
    }

	@Override
	public boolean isDurationEffectTick(int duration, int amplifier) {
		return true;
	}
}
