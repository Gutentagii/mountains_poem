
package net.mcreator.mountainspoem.block;

public class YanButtonBlock extends ButtonBlock {
	public YanButtonBlock() {
		super(BlockBehaviour.Properties.of().ignitedByLava().instrument(NoteBlockInstrument.BASS).sound(SoundType.WOOD).strength(2.2f, 3.3f).dynamicShape(), BlockSetType.OAK, 30, true);
	}

	@Override
	public int getLightBlock(BlockState state, BlockGetter worldIn, BlockPos pos) {
		return 0;
	}

	@Override
	public int getFlammability(BlockState state, BlockGetter world, BlockPos pos, Direction face) {
		return 6;
	}
}
