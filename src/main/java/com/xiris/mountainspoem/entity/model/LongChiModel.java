package com.xiris.mountainspoem.entity.model;

import com.xiris.mountainspoem.MountainsPoemMod;
import com.xiris.mountainspoem.entity.LongChiEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class LongChiModel extends GeoModel<LongChiEntity> {
	@Override
	public ResourceLocation getAnimationResource(LongChiEntity entity) {
		return ResourceLocation.fromNamespaceAndPath(MountainsPoemMod.MOD_ID, "animations/long_chi.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(LongChiEntity entity) {
		return ResourceLocation.fromNamespaceAndPath(MountainsPoemMod.MOD_ID, "geo/long_chi.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(LongChiEntity entity) {
		return ResourceLocation.fromNamespaceAndPath(MountainsPoemMod.MOD_ID, "textures/entities/" + entity.getTexture() + ".png");
	}

}
