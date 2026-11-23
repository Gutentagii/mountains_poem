package com.xiris.mountainspoem.client.renderer;

import com.xiris.mountainspoem.MountainsPoemMod;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.math.Axis;
import com.xiris.mountainspoem.client.model.Modelstone;
import com.xiris.mountainspoem.entity.StoneEntity;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;

public class StoneRenderer extends EntityRenderer<StoneEntity> {
    private static final ResourceLocation texture = ResourceLocation.fromNamespaceAndPath(MountainsPoemMod.MOD_ID,"textures/entities/stone.png");
    private final Modelstone model;

    public StoneRenderer(EntityRendererProvider.Context context) {
        super(context);
        this.model = new Modelstone(context.bakeLayer(Modelstone.LAYER_LOCATION));
    }

    @Override
    public void render(StoneEntity entityIn, float entityYaw, float partialTicks, PoseStack poseStack, MultiBufferSource bufferIn, int packedLightIn) {
        VertexConsumer vb = bufferIn.getBuffer(RenderType.entityCutout(this.getTextureLocation(entityIn)));
        poseStack.pushPose();
        poseStack.mulPose(Axis.YP.rotationDegrees(Mth.lerp(partialTicks, entityIn.yRotO, entityIn.getYRot()) - 90));
        poseStack.mulPose(Axis.ZP.rotationDegrees(90 + Mth.lerp(partialTicks, entityIn.xRotO, entityIn.getXRot())));
        this.model.renderToBuffer(poseStack, vb, packedLightIn, OverlayTexture.NO_OVERLAY, 1, 1, 1, 1);
        poseStack.popPose();
        super.render(entityIn, entityYaw, partialTicks, poseStack, bufferIn, packedLightIn);
    }

    @Override
    public ResourceLocation getTextureLocation(StoneEntity entity) {
        return texture;
    }
}
