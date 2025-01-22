package net.mcreator.mountainspoem.procedures;

import net.mcreator.mountainspoem.entity.HuHorseEntity;

public class HuHorseDangWanJiaYuGaiShiTiFaShengPengZhuangShiProcedure {
	public static void execute(LevelAccessor world, Entity entity, Entity sourceentity) {
		if (entity == null || sourceentity == null)
			return;
		if (entity instanceof HuHorseEntity == false && (entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null) == sourceentity) {
			entity.lookAt(EntityAnchorArgument.Anchor.EYES, new Vec3((sourceentity.getX()), (sourceentity.getY()), (sourceentity.getZ())));
			sourceentity.hurt(new DamageSource(world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(ResourceKey.create(Registries.DAMAGE_TYPE, new ResourceLocation("mountains_poem:bump")))), 3);
			if (entity instanceof HuHorseEntity) {
				((HuHorseEntity) entity).setAnimation("crash");
			}
			sourceentity.setDeltaMovement(new Vec3(0, 1, 0));
			{
				Entity _ent = sourceentity;
				_ent.setYRot(0);
				_ent.setXRot(180);
				_ent.setYBodyRot(_ent.getYRot());
				_ent.setYHeadRot(_ent.getYRot());
				_ent.yRotO = _ent.getYRot();
				_ent.xRotO = _ent.getXRot();
				if (_ent instanceof LivingEntity _entity) {
					_entity.yBodyRotO = _entity.getYRot();
					_entity.yHeadRotO = _entity.getYRot();
				}
			}
			if (sourceentity instanceof ServerPlayer _player) {
				Advancement _adv = _player.server.getAdvancements().getAdvancement(new ResourceLocation("mountains_poem:bumped_by_a_water_horse"));
				AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
				if (!_ap.isDone()) {
					for (String criteria : _ap.getRemainingCriteria())
						_player.getAdvancements().award(_adv, criteria);
				}
			}
		}
	}
}
