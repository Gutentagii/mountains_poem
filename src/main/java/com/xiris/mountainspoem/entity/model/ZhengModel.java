package com.xiris.mountainspoem.entity.model;

import com.xiris.mountainspoem.MountainsPoemMod;
import com.xiris.mountainspoem.entity.ZhengEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class ZhengModel extends GeoModel<ZhengEntity> {
	@Override
	public ResourceLocation getAnimationResource(ZhengEntity entity) {
		return ResourceLocation.fromNamespaceAndPath(MountainsPoemMod.MOD_ID, "animations/zheng.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(ZhengEntity entity) {
		return ResourceLocation.fromNamespaceAndPath(MountainsPoemMod.MOD_ID, "geo/zheng.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(ZhengEntity entity) {
		return ResourceLocation.fromNamespaceAndPath(MountainsPoemMod.MOD_ID, "textures/entities/" + entity.getTexture() + ".png");
	}

}
