
package net.mcreator.mountainspoem.potion;

import net.mcreator.mountainspoem.procedures.GuResistanceXiaoGuoChiXuShiMeiKeFaShengProcedure;

public class GuResistanceMobEffect extends MobEffect {
	public GuResistanceMobEffect() {
		super(MobEffectCategory.BENEFICIAL, -1640);
	}

	@Override
	public void applyEffectTick(LivingEntity entity, int amplifier) {
		GuResistanceXiaoGuoChiXuShiMeiKeFaShengProcedure.execute(entity.level(), entity.getX(), entity.getY(), entity.getZ(), entity);
	}

	@Override
	public boolean isDurationEffectTick(int duration, int amplifier) {
		return true;
	}
}
