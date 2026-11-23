package com.xiris.mountainspoem.entity.model;

import com.xiris.mountainspoem.MountainsPoemMod;
import com.xiris.mountainspoem.entity.LushuhorseEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class LushuhorseModel extends GeoModel<LushuhorseEntity> {
	@Override
	public ResourceLocation getAnimationResource(LushuhorseEntity entity) {
		return ResourceLocation.fromNamespaceAndPath(MountainsPoemMod.MOD_ID, "animations/lushu_horse.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(LushuhorseEntity entity) {
		return ResourceLocation.fromNamespaceAndPath(MountainsPoemMod.MOD_ID, "geo/lushu_horse.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(LushuhorseEntity entity) {
		return ResourceLocation.fromNamespaceAndPath(MountainsPoemMod.MOD_ID, "textures/entities/lushu_horse/" + entity.getTexture() + ".png");
	}

}
