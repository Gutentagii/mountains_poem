package net.mcreator.mountainspoem.entity.model;

import software.bernie.geckolib.model.data.EntityModelData;
import software.bernie.geckolib.model.GeoModel;
import software.bernie.geckolib.core.animation.AnimationState;
import software.bernie.geckolib.core.animatable.model.CoreGeoBone;
import software.bernie.geckolib.constant.DataTickets;

import net.minecraft.util.Mth;
import net.minecraft.resources.ResourceLocation;

import net.mcreator.mountainspoem.entity.ImperialExaminationGhostEntity;

public class ImperialExaminationGhostModel extends GeoModel<ImperialExaminationGhostEntity> {
	@Override
	public ResourceLocation getAnimationResource(ImperialExaminationGhostEntity entity) {
		return new ResourceLocation("mountains_poem", "animations/imperial_examination_ghost.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(ImperialExaminationGhostEntity entity) {
		return new ResourceLocation("mountains_poem", "geo/imperial_examination_ghost.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(ImperialExaminationGhostEntity entity) {
		return new ResourceLocation("mountains_poem", "textures/entities/" + entity.getTexture() + ".png");
	}

	@Override
	public void setCustomAnimations(ImperialExaminationGhostEntity animatable, long instanceId, AnimationState animationState) {
		CoreGeoBone head = getAnimationProcessor().getBone("head2");
		if (head != null) {
			EntityModelData entityData = (EntityModelData) animationState.getData(DataTickets.ENTITY_MODEL_DATA);
			head.setRotX(entityData.headPitch() * Mth.DEG_TO_RAD);
			head.setRotY(entityData.netHeadYaw() * Mth.DEG_TO_RAD);
		}

	}
}
