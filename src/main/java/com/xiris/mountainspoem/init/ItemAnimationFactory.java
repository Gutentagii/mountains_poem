package com.xiris.mountainspoem.init;

import com.xiris.mountainspoem.item.PlagueHalberdItem;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.ItemInHandRenderer;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;

import java.lang.reflect.Field;

public final class ItemAnimationFactory {

    private static ItemInHandRenderer getRenderer() {
        try {
            Field field = Minecraft.class.getDeclaredField("itemInHandRenderer");
            field.setAccessible(true);
            return (ItemInHandRenderer) field.get(Minecraft.getInstance());
        } catch (Exception e) {
            return null;
        }
    }

    public static void disableUseAnim(String hand) {
        ItemInHandRenderer renderer = getRenderer();
        if (renderer == null) return;

        try {
            Field mainHand = ItemInHandRenderer.class.getDeclaredField("mainHandHeight");
            Field oMainHand = ItemInHandRenderer.class.getDeclaredField("oMainHandHeight");
            Field offHand = ItemInHandRenderer.class.getDeclaredField("offHandHeight");
            Field oOffHand = ItemInHandRenderer.class.getDeclaredField("oOffHandHeight");

            mainHand.setAccessible(true);
            oMainHand.setAccessible(true);
            offHand.setAccessible(true);
            oOffHand.setAccessible(true);

            mainHand.setFloat(renderer, 1.0F);
            oMainHand.setFloat(renderer, 1.0F);
            offHand.setFloat(renderer, 1.0F);
            oOffHand.setFloat(renderer, 1.0F);
        } catch (Exception ignored) {}
    }

    public static void animatedItems(Player player) {
        if (!player.level().isClientSide()) return;

        ItemStack mainHandItem = player.getMainHandItem();
        ItemStack offHandItem = player.getOffhandItem();

        if (mainHandItem.getItem() instanceof PlagueHalberdItem plagueItem) {
            String animation = mainHandItem.getOrCreateTag().getString("geckoAnim");
            if (!animation.isEmpty()) {
                mainHandItem.getOrCreateTag().putString("geckoAnim", "");
                plagueItem.animationprocedure = animation;
                disableUseAnim("right");
            }
        }

        if (offHandItem.getItem() instanceof PlagueHalberdItem plagueItem) {
            String animation = offHandItem.getOrCreateTag().getString("geckoAnim");
            if (!animation.isEmpty()) {
                offHandItem.getOrCreateTag().putString("geckoAnim", "");
                plagueItem.animationprocedure = animation;
                disableUseAnim("left");
            }
        }
    }
}