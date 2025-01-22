package net.mcreator.mountainspoem.entity.model;

import software.bernie.geckolib.model.GeoModel;

import net.minecraft.resources.ResourceLocation;

import net.mcreator.mountainspoem.entity.LongChiEntity;

public class LongChiModel extends GeoModel<LongChiEntity> {
	@Override
	public ResourceLocation getAnimationResource(LongChiEntity entity) {
		return new ResourceLocation("mountains_poem", "animations/long_chi.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(LongChiEntity entity) {
		return new ResourceLocation("mountains_poem", "geo/long_chi.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(LongChiEntity entity) {
		return new ResourceLocation("mountains_poem", "textures/entities/" + entity.getTexture() + ".png");
	}

}
