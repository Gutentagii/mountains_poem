package net.mcreator.mountainspoem.entity.layer;

import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.renderer.layer.GeoRenderLayer;
import software.bernie.geckolib.renderer.GeoRenderer;
import software.bernie.geckolib.cache.object.BakedGeoModel;

import net.mcreator.mountainspoem.entity.FuriousSouthernMountainsGodHeadEntity;

public class FuriousSouthernMountainsGodHeadLayer extends GeoRenderLayer<FuriousSouthernMountainsGodHeadEntity> {
	private static final ResourceLocation LAYER = new ResourceLocation("mountains_poem", "textures/entities/south_god_head_layer.png");

	public FuriousSouthernMountainsGodHeadLayer(GeoRenderer<FuriousSouthernMountainsGodHeadEntity> entityRenderer) {
		super(entityRenderer);
	}

	@Override
	public void render(PoseStack poseStack, FuriousSouthernMountainsGodHeadEntity animatable, BakedGeoModel bakedModel, RenderType renderType, MultiBufferSource bufferSource, VertexConsumer buffer, float partialTick, int packedLight,
					   int packedOverlay) {
		RenderType glowRenderType = RenderType.eyes(LAYER);
		getRenderer().reRender(getDefaultBakedModel(animatable), poseStack, bufferSource, animatable, glowRenderType, bufferSource.getBuffer(glowRenderType), partialTick, packedLight, OverlayTexture.NO_OVERLAY, 1, 1, 1, 1);
	}
}
