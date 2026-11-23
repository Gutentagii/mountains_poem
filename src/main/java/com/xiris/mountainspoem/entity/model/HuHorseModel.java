package com.xiris.mountainspoem.entity.model;

import com.xiris.mountainspoem.MountainsPoemMod;
import com.xiris.mountainspoem.entity.HuHorseEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class HuHorseModel extends GeoModel<HuHorseEntity> {
	@Override
	public ResourceLocation getAnimationResource(HuHorseEntity entity) {
		return ResourceLocation.fromNamespaceAndPath(MountainsPoemMod.MOD_ID, "animations/hu_horse.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(HuHorseEntity entity) {
		return ResourceLocation.fromNamespaceAndPath(MountainsPoemMod.MOD_ID, "geo/hu_horse.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(HuHorseEntity entity) {
		return ResourceLocation.fromNamespaceAndPath(MountainsPoemMod.MOD_ID, "textures/entities/water_horse/" + entity.getTexture() + ".png");
	}

}
