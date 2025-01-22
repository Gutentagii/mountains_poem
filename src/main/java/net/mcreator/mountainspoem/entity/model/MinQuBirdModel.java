package net.mcreator.mountainspoem.entity.model;

import software.bernie.geckolib.model.GeoModel;

import net.minecraft.resources.ResourceLocation;

import net.mcreator.mountainspoem.entity.MinQuBirdEntity;

public class MinQuBirdModel extends GeoModel<MinQuBirdEntity> {
	@Override
	public ResourceLocation getAnimationResource(MinQuBirdEntity entity) {
		return new ResourceLocation("mountains_poem", "animations/mingqu.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(MinQuBirdEntity entity) {
		return new ResourceLocation("mountains_poem", "geo/mingqu.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(MinQuBirdEntity entity) {
		return new ResourceLocation("mountains_poem", "textures/entities/mingqu_bird/" + entity.getTexture() + ".png");
	}

}
