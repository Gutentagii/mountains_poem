package net.mcreator.mountainspoem.entity.model;

import software.bernie.geckolib.model.GeoModel;

import net.minecraft.resources.ResourceLocation;

import net.mcreator.mountainspoem.entity.GuEagleEntity;

public class GuEagleModel extends GeoModel<GuEagleEntity> {
	@Override
	public ResourceLocation getAnimationResource(GuEagleEntity entity) {
		return new ResourceLocation("mountains_poem", "animations/gu_diao.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(GuEagleEntity entity) {
		return new ResourceLocation("mountains_poem", "geo/gu_diao.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(GuEagleEntity entity) {
		return new ResourceLocation("mountains_poem", "textures/entities/gu_diao/" + entity.getTexture() + ".png");
	}

}
