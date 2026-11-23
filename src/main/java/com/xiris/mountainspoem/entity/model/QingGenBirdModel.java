package com.xiris.mountainspoem.entity.model;

import com.xiris.mountainspoem.MountainsPoemMod;
import com.xiris.mountainspoem.entity.QingGenBirdEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class QingGenBirdModel extends GeoModel<QingGenBirdEntity> {
	@Override
	public ResourceLocation getAnimationResource(QingGenBirdEntity entity) {
		return ResourceLocation.fromNamespaceAndPath(MountainsPoemMod.MOD_ID, "animations/qingen.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(QingGenBirdEntity entity) {
		return ResourceLocation.fromNamespaceAndPath(MountainsPoemMod.MOD_ID, "geo/qingen.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(QingGenBirdEntity entity) {
		return ResourceLocation.fromNamespaceAndPath(MountainsPoemMod.MOD_ID, "textures/entities/qinggeng_bird/" + entity.getTexture() + ".png");
	}

}
