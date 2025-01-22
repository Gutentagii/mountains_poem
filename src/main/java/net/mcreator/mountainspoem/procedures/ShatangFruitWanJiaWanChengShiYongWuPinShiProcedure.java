package net.mcreator.mountainspoem.procedures;

import net.mcreator.mountainspoem.init.MountainsPoemModMobEffects;

public class ShatangFruitWanJiaWanChengShiYongWuPinShiProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
			_entity.addEffect(new MobEffectInstance(MountainsPoemModMobEffects.BUOYANCY.get(), 600, 0, false, false));
	}
}
