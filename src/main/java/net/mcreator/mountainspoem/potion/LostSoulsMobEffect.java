
package net.mcreator.mountainspoem.potion;

import net.mcreator.mountainspoem.procedures.LostSoulsXiaoGuoChiXuShiMeiKeFaShengProcedure;

public class LostSoulsMobEffect extends MobEffect {
	public LostSoulsMobEffect() {
		super(MobEffectCategory.HARMFUL, -15500954);
	}

	@Override
	public void applyEffectTick(LivingEntity entity, int amplifier) {
		LostSoulsXiaoGuoChiXuShiMeiKeFaShengProcedure.execute(entity.level(), entity.getX(), entity.getY(), entity.getZ(), entity);
	}

	@Override
	public boolean isDurationEffectTick(int duration, int amplifier) {
		return true;
	}
}
