
/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.mountainspoem.init;

import net.mcreator.mountainspoem.potion.TheMountainGodSBlessingMobEffect;
import net.mcreator.mountainspoem.potion.SuffocateMobEffect;
import net.mcreator.mountainspoem.potion.StrongOdorMobEffect;
import net.mcreator.mountainspoem.potion.SleepPeacefullyMobEffect;
import net.mcreator.mountainspoem.potion.ResentmentOfTheSouthernMountainsGodMobEffect;
import net.mcreator.mountainspoem.potion.PestilenceMobEffect;
import net.mcreator.mountainspoem.potion.NocturnalJourneymanMobEffect;
import net.mcreator.mountainspoem.potion.LushuHeartMobEffect;
import net.mcreator.mountainspoem.potion.LushMobEffect;
import net.mcreator.mountainspoem.potion.LostSoulsMobEffect;
import net.mcreator.mountainspoem.potion.HydratedSkinMobEffect;
import net.mcreator.mountainspoem.potion.GuResistanceMobEffect;
import net.mcreator.mountainspoem.potion.EvilQiMobEffect;
import net.mcreator.mountainspoem.potion.DermatosisMobEffect;
import net.mcreator.mountainspoem.potion.DehydrationMobEffect;
import net.mcreator.mountainspoem.potion.CrazyMobEffect;
import net.mcreator.mountainspoem.potion.ChaosMobEffect;
import net.mcreator.mountainspoem.potion.CarbunclesResistanceMobEffect;
import net.mcreator.mountainspoem.potion.CarbunclesMobEffect;
import net.mcreator.mountainspoem.potion.BuoyancyMobEffect;
import net.mcreator.mountainspoem.potion.BoshiBlessingMobEffect;
import net.mcreator.mountainspoem.potion.AbundantMobEffect;
import net.mcreator.mountainspoem.MountainsPoemMod;
import net.minecraft.world.effect.MobEffect;

public class MountainsPoemModMobEffects {
	public static final DeferredRegister<MobEffect> REGISTRY = DeferredRegister.create(ForgeRegistries.MOB_EFFECTS, MountainsPoemMod.MODID);
	public static final RegistryObject<MobEffect> DEHYDRATION = REGISTRY.register("dehydration", () -> new DehydrationMobEffect());
	public static final RegistryObject<MobEffect> PESTILENCE = REGISTRY.register("pestilence", () -> new PestilenceMobEffect());
	public static final RegistryObject<MobEffect> DERMATOSIS = REGISTRY.register("dermatosis", () -> new DermatosisMobEffect());
	public static final RegistryObject<MobEffect> LUSHU_HEART = REGISTRY.register("lushu_heart", () -> new LushuHeartMobEffect());
	public static final RegistryObject<MobEffect> BOYI_BLESSING = REGISTRY.register("boyi_blessing", () -> new BoshiBlessingMobEffect());
	public static final RegistryObject<MobEffect> LOST_SOULS = REGISTRY.register("lost_souls", () -> new LostSoulsMobEffect());
	public static final RegistryObject<MobEffect> CRAZY = REGISTRY.register("crazy", () -> new CrazyMobEffect());
	public static final RegistryObject<MobEffect> STRONG_ODOR = REGISTRY.register("strong_odor", () -> new StrongOdorMobEffect());
	public static final RegistryObject<MobEffect> CHAOS = REGISTRY.register("chaos", () -> new ChaosMobEffect());
	public static final RegistryObject<MobEffect> HYDRATED_SKIN = REGISTRY.register("hydrated_skin", () -> new HydratedSkinMobEffect());
	public static final RegistryObject<MobEffect> ABUNDANT = REGISTRY.register("abundant", () -> new AbundantMobEffect());
	public static final RegistryObject<MobEffect> LUSH = REGISTRY.register("lush", () -> new LushMobEffect());
	public static final RegistryObject<MobEffect> THE_MOUNTAIN_GOD_S_BLESSING = REGISTRY.register("the_mountain_god_s_blessing", () -> new TheMountainGodSBlessingMobEffect());
	public static final RegistryObject<MobEffect> CARBUNCLES = REGISTRY.register("carbuncles", () -> new CarbunclesMobEffect());
	public static final RegistryObject<MobEffect> CARBUNCLES_RESISTANCE = REGISTRY.register("carbuncles_resistance", () -> new CarbunclesResistanceMobEffect());
	public static final RegistryObject<MobEffect> EVIL_QI = REGISTRY.register("evil_qi", () -> new EvilQiMobEffect());
	public static final RegistryObject<MobEffect> GU_RESISTANCE = REGISTRY.register("gu_resistance", () -> new GuResistanceMobEffect());
	public static final RegistryObject<MobEffect> NOCTURNAL_JOURNEYMAN = REGISTRY.register("nocturnal_journeyman", () -> new NocturnalJourneymanMobEffect());
	public static final RegistryObject<MobEffect> SUFFOCATE = REGISTRY.register("suffocate", () -> new SuffocateMobEffect());
	public static final RegistryObject<MobEffect> BUOYANCY = REGISTRY.register("buoyancy", () -> new BuoyancyMobEffect());
	public static final RegistryObject<MobEffect> SLEEP_PEACEFULLY = REGISTRY.register("sleep_peacefully", () -> new SleepPeacefullyMobEffect());
	public static final RegistryObject<MobEffect> RESENTMENT_OF_THE_SOUTHERN_MOUNTAINS_GOD = REGISTRY.register("resentment_of_the_southern_mountains_god", () -> new ResentmentOfTheSouthernMountainsGodMobEffect());
}
