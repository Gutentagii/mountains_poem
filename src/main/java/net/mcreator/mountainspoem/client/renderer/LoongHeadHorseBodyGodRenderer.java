
package net.mcreator.mountainspoem.client.renderer;

import software.bernie.geckolib.renderer.GeoEntityRenderer;
import software.bernie.geckolib.cache.object.BakedGeoModel;

import net.mcreator.mountainspoem.entity.model.LoongHeadHorseBodyGodModel;
import net.mcreator.mountainspoem.entity.LoongHeadHorseBodyGodEntity;

public class LoongHeadHorseBodyGodRenderer extends GeoEntityRenderer<LoongHeadHorseBodyGodEntity> {
	public LoongHeadHorseBodyGodRenderer(EntityRendererProvider.Context renderManager) {
		super(renderManager, new LoongHeadHorseBodyGodModel());
		this.shadowRadius = 2.3f;
	}

	@Override
	public RenderType getRenderType(LoongHeadHorseBodyGodEntity animatable, ResourceLocation texture, MultiBufferSource bufferSource, float partialTick) {
		return RenderType.entityTranslucent(getTextureLocation(animatable));
	}

	@Override
	public void preRender(PoseStack poseStack, LoongHeadHorseBodyGodEntity entity, BakedGeoModel model, MultiBufferSource bufferSource, VertexConsumer buffer, boolean isReRender, float partialTick, int packedLight, int packedOverlay, float red,
			float green, float blue, float alpha) {
		float scale = 1f;
		this.scaleHeight = scale;
		this.scaleWidth = scale;
		super.preRender(poseStack, entity, model, bufferSource, buffer, isReRender, partialTick, packedLight, packedOverlay, red, green, blue, alpha);
	}

	@Override
	protected float getDeathMaxRotation(LoongHeadHorseBodyGodEntity entityLivingBaseIn) {
		return 0.0F;
	}
}
