
package net.mcreator.mountainspoem.block;

import net.mcreator.mountainspoem.init.MountainsPoemModBlocks;

public class WutiaoGrassBlock extends FlowerBlock {
	public WutiaoGrassBlock() {
		super(() -> MobEffects.DIG_SLOWDOWN, 100, BlockBehaviour.Properties.of().mapColor(MapColor.PLANT).sound(SoundType.GRASS).instabreak().noOcclusion().dynamicShape().offsetType(BlockBehaviour.OffsetType.XZ).pushReaction(PushReaction.DESTROY));
	}

	@Override
	public VoxelShape getShape(BlockState state, BlockGetter world, BlockPos pos, CollisionContext context) {
		Vec3 offset = state.getOffset(world, pos);
		return box(0, 0, 0, 16, 4.2, 16).move(offset.x, offset.y, offset.z);
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
		return groundState.is(Blocks.PACKED_MUD) || groundState.is(Blocks.GRASS_BLOCK) || groundState.is(Blocks.DIRT) || groundState.is(MountainsPoemModBlocks.LUSH_GRASS_BLOCK.get()) || groundState.is(MountainsPoemModBlocks.LUSH_DIRT.get())
				|| groundState.is(Blocks.PODZOL);
	}

	@Override
	public boolean canSurvive(BlockState blockstate, LevelReader worldIn, BlockPos pos) {
		BlockPos blockpos = pos.below();
		BlockState groundState = worldIn.getBlockState(blockpos);
		return this.mayPlaceOn(groundState, worldIn, blockpos);
	}
}
