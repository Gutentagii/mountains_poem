package com.xiris.mountainspoem.entity.model;

import com.xiris.mountainspoem.MountainsPoemMod;
import com.xiris.mountainspoem.entity.CrimsonXuanTortoiseEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class CrimsonXuanTortoiseModel extends GeoModel<CrimsonXuanTortoiseEntity> {
	@Override
	public ResourceLocation getAnimationResource(CrimsonXuanTortoiseEntity entity) {
		return ResourceLocation.fromNamespaceAndPath(MountainsPoemMod.MOD_ID, "animations/crimson_xuan_tortoise.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(CrimsonXuanTortoiseEntity entity) {
		return ResourceLocation.fromNamespaceAndPath(MountainsPoemMod.MOD_ID, "geo/crimson_xuan_tortoise.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(CrimsonXuanTortoiseEntity entity) {
		return ResourceLocation.fromNamespaceAndPath(MountainsPoemMod.MOD_ID, "textures/entities/" + entity.getTexture() + ".png");
	}

}
