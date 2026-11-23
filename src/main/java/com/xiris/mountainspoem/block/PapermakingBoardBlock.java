package com.xiris.mountainspoem.block;

import com.xiris.mountainspoem.init.MountainsPoemModItems;
import net.minecraft.core.BlockPos;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;

public class PapermakingBoardBlock extends Block {
    public static final BooleanProperty BLOCKSTATE = BooleanProperty.create("blockstate");

    public PapermakingBoardBlock() {
        super(BlockBehaviour.Properties.of()
                .ignitedByLava()
                .instrument(NoteBlockInstrument.BASS)
                .sound(SoundType.WOOD)
                .strength(1.5f, 15f)
                .lightLevel(s -> 0)
                .noOcclusion()
                .isRedstoneConductor((bs, br, bp) -> false)
        );

        this.registerDefaultState(this.stateDefinition.any().setValue(BLOCKSTATE, false));
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
        return box(0, 0, 0, 16, 2, 16);
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(BLOCKSTATE);
    }

    @Override
    public InteractionResult use(BlockState state, Level world, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hit) {
        if (!world.isClientSide()) {
            boolean isActive = state.getValue(BLOCKSTATE);

            if (isActive) {
                ItemStack stack = player.getItemInHand(hand);

                if (stack.is(MountainsPoemModItems.WOODEN_MESH.get())) {
                    stack.shrink(1);
                    world.setBlock(pos, state.setValue(BLOCKSTATE, false), 3);
                    player.getInventory().placeItemBackInInventory(new ItemStack(MountainsPoemModItems.WOODEN_MESH_WITH_PAPER_PULP.get()));
                }
                if (stack.is(MountainsPoemModItems.BAMBOO_MESH.get())) {
                    stack.shrink(1);
                    world.setBlock(pos, state.setValue(BLOCKSTATE, false), 3);
                    player.getInventory().placeItemBackInInventory(new ItemStack(MountainsPoemModItems.BAMBOO_MESH_WITH_PAPER_PULP.get()));
                }
            }
        }

        return InteractionResult.SUCCESS;
    }
}