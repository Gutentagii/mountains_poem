
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package com.xiris.mountainspoem.init;

import com.xiris.mountainspoem.client.model.*;
import com.xiris.mountainspoem.client.model.*;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = {Dist.CLIENT})
public class MountainsPoemModModels {
	@SubscribeEvent
	public static void registerLayerDefinitions(EntityRenderersEvent.RegisterLayerDefinitions event) {
		event.registerLayerDefinition(Modelplague_ball.LAYER_LOCATION, Modelplague_ball::createBodyLayer);
		event.registerLayerDefinition(Modelghost_cordage.LAYER_LOCATION, Modelghost_cordage::createBodyLayer);
		event.registerLayerDefinition(Modellei_arrow.LAYER_LOCATION, Modellei_arrow::createBodyLayer);
		event.registerLayerDefinition(Modelstone.LAYER_LOCATION, Modelstone::createBodyLayer);
		event.registerLayerDefinition(Modelsoul_shards.LAYER_LOCATION, Modelsoul_shards::createBodyLayer);
        event.registerLayerDefinition(ModelUnder_iron.LAYER_LOCATION, ModelUnder_iron::createBodyLayer);
        event.registerLayerDefinition(ModelBlood_copper.LAYER_LOCATION, ModelBlood_copper::createBodyLayer);
        event.registerLayerDefinition(ModelAo_yin_fur_coat.LAYER_LOCATION, ModelAo_yin_fur_coat::createBodyLayer);
        event.registerLayerDefinition(ModelWhite_fox_coat.LAYER_LOCATION, ModelWhite_fox_coat::createBodyLayer);
	}
}
