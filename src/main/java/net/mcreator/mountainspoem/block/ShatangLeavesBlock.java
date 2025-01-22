
package net.mcreator.mountainspoem.block;

import net.mcreator.mountainspoem.procedures.ShatangLeavesGuFenChengGongShiYongShiProcedure;

public class ShatangLeavesBlock extends LeavesBlock implements BonemealableBlock {
	public ShatangLeavesBlock() {
		super(BlockBehaviour.Properties.of().ignitedByLava().sound(SoundType.GRASS).strength(0.5f).noOcclusion());
	}

	@Override
	public int getLightBlock(BlockState state, BlockGetter worldIn, BlockPos pos) {
		return 1;
	}

	@Override
	public int getFlammability(BlockState state, BlockGetter world, BlockPos pos, Direction face) {
		return 75;
	}

	@Override
	public boolean isValidBonemealTarget(LevelReader worldIn, BlockPos pos, BlockState blockstate, boolean clientSide) {
		return true;
	}

	@Override
	public boolean isBonemealSuccess(Level world, RandomSource random, BlockPos pos, BlockState blockstate) {
		return true;
	}

	@Override
	public void performBonemeal(ServerLevel world, RandomSource random, BlockPos pos, BlockState blockstate) {
		ShatangLeavesGuFenChengGongShiYongShiProcedure.execute(world, pos.getX(), pos.getY(), pos.getZ());
	}
}
