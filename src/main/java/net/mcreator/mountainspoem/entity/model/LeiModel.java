package net.mcreator.mountainspoem.entity.model;

import software.bernie.geckolib.model.GeoModel;

import net.minecraft.resources.ResourceLocation;

import net.mcreator.mountainspoem.entity.LeiEntity;

public class LeiModel extends GeoModel<LeiEntity> {
	@Override
	public ResourceLocation getAnimationResource(LeiEntity entity) {
		return new ResourceLocation("mountains_poem", "animations/lei.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(LeiEntity entity) {
		return new ResourceLocation("mountains_poem", "geo/lei.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(LeiEntity entity) {
		return new ResourceLocation("mountains_poem", "textures/entities/lei/" + entity.getTexture() + ".png");
	}

}
