package net.mcreator.mountainspoem.entity.model;

import software.bernie.geckolib.model.GeoModel;

import net.minecraft.resources.ResourceLocation;

import net.mcreator.mountainspoem.entity.ChangfuChickenPlainsEntity;

public class ChangfuChickenPlainsModel extends GeoModel<ChangfuChickenPlainsEntity> {
	@Override
	public ResourceLocation getAnimationResource(ChangfuChickenPlainsEntity entity) {
		return new ResourceLocation("mountains_poem", "animations/changfu.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(ChangfuChickenPlainsEntity entity) {
		return new ResourceLocation("mountains_poem", "geo/changfu.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(ChangfuChickenPlainsEntity entity) {
		return new ResourceLocation("mountains_poem", "textures/entities/changfu_chick/" + entity.getTexture() + ".png");
	}

}
