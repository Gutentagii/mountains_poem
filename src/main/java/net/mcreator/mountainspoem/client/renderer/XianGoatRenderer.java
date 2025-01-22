
package net.mcreator.mountainspoem.client.renderer;

import software.bernie.geckolib.renderer.GeoEntityRenderer;
import software.bernie.geckolib.cache.object.BakedGeoModel;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.MultiBufferSource;

import net.mcreator.mountainspoem.entity.model.XianGoatModel;
import net.mcreator.mountainspoem.entity.XianGoatEntity;

import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.blaze3d.vertex.PoseStack;

public class XianGoatRenderer extends GeoEntityRenderer<XianGoatEntity> {
	public XianGoatRenderer(EntityRendererProvider.Context renderManager) {
		super(renderManager, new XianGoatModel());
		this.shadowRadius = 0.5f;
	}

	@Override
	public RenderType getRenderType(XianGoatEntity animatable, ResourceLocation texture, MultiBufferSource bufferSource, float partialTick) {
		return RenderType.entityTranslucent(getTextureLocation(animatable));
	}

	@Override
	public void preRender(PoseStack poseStack, XianGoatEntity entity, BakedGeoModel model, MultiBufferSource bufferSource, VertexConsumer buffer, boolean isReRender, float partialTick, int packedLight, int packedOverlay, float red, float green,
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
