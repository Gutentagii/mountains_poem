
package net.mcreator.mountainspoem.block;

import net.mcreator.mountainspoem.init.MountainsPoemModBlocks;

public class UnderGrassBlock extends FlowerBlock {
	public UnderGrassBlock() {
		super(() -> MobEffects.DARKNESS, 100, BlockBehaviour.Properties.of().mapColor(MapColor.PLANT).sound(SoundType.GRASS).strength(1f, 1f).noCollission().replaceable().offsetType(BlockBehaviour.OffsetType.XZ).pushReaction(PushReaction.DESTROY));
	}

	@Override
	public int getEffectDuration() {
		return 100;
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
				|| groundState.is(Blocks.CRIMSON_NYLIUM) || groundState.is(Blocks.WARPED_NYLIUM);
	}

	@Override
	public boolean canSurvive(BlockState blockstate, LevelReader worldIn, BlockPos pos) {
		BlockPos blockpos = pos.below();
		BlockState groundState = worldIn.getBlockState(blockpos);
		return this.mayPlaceOn(groundState, worldIn, blockpos);
	}

	@Override
	public PlantType getPlantType(BlockGetter world, BlockPos pos) {
		return PlantType.NETHER;
	}
}
