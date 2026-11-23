package com.xiris.mountainspoem.item.model;

import com.xiris.mountainspoem.MountainsPoemMod;
import com.xiris.mountainspoem.item.PeachRedNineTailedFoxHanfuItem;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class PeachRedNineTailedFoxHanfuModel extends GeoModel<PeachRedNineTailedFoxHanfuItem> {
	@Override
	public ResourceLocation getAnimationResource(PeachRedNineTailedFoxHanfuItem object) {
		return ResourceLocation.fromNamespaceAndPath(MountainsPoemMod.MOD_ID, "animations/nine_tailed_fox_hanfu.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(PeachRedNineTailedFoxHanfuItem object) {
		return ResourceLocation.fromNamespaceAndPath(MountainsPoemMod.MOD_ID, "geo/nine_tailed_fox_hanfu.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(PeachRedNineTailedFoxHanfuItem object) {
		return ResourceLocation.fromNamespaceAndPath(MountainsPoemMod.MOD_ID, "textures/models/armor/nine_tailed_fox_hanfu/hujiuwei2.png");
	}
}
