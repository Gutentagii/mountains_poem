package net.mcreator.mountainspoem.procedures;

import net.mcreator.mountainspoem.entity.LeiEntity;

public class LeidedonghuawengjianProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if (world.getBiome(BlockPos.containing(x, y, z)).is(new ResourceLocation("mountains_poem:shatang_forest"))) {
			if (entity instanceof LeiEntity animatable)
				animatable.setTexture("lei_lion_4");
		}
	}
}
