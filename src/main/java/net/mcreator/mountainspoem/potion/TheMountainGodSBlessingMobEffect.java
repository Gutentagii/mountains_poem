
package net.mcreator.mountainspoem.potion;

import net.mcreator.mountainspoem.procedures.TheMountainGodSBlessingXiaoGuoChiXuShiMeiKeFaShengProcedure;

public class TheMountainGodSBlessingMobEffect extends MobEffect {
	public TheMountainGodSBlessingMobEffect() {
		super(MobEffectCategory.BENEFICIAL, -11958351);
	}

	@Override
	public void applyEffectTick(LivingEntity entity, int amplifier) {
		TheMountainGodSBlessingXiaoGuoChiXuShiMeiKeFaShengProcedure.execute(entity);
	}

	@Override
	public boolean isDurationEffectTick(int duration, int amplifier) {
		return true;
	}
}
