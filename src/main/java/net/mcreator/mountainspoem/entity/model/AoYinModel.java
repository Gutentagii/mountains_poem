package net.mcreator.mountainspoem.entity.model;

import software.bernie.geckolib.model.GeoModel;

import net.minecraft.resources.ResourceLocation;

import net.mcreator.mountainspoem.entity.AoYinEntity;

public class AoYinModel extends GeoModel<AoYinEntity> {
	@Override
	public ResourceLocation getAnimationResource(AoYinEntity entity) {
		return new ResourceLocation("mountains_poem", "animations/ao_yin.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(AoYinEntity entity) {
		return new ResourceLocation("mountains_poem", "geo/ao_yin.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(AoYinEntity entity) {
		return new ResourceLocation("mountains_poem", "textures/entities/" + entity.getTexture() + ".png");
	}

}
