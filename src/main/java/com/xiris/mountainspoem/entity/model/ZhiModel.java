package com.xiris.mountainspoem.entity.model;

import com.xiris.mountainspoem.MountainsPoemMod;
import com.xiris.mountainspoem.entity.ZhiEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class ZhiModel extends GeoModel<ZhiEntity> {
	@Override
	public ResourceLocation getAnimationResource(ZhiEntity entity) {
		return ResourceLocation.fromNamespaceAndPath(MountainsPoemMod.MOD_ID, "animations/zhi.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(ZhiEntity entity) {
		return ResourceLocation.fromNamespaceAndPath(MountainsPoemMod.MOD_ID, "geo/zhi.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(ZhiEntity entity) {
		return ResourceLocation.fromNamespaceAndPath(MountainsPoemMod.MOD_ID, "textures/entities/zhi/" + entity.getTexture() + ".png");
	}

}
