
package net.mcreator.mountainspoem.block;

public class UnderGrassBlockBlock extends Block {
	public UnderGrassBlockBlock() {
		super(BlockBehaviour.Properties.of().instrument(NoteBlockInstrument.BASEDRUM).sound(SoundType.WET_GRASS).strength(1.25f, 10f));
	}

	@Override
	public int getLightBlock(BlockState state, BlockGetter worldIn, BlockPos pos) {
		return 15;
	}
}
