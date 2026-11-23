package com.xiris.mountainspoem.procedures;

import com.xiris.mountainspoem.MountainsPoemMod;
import net.minecraft.ChatFormatting;
import net.minecraft.client.Minecraft;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.network.chat.ClickEvent;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.HoverEvent;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.ClientPlayerNetworkEvent;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = MountainsPoemMod.MOD_ID, value = Dist.CLIENT)
public final class alpha {
    private static final String FEEDBACK_URL = "https://www.mcmod.cn/class/15910.html";

    private static boolean sent = false;

    @SubscribeEvent
    public static void onClientTick(TickEvent.ClientTickEvent event) {
        if (event.phase != TickEvent.Phase.END || sent) {
            return;
        }

        LocalPlayer player = Minecraft.getInstance().player;
        if (player == null) {
            return;
        }

        player.displayClientMessage(buildNotice(), false);
        sent = true;
    }

    @SubscribeEvent
    public static void onLoggingIn(ClientPlayerNetworkEvent.LoggingIn event) {
        sent = false;
    }

    private static Component buildNotice() {
        Component hover = Component.translatable("text.mountains_poem.alpha.hover");

        Component link = Component.translatable("text.mountains_poem.alpha.link")
                .withStyle(style -> style
                        .withColor(ChatFormatting.GOLD)
                        .withUnderlined(true)
                        .withClickEvent(new ClickEvent(ClickEvent.Action.OPEN_URL, FEEDBACK_URL))
                        .withHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, hover)));

        return Component.translatable("text.mountains_poem.alpha")
                .withStyle(style -> style
                        .withClickEvent(new ClickEvent(ClickEvent.Action.OPEN_URL, FEEDBACK_URL))
                        .withHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, hover)))
                .append(Component.literal(" "))
                .append(link);
    }
}