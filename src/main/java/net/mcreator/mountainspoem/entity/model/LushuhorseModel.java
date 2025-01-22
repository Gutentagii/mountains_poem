package net.mcreator.mountainspoem.entity.model;

import software.bernie.geckolib.model.GeoModel;

import net.minecraft.resources.ResourceLocation;

import net.mcreator.mountainspoem.entity.LushuhorseEntity;

public class LushuhorseModel extends GeoModel<LushuhorseEntity> {
	@Override
	public ResourceLocation getAnimationResource(LushuhorseEntity entity) {
		return new ResourceLocation("mountains_poem", "animations/lushu_horse.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(LushuhorseEntity entity) {
		return new ResourceLocation("mountains_poem", "geo/lushu_horse.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(LushuhorseEntity entity) {
		return new ResourceLocation("mountains_poem", "textures/entities/lushu_horse/" + entity.getTexture() + ".png");
	}

}
