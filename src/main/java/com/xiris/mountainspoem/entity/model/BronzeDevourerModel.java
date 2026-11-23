package com.xiris.mountainspoem.entity.model;

import com.xiris.mountainspoem.MountainsPoemMod;
import com.xiris.mountainspoem.entity.BronzeDevourerEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class BronzeDevourerModel extends GeoModel<BronzeDevourerEntity> {
	@Override
	public ResourceLocation getAnimationResource(BronzeDevourerEntity entity) {
		return ResourceLocation.fromNamespaceAndPath(MountainsPoemMod.MOD_ID, "animations/bronze_devourer.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(BronzeDevourerEntity entity) {
		return ResourceLocation.fromNamespaceAndPath(MountainsPoemMod.MOD_ID, "geo/bronze_devourer.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(BronzeDevourerEntity entity) {
		return ResourceLocation.fromNamespaceAndPath(MountainsPoemMod.MOD_ID, "textures/entities/" + entity.getTexture() + ".png");
	}

}
