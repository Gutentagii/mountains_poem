
package net.mcreator.mountainspoem.block;

public class YanPressurePlateBlock extends PressurePlateBlock {
	public YanPressurePlateBlock() {
		super(Sensitivity.EVERYTHING, BlockBehaviour.Properties.of().ignitedByLava().instrument(NoteBlockInstrument.BASS).sound(SoundType.WOOD).strength(2.2f, 3.3f).dynamicShape().forceSolidOn(), BlockSetType.OAK);
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
