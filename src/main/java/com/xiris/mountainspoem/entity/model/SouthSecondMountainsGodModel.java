package com.xiris.mountainspoem.entity.model;

import com.xiris.mountainspoem.MountainsPoemMod;
import com.xiris.mountainspoem.entity.SouthSecondMountainsGodEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class SouthSecondMountainsGodModel extends GeoModel<SouthSecondMountainsGodEntity> {
	@Override
	public ResourceLocation getAnimationResource(SouthSecondMountainsGodEntity entity) {
		return ResourceLocation.fromNamespaceAndPath(MountainsPoemMod.MOD_ID, "animations/south_mountains_second_god.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(SouthSecondMountainsGodEntity entity) {
		return ResourceLocation.fromNamespaceAndPath(MountainsPoemMod.MOD_ID, "geo/south_mountains_second_god.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(SouthSecondMountainsGodEntity entity) {
		return ResourceLocation.fromNamespaceAndPath(MountainsPoemMod.MOD_ID, "textures/entities/south_god_2/" + entity.getTexture() + ".png");
	}

}
