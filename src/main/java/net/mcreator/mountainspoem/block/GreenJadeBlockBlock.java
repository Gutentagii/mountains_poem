
package net.mcreator.mountainspoem.block;

public class GreenJadeBlockBlock extends Block {
	public GreenJadeBlockBlock() {
		super(BlockBehaviour.Properties.of().sound(SoundType.STONE).strength(2f, 0.1f));
	}

	@Override
	public int getLightBlock(BlockState state, BlockGetter worldIn, BlockPos pos) {
		return 15;
	}
}
