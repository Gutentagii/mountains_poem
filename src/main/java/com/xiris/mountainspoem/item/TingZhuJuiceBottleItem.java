package com.xiris.mountainspoem.item;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.*;
import net.minecraft.world.level.Level;

public class TingZhuJuiceBottleItem extends Item {
    public TingZhuJuiceBottleItem() {
        super(new Item.Properties()
                .stacksTo(1)
                .rarity(Rarity.COMMON)
                .food(new FoodProperties.Builder()
                        .nutrition(3)
                        .saturationMod(0.8f)
                        .alwaysEat()
                        .build()));
    }

    @Override
    public UseAnim getUseAnimation(ItemStack stack) {
        return UseAnim.DRINK;
    }

    @Override
    public int getUseDuration(ItemStack stack) {
        return 32;
    }

    @Override
    public ItemStack finishUsingItem(ItemStack stack, Level world, LivingEntity entity) {
        ItemStack bottle = new ItemStack(Items.GLASS_BOTTLE);
        super.finishUsingItem(stack, world, entity);

        if (stack.isEmpty()) {
            return bottle;
        } else {
            if (entity instanceof Player player && !player.isCreative()) {
                if (!player.getInventory().add(bottle))
                    player.drop(bottle, false);
            }
            return stack;
        }
    }
}