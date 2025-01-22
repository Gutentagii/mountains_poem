
package net.mcreator.mountainspoem.block;

public class NewjiangFenceGateBlock extends FenceGateBlock {
	public NewjiangFenceGateBlock() {
		super(BlockBehaviour.Properties.of().ignitedByLava().instrument(NoteBlockInstrument.BASS).sound(SoundType.WOOD).strength(8f, 10f).dynamicShape().forceSolidOn(), WoodType.OAK);
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
