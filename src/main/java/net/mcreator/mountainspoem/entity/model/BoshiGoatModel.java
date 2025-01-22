package net.mcreator.mountainspoem.entity.model;

import software.bernie.geckolib.model.GeoModel;

import net.minecraft.resources.ResourceLocation;

import net.mcreator.mountainspoem.entity.BoshiGoatEntity;

public class BoshiGoatModel extends GeoModel<BoshiGoatEntity> {
	@Override
	public ResourceLocation getAnimationResource(BoshiGoatEntity entity) {
		return new ResourceLocation("mountains_poem", "animations/boshi_goat.animation.json");
	}
 
	@Override
	public ResourceLocation getModelResource(BoshiGoatEntity entity) {
		return new ResourceLocation("mountains_poem", "geo/boshi_goat.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(BoshiGoatEntity entity) {
		return new ResourceLocation("mountains_poem", "textures/entities/boshi_goat/" + entity.getTexture() + ".png");
	}

}
