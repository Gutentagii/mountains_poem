package net.mcreator.mountainspoem.procedures;

public class CopperDaggerAxeShiTiBeiGongJuJiZhongShiProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if (Math.random() < 0.4) {
			if (entity.getType().is(TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation("minecraft:undead")))) {
				if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
					_entity.addEffect(new MobEffectInstance(MobEffects.HEAL, Mth.nextInt(RandomSource.create(), 1, 8), 0));
			} else {
				if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
					_entity.addEffect(new MobEffectInstance(MobEffects.HARM, Mth.nextInt(RandomSource.create(), 1, 8), 0));
			}
		}
		if (Math.random() < 0.3) {
			entity.hurt(new DamageSource(world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(DamageTypes.PLAYER_ATTACK)), Mth.nextInt(RandomSource.create(), 2, 5));
			if (world instanceof ServerLevel _level)
				_level.sendParticles(ParticleTypes.CRIT, x, y, z, 8, 1, 1, 1, 1);
		}
	}
}
