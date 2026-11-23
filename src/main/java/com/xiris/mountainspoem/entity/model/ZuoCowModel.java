
/*
 *    Gutentagiicreator note: This file will Not be REGENERATED on each build.uh,a crazy person.
 */

package com.xiris.mountainspoem.entity.model;

import com.xiris.mountainspoem.MountainsPoemMod;
import com.xiris.mountainspoem.entity.ZuoCowEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class ZuoCowModel extends GeoModel<ZuoCowEntity> {
	@Override
	public ResourceLocation getAnimationResource(ZuoCowEntity entity) {
		return ResourceLocation.fromNamespaceAndPath(MountainsPoemMod.MOD_ID, "animations/zuo_cow.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(ZuoCowEntity entity) {
		return ResourceLocation.fromNamespaceAndPath(MountainsPoemMod.MOD_ID, "geo/zuo_cow.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(ZuoCowEntity entity) {
		return ResourceLocation.fromNamespaceAndPath(MountainsPoemMod.MOD_ID, "textures/entities/zuo_cow/" + entity.getTexture() + ".png");
	}

}
