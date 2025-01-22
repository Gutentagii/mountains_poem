package net.mcreator.mountainspoem.entity.layer;

import software.bernie.geckolib.renderer.layer.GeoRenderLayer;
import software.bernie.geckolib.renderer.GeoRenderer;
import software.bernie.geckolib.cache.object.BakedGeoModel;

import net.mcreator.mountainspoem.entity.SouthernMountainsGodHeadEntity;

public class SouthernMountainsGodHeadLayer extends GeoRenderLayer<SouthernMountainsGodHeadEntity> {
	private static final ResourceLocation LAYER = new ResourceLocation("mountains_poem", "textures/entities/south_god_head_layer.png");

	public SouthernMountainsGodHeadLayer(GeoRenderer<SouthernMountainsGodHeadEntity> entityRenderer) {
		super(entityRenderer);
	}

	@Override
	public void render(PoseStack poseStack, SouthernMountainsGodHeadEntity animatable, BakedGeoModel bakedModel, RenderType renderType, MultiBufferSource bufferSource, VertexConsumer buffer, float partialTick, int packedLight, int packedOverlay) {
		RenderType glowRenderType = RenderType.eyes(LAYER);
		getRenderer().reRender(getDefaultBakedModel(animatable), poseStack, bufferSource, animatable, glowRenderType, bufferSource.getBuffer(glowRenderType), partialTick, packedLight, OverlayTexture.NO_OVERLAY, 1, 1, 1, 1);
	}
}
