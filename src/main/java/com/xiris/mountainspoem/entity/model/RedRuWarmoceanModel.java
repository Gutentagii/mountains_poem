package com.xiris.mountainspoem.entity.model;

import com.xiris.mountainspoem.MountainsPoemMod;
import com.xiris.mountainspoem.entity.RedRuWarmoceanEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class RedRuWarmoceanModel extends GeoModel<RedRuWarmoceanEntity> {
	@Override
 
	public ResourceLocation getAnimationResource(RedRuWarmoceanEntity entity) {
		return ResourceLocation.fromNamespaceAndPath(MountainsPoemMod.MOD_ID, "animations/redru.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(RedRuWarmoceanEntity entity) {
		return ResourceLocation.fromNamespaceAndPath(MountainsPoemMod.MOD_ID, "geo/redru.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(RedRuWarmoceanEntity entity) {
		return ResourceLocation.fromNamespaceAndPath(MountainsPoemMod.MOD_ID, "textures/entities/red_ru/" + entity.getTexture() + ".png");
	}

}
