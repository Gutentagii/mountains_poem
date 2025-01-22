package net.mcreator.mountainspoem.entity.model;

import software.bernie.geckolib.model.data.EntityModelData;
import software.bernie.geckolib.model.GeoModel;
import software.bernie.geckolib.core.animation.AnimationState;
import software.bernie.geckolib.core.animatable.model.CoreGeoBone;
import software.bernie.geckolib.constant.DataTickets;

import net.minecraft.util.Mth;
import net.minecraft.resources.ResourceLocation;

import net.mcreator.mountainspoem.entity.WoodWormsEntity;
 
public class WoodWormsModel extends GeoModel<WoodWormsEntity> {
	@Override
	public ResourceLocation getAnimationResource(WoodWormsEntity entity) {
		return new ResourceLocation("mountains_poem", "animations/woodworm.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(WoodWormsEntity entity) {
		return new ResourceLocation("mountains_poem", "geo/woodworm.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(WoodWormsEntity entity) {
		return new ResourceLocation("mountains_poem", "textures/entities/wood_worms/" + entity.getTexture() + ".png");
	}

	@Override
	public void setCustomAnimations(WoodWormsEntity animatable, long instanceId, AnimationState animationState) {
		CoreGeoBone head = getAnimationProcessor().getBone("bone4");
		if (head != null) {
			EntityModelData entityData = (EntityModelData) animationState.getData(DataTickets.ENTITY_MODEL_DATA);
			head.setRotX(entityData.headPitch() * Mth.DEG_TO_RAD);
			head.setRotY(entityData.netHeadYaw() * Mth.DEG_TO_RAD);
		}

	}
}
