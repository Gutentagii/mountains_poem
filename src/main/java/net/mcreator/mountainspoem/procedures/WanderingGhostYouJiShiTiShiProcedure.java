package net.mcreator.mountainspoem.procedures;

import net.mcreator.mountainspoem.entity.WanderingGhostEntity;

public class WanderingGhostYouJiShiTiShiProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, Entity sourceentity) {
		if (entity == null || sourceentity == null)
			return;
		if ((((WanderingGhostEntity) entity).animationprocedure).equals("beg")) {
			if ((sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem().isEdible()) {
				if (sourceentity instanceof LivingEntity _entity)
					_entity.swing(InteractionHand.MAIN_HAND, true);
				if (entity instanceof LivingEntity _entity) {
					ItemStack _setstack = (sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).copy();
					_setstack.setCount(1);
					_entity.setItemInHand(InteractionHand.OFF_HAND, _setstack);
					if (_entity instanceof Player _player)
						_player.getInventory().setChanged();
				}
				(sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).shrink(1);
				if (entity instanceof WanderingGhostEntity) {
					((WanderingGhostEntity) entity).setAnimation("thank");
				}
				if (Math.random() < 0.3) {
					if (entity instanceof TamableAnimal _toTame && sourceentity instanceof Player _owner)
						_toTame.tame(_owner);
					if (world instanceof ServerLevel _level)
						_level.sendParticles(ParticleTypes.HEART, x, y, z, 5, 2, 2, 2, 1);
				}
			}
		}
	}
}
