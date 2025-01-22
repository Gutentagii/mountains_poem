package net.mcreator.mountainspoem.procedures;

import net.mcreator.mountainspoem.entity.WanderingGhostEntity;

public class WanderingGhostShiTiChuShiShengChengShiProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if (Math.random() < 0.3) {
			if (world.getBiome(BlockPos.containing(x, y, z)).value().getBaseTemperature() * 100f <= 0.15) {
				if (entity instanceof WanderingGhostEntity animatable)
					animatable.setTexture("wandering_ghost_3");
			} else {
				if (entity instanceof WanderingGhostEntity animatable)
					animatable.setTexture("wandering_ghost_2");
			}
		}
	}
}
