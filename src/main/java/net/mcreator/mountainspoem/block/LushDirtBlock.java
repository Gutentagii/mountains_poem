
package net.mcreator.mountainspoem.block;

import net.mcreator.mountainspoem.procedures.LushDirtFangKuaiBeiWanJiaPoPiShiProcedure;

public class LushDirtBlock extends Block {
	public LushDirtBlock() {
		super(BlockBehaviour.Properties.of().sound(SoundType.GRAVEL).strength(1f, 9f));
	}

	@Override
	public int getLightBlock(BlockState state, BlockGetter worldIn, BlockPos pos) {
		return 15;
	}

	@Override
	public boolean onDestroyedByPlayer(BlockState blockstate, Level world, BlockPos pos, Player entity, boolean willHarvest, FluidState fluid) {
		boolean retval = super.onDestroyedByPlayer(blockstate, world, pos, entity, willHarvest, fluid);
		LushDirtFangKuaiBeiWanJiaPoPiShiProcedure.execute(world, pos.getX(), pos.getY(), pos.getZ());
		return retval;
	}
}
