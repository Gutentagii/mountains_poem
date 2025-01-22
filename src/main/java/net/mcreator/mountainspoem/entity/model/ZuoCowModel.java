
/*
 *    Gutentagiicreator note: This file will Not be REGENERATED on each build.uh,a crazy person.
 */

package net.mcreator.mountainspoem.entity.model;

import software.bernie.geckolib.model.GeoModel;

import net.minecraft.resources.ResourceLocation;

import net.mcreator.mountainspoem.entity.ZuoCowEntity;

public class ZuoCowModel extends GeoModel<ZuoCowEntity> {
	@Override
	public ResourceLocation getAnimationResource(ZuoCowEntity entity) {
		return new ResourceLocation("mountains_poem", "animations/zuo_cow.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(ZuoCowEntity entity) {
		return new ResourceLocation("mountains_poem", "geo/zuo_cow.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(ZuoCowEntity entity) {
		return new ResourceLocation("mountains_poem", "textures/entities/zuo_cow/" + entity.getTexture() + ".png");
	}

}
