package net.mcreator.mountainspoem.client.renderer;

import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.renderer.GeoArmorRenderer;
import software.bernie.geckolib.cache.object.GeoBone;

import net.mcreator.mountainspoem.item.model.JunBlackNineTailedFoxHanfuModel;
import net.mcreator.mountainspoem.item.JunBlackNineTailedFoxHanfuItem;

import static net.minecraft.client.renderer.entity.ShulkerRenderer.getTextureLocation;

public class JunBlackNineTailedFoxHanfuArmorRenderer extends GeoArmorRenderer<JunBlackNineTailedFoxHanfuItem> {
	public JunBlackNineTailedFoxHanfuArmorRenderer() {
		super(new JunBlackNineTailedFoxHanfuModel());
		this.head = new GeoBone(null, "armorHead", false, (double) 0, false, false);
		this.body = new GeoBone(null, "armorBody", false, (double) 0, false, false);
		this.rightArm = new GeoBone(null, "armorRightArm", false, (double) 0, false, false);
		this.leftArm = new GeoBone(null, "armorLeftArm", false, (double) 0, false, false);
		this.rightLeg = new GeoBone(null, "armorRightLeg", false, (double) 0, false, false);
		this.leftLeg = new GeoBone(null, "armorLeftLeg", false, (double) 0, false, false);
		this.rightBoot = new GeoBone(null, "armorRightBoot", false, (double) 0, false, false);
		this.leftBoot = new GeoBone(null, "armorLeftBoot", false, (double) 0, false, false);
	}

	@Override
	public RenderType getRenderType(JunBlackNineTailedFoxHanfuItem animatable, ResourceLocation texture, MultiBufferSource bufferSource, float partialTick) {
		return RenderType.entityTranslucent(getTextureLocation(animatable));
	}
}
