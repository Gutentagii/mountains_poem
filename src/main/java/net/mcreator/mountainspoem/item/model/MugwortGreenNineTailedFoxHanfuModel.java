package net.mcreator.mountainspoem.item.model;

import software.bernie.geckolib.model.GeoModel;

import net.mcreator.mountainspoem.item.MugwortGreenNineTailedFoxHanfuItem;

public class MugwortGreenNineTailedFoxHanfuModel extends GeoModel<MugwortGreenNineTailedFoxHanfuItem> {
	@Override
	public ResourceLocation getAnimationResource(MugwortGreenNineTailedFoxHanfuItem object) {
		return new ResourceLocation("mountains_poem", "animations/nine_tailed_fox_hanfu.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(MugwortGreenNineTailedFoxHanfuItem object) {
		return new ResourceLocation("mountains_poem", "geo/nine_tailed_fox_hanfu.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(MugwortGreenNineTailedFoxHanfuItem object) {
		return new ResourceLocation("mountains_poem", "textures/models/armor/nine_tailed_fox_hanfu/hujiuwei1.png");
	}
}
