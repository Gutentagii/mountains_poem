package net.mcreator.mountainspoem.entity.model;

import software.bernie.geckolib.model.GeoModel;

import net.minecraft.resources.ResourceLocation;

import net.mcreator.mountainspoem.entity.FenghuangPhoenixEntity;

public class FenghuangPhoenixModel extends GeoModel<FenghuangPhoenixEntity> {
	@Override
	public ResourceLocation getAnimationResource(FenghuangPhoenixEntity entity) {
		return new ResourceLocation("mountains_poem", "animations/fenghuang_phoenix.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(FenghuangPhoenixEntity entity) {
		return new ResourceLocation("mountains_poem", "geo/fenghuang_phoenix.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(FenghuangPhoenixEntity entity) {
		return new ResourceLocation("mountains_poem", "textures/entities/" + entity.getTexture() + ".png");
	}

}
