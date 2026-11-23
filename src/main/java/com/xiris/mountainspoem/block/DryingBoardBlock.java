package com.xiris.mountainspoem.block;

import com.xiris.mountainspoem.init.MountainsPoemModItems;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.HorizontalDirectionalBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;

public class DryingBoardBlock extends HorizontalDirectionalBlock {
    public static final IntegerProperty BLOCKSTATE = IntegerProperty.create("blockstate", 0, 3);

    public DryingBoardBlock() {
        super(BlockBehaviour.Properties.of()
                .ignitedByLava()
                .instrument(NoteBlockInstrument.BASS)
                .sound(SoundType.WOOD)
                .strength(1.5f, 15f)
                .lightLevel(s -> 0)
                .noOcclusion()
                .isRedstoneConductor((bs, br, bp) -> false)
        );
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
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(FACING, BLOCKSTATE);
    }

    @Override
    public BlockState getStateForPlacement(BlockPlaceContext context) {
        return this.defaultBlockState().setValue(FACING, context.getHorizontalDirection().getOpposite());
    }

    @Override
    public InteractionResult use(BlockState blockstate, Level world, BlockPos pos, Player entity, InteractionHand hand, BlockHitResult hit) {
        int currentState = blockstate.getValue(BLOCKSTATE);

        if (currentState == 3 && !world.isClientSide) {
            spawnItem((ServerLevel) world, pos, Items.PAPER);
            spawnItem((ServerLevel) world, pos, Items.PAPER);
            spawnItem((ServerLevel) world, pos, Items.PAPER);
            world.setBlock(pos, blockstate.setValue(BLOCKSTATE, 0), 3);
            return InteractionResult.SUCCESS;
        }

        if (currentState == 0) {
            ItemStack held = entity.getItemInHand(hand);

            if (held.is(MountainsPoemModItems.WOODEN_MESH_WITH_PAPER_PULP.get())) {
                held.shrink(1);
                if (!entity.getInventory().add(new ItemStack(MountainsPoemModItems.WOODEN_MESH.get())))
                    entity.drop(new ItemStack(MountainsPoemModItems.WOODEN_MESH.get()), false);

                startDrying(world, pos);
                return InteractionResult.SUCCESS;
            }

            if (held.is(MountainsPoemModItems.BAMBOO_MESH_WITH_PAPER_PULP.get())) {
                held.shrink(1);
                if (!entity.getInventory().add(new ItemStack(MountainsPoemModItems.BAMBOO_MESH.get())))
                    entity.drop(new ItemStack(MountainsPoemModItems.BAMBOO_MESH.get()), false);

                startDrying(world, pos);
                return InteractionResult.SUCCESS;
            }
        }

        return InteractionResult.PASS;
    }

    private void startDrying(Level world, BlockPos pos) {
        if (world.isClientSide) return;

        ServerLevel serverLevel = (ServerLevel) world;
        BlockState initial = world.getBlockState(pos).setValue(BLOCKSTATE, 1);
        world.setBlock(pos, initial, 3);

        serverLevel.scheduleTick(pos, this, 40);
    }

    @Override
    public void tick(BlockState state, ServerLevel world, BlockPos pos, net.minecraft.util.RandomSource rand) {
        int current = state.getValue(BLOCKSTATE);
        if (current == 1) {
            world.setBlock(pos, state.setValue(BLOCKSTATE, 2), 3);
            world.scheduleTick(pos, this, 40);
        }
        if (current == 2) {
            world.setBlock(pos, state.setValue(BLOCKSTATE, 3), 3);
        }
    }

    private void spawnItem(ServerLevel level, BlockPos pos, net.minecraft.world.item.Item item) {
        double x = pos.getX() + 0.5;
        double y = pos.getY() + 0.5;
        double z = pos.getZ() + 0.5;
        ItemEntity itemEntity = new ItemEntity(level, x, y, z, new ItemStack(item));
        level.addFreshEntity(itemEntity);
    }
}