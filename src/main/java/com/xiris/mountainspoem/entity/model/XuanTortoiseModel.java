package com.xiris.mountainspoem.entity.model;

import com.xiris.mountainspoem.MountainsPoemMod;
import com.xiris.mountainspoem.entity.XuanTortoiseEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class XuanTortoiseModel extends GeoModel<XuanTortoiseEntity> {
	@Override
	public ResourceLocation getAnimationResource(XuanTortoiseEntity entity) {
		return ResourceLocation.fromNamespaceAndPath(MountainsPoemMod.MOD_ID, "animations/xuan_tortoise.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(XuanTortoiseEntity entity) {
		return ResourceLocation.fromNamespaceAndPath(MountainsPoemMod.MOD_ID, "geo/xuan_tortoise.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(XuanTortoiseEntity entity) {
		return ResourceLocation.fromNamespaceAndPath(MountainsPoemMod.MOD_ID, "textures/entities/" + entity.getTexture() + ".png");
	}

}
