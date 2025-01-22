package net.mcreator.mountainspoem.client.gui;

import com.mojang.blaze3d.systems.RenderSystem;
import net.mcreator.mountainspoem.world.inventory.CopperCuttersMenu;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;

import java.util.HashMap;

public class CopperCuttersScreen extends AbstractContainerScreen<CopperCuttersMenu> {
	private final static HashMap<String, Object> guistate = CopperCuttersMenu.guistate;
	private final Level world;
	private final int x, y, z;
	private final Player entity;

	public CopperCuttersScreen(CopperCuttersMenu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 176;
		this.imageHeight = 166;
	}

	private static final ResourceLocation texture = new ResourceLocation("mountains_poem:textures/screens/copper_cutters.png");

	@Override
	public void render(@NotNull GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
		this.renderBackground(guiGraphics);
		super.render(guiGraphics, mouseX, mouseY, partialTicks);
		this.renderTooltip(guiGraphics, mouseX, mouseY);
	}

	@Override
	protected void renderBg(GuiGraphics guiGraphics, float partialTicks, int gx, int gy) {
		RenderSystem.setShaderColor(1, 1, 1, 1);
		RenderSystem.enableBlend();
		RenderSystem.defaultBlendFunc();
		guiGraphics.blit(texture, this.leftPos, this.topPos, 0, 0, this.imageWidth, this.imageHeight, this.imageWidth, this.imageHeight);

		guiGraphics.blit(new ResourceLocation("mountains_poem:textures/screens/book.png"), this.leftPos + 60, this.topPos + 34, 0, 0, 17, 17, 17, 17);

		guiGraphics.blit(new ResourceLocation("mountains_poem:textures/screens/block_pattern.png"), this.leftPos + 24, this.topPos + 52, 0, 0, 16, 16, 16, 16);

		RenderSystem.disableBlend();
	}

	@Override
	public boolean keyPressed(int key, int b, int c) {
		if (key == 256) {
            if (this.minecraft != null) {
                if (this.minecraft.player != null) {
                    this.minecraft.player.closeContainer();
                }
            }
            return true;
		}
		return super.keyPressed(key, b, c);
	}

	@Override
	protected void renderLabels(GuiGraphics guiGraphics, int mouseX, int mouseY) {
	}

	@Override
	public void init() {
		super.init();
	}
}
