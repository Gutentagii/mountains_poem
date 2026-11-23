
/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package com.xiris.mountainspoem.init;

import com.xiris.mountainspoem.potion.*;
//import dev.architectury.registry.registries.DeferredRegister;
//import dev.architectury.registry.registries.RegistrySupplier;
import com.xiris.mountainspoem.MountainsPoemMod;
import com.xiris.mountainspoem.potion.*;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.effect.MobEffect;
import net.minecraftforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class MountainsPoemModMobEffects {
    public static final DeferredRegister<MobEffect> REGISTRY = DeferredRegister.create(Registries.MOB_EFFECT, MountainsPoemMod.MOD_ID);

    public static final Supplier<MobEffect> DEHYDRATION = REGISTRY.register("dehydration", DehydrationMobEffect::new);
    public static final Supplier<MobEffect> PESTILENCE = REGISTRY.register("pestilence", PestilenceMobEffect::new);
    public static final Supplier<MobEffect> DERMATOSIS = REGISTRY.register("dermatosis", DermatosisMobEffect::new);
    public static final Supplier<MobEffect> LUSHU_HEART = REGISTRY.register("lushu_heart", LushuHeartMobEffect::new);
    public static final Supplier<MobEffect> BOYI_BLESSING = REGISTRY.register("boyi_blessing", BoshiBlessingMobEffect::new);
    public static final Supplier<MobEffect> LOST_SOULS = REGISTRY.register("lost_souls", LostSoulsMobEffect::new);
    public static final Supplier<MobEffect> CRAZY = REGISTRY.register("crazy", CrazyMobEffect::new);
    public static final Supplier<MobEffect> STRONG_ODOR = REGISTRY.register("strong_odor", StrongOdorMobEffect::new);
    public static final Supplier<MobEffect> CHAOS = REGISTRY.register("chaos", ChaosMobEffect::new);
    public static final Supplier<MobEffect> HYDRATED_SKIN = REGISTRY.register("hydrated_skin", HydratedSkinMobEffect::new);
    public static final Supplier<MobEffect> ABUNDANT = REGISTRY.register("abundant", AbundantMobEffect::new);
    public static final Supplier<MobEffect> LUSH = REGISTRY.register("lush", LushMobEffect::new);
    public static final Supplier<MobEffect> THE_MOUNTAIN_GOD_S_BLESSING = REGISTRY.register("the_mountain_god_s_blessing", TheMountainGodSBlessingMobEffect::new);
    public static final Supplier<MobEffect> CARBUNCLES = REGISTRY.register("carbuncles", CarbunclesMobEffect::new);
    public static final Supplier<MobEffect> CARBUNCLES_RESISTANCE = REGISTRY.register("carbuncles_resistance", CarbunclesResistanceMobEffect::new);
    public static final Supplier<MobEffect> EVIL_QI = REGISTRY.register("evil_qi", EvilQiMobEffect::new);
    public static final Supplier<MobEffect> GU_RESISTANCE = REGISTRY.register("gu_resistance", GuResistanceMobEffect::new);
    public static final Supplier<MobEffect> NOCTURNAL_JOURNEYMAN = REGISTRY.register("nocturnal_journeyman", NocturnalJourneymanMobEffect::new);
    public static final Supplier<MobEffect> SUFFOCATE = REGISTRY.register("suffocate", SuffocateMobEffect::new);
    public static final Supplier<MobEffect> BUOYANCY = REGISTRY.register("buoyancy", BuoyancyMobEffect::new);
    public static final Supplier<MobEffect> SLEEP_PEACEFULLY = REGISTRY.register("sleep_peacefully", SleepPeacefullyMobEffect::new);
    public static final Supplier<MobEffect> RESENTMENT_OF_THE_SOUTHERN_MOUNTAINS_GOD = REGISTRY.register("resentment_of_the_southern_mountains_god", ResentmentOfTheSouthernMountainsGodMobEffect::new);
}