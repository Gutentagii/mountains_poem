// Made with Blockbench 4.10.4
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports

public class Modelblood_copper_armor<T extends Entity> extends EntityModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in
	// the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(
			new ResourceLocation("modid", "blood_copper_armor"), "main");
	private final ModelPart Head;
	private final ModelPart bone;
	private final ModelPart bone2;
	private final ModelPart bone3;
	private final ModelPart Body;
	private final ModelPart LeftArm;
	private final ModelPart RightArm;
	private final ModelPart LeftLeg;
	private final ModelPart RightLeg;

	public Modelblood_copper_armor(ModelPart root) {
		this.Head = root.getChild("Head");
		this.bone = root.getChild("bone");
		this.bone2 = root.getChild("bone2");
		this.bone3 = root.getChild("bone3");
		this.Body = root.getChild("Body");
		this.LeftArm = root.getChild("LeftArm");
		this.RightArm = root.getChild("RightArm");
		this.LeftLeg = root.getChild("LeftLeg");
		this.RightLeg = root.getChild("RightLeg");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition Head = partdefinition.addOrReplaceChild("Head",
				CubeListBuilder.create().texOffs(12, 79)
						.addBox(-5.1F, -6.4F, -4.8F, 10.0F, 2.0F, 10.0F, new CubeDeformation(0.3F)).texOffs(56, 78)
						.addBox(-4.5F, -9.4F, -4.3F, 9.0F, 3.0F, 9.0F, new CubeDeformation(0.3F)).texOffs(80, 55)
						.addBox(-1.0F, -13.1F, -0.8F, 2.0F, 4.0F, 2.0F, new CubeDeformation(0.2F)),
				PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition armorHead_r1 = Head.addOrReplaceChild("armorHead_r1",
				CubeListBuilder.create().texOffs(81, 29).addBox(-0.35F, -0.3F, -0.9F, 3.9F, 4.0F, 1.0F,
						new CubeDeformation(0.3F)),
				PartPose.offsetAndRotation(-3.6375F, -2.4774F, -0.5218F, -1.591F, 0.0F, -1.5708F));

		PartDefinition armorHead_r2 = Head.addOrReplaceChild("armorHead_r2",
				CubeListBuilder.create().texOffs(81, 29).mirror()
						.addBox(-3.55F, -0.3F, -0.9F, 3.9F, 4.0F, 1.0F, new CubeDeformation(0.3F)).mirror(false),
				PartPose.offsetAndRotation(3.6375F, -2.4774F, -0.5218F, -1.591F, 0.0F, 1.5708F));

		PartDefinition armorHead_r3 = Head.addOrReplaceChild("armorHead_r3",
				CubeListBuilder.create().texOffs(0, 27).addBox(-4.05F, -3.0F, -0.5F, 4.0F, 6.0F, 1.0F,
						new CubeDeformation(0.3F)),
				PartPose.offsetAndRotation(-0.05F, -3.4F, 5.2F, 0.2233F, -0.2129F, -0.0479F));

		PartDefinition armorHead_r4 = Head.addOrReplaceChild("armorHead_r4",
				CubeListBuilder.create().texOffs(0, 27).mirror()
						.addBox(-0.05F, -3.0F, -0.5F, 4.0F, 6.0F, 1.0F, new CubeDeformation(0.3F)).mirror(false),
				PartPose.offsetAndRotation(-0.05F, -3.4F, 5.2F, 0.2233F, 0.2129F, 0.0479F));

		PartDefinition bone = Head.addOrReplaceChild("bone", CubeListBuilder.create(),
				PartPose.offset(0.0F, 0.0F, 0.2F));

		PartDefinition bone_r1 = bone.addOrReplaceChild("bone_r1",
				CubeListBuilder.create().texOffs(24, 24).mirror()
						.addBox(-2.05F, -2.5F, -1.6F, 4.0F, 6.0F, 1.0F, new CubeDeformation(0.2F)).mirror(false),
				PartPose.offsetAndRotation(3.9375F, -2.7774F, 1.1783F, -1.5857F, 0.041F, 1.2214F));

		PartDefinition bone2 = Head.addOrReplaceChild("bone2", CubeListBuilder.create(),
				PartPose.offset(0.0F, 0.0F, 0.2F));

		PartDefinition bone2_r1 = bone2.addOrReplaceChild("bone2_r1",
				CubeListBuilder.create().texOffs(24, 24).addBox(-2.05F, -2.5F, -1.6F, 4.0F, 6.0F, 1.0F,
						new CubeDeformation(0.2F)),
				PartPose.offsetAndRotation(-3.9375F, -2.7774F, 1.1783F, -1.5857F, -0.041F, -1.2214F));

		PartDefinition bone3 = Head.addOrReplaceChild("bone3", CubeListBuilder.create(),
				PartPose.offset(0.0F, -10.0F, 1.2F));

		PartDefinition bone3_r1 = bone3.addOrReplaceChild("bone3_r1",
				CubeListBuilder.create().texOffs(17, 71).addBox(-1.0F, -3.2124F, -1.7314F, 2.0F, 3.0F, 2.0F,
						new CubeDeformation(0.3F)),
				PartPose.offsetAndRotation(0.0F, -1.194F, -0.74F, -1.8762F, 0.0F, 0.0F));

		PartDefinition Body = partdefinition.addOrReplaceChild("Body",
				CubeListBuilder.create().texOffs(28, 36)
						.addBox(-4.0F, 0.2F, -1.0F, 8.0F, 5.0F, 4.0F, new CubeDeformation(0.16F)).texOffs(40, 8)
						.addBox(-4.5F, 4.2F, -2.0F, 9.0F, 8.0F, 4.0F, new CubeDeformation(0.6F)).texOffs(46, 51)
						.addBox(-3.5F, 7.4F, -2.8F, 7.0F, 1.0F, 1.0F, new CubeDeformation(0.16F)).texOffs(0, 14)
						.addBox(-4.5F, 5.2F, -3.9F, 9.0F, 8.0F, 1.0F, new CubeDeformation(0.3F)).texOffs(0, 0)
						.addBox(-4.0F, 0.2F, -4.0F, 8.0F, 5.0F, 1.0F, new CubeDeformation(0.3F)),
				PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition armorBody_r1 = Body.addOrReplaceChild("armorBody_r1",
				CubeListBuilder.create().texOffs(33, 61).mirror()
						.addBox(-0.8832F, -3.9116F, -3.0371F, 1.0F, 8.0F, 5.0F, new CubeDeformation(0.3F))
						.mirror(false),
				PartPose.offsetAndRotation(-4.0884F, 12.4384F, -0.3F, 0.0F, 0.0F, 0.1309F));

		PartDefinition armorBody_r2 = Body.addOrReplaceChild("armorBody_r2",
				CubeListBuilder.create().texOffs(33, 61).addBox(0.0513F, -3.9116F, -3.0371F, 1.0F, 8.0F, 5.0F,
						new CubeDeformation(0.3F)),
				PartPose.offsetAndRotation(4.0884F, 12.4384F, -0.3F, 0.0F, 0.0F, -0.1309F));

		PartDefinition LeftArm = partdefinition.addOrReplaceChild("LeftArm",
				CubeListBuilder.create().texOffs(49, 30)
						.addBox(-14.6F, -2.64F, -3.1F, 6.0F, 2.0F, 6.0F, new CubeDeformation(0.3F)).texOffs(45, 0)
						.addBox(-13.1F, -0.6F, 1.0F, 4.0F, 2.0F, 1.0F, new CubeDeformation(0.3F)).texOffs(45, 0)
						.addBox(-13.1F, -0.6F, -3.0F, 4.0F, 2.0F, 1.0F, new CubeDeformation(0.3F)).texOffs(50, 70)
						.addBox(-15.64F, -2.76F, -1.3F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.3F)).texOffs(0, 0)
						.addBox(-1.0F, -2.0F, -1.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)),
				PartPose.offset(4.6F, 2.0F, 0.0F));

		PartDefinition armorLeftArm_r1 = LeftArm.addOrReplaceChild("armorLeftArm_r1",
				CubeListBuilder.create().texOffs(10, 30).addBox(-5.392F, 0.244F, -2.9F, 1.0F, 6.0F, 6.0F,
						new CubeDeformation(0.3F)),
				PartPose.offsetAndRotation(-9.308F, -1.444F, -0.1F, 0.0F, 0.0F, 0.2618F));

		PartDefinition RightArm = partdefinition.addOrReplaceChild("RightArm", CubeListBuilder.create().texOffs(50, 70)
				.mirror().addBox(14.132F, -2.783F, -1.21F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.3F)).mirror(false)
				.texOffs(45, 0).mirror().addBox(9.1F, -0.6F, -3.0F, 4.0F, 2.0F, 1.0F, new CubeDeformation(0.3F))
				.mirror(false).texOffs(45, 0).mirror()
				.addBox(9.1F, -0.6F, 1.0F, 4.0F, 2.0F, 1.0F, new CubeDeformation(0.3F)).mirror(false).texOffs(49, 30)
				.mirror().addBox(8.89F, -2.662F, -3.025F, 6.0F, 2.0F, 6.0F, new CubeDeformation(0.3F)).mirror(false),
				PartPose.offset(-4.6F, 2.0F, 0.0F));

		PartDefinition armorRightArm_r1 = RightArm.addOrReplaceChild("armorRightArm_r1",
				CubeListBuilder.create().texOffs(10, 30).mirror()
						.addBox(3.3536F, 0.2552F, -3.0F, 1.0F, 6.0F, 6.0F, new CubeDeformation(0.3F)).mirror(false),
				PartPose.offsetAndRotation(10.6464F, -1.7552F, 0.0F, 0.0F, 0.0F, -0.2618F));

		PartDefinition LeftLeg = partdefinition.addOrReplaceChild("LeftLeg", CubeListBuilder.create().texOffs(112, 112)
				.addBox(-2.4F, -1.1F, -2.6F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.3F)),
				PartPose.offset(-2.0F, 12.0F, 0.0F));

		PartDefinition RightLeg = partdefinition.addOrReplaceChild("RightLeg",
				CubeListBuilder.create().texOffs(112, 112).mirror()
						.addBox(-1.6F, -1.1F, -2.6F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.3F)).mirror(false),
				PartPose.offset(2.0F, 12.0F, 0.0F));

		return LayerDefinition.create(meshdefinition, 128, 128);
	}

	@Override
	public void setupAnim(Entity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw,
			float headPitch) {

	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay,
			float red, float green, float blue, float alpha) {
		Head.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Body.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		LeftArm.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		RightArm.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		LeftLeg.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		RightLeg.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}