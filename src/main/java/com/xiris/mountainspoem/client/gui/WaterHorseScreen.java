package com.xiris.mountainspoem.client.gui;

import com.xiris.mountainspoem.MountainsPoemMod;
import com.mojang.blaze3d.systems.RenderSystem;
import com.xiris.mountainspoem.entity.HuHorseEntity;
import com.xiris.mountainspoem.init.MountainsPoemModEntities;
import com.xiris.mountainspoem.world.inventory.WaterHorseMenu;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.gui.screens.inventory.InventoryScreen;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;

import java.util.HashMap;

public class WaterHorseScreen extends AbstractContainerScreen<WaterHorseMenu> {
	private final static HashMap<String, Object> guistate = WaterHorseMenu.guistate;
	private final Level world;
	private final int x, y, z;
	private final Player entity;

	public WaterHorseScreen(WaterHorseMenu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 176;
		this.imageHeight = 166;
	}

	private static final ResourceLocation texture = ResourceLocation.fromNamespaceAndPath(MountainsPoemMod.MOD_ID,"textures/screens/water_horse.png");

	@Override
	public void render(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
		this.renderBackground(guiGraphics);
		super.render(guiGraphics, mouseX, mouseY, partialTicks);
        if (((Entity) ((LevelAccessor) this.world instanceof Level _level ? new HuHorseEntity(MountainsPoemModEntities.WATER_HORSE.get(), _level) : null)) instanceof LivingEntity livingEntity) {
			InventoryScreen.renderEntityInInventoryFollowsAngle(guiGraphics, this.leftPos + 53, this.topPos + 63, 15, 0f + (float) Math.atan((this.leftPos + 53 - mouseX) / 40.0), (float) Math.atan((this.topPos + 14 - mouseY) / 40.0), livingEntity);
		}
		this.renderTooltip(guiGraphics, mouseX, mouseY);
	}

	@Override
	protected void renderBg(GuiGraphics guiGraphics, float partialTicks, int gx, int gy) {
		RenderSystem.setShaderColor(1, 1, 1, 1);
		RenderSystem.enableBlend();
		RenderSystem.defaultBlendFunc();
		guiGraphics.blit(texture, this.leftPos, this.topPos, 0, 0, this.imageWidth, this.imageHeight, this.imageWidth, this.imageHeight);

		guiGraphics.blit(ResourceLocation.fromNamespaceAndPath(MountainsPoemMod.MOD_ID,"textures/screens/empty_armor_horse.png"), this.leftPos + 7, this.topPos + 26, 0, 0, 16, 16, 16, 16);

		RenderSystem.disableBlend();
	}

	@Override
	public boolean keyPressed(int key, int b, int c) {
		if (key == 256) {
			this.minecraft.player.closeContainer();
			return true;
		}
		return super.keyPressed(key, b, c);
	}

	@Override
	public void containerTick() {
		super.containerTick();
	}

	@Override
	protected void renderLabels(GuiGraphics guiGraphics, int mouseX, int mouseY) {
		guiGraphics.drawString(this.font, Component.translatable("gui.mountains_poem.water_horse.label_inventory"), 6, 70, -12829636, false);
	}

	@Override
	public void onClose() {
		super.onClose();
	}

	@Override
	public void init() {
		super.init();
	}
}
