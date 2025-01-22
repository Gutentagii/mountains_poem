
package net.mcreator.mountainspoem.potion;

import net.mcreator.mountainspoem.procedures.ZhengDangShiTiGengXinKeShiProcedure;

public class StrongOdorMobEffect extends MobEffect {
	public StrongOdorMobEffect() {
		super(MobEffectCategory.BENEFICIAL, -4231852);
	}

	@Override
	public void applyEffectTick(LivingEntity entity, int amplifier) {
		ZhengDangShiTiGengXinKeShiProcedure.execute(entity.level(), entity.getX(), entity.getY(), entity.getZ(), entity);
	}

	@Override
	public boolean isDurationEffectTick(int duration, int amplifier) {
		return true;
	}
}
