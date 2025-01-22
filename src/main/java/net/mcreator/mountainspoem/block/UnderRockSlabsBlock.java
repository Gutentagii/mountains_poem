
package net.mcreator.mountainspoem.block;

public class UnderRockSlabsBlock extends SlabBlock {
	public UnderRockSlabsBlock() {
		super(BlockBehaviour.Properties.of().instrument(NoteBlockInstrument.BASEDRUM).sound(SoundType.STONE).strength(5f, 10f).requiresCorrectToolForDrops().dynamicShape());
	}
}
