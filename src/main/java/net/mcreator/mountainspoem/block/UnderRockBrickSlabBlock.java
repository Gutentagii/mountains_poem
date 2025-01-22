
package net.mcreator.mountainspoem.block;

public class UnderRockBrickSlabBlock extends SlabBlock {
	public UnderRockBrickSlabBlock() {
		super(BlockBehaviour.Properties.of().instrument(NoteBlockInstrument.BASEDRUM).sound(SoundType.STONE).strength(5f, 10f).requiresCorrectToolForDrops().dynamicShape());
	}
}
