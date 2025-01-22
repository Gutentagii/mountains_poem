package net.mcreator.mountainspoem.procedures;

import net.mcreator.mountainspoem.entity.RedRuWarmoceanEntity;

public class Redru3Procedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		entity.setAirSupply(400);
		if (world.getBiome(BlockPos.containing(x, y, z)).is(new ResourceLocation("mountains_poem:deleted_mod_element"))) {
			if (entity instanceof RedRuWarmoceanEntity animatable)
				animatable.setTexture("red_ru_hot");
		}
		if (world.getBiome(BlockPos.containing(x, y, z)).is(new ResourceLocation("swamp"))) {
			if (entity instanceof RedRuWarmoceanEntity animatable)
				animatable.setTexture("red_ru_hot");
		}
		if (world.getBiome(BlockPos.containing(x, y, z)).is(new ResourceLocation("mangrove_swamp"))) {
			if (entity instanceof RedRuWarmoceanEntity animatable)
				animatable.setTexture("red_ru_hot_2");
		}
		if (world.getBiome(BlockPos.containing(x, y, z)).is(new ResourceLocation("lush_caves"))) {
			if (entity instanceof RedRuWarmoceanEntity animatable)
				animatable.setTexture("red_ru_common_2");
		}
		if (world.getBiome(BlockPos.containing(x, y, z)).is(new ResourceLocation("lukewarm_ocean"))) {
			if (entity instanceof RedRuWarmoceanEntity animatable)
				animatable.setTexture("red_ru_common_3");
		}
		if (world.getBiome(BlockPos.containing(x, y, z)).is(new ResourceLocation("deep_lukewarm_ocean"))) {
			if (entity instanceof RedRuWarmoceanEntity animatable)
				animatable.setTexture("red_ru_common_3");
		}
		if (world.getBiome(BlockPos.containing(x, y, z)).is(new ResourceLocation("frozen_river"))) {
			if (entity instanceof RedRuWarmoceanEntity animatable)
				animatable.setTexture("red_ru_cold_2");
		}
		if (world.getBiome(BlockPos.containing(x, y, z)).is(new ResourceLocation("frozen_peaks"))) {
			if (entity instanceof RedRuWarmoceanEntity animatable)
				animatable.setTexture("red_ru_cold_2");
		}
		if (world.getBiome(BlockPos.containing(x, y, z)).is(new ResourceLocation("deep_cold_ocean"))) {
			if (entity instanceof RedRuWarmoceanEntity animatable)
				animatable.setTexture("red_ru_cold_2");
		}
		if (world.getBiome(BlockPos.containing(x, y, z)).is(new ResourceLocation("deep_frozen_ocean"))) {
			if (entity instanceof RedRuWarmoceanEntity animatable)
				animatable.setTexture("red_ru_cold_3");
		}
		if (world.getBiome(BlockPos.containing(x, y, z)).is(new ResourceLocation("frozen_ocean"))) {
			if (entity instanceof RedRuWarmoceanEntity animatable)
				animatable.setTexture("red_ru_cold_3");
		}
		if (world.getBiome(BlockPos.containing(x, y, z)).is(new ResourceLocation("cold_ocean"))) {
			if (entity instanceof RedRuWarmoceanEntity animatable)
				animatable.setTexture("red_ru_cold_2");
		}
		if (world.getBiome(BlockPos.containing(x, y, z)).is(new ResourceLocation("snowy_plains"))) {
			if (entity instanceof RedRuWarmoceanEntity animatable)
				animatable.setTexture("red_ru_cold");
		}
	}
}
