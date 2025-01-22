
/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.mountainspoem.init;

import net.mcreator.mountainspoem.enchantment.TightEnchantment;
import net.mcreator.mountainspoem.enchantment.SoulStrengthEnchantment;
import net.mcreator.mountainspoem.enchantment.RockAttachedEnchantment;
import net.mcreator.mountainspoem.enchantment.ControlOfWaterHorsesEnchantment;
import net.mcreator.mountainspoem.MountainsPoemMod;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class MountainsPoemModEnchantments {
	public static final DeferredRegister<Enchantment> REGISTRY = DeferredRegister.create(ForgeRegistries.ENCHANTMENTS, MountainsPoemMod.MODID);
	public static final RegistryObject<Enchantment> SOUL_STRENGTH = REGISTRY.register("soul_strength", () -> new SoulStrengthEnchantment());
	public static final RegistryObject<Enchantment> TIGHT = REGISTRY.register("tight", () -> new TightEnchantment());
	public static final RegistryObject<Enchantment> CONTROL_OF_WATER_HORSES = REGISTRY.register("control_of_water_horses", () -> new ControlOfWaterHorsesEnchantment());
	public static final RegistryObject<Enchantment> ROCK_ATTACHED = REGISTRY.register("rock_attached", () -> new RockAttachedEnchantment());
}
