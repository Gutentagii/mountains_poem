package net.mcreator.mountainspoem.item.model;

import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

import net.mcreator.mountainspoem.item.PlagueHalberdItem;

public class PlagueHalberdItemModel extends GeoModel<PlagueHalberdItem> {
	@Override
	public ResourceLocation getAnimationResource(PlagueHalberdItem animatable) {
		return new ResourceLocation("mountains_poem", "animations/plague_halberd.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(PlagueHalberdItem animatable) {
		return new ResourceLocation("mountains_poem", "geo/plague_halberd.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(PlagueHalberdItem animatable) {
		return new ResourceLocation("mountains_poem", "textures/item/plague_halberd.png");
	}
}
