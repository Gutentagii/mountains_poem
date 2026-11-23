package com.xiris.mountainspoem.init;

import com.xiris.mountainspoem.item.*;
import com.xiris.mountainspoem.item.*;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import software.bernie.geckolib.animatable.GeoItem;

public class ArmorAnimationFactory {
    public static void animatedArmors(Player player) {
        String animation;
        if (player.level().isClientSide()) {
            if (player.getItemBySlot(EquipmentSlot.HEAD).getItem() != (ItemStack.EMPTY).getItem() && player.getItemBySlot(EquipmentSlot.HEAD).getItem() instanceof GeoItem) {
                if (!player.getItemBySlot(EquipmentSlot.HEAD).getOrCreateTag().getString("geckoAnim").isEmpty()) {
                    animation = player.getItemBySlot(EquipmentSlot.HEAD).getOrCreateTag().getString("geckoAnim");
                    player.getItemBySlot(EquipmentSlot.HEAD).getOrCreateTag().putString("geckoAnim", "");
                    if (player.getItemBySlot(EquipmentSlot.HEAD).getItem() instanceof VinesArmorsItem animatable)
                        animatable.animationprocedure = animation;
                    if (player.getItemBySlot(EquipmentSlot.HEAD).getItem() instanceof BronzeDevourerPieceItem animatable)
                        animatable.animationprocedure = animation;
                    if (player.getItemBySlot(EquipmentSlot.HEAD).getItem() instanceof BambooGreenNineTailedFoxHanfuItem animatable)
                        animatable.animationprocedure = animation;
                    if (player.getItemBySlot(EquipmentSlot.HEAD).getItem() instanceof MugwortGreenNineTailedFoxHanfuItem animatable)
                        animatable.animationprocedure = animation;
                    if (player.getItemBySlot(EquipmentSlot.HEAD).getItem() instanceof PeachRedNineTailedFoxHanfuItem animatable)
                        animatable.animationprocedure = animation;
                    if (player.getItemBySlot(EquipmentSlot.HEAD).getItem() instanceof JunBlackNineTailedFoxHanfuItem animatable)
                        animatable.animationprocedure = animation;
                }
            }
            if (player.getItemBySlot(EquipmentSlot.CHEST).getItem() != (ItemStack.EMPTY).getItem() && player.getItemBySlot(EquipmentSlot.CHEST).getItem() instanceof GeoItem) {
                if (!player.getItemBySlot(EquipmentSlot.CHEST).getOrCreateTag().getString("geckoAnim").isEmpty()) {
                    animation = player.getItemBySlot(EquipmentSlot.CHEST).getOrCreateTag().getString("geckoAnim");
                    player.getItemBySlot(EquipmentSlot.CHEST).getOrCreateTag().putString("geckoAnim", "");
                    if (player.getItemBySlot(EquipmentSlot.CHEST).getItem() instanceof VinesArmorsItem animatable)
                        animatable.animationprocedure = animation;
                    if (player.getItemBySlot(EquipmentSlot.CHEST).getItem() instanceof BronzeDevourerPieceItem animatable)
                        animatable.animationprocedure = animation;
                    if (player.getItemBySlot(EquipmentSlot.CHEST).getItem() instanceof BambooGreenNineTailedFoxHanfuItem animatable)
                        animatable.animationprocedure = animation;
                    if (player.getItemBySlot(EquipmentSlot.CHEST).getItem() instanceof MugwortGreenNineTailedFoxHanfuItem animatable)
                        animatable.animationprocedure = animation;
                    if (player.getItemBySlot(EquipmentSlot.CHEST).getItem() instanceof PeachRedNineTailedFoxHanfuItem animatable)
                        animatable.animationprocedure = animation;
                    if (player.getItemBySlot(EquipmentSlot.CHEST).getItem() instanceof JunBlackNineTailedFoxHanfuItem animatable)
                        animatable.animationprocedure = animation;
                }
            }
            if (player.getItemBySlot(EquipmentSlot.LEGS).getItem() != (ItemStack.EMPTY).getItem() && player.getItemBySlot(EquipmentSlot.LEGS).getItem() instanceof GeoItem) {
                if (!player.getItemBySlot(EquipmentSlot.LEGS).getOrCreateTag().getString("geckoAnim").isEmpty()) {
                    animation = player.getItemBySlot(EquipmentSlot.LEGS).getOrCreateTag().getString("geckoAnim");
                    player.getItemBySlot(EquipmentSlot.LEGS).getOrCreateTag().putString("geckoAnim", "");
                    if (player.getItemBySlot(EquipmentSlot.LEGS).getItem() instanceof VinesArmorsItem animatable)
                        animatable.animationprocedure = animation;
                    if (player.getItemBySlot(EquipmentSlot.LEGS).getItem() instanceof BronzeDevourerPieceItem animatable)
                        animatable.animationprocedure = animation;
                    if (player.getItemBySlot(EquipmentSlot.LEGS).getItem() instanceof BambooGreenNineTailedFoxHanfuItem animatable)
                        animatable.animationprocedure = animation;
                    if (player.getItemBySlot(EquipmentSlot.LEGS).getItem() instanceof MugwortGreenNineTailedFoxHanfuItem animatable)
                        animatable.animationprocedure = animation;
                    if (player.getItemBySlot(EquipmentSlot.LEGS).getItem() instanceof PeachRedNineTailedFoxHanfuItem animatable)
                        animatable.animationprocedure = animation;
                    if (player.getItemBySlot(EquipmentSlot.LEGS).getItem() instanceof JunBlackNineTailedFoxHanfuItem animatable)
                        animatable.animationprocedure = animation;
                }
            }
            if (player.getItemBySlot(EquipmentSlot.FEET).getItem() != (ItemStack.EMPTY).getItem() && player.getItemBySlot(EquipmentSlot.FEET).getItem() instanceof GeoItem) {
                if (!player.getItemBySlot(EquipmentSlot.FEET).getOrCreateTag().getString("geckoAnim").isEmpty()) {
                    animation = player.getItemBySlot(EquipmentSlot.FEET).getOrCreateTag().getString("geckoAnim");
                    player.getItemBySlot(EquipmentSlot.FEET).getOrCreateTag().putString("geckoAnim", "");
                    if (player.getItemBySlot(EquipmentSlot.FEET).getItem() instanceof VinesArmorsItem animatable)
                        animatable.animationprocedure = animation;
                    if (player.getItemBySlot(EquipmentSlot.FEET).getItem() instanceof BronzeDevourerPieceItem animatable)
                        animatable.animationprocedure = animation;
                    if (player.getItemBySlot(EquipmentSlot.FEET).getItem() instanceof BambooGreenNineTailedFoxHanfuItem animatable)
                        animatable.animationprocedure = animation;
                    if (player.getItemBySlot(EquipmentSlot.FEET).getItem() instanceof MugwortGreenNineTailedFoxHanfuItem animatable)
                        animatable.animationprocedure = animation;
                    if (player.getItemBySlot(EquipmentSlot.FEET).getItem() instanceof PeachRedNineTailedFoxHanfuItem animatable)
                        animatable.animationprocedure = animation;
                    if (player.getItemBySlot(EquipmentSlot.FEET).getItem() instanceof JunBlackNineTailedFoxHanfuItem animatable)
                        animatable.animationprocedure = animation;
                }
            }
        }
    }
}
