package com.xiris.mountainspoem.entity.model;

import com.xiris.mountainspoem.MountainsPoemMod;
import com.xiris.mountainspoem.entity.UnderGhostEntity;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import software.bernie.geckolib.constant.DataTickets;
import software.bernie.geckolib.core.animatable.model.CoreGeoBone;
import software.bernie.geckolib.core.animation.AnimationState;
import software.bernie.geckolib.model.GeoModel;
import software.bernie.geckolib.model.data.EntityModelData;

public class UnderGhostModel extends GeoModel<UnderGhostEntity> {
	@Override
	public ResourceLocation getAnimationResource(UnderGhostEntity entity) {
		return ResourceLocation.fromNamespaceAndPath(MountainsPoemMod.MOD_ID, "animations/wandering_ghost.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(UnderGhostEntity entity) {
		return ResourceLocation.fromNamespaceAndPath(MountainsPoemMod.MOD_ID, "geo/wandering_ghost.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(UnderGhostEntity entity) {
		return ResourceLocation.fromNamespaceAndPath(MountainsPoemMod.MOD_ID, "textures/entities/" + entity.getTexture() + ".png");
	}

	@Override
	public void setCustomAnimations(UnderGhostEntity animatable, long instanceId, AnimationState animationState) {
		CoreGeoBone head = this.getAnimationProcessor().getBone("head2");
		if (head != null) {
			EntityModelData entityData = (EntityModelData) animationState.getData(DataTickets.ENTITY_MODEL_DATA);
			head.setRotX(entityData.headPitch() * Mth.DEG_TO_RAD);
			head.setRotY(entityData.netHeadYaw() * Mth.DEG_TO_RAD);
		}

	}
}
