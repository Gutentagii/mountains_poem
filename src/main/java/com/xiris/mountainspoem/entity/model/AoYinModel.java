package com.xiris.mountainspoem.entity.model;

import com.xiris.mountainspoem.MountainsPoemMod;
import com.xiris.mountainspoem.entity.AoYinEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class AoYinModel extends GeoModel<AoYinEntity> {
	@Override
	public ResourceLocation getAnimationResource(AoYinEntity entity) {
		return ResourceLocation.fromNamespaceAndPath(MountainsPoemMod.MOD_ID, "animations/ao_yin.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(AoYinEntity entity) {
		return ResourceLocation.fromNamespaceAndPath(MountainsPoemMod.MOD_ID, "geo/ao_yin.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(AoYinEntity entity) {
		return ResourceLocation.fromNamespaceAndPath(MountainsPoemMod.MOD_ID, "textures/entities/" + entity.getTexture() + ".png");
	}

}
