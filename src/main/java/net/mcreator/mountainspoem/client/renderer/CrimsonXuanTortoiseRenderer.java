
package net.mcreator.mountainspoem.client.renderer;

import software.bernie.geckolib.renderer.GeoEntityRenderer;
import software.bernie.geckolib.cache.object.BakedGeoModel;

import net.mcreator.mountainspoem.entity.model.CrimsonXuanTortoiseModel;
import net.mcreator.mountainspoem.entity.CrimsonXuanTortoiseEntity;

public class CrimsonXuanTortoiseRenderer extends GeoEntityRenderer<CrimsonXuanTortoiseEntity> {
	public CrimsonXuanTortoiseRenderer(EntityRendererProvider.Context renderManager) {
		super(renderManager, new CrimsonXuanTortoiseModel());
		this.shadowRadius = 1f;
	}

	@Override
	public RenderType getRenderType(CrimsonXuanTortoiseEntity animatable, ResourceLocation texture, MultiBufferSource bufferSource, float partialTick) {
		return RenderType.entityTranslucent(getTextureLocation(animatable));
	}

	@Override
	public void preRender(PoseStack poseStack, CrimsonXuanTortoiseEntity entity, BakedGeoModel model, MultiBufferSource bufferSource, VertexConsumer buffer, boolean isReRender, float partialTick, int packedLight, int packedOverlay, float red,
			float green, float blue, float alpha) {
		float scale = 1f;
		this.scaleHeight = scale;
		this.scaleWidth = scale;
		super.preRender(poseStack, entity, model, bufferSource, buffer, isReRender, partialTick, packedLight, packedOverlay, red, green, blue, alpha);
	}
}
