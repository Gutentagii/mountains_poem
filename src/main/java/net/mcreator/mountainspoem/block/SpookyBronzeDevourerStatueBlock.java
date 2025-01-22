
package net.mcreator.mountainspoem.block;

import net.mcreator.mountainspoem.procedures.SpookyBronzeDevourerStatueFangKuaiBeiWanJiaPoPiShiProcedure;

public class SpookyBronzeDevourerStatueBlock extends FallingBlock {
	public static final DirectionProperty FACING = HorizontalDirectionalBlock.FACING;

	public SpookyBronzeDevourerStatueBlock() {
		super(BlockBehaviour.Properties.of().sound(SoundType.METAL).strength(3f, 15f).noOcclusion().isRedstoneConductor((bs, br, bp) -> false));
		this.registerDefaultState(this.stateDefinition.any().setValue(FACING, Direction.NORTH));
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
		return switch (state.getValue(FACING)) {
			default -> box(0, 0, 0, 16, 24, 16);
			case NORTH -> box(0, 0, 0, 16, 24, 16);
			case EAST -> box(0, 0, 0, 16, 24, 16);
			case WEST -> box(0, 0, 0, 16, 24, 16);
		};
	}

	@Override
	protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
		builder.add(FACING);
	}

	@Override
	public BlockState getStateForPlacement(BlockPlaceContext context) {
		return this.defaultBlockState().setValue(FACING, context.getHorizontalDirection().getOpposite());
	}

	public BlockState rotate(BlockState state, Rotation rot) {
		return state.setValue(FACING, rot.rotate(state.getValue(FACING)));
	}

	public BlockState mirror(BlockState state, Mirror mirrorIn) {
		return state.rotate(mirrorIn.getRotation(state.getValue(FACING)));
	}

	@Override
	public boolean onDestroyedByPlayer(BlockState blockstate, Level world, BlockPos pos, Player entity, boolean willHarvest, FluidState fluid) {
		boolean retval = super.onDestroyedByPlayer(blockstate, world, pos, entity, willHarvest, fluid);
		SpookyBronzeDevourerStatueFangKuaiBeiWanJiaPoPiShiProcedure.execute(world, pos.getX(), pos.getY(), pos.getZ());
		return retval;
	}
}
