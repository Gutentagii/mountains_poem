package net.mcreator.mountainspoem.entity.model;

import software.bernie.geckolib.model.GeoModel;

import net.minecraft.resources.ResourceLocation;

import net.mcreator.mountainspoem.entity.QingGenBirdEntity;

public class QingGenBirdModel extends GeoModel<QingGenBirdEntity> {
	@Override
	public ResourceLocation getAnimationResource(QingGenBirdEntity entity) {
		return new ResourceLocation("mountains_poem", "animations/qingen.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(QingGenBirdEntity entity) {
		return new ResourceLocation("mountains_poem", "geo/qingen.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(QingGenBirdEntity entity) {
		return new ResourceLocation("mountains_poem", "textures/entities/qinggeng_bird/" + entity.getTexture() + ".png");
	}

}
