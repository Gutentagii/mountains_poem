
package net.mcreator.mountainspoem.client.renderer;

import software.bernie.geckolib.renderer.GeoEntityRenderer;
import software.bernie.geckolib.cache.object.BakedGeoModel;

import net.mcreator.mountainspoem.entity.model.SouthernMountainsGodHeadModel;
import net.mcreator.mountainspoem.entity.layer.SouthernMountainsGodHeadLayer;
import net.mcreator.mountainspoem.entity.SouthernMountainsGodHeadEntity;

public class SouthernMountainsGodHeadRenderer extends GeoEntityRenderer<SouthernMountainsGodHeadEntity> {
	public SouthernMountainsGodHeadRenderer(EntityRendererProvider.Context renderManager) {
		super(renderManager, new SouthernMountainsGodHeadModel());
		this.shadowRadius = 0f;
		this.addRenderLayer(new SouthernMountainsGodHeadLayer(this));
	}

	@Override
	public RenderType getRenderType(SouthernMountainsGodHeadEntity animatable, ResourceLocation texture, MultiBufferSource bufferSource, float partialTick) {
		return RenderType.entityTranslucent(getTextureLocation(animatable));
	}

	@Override
	public void preRender(PoseStack poseStack, SouthernMountainsGodHeadEntity entity, BakedGeoModel model, MultiBufferSource bufferSource, VertexConsumer buffer, boolean isReRender, float partialTick, int packedLight, int packedOverlay, float red,
			float green, float blue, float alpha) {
		float scale = 1f;
		this.scaleHeight = scale;
		this.scaleWidth = scale;
		super.preRender(poseStack, entity, model, bufferSource, buffer, isReRender, partialTick, packedLight, packedOverlay, red, green, blue, alpha);
	}
}
