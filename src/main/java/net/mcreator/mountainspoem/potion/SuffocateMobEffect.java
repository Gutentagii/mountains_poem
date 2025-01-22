
package net.mcreator.mountainspoem.potion;

import net.mcreator.mountainspoem.procedures.SuffocateXiaoGuoChiXuShiMeiKeFaShengProcedure;

public class SuffocateMobEffect extends MobEffect {
	public SuffocateMobEffect() {
		super(MobEffectCategory.NEUTRAL, -11988726);
	}

	@Override
	public void applyEffectTick(LivingEntity entity, int amplifier) {
		SuffocateXiaoGuoChiXuShiMeiKeFaShengProcedure.execute(entity.level(), entity);
	}

	@Override
	public boolean isDurationEffectTick(int duration, int amplifier) {
		return true;
	}
}
