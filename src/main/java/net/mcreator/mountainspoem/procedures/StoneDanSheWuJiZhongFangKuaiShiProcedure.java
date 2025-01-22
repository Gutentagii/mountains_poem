package net.mcreator.mountainspoem.procedures;

public class StoneDanSheWuJiZhongFangKuaiShiProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		if ((world.getBlockState(BlockPos.containing(x, y, z))).is(BlockTags.create(new ResourceLocation("mountains_poem:fragile_block")))) {
			if (Math.random() < 0.3) {
				world.destroyBlock(BlockPos.containing(x, y, z), false);
			}
		}
	}
}
