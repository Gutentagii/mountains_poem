package net.mcreator.mountainspoem.item.model;

import software.bernie.geckolib.model.GeoModel;

import net.mcreator.mountainspoem.item.JunBlackNineTailedFoxHanfuItem;

public class JunBlackNineTailedFoxHanfuModel extends GeoModel<JunBlackNineTailedFoxHanfuItem> {
	@Override
	public ResourceLocation getAnimationResource(JunBlackNineTailedFoxHanfuItem object) {
		return new ResourceLocation("mountains_poem", "animations/nine_tailed_fox_hanfu.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(JunBlackNineTailedFoxHanfuItem object) {
		return new ResourceLocation("mountains_poem", "geo/nine_tailed_fox_hanfu.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(JunBlackNineTailedFoxHanfuItem object) {
		return new ResourceLocation("mountains_poem", "textures/models/armor/nine_tailed_fox_hanfu/hujiuwei4.png");
	}
}
