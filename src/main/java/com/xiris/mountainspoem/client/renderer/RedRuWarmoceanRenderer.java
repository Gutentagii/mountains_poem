package com.xiris.mountainspoem.client.renderer;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.xiris.mountainspoem.entity.RedRuWarmoceanEntity;
import com.xiris.mountainspoem.entity.model.RedRuWarmoceanModel;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.cache.object.BakedGeoModel;
import software.bernie.geckolib.renderer.GeoEntityRenderer;

public class RedRuWarmoceanRenderer extends GeoEntityRenderer<RedRuWarmoceanEntity> {
    public RedRuWarmoceanRenderer(EntityRendererProvider.Context renderManager) {
        super(renderManager, new RedRuWarmoceanModel());
        this.shadowRadius = 0.5f;
    }

    @Override
    public RenderType getRenderType(RedRuWarmoceanEntity animatable, ResourceLocation texture, MultiBufferSource bufferSource, float partialTick) {
        return RenderType.entityTranslucent(this.getTextureLocation(animatable));
    }

    @Override
    public void preRender(PoseStack poseStack, RedRuWarmoceanEntity entity, BakedGeoModel model, MultiBufferSource bufferSource, VertexConsumer buffer, boolean isReRender, float partialTick, int packedLight, int packedOverlay, float red, float green,
                          float blue, float alpha) {
        float scale = 1f;
        this.scaleHeight = scale;
        this.scaleWidth = scale;
        super.preRender(poseStack, entity, model, bufferSource, buffer, isReRender, partialTick, packedLight, packedOverlay, red, green, blue, alpha);
    }

    @Override
    protected float getDeathMaxRotation(RedRuWarmoceanEntity entityLivingBaseIn) {
        return 0.0F;
    }
}
