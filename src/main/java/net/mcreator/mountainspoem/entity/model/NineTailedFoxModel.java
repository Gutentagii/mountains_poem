package net.mcreator.mountainspoem.entity.model;

import software.bernie.geckolib.model.data.EntityModelData;
import software.bernie.geckolib.model.GeoModel;
import software.bernie.geckolib.core.animation.AnimationState;
import software.bernie.geckolib.core.animatable.model.CoreGeoBone;
import software.bernie.geckolib.constant.DataTickets;

import net.minecraft.util.Mth;
import net.minecraft.resources.ResourceLocation;

import net.mcreator.mountainspoem.entity.NineTailedFoxEntity;

public class NineTailedFoxModel extends GeoModel<NineTailedFoxEntity> {
	@Override
	public ResourceLocation getAnimationResource(NineTailedFoxEntity entity) {
		return new ResourceLocation("mountains_poem", "animations/hujiuwei.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(NineTailedFoxEntity entity) {
		return new ResourceLocation("mountains_poem", "geo/hujiuwei.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(NineTailedFoxEntity entity) {
		return new ResourceLocation("mountains_poem", "textures/entities/hujiuwei/" + entity.getTexture() + ".png");
	}

	@Override
	public void setCustomAnimations(NineTailedFoxEntity animatable, long instanceId, AnimationState animationState) {
		CoreGeoBone head = getAnimationProcessor().getBone("head");
		if (head != null) {
			EntityModelData entityData = (EntityModelData) animationState.getData(DataTickets.ENTITY_MODEL_DATA);
			head.setRotX(entityData.headPitch() * Mth.DEG_TO_RAD);
			head.setRotY(entityData.netHeadYaw() * Mth.DEG_TO_RAD);
		}

	}
}
