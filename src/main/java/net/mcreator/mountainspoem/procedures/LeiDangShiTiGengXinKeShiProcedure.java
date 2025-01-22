package net.mcreator.mountainspoem.procedures;

import net.mcreator.mountainspoem.entity.LeiEntity;

public class LeiDangShiTiGengXinKeShiProcedure {
	public static void execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		if ((((LeiEntity) entity).animationprocedure).equals("idle")) {
			if (Math.random() < 0.2) {
				if (entity instanceof LeiEntity) {
					((LeiEntity) entity).setAnimation("play");
				}
			}
			if (Math.random() < 0.2 && (world instanceof Level _lvl2 && _lvl2.isDay()) == false) {
				if (entity instanceof LeiEntity) {
					((LeiEntity) entity).setAnimation("hello");
				}
			}
			if (entity.isSprinting() == true) {
				if (entity instanceof LeiEntity) {
					((LeiEntity) entity).setAnimation("sprint");
				}
			}
		}
		if ((entity instanceof LeiEntity animatable ? animatable.getTexture() : "null").equals("lei_lion_5") || (entity instanceof LeiEntity animatable ? animatable.getTexture() : "null").equals("lei_lion_2")) {
			if (entity instanceof LivingEntity _entity)
				_entity.setHealth((float) ((entity instanceof LivingEntity _livEnt ? _livEnt.getMaxHealth() : -1) + 10));
			if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
				_entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 3, 2, false, false));
		}
		if (entity.isInWater()) {
			if ((entity instanceof LeiEntity animatable ? animatable.getTexture() : "null").equals("lei_lion_2")) {
				if (entity instanceof LeiEntity animatable)
					animatable.setTexture("lei_lion");
			}
			if ((entity instanceof LeiEntity animatable ? animatable.getTexture() : "null").equals("lei_lion_5")) {
				if (entity instanceof LeiEntity animatable)
					animatable.setTexture("lei_lion_4");
			}
		}
		if (Math.random() < 0.1) {
			if (Math.random() < 0.1) {
				if ((entity instanceof LeiEntity animatable ? animatable.getTexture() : "null").equals("lei_lion_6") && Math.random() < 0.6) {
					if (entity instanceof LeiEntity animatable)
						animatable.setTexture("lei_lion_4");
				}
				if ((entity instanceof LeiEntity animatable ? animatable.getTexture() : "null").equals("lei_lion_3") && Math.random() < 0.6) {
					if (entity instanceof LeiEntity animatable)
						animatable.setTexture("lei_lion");
				}
			}
		}
	}
}
