package com.xiris.mountainspoem.item;

import com.xiris.mountainspoem.block.TheUnderPortalBlock;
import net.minecraft.core.BlockPos;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;

public class TheUnderItem extends Item {
    public TheUnderItem() {
        super(new Item.Properties().rarity(Rarity.COMMON).durability(64));
    }

    @Override
    public InteractionResult useOn(UseOnContext context) {
        Player player = context.getPlayer();
        if (player == null) {
            return InteractionResult.PASS;
        }

        Level level = context.getLevel();
        BlockPos pos = context.getClickedPos().relative(context.getClickedFace());
        ItemStack stack = context.getItemInHand();

        if (!player.mayUseItemAt(pos, context.getClickedFace(), stack)) {
            return InteractionResult.FAIL;
        }

        if (!level.isClientSide && level.isEmptyBlock(pos) && TheUnderPortalBlock.portalSpawn(level, pos)) {
            stack.hurtAndBreak(1, player, broken -> broken.broadcastBreakEvent(context.getHand()));
            return InteractionResult.SUCCESS;
        }

        return InteractionResult.FAIL;
    }
}
