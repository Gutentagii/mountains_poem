package com.xiris.mountainspoem.entity.model;

import com.xiris.mountainspoem.MountainsPoemMod;
import com.xiris.mountainspoem.entity.WoodWormsEntity;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import software.bernie.geckolib.constant.DataTickets;
import software.bernie.geckolib.core.animatable.model.CoreGeoBone;
import software.bernie.geckolib.core.animation.AnimationState;
import software.bernie.geckolib.model.GeoModel;
import software.bernie.geckolib.model.data.EntityModelData;

 
public class WoodWormsModel extends GeoModel<WoodWormsEntity> {
	@Override
	public ResourceLocation getAnimationResource(WoodWormsEntity entity) {
		return ResourceLocation.fromNamespaceAndPath(MountainsPoemMod.MOD_ID, "animations/woodworm.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(WoodWormsEntity entity) {
		return ResourceLocation.fromNamespaceAndPath(MountainsPoemMod.MOD_ID, "geo/woodworm.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(WoodWormsEntity entity) {
		return ResourceLocation.fromNamespaceAndPath(MountainsPoemMod.MOD_ID, "textures/entities/wood_worms/" + entity.getTexture() + ".png");
	}

	@Override
	public void setCustomAnimations(WoodWormsEntity animatable, long instanceId, AnimationState animationState) {
		CoreGeoBone head = this.getAnimationProcessor().getBone("bone4");
		if (head != null) {
			EntityModelData entityData = (EntityModelData) animationState.getData(DataTickets.ENTITY_MODEL_DATA);
			head.setRotX(entityData.headPitch() * Mth.DEG_TO_RAD);
			head.setRotY(entityData.netHeadYaw() * Mth.DEG_TO_RAD);
		}

	}
}
