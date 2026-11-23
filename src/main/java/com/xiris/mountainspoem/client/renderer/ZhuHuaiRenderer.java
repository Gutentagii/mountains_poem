package com.xiris.mountainspoem.client.renderer;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.xiris.mountainspoem.entity.ZhuHuaiEntity;
import com.xiris.mountainspoem.entity.model.ZhuHuaiModel;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.cache.object.BakedGeoModel;
import software.bernie.geckolib.renderer.GeoEntityRenderer;

public class ZhuHuaiRenderer extends GeoEntityRenderer<ZhuHuaiEntity> {
    public ZhuHuaiRenderer(EntityRendererProvider.Context renderManager) {
        super(renderManager, new ZhuHuaiModel());
        this.shadowRadius = 0.5f;
    }

    @Override
    public RenderType getRenderType(ZhuHuaiEntity animatable, ResourceLocation texture, MultiBufferSource bufferSource, float partialTick) {
        return RenderType.entityTranslucent(this.getTextureLocation(animatable));
    }

    @Override
    public void preRender(PoseStack poseStack, ZhuHuaiEntity entity, BakedGeoModel model, MultiBufferSource bufferSource, VertexConsumer buffer, boolean isReRender, float partialTick, int packedLight, int packedOverlay, float red, float green,
                          float blue, float alpha) {

        if (entity.isBaby()) {
            poseStack.scale(0.6f, 0.6f, 0.6f);
        } else {
            poseStack.scale(1f, 1f, 1f);
        }

        super.preRender(poseStack, entity, model, bufferSource, buffer, isReRender, partialTick, packedLight, packedOverlay, red, green, blue, alpha);
    }

    @Override
    protected float getDeathMaxRotation(ZhuHuaiEntity entityLivingBaseIn) {
        return 0.0F;
    }
}
