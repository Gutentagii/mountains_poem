
package net.mcreator.mountainspoem.client.renderer;

import software.bernie.geckolib.renderer.GeoEntityRenderer;
import software.bernie.geckolib.cache.object.BakedGeoModel;

import net.mcreator.mountainspoem.entity.model.HuaSnakeModel;
import net.mcreator.mountainspoem.entity.HuaSnakeEntity;

public class HuaSnakeRenderer extends GeoEntityRenderer<HuaSnakeEntity> {
	public HuaSnakeRenderer(EntityRendererProvider.Context renderManager) {
		super(renderManager, new HuaSnakeModel());
		this.shadowRadius = 1.2f;
	}

	@Override
	public RenderType getRenderType(HuaSnakeEntity animatable, ResourceLocation texture, MultiBufferSource bufferSource, float partialTick) {
		return RenderType.entityTranslucent(getTextureLocation(animatable));
	}

	@Override
	public void preRender(PoseStack poseStack, HuaSnakeEntity entity, BakedGeoModel model, MultiBufferSource bufferSource, VertexConsumer buffer, boolean isReRender, float partialTick, int packedLight, int packedOverlay, float red, float green,
			float blue, float alpha) {
		float scale = 1f;
		this.scaleHeight = scale;
		this.scaleWidth = scale;
		super.preRender(poseStack, entity, model, bufferSource, buffer, isReRender, partialTick, packedLight, packedOverlay, red, green, blue, alpha);
	}
}
