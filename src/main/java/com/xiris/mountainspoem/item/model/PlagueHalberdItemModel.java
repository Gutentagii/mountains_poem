package com.xiris.mountainspoem.item.model;

import com.xiris.mountainspoem.MountainsPoemMod;
import com.xiris.mountainspoem.item.PlagueHalberdItem;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class PlagueHalberdItemModel extends GeoModel<PlagueHalberdItem> {
	@Override
	public ResourceLocation getAnimationResource(PlagueHalberdItem animatable) {
		return ResourceLocation.fromNamespaceAndPath(MountainsPoemMod.MOD_ID, "animations/plague_halberd.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(PlagueHalberdItem animatable) {
		return ResourceLocation.fromNamespaceAndPath(MountainsPoemMod.MOD_ID, "geo/plague_halberd.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(PlagueHalberdItem animatable) {
		return ResourceLocation.fromNamespaceAndPath(MountainsPoemMod.MOD_ID, "textures/item/plague_halberd.png");
	}
}
