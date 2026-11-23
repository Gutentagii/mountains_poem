package com.xiris.mountainspoem.client.model;

// Made with Blockbench 5.0.5
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports


import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.xiris.mountainspoem.MountainsPoemMod;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;

public class ModelUnder_iron<T extends Entity> extends EntityModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(ResourceLocation.fromNamespaceAndPath(MountainsPoemMod.MOD_ID, "under_iron"), "main");
    public final ModelPart bipedHead;
    public final ModelPart bipedBody;
    public final ModelPart bipedRightArm;
    public final ModelPart bipedLeftArm;
    public final ModelPart LeftBoots;
    public final ModelPart bipedLeftLeg;
    public final ModelPart RightBoots;
    public final ModelPart bipedRightLeg;

	public ModelUnder_iron(ModelPart root) {
		this.bipedHead = root.getChild("bipedHead");
		this.bipedBody = root.getChild("bipedBody");
		this.bipedRightArm = root.getChild("bipedRightArm");
		this.bipedLeftArm = root.getChild("bipedLeftArm");
		this.LeftBoots = root.getChild("LeftBoots");
		this.bipedLeftLeg = root.getChild("bipedLeftLeg");
		this.RightBoots = root.getChild("RightBoots");
		this.bipedRightLeg = root.getChild("bipedRightLeg");
	}

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();

        PartDefinition bipedHead = partdefinition.addOrReplaceChild("bipedHead", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

        PartDefinition head = bipedHead.addOrReplaceChild("head", CubeListBuilder.create().texOffs(0, 32).addBox(-4.5F, -6.1F, -4.4F, 9.0F, 4.0F, 9.0F, new CubeDeformation(0.2F))
                .texOffs(0, 70).addBox(-4.0F, -9.3F, -4.0F, 8.0F, 10.0F, 8.0F, new CubeDeformation(0.0F))
                .texOffs(18, 13).addBox(-1.0F, -12.0F, -1.0F, 2.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -1.0F, 0.0F));

        PartDefinition cube_r1 = head.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(0, 22).addBox(-1.5F, -1.5F, -1.5F, 3.0F, 4.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -10.5F, 1.5F, 0.6981F, 0.0F, 0.0F));

        PartDefinition bipedBody = partdefinition.addOrReplaceChild("bipedBody", CubeListBuilder.create().texOffs(34, 0).addBox(-3.9F, 0.0F, -2.6F, 8.0F, 12.0F, 4.0F, new CubeDeformation(0.55F)), PartPose.offset(-0.3F, 0.0F, 0.6F));

        PartDefinition bipedRightArm = partdefinition.addOrReplaceChild("bipedRightArm", CubeListBuilder.create().texOffs(16, 0).addBox(-3.5F, -0.2F, -3.0F, 3.0F, 4.0F, 6.0F, new CubeDeformation(0.4F))
                .texOffs(34, 16).addBox(-3.0F, -2.0F, -2.0F, 4.0F, 13.0F, 4.0F, new CubeDeformation(0.3F)), PartPose.offset(-5.0F, 2.0F, 1.0F));

        PartDefinition rightArm_r1 = bipedRightArm.addOrReplaceChild("rightArm_r1", CubeListBuilder.create().texOffs(46, 49).addBox(-5.0F, 0.0F, -2.0F, 5.0F, 3.0F, 6.0F, new CubeDeformation(0.45F)), PartPose.offsetAndRotation(-0.4F, -3.2F, -1.0F, 0.0F, 0.0F, -0.3927F));

        PartDefinition bipedLeftArm = partdefinition.addOrReplaceChild("bipedLeftArm", CubeListBuilder.create().texOffs(16, 0).mirror().addBox(0.5F, -0.2F, -3.0F, 3.0F, 4.0F, 6.0F, new CubeDeformation(0.4F)).mirror(false)
                .texOffs(34, 16).mirror().addBox(-1.0F, -2.0F, -2.0F, 4.0F, 13.0F, 4.0F, new CubeDeformation(0.3F)).mirror(false), PartPose.offset(4.0F, 2.0F, 1.0F));

        PartDefinition leftArm_r1 = bipedLeftArm.addOrReplaceChild("leftArm_r1", CubeListBuilder.create().texOffs(46, 49).mirror().addBox(0.0F, 0.0F, -2.0F, 5.0F, 3.0F, 6.0F, new CubeDeformation(0.45F)).mirror(false), PartPose.offsetAndRotation(0.4F, -3.2F, -1.0F, 0.0F, 0.0F, 0.3927F));

        PartDefinition bipedRightLeg = partdefinition.addOrReplaceChild("bipedRightLeg", CubeListBuilder.create().texOffs(0, 0).mirror().addBox(-2.1F, -0.5F, -2.0F, 4.0F, 9.0F, 4.0F, new CubeDeformation(0.4F)).mirror(false), PartPose.offset(-1.9F, 12.0F, 0.0F));

        PartDefinition rightLeg_r1 = bipedRightLeg.addOrReplaceChild("rightLeg_r1", CubeListBuilder.create().texOffs(0, 52).addBox(-2.5F, -4.0F, -2.0F, 4.0F, 7.0F, 4.0F, new CubeDeformation(0.51F)), PartPose.offsetAndRotation(-0.6F, 3.0F, 0.0F, 0.0F, 0.0F, 0.1745F));

        PartDefinition bipedLeftLeg = partdefinition.addOrReplaceChild("bipedLeftLeg", CubeListBuilder.create().texOffs(0, 0).addBox(-1.9F, -0.5F, -2.0F, 4.0F, 9.0F, 4.0F, new CubeDeformation(0.4F)), PartPose.offset(1.9F, 12.0F, 0.0F));

        PartDefinition leftLeg_r1 = bipedLeftLeg.addOrReplaceChild("leftLeg_r1", CubeListBuilder.create().texOffs(0, 52).mirror().addBox(-1.5F, -4.0F, -2.0F, 4.0F, 7.0F, 4.0F, new CubeDeformation(0.5F)).mirror(false), PartPose.offsetAndRotation(0.6F, 3.0F, 0.0F, 0.0F, 0.0F, -0.1745F));

        PartDefinition RightBoots = partdefinition.addOrReplaceChild("RightBoots", CubeListBuilder.create().texOffs(31, 67).addBox(-2.1F, 8.5F, -2.0F, 4.0F, 5.0F, 4.0F, new CubeDeformation(0.45F)), PartPose.offset(-2.1F, 10.5F, 0.0F));

        PartDefinition LeftBoots = partdefinition.addOrReplaceChild("LeftBoots", CubeListBuilder.create().texOffs(31, 67).mirror().addBox(-1.7F, 8.5F, -2.0F, 4.0F, 5.0F, 4.0F, new CubeDeformation(0.45F)).mirror(false), PartPose.offset(1.9F, 10.5F, 0.0F));

        return LayerDefinition.create(meshdefinition, 128, 128);
    }

    @Override
    public void setupAnim(Entity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {

    }

    @Override
    public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
        bipedHead.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
        bipedBody.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
        bipedRightArm.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
        bipedLeftArm.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
        bipedRightLeg.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
        bipedLeftLeg.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
        RightBoots.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
        LeftBoots.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
    }
}