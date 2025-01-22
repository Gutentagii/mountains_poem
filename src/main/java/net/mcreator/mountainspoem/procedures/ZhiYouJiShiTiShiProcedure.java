package net.mcreator.mountainspoem.procedures;

import net.mcreator.mountainspoem.entity.ZhiEntity;

public class ZhiYouJiShiTiShiProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, Entity sourceentity) {
		if (entity == null || sourceentity == null)
			return;
		if ((entity instanceof ZhiEntity animatable ? animatable.getTexture() : "null").equals("zhi")
				&& (sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).is(ItemTags.create(new ResourceLocation("mountains_poem:zhi_foods"))) && entity instanceof LivingEntity _livEnt3
				&& _livEnt3.hasEffect(MobEffects.MOVEMENT_SLOWDOWN) && entity instanceof LivingEntity _livEnt4 && _livEnt4.hasEffect(MobEffects.BLINDNESS)) {
			if (sourceentity instanceof LivingEntity _entity)
				_entity.swing(InteractionHand.MAIN_HAND, true);
			(sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).shrink(1);
			if (Math.random() > 0.2) {
				if (entity instanceof TamableAnimal _toTame && sourceentity instanceof Player _owner)
					_toTame.tame(_owner);
				if (entity instanceof ZhiEntity animatable)
					animatable.setTexture("zhi_2");
				if (world instanceof ServerLevel _level)
					_level.sendParticles(ParticleTypes.HEART, x, y, z, 5, 0.5, 0.5, 0.5, 1);
				if (sourceentity instanceof ServerPlayer _player) {
					Advancement _adv = _player.server.getAdvancements().getAdvancement(new ResourceLocation("mountains_poem:my_old_friend"));
					AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
					if (!_ap.isDone()) {
						for (String criteria : _ap.getRemainingCriteria())
							_player.getAdvancements().award(_adv, criteria);
					}
				}
			} else {
				if (world instanceof ServerLevel _level)
					_level.sendParticles(ParticleTypes.LARGE_SMOKE, x, y, z, 10, 0.5, 0.5, 0.5, 1);
			}
		}
	}
}
