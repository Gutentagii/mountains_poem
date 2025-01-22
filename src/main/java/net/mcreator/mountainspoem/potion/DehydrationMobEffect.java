
package net.mcreator.mountainspoem.potion;

import net.mcreator.mountainspoem.procedures.DehydrationXiaoGuoChiXuShiMeiKeFaShengProcedure;

public class DehydrationMobEffect extends MobEffect {
	public DehydrationMobEffect() {
		super(MobEffectCategory.HARMFUL, -52);
	}

	@Override
	public void applyEffectTick(LivingEntity entity, int amplifier) {
		DehydrationXiaoGuoChiXuShiMeiKeFaShengProcedure.execute(entity.level(), entity);
	}

	@Override
	public boolean isDurationEffectTick(int duration, int amplifier) {
		return true;
	}
}
