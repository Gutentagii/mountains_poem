package com.xiris.mountainspoem.entity.model;

import com.xiris.mountainspoem.MountainsPoemMod;
import com.xiris.mountainspoem.entity.HuiHorseEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class HuiHorseModel extends GeoModel<HuiHorseEntity> {
	@Override
	public ResourceLocation getAnimationResource(HuiHorseEntity entity) {
		return ResourceLocation.fromNamespaceAndPath(MountainsPoemMod.MOD_ID, "animations/hui_horse.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(HuiHorseEntity entity) {
		return ResourceLocation.fromNamespaceAndPath(MountainsPoemMod.MOD_ID, "geo/hui_horse.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(HuiHorseEntity entity) {
		return ResourceLocation.fromNamespaceAndPath(MountainsPoemMod.MOD_ID, "textures/entities/" + entity.getTexture() + ".png");
	}

}
