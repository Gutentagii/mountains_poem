
package net.mcreator.mountainspoem.client.renderer;

import software.bernie.geckolib.renderer.GeoEntityRenderer;
import software.bernie.geckolib.cache.object.BakedGeoModel;

import net.mcreator.mountainspoem.entity.model.LufishModel;
import net.mcreator.mountainspoem.entity.LufishEntity;

public class LufishRenderer extends GeoEntityRenderer<LufishEntity> {
	public LufishRenderer(EntityRendererProvider.Context renderManager) {
		super(renderManager, new LufishModel());
		this.shadowRadius = 0.4f;
	}

	@Override
	public RenderType getRenderType(LufishEntity animatable, ResourceLocation texture, MultiBufferSource bufferSource, float partialTick) {
		return RenderType.entityTranslucent(getTextureLocation(animatable));
	}

	@Override
	public void preRender(PoseStack poseStack, LufishEntity entity, BakedGeoModel model, MultiBufferSource bufferSource, VertexConsumer buffer, boolean isReRender, float partialTick, int packedLight, int packedOverlay, float red, float green,
			float blue, float alpha) {
		float scale = 1f;
		this.scaleHeight = scale;
		this.scaleWidth = scale;
		super.preRender(poseStack, entity, model, bufferSource, buffer, isReRender, partialTick, packedLight, packedOverlay, red, green, blue, alpha);
	}

	@Override
	protected float getDeathMaxRotation(LufishEntity entityLivingBaseIn) {
		return 0.0F;
	}
}
