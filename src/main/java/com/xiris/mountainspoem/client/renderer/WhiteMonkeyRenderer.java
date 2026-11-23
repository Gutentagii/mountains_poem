package com.xiris.mountainspoem.client.renderer;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.xiris.mountainspoem.entity.WhiteMonkeyEntity;
import com.xiris.mountainspoem.entity.model.WhiteMonkeyModel;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.cache.object.BakedGeoModel;
import software.bernie.geckolib.renderer.GeoEntityRenderer;

public class WhiteMonkeyRenderer extends GeoEntityRenderer<WhiteMonkeyEntity> {
    public WhiteMonkeyRenderer(EntityRendererProvider.Context renderManager) {
        super(renderManager, new WhiteMonkeyModel());
        this.shadowRadius = 0.5f;
    }

    @Override
    public RenderType getRenderType(WhiteMonkeyEntity animatable, ResourceLocation texture, MultiBufferSource bufferSource, float partialTick) {
        return RenderType.entityTranslucent(this.getTextureLocation(animatable));
    }

    @Override
    public void preRender(PoseStack poseStack, WhiteMonkeyEntity entity, BakedGeoModel model, MultiBufferSource bufferSource, VertexConsumer buffer, boolean isReRender, float partialTick, int packedLight, int packedOverlay, float red, float green,
                          float blue, float alpha) {

        if (entity.isBaby()) {
            poseStack.scale(0.8f, 0.8f, 0.8f);
        } else {
            poseStack.scale(1f, 1f, 1f);
        }

        super.preRender(poseStack, entity, model, bufferSource, buffer, isReRender, partialTick, packedLight, packedOverlay, red, green, blue, alpha);
    }

    @Override
    protected float getDeathMaxRotation(WhiteMonkeyEntity entityLivingBaseIn) {
        return 0.0F;
    }
}
