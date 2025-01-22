
/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.mountainspoem.init;

import net.mcreator.mountainspoem.world.inventory.ZunBottlesMenu;
import net.mcreator.mountainspoem.world.inventory.WaterHorseMenu;
import net.mcreator.mountainspoem.world.inventory.GuiBasketsMenu;
import net.mcreator.mountainspoem.world.inventory.DirtBoxMenu;
import net.mcreator.mountainspoem.world.inventory.CopperCuttersMenu;
import net.mcreator.mountainspoem.MountainsPoemMod;
import net.minecraft.world.inventory.MenuType;
import net.minecraftforge.common.extensions.IForgeMenuType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class MountainsPoemModMenus {
	public static final DeferredRegister<MenuType<?>> REGISTRY = DeferredRegister.create(ForgeRegistries.MENU_TYPES, MountainsPoemMod.MODID);
	public static final RegistryObject<MenuType<GuiBasketsMenu>> GUI_BASKETS = REGISTRY.register("gui_baskets", () -> IForgeMenuType.create(GuiBasketsMenu::new));
	public static final RegistryObject<MenuType<DirtBoxMenu>> DIRT_BOX = REGISTRY.register("dirt_box", () -> IForgeMenuType.create(DirtBoxMenu::new));
	public static final RegistryObject<MenuType<CopperCuttersMenu>> COPPER_CUTTERS = REGISTRY.register("copper_cutters", () -> IForgeMenuType.create(CopperCuttersMenu::new));
	public static final RegistryObject<MenuType<ZunBottlesMenu>> ZUN_BOTTLES = REGISTRY.register("zun_bottles", () -> IForgeMenuType.create(ZunBottlesMenu::new));
	public static final RegistryObject<MenuType<WaterHorseMenu>> WATER_HORSE = REGISTRY.register("water_horse", () -> IForgeMenuType.create(WaterHorseMenu::new));
}
