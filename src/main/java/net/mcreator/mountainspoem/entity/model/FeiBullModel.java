package net.mcreator.mountainspoem.entity.model;

import software.bernie.geckolib.model.GeoModel;

import net.mcreator.mountainspoem.entity.FeiBullEntity;

public class FeiBullModel extends GeoModel<FeiBullEntity> {
	@Override
	public ResourceLocation getAnimationResource(FeiBullEntity entity) {
		return new ResourceLocation("mountains_poem", "animations/fei_bull.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(FeiBullEntity entity) {
		return new ResourceLocation("mountains_poem", "geo/fei_bull.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(FeiBullEntity entity) {
		return new ResourceLocation("mountains_poem", "textures/entities/" + entity.getTexture() + ".png");
	}

}
