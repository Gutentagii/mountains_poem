package net.mcreator.mountainspoem.procedures;

import net.mcreator.mountainspoem.init.MountainsPoemModMobEffects;

public class PlagueHornShiTiBeiGaiWuPinJiZhongShiProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
			_entity.addEffect(new MobEffectInstance(MountainsPoemModMobEffects.PESTILENCE.get(), 60, 1));
	}
}
