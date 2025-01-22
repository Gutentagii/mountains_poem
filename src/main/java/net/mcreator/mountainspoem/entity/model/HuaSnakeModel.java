package net.mcreator.mountainspoem.entity.model;

import software.bernie.geckolib.model.GeoModel;

import net.mcreator.mountainspoem.entity.HuaSnakeEntity;

public class HuaSnakeModel extends GeoModel<HuaSnakeEntity> {
	@Override
	public ResourceLocation getAnimationResource(HuaSnakeEntity entity) {
		return new ResourceLocation("mountains_poem", "animations/hua_snake.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(HuaSnakeEntity entity) {
		return new ResourceLocation("mountains_poem", "geo/hua_snake.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(HuaSnakeEntity entity) {
		return new ResourceLocation("mountains_poem", "textures/entities/" + entity.getTexture() + ".png");
	}

}
