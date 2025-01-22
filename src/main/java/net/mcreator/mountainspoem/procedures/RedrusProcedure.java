package net.mcreator.mountainspoem.procedures;

import net.mcreator.mountainspoem.entity.RedRuWarmoceanEntity;

public class RedrusProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if (world.getBiome(BlockPos.containing(x, y, z)).is(new ResourceLocation("lush_caves"))) {
			if (entity instanceof RedRuWarmoceanEntity animatable)
				animatable.setTexture("red_ru_common_2");
		}
		if (world.getBiome(BlockPos.containing(x, y, z)).is(new ResourceLocation("lukewarm_ocean"))) {
			if (entity instanceof RedRuWarmoceanEntity animatable)
				animatable.setTexture("red_ru_common_2");
		}
		if (world.getBiome(BlockPos.containing(x, y, z)).is(new ResourceLocation("deep_lukewarm_ocean"))) {
			if (entity instanceof RedRuWarmoceanEntity animatable)
				animatable.setTexture("red_ru_common_2");
		}
	}
}
