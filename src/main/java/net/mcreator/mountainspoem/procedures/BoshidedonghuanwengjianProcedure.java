package net.mcreator.mountainspoem.procedures;

import net.mcreator.mountainspoem.entity.BoshiGoatEntity;

public class BoshidedonghuanwengjianProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if (entity instanceof LivingEntity _livEnt0 && _livEnt0.isBaby() && world.getBiome(BlockPos.containing(x, y, z)).is(new ResourceLocation("soul_sand_valley"))) {
			if (Math.random() < 0.3) {
				if (entity instanceof BoshiGoatEntity animatable)
					animatable.setTexture("boshi_goat2");
			}
		}
	}
}
