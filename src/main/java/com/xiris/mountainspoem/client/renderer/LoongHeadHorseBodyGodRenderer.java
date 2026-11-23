package com.xiris.mountainspoem.client.renderer;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.xiris.mountainspoem.entity.LoongHeadHorseBodyGodEntity;
import com.xiris.mountainspoem.entity.model.LoongHeadHorseBodyGodModel;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.cache.object.BakedGeoModel;
import software.bernie.geckolib.renderer.GeoEntityRenderer;

public class LoongHeadHorseBodyGodRenderer extends GeoEntityRenderer<LoongHeadHorseBodyGodEntity> {
    public LoongHeadHorseBodyGodRenderer(EntityRendererProvider.Context renderManager) {
        super(renderManager, new LoongHeadHorseBodyGodModel());
        this.shadowRadius = 2.3f;
    }

    @Override
    public RenderType getRenderType(LoongHeadHorseBodyGodEntity animatable, ResourceLocation texture, MultiBufferSource bufferSource, float partialTick) {
        return RenderType.entityTranslucent(this.getTextureLocation(animatable));
    }

    @Override
    public void preRender(PoseStack poseStack, LoongHeadHorseBodyGodEntity entity, BakedGeoModel model, MultiBufferSource bufferSource, VertexConsumer buffer, boolean isReRender, float partialTick, int packedLight, int packedOverlay, float red,
                          float green, float blue, float alpha) {
        float scale = 1f;
        this.scaleHeight = scale;
        this.scaleWidth = scale;
        super.preRender(poseStack, entity, model, bufferSource, buffer, isReRender, partialTick, packedLight, packedOverlay, red, green, blue, alpha);
    }

    @Override
    protected float getDeathMaxRotation(LoongHeadHorseBodyGodEntity entityLivingBaseIn) {
        return 0.0F;
    }
}
