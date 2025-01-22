
package net.mcreator.mountainspoem.block;

import net.mcreator.mountainspoem.procedures.DirtWithRongGrassTubersGuFenChengGongShiYongShiProcedure;

public class DirtWithRongGrassTubersBlock extends Block implements BonemealableBlock {
	public DirtWithRongGrassTubersBlock() {
		super(BlockBehaviour.Properties.of().sound(SoundType.GRAVEL).strength(1f, 5f));
	}

	@Override
	public int getLightBlock(BlockState state, BlockGetter worldIn, BlockPos pos) {
		return 15;
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
		DirtWithRongGrassTubersGuFenChengGongShiYongShiProcedure.execute(world, pos.getX(), pos.getY(), pos.getZ());
	}
}
