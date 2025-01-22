
package net.mcreator.mountainspoem.block;

public class UnderRockWallBlock extends WallBlock {
	public UnderRockWallBlock() {
		super(BlockBehaviour.Properties.of().instrument(NoteBlockInstrument.BASEDRUM).sound(SoundType.STONE).strength(5f, 10f).requiresCorrectToolForDrops().dynamicShape().forceSolidOn());
	}
}
