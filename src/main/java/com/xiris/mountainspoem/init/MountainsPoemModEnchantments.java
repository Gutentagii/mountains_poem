
/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package com.xiris.mountainspoem.init;

//import dev.architectury.registry.registries.DeferredRegister;
//import dev.architectury.registry.registries.RegistrySupplier;
import com.xiris.mountainspoem.MountainsPoemMod;
import com.xiris.mountainspoem.enchantment.ControlOfWaterHorsesEnchantment;
import com.xiris.mountainspoem.enchantment.RockAttachedEnchantment;
import com.xiris.mountainspoem.enchantment.SoulStrengthEnchantment;
import com.xiris.mountainspoem.enchantment.TightEnchantment;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraftforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class MountainsPoemModEnchantments {
    public static final DeferredRegister<Enchantment> REGISTRY = DeferredRegister.create(Registries.ENCHANTMENT, MountainsPoemMod.MOD_ID);

    public static final Supplier<Enchantment> SOUL_STRENGTH = REGISTRY.register("soul_strength", SoulStrengthEnchantment::new);
    public static final Supplier<Enchantment> TIGHT = REGISTRY.register("tight", TightEnchantment::new);
    public static final Supplier<Enchantment> CONTROL_OF_WATER_HORSES = REGISTRY.register("control_of_water_horses", ControlOfWaterHorsesEnchantment::new);
    public static final Supplier<Enchantment> ROCK_ATTACHED = REGISTRY.register("rock_attached", RockAttachedEnchantment::new);
}
