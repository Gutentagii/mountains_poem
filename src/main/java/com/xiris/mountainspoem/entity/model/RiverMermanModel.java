package com.xiris.mountainspoem.entity.model;

import com.xiris.mountainspoem.MountainsPoemMod;
import com.xiris.mountainspoem.entity.RiverMermanEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class RiverMermanModel extends GeoModel<RiverMermanEntity> {
	@Override
	public ResourceLocation getAnimationResource(RiverMermanEntity entity) {
		return ResourceLocation.fromNamespaceAndPath(MountainsPoemMod.MOD_ID, "animations/merman.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(RiverMermanEntity entity) {
		return ResourceLocation.fromNamespaceAndPath(MountainsPoemMod.MOD_ID, "geo/merman.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(RiverMermanEntity entity) {
		return ResourceLocation.fromNamespaceAndPath(MountainsPoemMod.MOD_ID, "textures/entities/merman/" + entity.getTexture() + ".png");
	}

}
