
package net.mcreator.mountainspoem.potion;

import net.mcreator.mountainspoem.procedures.HydratedSkinXiaoGuoChiXuShiMeiKeFaShengProcedure;

public class HydratedSkinMobEffect extends MobEffect {
	public HydratedSkinMobEffect() {
		super(MobEffectCategory.BENEFICIAL, -16737793);
	}

	@Override
	public void applyEffectTick(LivingEntity entity, int amplifier) {
		HydratedSkinXiaoGuoChiXuShiMeiKeFaShengProcedure.execute(entity);
	}

	@Override
	public boolean isDurationEffectTick(int duration, int amplifier) {
		return true;
	}
}
