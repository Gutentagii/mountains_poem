
package net.mcreator.mountainspoem.client.renderer;

import software.bernie.geckolib.renderer.GeoEntityRenderer;
import software.bernie.geckolib.cache.object.BakedGeoModel;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.MultiBufferSource;

import net.mcreator.mountainspoem.entity.model.MinQuBirdModel;
import net.mcreator.mountainspoem.entity.MinQuBirdEntity;

import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.blaze3d.vertex.PoseStack;

public class MinQuBirdRenderer extends GeoEntityRenderer<MinQuBirdEntity> {
	public MinQuBirdRenderer(EntityRendererProvider.Context renderManager) {
		super(renderManager, new MinQuBirdModel());
		this.shadowRadius = 0.6f;
	}

	@Override
	public RenderType getRenderType(MinQuBirdEntity animatable, ResourceLocation texture, MultiBufferSource bufferSource, float partialTick) {
		return RenderType.entityTranslucent(getTextureLocation(animatable));
	}

	@Override
	public void preRender(PoseStack poseStack, MinQuBirdEntity entity, BakedGeoModel model, MultiBufferSource bufferSource, VertexConsumer buffer, boolean isReRender, float partialTick, int packedLight, int packedOverlay, float red, float green,
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
}
