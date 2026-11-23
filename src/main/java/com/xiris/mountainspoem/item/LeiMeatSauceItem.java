package com.xiris.mountainspoem.item;

import com.xiris.mountainspoem.init.MountainsPoemModBlocks;
import com.xiris.mountainspoem.util.PlantType;
import com.xiris.mountainspoem.util.PlantUtil;
import net.minecraft.core.BlockPos;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;

public class LeiMeatSauceItem extends Item {
    public LeiMeatSauceItem() {
        super(new Item.Properties().stacksTo(1).rarity(Rarity.COMMON)
                .food(new FoodProperties.Builder().nutrition(13).saturationMod(4f).meat().build()));
    }

    @Override
    public ItemStack finishUsingItem(ItemStack itemstack, Level world, LivingEntity entity) {
        ItemStack retval = new ItemStack(MountainsPoemModBlocks.COPPER_DOU.get());
        super.finishUsingItem(itemstack, world, entity);
        if (itemstack.isEmpty()) {
            return retval;
        } else {
            if (entity instanceof Player player && !player.getAbilities().instabuild) {
                if (!player.getInventory().add(retval))
                    player.drop(retval, false);
            }
            return itemstack;
        }
    }

    @Override
    public InteractionResult useOn(UseOnContext context) {
        Level world = (Level) context.getLevel();
        BlockPos clickPos = context.getClickedPos();
        Player player = context.getPlayer();
        ItemStack stack = context.getItemInHand();

        if (player == null || !player.isShiftKeyDown()) {
            return InteractionResult.PASS;
        }

        BlockPos placePos = clickPos.above();
        if (!world.isEmptyBlock(placePos)) {
            return InteractionResult.FAIL;
        }

        BlockState clickedState = world.getBlockState(clickPos);
        boolean isPlantValid = PlantUtil.getPlantType(clickedState.getBlock()) == PlantType.PLAINS;

        if (isPlantValid) {
            world.setBlock(placePos, MountainsPoemModBlocks.COPPER_DOU_LEI_MEAT_SAUCE.get().defaultBlockState(), 3);

            if (!player.isCreative()) {
                stack.shrink(1);
            }

            player.swing(InteractionHand.MAIN_HAND, true);
            return InteractionResult.SUCCESS;
        }

        return InteractionResult.PASS;
    }

    @Override
    public boolean isFoil(ItemStack stack) {
        return false;
    }
}