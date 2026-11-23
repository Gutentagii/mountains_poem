
package com.xiris.mountainspoem.jei_recipes;

import mezz.jei.api.constants.VanillaTypes;
import mezz.jei.api.gui.builder.IRecipeLayoutBuilder;
import mezz.jei.api.gui.drawable.IDrawable;
import mezz.jei.api.helpers.IGuiHelper;
import mezz.jei.api.recipe.IFocusGroup;
import mezz.jei.api.recipe.RecipeIngredientRole;
import mezz.jei.api.recipe.category.IRecipeCategory;
import com.xiris.mountainspoem.MountainsPoemMod;
import com.xiris.mountainspoem.init.MountainsPoemModBlocks;
import com.xiris.mountainspoem.init.MountainsPoemModJeiPlugin;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;

public class DryingBoardCraftingRecipeCategory implements IRecipeCategory<DryingBoardCraftingRecipe> {
	public final static ResourceLocation UID = ResourceLocation.fromNamespaceAndPath(MountainsPoemMod.MOD_ID, "drying_board_crafting");
	public final static ResourceLocation TEXTURE = ResourceLocation.fromNamespaceAndPath(MountainsPoemMod.MOD_ID, "textures/screens/dry.png");
	private final IDrawable background;
	private final IDrawable icon;

	public DryingBoardCraftingRecipeCategory(IGuiHelper helper) {
		this.background = helper.createDrawable(TEXTURE, 0, 0, 113, 70);
		this.icon = helper.createDrawableIngredient(VanillaTypes.ITEM_STACK, new ItemStack(MountainsPoemModBlocks.DRYING_BOARD.get().asItem()));
	}

	@Override
	public mezz.jei.api.recipe.RecipeType<DryingBoardCraftingRecipe> getRecipeType() {
		return MountainsPoemModJeiPlugin.DryingBoardCrafting_Type;
	}

	@Override
	public Component getTitle() {
		return Component.translatable("recipe.mountains_poem.drying_board");
	}

	@Override
	public IDrawable getBackground() {
		return this.background;
	}

	@Override
	public IDrawable getIcon() {
		return this.icon;
	}

	@Override
	public void setRecipe(IRecipeLayoutBuilder builder, DryingBoardCraftingRecipe recipe, IFocusGroup focuses) {
		builder.addSlot(RecipeIngredientRole.INPUT, 34, 26).addIngredients(recipe.getIngredients().get(0));
		builder.addSlot(RecipeIngredientRole.OUTPUT, 89, 27).addItemStack(recipe.getResultItem(null));
	}
}
