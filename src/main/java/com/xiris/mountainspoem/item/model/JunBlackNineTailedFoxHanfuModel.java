package com.xiris.mountainspoem.item.model;

import com.xiris.mountainspoem.MountainsPoemMod;
import com.xiris.mountainspoem.item.JunBlackNineTailedFoxHanfuItem;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class JunBlackNineTailedFoxHanfuModel extends GeoModel<JunBlackNineTailedFoxHanfuItem> {
	@Override
	public ResourceLocation getAnimationResource(JunBlackNineTailedFoxHanfuItem object) {
		return ResourceLocation.fromNamespaceAndPath(MountainsPoemMod.MOD_ID, "animations/nine_tailed_fox_hanfu.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(JunBlackNineTailedFoxHanfuItem object) {
		return ResourceLocation.fromNamespaceAndPath(MountainsPoemMod.MOD_ID, "geo/nine_tailed_fox_hanfu.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(JunBlackNineTailedFoxHanfuItem object) {
		return ResourceLocation.fromNamespaceAndPath(MountainsPoemMod.MOD_ID, "textures/models/armor/nine_tailed_fox_hanfu/hujiuwei4.png");
	}
}
