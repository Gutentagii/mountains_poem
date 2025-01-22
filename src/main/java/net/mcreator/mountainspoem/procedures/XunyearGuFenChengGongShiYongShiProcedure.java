package net.mcreator.mountainspoem.procedures;

import net.mcreator.mountainspoem.init.MountainsPoemModBlocks;

public class XunyearGuFenChengGongShiYongShiProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		if (Math.random() < 0.7) {
			if (world.isEmptyBlock(BlockPos.containing(x, y + 1, z))) {
				world.setBlock(BlockPos.containing(x, y + 1, z), MountainsPoemModBlocks.XUN_LEAVES_BERRY.get().defaultBlockState(), 3);
			}
		}
	}
}
