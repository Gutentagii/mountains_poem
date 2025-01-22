
package net.mcreator.mountainspoem.block;

import net.mcreator.mountainspoem.procedures.PeachBlossomLeavesDangYouXiKeGengXinShiProcedure;

public class PeachBlossomLeavesBlock extends LeavesBlock {
	public PeachBlossomLeavesBlock() {
		super(BlockBehaviour.Properties.of().ignitedByLava().sound(SoundType.GRASS).strength(0.18f).noOcclusion());
	}

	@Override
	public int getLightBlock(BlockState state, BlockGetter worldIn, BlockPos pos) {
		return 1;
	}

	@Override
	public int getFlammability(BlockState state, BlockGetter world, BlockPos pos, Direction face) {
		return 27;
	}

	@Override
	public void tick(BlockState blockstate, ServerLevel world, BlockPos pos, RandomSource random) {
		super.tick(blockstate, world, pos, random);
		int x = pos.getX();
		int y = pos.getY();
		int z = pos.getZ();
		PeachBlossomLeavesDangYouXiKeGengXinShiProcedure.execute(world, x, y, z);
	}
}
