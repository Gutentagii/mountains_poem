
/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package com.xiris.mountainspoem.init;

import com.xiris.mountainspoem.client.gui.*;
import com.xiris.mountainspoem.client.gui.*;
import net.minecraft.client.gui.screens.MenuScreens;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class MountainsPoemModScreens {
	@SubscribeEvent
	public static void clientLoad(FMLClientSetupEvent event) {
		event.enqueueWork(() -> {
			MenuScreens.register(MountainsPoemModMenus.GUI_BASKETS.get(), GuiBasketsScreen::new);
			MenuScreens.register(MountainsPoemModMenus.DIRT_BOX.get(), DirtBoxScreen::new);
			MenuScreens.register(MountainsPoemModMenus.COPPER_CUTTERS.get(), CopperCuttersScreen::new);
			MenuScreens.register(MountainsPoemModMenus.ZUN_BOTTLES.get(), ZunBottlesScreen::new);
			MenuScreens.register(MountainsPoemModMenus.WATER_HORSE.get(), WaterHorseScreen::new);
		});
	}
}
