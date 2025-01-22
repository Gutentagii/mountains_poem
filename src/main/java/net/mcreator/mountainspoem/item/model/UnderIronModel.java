package net.mcreator.mountainspoem.item.model;

import software.bernie.geckolib.model.GeoModel;

import net.minecraft.resources.ResourceLocation;

import net.mcreator.mountainspoem.item.UnderIronItem;

public class UnderIronModel extends GeoModel<UnderIronItem> {
	@Override
	public ResourceLocation getAnimationResource(UnderIronItem object) {
		return new ResourceLocation("mountains_poem", "animations/the_common_armor.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(UnderIronItem object) {
		return new ResourceLocation("mountains_poem", "geo/the_common_armor.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(UnderIronItem object) {
		return new ResourceLocation("mountains_poem", "textures/models/armor/under_iron_armor/under_iron_armor.png");
	}
}
