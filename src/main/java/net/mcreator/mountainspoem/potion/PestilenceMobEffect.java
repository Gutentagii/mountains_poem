
package net.mcreator.mountainspoem.potion;

import net.mcreator.mountainspoem.procedures.PestilenceXiaoGuoChiXuShiMeiKeFaShengProcedure;
import net.mcreator.mountainspoem.procedures.PestilenceDangYaoShuiXiaoGuoKaiShiYingYongShiProcedure;
import net.mcreator.mountainspoem.procedures.PestilenceDangXiaoGuoJieShuProcedure;

public class PestilenceMobEffect extends MobEffect {
	public PestilenceMobEffect() {
		super(MobEffectCategory.HARMFUL, -13088714);
	}

	@Override
	public void addAttributeModifiers(LivingEntity entity, AttributeMap attributeMap, int amplifier) {
		PestilenceDangYaoShuiXiaoGuoKaiShiYingYongShiProcedure.execute(entity);
	}

	@Override
	public void applyEffectTick(LivingEntity entity, int amplifier) {
		PestilenceXiaoGuoChiXuShiMeiKeFaShengProcedure.execute(entity.level(), entity);
	}

	@Override
	public void removeAttributeModifiers(LivingEntity entity, AttributeMap attributeMap, int amplifier) {
		super.removeAttributeModifiers(entity, attributeMap, amplifier);
		PestilenceDangXiaoGuoJieShuProcedure.execute(entity);
	}

	@Override
	public boolean isDurationEffectTick(int duration, int amplifier) {
		return true;
	}
}
