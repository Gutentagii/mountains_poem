
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.mountainspoem.init;

import net.mcreator.mountainspoem.MountainsPoemMod;

public class MountainsPoemModPotions {
	public static final DeferredRegister<Potion> REGISTRY = DeferredRegister.create(ForgeRegistries.POTIONS, MountainsPoemMod.MODID);
	public static final RegistryObject<Potion> STRANGE_ODOR = REGISTRY.register("strange_odor", () -> new Potion(new MobEffectInstance(MountainsPoemModMobEffects.STRONG_ODOR.get(), 3600, 0, false, true)));
	public static final RegistryObject<Potion> EVIL_QI_RESISTANCE = REGISTRY.register("evil_qi_resistance", () -> new Potion(new MobEffectInstance(MountainsPoemModMobEffects.GU_RESISTANCE.get(), 3600, 0, false, true)));
}
