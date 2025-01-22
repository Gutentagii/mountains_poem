package net.mcreator.mountainspoem.client.renderer;

import net.mcreator.mountainspoem.entity.PlagueBallEntity;
import net.mcreator.mountainspoem.client.model.Modelplague_ball;

import com.mojang.math.Axis;

public class PlagueBallRenderer extends EntityRenderer<PlagueBallEntity> {
	private static final ResourceLocation texture = new ResourceLocation("mountains_poem:textures/entities/plague_ball.png");
	private final Modelplague_ball model;

	public PlagueBallRenderer(EntityRendererProvider.Context context) {
		super(context);
		model = new Modelplague_ball(context.bakeLayer(Modelplague_ball.LAYER_LOCATION));
	}

	@Override
	public void render(PlagueBallEntity entityIn, float entityYaw, float partialTicks, PoseStack poseStack, MultiBufferSource bufferIn, int packedLightIn) {
		VertexConsumer vb = bufferIn.getBuffer(RenderType.entityCutout(this.getTextureLocation(entityIn)));
		poseStack.pushPose();
		poseStack.mulPose(Axis.YP.rotationDegrees(Mth.lerp(partialTicks, entityIn.yRotO, entityIn.getYRot()) - 90));
		poseStack.mulPose(Axis.ZP.rotationDegrees(90 + Mth.lerp(partialTicks, entityIn.xRotO, entityIn.getXRot())));
		model.renderToBuffer(poseStack, vb, packedLightIn, OverlayTexture.NO_OVERLAY, 1, 1, 1, 1);
		poseStack.popPose();
		super.render(entityIn, entityYaw, partialTicks, poseStack, bufferIn, packedLightIn);
	}

	@Override
	public ResourceLocation getTextureLocation(PlagueBallEntity entity) {
		return texture;
	}
}
