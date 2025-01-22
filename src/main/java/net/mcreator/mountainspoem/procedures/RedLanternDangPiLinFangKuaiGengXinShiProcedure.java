package net.mcreator.mountainspoem.procedures;

public class RedLanternDangPiLinFangKuaiGengXinShiProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		if (world.isEmptyBlock(BlockPos.containing(x, y + 1, z)) && world.isEmptyBlock(BlockPos.containing(x, y - 1, z))) {
			{
				BlockPos _pos = BlockPos.containing(x, y, z);
				Block.dropResources(world.getBlockState(_pos), world, BlockPos.containing(x, y, z), null);
				world.destroyBlock(_pos, false);
			}
		}
	}
}
