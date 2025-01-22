
package net.mcreator.mountainspoem.potion;

import net.mcreator.mountainspoem.procedures.CarbunclesXiaoGuoChiXuShiMeiKeFaShengProcedure;

public class CarbunclesMobEffect extends MobEffect {
	public CarbunclesMobEffect() {
		super(MobEffectCategory.HARMFUL, -10873322);
	}

	@Override
	public void applyEffectTick(LivingEntity entity, int amplifier) {
		CarbunclesXiaoGuoChiXuShiMeiKeFaShengProcedure.execute(entity.level(), entity);
	}

	@Override
	public boolean isDurationEffectTick(int duration, int amplifier) {
		return true;
	}
}
