package com.xiris.mountainspoem.entity.model;

import com.xiris.mountainspoem.MountainsPoemMod;
import com.xiris.mountainspoem.entity.LeiEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class LeiModel extends GeoModel<LeiEntity> {
	@Override
	public ResourceLocation getAnimationResource(LeiEntity entity) {
		return ResourceLocation.fromNamespaceAndPath(MountainsPoemMod.MOD_ID, "animations/lei.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(LeiEntity entity) {
		return ResourceLocation.fromNamespaceAndPath(MountainsPoemMod.MOD_ID, "geo/lei.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(LeiEntity entity) {
		return ResourceLocation.fromNamespaceAndPath(MountainsPoemMod.MOD_ID, "textures/entities/lei/" + entity.getTexture() + ".png");
	}

}
