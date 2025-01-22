
package net.mcreator.mountainspoem.potion;

import net.mcreator.mountainspoem.procedures.LushuHeartsProcedure;

public class LushuHeartMobEffect extends MobEffect {
	public LushuHeartMobEffect() {
		super(MobEffectCategory.BENEFICIAL, -3394816);
	}

	@Override
	public void applyEffectTick(LivingEntity entity, int amplifier) {
		LushuHeartsProcedure.execute(entity.level(), entity.getX(), entity.getY(), entity.getZ(), entity);
	}

	@Override
	public boolean isDurationEffectTick(int duration, int amplifier) {
		return true;
	}
}
