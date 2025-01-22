
package net.mcreator.mountainspoem.potion;

import net.mcreator.mountainspoem.procedures.BoshiBlessingXiaoGuoChiXuShiMeiKeFaShengProcedure;

public class BoshiBlessingMobEffect extends MobEffect {
	public BoshiBlessingMobEffect() {
		super(MobEffectCategory.BENEFICIAL, -6113090);
	}

	@Override
	public void applyEffectTick(LivingEntity entity, int amplifier) {
		BoshiBlessingXiaoGuoChiXuShiMeiKeFaShengProcedure.execute(entity);
	}

	@Override
	public boolean isDurationEffectTick(int duration, int amplifier) {
		return true;
	}
}
