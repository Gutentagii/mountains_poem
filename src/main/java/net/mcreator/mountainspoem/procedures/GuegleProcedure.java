package net.mcreator.mountainspoem.procedures;

import net.mcreator.mountainspoem.entity.GuEagleEntity;

public class GuegleProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if (world.getBiome(BlockPos.containing(x, y, z)).is(new ResourceLocation("snowy_plains"))) {
			if (entity instanceof GuEagleEntity animatable)
				animatable.setTexture("gu_diao_2");
		}
		if (world.getBiome(BlockPos.containing(x, y, z)).is(new ResourceLocation("old_growth_pine_taiga"))) {
			if (entity instanceof GuEagleEntity animatable)
				animatable.setTexture("gu_diao_3");
		}
		if (world.getBiome(BlockPos.containing(x, y, z)).is(new ResourceLocation("taiga"))) {
			if (entity instanceof GuEagleEntity animatable)
				animatable.setTexture("gu_diao_3");
		}
	}
}
