package net.mcreator.mountainspoem.procedures;

public class StoneDanSheWuJiZhongShiTiShiProcedure {
	public static void execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		if (entity.getType().is(TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation("mountains_poem:stone_damage_immune"))) == false) {
			entity.hurt(new DamageSource(world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(ResourceKey.create(Registries.DAMAGE_TYPE, new ResourceLocation("mountains_poem:stone_throw")))),
					Mth.nextInt(RandomSource.create(), 1, 3));
			if (entity.getType().is(TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation("minecraft:skeletons")))) {
				if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
					_entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 100, 2));
				if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
					_entity.addEffect(new MobEffectInstance(MobEffects.WEAKNESS, 100, 2));
			}
		}
	}
}
