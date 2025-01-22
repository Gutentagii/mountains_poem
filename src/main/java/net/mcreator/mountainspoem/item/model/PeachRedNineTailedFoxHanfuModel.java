package net.mcreator.mountainspoem.item.model;

import software.bernie.geckolib.model.GeoModel;

import net.mcreator.mountainspoem.item.PeachRedNineTailedFoxHanfuItem;

public class PeachRedNineTailedFoxHanfuModel extends GeoModel<PeachRedNineTailedFoxHanfuItem> {
	@Override
	public ResourceLocation getAnimationResource(PeachRedNineTailedFoxHanfuItem object) {
		return new ResourceLocation("mountains_poem", "animations/nine_tailed_fox_hanfu.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(PeachRedNineTailedFoxHanfuItem object) {
		return new ResourceLocation("mountains_poem", "geo/nine_tailed_fox_hanfu.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(PeachRedNineTailedFoxHanfuItem object) {
		return new ResourceLocation("mountains_poem", "textures/models/armor/nine_tailed_fox_hanfu/hujiuwei2.png");
	}
}
