package net.mcreator.mountainspoem.entity.model;

import software.bernie.geckolib.model.GeoModel;

import net.minecraft.resources.ResourceLocation;

import net.mcreator.mountainspoem.entity.RedRuWarmoceanEntity;

public class RedRuWarmoceanModel extends GeoModel<RedRuWarmoceanEntity> {
	@Override 
	public ResourceLocation getAnimationResource(RedRuWarmoceanEntity entity) {
		return new ResourceLocation("mountains_poem", "animations/redru.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(RedRuWarmoceanEntity entity) {
		return new ResourceLocation("mountains_poem", "geo/redru.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(RedRuWarmoceanEntity entity) {
		return new ResourceLocation("mountains_poem", "textures/entities/red_ru/" + entity.getTexture() + ".png");
	}

}
