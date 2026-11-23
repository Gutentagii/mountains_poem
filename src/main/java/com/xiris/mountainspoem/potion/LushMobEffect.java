
package com.xiris.mountainspoem.potion;

import com.xiris.mountainspoem.init.MountainsPoemModBlocks;
import com.xiris.mountainspoem.util.BlockStateUtil;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.BoneMealItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.BonemealableBlock;

public class LushMobEffect extends MobEffect {
	public LushMobEffect() {
		super(MobEffectCategory.BENEFICIAL, -16724992);
	}

	@Override
	public void applyEffectTick(LivingEntity entity, int amplifier) {
        LevelAccessor world = entity.level();
        BlockPos pos = BlockPos.containing(entity.getX(), entity.getY(), entity.getZ());
        if ((world.getBlockState(pos)).getBlock() == Blocks.DIRT) {
            if (world.getBiome(pos).is(ResourceLocation.fromNamespaceAndPath("minecraft", "mushroom_fields")))
                BlockStateUtil.replaceBlock(world, pos, Blocks.MYCELIUM, true);
            else
                BlockStateUtil.replaceBlock(world, pos, Blocks.GRASS_BLOCK, true);
        }
        if ((world.getBlockState(pos)).getBlock() == MountainsPoemModBlocks.LUSH_DIRT.get())
            BlockStateUtil.replaceBlock(world, pos, MountainsPoemModBlocks.LUSH_GRASS_BLOCK.get(), true);
        if (entity.onGround() && entity.isShiftKeyDown()) {
            if ((world.getBlockState(pos.above())).getBlock() instanceof BonemealableBlock) {
                if (world instanceof Level _level) {
                    BlockPos _bp = pos.above();
                    if (BoneMealItem.growCrop(new ItemStack(Items.BONE_MEAL), _level, _bp) || BoneMealItem.growWaterPlant(new ItemStack(Items.BONE_MEAL), _level, _bp, null))
                        if (!_level.isClientSide())
                            _level.levelEvent(2005, _bp, 0);

                }
            } else if ((world.getBlockState(pos)).is(BlockTags.create(ResourceLocation.fromNamespaceAndPath("minecraft", "dirt"))))
                if (world instanceof Level _level)
                    if (BoneMealItem.growCrop(new ItemStack(Items.BONE_MEAL), _level, pos) || BoneMealItem.growWaterPlant(new ItemStack(Items.BONE_MEAL), _level, pos, null))
                        if (!_level.isClientSide())
                            _level.levelEvent(2005, pos, 0);
        }
    }

	@Override
	public boolean isDurationEffectTick(int duration, int amplifier) {
		return true;
	}
}
