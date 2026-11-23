package com.xiris.mountainspoem.item.model;

import com.xiris.mountainspoem.MountainsPoemMod;
import com.xiris.mountainspoem.item.MugwortGreenNineTailedFoxHanfuItem;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class MugwortGreenNineTailedFoxHanfuModel extends GeoModel<MugwortGreenNineTailedFoxHanfuItem> {
	@Override
	public ResourceLocation getAnimationResource(MugwortGreenNineTailedFoxHanfuItem object) {
		return ResourceLocation.fromNamespaceAndPath(MountainsPoemMod.MOD_ID, "animations/nine_tailed_fox_hanfu.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(MugwortGreenNineTailedFoxHanfuItem object) {
		return ResourceLocation.fromNamespaceAndPath(MountainsPoemMod.MOD_ID, "geo/nine_tailed_fox_hanfu.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(MugwortGreenNineTailedFoxHanfuItem object) {
		return ResourceLocation.fromNamespaceAndPath(MountainsPoemMod.MOD_ID, "textures/models/armor/nine_tailed_fox_hanfu/hujiuwei1.png");
	}
}
