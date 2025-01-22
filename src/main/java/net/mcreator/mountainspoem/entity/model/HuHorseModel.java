package net.mcreator.mountainspoem.entity.model;

import software.bernie.geckolib.model.GeoModel;

import net.minecraft.resources.ResourceLocation;
 
import net.mcreator.mountainspoem.entity.HuHorseEntity;

public class HuHorseModel extends GeoModel<HuHorseEntity> {
	@Override
	public ResourceLocation getAnimationResource(HuHorseEntity entity) {
		return new ResourceLocation("mountains_poem", "animations/hu_horse.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(HuHorseEntity entity) {
		return new ResourceLocation("mountains_poem", "geo/hu_horse.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(HuHorseEntity entity) {
		return new ResourceLocation("mountains_poem", "textures/entities/water_horse/" + entity.getTexture() + ".png");
	}

}
