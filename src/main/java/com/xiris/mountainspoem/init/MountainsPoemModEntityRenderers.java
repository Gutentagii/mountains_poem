
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package com.xiris.mountainspoem.init;

import com.xiris.mountainspoem.client.renderer.*;
import com.xiris.mountainspoem.client.renderer.*;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class MountainsPoemModEntityRenderers {
	@SubscribeEvent
	public static void registerEntityRenderers(EntityRenderersEvent.RegisterRenderers event) {
		event.registerEntityRenderer(MountainsPoemModEntities.RED_RU.get(), RedRuWarmoceanRenderer::new);
		event.registerEntityRenderer(MountainsPoemModEntities.LEI.get(), LeiRenderer::new);
		event.registerEntityRenderer(MountainsPoemModEntities.XUAN_TORTOISE.get(), XuanTortoiseRenderer::new);
		event.registerEntityRenderer(MountainsPoemModEntities.CHANGFU_CHICKEN.get(), ChangfuChickenPlainsRenderer::new);
		event.registerEntityRenderer(MountainsPoemModEntities.LUFISH.get(), LufishRenderer::new);
		event.registerEntityRenderer(MountainsPoemModEntities.WOOD_WORMS.get(), WoodWormsRenderer::new);
		event.registerEntityRenderer(MountainsPoemModEntities.BOYI_GOAT.get(), BoshiGoatRenderer::new);
		event.registerEntityRenderer(MountainsPoemModEntities.WHITE_APE.get(), WhiteMonkeyRenderer::new);
		event.registerEntityRenderer(MountainsPoemModEntities.NINE_TAILED_FOX.get(), NineTailedFoxRenderer::new);
		event.registerEntityRenderer(MountainsPoemModEntities.GU_EAGLE.get(), GuEagleRenderer::new);
		event.registerEntityRenderer(MountainsPoemModEntities.FEI_BULL.get(), FeiBullRenderer::new);
		event.registerEntityRenderer(MountainsPoemModEntities.LUSHUHORSE.get(), LushuhorseRenderer::new);
		event.registerEntityRenderer(MountainsPoemModEntities.SOUTH_MOUNTAIN_GOD.get(), SouthMountainGodRenderer::new);
		event.registerEntityRenderer(MountainsPoemModEntities.SOUTH_SECOND_MOUNTAINS_GOD.get(), SouthSecondMountainsGodRenderer::new);
		event.registerEntityRenderer(MountainsPoemModEntities.ZUO_COW.get(), ZuoCowRenderer::new);
		event.registerEntityRenderer(MountainsPoemModEntities.MIN_QU_BIRD.get(), MinQuBirdRenderer::new);
		event.registerEntityRenderer(MountainsPoemModEntities.XIAN_GOAT.get(), XianGoatRenderer::new);
		event.registerEntityRenderer(MountainsPoemModEntities.ZHI.get(), ZhiRenderer::new);
		event.registerEntityRenderer(MountainsPoemModEntities.FENGHUANG_PHOENIX.get(), FenghuangPhoenixRenderer::new);
		event.registerEntityRenderer(MountainsPoemModEntities.WATER_HORSE.get(), HuHorseRenderer::new);
		event.registerEntityRenderer(MountainsPoemModEntities.QING_GENG_BIRD.get(), QingGenBirdRenderer::new);
		event.registerEntityRenderer(MountainsPoemModEntities.HUN_HORSE.get(), HuiHorseRenderer::new);
		event.registerEntityRenderer(MountainsPoemModEntities.HUA_SNAKE.get(), HuaSnakeRenderer::new);
		event.registerEntityRenderer(MountainsPoemModEntities.RIVER_MERMAN.get(), RiverMermanRenderer::new);
		event.registerEntityRenderer(MountainsPoemModEntities.SHAN_GAO_PIG.get(), ShanGaoPigRenderer::new);
		event.registerEntityRenderer(MountainsPoemModEntities.PLAGUE_BALL.get(), PlagueBallRenderer::new);
		event.registerEntityRenderer(MountainsPoemModEntities.ZHENG.get(), ZhengRenderer::new);
		event.registerEntityRenderer(MountainsPoemModEntities.AO_YIN.get(), AoYinRenderer::new);
		event.registerEntityRenderer(MountainsPoemModEntities.GHOST_CORDAGE.get(), GhostCordageRenderer::new);
		event.registerEntityRenderer(MountainsPoemModEntities.HANGED_GHOST.get(), HangedGhostRenderer::new);
		event.registerEntityRenderer(MountainsPoemModEntities.IMPERIAL_EXAMINATION_GHOST.get(), ImperialExaminationGhostRenderer::new);
		event.registerEntityRenderer(MountainsPoemModEntities.WANDERING_GHOST.get(), WanderingGhostRenderer::new);
		event.registerEntityRenderer(MountainsPoemModEntities.HUAN.get(), HuanRenderer::new);
		event.registerEntityRenderer(MountainsPoemModEntities.UNDER_GHOST.get(), UnderGhostRenderer::new);
		event.registerEntityRenderer(MountainsPoemModEntities.SOUL_SHARD.get(), SoulShardRenderer::new);
		event.registerEntityRenderer(MountainsPoemModEntities.LONG_CHI.get(), LongChiRenderer::new);
		event.registerEntityRenderer(MountainsPoemModEntities.ZHU_HUAI.get(), ZhuHuaiRenderer::new);
		event.registerEntityRenderer(MountainsPoemModEntities.STONE.get(), StoneRenderer::new);
		event.registerEntityRenderer(MountainsPoemModEntities.JUFU.get(), JufuRenderer::new);
		event.registerEntityRenderer(MountainsPoemModEntities.CRIMSON_XUAN_TORTOISE.get(), CrimsonXuanTortoiseRenderer::new);
		event.registerEntityRenderer(MountainsPoemModEntities.LOONG_HEAD_HORSE_BODY_GOD.get(), LoongHeadHorseBodyGodRenderer::new);
		event.registerEntityRenderer(MountainsPoemModEntities.SOUTHERN_MOUNTAINS_GOD_HEAD.get(), SouthernMountainsGodHeadRenderer::new);
		event.registerEntityRenderer(MountainsPoemModEntities.FURIOUS_SOUTHERN_MOUNTAINS_GOD_HEAD.get(), FuriousSouthernMountainsGodHeadRenderer::new);
		event.registerEntityRenderer(MountainsPoemModEntities.BRONZE_DEVOURER.get(), BronzeDevourerRenderer::new);
	}
}
