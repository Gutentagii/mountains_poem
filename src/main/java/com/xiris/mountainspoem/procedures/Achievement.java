package com.xiris.mountainspoem.procedures;

import com.xiris.mountainspoem.MountainsPoemMod;
import com.xiris.mountainspoem.init.MountainsPoemModItems;
import net.minecraft.advancements.Advancement;
import net.minecraft.advancements.AdvancementProgress;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber
public class Achievement {
    @SubscribeEvent
    public static void onItemPickup(PlayerEvent.ItemPickupEvent event) {
        Player player = event.getEntity();
        ItemStack stack = event.getStack();

        if (stack.is(MountainsPoemModItems.WHITE_APE_CLIMBING_HOOK.get()) && player instanceof ServerPlayer sp) {
            Advancement advancement = sp.server.getAdvancements().getAdvancement(
                    net.minecraft.resources.ResourceLocation.fromNamespaceAndPath(MountainsPoemMod.MOD_ID, "white_ape_climbing_hook")
            );
            if (advancement != null) {
                AdvancementProgress progress = sp.getAdvancements().getOrStartProgress(advancement);
                if (!progress.isDone()) {
                    for (String s : progress.getRemainingCriteria()) {
                        sp.getAdvancements().award(advancement, s);
                    }
                }
            }
        }
    }
}
