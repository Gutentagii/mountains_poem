package com.xiris.mountainspoem.entity.layer;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.xiris.mountainspoem.MountainsPoemMod;
import com.xiris.mountainspoem.entity.FuriousSouthernMountainsGodHeadEntity;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.cache.object.BakedGeoModel;
import software.bernie.geckolib.renderer.GeoRenderer;
import software.bernie.geckolib.renderer.layer.GeoRenderLayer;

public class FuriousSouthernMountainsGodHeadLayer extends GeoRenderLayer<FuriousSouthernMountainsGodHeadEntity> {
    private static final ResourceLocation LAYER = ResourceLocation.fromNamespaceAndPath(MountainsPoemMod.MOD_ID, "textures/entities/south_god_head_layer.png");

    public FuriousSouthernMountainsGodHeadLayer(GeoRenderer<FuriousSouthernMountainsGodHeadEntity> entityRenderer) {
        super(entityRenderer);
    }

    @Override
    public void render(PoseStack poseStack, FuriousSouthernMountainsGodHeadEntity animatable, BakedGeoModel bakedModel, RenderType renderType, MultiBufferSource bufferSource, VertexConsumer buffer, float partialTick, int packedLight, int packedOverlay) {
        RenderType glowRenderType = RenderType.eyes(LAYER);
        this.getRenderer().reRender(this.getDefaultBakedModel(animatable), poseStack, bufferSource, animatable, glowRenderType, bufferSource.getBuffer(glowRenderType), partialTick, packedLight, OverlayTexture.NO_OVERLAY, 1, 1, 1, 1);
    }
}
