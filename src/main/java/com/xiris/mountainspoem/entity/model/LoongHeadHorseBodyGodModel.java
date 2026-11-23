package com.xiris.mountainspoem.entity.model;

import com.xiris.mountainspoem.MountainsPoemMod;
import com.xiris.mountainspoem.entity.LoongHeadHorseBodyGodEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class LoongHeadHorseBodyGodModel extends GeoModel<LoongHeadHorseBodyGodEntity> {
	@Override
	public ResourceLocation getAnimationResource(LoongHeadHorseBodyGodEntity entity) {
		return ResourceLocation.fromNamespaceAndPath(MountainsPoemMod.MOD_ID, "animations/zhong_shan_god.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(LoongHeadHorseBodyGodEntity entity) {
		return ResourceLocation.fromNamespaceAndPath(MountainsPoemMod.MOD_ID, "geo/zhong_shan_god.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(LoongHeadHorseBodyGodEntity entity) {
		return ResourceLocation.fromNamespaceAndPath(MountainsPoemMod.MOD_ID, "textures/entities/" + entity.getTexture() + ".png");
	}

}
