package com.xiris.mountainspoem.client.renderer;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.xiris.mountainspoem.entity.JufuEntity;
import com.xiris.mountainspoem.entity.model.JufuModel;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.cache.object.BakedGeoModel;
import software.bernie.geckolib.renderer.GeoEntityRenderer;

public class JufuRenderer extends GeoEntityRenderer<JufuEntity> {
    public JufuRenderer(EntityRendererProvider.Context renderManager) {
        super(renderManager, new JufuModel());
        this.shadowRadius = 0.8f;
    }

    @Override
    public RenderType getRenderType(JufuEntity animatable, ResourceLocation texture, MultiBufferSource bufferSource, float partialTick) {
        return RenderType.entityTranslucent(this.getTextureLocation(animatable));
    }

    @Override
    public void preRender(PoseStack poseStack, JufuEntity entity, BakedGeoModel model, MultiBufferSource bufferSource, VertexConsumer buffer, boolean isReRender, float partialTick, int packedLight, int packedOverlay, float red, float green,
                          float blue, float alpha) {

        if (entity.isBaby()) {
            poseStack.scale(0.6f, 0.6f, 0.6f);
        } else {
            poseStack.scale(1f, 1f, 1f);
        }

        super.preRender(poseStack, entity, model, bufferSource, buffer, isReRender, partialTick, packedLight, packedOverlay, red, green, blue, alpha);
    }

    @Override
    protected float getDeathMaxRotation(JufuEntity entityLivingBaseIn) {
        return 0.0F;
    }
}
