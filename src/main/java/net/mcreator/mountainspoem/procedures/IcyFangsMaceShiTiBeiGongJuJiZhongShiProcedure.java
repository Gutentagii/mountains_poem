package net.mcreator.mountainspoem.procedures;

import net.mcreator.mountainspoem.init.MountainsPoemModParticleTypes;
import net.mcreator.mountainspoem.init.MountainsPoemModEntities;

public class IcyFangsMaceShiTiBeiGongJuJiZhongShiProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if (Math.random() < 0.7) {
			if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
				_entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 600, 3));
			if (world instanceof ServerLevel _level)
				_level.sendParticles((SimpleParticleType) (MountainsPoemModParticleTypes.ICE.get()), x, y, z, 5, 1, 1, 1, 1);
		}
		if (entity.getType().is(TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation("minecraft:skeletons")))) {
			entity.hurt(new DamageSource(world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(DamageTypes.MAGIC)), 5);
			if (world instanceof ServerLevel _level) {
				Entity entityToSpawn = MountainsPoemModEntities.SOUL_SHARD.get().spawn(_level, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
				if (entityToSpawn != null) {
					entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
				}
			}
		}
		if (entity.getType().is(TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation("minecraft:freeze_hurts_extra_types")))) {
			entity.hurt(new DamageSource(world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(DamageTypes.MAGIC)), 5);
		}
		entity.setTicksFrozen(300);
		entity.setDeltaMovement(new Vec3(0, 0.6, 0));
	}
}
