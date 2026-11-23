package com.xiris.mountainspoem.client.renderer;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.xiris.mountainspoem.entity.FenghuangPhoenixEntity;
import com.xiris.mountainspoem.entity.model.FenghuangPhoenixModel;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.cache.object.BakedGeoModel;
import software.bernie.geckolib.renderer.GeoEntityRenderer;

public class FenghuangPhoenixRenderer extends GeoEntityRenderer<FenghuangPhoenixEntity> {
    public FenghuangPhoenixRenderer(EntityRendererProvider.Context renderManager) {
        super(renderManager, new FenghuangPhoenixModel());
        this.shadowRadius = 0.5f;
    }

    @Override
    public RenderType getRenderType(FenghuangPhoenixEntity animatable, ResourceLocation texture, MultiBufferSource bufferSource, float partialTick) {
        return RenderType.entityTranslucent(this.getTextureLocation(animatable));
    }

    @Override
    public void preRender(PoseStack poseStack, FenghuangPhoenixEntity entity, BakedGeoModel model, MultiBufferSource bufferSource, VertexConsumer buffer, boolean isReRender, float partialTick, int packedLight, int packedOverlay, float red,
                          float green, float blue, float alpha) {

        if (entity.isBaby()) {
            poseStack.scale(0.8f, 0.8f, 0.8f);
        } else {
            poseStack.scale(1f, 1f, 1f);
        }

        super.preRender(poseStack, entity, model, bufferSource, buffer, isReRender, partialTick, packedLight, packedOverlay, red, green, blue, alpha);
    }
}
