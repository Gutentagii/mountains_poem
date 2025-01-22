
package net.mcreator.mountainspoem.potion;

import net.mcreator.mountainspoem.procedures.SleepPeacefullyXiaoGuoChiXuShiMeiKeFaShengProcedure;

public class SleepPeacefullyMobEffect extends MobEffect {
	public SleepPeacefullyMobEffect() {
		super(MobEffectCategory.NEUTRAL, -16777114);
	}

	@Override
	public void applyEffectTick(LivingEntity entity, int amplifier) {
		SleepPeacefullyXiaoGuoChiXuShiMeiKeFaShengProcedure.execute(entity.level(), entity.getX(), entity.getY(), entity.getZ());
	}

	@Override
	public boolean isDurationEffectTick(int duration, int amplifier) {
		return true;
	}
}
