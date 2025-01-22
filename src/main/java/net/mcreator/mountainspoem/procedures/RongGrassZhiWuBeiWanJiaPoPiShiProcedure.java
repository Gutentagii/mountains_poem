package net.mcreator.mountainspoem.procedures;

import net.mcreator.mountainspoem.init.MountainsPoemModEntities;

public class RongGrassZhiWuBeiWanJiaPoPiShiProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		if (Math.random() < 0.05) {
			if (world instanceof ServerLevel _level) {
				Entity entityToSpawn = MountainsPoemModEntities.WOOD_WORMS.get().spawn(_level, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
				if (entityToSpawn != null) {
					entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
				}
			}
		}
	}
}
