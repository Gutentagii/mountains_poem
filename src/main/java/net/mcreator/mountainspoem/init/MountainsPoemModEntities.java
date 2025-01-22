
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.mountainspoem.init;

import net.mcreator.mountainspoem.entity.ZuoCowEntity;
import net.mcreator.mountainspoem.entity.ZhuHuaiEntity;
import net.mcreator.mountainspoem.entity.ZhiEntity;
import net.mcreator.mountainspoem.entity.ZhengEntity;
import net.mcreator.mountainspoem.entity.XuanTortoiseEntity;
import net.mcreator.mountainspoem.entity.XianGoatEntity;
import net.mcreator.mountainspoem.entity.WoodWormsEntity;
import net.mcreator.mountainspoem.entity.WhiteMonkeyEntity;
import net.mcreator.mountainspoem.entity.WanderingGhostEntity;
import net.mcreator.mountainspoem.entity.UnderGhostEntity;
import net.mcreator.mountainspoem.entity.StoneEntity;
import net.mcreator.mountainspoem.entity.SouthernMountainsGodHeadEntity;
import net.mcreator.mountainspoem.entity.SouthSecondMountainsGodEntity;
import net.mcreator.mountainspoem.entity.SouthMountainGodEntity;
import net.mcreator.mountainspoem.entity.SoulShardEntity;
import net.mcreator.mountainspoem.entity.ShanGaoPigEntity;
import net.mcreator.mountainspoem.entity.RiverMermanEntity;
import net.mcreator.mountainspoem.entity.RedRuWarmoceanEntity;
import net.mcreator.mountainspoem.entity.QingGenBirdEntity;
import net.mcreator.mountainspoem.entity.PlagueBallEntity;
import net.mcreator.mountainspoem.entity.NineTailedFoxEntity;
import net.mcreator.mountainspoem.entity.MinQuBirdEntity;
import net.mcreator.mountainspoem.entity.LushuhorseEntity;
import net.mcreator.mountainspoem.entity.LufishEntity;
import net.mcreator.mountainspoem.entity.LoongHeadHorseBodyGodEntity;
import net.mcreator.mountainspoem.entity.LongChiEntity;
import net.mcreator.mountainspoem.entity.LeiEntity;
import net.mcreator.mountainspoem.entity.JufuEntity;
import net.mcreator.mountainspoem.entity.ImperialExaminationGhostEntity;
import net.mcreator.mountainspoem.entity.HuiHorseEntity;
import net.mcreator.mountainspoem.entity.HuanEntity;
import net.mcreator.mountainspoem.entity.HuaSnakeEntity;
import net.mcreator.mountainspoem.entity.HuHorseEntity;
import net.mcreator.mountainspoem.entity.HangedGhostEntity;
import net.mcreator.mountainspoem.entity.GuEagleEntity;
import net.mcreator.mountainspoem.entity.GhostCordageEntity;
import net.mcreator.mountainspoem.entity.FuriousSouthernMountainsGodHeadEntity;
import net.mcreator.mountainspoem.entity.FenghuangPhoenixEntity;
import net.mcreator.mountainspoem.entity.FeiBullEntity;
import net.mcreator.mountainspoem.entity.CrimsonXuanTortoiseEntity;
import net.mcreator.mountainspoem.entity.ChangfuChickenPlainsEntity;
import net.mcreator.mountainspoem.entity.BronzeDevourerEntity;
import net.mcreator.mountainspoem.entity.BoshiGoatEntity;
import net.mcreator.mountainspoem.entity.AoYinEntity;
import net.mcreator.mountainspoem.MountainsPoemMod;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class MountainsPoemModEntities {
	public static final DeferredRegister<EntityType<?>> REGISTRY = DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, MountainsPoemMod.MODID);
	public static final RegistryObject<EntityType<RedRuWarmoceanEntity>> RED_RU = register("red_ru",
			EntityType.Builder.<RedRuWarmoceanEntity>of(RedRuWarmoceanEntity::new, MobCategory.WATER_CREATURE).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(RedRuWarmoceanEntity::new)

					.sized(0.6f, 0.4f));
	public static final RegistryObject<EntityType<LeiEntity>> LEI = register("lei",
			EntityType.Builder.<LeiEntity>of(LeiEntity::new, MobCategory.CREATURE).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(LeiEntity::new)

					.sized(1.4f, 1.2f));
	public static final RegistryObject<EntityType<XuanTortoiseEntity>> XUAN_TORTOISE = register("xuan_tortoise",
			EntityType.Builder.<XuanTortoiseEntity>of(XuanTortoiseEntity::new, MobCategory.WATER_CREATURE).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(XuanTortoiseEntity::new)

					.sized(0.7f, 0.5f));
	public static final RegistryObject<EntityType<ChangfuChickenPlainsEntity>> CHANGFU_CHICKEN = register("changfu_chicken",
			EntityType.Builder.<ChangfuChickenPlainsEntity>of(ChangfuChickenPlainsEntity::new, MobCategory.CREATURE).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3)
					.setCustomClientFactory(ChangfuChickenPlainsEntity::new)

					.sized(3f, 2f));
	public static final RegistryObject<EntityType<LufishEntity>> LUFISH = register("lufish",
			EntityType.Builder.<LufishEntity>of(LufishEntity::new, MobCategory.WATER_CREATURE).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(LufishEntity::new)

					.sized(1f, 0.2f));
	public static final RegistryObject<EntityType<WoodWormsEntity>> WOOD_WORMS = register("wood_worms",
			EntityType.Builder.<WoodWormsEntity>of(WoodWormsEntity::new, MobCategory.CREATURE).setShouldReceiveVelocityUpdates(true).setTrackingRange(20).setUpdateInterval(3).setCustomClientFactory(WoodWormsEntity::new)

					.sized(0.2f, 0.1f));
	public static final RegistryObject<EntityType<BoshiGoatEntity>> BOYI_GOAT = register("boyi_goat",
			EntityType.Builder.<BoshiGoatEntity>of(BoshiGoatEntity::new, MobCategory.CREATURE).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(BoshiGoatEntity::new)

					.sized(1.7f, 1.4f));
	public static final RegistryObject<EntityType<WhiteMonkeyEntity>> WHITE_MONKEY = register("white_monkey",
			EntityType.Builder.<WhiteMonkeyEntity>of(WhiteMonkeyEntity::new, MobCategory.CREATURE).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(WhiteMonkeyEntity::new)

					.sized(1.6f, 1.5f));
	public static final RegistryObject<EntityType<NineTailedFoxEntity>> NINE_TAILED_FOX = register("nine_tailed_fox",
			EntityType.Builder.<NineTailedFoxEntity>of(NineTailedFoxEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(NineTailedFoxEntity::new)

					.sized(1.4f, 1.3f));
	public static final RegistryObject<EntityType<GuEagleEntity>> GU_EAGLE = register("gu_eagle",
			EntityType.Builder.<GuEagleEntity>of(GuEagleEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(GuEagleEntity::new)

					.sized(1.5f, 1.1f));
	public static final RegistryObject<EntityType<FeiBullEntity>> FEI_BULL = register("fei_bull",
			EntityType.Builder.<FeiBullEntity>of(FeiBullEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(FeiBullEntity::new).fireImmune().sized(3f, 2.5f));
	public static final RegistryObject<EntityType<LushuhorseEntity>> LUSHUHORSE = register("lushuhorse",
			EntityType.Builder.<LushuhorseEntity>of(LushuhorseEntity::new, MobCategory.CREATURE).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(LushuhorseEntity::new)

					.sized(1.4f, 1.5f));
	public static final RegistryObject<EntityType<SouthMountainGodEntity>> SOUTH_MOUNTAIN_GOD = register("south_mountain_god", EntityType.Builder.<SouthMountainGodEntity>of(SouthMountainGodEntity::new, MobCategory.CREATURE)
			.setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(SouthMountainGodEntity::new).fireImmune().sized(8.5f, 4f));
	public static final RegistryObject<EntityType<SouthSecondMountainsGodEntity>> SOUTH_SECOND_MOUNTAINS_GOD = register("south_second_mountains_god",
			EntityType.Builder.<SouthSecondMountainsGodEntity>of(SouthSecondMountainsGodEntity::new, MobCategory.CREATURE).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3)
					.setCustomClientFactory(SouthSecondMountainsGodEntity::new).fireImmune().sized(2.1f, 1.8f));
	public static final RegistryObject<EntityType<ZuoCowEntity>> ZUO_COW = register("zuo_cow",
			EntityType.Builder.<ZuoCowEntity>of(ZuoCowEntity::new, MobCategory.CREATURE).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(ZuoCowEntity::new)

					.sized(1.6f, 1.3f));
	public static final RegistryObject<EntityType<MinQuBirdEntity>> MIN_QU_BIRD = register("min_qu_bird",
			EntityType.Builder.<MinQuBirdEntity>of(MinQuBirdEntity::new, MobCategory.CREATURE).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(MinQuBirdEntity::new)

					.sized(0.6f, 0.4f));
	public static final RegistryObject<EntityType<XianGoatEntity>> XIAN_GOAT = register("xian_goat",
			EntityType.Builder.<XianGoatEntity>of(XianGoatEntity::new, MobCategory.CREATURE).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(XianGoatEntity::new)

					.sized(2f, 1.3f));
	public static final RegistryObject<EntityType<ZhiEntity>> ZHI = register("zhi",
			EntityType.Builder.<ZhiEntity>of(ZhiEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(ZhiEntity::new)

					.sized(1.8f, 1.4f));
	public static final RegistryObject<EntityType<FenghuangPhoenixEntity>> FENGHUANG_PHOENIX = register("fenghuang_phoenix", EntityType.Builder.<FenghuangPhoenixEntity>of(FenghuangPhoenixEntity::new, MobCategory.CREATURE)
			.setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(FenghuangPhoenixEntity::new).fireImmune().sized(0.8f, 0.6f));
	public static final RegistryObject<EntityType<HuHorseEntity>> WATER_HORSE = register("water_horse",
			EntityType.Builder.<HuHorseEntity>of(HuHorseEntity::new, MobCategory.CREATURE).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(HuHorseEntity::new)

					.sized(1.5f, 1.6f));
	public static final RegistryObject<EntityType<QingGenBirdEntity>> QING_GENG_BIRD = register("qing_geng_bird",
			EntityType.Builder.<QingGenBirdEntity>of(QingGenBirdEntity::new, MobCategory.CREATURE).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(QingGenBirdEntity::new)

					.sized(0.6f, 0.3f));
	public static final RegistryObject<EntityType<HuiHorseEntity>> HUN_HORSE = register("hun_horse",
			EntityType.Builder.<HuiHorseEntity>of(HuiHorseEntity::new, MobCategory.CREATURE).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(HuiHorseEntity::new)

					.sized(2f, 2f));
	public static final RegistryObject<EntityType<HuaSnakeEntity>> HUA_SNAKE = register("hua_snake",
			EntityType.Builder.<HuaSnakeEntity>of(HuaSnakeEntity::new, MobCategory.WATER_CREATURE).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(HuaSnakeEntity::new)

					.sized(2.4f, 1.7f));
	public static final RegistryObject<EntityType<RiverMermanEntity>> RIVER_MERMAN = register("river_merman",
			EntityType.Builder.<RiverMermanEntity>of(RiverMermanEntity::new, MobCategory.WATER_CREATURE).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(RiverMermanEntity::new)

					.sized(1.2f, 1.2f));
	public static final RegistryObject<EntityType<ShanGaoPigEntity>> SHAN_GAO_PIG = register("shan_gao_pig",
			EntityType.Builder.<ShanGaoPigEntity>of(ShanGaoPigEntity::new, MobCategory.CREATURE).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(ShanGaoPigEntity::new)

					.sized(1f, 1.1f));
	public static final RegistryObject<EntityType<PlagueBallEntity>> PLAGUE_BALL = register("plague_ball",
			EntityType.Builder.<PlagueBallEntity>of(PlagueBallEntity::new, MobCategory.MISC).setCustomClientFactory(PlagueBallEntity::new).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1).sized(0.5f, 0.5f));
	public static final RegistryObject<EntityType<ZhengEntity>> ZHENG = register("zheng",
			EntityType.Builder.<ZhengEntity>of(ZhengEntity::new, MobCategory.CREATURE).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(ZhengEntity::new)

					.sized(1.5f, 1.4f));
	public static final RegistryObject<EntityType<AoYinEntity>> AO_YIN = register("ao_yin",
			EntityType.Builder.<AoYinEntity>of(AoYinEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(AoYinEntity::new).fireImmune().sized(2.2f, 2.9f));
	public static final RegistryObject<EntityType<GhostCordageEntity>> GHOST_CORDAGE = register("ghost_cordage",
			EntityType.Builder.<GhostCordageEntity>of(GhostCordageEntity::new, MobCategory.MISC).setCustomClientFactory(GhostCordageEntity::new).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1).sized(0.5f, 0.5f));
	public static final RegistryObject<EntityType<HangedGhostEntity>> HANGED_GHOST = register("hanged_ghost",
			EntityType.Builder.<HangedGhostEntity>of(HangedGhostEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(32).setUpdateInterval(3).setCustomClientFactory(HangedGhostEntity::new)

					.sized(1f, 2f));
	public static final RegistryObject<EntityType<ImperialExaminationGhostEntity>> IMPERIAL_EXAMINATION_GHOST = register("imperial_examination_ghost",
			EntityType.Builder.<ImperialExaminationGhostEntity>of(ImperialExaminationGhostEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(32).setUpdateInterval(3)
					.setCustomClientFactory(ImperialExaminationGhostEntity::new)

					.sized(1f, 2.1f));
	public static final RegistryObject<EntityType<WanderingGhostEntity>> WANDERING_GHOST = register("wandering_ghost",
			EntityType.Builder.<WanderingGhostEntity>of(WanderingGhostEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(32).setUpdateInterval(3).setCustomClientFactory(WanderingGhostEntity::new)

					.sized(1f, 2.1f));
	public static final RegistryObject<EntityType<HuanEntity>> HUAN = register("huan",
			EntityType.Builder.<HuanEntity>of(HuanEntity::new, MobCategory.CREATURE).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(HuanEntity::new)

					.sized(2f, 1.3f));
	public static final RegistryObject<EntityType<UnderGhostEntity>> UNDER_GHOST = register("under_ghost",
			EntityType.Builder.<UnderGhostEntity>of(UnderGhostEntity::new, MobCategory.CREATURE).setShouldReceiveVelocityUpdates(true).setTrackingRange(32).setUpdateInterval(3).setCustomClientFactory(UnderGhostEntity::new)

					.sized(1f, 2.1f));
	public static final RegistryObject<EntityType<SoulShardEntity>> SOUL_SHARD = register("soul_shard", EntityType.Builder.<SoulShardEntity>of(SoulShardEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64)
			.setUpdateInterval(3).setCustomClientFactory(SoulShardEntity::new).fireImmune().sized(0.6f, 1.8f));
	public static final RegistryObject<EntityType<LongChiEntity>> LONG_CHI = register("long_chi",
			EntityType.Builder.<LongChiEntity>of(LongChiEntity::new, MobCategory.CREATURE).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(LongChiEntity::new)

					.sized(1.8f, 1.2f));
	public static final RegistryObject<EntityType<ZhuHuaiEntity>> ZHU_HUAI = register("zhu_huai",
			EntityType.Builder.<ZhuHuaiEntity>of(ZhuHuaiEntity::new, MobCategory.CREATURE).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(ZhuHuaiEntity::new)

					.sized(1.9f, 1.7f));
	public static final RegistryObject<EntityType<StoneEntity>> STONE = register("stone",
			EntityType.Builder.<StoneEntity>of(StoneEntity::new, MobCategory.MISC).setCustomClientFactory(StoneEntity::new).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1).sized(0.5f, 0.5f));
	public static final RegistryObject<EntityType<JufuEntity>> JUFU = register("jufu",
			EntityType.Builder.<JufuEntity>of(JufuEntity::new, MobCategory.CREATURE).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(JufuEntity::new)

					.sized(1.5f, 1.6f));
	public static final RegistryObject<EntityType<CrimsonXuanTortoiseEntity>> CRIMSON_XUAN_TORTOISE = register("crimson_xuan_tortoise",
			EntityType.Builder.<CrimsonXuanTortoiseEntity>of(CrimsonXuanTortoiseEntity::new, MobCategory.CREATURE).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(CrimsonXuanTortoiseEntity::new)

					.sized(1f, 0.5f));
	public static final RegistryObject<EntityType<LoongHeadHorseBodyGodEntity>> LOONG_HEAD_HORSE_BODY_GOD = register("loong_head_horse_body_god",
			EntityType.Builder.<LoongHeadHorseBodyGodEntity>of(LoongHeadHorseBodyGodEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3)
					.setCustomClientFactory(LoongHeadHorseBodyGodEntity::new)

					.sized(4.75f, 3.4f));
	public static final RegistryObject<EntityType<SouthernMountainsGodHeadEntity>> SOUTHERN_MOUNTAINS_GOD_HEAD = register("southern_mountains_god_head",
			EntityType.Builder.<SouthernMountainsGodHeadEntity>of(SouthernMountainsGodHeadEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3)
					.setCustomClientFactory(SouthernMountainsGodHeadEntity::new)

					.sized(1.5f, 1.5f));
	public static final RegistryObject<EntityType<FuriousSouthernMountainsGodHeadEntity>> FURIOUS_SOUTHERN_MOUNTAINS_GOD_HEAD = register("furious_southern_mountains_god_head",
			EntityType.Builder.<FuriousSouthernMountainsGodHeadEntity>of(FuriousSouthernMountainsGodHeadEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3)
					.setCustomClientFactory(FuriousSouthernMountainsGodHeadEntity::new)

					.sized(1.5f, 1.5f));
	public static final RegistryObject<EntityType<BronzeDevourerEntity>> BRONZE_DEVOURER = register("bronze_devourer",
			EntityType.Builder.<BronzeDevourerEntity>of(BronzeDevourerEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(BronzeDevourerEntity::new)

					.sized(0.6f, 1f));

	private static <T extends Entity> RegistryObject<EntityType<T>> register(String registryname, EntityType.Builder<T> entityTypeBuilder) {
		return REGISTRY.register(registryname, () -> (EntityType<T>) entityTypeBuilder.build(registryname));
	}

	@SubscribeEvent
	public static void init(FMLCommonSetupEvent event) {
		event.enqueueWork(() -> {
			RedRuWarmoceanEntity.init();
			LeiEntity.init();
			XuanTortoiseEntity.init();
			ChangfuChickenPlainsEntity.init();
			LufishEntity.init();
			WoodWormsEntity.init();
			BoshiGoatEntity.init();
			WhiteMonkeyEntity.init();
			NineTailedFoxEntity.init();
			GuEagleEntity.init();
			FeiBullEntity.init();
			LushuhorseEntity.init();
			SouthMountainGodEntity.init();
			SouthSecondMountainsGodEntity.init();
			ZuoCowEntity.init();
			MinQuBirdEntity.init();
			XianGoatEntity.init();
			ZhiEntity.init();
			FenghuangPhoenixEntity.init();
			HuHorseEntity.init();
			QingGenBirdEntity.init();
			HuiHorseEntity.init();
			HuaSnakeEntity.init();
			RiverMermanEntity.init();
			ShanGaoPigEntity.init();
			ZhengEntity.init();
			AoYinEntity.init();
			HangedGhostEntity.init();
			ImperialExaminationGhostEntity.init();
			WanderingGhostEntity.init();
			HuanEntity.init();
			UnderGhostEntity.init();
			SoulShardEntity.init();
			LongChiEntity.init();
			ZhuHuaiEntity.init();
			JufuEntity.init();
			CrimsonXuanTortoiseEntity.init();
			LoongHeadHorseBodyGodEntity.init();
			SouthernMountainsGodHeadEntity.init();
			FuriousSouthernMountainsGodHeadEntity.init();
			BronzeDevourerEntity.init();
		});
	}

	@SubscribeEvent
	public static void registerAttributes(EntityAttributeCreationEvent event) {
		event.put(RED_RU.get(), RedRuWarmoceanEntity.createAttributes().build());
		event.put(LEI.get(), LeiEntity.createAttributes().build());
		event.put(XUAN_TORTOISE.get(), XuanTortoiseEntity.createAttributes().build());
		event.put(CHANGFU_CHICKEN.get(), ChangfuChickenPlainsEntity.createAttributes().build());
		event.put(LUFISH.get(), LufishEntity.createAttributes().build());
		event.put(WOOD_WORMS.get(), WoodWormsEntity.createAttributes().build());
		event.put(BOYI_GOAT.get(), BoshiGoatEntity.createAttributes().build());
		event.put(WHITE_MONKEY.get(), WhiteMonkeyEntity.createAttributes().build());
		event.put(NINE_TAILED_FOX.get(), NineTailedFoxEntity.createAttributes().build());
		event.put(GU_EAGLE.get(), GuEagleEntity.createAttributes().build());
		event.put(FEI_BULL.get(), FeiBullEntity.createAttributes().build());
		event.put(LUSHUHORSE.get(), LushuhorseEntity.createAttributes().build());
		event.put(SOUTH_MOUNTAIN_GOD.get(), SouthMountainGodEntity.createAttributes().build());
		event.put(SOUTH_SECOND_MOUNTAINS_GOD.get(), SouthSecondMountainsGodEntity.createAttributes().build());
		event.put(ZUO_COW.get(), ZuoCowEntity.createAttributes().build());
		event.put(MIN_QU_BIRD.get(), MinQuBirdEntity.createAttributes().build());
		event.put(XIAN_GOAT.get(), XianGoatEntity.createAttributes().build());
		event.put(ZHI.get(), ZhiEntity.createAttributes().build());
		event.put(FENGHUANG_PHOENIX.get(), FenghuangPhoenixEntity.createAttributes().build());
		event.put(WATER_HORSE.get(), HuHorseEntity.createAttributes().build());
		event.put(QING_GENG_BIRD.get(), QingGenBirdEntity.createAttributes().build());
		event.put(HUN_HORSE.get(), HuiHorseEntity.createAttributes().build());
		event.put(HUA_SNAKE.get(), HuaSnakeEntity.createAttributes().build());
		event.put(RIVER_MERMAN.get(), RiverMermanEntity.createAttributes().build());
		event.put(SHAN_GAO_PIG.get(), ShanGaoPigEntity.createAttributes().build());
		event.put(ZHENG.get(), ZhengEntity.createAttributes().build());
		event.put(AO_YIN.get(), AoYinEntity.createAttributes().build());
		event.put(HANGED_GHOST.get(), HangedGhostEntity.createAttributes().build());
		event.put(IMPERIAL_EXAMINATION_GHOST.get(), ImperialExaminationGhostEntity.createAttributes().build());
		event.put(WANDERING_GHOST.get(), WanderingGhostEntity.createAttributes().build());
		event.put(HUAN.get(), HuanEntity.createAttributes().build());
		event.put(UNDER_GHOST.get(), UnderGhostEntity.createAttributes().build());
		event.put(SOUL_SHARD.get(), SoulShardEntity.createAttributes().build());
		event.put(LONG_CHI.get(), LongChiEntity.createAttributes().build());
		event.put(ZHU_HUAI.get(), ZhuHuaiEntity.createAttributes().build());
		event.put(JUFU.get(), JufuEntity.createAttributes().build());
		event.put(CRIMSON_XUAN_TORTOISE.get(), CrimsonXuanTortoiseEntity.createAttributes().build());
		event.put(LOONG_HEAD_HORSE_BODY_GOD.get(), LoongHeadHorseBodyGodEntity.createAttributes().build());
		event.put(SOUTHERN_MOUNTAINS_GOD_HEAD.get(), SouthernMountainsGodHeadEntity.createAttributes().build());
		event.put(FURIOUS_SOUTHERN_MOUNTAINS_GOD_HEAD.get(), FuriousSouthernMountainsGodHeadEntity.createAttributes().build());
		event.put(BRONZE_DEVOURER.get(), BronzeDevourerEntity.createAttributes().build());
	}
}
