package net.mcreator.mountainspoem.item.model;

import software.bernie.geckolib.model.GeoModel;

import net.mcreator.mountainspoem.item.BronzeDevourerPieceItem;

public class BronzeDevourerPieceModel extends GeoModel<BronzeDevourerPieceItem> {
	@Override
	public ResourceLocation getAnimationResource(BronzeDevourerPieceItem object) {
		return new ResourceLocation("mountains_poem", "animations/bronze_devourer_armor.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(BronzeDevourerPieceItem object) {
		return new ResourceLocation("mountains_poem", "geo/bronze_devourer_armor.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(BronzeDevourerPieceItem object) {
		return new ResourceLocation("mountains_poem", "textures/models/armor/bronze_devourer_armor/bronze_devourer_armor.png");
	}
}
