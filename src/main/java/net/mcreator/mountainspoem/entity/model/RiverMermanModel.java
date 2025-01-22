package net.mcreator.mountainspoem.entity.model;

import software.bernie.geckolib.model.GeoModel;

import net.minecraft.resources.ResourceLocation;

import net.mcreator.mountainspoem.entity.RiverMermanEntity;

public class RiverMermanModel extends GeoModel<RiverMermanEntity> {
	@Override
	public ResourceLocation getAnimationResource(RiverMermanEntity entity) {
		return new ResourceLocation("mountains_poem", "animations/merman.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(RiverMermanEntity entity) {
		return new ResourceLocation("mountains_poem", "geo/merman.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(RiverMermanEntity entity) {
		return new ResourceLocation("mountains_poem", "textures/entities/merman/" + entity.getTexture() + ".png");
	}

}
