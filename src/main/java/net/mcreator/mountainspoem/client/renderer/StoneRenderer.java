package net.mcreator.mountainspoem.client.renderer;

import net.mcreator.mountainspoem.entity.StoneEntity;
import net.mcreator.mountainspoem.client.model.Modelstone;

import com.mojang.math.Axis;

public class StoneRenderer extends EntityRenderer<StoneEntity> {
	private static final ResourceLocation texture = new ResourceLocation("mountains_poem:textures/entities/stone.png");
	private final Modelstone model;

	public StoneRenderer(EntityRendererProvider.Context context) {
		super(context);
		model = new Modelstone(context.bakeLayer(Modelstone.LAYER_LOCATION));
	}

	@Override
	public void render(StoneEntity entityIn, float entityYaw, float partialTicks, PoseStack poseStack, MultiBufferSource bufferIn, int packedLightIn) {
		VertexConsumer vb = bufferIn.getBuffer(RenderType.entityCutout(this.getTextureLocation(entityIn)));
		poseStack.pushPose();
		poseStack.mulPose(Axis.YP.rotationDegrees(Mth.lerp(partialTicks, entityIn.yRotO, entityIn.getYRot()) - 90));
		poseStack.mulPose(Axis.ZP.rotationDegrees(90 + Mth.lerp(partialTicks, entityIn.xRotO, entityIn.getXRot())));
		model.renderToBuffer(poseStack, vb, packedLightIn, OverlayTexture.NO_OVERLAY, 1, 1, 1, 1);
		poseStack.popPose();
		super.render(entityIn, entityYaw, partialTicks, poseStack, bufferIn, packedLightIn);
	}

	@Override
	public ResourceLocation getTextureLocation(StoneEntity entity) {
		return texture;
	}
}
