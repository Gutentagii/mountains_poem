package com.xiris.mountainspoem.entity.model;

import com.xiris.mountainspoem.MountainsPoemMod;
import com.xiris.mountainspoem.entity.FenghuangPhoenixEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class FenghuangPhoenixModel extends GeoModel<FenghuangPhoenixEntity> {
	@Override
	public ResourceLocation getAnimationResource(FenghuangPhoenixEntity entity) {
		return ResourceLocation.fromNamespaceAndPath(MountainsPoemMod.MOD_ID, "animations/fenghuang_phoenix.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(FenghuangPhoenixEntity entity) {
		return ResourceLocation.fromNamespaceAndPath(MountainsPoemMod.MOD_ID, "geo/fenghuang_phoenix.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(FenghuangPhoenixEntity entity) {
		return ResourceLocation.fromNamespaceAndPath(MountainsPoemMod.MOD_ID, "textures/entities/" + entity.getTexture() + ".png");
	}

}
