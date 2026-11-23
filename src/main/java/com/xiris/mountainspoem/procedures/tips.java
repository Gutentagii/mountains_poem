package com.xiris.mountainspoem.procedures;

import com.xiris.mountainspoem.MountainsPoemMod;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.ClickEvent;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.HoverEvent;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.fml.common.Mod;

@OnlyIn(Dist.CLIENT)
@Mod.EventBusSubscriber(modid = MountainsPoemMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE, value = Dist.CLIENT)
public class tips {

    private static boolean patchouliTipShown = false;

    private static final String PATCHOULI_URL = "https://www.curseforge.com/minecraft/mc-mods/patchouli";

    @SubscribeEvent
    public static void onEnterGame(PlayerEvent.PlayerLoggedInEvent event) {
        if (patchouliTipShown) {
            return;
        }

        if (!ModList.get().isLoaded("patchouli")) {
            Component cw = Component.translatable("item_group.mountains_poem.mountains_poem");

            Component modtip = Component.literal("[")
                    .append(cw)
                    .append(Component.literal("] "))
                    .withStyle(ChatFormatting.GREEN);

            Component link = Component.translatable("text.mountains_poem.tips.miss_patchouli")
                    .withStyle(style -> style
                            .withColor(ChatFormatting.GOLD)
                            .withUnderlined(true)
                            .withClickEvent(new ClickEvent(ClickEvent.Action.OPEN_URL, PATCHOULI_URL))
                            .withHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT,
                                    Component.literal(PATCHOULI_URL)))
                    );

            event.getEntity().sendSystemMessage(modtip.copy().append(link));
            patchouliTipShown = true;
        }
    }
}