
package net.mcreator.mountainspoem.block;

import net.mcreator.mountainspoem.procedures.CarnelianBlockFangKuaiBeiWanJiaPoPiShiProcedure;

public class CarnelianBlockBlock extends Block {
	public CarnelianBlockBlock() {
		super(BlockBehaviour.Properties.of().instrument(NoteBlockInstrument.BASEDRUM).sound(SoundType.STONE).strength(2.5f, 15f).requiresCorrectToolForDrops());
	}

	@Override
	public int getLightBlock(BlockState state, BlockGetter worldIn, BlockPos pos) {
		return 15;
	}

	@Override
	public boolean onDestroyedByPlayer(BlockState blockstate, Level world, BlockPos pos, Player entity, boolean willHarvest, FluidState fluid) {
		boolean retval = super.onDestroyedByPlayer(blockstate, world, pos, entity, willHarvest, fluid);
		CarnelianBlockFangKuaiBeiWanJiaPoPiShiProcedure.execute(entity);
		return retval;
	}

	@Override
	public void setPlacedBy(Level world, BlockPos pos, BlockState blockstate, LivingEntity entity, ItemStack itemstack) {
		super.setPlacedBy(world, pos, blockstate, entity, itemstack);
		CarnelianBlockFangKuaiBeiWanJiaPoPiShiProcedure.execute(entity);
	}
}
