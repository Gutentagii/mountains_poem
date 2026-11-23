package com.xiris.mountainspoem.item.model;

import com.xiris.mountainspoem.MountainsPoemMod;
import com.xiris.mountainspoem.item.BambooGreenNineTailedFoxHanfuItem;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class BambooGreenNineTailedFoxHanfuModel extends GeoModel<BambooGreenNineTailedFoxHanfuItem> {
	@Override
	public ResourceLocation getAnimationResource(BambooGreenNineTailedFoxHanfuItem object) {
		return ResourceLocation.fromNamespaceAndPath(MountainsPoemMod.MOD_ID, "animations/nine_tailed_fox_hanfu.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(BambooGreenNineTailedFoxHanfuItem object) {
		return ResourceLocation.fromNamespaceAndPath(MountainsPoemMod.MOD_ID, "geo/nine_tailed_fox_hanfu.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(BambooGreenNineTailedFoxHanfuItem object) {
		return ResourceLocation.fromNamespaceAndPath(MountainsPoemMod.MOD_ID, "textures/models/armor/nine_tailed_fox_hanfu/hujiuwei3.png");
	}
}
