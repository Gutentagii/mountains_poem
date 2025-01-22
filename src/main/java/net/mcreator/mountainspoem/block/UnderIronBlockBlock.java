
package net.mcreator.mountainspoem.block;

public class UnderIronBlockBlock extends Block {
	public UnderIronBlockBlock() {
		super(BlockBehaviour.Properties.of().sound(SoundType.METAL).strength(2.5f, 10f).requiresCorrectToolForDrops());
	}

	@Override
	public int getLightBlock(BlockState state, BlockGetter worldIn, BlockPos pos) {
		return 15;
	}
}
