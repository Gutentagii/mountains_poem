package net.mcreator.mountainspoem.item.model;

import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

import net.mcreator.mountainspoem.item.VinesArmorsItem;

public class VinesArmorsModel extends GeoModel<VinesArmorsItem> {
	@Override
	public ResourceLocation getAnimationResource(VinesArmorsItem object) {
		return new ResourceLocation("mountains_poem", "animations/vine_armor.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(VinesArmorsItem object) {
		return new ResourceLocation("mountains_poem", "geo/vine_armor.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(VinesArmorsItem object) {
		return new ResourceLocation("mountains_poem", "textures/models/armor/vines_armor/vine_armor.png");
	}
}
