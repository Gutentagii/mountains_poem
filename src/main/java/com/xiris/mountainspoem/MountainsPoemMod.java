package com.xiris.mountainspoem;

import com.xiris.mountainspoem.event.ServerEvents;
import com.xiris.mountainspoem.init.*;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod(MountainsPoemMod.MOD_ID)
public class MountainsPoemMod {
    public static final Logger LOGGER = LogManager.getLogger(MountainsPoemMod.class);
    public static final String MOD_ID = "mountains_poem";

    public MountainsPoemMod(FMLJavaModLoadingContext context) {
        var bus = context.getModEventBus();
        MountainsPoemModEntities.REGISTRY.register(bus);
        MountainsPoemModItems.REGISTRY.register(bus);
        MountainsPoemModSounds.REGISTRY.register(bus);
        MountainsPoemModBlocks.REGISTRY.register(bus);

        MountainsPoemModBlockEntities.REGISTRY.register(bus);
        MountainsPoemModEnchantments.REGISTRY.register(bus);
        MountainsPoemModTabs.REGISTRY.register(bus);
        MountainsPoemModMobEffects.REGISTRY.register(bus);
        MountainsPoemModPotions.REGISTRY.register(bus);
        MountainsPoemModPaintings.REGISTRY.register(bus);
        MountainsPoemModParticleTypes.REGISTRY.register(bus);
        MountainsPoemModVillagerProfessions.PROFESSIONS.register(bus);
        MountainsPoemModMenus.REGISTRY.register(bus);

        MinecraftForge.EVENT_BUS.register(ServerEvents.class);

        bus.addListener(this::commonSetup);
    }

    private void commonSetup(final FMLCommonSetupEvent event) {
        // Fuck you the null code!!!!!!!!!!!!!!!!!!!!!!!
        // Fuck you the null code!!!!!!!!!!!!!!!!!!!!!!!
        // Fuck you the null code!!!!!!!!!!!!!!!!!!!!!!!
        //MountainsPoemModEntities.REGISTRY.register(FMLJavaModLoadingContext.get().getModEventBus());
    }
}