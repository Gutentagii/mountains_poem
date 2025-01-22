package net.mcreator.mountainspoem.procedures;

import net.mcreator.mountainspoem.init.MountainsPoemModItems;

public class LeiDangShiTiSiWangShiProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		if (Math.random() < 0.1) {
			if (world instanceof ServerLevel _level) {
				ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, new ItemStack(MountainsPoemModItems.LEI_TEETH.get()));
				entityToSpawn.setPickUpDelay(0);
				entityToSpawn.setUnlimitedLifetime();
				_level.addFreshEntity(entityToSpawn);
			}
		}
	}
}
