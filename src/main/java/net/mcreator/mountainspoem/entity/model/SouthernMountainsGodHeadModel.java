package net.mcreator.mountainspoem.entity.model;

import software.bernie.geckolib.model.GeoModel;

import net.mcreator.mountainspoem.entity.SouthernMountainsGodHeadEntity;

public class SouthernMountainsGodHeadModel extends GeoModel<SouthernMountainsGodHeadEntity> {
	@Override
	public ResourceLocation getAnimationResource(SouthernMountainsGodHeadEntity entity) {
		return new ResourceLocation("mountains_poem", "animations/south_mountains_god_head.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(SouthernMountainsGodHeadEntity entity) {
		return new ResourceLocation("mountains_poem", "geo/south_mountains_god_head.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(SouthernMountainsGodHeadEntity entity) {
		return new ResourceLocation("mountains_poem", "textures/entities/" + entity.getTexture() + ".png");
	}

}
