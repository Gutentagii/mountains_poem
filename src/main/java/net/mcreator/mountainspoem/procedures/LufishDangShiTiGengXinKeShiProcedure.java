package net.mcreator.mountainspoem.procedures;

public class LufishDangShiTiGengXinKeShiProcedure {
	public static void execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		if (entity.isInWaterOrBubble()) {
			entity.clearFire();
		} else {
			entity.hurt(new DamageSource(world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(DamageTypes.DRY_OUT)), (float) 0.1);
		}
	}
}
