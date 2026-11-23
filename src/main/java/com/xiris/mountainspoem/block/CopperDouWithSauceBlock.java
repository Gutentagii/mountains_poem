package com.xiris.mountainspoem.block;

import com.xiris.mountainspoem.MountainsPoemMod;
import com.xiris.mountainspoem.block.entity.CopperDouWithSauceBlockEntity;
import com.xiris.mountainspoem.init.MountainsPoemModBlocks;
import com.xiris.mountainspoem.init.MountainsPoemModSounds;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.minecraftforge.common.util.FakePlayerFactory;

import java.util.function.Supplier;

public class CopperDouWithSauceBlock extends HorizontalDirectionalBlock implements EntityBlock {
    public static final IntegerProperty LAYER = IntegerProperty.create("layer", 0, 2);
    private final Supplier<Item> rice;
    private final Supplier<Item> manTou;

    public CopperDouWithSauceBlock(Supplier<Item> rice, Supplier<Item> manTou) {
        super(BlockBehaviour.Properties.of().sound(SoundType.METAL).strength(3f, 6f).friction(0.7f).noOcclusion().isRedstoneConductor((bs, br, bp) -> false));
        this.rice = rice;
        this.manTou = manTou;
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
        return Shapes.or(box(1.5, 0, 1.5, 14.5, 1, 14.5), box(4.5, 1, 4.5, 11.5, 7, 11.5), box(1.5, 7, 1.5, 14.5, 14, 14.5));
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(FACING, LAYER);
    }

    @Override
    public BlockState getStateForPlacement(BlockPlaceContext context) {
        return this.defaultBlockState().setValue(FACING, context.getHorizontalDirection().getOpposite());
    }

    @Override
    public InteractionResult use(BlockState blockstate, Level world, BlockPos pos, Player entity, InteractionHand hand, BlockHitResult hit) {
        int layer = blockstate.getValue(LAYER);
        BlockPos pos1 = pos;

        entity.swing(hand, true);

        if (layer == 2)
            world.setBlock(pos1, MountainsPoemModBlocks.COPPER_DOU.get().defaultBlockState().setValue(FACING, blockstate.getValue(FACING)), 3);
        else
            world.setBlock(pos1, blockstate.setValue(LAYER, layer + 1), 3);

        ItemStack held = entity.getItemInHand(hand);


        if (held.is(ItemTags.create(ResourceLocation.fromNamespaceAndPath("forge","cooked_rice")))) {
            playSound(world, pos, MountainsPoemModSounds.MEAT_SAUCE.get(), 1, 1);
            held.shrink(1);
            if (!world.isClientSide)
                spawnItem((ServerLevel) world, pos, this.rice.get());
        }

        else if (held.is(ItemTags.create(ResourceLocation.fromNamespaceAndPath(MountainsPoemMod.MOD_ID, "mantou")))) {
            playSound(world, pos, MountainsPoemModSounds.MEAT_SAUCE.get(), 1, 1);
            held.shrink(1);
            if (!world.isClientSide)
                spawnItem((ServerLevel) world, pos, this.manTou.get());
        }

        else {
            playSound(world, pos, SoundEvents.GENERIC_EAT, 1, 1);
            if (entity.getFoodData() != null) {
                entity.getFoodData().setFoodLevel(entity.getFoodData().getFoodLevel() + 5);
                entity.getFoodData().setSaturation(entity.getFoodData().getSaturationLevel() + 3);
            }
        }

        return InteractionResult.SUCCESS;
    }

    private void playSound(Level level, BlockPos pos, SoundEvent sound, float volume, float pitch) {
        if (!level.isClientSide) {
            level.playSound(
                    FakePlayerFactory.getMinecraft((ServerLevel) level),
                    pos,
                    sound,
                    SoundSource.PLAYERS,
                    volume,
                    pitch
            );
        }
    }


    private void spawnItem(ServerLevel level, BlockPos pos, Item item) {
        double x = pos.getX() + 0.5;
        double y = pos.getY() + 0.5;
        double z = pos.getZ() + 0.5;
        ItemEntity itemEntity = new ItemEntity(level, x, y, z, new ItemStack(item));
        level.addFreshEntity(itemEntity);
    }

    @Override
    public MenuProvider getMenuProvider(BlockState state, Level worldIn, BlockPos pos) {
        BlockEntity tileEntity = worldIn.getBlockEntity(pos);
        return tileEntity instanceof MenuProvider menuProvider ? menuProvider : null;
    }

    @Override
    public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
        return new CopperDouWithSauceBlockEntity(pos, state);
    }

    @Override
    public boolean triggerEvent(BlockState state, Level world, BlockPos pos, int eventID, int eventParam) {
        super.triggerEvent(state, world, pos, eventID, eventParam);
        BlockEntity blockEntity = world.getBlockEntity(pos);
        return blockEntity != null && blockEntity.triggerEvent(eventID, eventParam);
    }
}