package com.xiris.mountainspoem.entity.model;

import com.xiris.mountainspoem.MountainsPoemMod;
import com.xiris.mountainspoem.entity.FuriousSouthernMountainsGodHeadEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class FuriousSouthernMountainsGodHeadModel extends GeoModel<FuriousSouthernMountainsGodHeadEntity> {
	@Override
	public ResourceLocation getAnimationResource(FuriousSouthernMountainsGodHeadEntity entity) {
		return ResourceLocation.fromNamespaceAndPath(MountainsPoemMod.MOD_ID, "animations/south_mountains_god_head.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(FuriousSouthernMountainsGodHeadEntity entity) {
		return ResourceLocation.fromNamespaceAndPath(MountainsPoemMod.MOD_ID, "geo/south_mountains_god_head.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(FuriousSouthernMountainsGodHeadEntity entity) {
		return ResourceLocation.fromNamespaceAndPath(MountainsPoemMod.MOD_ID, "textures/entities/" + entity.getTexture() + ".png");
	}

}
