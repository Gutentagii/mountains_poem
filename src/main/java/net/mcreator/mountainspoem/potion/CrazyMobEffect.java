
package net.mcreator.mountainspoem.potion;

import net.mcreator.mountainspoem.procedures.CrazyXiaoGuoChiXuShiMeiKeFaShengProcedure;
import net.mcreator.mountainspoem.procedures.CrazyDangYaoShuiXiaoGuoKaiShiYingYongShiProcedure;
import net.mcreator.mountainspoem.procedures.CrazyDangXiaoGuoJieShuProcedure;

public class CrazyMobEffect extends MobEffect {
	public CrazyMobEffect() {
		super(MobEffectCategory.HARMFUL, -15859455);
	}

	@Override
	public void addAttributeModifiers(LivingEntity entity, AttributeMap attributeMap, int amplifier) {
		CrazyDangYaoShuiXiaoGuoKaiShiYingYongShiProcedure.execute(entity);
	}

	@Override
	public void applyEffectTick(LivingEntity entity, int amplifier) {
		CrazyXiaoGuoChiXuShiMeiKeFaShengProcedure.execute(entity);
	}

	@Override
	public void removeAttributeModifiers(LivingEntity entity, AttributeMap attributeMap, int amplifier) {
		super.removeAttributeModifiers(entity, attributeMap, amplifier);
		CrazyDangXiaoGuoJieShuProcedure.execute(entity);
	}

	@Override
	public boolean isDurationEffectTick(int duration, int amplifier) {
		return true;
	}
}
