
package com.xiris.mountainspoem.init;

import com.xiris.mountainspoem.MountainsPoemMod;
import com.xiris.mountainspoem.jei_recipes.*;
import mezz.jei.api.IModPlugin;
import mezz.jei.api.JeiPlugin;
import mezz.jei.api.recipe.RecipeType;
import mezz.jei.api.registration.IRecipeCatalystRegistration;
import mezz.jei.api.registration.IRecipeCategoryRegistration;
import mezz.jei.api.registration.IRecipeRegistration;
import com.xiris.mountainspoem.jei_recipes.*;
import net.minecraft.client.Minecraft;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.RecipeManager;

import java.util.List;
import java.util.Objects;

@JeiPlugin
public class MountainsPoemModJeiPlugin implements IModPlugin {
    public static final RecipeType<DippingSauceRecipe> DippingSauce_Type = new mezz.jei.api.recipe.RecipeType<>(DippingSauceRecipeCategory.UID, DippingSauceRecipe.class);
    public static final RecipeType<PapermakingBoardCraftingRecipe> PapermakingBoardCrafting_Type = new mezz.jei.api.recipe.RecipeType<>(PapermakingBoardCraftingRecipeCategory.UID, PapermakingBoardCraftingRecipe.class);
    public static final RecipeType<DryingBoardCraftingRecipe> DryingBoardCrafting_Type = new mezz.jei.api.recipe.RecipeType<>(DryingBoardCraftingRecipeCategory.UID, DryingBoardCraftingRecipe.class);

    @Override
    public ResourceLocation getPluginUid() {
        return ResourceLocation.fromNamespaceAndPath(MountainsPoemMod.MOD_ID,"jei_plugin");
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
        List<PapermakingBoardCraftingRecipe> PapermakingBoardCraftingRecipes = recipeManager.getAllRecipesFor(PapermakingBoardCraftingRecipe.TYPE);
        registration.addRecipes(PapermakingBoardCrafting_Type, PapermakingBoardCraftingRecipes);
        List<DryingBoardCraftingRecipe> DryingBoardCraftingRecipes = recipeManager.getAllRecipesFor(DryingBoardCraftingRecipe.TYPE);
        registration.addRecipes(DryingBoardCrafting_Type, DryingBoardCraftingRecipes);
    }

    @Override
    public void registerRecipeCatalysts(IRecipeCatalystRegistration registration) {
        registration.addRecipeCatalyst(new ItemStack(MountainsPoemModBlocks.PAPERMAKING_BOARD.get().asItem()), PapermakingBoardCrafting_Type);
        registration.addRecipeCatalyst(new ItemStack(MountainsPoemModBlocks.DRYING_BOARD.get().asItem()), DryingBoardCrafting_Type);
    }
}
