
package net.mcreator.mountainspoem.potion;

import net.mcreator.mountainspoem.procedures.ResentmentOfTheSouthernMountainsGodXiaoGuoChiXuShiMeiKeFaShengProcedure;

public class ResentmentOfTheSouthernMountainsGodMobEffect extends MobEffect {
	public ResentmentOfTheSouthernMountainsGodMobEffect() {
		super(MobEffectCategory.HARMFUL, -9995397);
	}

	@Override
	public void applyEffectTick(LivingEntity entity, int amplifier) {
		ResentmentOfTheSouthernMountainsGodXiaoGuoChiXuShiMeiKeFaShengProcedure.execute(entity.level(), entity.getX(), entity.getY(), entity.getZ(), entity);
	}

	@Override
	public boolean isDurationEffectTick(int duration, int amplifier) {
		return true;
	}
}
