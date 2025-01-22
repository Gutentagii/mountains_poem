package net.mcreator.mountainspoem.procedures;

import net.mcreator.mountainspoem.entity.XianGoatEntity;

public class XiangoatssProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if (world.getBiome(BlockPos.containing(x, y, z)).is(new ResourceLocation("savanna"))) {
			if (entity instanceof XianGoatEntity animatable)
				animatable.setTexture("xian_goat_2");
		}
		if (world.getBiome(BlockPos.containing(x, y, z)).is(new ResourceLocation("snowy_plains"))) {
			if (entity instanceof XianGoatEntity animatable)
				animatable.setTexture("xian_goat_3");
		}
		if (world.getBiome(BlockPos.containing(x, y, z)).is(new ResourceLocation("jagged_peaks"))) {
			if (entity instanceof XianGoatEntity animatable)
				animatable.setTexture("xian_goat_3");
		}
		if (world.getBiome(BlockPos.containing(x, y, z)).is(new ResourceLocation("snowy_slopes"))) {
			if (entity instanceof XianGoatEntity animatable)
				animatable.setTexture("xian_goat_3");
		}
		if (world.getBiome(BlockPos.containing(x, y, z)).is(new ResourceLocation("meadow"))) {
			if (entity instanceof XianGoatEntity animatable)
				animatable.setTexture("xian_goat_2");
		}
		if (world.getBiome(BlockPos.containing(x, y, z)).is(new ResourceLocation("jungle"))) {
			if (Math.random() < 0.7) {
				if (entity instanceof XianGoatEntity animatable)
					animatable.setTexture("xian_goat_4_b");
			} else {
				if (entity instanceof XianGoatEntity animatable)
					animatable.setTexture("xian_goat_4");
			}
		}
	}
}
