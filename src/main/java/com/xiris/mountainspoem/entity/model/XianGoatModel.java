package com.xiris.mountainspoem.entity.model;

import com.xiris.mountainspoem.MountainsPoemMod;
import com.xiris.mountainspoem.entity.XianGoatEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class XianGoatModel extends GeoModel<XianGoatEntity> {
	@Override
	public ResourceLocation getAnimationResource(XianGoatEntity entity) {
		return ResourceLocation.fromNamespaceAndPath(MountainsPoemMod.MOD_ID, "animations/xian_goat.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(XianGoatEntity entity) {
		return ResourceLocation.fromNamespaceAndPath(MountainsPoemMod.MOD_ID, "geo/xian_goat.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(XianGoatEntity entity) {
		return ResourceLocation.fromNamespaceAndPath(MountainsPoemMod.MOD_ID, "textures/entities/xian_goat/" + entity.getTexture() + ".png");
	}

}
