
package net.mcreator.mountainspoem.potion;

import net.mcreator.mountainspoem.procedures.ChaosXiaoGuoChiXuShiMeiKeFaShengProcedure;

public class ChaosMobEffect extends MobEffect {
	public ChaosMobEffect() {
		super(MobEffectCategory.HARMFUL, -15397876);
	}

	@Override
	public void applyEffectTick(LivingEntity entity, int amplifier) {
		ChaosXiaoGuoChiXuShiMeiKeFaShengProcedure.execute(entity);
	}

	@Override
	public boolean isDurationEffectTick(int duration, int amplifier) {
		return true;
	}
}
