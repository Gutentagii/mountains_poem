
package net.mcreator.mountainspoem.client.renderer;

import software.bernie.geckolib.renderer.GeoEntityRenderer;
import software.bernie.geckolib.cache.object.BakedGeoModel;

import net.mcreator.mountainspoem.entity.model.FuriousSouthernMountainsGodHeadModel;
import net.mcreator.mountainspoem.entity.layer.FuriousSouthernMountainsGodHeadLayer;
import net.mcreator.mountainspoem.entity.FuriousSouthernMountainsGodHeadEntity;

public class FuriousSouthernMountainsGodHeadRenderer extends GeoEntityRenderer<FuriousSouthernMountainsGodHeadEntity> {
	public FuriousSouthernMountainsGodHeadRenderer(EntityRendererProvider.Context renderManager) {
		super(renderManager, new FuriousSouthernMountainsGodHeadModel());
		this.shadowRadius = 0.5f;
		this.addRenderLayer(new FuriousSouthernMountainsGodHeadLayer(this));
	}

	@Override
	public RenderType getRenderType(FuriousSouthernMountainsGodHeadEntity animatable, ResourceLocation texture, MultiBufferSource bufferSource, float partialTick) {
		return RenderType.entityTranslucent(getTextureLocation(animatable));
	}

	@Override
	public void preRender(PoseStack poseStack, FuriousSouthernMountainsGodHeadEntity entity, BakedGeoModel model, MultiBufferSource bufferSource, VertexConsumer buffer, boolean isReRender, float partialTick, int packedLight, int packedOverlay,
			float red, float green, float blue, float alpha) {
		float scale = 1f;
		this.scaleHeight = scale;
		this.scaleWidth = scale;
		super.preRender(poseStack, entity, model, bufferSource, buffer, isReRender, partialTick, packedLight, packedOverlay, red, green, blue, alpha);
	}
}
