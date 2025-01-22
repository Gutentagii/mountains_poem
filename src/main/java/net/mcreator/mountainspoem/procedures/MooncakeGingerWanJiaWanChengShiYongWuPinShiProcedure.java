package net.mcreator.mountainspoem.procedures;

public class MooncakeGingerWanJiaWanChengShiYongWuPinShiProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
			_entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 100, 0));
	}
}
