package com.xiris.mountainspoem.item.model;

import com.xiris.mountainspoem.MountainsPoemMod;
import com.xiris.mountainspoem.item.VinesArmorsItem;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class VinesArmorsModel extends GeoModel<VinesArmorsItem> {
	@Override
	public ResourceLocation getAnimationResource(VinesArmorsItem object) {
		return ResourceLocation.fromNamespaceAndPath(MountainsPoemMod.MOD_ID, "animations/vine_armor.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(VinesArmorsItem object) {
		return ResourceLocation.fromNamespaceAndPath(MountainsPoemMod.MOD_ID, "geo/vine_armor.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(VinesArmorsItem object) {
		return ResourceLocation.fromNamespaceAndPath(MountainsPoemMod.MOD_ID, "textures/models/armor/vines_armor/vine_armor.png");
	}
}
