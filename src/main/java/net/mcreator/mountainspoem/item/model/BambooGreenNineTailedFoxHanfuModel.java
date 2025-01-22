package net.mcreator.mountainspoem.item.model;

import software.bernie.geckolib.model.GeoModel;

import net.mcreator.mountainspoem.item.BambooGreenNineTailedFoxHanfuItem;

public class BambooGreenNineTailedFoxHanfuModel extends GeoModel<BambooGreenNineTailedFoxHanfuItem> {
	@Override
	public ResourceLocation getAnimationResource(BambooGreenNineTailedFoxHanfuItem object) {
		return new ResourceLocation("mountains_poem", "animations/nine_tailed_fox_hanfu.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(BambooGreenNineTailedFoxHanfuItem object) {
		return new ResourceLocation("mountains_poem", "geo/nine_tailed_fox_hanfu.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(BambooGreenNineTailedFoxHanfuItem object) {
		return new ResourceLocation("mountains_poem", "textures/models/armor/nine_tailed_fox_hanfu/hujiuwei3.png");
	}
}
