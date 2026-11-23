
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package com.xiris.mountainspoem.init;

//import dev.architectury.registry.registries.DeferredRegister;
//import dev.architectury.registry.registries.RegistrySupplier;
import com.xiris.mountainspoem.MountainsPoemMod;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.item.alchemy.Potion;
import net.minecraftforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class MountainsPoemModPotions {
    public static final DeferredRegister<Potion> REGISTRY = DeferredRegister.create(Registries.POTION, MountainsPoemMod.MOD_ID);

    public static final Supplier<Potion> STRANGE_ODOR = REGISTRY.register("strange_odor",
            () -> new Potion(new MobEffectInstance(MountainsPoemModMobEffects.STRONG_ODOR.get(), 3600, 0, false, true)));

    public static final Supplier<Potion> EVIL_QI_RESISTANCE = REGISTRY.register("evil_qi_resistance",
            () -> new Potion(new MobEffectInstance(MountainsPoemModMobEffects.GU_RESISTANCE.get(), 3600, 0, false, true)));
}