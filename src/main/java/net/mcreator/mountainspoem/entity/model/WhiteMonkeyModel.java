package net.mcreator.mountainspoem.entity.model;

import software.bernie.geckolib.model.GeoModel;

import net.minecraft.resources.ResourceLocation;

import net.mcreator.mountainspoem.entity.WhiteMonkeyEntity;

public class WhiteMonkeyModel extends GeoModel<WhiteMonkeyEntity> {
	@Override
	public ResourceLocation getAnimationResource(WhiteMonkeyEntity entity) {
		return new ResourceLocation("mountains_poem", "animations/white_monkey.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(WhiteMonkeyEntity entity) {
		return new ResourceLocation("mountains_poem", "geo/white_monkey.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(WhiteMonkeyEntity entity) {
		return new ResourceLocation("mountains_poem", "textures/entities/" + entity.getTexture() + ".png");
	}

}
