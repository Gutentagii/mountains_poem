
package net.mcreator.mountainspoem.block;

public class NewjiangleaveBlock extends LeavesBlock {
	public NewjiangleaveBlock() {
		super(BlockBehaviour.Properties.of().ignitedByLava().sound(SoundType.AZALEA_LEAVES).strength(1f, 10f).noOcclusion());
	}

	@Override
	public int getLightBlock(BlockState state, BlockGetter worldIn, BlockPos pos) {
		return 1;
	}
}
