package net.mcreator.mountainspoem.entity.model;

import software.bernie.geckolib.model.GeoModel;

import net.minecraft.resources.ResourceLocation;

import net.mcreator.mountainspoem.entity.SouthSecondMountainsGodEntity;

public class SouthSecondMountainsGodModel extends GeoModel<SouthSecondMountainsGodEntity> {
	@Override
	public ResourceLocation getAnimationResource(SouthSecondMountainsGodEntity entity) {
		return new ResourceLocation("mountains_poem", "animations/south_mountains_second_god.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(SouthSecondMountainsGodEntity entity) {
		return new ResourceLocation("mountains_poem", "geo/south_mountains_second_god.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(SouthSecondMountainsGodEntity entity) {
		return new ResourceLocation("mountains_poem", "textures/entities/south_god_2/" + entity.getTexture() + ".png");
	}

}
