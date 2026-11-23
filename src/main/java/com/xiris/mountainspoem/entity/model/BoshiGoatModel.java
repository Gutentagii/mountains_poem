package com.xiris.mountainspoem.entity.model;

import com.xiris.mountainspoem.MountainsPoemMod;
import com.xiris.mountainspoem.entity.BoshiGoatEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class BoshiGoatModel extends GeoModel<BoshiGoatEntity> {
	@Override
	public ResourceLocation getAnimationResource(BoshiGoatEntity entity) {
		return ResourceLocation.fromNamespaceAndPath(MountainsPoemMod.MOD_ID, "animations/boshi_goat.animation.json");
	}

 
	@Override
	public ResourceLocation getModelResource(BoshiGoatEntity entity) {
		return ResourceLocation.fromNamespaceAndPath(MountainsPoemMod.MOD_ID, "geo/boshi_goat.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(BoshiGoatEntity entity) {
		return ResourceLocation.fromNamespaceAndPath(MountainsPoemMod.MOD_ID, "textures/entities/boshi_goat/" + entity.getTexture() + ".png");
	}

}
