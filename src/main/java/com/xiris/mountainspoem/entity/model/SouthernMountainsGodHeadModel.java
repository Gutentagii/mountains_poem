package com.xiris.mountainspoem.entity.model;

import com.xiris.mountainspoem.MountainsPoemMod;
import com.xiris.mountainspoem.entity.SouthernMountainsGodHeadEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class SouthernMountainsGodHeadModel extends GeoModel<SouthernMountainsGodHeadEntity> {
	@Override
	public ResourceLocation getAnimationResource(SouthernMountainsGodHeadEntity entity) {
		return ResourceLocation.fromNamespaceAndPath(MountainsPoemMod.MOD_ID, "animations/south_mountains_god_head.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(SouthernMountainsGodHeadEntity entity) {
		return ResourceLocation.fromNamespaceAndPath(MountainsPoemMod.MOD_ID, "geo/south_mountains_god_head.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(SouthernMountainsGodHeadEntity entity) {
		return ResourceLocation.fromNamespaceAndPath(MountainsPoemMod.MOD_ID, "textures/entities/" + entity.getTexture() + ".png");
	}

}
