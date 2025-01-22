package net.mcreator.mountainspoem.procedures;

public class SuffocateXiaoGuoChiXuShiMeiKeFaShengProcedure {
	public static void execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		if ((entity instanceof LivingEntity _livEnt0 && _livEnt0.hasEffect(MobEffects.WATER_BREATHING)) == false) {
			entity.hurt(new DamageSource(world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(ResourceKey.create(Registries.DAMAGE_TYPE, new ResourceLocation("mountains_poem:hanging")))), (float) 0.5);
		}
	}
}
