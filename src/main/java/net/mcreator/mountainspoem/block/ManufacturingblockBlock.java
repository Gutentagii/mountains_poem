
package net.mcreator.mountainspoem.block;

public class ManufacturingblockBlock extends Block {
	public ManufacturingblockBlock() {
		super(BlockBehaviour.Properties.of().sound(SoundType.METAL).strength(3f, 6f).lightLevel(s -> 5).requiresCorrectToolForDrops());
	}

	@Override
	public float[] getBeaconColorMultiplier(BlockState state, LevelReader world, BlockPos pos, BlockPos beaconPos) {
		return new float[]{1f, 0.4901960784f, 0.1450980392f};
	}

	@Override
	public int getLightBlock(BlockState state, BlockGetter worldIn, BlockPos pos) {
		return 15;
	}

	@Override
	public float getEnchantPowerBonus(BlockState state, LevelReader world, BlockPos pos) {
		return 0.5f;
	}
}
