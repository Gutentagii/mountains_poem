
package net.mcreator.mountainspoem.potion;

import net.mcreator.mountainspoem.procedures.AbundantXiaoGuoChiXuShiMeiKeFaShengProcedure;

public class AbundantMobEffect extends MobEffect {
	public AbundantMobEffect() {
		super(MobEffectCategory.BENEFICIAL, -3381760);
	}

	@Override
	public void applyEffectTick(LivingEntity entity, int amplifier) {
		AbundantXiaoGuoChiXuShiMeiKeFaShengProcedure.execute(entity);
	}

	@Override
	public boolean isDurationEffectTick(int duration, int amplifier) {
		return true;
	}
}
