package net.mcreator.mountainspoem.entity.model;

import software.bernie.geckolib.model.GeoModel;

import net.minecraft.resources.ResourceLocation;

import net.mcreator.mountainspoem.entity.ShanGaoPigEntity;

public class ShanGaoPigModel extends GeoModel<ShanGaoPigEntity> {
	@Override
	public ResourceLocation getAnimationResource(ShanGaoPigEntity entity) {
		return new ResourceLocation("mountains_poem", "animations/shan_gao_pig.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(ShanGaoPigEntity entity) {
		return new ResourceLocation("mountains_poem", "geo/shan_gao_pig.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(ShanGaoPigEntity entity) {
		return new ResourceLocation("mountains_poem", "textures/entities/shangao/" + entity.getTexture() + ".png");
	}

}
