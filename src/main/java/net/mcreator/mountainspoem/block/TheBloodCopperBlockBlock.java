
package net.mcreator.mountainspoem.block;

public class TheBloodCopperBlockBlock extends Block {
	public TheBloodCopperBlockBlock() {
		super(BlockBehaviour.Properties.of().sound(SoundType.METAL).strength(3f, 25f).requiresCorrectToolForDrops());
	}

	@Override
	public int getLightBlock(BlockState state, BlockGetter worldIn, BlockPos pos) {
		return 15;
	}
}
