package com.xiris.mountainspoem.entity.model;

import com.xiris.mountainspoem.MountainsPoemMod;
import com.xiris.mountainspoem.entity.SoulShardEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class SoulShardModel extends GeoModel<SoulShardEntity> {
	@Override
	public ResourceLocation getAnimationResource(SoulShardEntity entity) {
		return ResourceLocation.fromNamespaceAndPath(MountainsPoemMod.MOD_ID, "animations/soul_shard.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(SoulShardEntity entity) {
		return ResourceLocation.fromNamespaceAndPath(MountainsPoemMod.MOD_ID, "geo/soul_shard.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(SoulShardEntity entity) {
		return ResourceLocation.fromNamespaceAndPath(MountainsPoemMod.MOD_ID, "textures/entities/" + entity.getTexture() + ".png");
	}

}
