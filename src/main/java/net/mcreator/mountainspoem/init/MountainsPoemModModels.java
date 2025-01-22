
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.mountainspoem.init;

import net.mcreator.mountainspoem.client.model.Modelstone;
import net.mcreator.mountainspoem.client.model.Modelsoul_shards;
import net.mcreator.mountainspoem.client.model.Modelplague_ball;
import net.mcreator.mountainspoem.client.model.Modellei_arrow;
import net.mcreator.mountainspoem.client.model.Modelghost_cordage;
import net.mcreator.mountainspoem.client.model.Modelblood_copper_armor;
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
		event.registerLayerDefinition(Modelblood_copper_armor.LAYER_LOCATION, Modelblood_copper_armor::createBodyLayer);
		event.registerLayerDefinition(Modelsoul_shards.LAYER_LOCATION, Modelsoul_shards::createBodyLayer);
	}
}
