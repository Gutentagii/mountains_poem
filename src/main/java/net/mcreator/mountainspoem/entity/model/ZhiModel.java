package net.mcreator.mountainspoem.entity.model;

import software.bernie.geckolib.model.GeoModel;

import net.minecraft.resources.ResourceLocation;

import net.mcreator.mountainspoem.entity.ZhiEntity;

public class ZhiModel extends GeoModel<ZhiEntity> {
	@Override
	public ResourceLocation getAnimationResource(ZhiEntity entity) {
		return new ResourceLocation("mountains_poem", "animations/zhi.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(ZhiEntity entity) {
		return new ResourceLocation("mountains_poem", "geo/zhi.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(ZhiEntity entity) {
		return new ResourceLocation("mountains_poem", "textures/entities/zhi/" + entity.getTexture() + ".png");
	}

}
