package com.xiris.mountainspoem.item;

import com.xiris.mountainspoem.entity.GhostCordageEntity;
import com.xiris.mountainspoem.init.MountainsPoemModEntities;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.level.Level;

public class ResentfulLeadItem extends Item {
    public ResentfulLeadItem() {
        super(new Item.Properties().stacksTo(64).rarity(Rarity.COMMON));
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand) {
        ItemStack stack = player.getItemInHand(hand);

        if (!level.isClientSide()) {
            GhostCordageEntity projectile = new GhostCordageEntity(MountainsPoemModEntities.GHOST_CORDAGE.get(), level);
            projectile.setOwner(player);
            projectile.setBaseDamage(3.0F);
            projectile.setKnockback(1);
            projectile.setSilent(true);
            projectile.setPierceLevel((byte) 0);

            projectile.setPos(player.getX(), player.getEyeY() - 0.1D, player.getZ());
            projectile.shoot(
                    player.getLookAngle().x,
                    player.getLookAngle().y,
                    player.getLookAngle().z,
                    1.4F,
                    0.1F
            );

            level.addFreshEntity(projectile);

            if (!player.isCreative()) {
                stack.shrink(1);
            }
        }

        return InteractionResultHolder.success(stack);
    }
}