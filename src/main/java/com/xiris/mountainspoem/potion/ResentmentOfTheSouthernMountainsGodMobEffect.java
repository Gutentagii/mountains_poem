
package com.xiris.mountainspoem.potion;

import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.LivingEntity;

public class ResentmentOfTheSouthernMountainsGodMobEffect extends MobEffect {
	public ResentmentOfTheSouthernMountainsGodMobEffect() {
		super(MobEffectCategory.HARMFUL, -9995397);
	}

	@Override
	public void applyEffectTick(LivingEntity entity, int amplifier) {
        entity.level();
    }

	@Override
	public boolean isDurationEffectTick(int duration, int amplifier) {
		return true;
	}
}
