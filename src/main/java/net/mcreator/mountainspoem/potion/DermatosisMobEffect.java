
package net.mcreator.mountainspoem.potion;

public class DermatosisMobEffect extends MobEffect {
	public DermatosisMobEffect() {
		super(MobEffectCategory.HARMFUL, -5666223);
	}

	@Override
	public boolean isDurationEffectTick(int duration, int amplifier) {
		return true;
	}
}
