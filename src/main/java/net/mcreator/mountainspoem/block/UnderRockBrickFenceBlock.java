
package net.mcreator.mountainspoem.block;

public class UnderRockBrickFenceBlock extends FenceBlock {
	public UnderRockBrickFenceBlock() {
		super(BlockBehaviour.Properties.of().instrument(NoteBlockInstrument.BASEDRUM).sound(SoundType.STONE).strength(5f, 10f).requiresCorrectToolForDrops().dynamicShape().forceSolidOn());
	}
}
