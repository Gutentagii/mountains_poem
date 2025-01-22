
package net.mcreator.mountainspoem.client.renderer;

import software.bernie.geckolib.renderer.GeoEntityRenderer;
import software.bernie.geckolib.cache.object.BakedGeoModel;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.MultiBufferSource;

import net.mcreator.mountainspoem.entity.model.HuHorseModel;
import net.mcreator.mountainspoem.entity.HuHorseEntity;

import com.mojang.blaze3d.vertex.VertexConsumer; 
import com.mojang.blaze3d.vertex.PoseStack;

public class HuHorseRenderer extends GeoEntityRenderer<HuHorseEntity> {
	public HuHorseRenderer(EntityRendererProvider.Context renderManager) {
		super(renderManager, new HuHorseModel());
		this.shadowRadius = 0.6f;
	}

	@Override
	public RenderType getRenderType(HuHorseEntity animatable, ResourceLocation texture, MultiBufferSource bufferSource, float partialTick) {
		return RenderType.entityTranslucent(getTextureLocation(animatable));
	}

	@Override
	public void preRender(PoseStack poseStack, HuHorseEntity entity, BakedGeoModel model, MultiBufferSource bufferSource, VertexConsumer buffer, boolean isReRender, float partialTick, int packedLight, int packedOverlay, float red, float green,
			float blue, float alpha) {
		
			if(entity.isBaby()) {
			poseStack.scale (0.7f, 0.7f, 0.7f);
			} else {
			poseStack.scale (1f, 1f, 1f);
			}

		//this.scaleHeight = scale;
		//this.scaleWidth = scale;
		super.preRender(poseStack, entity, model, bufferSource, buffer, isReRender, partialTick, packedLight, packedOverlay, red, green, blue, alpha);
	}
}
