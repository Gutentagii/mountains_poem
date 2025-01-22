
package net.mcreator.mountainspoem.block;

import net.mcreator.mountainspoem.procedures.CopperDouLeiMeatSauceYouJiFangKuaiShiProcedure;
import net.mcreator.mountainspoem.block.entity.CopperDouLeiMeatSauceBlockEntity;

public class CopperDouLeiMeatSauceBlock extends Block implements EntityBlock {
	public static final IntegerProperty BLOCKSTATE = IntegerProperty.create("blockstate", 0, 2);
	public static final DirectionProperty FACING = HorizontalDirectionalBlock.FACING;

	public CopperDouLeiMeatSauceBlock() {
		super(BlockBehaviour.Properties.of().sound(SoundType.METAL).strength(3f, 6f).lightLevel(s -> (new Object() {
			public int getLightLevel() {
				if (s.getValue(BLOCKSTATE) == 1)
					return 0;
				if (s.getValue(BLOCKSTATE) == 2)
					return 0;
				return 0;
			}
		}.getLightLevel())).friction(0.7f).noOcclusion().isRedstoneConductor((bs, br, bp) -> false));
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
		if (state.getValue(BLOCKSTATE) == 1) {
			return switch (state.getValue(FACING)) {
				default -> Shapes.or(box(1.5, 0, 1.5, 14.5, 1, 14.5), box(4.5, 1, 4.5, 11.5, 7, 11.5), box(1.5, 7, 1.5, 14.5, 14, 14.5));
				case NORTH -> Shapes.or(box(1.5, 0, 1.5, 14.5, 1, 14.5), box(4.5, 1, 4.5, 11.5, 7, 11.5), box(1.5, 7, 1.5, 14.5, 14, 14.5));
				case EAST -> Shapes.or(box(1.5, 0, 1.5, 14.5, 1, 14.5), box(4.5, 1, 4.5, 11.5, 7, 11.5), box(1.5, 7, 1.5, 14.5, 14, 14.5));
				case WEST -> Shapes.or(box(1.5, 0, 1.5, 14.5, 1, 14.5), box(4.5, 1, 4.5, 11.5, 7, 11.5), box(1.5, 7, 1.5, 14.5, 14, 14.5));
			};
		}
		if (state.getValue(BLOCKSTATE) == 2) {
			return switch (state.getValue(FACING)) {
				default -> Shapes.or(box(1.5, 0, 1.5, 14.5, 1, 14.5), box(4.5, 1, 4.5, 11.5, 7, 11.5), box(1.5, 7, 1.5, 14.5, 14, 14.5));
				case NORTH -> Shapes.or(box(1.5, 0, 1.5, 14.5, 1, 14.5), box(4.5, 1, 4.5, 11.5, 7, 11.5), box(1.5, 7, 1.5, 14.5, 14, 14.5));
				case EAST -> Shapes.or(box(1.5, 0, 1.5, 14.5, 1, 14.5), box(4.5, 1, 4.5, 11.5, 7, 11.5), box(1.5, 7, 1.5, 14.5, 14, 14.5));
				case WEST -> Shapes.or(box(1.5, 0, 1.5, 14.5, 1, 14.5), box(4.5, 1, 4.5, 11.5, 7, 11.5), box(1.5, 7, 1.5, 14.5, 14, 14.5));
			};
		}
		return switch (state.getValue(FACING)) {
			default -> Shapes.or(box(1.5, 0, 1.5, 14.5, 1, 14.5), box(4.5, 1, 4.5, 11.5, 7, 11.5), box(1.5, 7, 1.5, 14.5, 14, 14.5));
			case NORTH -> Shapes.or(box(1.5, 0, 1.5, 14.5, 1, 14.5), box(4.5, 1, 4.5, 11.5, 7, 11.5), box(1.5, 7, 1.5, 14.5, 14, 14.5));
			case EAST -> Shapes.or(box(1.5, 0, 1.5, 14.5, 1, 14.5), box(4.5, 1, 4.5, 11.5, 7, 11.5), box(1.5, 7, 1.5, 14.5, 14, 14.5));
			case WEST -> Shapes.or(box(1.5, 0, 1.5, 14.5, 1, 14.5), box(4.5, 1, 4.5, 11.5, 7, 11.5), box(1.5, 7, 1.5, 14.5, 14, 14.5));
		};
	}

	@Override
	protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
		builder.add(FACING, BLOCKSTATE);
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
	public InteractionResult use(BlockState blockstate, Level world, BlockPos pos, Player entity, InteractionHand hand, BlockHitResult hit) {
		super.use(blockstate, world, pos, entity, hand, hit);
		int x = pos.getX();
		int y = pos.getY();
		int z = pos.getZ();
		double hitX = hit.getLocation().x;
		double hitY = hit.getLocation().y;
		double hitZ = hit.getLocation().z;
		Direction direction = hit.getDirection();
		CopperDouLeiMeatSauceYouJiFangKuaiShiProcedure.execute(world, x, y, z, blockstate, entity);
		return InteractionResult.SUCCESS;
	}

	@Override
	public MenuProvider getMenuProvider(BlockState state, Level worldIn, BlockPos pos) {
		BlockEntity tileEntity = worldIn.getBlockEntity(pos);
		return tileEntity instanceof MenuProvider menuProvider ? menuProvider : null;
	}

	@Override
	public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
		return new CopperDouLeiMeatSauceBlockEntity(pos, state);
	}

	@Override
	public boolean triggerEvent(BlockState state, Level world, BlockPos pos, int eventID, int eventParam) {
		super.triggerEvent(state, world, pos, eventID, eventParam);
		BlockEntity blockEntity = world.getBlockEntity(pos);
		return blockEntity == null ? false : blockEntity.triggerEvent(eventID, eventParam);
	}
}
