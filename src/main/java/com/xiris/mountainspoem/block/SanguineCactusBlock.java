package com.xiris.mountainspoem.block;

import com.xiris.mountainspoem.MountainsPoemMod;
import com.xiris.mountainspoem.init.MountainsPoemModBlocks;
import com.xiris.mountainspoem.init.MountainsPoemModEnchantments;
import net.minecraft.core.BlockPos;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.TagKey;
import net.minecraft.util.RandomSource;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.SugarCaneBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.material.PushReaction;
import net.minecraft.world.level.storage.loot.LootParams;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

import java.util.Collections;
import java.util.List;

public class SanguineCactusBlock extends SugarCaneBlock {
    public SanguineCactusBlock() {
        super(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_RED).randomTicks().sound(SoundType.WOOD).strength(3f, 1f).noOcclusion().dynamicShape().offsetType(BlockBehaviour.OffsetType.NONE).pushReaction(PushReaction.DESTROY));
    }

    @Override
    public VoxelShape getShape(BlockState state, BlockGetter world, BlockPos pos, CollisionContext context) {
        Vec3 offset = state.getOffset(world, pos);
        return box(2, 0, 2, 14, 16, 14).move(offset.x, offset.y, offset.z);
    }

    @Override
    public List<ItemStack> getDrops(BlockState state, LootParams.Builder builder) {
        List<ItemStack> dropsOriginal = super.getDrops(state, builder);
        if (!dropsOriginal.isEmpty()) return dropsOriginal;
        return Collections.singletonList(new ItemStack(this));
    }

    @Override
    public boolean canSurvive(BlockState blockstate, LevelReader worldIn, BlockPos pos) {
        BlockPos blockpos = pos.below();
        BlockState groundState = worldIn.getBlockState(blockpos);
        return groundState.is(this) ||
                groundState.is(MountainsPoemModBlocks.SANGUINE_SAND.get()) ||
                groundState.is(MountainsPoemModBlocks.UNDER_GRASS_BLOCK.get()) ||
                groundState.is(MountainsPoemModBlocks.UNDER_DIRT.get()) ||
                groundState.is(Blocks.NETHERRACK) ||
                groundState.is(Blocks.CRIMSON_NYLIUM) ||
                groundState.is(Blocks.WARPED_NYLIUM);
    }

    @Override
    public void randomTick(BlockState blockstate, ServerLevel world, BlockPos blockpos, RandomSource random) {
        if (world.isEmptyBlock(blockpos.above())) {
            int i = 1;
            while (world.getBlockState(blockpos.below(i)).is(this)) ++i;
            if (i < 5) {
                int j = blockstate.getValue(AGE);
                if (random.nextInt((int) (25.0F / this.getGrowthSpeed(world, blockpos)) + 1) == 0) {
                    if (j == 6) {
                        world.setBlockAndUpdate(blockpos.above(), this.defaultBlockState());
                        world.setBlock(blockpos, blockstate.setValue(AGE, 0), 4);
                    } else
                        world.setBlock(blockpos, blockstate.setValue(AGE, j + 1), 4);
                }
            }
        }
    }

    @Override
    public void neighborChanged(BlockState blockstate, Level world, BlockPos pos, Block neighborBlock, BlockPos fromPos, boolean moving) {
        super.neighborChanged(blockstate, world, pos, neighborBlock, fromPos, moving);
        double x = pos.getX();
        double y = pos.getY();
        double z = pos.getZ();
        if (!(world.getBlockState(pos.east()).is(BlockTags.create(ResourceLocation.fromNamespaceAndPath(MountainsPoemMod.MOD_ID, "special_blocks")))
                && world.getBlockState(pos.south()).is(BlockTags.create(ResourceLocation.fromNamespaceAndPath(MountainsPoemMod.MOD_ID, "special_blocks")))
                && world.getBlockState(pos.west()).is(BlockTags.create(ResourceLocation.fromNamespaceAndPath(MountainsPoemMod.MOD_ID, "special_blocks")))
                && world.getBlockState(pos.north()).is(BlockTags.create(ResourceLocation.fromNamespaceAndPath(MountainsPoemMod.MOD_ID, "special_blocks"))))) {
            BlockPos _pos = BlockPos.containing(x, y, z);
            dropResources(world.getBlockState(_pos), world, BlockPos.containing(x, y, z), null);
            world.destroyBlock(_pos, false);
        }
    }

    @Override
    public void entityInside(BlockState blockstate, Level world, BlockPos pos, Entity entity) {
        super.entityInside(blockstate, world, pos, entity);
        if (entity instanceof LivingEntity living && EnchantmentHelper.getItemEnchantmentLevel(MountainsPoemModEnchantments.TIGHT.get(), living.getItemBySlot(EquipmentSlot.CHEST)) == 0 && !entity.getType().is(TagKey.create(Registries.ENTITY_TYPE, ResourceLocation.fromNamespaceAndPath(MountainsPoemMod.MOD_ID, "under_thorns_crossable"))))
            entity.hurt(new DamageSource(world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(ResourceKey.create(Registries.DAMAGE_TYPE, ResourceLocation.fromNamespaceAndPath(MountainsPoemMod.MOD_ID, "sanguine_thorn_stung")))), 1);
    }

    private float getGrowthSpeed(BlockGetter worldIn, BlockPos pos) {
        float growth = 1.0F;
        BlockPos blockpos = pos.below();
        BlockState state = worldIn.getBlockState(blockpos);
        if (state.is(MountainsPoemModBlocks.SANGUINE_SAND.get()) || state.is(Blocks.NETHERRACK)) growth = 3.0F;
        return growth;
    }
}