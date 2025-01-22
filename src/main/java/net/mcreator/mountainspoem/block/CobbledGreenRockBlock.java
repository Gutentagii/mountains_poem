
package net.mcreator.mountainspoem.block;

public class CobbledGreenRockBlock extends Block {
	public CobbledGreenRockBlock() {
		super(BlockBehaviour.Properties.of().instrument(NoteBlockInstrument.BASEDRUM).sound(SoundType.STONE).strength(1.5f, 12f));
	}

	@Override
	public int getLightBlock(BlockState state, BlockGetter worldIn, BlockPos pos) {
		return 15;
	}
}
