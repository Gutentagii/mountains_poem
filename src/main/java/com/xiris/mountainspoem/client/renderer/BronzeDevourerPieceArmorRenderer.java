package com.xiris.mountainspoem.client.renderer;

import com.xiris.mountainspoem.item.BronzeDevourerPieceItem;
import com.xiris.mountainspoem.item.model.BronzeDevourerPieceModel;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EquipmentSlot;
import software.bernie.geckolib.cache.object.GeoBone;
import software.bernie.geckolib.renderer.GeoArmorRenderer;

public class BronzeDevourerPieceArmorRenderer extends GeoArmorRenderer<BronzeDevourerPieceItem> {
    public BronzeDevourerPieceArmorRenderer() {
        super(new BronzeDevourerPieceModel());
    }

    @Override
    protected void applyBoneVisibilityBySlot(EquipmentSlot slot) {
        setBoneVisible(this.head, false);
        setBoneVisible(this.body, false);
        setBoneVisible(this.rightArm, false);
        setBoneVisible(this.leftArm, false);
        setBoneVisible(this.rightLeg, false);
        setBoneVisible(this.leftLeg, false);
        setBoneVisible(this.rightBoot, false);
        setBoneVisible(this.leftBoot, false);

        switch (slot) {
            case HEAD -> setBoneVisible(this.head, true);
            case CHEST -> {
                setBoneVisible(this.body, true);
                setBoneVisible(this.rightArm, true);
                setBoneVisible(this.leftArm, true);
            }
            case LEGS -> {
                setBoneVisible(this.rightLeg, true);
                setBoneVisible(this.leftLeg, true);
            }
            case FEET -> {
                setBoneVisible(this.rightBoot, true);
                setBoneVisible(this.leftBoot, true);
            }
        }
    }

    @Override
    public RenderType getRenderType(BronzeDevourerPieceItem animatable, ResourceLocation texture, MultiBufferSource bufferSource, float partialTick) {
        return RenderType.entityTranslucent(this.getTextureLocation(animatable));
    }
}