package net.mcreator.mountainspoem.procedures;

import net.mcreator.mountainspoem.init.MountainsPoemModBlocks;

public class RongGrassssProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, ItemStack itemstack) {
		if ((world.getBlockState(BlockPos.containing(x, y, z))).is(BlockTags.create(new ResourceLocation("minecraft:dirt")))) {
			if (world.isEmptyBlock(BlockPos.containing(x, y + 1, z))) {
				world.setBlock(BlockPos.containing(x, y + 1, z), MountainsPoemModBlocks.RONG_GRASS.get().defaultBlockState(), 3);
				itemstack.shrink(1);
			}
		}
	}
}
