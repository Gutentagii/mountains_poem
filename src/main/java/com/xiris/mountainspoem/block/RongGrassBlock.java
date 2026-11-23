package com.xiris.mountainspoem.block;

import com.xiris.mountainspoem.MountainsPoemMod;
import com.xiris.mountainspoem.init.MountainsPoemModBlocks;
import com.xiris.mountainspoem.init.MountainsPoemModEntities;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.RandomSource;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.BonemealableBlock;
import net.minecraft.world.level.block.FlowerBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.material.PushReaction;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class RongGrassBlock extends FlowerBlock implements BonemealableBlock {
    public RongGrassBlock() {
        super(MobEffects.DAMAGE_BOOST, 100, BlockBehaviour.Properties.of()
                .mapColor(MapColor.PLANT)
                .sound(SoundType.GRASS)
                .instabreak()
                .noCollission()
                .offsetType(BlockBehaviour.OffsetType.XZ)
                .pushReaction(PushReaction.DESTROY)
        );
    }

    @Override
    public void playerDestroy(Level world, Player player, BlockPos blockPos, BlockState blockState,
                              @Nullable BlockEntity blockEntity, ItemStack itemStack) {
        super.playerDestroy(world, player, blockPos, blockState, blockEntity, itemStack);

        if (!world.isClientSide()) {
            popResource(world, blockPos, new ItemStack(Blocks.DIRT));
        }

        if (Math.random() < 0.05 && world instanceof ServerLevel serverLevel) {
            summonEntity(serverLevel, blockPos, MountainsPoemModEntities.WOOD_WORMS.get());
        }
    }

    @Override
    public boolean isValidBonemealTarget(LevelReader worldIn, BlockPos pos, BlockState blockstate, boolean clientSide) {
        return true;
    }

    @Override
    public boolean isBonemealSuccess(Level world, RandomSource random, BlockPos pos, BlockState blockstate) {
        return true;
    }

    @Override
    public void performBonemeal(ServerLevel world, RandomSource random, BlockPos pos, BlockState blockstate) {
        BlockPos pos1 = pos;
        List<BlockPos> offsets = List.of(
                new BlockPos(0, -1, -1),
                new BlockPos(0, -1, 1),
                new BlockPos(1, -1, 0),
                new BlockPos(-1, -1, 0),
                new BlockPos(-1, -1, -1),
                new BlockPos(-1, -1, 1),
                new BlockPos(1, -1, -1),
                new BlockPos(1, -1, 1)
        );

        for (BlockPos p : offsets) {
            BlockPos targetPos = pos1.offset(p);
            if (Math.random() < 0.2 && world.getBlockState(targetPos).is(BlockTags.create(ResourceLocation.fromNamespaceAndPath(MountainsPoemMod.MOD_ID, "rong_grass_replaceable")))) {
                world.setBlock(targetPos, MountainsPoemModBlocks.DIRT_WITH_RONG_GRASS_TUBERS.get().defaultBlockState(), 3);
                if (Math.random() < 0.3 && world.isEmptyBlock(targetPos.above())) {
                    world.setBlock(targetPos.above(), MountainsPoemModBlocks.RONG_GRASS.get().defaultBlockState(), 3);
                }
            }
        }
    }

    private void summonEntity(ServerLevel level, BlockPos pos, net.minecraft.world.entity.EntityType<? extends Entity> type) {
        double x = pos.getX() + 0.5;
        double y = pos.getY();
        double z = pos.getZ() + 0.5;
        type.spawn(level, BlockPos.containing(x, y, z), MobSpawnType.NATURAL);
    }
}