package net.mcreator.mountainspoem.procedures;

import net.mcreator.mountainspoem.MountainsPoemMod;

public class BuoyancyXiaoGuoChiXuShiMeiKeFaShengProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if ((world.getFluidState(BlockPos.containing(x, y, z)).createLegacyBlock()).is(BlockTags.create(new ResourceLocation("minecraft:water_block")))) {
			MountainsPoemMod.queueServerWork(20, () -> {
				entity.setDeltaMovement(new Vec3(0, 1, 0));
			});
		}
	}
}
