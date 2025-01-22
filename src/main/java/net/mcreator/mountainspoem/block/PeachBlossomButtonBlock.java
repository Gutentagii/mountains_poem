
package net.mcreator.mountainspoem.block;

public class PeachBlossomButtonBlock extends ButtonBlock {
	public PeachBlossomButtonBlock() {
		super(BlockBehaviour.Properties.of().ignitedByLava().instrument(NoteBlockInstrument.BASS).sound(SoundType.WOOD).strength(1.8f, 2.7f).dynamicShape(), BlockSetType.OAK, 30, true);
	}

	@Override
	public int getLightBlock(BlockState state, BlockGetter worldIn, BlockPos pos) {
		return 0;
	}

	@Override
	public int getFlammability(BlockState state, BlockGetter world, BlockPos pos, Direction face) {
		return 5;
	}
}
