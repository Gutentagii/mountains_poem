
package net.mcreator.mountainspoem.init;

import net.mcreator.mountainspoem.jei_recipes.PapermakingBoardCraftingRecipeCategory;
import net.mcreator.mountainspoem.jei_recipes.PapermakingBoardCraftingRecipe;
import net.mcreator.mountainspoem.jei_recipes.DryingBoardCraftingRecipeCategory;
import net.mcreator.mountainspoem.jei_recipes.DryingBoardCraftingRecipe;
import net.mcreator.mountainspoem.jei_recipes.DippingSauceRecipeCategory;
import net.mcreator.mountainspoem.jei_recipes.DippingSauceRecipe;

import mezz.jei.library.recipes.RecipeManager;
import mezz.jei.api.registration.IRecipeRegistration;
import mezz.jei.api.registration.IRecipeCategoryRegistration;
import mezz.jei.api.registration.IRecipeCatalystRegistration;
import mezz.jei.api.JeiPlugin;
import mezz.jei.api.IModPlugin;
import net.minecraft.client.Minecraft;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;

import java.util.Objects;
import java.util.List;

@JeiPlugin
public class MountainsPoemModJeiPlugin implements IModPlugin {
	public static mezz.jei.api.recipe.RecipeType<DippingSauceRecipe> DippingSauce_Type = new mezz.jei.api.recipe.RecipeType<>(DippingSauceRecipeCategory.UID, DippingSauceRecipe.class);
	public static mezz.jei.api.recipe.RecipeType<PapermakingBoardCraftingRecipe> PapermakingBoardCrafting_Type = new mezz.jei.api.recipe.RecipeType<>(PapermakingBoardCraftingRecipeCategory.UID, PapermakingBoardCraftingRecipe.class);
	public static mezz.jei.api.recipe.RecipeType<DryingBoardCraftingRecipe> DryingBoardCrafting_Type = new mezz.jei.api.recipe.RecipeType<>(DryingBoardCraftingRecipeCategory.UID, DryingBoardCraftingRecipe.class);

	@Override
	public ResourceLocation getPluginUid() {
		return new ResourceLocation("mountains_poem:jei_plugin");
	}

	@Override
	public void registerCategories(IRecipeCategoryRegistration registration) {
		registration.addRecipeCategories(new DippingSauceRecipeCategory(registration.getJeiHelpers().getGuiHelper()));
		registration.addRecipeCategories(new PapermakingBoardCraftingRecipeCategory(registration.getJeiHelpers().getGuiHelper()));
		registration.addRecipeCategories(new DryingBoardCraftingRecipeCategory(registration.getJeiHelpers().getGuiHelper()));
	}

	@Override
	public void registerRecipes(IRecipeRegistration registration) {
		RecipeManager recipeManager = Objects.requireNonNull(Minecraft.getInstance().level).getRecipeManager();
		List<DippingSauceRecipe> DippingSauceRecipes = recipeManager.getAllRecipesFor(DippingSauceRecipe.Type.INSTANCE);
		registration.addRecipes(DippingSauce_Type, DippingSauceRecipes);
		List<PapermakingBoardCraftingRecipe> PapermakingBoardCraftingRecipes = recipeManager.getAllRecipesFor(PapermakingBoardCraftingRecipe.Type.INSTANCE);
		registration.addRecipes(PapermakingBoardCrafting_Type, PapermakingBoardCraftingRecipes);
		List<DryingBoardCraftingRecipe> DryingBoardCraftingRecipes = recipeManager.getAllRecipesFor(DryingBoardCraftingRecipe.Type.INSTANCE);
		registration.addRecipes(DryingBoardCrafting_Type, DryingBoardCraftingRecipes);
	}

	@Override
	public void registerRecipeCatalysts(IRecipeCatalystRegistration registration) {
		registration.addRecipeCatalyst(new ItemStack(MountainsPoemModBlocks.PAPERMAKING_BOARD.get().asItem()), PapermakingBoardCrafting_Type);
		registration.addRecipeCatalyst(new ItemStack(MountainsPoemModBlocks.DRYING_BOARD.get().asItem()), DryingBoardCrafting_Type);
	}
}
