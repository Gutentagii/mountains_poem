
package net.mcreator.mountainspoem.block;

public class CopperSmallDingBlock extends Block implements SimpleWaterloggedBlock {
	public static final DirectionProperty FACING = HorizontalDirectionalBlock.FACING;
	public static final BooleanProperty WATERLOGGED = BlockStateProperties.WATERLOGGED;

	public CopperSmallDingBlock() {
		super(BlockBehaviour.Properties.of().sound(SoundType.METAL).strength(3f, 6f).noOcclusion().isRedstoneConductor((bs, br, bp) -> false));
		this.registerDefaultState(this.stateDefinition.any().setValue(FACING, Direction.NORTH).setValue(WATERLOGGED, false));
	}

	@Override
	public boolean propagatesSkylightDown(BlockState state, BlockGetter reader, BlockPos pos) {
		return state.getFluidState().isEmpty();
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
			default -> Shapes.or(box(2, 4, 2, 14, 13, 14), box(3.5, 0, 10.5, 5.5, 4, 12.5), box(10.5, 0, 10.5, 12.5, 4, 12.5), box(7, 0, 3, 9, 4, 5));
			case NORTH -> Shapes.or(box(2, 4, 2, 14, 13, 14), box(10.5, 0, 3.5, 12.5, 4, 5.5), box(3.5, 0, 3.5, 5.5, 4, 5.5), box(7, 0, 11, 9, 4, 13));
			case EAST -> Shapes.or(box(2, 4, 2, 14, 13, 14), box(10.5, 0, 10.5, 12.5, 4, 12.5), box(10.5, 0, 3.5, 12.5, 4, 5.5), box(3, 0, 7, 5, 4, 9));
			case WEST -> Shapes.or(box(2, 4, 2, 14, 13, 14), box(3.5, 0, 3.5, 5.5, 4, 5.5), box(3.5, 0, 10.5, 5.5, 4, 12.5), box(11, 0, 7, 13, 4, 9));
		};
	}

	@Override
	protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
		builder.add(FACING, WATERLOGGED);
	}

	@Override
	public BlockState getStateForPlacement(BlockPlaceContext context) {
		boolean flag = context.getLevel().getFluidState(context.getClickedPos()).getType() == Fluids.WATER;
		return this.defaultBlockState().setValue(FACING, context.getHorizontalDirection().getOpposite()).setValue(WATERLOGGED, flag);
	}

	public BlockState rotate(BlockState state, Rotation rot) {
		return state.setValue(FACING, rot.rotate(state.getValue(FACING)));
	}

	public BlockState mirror(BlockState state, Mirror mirrorIn) {
		return state.rotate(mirrorIn.getRotation(state.getValue(FACING)));
	}

	@Override
	public FluidState getFluidState(BlockState state) {
		return state.getValue(WATERLOGGED) ? Fluids.WATER.getSource(false) : super.getFluidState(state);
	}

	@Override
	public BlockState updateShape(BlockState state, Direction facing, BlockState facingState, LevelAccessor world, BlockPos currentPos, BlockPos facingPos) {
		if (state.getValue(WATERLOGGED)) {
			world.scheduleTick(currentPos, Fluids.WATER, Fluids.WATER.getTickDelay(world));
		}
		return super.updateShape(state, facing, facingState, world, currentPos, facingPos);
	}
}
