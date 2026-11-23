package com.xiris.mountainspoem.client.model;

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

public class ModelWhite_fox_coat<T extends Entity> extends EntityModel<T> {
    // This layer location should be baked with EntityRendererProvider.Context in the entity renderer and passed into this model's constructor
    public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(ResourceLocation.fromNamespaceAndPath(MountainsPoemMod.MOD_ID, "white_fox_coat"), "main");
    public final ModelPart bipedBody;
    public final ModelPart bipedRightArm;
    public final ModelPart bipedLeftArm;

    public ModelWhite_fox_coat(ModelPart root) {
        this.bipedBody = root.getChild("bipedBody");
        this.bipedRightArm = root.getChild("bipedRightArm");
        this.bipedLeftArm = root.getChild("bipedLeftArm");
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();

        PartDefinition bipedBody = partdefinition.addOrReplaceChild("bipedBody", CubeListBuilder.create().texOffs(0, 26).addBox(-3.7F, -1.0F, -1.1F, 8.0F, 6.0F, 5.0F, new CubeDeformation(0.75F))
                .texOffs(0, 0).addBox(-3.7F, 0.0F, -0.6F, 8.0F, 14.0F, 4.0F, new CubeDeformation(0.7F))
                .texOffs(0, 0).addBox(-3.7F, 0.0F, -0.6F, 8.0F, 14.0F, 4.0F, new CubeDeformation(0.7F)), PartPose.offset(-0.3F, 0.0F, -1.4F));

        PartDefinition bipedRightArm = partdefinition.addOrReplaceChild("bipedRightArm", CubeListBuilder.create().texOffs(24, 0).addBox(-5.3F, -3.2F, -3.4F, 6.0F, 5.0F, 5.0F, new CubeDeformation(0.45F)), PartPose.offset(-5.0F, 2.0F, 1.0F));

        PartDefinition bipedLeftArm = partdefinition.addOrReplaceChild("bipedLeftArm", CubeListBuilder.create().texOffs(24, 0).mirror().addBox(0.3F, -3.2F, -3.4F, 6.0F, 5.0F, 5.0F, new CubeDeformation(0.45F)).mirror(false), PartPose.offset(4.0F, 2.0F, 1.0F));

        return LayerDefinition.create(meshdefinition, 64, 64);
    }

    @Override
    public void setupAnim(Entity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {

    }

    @Override
    public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
        bipedBody.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
        bipedRightArm.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
        bipedLeftArm.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
    }
}