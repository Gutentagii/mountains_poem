
package net.mcreator.mountainspoem.block;

public class ShatangFenceGateBlock extends FenceGateBlock {
	public ShatangFenceGateBlock() {
		super(BlockBehaviour.Properties.of().ignitedByLava().instrument(NoteBlockInstrument.BASS).sound(SoundType.WOOD).strength(5f, 7.5f).dynamicShape().forceSolidOn(), WoodType.OAK);
	}

	@Override
	public int getLightBlock(BlockState state, BlockGetter worldIn, BlockPos pos) {
		return 0;
	}

	@Override
	public int getFlammability(BlockState state, BlockGetter world, BlockPos pos, Direction face) {
		return 13;
	}
}
