package net.mcreator.mountainspoem.procedures;

import net.mcreator.mountainspoem.init.MountainsPoemModBlocks;

public class DirtWithRongGrassTubersGuFenChengGongShiYongShiProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		if (Math.random() < 0.7) {
			if (world.isEmptyBlock(BlockPos.containing(x, y + 1, z))) {
				world.setBlock(BlockPos.containing(x, y + 1, z), MountainsPoemModBlocks.RONG_GRASS.get().defaultBlockState(), 3);
			}
			if ((world.getBlockState(BlockPos.containing(x, y - 1, z))).is(BlockTags.create(new ResourceLocation("mountains_poem:rong_grass_replaceable")))) {
				world.setBlock(BlockPos.containing(x, y - 1, z), MountainsPoemModBlocks.DIRT_WITH_RONG_GRASS_TUBERS.get().defaultBlockState(), 3);
			}
		}
	}
}
