
package net.mcreator.mountainspoem.jei_recipes;

import net.mcreator.mountainspoem.init.MountainsPoemModJeiPlugin;
import net.mcreator.mountainspoem.init.MountainsPoemModBlocks;

import mezz.jei.api.recipe.category.IRecipeCategory;
import mezz.jei.api.recipe.RecipeIngredientRole;
import mezz.jei.api.recipe.IFocusGroup;
import mezz.jei.api.helpers.IGuiHelper;
import mezz.jei.api.gui.drawable.IDrawable;
import mezz.jei.api.gui.builder.IRecipeLayoutBuilder;
import mezz.jei.api.constants.VanillaTypes;

public class DryingBoardCraftingRecipeCategory implements IRecipeCategory<DryingBoardCraftingRecipe> {
	public final static ResourceLocation UID = new ResourceLocation("mountains_poem", "drying_board_crafting");
	public final static ResourceLocation TEXTURE = new ResourceLocation("mountains_poem", "textures/screens/dry.png");
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
