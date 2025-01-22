package net.mcreator.mountainspoem.entity.model;

import software.bernie.geckolib.model.GeoModel;

import net.mcreator.mountainspoem.entity.CrimsonXuanTortoiseEntity;

public class CrimsonXuanTortoiseModel extends GeoModel<CrimsonXuanTortoiseEntity> {
	@Override
	public ResourceLocation getAnimationResource(CrimsonXuanTortoiseEntity entity) {
		return new ResourceLocation("mountains_poem", "animations/crimson_xuan_tortoise.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(CrimsonXuanTortoiseEntity entity) {
		return new ResourceLocation("mountains_poem", "geo/crimson_xuan_tortoise.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(CrimsonXuanTortoiseEntity entity) {
		return new ResourceLocation("mountains_poem", "textures/entities/" + entity.getTexture() + ".png");
	}

}
