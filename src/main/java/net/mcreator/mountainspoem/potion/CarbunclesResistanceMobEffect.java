
package net.mcreator.mountainspoem.potion;

import net.mcreator.mountainspoem.procedures.CarbunclesResistanceXiaoGuoChiXuShiMeiKeFaShengProcedure;

public class CarbunclesResistanceMobEffect extends MobEffect {
	public CarbunclesResistanceMobEffect() {
		super(MobEffectCategory.BENEFICIAL, -14817472);
	}

	@Override
	public void applyEffectTick(LivingEntity entity, int amplifier) {
		CarbunclesResistanceXiaoGuoChiXuShiMeiKeFaShengProcedure.execute(entity);
	}

	@Override
	public boolean isDurationEffectTick(int duration, int amplifier) {
		return true;
	}
}
