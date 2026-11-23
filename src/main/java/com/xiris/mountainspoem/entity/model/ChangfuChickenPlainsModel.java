package com.xiris.mountainspoem.entity.model;

import com.xiris.mountainspoem.MountainsPoemMod;
import com.xiris.mountainspoem.entity.ChangfuChickenPlainsEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class ChangfuChickenPlainsModel extends GeoModel<ChangfuChickenPlainsEntity> {
	@Override
	public ResourceLocation getAnimationResource(ChangfuChickenPlainsEntity entity) {
		return ResourceLocation.fromNamespaceAndPath(MountainsPoemMod.MOD_ID, "animations/changfu.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(ChangfuChickenPlainsEntity entity) {
		return ResourceLocation.fromNamespaceAndPath(MountainsPoemMod.MOD_ID, "geo/changfu.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(ChangfuChickenPlainsEntity entity) {
		return ResourceLocation.fromNamespaceAndPath(MountainsPoemMod.MOD_ID, "textures/entities/changfu_chick/" + entity.getTexture() + ".png");
	}

}
