
package net.mcreator.mountainspoem.potion;

import net.mcreator.mountainspoem.procedures.NocturnalJourneymanXiaoGuoChiXuShiMeiKeFaShengProcedure;
import net.mcreator.mountainspoem.procedures.NocturnalJourneymanDangXiaoGuoJieShuProcedure;

public class NocturnalJourneymanMobEffect extends MobEffect {
	public NocturnalJourneymanMobEffect() {
		super(MobEffectCategory.BENEFICIAL, -1257);
	}

	@Override
	public void applyEffectTick(LivingEntity entity, int amplifier) {
		NocturnalJourneymanXiaoGuoChiXuShiMeiKeFaShengProcedure.execute(entity);
	}

	@Override
	public void removeAttributeModifiers(LivingEntity entity, AttributeMap attributeMap, int amplifier) {
		super.removeAttributeModifiers(entity, attributeMap, amplifier);
		NocturnalJourneymanDangXiaoGuoJieShuProcedure.execute(entity.level(), entity.getX(), entity.getY(), entity.getZ(), entity);
	}

	@Override
	public boolean isDurationEffectTick(int duration, int amplifier) {
		return true;
	}
}
