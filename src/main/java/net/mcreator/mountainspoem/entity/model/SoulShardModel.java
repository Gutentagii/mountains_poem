package net.mcreator.mountainspoem.entity.model;

import software.bernie.geckolib.model.GeoModel;

import net.minecraft.resources.ResourceLocation;

import net.mcreator.mountainspoem.entity.SoulShardEntity;

public class SoulShardModel extends GeoModel<SoulShardEntity> {
	@Override
	public ResourceLocation getAnimationResource(SoulShardEntity entity) {
		return new ResourceLocation("mountains_poem", "animations/soul_shard.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(SoulShardEntity entity) {
		return new ResourceLocation("mountains_poem", "geo/soul_shard.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(SoulShardEntity entity) {
		return new ResourceLocation("mountains_poem", "textures/entities/" + entity.getTexture() + ".png");
	}

}
