package com.xiris.mountainspoem.entity.model;

import com.xiris.mountainspoem.MountainsPoemMod;
import com.xiris.mountainspoem.entity.FeiBullEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class FeiBullModel extends GeoModel<FeiBullEntity> {
	@Override
	public ResourceLocation getAnimationResource(FeiBullEntity entity) {
		return ResourceLocation.fromNamespaceAndPath(MountainsPoemMod.MOD_ID, "animations/fei_bull.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(FeiBullEntity entity) {
		return ResourceLocation.fromNamespaceAndPath(MountainsPoemMod.MOD_ID, "geo/fei_bull.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(FeiBullEntity entity) {
		return ResourceLocation.fromNamespaceAndPath(MountainsPoemMod.MOD_ID, "textures/entities/" + entity.getTexture() + ".png");
	}

}
