package net.mcreator.mountainspoem.item.model;

import software.bernie.geckolib.model.GeoModel;

import net.minecraft.resources.ResourceLocation;

import net.mcreator.mountainspoem.item.TheBloodCopperItem;

public class TheBloodCopperModel extends GeoModel<TheBloodCopperItem> {
	@Override
	public ResourceLocation getAnimationResource(TheBloodCopperItem object) {
		return new ResourceLocation("mountains_poem", "animations/the_common_armor.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(TheBloodCopperItem object) {
		return new ResourceLocation("mountains_poem", "geo/the_common_armor.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(TheBloodCopperItem object) {
		return new ResourceLocation("mountains_poem", "textures/models/armor/the_blood_copper_armor/blood_copper_armor.png");
	}
}
