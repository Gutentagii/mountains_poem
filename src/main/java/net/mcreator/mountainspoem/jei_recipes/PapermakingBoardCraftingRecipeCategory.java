
package net.mcreator.mountainspoem.jei_recipes;

import net.mcreator.mountainspoem.init.MountainsPoemModJeiPlugin;
import net.mcreator.mountainspoem.init.MountainsPoemModItems;

import mezz.jei.api.recipe.category.IRecipeCategory;
import mezz.jei.api.recipe.RecipeIngredientRole;
import mezz.jei.api.recipe.IFocusGroup;
import mezz.jei.api.helpers.IGuiHelper;
import mezz.jei.api.gui.drawable.IDrawable;
import mezz.jei.api.gui.builder.IRecipeLayoutBuilder;
import mezz.jei.api.constants.VanillaTypes;

public class PapermakingBoardCraftingRecipeCategory implements IRecipeCategory<PapermakingBoardCraftingRecipe> {
	public final static ResourceLocation UID = new ResourceLocation("mountains_poem", "papermaking_board_crafting");
	public final static ResourceLocation TEXTURE = new ResourceLocation("mountains_poem", "textures/screens/paper_making.png");
	private final IDrawable background;
	private final IDrawable icon;

	public PapermakingBoardCraftingRecipeCategory(IGuiHelper helper) {
		this.background = helper.createDrawable(TEXTURE, 0, 0, 127, 99);
		this.icon = helper.createDrawableIngredient(VanillaTypes.ITEM_STACK, new ItemStack(MountainsPoemModItems.WOODEN_MESH_WITH_PAPER_PULP.get()));
	}

	@Override
	public mezz.jei.api.recipe.RecipeType<PapermakingBoardCraftingRecipe> getRecipeType() {
		return MountainsPoemModJeiPlugin.PapermakingBoardCrafting_Type;
	}

	@Override
	public Component getTitle() {
		return Component.translatable("recipe.mountains_poem.papermaking_board");
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
	public void setRecipe(IRecipeLayoutBuilder builder, PapermakingBoardCraftingRecipe recipe, IFocusGroup focuses) {
		builder.addSlot(RecipeIngredientRole.INPUT, 39, 24).addIngredients(recipe.getIngredients().get(0));
		builder.addSlot(RecipeIngredientRole.OUTPUT, 103, 27).addItemStack(recipe.getResultItem(null));
	}
}
