
package net.mcreator.mountainspoem.block;

public class SanguineSoilBlock extends Block {
	public SanguineSoilBlock() {
		super(BlockBehaviour.Properties.of().sound(SoundType.GRAVEL).strength(1.5f, 25f).friction(0.7f).speedFactor(1.1f));
	}

	@Override
	public int getLightBlock(BlockState state, BlockGetter worldIn, BlockPos pos) {
		return 15;
	}
}
