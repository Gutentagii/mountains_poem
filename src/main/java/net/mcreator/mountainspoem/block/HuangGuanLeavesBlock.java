
package net.mcreator.mountainspoem.block;

import net.mcreator.mountainspoem.init.MountainsPoemModBlocks;

public class HuangGuanLeavesBlock extends LeavesBlock {
	public HuangGuanLeavesBlock() {
		super(BlockBehaviour.Properties.of().ignitedByLava().sound(SoundType.GRASS).strength(0.3f).noOcclusion());
	}

	@Override
	public int getLightBlock(BlockState state, BlockGetter worldIn, BlockPos pos) {
		return 1;
	}

	@Override
	public int getFlammability(BlockState state, BlockGetter world, BlockPos pos, Direction face) {
		return 45;
	}

	@Override
	public BlockPathTypes getBlockPathType(BlockState state, BlockGetter world, BlockPos pos, Mob entity) {
		return BlockPathTypes.LEAVES;
	}

	@OnlyIn(Dist.CLIENT)
	public static void blockColorLoad(BlockEvent.RegisterColorHandlersEvent event) {
		event.getBlockColors().register((bs, world, pos, index) -> {
			return world != null && pos != null ? BiomeColors.getAverageFoliageColor(world, pos) : FoliageColor.getDefaultColor();
		}, MountainsPoemModBlocks.HUANG_GUAN_LEAVES.get());
	}

	@OnlyIn(Dist.CLIENT)
	public static void itemColorLoad(RegisterColorHandlersEvent.Item event) {
		event.getItemColors().register((stack, index) -> {
			return FoliageColor.getDefaultColor();
		}, MountainsPoemModBlocks.HUANG_GUAN_LEAVES.get());
	}
}
