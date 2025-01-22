package net.mcreator.mountainspoem.entity.model;

import software.bernie.geckolib.model.GeoModel;

import net.mcreator.mountainspoem.entity.FuriousSouthernMountainsGodHeadEntity;

public class FuriousSouthernMountainsGodHeadModel extends GeoModel<FuriousSouthernMountainsGodHeadEntity> {
	@Override
	public ResourceLocation getAnimationResource(FuriousSouthernMountainsGodHeadEntity entity) {
		return new ResourceLocation("mountains_poem", "animations/south_mountains_god_head.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(FuriousSouthernMountainsGodHeadEntity entity) {
		return new ResourceLocation("mountains_poem", "geo/south_mountains_god_head.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(FuriousSouthernMountainsGodHeadEntity entity) {
		return new ResourceLocation("mountains_poem", "textures/entities/" + entity.getTexture() + ".png");
	}

}
