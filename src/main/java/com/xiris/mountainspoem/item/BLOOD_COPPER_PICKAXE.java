package com.xiris.mountainspoem.item;

import com.xiris.mountainspoem.init.MountainsPoemModBlocks;
import com.xiris.mountainspoem.init.MountainsPoemModItems;
import net.minecraft.core.BlockPos;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.PickaxeItem;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;

import java.util.List;

public class BLOOD_COPPER_PICKAXE extends PickaxeItem {
    public BLOOD_COPPER_PICKAXE() {
        super(new Tier() {
            public int getUses() {
                return 3044;
            }

            public float getSpeed() {
                return 10f;
            }

            public float getAttackDamageBonus() {
                return 5f;
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
        }, 1, -2.8f, new Item.Properties());
    }

    @Override
    public boolean mineBlock(ItemStack itemstack, Level world, BlockState blockstate, BlockPos pos, LivingEntity entity) {
        boolean retval = super.mineBlock(itemstack, world, blockstate, pos, entity);
        if (!world.isClientSide() && entity instanceof Player player) {
            Block block = blockstate.getBlock();
            boolean isCopperOre = block == Blocks.COPPER_ORE || block == Blocks.DEEPSLATE_COPPER_ORE
                    || block == MountainsPoemModBlocks.BLOOD_COPPER_ORE.get()
                    || block == MountainsPoemModBlocks.DEEPSLATE_BLOOD_COPPER_ORE.get();

            if (isCopperOre && player.getRandom().nextFloat() <= 0.2F) {
                List<ItemStack> allItems = player.getInventory().items;
                for (ItemStack stack : allItems) {
                    if (stack.isEmpty()) continue;
                    if (stack.getItem() == MountainsPoemModItems.BLOOD_COPPER_AXE.get()
                            || stack.getItem() == MountainsPoemModItems.BLOOD_COPPER_HOE.get()
                            || stack.getItem() == MountainsPoemModItems.BLOOD_COPPER_SHOVEL.get()
                            || stack.getItem() == MountainsPoemModItems.BLOOD_COPPER_SWORD.get()
                            || stack.getItem() == MountainsPoemModItems.BLOOD_COPPER_PICKAXE.get()) {
                        if (stack.isDamageableItem()) {
                            int newDamage = stack.getDamageValue() - 20;
                            if (newDamage < 0) newDamage = 0;
                            stack.setDamageValue(newDamage);
                        }
                    }
                }
            }
        }
        return retval;
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level world, Player player, InteractionHand hand) {
        ItemStack stack = player.getItemInHand(hand);

        if (!world.isClientSide()) {
            BlockPos pos = player.getOnPos().relative(player.getDirection());
            BlockState state = world.getBlockState(pos);
            Block block = state.getBlock();

            if (block == Blocks.COPPER_BLOCK) {
                world.setBlock(pos, Blocks.EXPOSED_COPPER.defaultBlockState(), 3);
                return InteractionResultHolder.success(stack);
            }
            if (block == Blocks.EXPOSED_COPPER) {
                world.setBlock(pos, Blocks.WEATHERED_COPPER.defaultBlockState(), 3);
                return InteractionResultHolder.success(stack);
            }
            if (block == Blocks.WEATHERED_COPPER) {
                world.setBlock(pos, Blocks.OXIDIZED_COPPER.defaultBlockState(), 3);
                return InteractionResultHolder.success(stack);
            }
            if (block == Blocks.OXIDIZED_COPPER) {
                world.setBlock(pos, Blocks.COPPER_BLOCK.defaultBlockState(), 3);
                return InteractionResultHolder.success(stack);
            }
        }

        return super.use(world, player, hand);
    }
}