package net.mcreator.mountainspoem.entity.model;

import software.bernie.geckolib.model.GeoModel;

import net.mcreator.mountainspoem.entity.LoongHeadHorseBodyGodEntity;

public class LoongHeadHorseBodyGodModel extends GeoModel<LoongHeadHorseBodyGodEntity> {
	@Override
	public ResourceLocation getAnimationResource(LoongHeadHorseBodyGodEntity entity) {
		return new ResourceLocation("mountains_poem", "animations/zhong_shan_god.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(LoongHeadHorseBodyGodEntity entity) {
		return new ResourceLocation("mountains_poem", "geo/zhong_shan_god.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(LoongHeadHorseBodyGodEntity entity) {
		return new ResourceLocation("mountains_poem", "textures/entities/" + entity.getTexture() + ".png");
	}

}
