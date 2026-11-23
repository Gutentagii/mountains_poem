
/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package com.xiris.mountainspoem.init;

//import dev.architectury.registry.menu.MenuRegistry;
//import dev.architectury.registry.registries.DeferredRegister;
//import dev.architectury.registry.registries.RegistrySupplier;
import com.xiris.mountainspoem.MountainsPoemMod;
import com.xiris.mountainspoem.world.inventory.*;
import com.xiris.mountainspoem.world.inventory.*;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.inventory.MenuType;
import net.minecraftforge.common.extensions.IForgeMenuType;
import net.minecraftforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class MountainsPoemModMenus {
    public static final DeferredRegister<MenuType<?>> REGISTRY = DeferredRegister.create(Registries.MENU, MountainsPoemMod.MOD_ID);

    public static final Supplier<MenuType<GuiBasketsMenu>> GUI_BASKETS = REGISTRY.register("gui_baskets",
            () -> IForgeMenuType.create(GuiBasketsMenu::new));

    public static final Supplier<MenuType<DirtBoxMenu>> DIRT_BOX = REGISTRY.register("dirt_box",
            () -> IForgeMenuType.create(DirtBoxMenu::new));

    public static final Supplier<MenuType<CopperCuttersMenu>> COPPER_CUTTERS = REGISTRY.register("copper_cutters",
            () -> IForgeMenuType.create(CopperCuttersMenu::new));

    public static final Supplier<MenuType<ZunBottlesMenu>> ZUN_BOTTLES = REGISTRY.register("zun_bottles",
            () -> IForgeMenuType.create(ZunBottlesMenu::new));

    public static final Supplier<MenuType<WaterHorseMenu>> WATER_HORSE = REGISTRY.register("water_horse",
            () -> IForgeMenuType.create(WaterHorseMenu::new));
}