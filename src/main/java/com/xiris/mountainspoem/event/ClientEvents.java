package com.xiris.mountainspoem.event;

import com.xiris.mountainspoem.MountainsPoemMod;
import com.xiris.mountainspoem.init.ArmorAnimationFactory;
import com.xiris.mountainspoem.init.ItemAnimationFactory;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = MountainsPoemMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE, value = Dist.CLIENT)
public final class ClientEvents {
    private ClientEvents() {
    }

    @SubscribeEvent
    public static void onPlayerTick(TickEvent.PlayerTickEvent event) {
        if (event.phase == TickEvent.Phase.END) {
            ArmorAnimationFactory.animatedArmors(event.player);
        }
        if (event.phase == TickEvent.Phase.START) {
            ItemAnimationFactory.animatedItems(event.player);
        }
    }
}
