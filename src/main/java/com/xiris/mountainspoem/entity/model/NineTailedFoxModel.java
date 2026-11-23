package com.xiris.mountainspoem.entity.model;

import com.xiris.mountainspoem.MountainsPoemMod;
import com.xiris.mountainspoem.entity.NineTailedFoxEntity;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import software.bernie.geckolib.constant.DataTickets;
import software.bernie.geckolib.core.animatable.model.CoreGeoBone;
import software.bernie.geckolib.core.animation.AnimationState;
import software.bernie.geckolib.model.GeoModel;
import software.bernie.geckolib.model.data.EntityModelData;

public class NineTailedFoxModel extends GeoModel<NineTailedFoxEntity> {
	@Override
	public ResourceLocation getAnimationResource(NineTailedFoxEntity entity) {
		return ResourceLocation.fromNamespaceAndPath(MountainsPoemMod.MOD_ID, "animations/hujiuwei.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(NineTailedFoxEntity entity) {
		return ResourceLocation.fromNamespaceAndPath(MountainsPoemMod.MOD_ID, "geo/hujiuwei.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(NineTailedFoxEntity entity) {
		return ResourceLocation.fromNamespaceAndPath(MountainsPoemMod.MOD_ID, "textures/entities/hujiuwei/" + entity.getTexture() + ".png");
	}

	@Override
	public void setCustomAnimations(NineTailedFoxEntity animatable, long instanceId, AnimationState animationState) {
		CoreGeoBone head = this.getAnimationProcessor().getBone("head");
		if (head != null) {
			EntityModelData entityData = (EntityModelData) animationState.getData(DataTickets.ENTITY_MODEL_DATA);
			head.setRotX(entityData.headPitch() * Mth.DEG_TO_RAD);
			head.setRotY(entityData.netHeadYaw() * Mth.DEG_TO_RAD);
		}

	}
}
