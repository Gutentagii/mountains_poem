package net.mcreator.mountainspoem.entity.model;

import software.bernie.geckolib.model.GeoModel;

import net.mcreator.mountainspoem.entity.LufishEntity;

public class LufishModel extends GeoModel<LufishEntity> {
	@Override
	public ResourceLocation getAnimationResource(LufishEntity entity) {
		return new ResourceLocation("mountains_poem", "animations/lufish.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(LufishEntity entity) {
		return new ResourceLocation("mountains_poem", "geo/lufish.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(LufishEntity entity) {
		return new ResourceLocation("mountains_poem", "textures/entities/" + entity.getTexture() + ".png");
	}

}
