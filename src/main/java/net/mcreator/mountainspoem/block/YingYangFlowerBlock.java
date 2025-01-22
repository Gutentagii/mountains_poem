
package net.mcreator.mountainspoem.block;

import net.mcreator.mountainspoem.init.MountainsPoemModBlocks;

public class YingYangFlowerBlock extends DoublePlantBlock {
	public YingYangFlowerBlock() {
		super(BlockBehaviour.Properties.of().mapColor(MapColor.PLANT).sound(SoundType.GRASS).strength(1f, 1f).hasPostProcess((bs, br, bp) -> true).emissiveRendering((bs, br, bp) -> true).lightLevel(s -> 3).noCollission()
				.offsetType(BlockBehaviour.OffsetType.XZ).pushReaction(PushReaction.DESTROY));
	}

	@Override
	public int getFlammability(BlockState state, BlockGetter world, BlockPos pos, Direction face) {
		return 100;
	}

	@Override
	public int getFireSpreadSpeed(BlockState state, BlockGetter world, BlockPos pos, Direction face) {
		return 60;
	}

	@Override
	public boolean mayPlaceOn(BlockState groundState, BlockGetter worldIn, BlockPos pos) {
		return groundState.is(MountainsPoemModBlocks.SANGUINE_SAND.get()) || groundState.is(MountainsPoemModBlocks.UNDER_GRASS_BLOCK.get()) || groundState.is(MountainsPoemModBlocks.UNDER_DIRT.get()) || groundState.is(Blocks.NETHERRACK)
				|| groundState.is(Blocks.CRIMSON_NYLIUM) || groundState.is(Blocks.WARPED_NYLIUM) || groundState.is(MountainsPoemModBlocks.SANGUINE_SOIL.get());
	}

	@Override
	public boolean canSurvive(BlockState blockstate, LevelReader worldIn, BlockPos pos) {
		BlockPos blockpos = pos.below();
		BlockState groundState = worldIn.getBlockState(blockpos);
		if (blockstate.getValue(HALF) == DoubleBlockHalf.UPPER)
			return groundState.is(this) && groundState.getValue(HALF) == DoubleBlockHalf.LOWER;
		else
			return this.mayPlaceOn(groundState, worldIn, blockpos);
	}

	@Override
	public PlantType getPlantType(BlockGetter world, BlockPos pos) {
		return PlantType.NETHER;
	}
}
