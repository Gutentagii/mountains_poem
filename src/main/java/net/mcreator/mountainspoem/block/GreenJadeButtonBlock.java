
package net.mcreator.mountainspoem.block;

public class GreenJadeButtonBlock extends ButtonBlock {
	public GreenJadeButtonBlock() {
		super(BlockBehaviour.Properties.of().instrument(NoteBlockInstrument.HAT).sound(SoundType.GLASS).strength(1.15f, 10f).lightLevel(s -> 1).noOcclusion().hasPostProcess((bs, br, bp) -> true).emissiveRendering((bs, br, bp) -> true)
				.isRedstoneConductor((bs, br, bp) -> false).dynamicShape(), BlockSetType.STONE, 20, false);
	}

	@Override
	public int getLightBlock(BlockState state, BlockGetter worldIn, BlockPos pos) {
		return 0;
	}
}
