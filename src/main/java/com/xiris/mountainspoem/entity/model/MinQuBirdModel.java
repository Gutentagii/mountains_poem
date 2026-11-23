package com.xiris.mountainspoem.entity.model;

import com.xiris.mountainspoem.MountainsPoemMod;
import com.xiris.mountainspoem.entity.MinQuBirdEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class MinQuBirdModel extends GeoModel<MinQuBirdEntity> {
	@Override
	public ResourceLocation getAnimationResource(MinQuBirdEntity entity) {
		return ResourceLocation.fromNamespaceAndPath(MountainsPoemMod.MOD_ID, "animations/mingqu.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(MinQuBirdEntity entity) {
		return ResourceLocation.fromNamespaceAndPath(MountainsPoemMod.MOD_ID, "geo/mingqu.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(MinQuBirdEntity entity) {
		return ResourceLocation.fromNamespaceAndPath(MountainsPoemMod.MOD_ID, "textures/entities/mingqu_bird/" + entity.getTexture() + ".png");
	}

}
