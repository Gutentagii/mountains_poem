package net.mcreator.mountainspoem.procedures;

public class JinyuJadeWuPinZaiShouShangShiMeiKeFaShengProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
			_entity.addEffect(new MobEffectInstance(MobEffects.LUCK, 1, 1, false, false));
	}
}
