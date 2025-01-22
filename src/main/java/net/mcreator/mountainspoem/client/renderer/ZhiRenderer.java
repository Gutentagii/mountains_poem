
package net.mcreator.mountainspoem.client.renderer;

import software.bernie.geckolib.renderer.GeoEntityRenderer;
import software.bernie.geckolib.cache.object.BakedGeoModel;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.MultiBufferSource;

import net.mcreator.mountainspoem.entity.model.ZhiModel;
import net.mcreator.mountainspoem.entity.ZhiEntity;

import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.blaze3d.vertex.PoseStack;

public class ZhiRenderer extends GeoEntityRenderer<ZhiEntity> {
	public ZhiRenderer(EntityRendererProvider.Context renderManager) {
		super(renderManager, new ZhiModel());
		this.shadowRadius = 1.1f;
	}

	@Override
	public RenderType getRenderType(ZhiEntity animatable, ResourceLocation texture, MultiBufferSource bufferSource, float partialTick) {
		return RenderType.entityTranslucent(getTextureLocation(animatable));
	}

	@Override
	public void preRender(PoseStack poseStack, ZhiEntity entity, BakedGeoModel model, MultiBufferSource bufferSource, VertexConsumer buffer, boolean isReRender, float partialTick, int packedLight, int packedOverlay, float red, float green,
			float blue, float alpha) {
		
			if(entity.isBaby()) {
			poseStack.scale (0.5f, 0.5f, 0.5f);
			} else {
			poseStack.scale (1f, 1f, 1f);
			}

		//this.scaleHeight = scale;
		//this.scaleWidth = scale;
		super.preRender(poseStack, entity, model, bufferSource, buffer, isReRender, partialTick, packedLight, packedOverlay, red, green, blue, alpha);
	}

	@Override
	protected float getDeathMaxRotation(ZhiEntity entityLivingBaseIn) {
		return 0.0F;
	}
}
