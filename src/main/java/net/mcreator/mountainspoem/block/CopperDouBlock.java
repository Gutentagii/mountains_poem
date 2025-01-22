
package net.mcreator.mountainspoem.block;

public class CopperDouBlock extends Block {
	public static final DirectionProperty FACING = HorizontalDirectionalBlock.FACING;

	public CopperDouBlock() {
		super(BlockBehaviour.Properties.of().sound(SoundType.METAL).strength(3f, 6f).friction(0.7f).noOcclusion().isRedstoneConductor((bs, br, bp) -> false));
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
			default -> Shapes.or(box(1.5, 0, 1.5, 14.5, 1, 14.5), box(4.5, 1, 4.5, 11.5, 7, 11.5), box(1.5, 7, 1.5, 14.5, 18, 14.5));
			case NORTH -> Shapes.or(box(1.5, 0, 1.5, 14.5, 1, 14.5), box(4.5, 1, 4.5, 11.5, 7, 11.5), box(1.5, 7, 1.5, 14.5, 18, 14.5));
			case EAST -> Shapes.or(box(1.5, 0, 1.5, 14.5, 1, 14.5), box(4.5, 1, 4.5, 11.5, 7, 11.5), box(1.5, 7, 1.5, 14.5, 18, 14.5));
			case WEST -> Shapes.or(box(1.5, 0, 1.5, 14.5, 1, 14.5), box(4.5, 1, 4.5, 11.5, 7, 11.5), box(1.5, 7, 1.5, 14.5, 18, 14.5));
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
}
