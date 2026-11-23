package com.xiris.mountainspoem.item;

import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.item.*;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.CropBlock;
import net.minecraft.world.level.block.state.BlockState;

public class BLOOD_COPPER_HOE extends HoeItem {
    public BLOOD_COPPER_HOE() {
        super(new Tier() {
            public int getUses() {
                return 3044;
            }

            public float getSpeed() {
                return 10f;
            }

            public float getAttackDamageBonus() {
                return 10f;
            }

            public int getLevel() {
                return 5;
            }

            public int getEnchantmentValue() {
                return 20;
            }

            public Ingredient getRepairIngredient() {
                return Ingredient.of();
            }
        }, 0, -3f, new Item.Properties());
    }

    @Override
    public boolean mineBlock(ItemStack stack, Level world, BlockState state, BlockPos pos, LivingEntity entity) {
        if (!world.isClientSide()) {
            if (state.is(Blocks.TORCHFLOWER)) {
                spawnSeeds(world, pos, Items.TORCHFLOWER_SEEDS);
            }

            if (state.is(Blocks.PITCHER_CROP) && state.getValue(CropBlock.AGE) == 4) {
                spawnSeeds(world, pos, Items.PITCHER_POD);
            }
        }

        return super.mineBlock(stack, world, state, pos, entity);
    }

    private void spawnSeeds(Level world, BlockPos pos, Item seed) {
        world.addFreshEntity(new ItemEntity(world,
                pos.getX() + 0.5, pos.getY() + 0.3, pos.getZ() + 0.5,
                new ItemStack(seed)));

        if (world.random.nextBoolean()) {
            world.addFreshEntity(new ItemEntity(world,
                    pos.getX() + 0.5, pos.getY() + 0.3, pos.getZ() + 0.5,
                    new ItemStack(seed)));
        }
    }
}