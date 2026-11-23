package com.xiris.mountainspoem.entity.model;

import com.xiris.mountainspoem.MountainsPoemMod;
import com.xiris.mountainspoem.entity.SouthMountainGodEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class SouthMountainGodModel extends GeoModel<SouthMountainGodEntity> {
	@Override
	public ResourceLocation getAnimationResource(SouthMountainGodEntity entity) {
 
		return ResourceLocation.fromNamespaceAndPath(MountainsPoemMod.MOD_ID, "animations/south_mountains_god.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(SouthMountainGodEntity entity) {
		return ResourceLocation.fromNamespaceAndPath(MountainsPoemMod.MOD_ID, "geo/south_mountains_god.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(SouthMountainGodEntity entity) {
		return ResourceLocation.fromNamespaceAndPath(MountainsPoemMod.MOD_ID, "textures/entities/south_god_1/" + entity.getTexture() + ".png");
	}

}
//south_god_1
