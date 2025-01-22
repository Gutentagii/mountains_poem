package net.mcreator.mountainspoem.entity.model;

import software.bernie.geckolib.model.GeoModel;

import net.mcreator.mountainspoem.entity.BronzeDevourerEntity;

public class BronzeDevourerModel extends GeoModel<BronzeDevourerEntity> {
	@Override
	public ResourceLocation getAnimationResource(BronzeDevourerEntity entity) {
		return new ResourceLocation("mountains_poem", "animations/bronze_devourer.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(BronzeDevourerEntity entity) {
		return new ResourceLocation("mountains_poem", "geo/bronze_devourer.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(BronzeDevourerEntity entity) {
		return new ResourceLocation("mountains_poem", "textures/entities/" + entity.getTexture() + ".png");
	}

}
