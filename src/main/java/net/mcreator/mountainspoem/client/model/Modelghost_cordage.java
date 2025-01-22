package net.mcreator.mountainspoem.client.model;

// Made with Blockbench 4.10.3
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports
public class Modelghost_cordage<T extends Entity> extends EntityModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in
	// the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation("mountains_poem", "modelghost_cordage"), "main");
	public final ModelPart bb_main;

	public Modelghost_cordage(ModelPart root) {
		this.bb_main = root.getChild("bb_main");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();
		PartDefinition bb_main = partdefinition.addOrReplaceChild("bb_main",
				CubeListBuilder.create().texOffs(0, 0).addBox(-7.0F, -2.0F, -7.0F, 2.0F, 2.0F, 14.0F, new CubeDeformation(0.0F)).texOffs(0, 16).addBox(-5.0F, -2.0F, 5.0F, 10.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(0, 0)
						.addBox(5.0F, -2.0F, -7.0F, 2.0F, 2.0F, 14.0F, new CubeDeformation(0.0F)).texOffs(0, 16).addBox(-5.0F, -2.0F, -7.0F, 10.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)),
				PartPose.offset(0.0F, 24.0F, 0.0F));
		return LayerDefinition.create(meshdefinition, 32, 32);
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		bb_main.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}

	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.bb_main.yRot = netHeadYaw / (180F / (float) Math.PI);
		this.bb_main.xRot = headPitch / (180F / (float) Math.PI);
	}
}
