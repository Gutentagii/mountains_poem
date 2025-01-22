package net.mcreator.mountainspoem.procedures;

public class DehydrationXiaoGuoChiXuShiMeiKeFaShengProcedure {
	public static void execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		entity.hurt(new DamageSource(world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(DamageTypes.GENERIC)), (float) 0.5);
	}
}
