package com.xiris.mountainspoem.entity.model;

import com.xiris.mountainspoem.MountainsPoemMod;
import com.xiris.mountainspoem.entity.GuEagleEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class GuEagleModel extends GeoModel<GuEagleEntity> {
	@Override
	public ResourceLocation getAnimationResource(GuEagleEntity entity) {
		return ResourceLocation.fromNamespaceAndPath(MountainsPoemMod.MOD_ID, "animations/gu_diao.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(GuEagleEntity entity) {
		return ResourceLocation.fromNamespaceAndPath(MountainsPoemMod.MOD_ID, "geo/gu_diao.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(GuEagleEntity entity) {
		return ResourceLocation.fromNamespaceAndPath(MountainsPoemMod.MOD_ID, "textures/entities/gu_diao/" + entity.getTexture() + ".png");
	}

}
