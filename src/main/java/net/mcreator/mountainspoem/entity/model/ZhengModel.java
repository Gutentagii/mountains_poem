package net.mcreator.mountainspoem.entity.model;

import software.bernie.geckolib.model.GeoModel;

import net.minecraft.resources.ResourceLocation;

import net.mcreator.mountainspoem.entity.ZhengEntity;

public class ZhengModel extends GeoModel<ZhengEntity> {
	@Override
	public ResourceLocation getAnimationResource(ZhengEntity entity) {
		return new ResourceLocation("mountains_poem", "animations/zheng.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(ZhengEntity entity) {
		return new ResourceLocation("mountains_poem", "geo/zheng.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(ZhengEntity entity) {
		return new ResourceLocation("mountains_poem", "textures/entities/" + entity.getTexture() + ".png");
	}

}
