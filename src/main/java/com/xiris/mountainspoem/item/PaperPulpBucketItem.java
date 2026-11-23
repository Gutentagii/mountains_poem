package com.xiris.mountainspoem.item;

import com.xiris.mountainspoem.init.MountainsPoemModBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.IntegerProperty;

public class PaperPulpBucketItem extends Item {
    public PaperPulpBucketItem() {
        super(new Item.Properties().stacksTo(16).rarity(Rarity.COMMON));
    }

    @Override
    public InteractionResult useOn(UseOnContext context) {
        LevelAccessor world = context.getLevel();
        BlockPos pos = context.getClickedPos();
        Player player = context.getPlayer();
        ItemStack stack = context.getItemInHand();
        BlockState state = world.getBlockState(pos);

        if (player == null)
            return InteractionResult.PASS;
        if (state.is(MountainsPoemModBlocks.PAPERMAKING_BOARD.get())) {
            if (state.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty blockstateProp) {
                if (blockstateProp.getPossibleValues().contains(1)) {
                    if (!world.isClientSide()) {
                        world.setBlock(pos, state.setValue(blockstateProp, 1), 3);

                        if (!player.isCreative()) {
                            stack.shrink(1);
                        }
                    }
                    return InteractionResult.SUCCESS;
                }
            }
        }

        return InteractionResult.PASS;
    }
}