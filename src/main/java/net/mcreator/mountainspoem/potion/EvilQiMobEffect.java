
package net.mcreator.mountainspoem.potion;

import net.mcreator.mountainspoem.procedures.EvilQiXiaoGuoChiXuShiMeiKeFaShengProcedure;

public class EvilQiMobEffect extends MobEffect {
	public EvilQiMobEffect() {
		super(MobEffectCategory.HARMFUL, -10408586);
	}

	@Override
	public void applyEffectTick(LivingEntity entity, int amplifier) {
		EvilQiXiaoGuoChiXuShiMeiKeFaShengProcedure.execute(entity);
	}

	@Override
	public boolean isDurationEffectTick(int duration, int amplifier) {
		return true;
	}
}
