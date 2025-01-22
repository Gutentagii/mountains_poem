package net.mcreator.mountainspoem.entity.model;

import software.bernie.geckolib.model.GeoModel;

import net.minecraft.resources.ResourceLocation;

import net.mcreator.mountainspoem.entity.HuiHorseEntity;

public class HuiHorseModel extends GeoModel<HuiHorseEntity> {
	@Override
	public ResourceLocation getAnimationResource(HuiHorseEntity entity) {
		return new ResourceLocation("mountains_poem", "animations/hui_horse.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(HuiHorseEntity entity) {
		return new ResourceLocation("mountains_poem", "geo/hui_horse.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(HuiHorseEntity entity) {
		return new ResourceLocation("mountains_poem", "textures/entities/" + entity.getTexture() + ".png");
	}

}
