package net.mcreator.mountainspoem.entity.model;

import software.bernie.geckolib.model.GeoModel;

import net.minecraft.resources.ResourceLocation;

import net.mcreator.mountainspoem.entity.SouthMountainGodEntity;

public class SouthMountainGodModel extends GeoModel<SouthMountainGodEntity> {
	@Override
	public ResourceLocation getAnimationResource(SouthMountainGodEntity entity) { 
		return new ResourceLocation("mountains_poem", "animations/south_mountains_god.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(SouthMountainGodEntity entity) {
		return new ResourceLocation("mountains_poem", "geo/south_mountains_god.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(SouthMountainGodEntity entity) {
		return new ResourceLocation("mountains_poem", "textures/entities/south_god_1/" + entity.getTexture() + ".png");
	}

}
//south_god_1
