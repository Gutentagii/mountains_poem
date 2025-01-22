
package net.mcreator.mountainspoem.block;

public class UnderIronOreBlock extends Block {
	public UnderIronOreBlock() {
		super(BlockBehaviour.Properties.of().sound(SoundType.METAL).strength(3.05f, 10f));
	}

	@Override
	public int getLightBlock(BlockState state, BlockGetter worldIn, BlockPos pos) {
		return 15;
	}
}
