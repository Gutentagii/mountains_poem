
package com.xiris.mountainspoem.potion;

import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;

public class DermatosisMobEffect extends MobEffect {
	public DermatosisMobEffect() {
		super(MobEffectCategory.HARMFUL, -5666223);
	}

	@Override
	public boolean isDurationEffectTick(int duration, int amplifier) {
		return true;
	}
}
