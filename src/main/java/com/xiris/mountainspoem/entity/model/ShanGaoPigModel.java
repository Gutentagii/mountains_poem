package com.xiris.mountainspoem.entity.model;

import com.xiris.mountainspoem.MountainsPoemMod;
import com.xiris.mountainspoem.entity.ShanGaoPigEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class ShanGaoPigModel extends GeoModel<ShanGaoPigEntity> {
	@Override
	public ResourceLocation getAnimationResource(ShanGaoPigEntity entity) {
		return ResourceLocation.fromNamespaceAndPath(MountainsPoemMod.MOD_ID, "animations/shan_gao_pig.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(ShanGaoPigEntity entity) {
		return ResourceLocation.fromNamespaceAndPath(MountainsPoemMod.MOD_ID, "geo/shan_gao_pig.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(ShanGaoPigEntity entity) {
		return ResourceLocation.fromNamespaceAndPath(MountainsPoemMod.MOD_ID, "textures/entities/shangao/" + entity.getTexture() + ".png");
	}

}
