package net.mcreator.mountainspoem.procedures;

import net.mcreator.mountainspoem.init.MountainsPoemModItems;

public class PureedRongGrassTuberShiTiHuiDongWuPinShiProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, ItemStack itemstack) {
		if (Math.random() < 0.2) {
			itemstack.shrink(1);
			if (world instanceof ServerLevel _level) {
				ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, new ItemStack(MountainsPoemModItems.RONG_GRASS_TUBER.get()));
				entityToSpawn.setPickUpDelay(0);
				entityToSpawn.setUnlimitedLifetime();
				_level.addFreshEntity(entityToSpawn);
			}
			world.levelEvent(2001, BlockPos.containing(x, y, z), Block.getId(Blocks.MUD.defaultBlockState()));
		}
	}
}
