package net.mcreator.mountainspoem.entity.model;

import software.bernie.geckolib.model.GeoModel;

import net.minecraft.resources.ResourceLocation;

import net.mcreator.mountainspoem.entity.XianGoatEntity;

public class XianGoatModel extends GeoModel<XianGoatEntity> {
	@Override
	public ResourceLocation getAnimationResource(XianGoatEntity entity) {
		return new ResourceLocation("mountains_poem", "animations/xian_goat.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(XianGoatEntity entity) {
		return new ResourceLocation("mountains_poem", "geo/xian_goat.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(XianGoatEntity entity) {
		return new ResourceLocation("mountains_poem", "textures/entities/xian_goat/" + entity.getTexture() + ".png");
	}

}
