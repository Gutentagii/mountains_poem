
package net.mcreator.mountainspoem.potion;

import net.mcreator.mountainspoem.procedures.LushXiaoGuoChiXuShiMeiKeFaShengProcedure;

public class LushMobEffect extends MobEffect {
	public LushMobEffect() {
		super(MobEffectCategory.BENEFICIAL, -16724992);
	}

	@Override
	public void applyEffectTick(LivingEntity entity, int amplifier) {
		LushXiaoGuoChiXuShiMeiKeFaShengProcedure.execute(entity.level(), entity.getX(), entity.getY(), entity.getZ(), entity);
	}

	@Override
	public boolean isDurationEffectTick(int duration, int amplifier) {
		return true;
	}
}
