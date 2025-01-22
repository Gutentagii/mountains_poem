package net.mcreator.mountainspoem.entity.model;

import software.bernie.geckolib.model.GeoModel;

import net.minecraft.resources.ResourceLocation;

import net.mcreator.mountainspoem.entity.XuanTortoiseEntity;

public class XuanTortoiseModel extends GeoModel<XuanTortoiseEntity> {
	@Override
	public ResourceLocation getAnimationResource(XuanTortoiseEntity entity) {
		return new ResourceLocation("mountains_poem", "animations/xuan_tortoise.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(XuanTortoiseEntity entity) {
		return new ResourceLocation("mountains_poem", "geo/xuan_tortoise.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(XuanTortoiseEntity entity) {
		return new ResourceLocation("mountains_poem", "textures/entities/" + entity.getTexture() + ".png");
	}

}
