package com.xiris.mountainspoem.item.model;

import com.xiris.mountainspoem.MountainsPoemMod;
import com.xiris.mountainspoem.item.BronzeDevourerPieceItem;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class BronzeDevourerPieceModel extends GeoModel<BronzeDevourerPieceItem> {
	@Override
	public ResourceLocation getAnimationResource(BronzeDevourerPieceItem object) {
		return ResourceLocation.fromNamespaceAndPath(MountainsPoemMod.MOD_ID, "animations/bronze_devourer_armor.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(BronzeDevourerPieceItem object) {
		return ResourceLocation.fromNamespaceAndPath(MountainsPoemMod.MOD_ID, "geo/bronze_devourer_armor.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(BronzeDevourerPieceItem object) {
		return ResourceLocation.fromNamespaceAndPath(MountainsPoemMod.MOD_ID, "textures/models/armor/bronze_devourer_armor/bronze_devourer_armor.png");
	}
}
