package net.mcreator.mountainspoem.client.renderer;

import net.mcreator.mountainspoem.entity.GhostCordageEntity;
import net.mcreator.mountainspoem.client.model.Modelghost_cordage;

import com.mojang.math.Axis;

public class GhostCordageRenderer extends EntityRenderer<GhostCordageEntity> {
	private static final ResourceLocation texture = new ResourceLocation("mountains_poem:textures/entities/ghost_cordage.png");
	private final Modelghost_cordage model;

	public GhostCordageRenderer(EntityRendererProvider.Context context) {
		super(context);
		model = new Modelghost_cordage(context.bakeLayer(Modelghost_cordage.LAYER_LOCATION));
	}

	@Override
	public void render(GhostCordageEntity entityIn, float entityYaw, float partialTicks, PoseStack poseStack, MultiBufferSource bufferIn, int packedLightIn) {
		VertexConsumer vb = bufferIn.getBuffer(RenderType.entityCutout(this.getTextureLocation(entityIn)));
		poseStack.pushPose();
		poseStack.mulPose(Axis.YP.rotationDegrees(Mth.lerp(partialTicks, entityIn.yRotO, entityIn.getYRot()) - 90));
		poseStack.mulPose(Axis.ZP.rotationDegrees(90 + Mth.lerp(partialTicks, entityIn.xRotO, entityIn.getXRot())));
		model.renderToBuffer(poseStack, vb, packedLightIn, OverlayTexture.NO_OVERLAY, 1, 1, 1, 1);
		poseStack.popPose();
		super.render(entityIn, entityYaw, partialTicks, poseStack, bufferIn, packedLightIn);
	}

	@Override
	public ResourceLocation getTextureLocation(GhostCordageEntity entity) {
		return texture;
	}
}
