package net.mcreator.mountainspoem.procedures;

import net.mcreator.mountainspoem.entity.WoodWormsEntity;

public class WoodwormssProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if (world.getBiome(BlockPos.containing(x, y, z)).is(new ResourceLocation("mountains_poem:yanforest"))) {
			if (entity instanceof WoodWormsEntity animatable)
				animatable.setTexture("wood_worms_1");
		}
		if (world.getBiome(BlockPos.containing(x, y, z)).is(new ResourceLocation("mountains_poem:newjiangforest"))) {
			if (entity instanceof WoodWormsEntity animatable)
				animatable.setTexture("wood_worms_2");
		}
		if (world.getBiome(BlockPos.containing(x, y, z)).is(new ResourceLocation("mountains_poem:huang_guan_forest"))) {
			if (entity instanceof WoodWormsEntity animatable)
				animatable.setTexture("wood_worms_3");
		}
		if (world.getBiome(BlockPos.containing(x, y, z)).is(new ResourceLocation("mountains_poem:pan_forest"))) {
			if (entity instanceof WoodWormsEntity animatable)
				animatable.setTexture("wood_worms_4");
		}
		if (world.getBiome(BlockPos.containing(x, y, z)).is(new ResourceLocation("mountains_poem:peach_blossom_forest"))) {
			if (entity instanceof WoodWormsEntity animatable)
				animatable.setTexture("wood_worms_5");
		}
		if (world.getBiome(BlockPos.containing(x, y, z)).is(new ResourceLocation("mountains_poem:shatang_forest"))) {
			if (entity instanceof WoodWormsEntity animatable)
				animatable.setTexture("wood_worms_6");
		}
		if (world.getBiome(BlockPos.containing(x, y, z)).is(new ResourceLocation("savanna"))) {
			if (entity instanceof WoodWormsEntity animatable)
				animatable.setTexture("wood_worms_7");
		}
		if (world.getBiome(BlockPos.containing(x, y, z)).is(new ResourceLocation("savanna_plateau"))) {
			if (entity instanceof WoodWormsEntity animatable)
				animatable.setTexture("wood_worms_7");
		}
		if (world.getBiome(BlockPos.containing(x, y, z)).is(new ResourceLocation("windswept_savanna"))) {
			if (entity instanceof WoodWormsEntity animatable)
				animatable.setTexture("wood_worms_7");
		}
		if (world.getBiome(BlockPos.containing(x, y, z)).is(new ResourceLocation("birch_forest"))) {
			if (entity instanceof WoodWormsEntity animatable)
				animatable.setTexture("wood_worms_8");
		}
		if (world.getBiome(BlockPos.containing(x, y, z)).is(new ResourceLocation("old_growth_birch_forest"))) {
			if (entity instanceof WoodWormsEntity animatable)
				animatable.setTexture("wood_worms_8");
		}
		if (world.getBiome(BlockPos.containing(x, y, z)).is(new ResourceLocation("cherry_grove"))) {
			if (entity instanceof WoodWormsEntity animatable)
				animatable.setTexture("wood_worms_9");
		}
		if (world.getBiome(BlockPos.containing(x, y, z)).is(new ResourceLocation("crimson_forest"))) {
			if (entity instanceof WoodWormsEntity animatable)
				animatable.setTexture("wood_worms_10");
		}
		if (world.getBiome(BlockPos.containing(x, y, z)).is(new ResourceLocation("dark_forest"))) {
			if (entity instanceof WoodWormsEntity animatable)
				animatable.setTexture("wood_worms_11");
		}
		if (world.getBiome(BlockPos.containing(x, y, z)).is(new ResourceLocation("desert"))) {
			if (entity instanceof WoodWormsEntity animatable)
				animatable.setTexture("wood_worms_12");
		}
		if (world.getBiome(BlockPos.containing(x, y, z)).is(new ResourceLocation("bamboo_jungle"))) {
			if (entity instanceof WoodWormsEntity animatable)
				animatable.setTexture("wood_worms_18");
		}
		if (world.getBiome(BlockPos.containing(x, y, z)).is(new ResourceLocation("jungle"))) {
			if (entity instanceof WoodWormsEntity animatable)
				animatable.setTexture("wood_worms_13");
		}
		if (world.getBiome(BlockPos.containing(x, y, z)).is(new ResourceLocation("sparse_jungle"))) {
			if (entity instanceof WoodWormsEntity animatable)
				animatable.setTexture("wood_worms_13");
		}
		if (world.getBiome(BlockPos.containing(x, y, z)).is(new ResourceLocation("forest"))) {
			if (entity instanceof WoodWormsEntity animatable)
				animatable.setTexture("wood_worms_14");
		}
		if (world.getBiome(BlockPos.containing(x, y, z)).is(new ResourceLocation("flower_forest"))) {
			if (entity instanceof WoodWormsEntity animatable)
				animatable.setTexture("wood_worms_14");
		}
		if (world.getBiome(BlockPos.containing(x, y, z)).is(new ResourceLocation("swamp"))) {
			if (entity instanceof WoodWormsEntity animatable)
				animatable.setTexture("wood_worms_14");
		}
		if (world.getBiome(BlockPos.containing(x, y, z)).is(new ResourceLocation("taiga"))) {
			if (entity instanceof WoodWormsEntity animatable)
				animatable.setTexture("wood_worms_15");
		}
		if (world.getBiome(BlockPos.containing(x, y, z)).is(new ResourceLocation("snowy_taiga"))) {
			if (entity instanceof WoodWormsEntity animatable)
				animatable.setTexture("wood_worms_15");
		}
		if (world.getBiome(BlockPos.containing(x, y, z)).is(new ResourceLocation("old_growth_pine_taiga"))) {
			if (entity instanceof WoodWormsEntity animatable)
				animatable.setTexture("wood_worms_15");
		}
		if (world.getBiome(BlockPos.containing(x, y, z)).is(new ResourceLocation("old_growth_spruce_taiga"))) {
			if (entity instanceof WoodWormsEntity animatable)
				animatable.setTexture("wood_worms_15");
		}
		if (world.getBiome(BlockPos.containing(x, y, z)).is(new ResourceLocation("warped_forest"))) {
			if (entity instanceof WoodWormsEntity animatable)
				animatable.setTexture("wood_worms_16");
		}
		if (world.getBiome(BlockPos.containing(x, y, z)).is(new ResourceLocation("badlands"))) {
			if (entity instanceof WoodWormsEntity animatable)
				animatable.setTexture("wood_worms_17");
		}
		if (world.getBiome(BlockPos.containing(x, y, z)).is(new ResourceLocation("eroded_badlands"))) {
			if (entity instanceof WoodWormsEntity animatable)
				animatable.setTexture("wood_worms_17");
		}
		if (world.getBiome(BlockPos.containing(x, y, z)).is(new ResourceLocation("wooded_badlands"))) {
			if (entity instanceof WoodWormsEntity animatable)
				animatable.setTexture("wood_worms_14");
		}
		if (world.getBiome(BlockPos.containing(x, y, z)).is(new ResourceLocation("plains"))) {
			if (entity instanceof WoodWormsEntity animatable)
				animatable.setTexture("wood_worms_14");
		}
		if (world.getBiome(BlockPos.containing(x, y, z)).is(new ResourceLocation("snowy_plains"))) {
			if (entity instanceof WoodWormsEntity animatable)
				animatable.setTexture("wood_worms_15");
		}
		if (world.getBiome(BlockPos.containing(x, y, z)).is(new ResourceLocation("end_barrens"))) {
			if (entity instanceof WoodWormsEntity animatable)
				animatable.setTexture("wood_worms_19");
		}
		if (world.getBiome(BlockPos.containing(x, y, z)).is(new ResourceLocation("the_end"))) {
			if (entity instanceof WoodWormsEntity animatable)
				animatable.setTexture("wood_worms_19");
		}
		if (world.getBiome(BlockPos.containing(x, y, z)).is(new ResourceLocation("end_highlands"))) {
			if (entity instanceof WoodWormsEntity animatable)
				animatable.setTexture("wood_worms_19");
		}
		if (world.getBiome(BlockPos.containing(x, y, z)).is(new ResourceLocation("mangrove_swamp"))) {
			if (entity instanceof WoodWormsEntity animatable)
				animatable.setTexture("wood_worms_20");
		}
		if (world.getBiome(BlockPos.containing(x, y, z)).is(new ResourceLocation("mountains_poem:jianmei_bamboo_jungle"))) {
			if (entity instanceof WoodWormsEntity animatable)
				animatable.setTexture("wood_worms_18");
		}
	}
}
