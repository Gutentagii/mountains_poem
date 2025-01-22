
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.mountainspoem.init;

import net.mcreator.mountainspoem.client.renderer.ZuoCowRenderer;
import net.mcreator.mountainspoem.client.renderer.ZhuHuaiRenderer;
import net.mcreator.mountainspoem.client.renderer.ZhiRenderer;
import net.mcreator.mountainspoem.client.renderer.ZhengRenderer;
import net.mcreator.mountainspoem.client.renderer.XuanTortoiseRenderer;
import net.mcreator.mountainspoem.client.renderer.XianGoatRenderer;
import net.mcreator.mountainspoem.client.renderer.WoodWormsRenderer;
import net.mcreator.mountainspoem.client.renderer.WhiteMonkeyRenderer;
import net.mcreator.mountainspoem.client.renderer.WanderingGhostRenderer;
import net.mcreator.mountainspoem.client.renderer.UnderGhostRenderer;
import net.mcreator.mountainspoem.client.renderer.StoneRenderer;
import net.mcreator.mountainspoem.client.renderer.SouthernMountainsGodHeadRenderer;
import net.mcreator.mountainspoem.client.renderer.SouthSecondMountainsGodRenderer;
import net.mcreator.mountainspoem.client.renderer.SouthMountainGodRenderer;
import net.mcreator.mountainspoem.client.renderer.SoulShardRenderer;
import net.mcreator.mountainspoem.client.renderer.ShanGaoPigRenderer;
import net.mcreator.mountainspoem.client.renderer.RiverMermanRenderer;
import net.mcreator.mountainspoem.client.renderer.RedRuWarmoceanRenderer;
import net.mcreator.mountainspoem.client.renderer.QingGenBirdRenderer;
import net.mcreator.mountainspoem.client.renderer.PlagueBallRenderer;
import net.mcreator.mountainspoem.client.renderer.NineTailedFoxRenderer;
import net.mcreator.mountainspoem.client.renderer.MinQuBirdRenderer;
import net.mcreator.mountainspoem.client.renderer.LushuhorseRenderer;
import net.mcreator.mountainspoem.client.renderer.LufishRenderer;
import net.mcreator.mountainspoem.client.renderer.LoongHeadHorseBodyGodRenderer;
import net.mcreator.mountainspoem.client.renderer.LongChiRenderer;
import net.mcreator.mountainspoem.client.renderer.LeiRenderer;
import net.mcreator.mountainspoem.client.renderer.JufuRenderer;
import net.mcreator.mountainspoem.client.renderer.ImperialExaminationGhostRenderer;
import net.mcreator.mountainspoem.client.renderer.HuiHorseRenderer;
import net.mcreator.mountainspoem.client.renderer.HuanRenderer;
import net.mcreator.mountainspoem.client.renderer.HuaSnakeRenderer;
import net.mcreator.mountainspoem.client.renderer.HuHorseRenderer;
import net.mcreator.mountainspoem.client.renderer.HangedGhostRenderer;
import net.mcreator.mountainspoem.client.renderer.GuEagleRenderer;
import net.mcreator.mountainspoem.client.renderer.GhostCordageRenderer;
import net.mcreator.mountainspoem.client.renderer.FuriousSouthernMountainsGodHeadRenderer;
import net.mcreator.mountainspoem.client.renderer.FenghuangPhoenixRenderer;
import net.mcreator.mountainspoem.client.renderer.FeiBullRenderer;
import net.mcreator.mountainspoem.client.renderer.CrimsonXuanTortoiseRenderer;
import net.mcreator.mountainspoem.client.renderer.ChangfuChickenPlainsRenderer;
import net.mcreator.mountainspoem.client.renderer.BronzeDevourerRenderer;
import net.mcreator.mountainspoem.client.renderer.BoshiGoatRenderer;
import net.mcreator.mountainspoem.client.renderer.AoYinRenderer;
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
		event.registerEntityRenderer(MountainsPoemModEntities.WHITE_MONKEY.get(), WhiteMonkeyRenderer::new);
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
