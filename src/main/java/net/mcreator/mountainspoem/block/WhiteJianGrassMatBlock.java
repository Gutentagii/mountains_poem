
package net.mcreator.mountainspoem.block;

import net.mcreator.mountainspoem.procedures.WhiteJianGrassMatDangPiLinFangKuaiGengXinShiProcedure;

public class WhiteJianGrassMatBlock extends Block {
	public WhiteJianGrassMatBlock() {
		super(BlockBehaviour.Properties.of().ignitedByLava().sound(SoundType.MOSS_CARPET).strength(0.45f, 9.5f).noOcclusion().isRedstoneConductor((bs, br, bp) -> false));
	}

	@Override
	public boolean propagatesSkylightDown(BlockState state, BlockGetter reader, BlockPos pos) {
		return true;
	}

	@Override
	public int getLightBlock(BlockState state, BlockGetter worldIn, BlockPos pos) {
		return 0;
	}

	@Override
	public VoxelShape getVisualShape(BlockState state, BlockGetter world, BlockPos pos, CollisionContext context) {
		return Shapes.empty();
	}

	@Override
	public VoxelShape getShape(BlockState state, BlockGetter world, BlockPos pos, CollisionContext context) {
		return box(0, 0, 0, 16, 1, 16);
	}

	@Override
	public int getFlammability(BlockState state, BlockGetter world, BlockPos pos, Direction face) {
		return 6;
	}

	@Override
	public void neighborChanged(BlockState blockstate, Level world, BlockPos pos, Block neighborBlock, BlockPos fromPos, boolean moving) {
		super.neighborChanged(blockstate, world, pos, neighborBlock, fromPos, moving);
		WhiteJianGrassMatDangPiLinFangKuaiGengXinShiProcedure.execute(world, pos.getX(), pos.getY(), pos.getZ());
	}
}
