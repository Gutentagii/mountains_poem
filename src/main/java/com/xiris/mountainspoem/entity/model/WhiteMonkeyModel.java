package com.xiris.mountainspoem.entity.model;

import com.xiris.mountainspoem.MountainsPoemMod;
import com.xiris.mountainspoem.entity.WhiteMonkeyEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class WhiteMonkeyModel extends GeoModel<WhiteMonkeyEntity> {
	@Override
	public ResourceLocation getAnimationResource(WhiteMonkeyEntity entity) {
		return ResourceLocation.fromNamespaceAndPath(MountainsPoemMod.MOD_ID, "animations/white_ape.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(WhiteMonkeyEntity entity) {
		return ResourceLocation.fromNamespaceAndPath(MountainsPoemMod.MOD_ID, "geo/white_ape.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(WhiteMonkeyEntity entity) {
		return ResourceLocation.fromNamespaceAndPath(MountainsPoemMod.MOD_ID, "textures/entities/" + entity.getTexture() + ".png");
	}

}
