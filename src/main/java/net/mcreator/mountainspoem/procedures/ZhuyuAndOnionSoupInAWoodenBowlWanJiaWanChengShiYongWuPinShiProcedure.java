package net.mcreator.mountainspoem.procedures;

public class ZhuyuAndOnionSoupInAWoodenBowlWanJiaWanChengShiYongWuPinShiProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
			_entity.addEffect(new MobEffectInstance(MobEffects.SATURATION, 6000, 1));
	}
}
