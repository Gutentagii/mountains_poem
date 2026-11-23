package com.xiris.mountainspoem.entity.model;

import com.xiris.mountainspoem.MountainsPoemMod;
import com.xiris.mountainspoem.entity.HuaSnakeEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class HuaSnakeModel extends GeoModel<HuaSnakeEntity> {
	@Override
	public ResourceLocation getAnimationResource(HuaSnakeEntity entity) {
		return ResourceLocation.fromNamespaceAndPath(MountainsPoemMod.MOD_ID, "animations/hua_snake.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(HuaSnakeEntity entity) {
		return ResourceLocation.fromNamespaceAndPath(MountainsPoemMod.MOD_ID, "geo/hua_snake.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(HuaSnakeEntity entity) {
		return ResourceLocation.fromNamespaceAndPath(MountainsPoemMod.MOD_ID, "textures/entities/" + entity.getTexture() + ".png");
	}

}
