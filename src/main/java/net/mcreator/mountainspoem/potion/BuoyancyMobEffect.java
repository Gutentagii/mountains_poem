
package net.mcreator.mountainspoem.potion;

import net.mcreator.mountainspoem.procedures.BuoyancyXiaoGuoChiXuShiMeiKeFaShengProcedure;

public class BuoyancyMobEffect extends MobEffect {
	public BuoyancyMobEffect() {
		super(MobEffectCategory.BENEFICIAL, -9144189);
	}

	@Override
	public void applyEffectTick(LivingEntity entity, int amplifier) {
		BuoyancyXiaoGuoChiXuShiMeiKeFaShengProcedure.execute(entity.level(), entity.getX(), entity.getY(), entity.getZ(), entity);
	}

	@Override
	public boolean isDurationEffectTick(int duration, int amplifier) {
		return true;
	}
}
