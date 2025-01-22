package net.mcreator.mountainspoem.entity.model;

import software.bernie.geckolib.model.GeoModel;

import net.minecraft.resources.ResourceLocation;

import net.mcreator.mountainspoem.entity.HuanEntity;

public class HuanModel extends GeoModel<HuanEntity> {
	@Override
	public ResourceLocation getAnimationResource(HuanEntity entity) {
		return new ResourceLocation("mountains_poem", "animations/huan.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(HuanEntity entity) {
		return new ResourceLocation("mountains_poem", "geo/huan.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(HuanEntity entity) {
		return new ResourceLocation("mountains_poem", "textures/entities/" + entity.getTexture() + ".png");
	}

}
