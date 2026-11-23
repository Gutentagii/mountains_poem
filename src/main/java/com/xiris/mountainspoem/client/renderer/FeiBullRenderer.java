package com.xiris.mountainspoem.client.renderer;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.xiris.mountainspoem.entity.FeiBullEntity;
import com.xiris.mountainspoem.entity.model.FeiBullModel;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.cache.object.BakedGeoModel;
import software.bernie.geckolib.renderer.GeoEntityRenderer;

public class FeiBullRenderer extends GeoEntityRenderer<FeiBullEntity> {
    public FeiBullRenderer(EntityRendererProvider.Context renderManager) {
        super(renderManager, new FeiBullModel());
        this.shadowRadius = 1.8f;
    }

    @Override
    public RenderType getRenderType(FeiBullEntity animatable, ResourceLocation texture, MultiBufferSource bufferSource, float partialTick) {
        return RenderType.entityTranslucent(this.getTextureLocation(animatable));
    }

    @Override
    public void preRender(PoseStack poseStack, FeiBullEntity entity, BakedGeoModel model, MultiBufferSource bufferSource, VertexConsumer buffer, boolean isReRender, float partialTick, int packedLight, int packedOverlay, float red, float green,
                          float blue, float alpha) {
        float scale = 1f;
        this.scaleHeight = scale;
        this.scaleWidth = scale;
        super.preRender(poseStack, entity, model, bufferSource, buffer, isReRender, partialTick, packedLight, packedOverlay, red, green, blue, alpha);
    }

    @Override
    protected float getDeathMaxRotation(FeiBullEntity entityLivingBaseIn) {
        return 0.0F;
    }
}
