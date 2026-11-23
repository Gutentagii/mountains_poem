package com.xiris.mountainspoem.jei_recipes;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.xiris.mountainspoem.MountainsPoemMod;
import net.minecraft.core.NonNullList;
import net.minecraft.core.RegistryAccess;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.GsonHelper;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.ShapedRecipe;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;
import net.minecraft.world.item.crafting.RecipeType;

public class PapermakingBoardCraftingRecipe implements Recipe<SimpleContainer> {
	private final ResourceLocation id;
	private final ItemStack output;
	private final NonNullList<Ingredient> recipeItems;

	public PapermakingBoardCraftingRecipe(ResourceLocation id, ItemStack output, NonNullList<Ingredient> recipeItems) {
		this.id = id;
		this.output = output;
		this.recipeItems = recipeItems;
	}

	@Override
	public boolean matches(SimpleContainer pContainer, Level pLevel) {
        pLevel.isClientSide();
        return false;
		//return recipeItems.get(0).test(pContainer.getItem(1));
	}

	@Override
	public NonNullList<Ingredient> getIngredients() {
		return this.recipeItems;
	}

	@Override
	public ItemStack assemble(SimpleContainer pContainer, RegistryAccess access) {
		return this.output;
	}

	@Override
	public boolean canCraftInDimensions(int pWidth, int pHeight) {
		return true;
	}

	@Override
	public ItemStack getResultItem(RegistryAccess access) {
		return this.output.copy();
	}

	@Override
	public ResourceLocation getId() {
		return this.id;
	}

    @Override
    public RecipeType<?> getType() {
        return TYPE;
    }

	@Override
	public RecipeSerializer<?> getSerializer() {
		return Serializer.INSTANCE;
	}


    public static final RecipeType<PapermakingBoardCraftingRecipe> TYPE = RecipeType.register(
            MountainsPoemMod.MOD_ID + ":papermaking_board_crafting"
    );

	public static class Serializer implements RecipeSerializer<PapermakingBoardCraftingRecipe> {
		public static final Serializer INSTANCE = new Serializer();
		public static final ResourceLocation ID = ResourceLocation.fromNamespaceAndPath(MountainsPoemMod.MOD_ID, "papermaking_board_crafting");

		@Override
		public PapermakingBoardCraftingRecipe fromJson(ResourceLocation pRecipeId, JsonObject pSerializedRecipe) {
			ItemStack output = ShapedRecipe.itemStackFromJson(GsonHelper.getAsJsonObject(pSerializedRecipe, "output"));
			JsonArray ingredients = GsonHelper.getAsJsonArray(pSerializedRecipe, "ingredients");
			NonNullList<Ingredient> inputs = NonNullList.withSize(1, Ingredient.EMPTY);
			for (int i = 0; i < inputs.size(); i++) {
				inputs.set(i, Ingredient.fromJson(ingredients.get(i)));
			}
			return new PapermakingBoardCraftingRecipe(pRecipeId, output, inputs);
		}

		@Override
		public @Nullable PapermakingBoardCraftingRecipe fromNetwork(ResourceLocation id, FriendlyByteBuf buf) {
			NonNullList<Ingredient> inputs = NonNullList.withSize(buf.readInt(), Ingredient.EMPTY);
            inputs.replaceAll(ignored -> Ingredient.fromNetwork(buf));
			ItemStack output = buf.readItem();
			return new PapermakingBoardCraftingRecipe(id, output, inputs);
		}

		@Override
		public void toNetwork(FriendlyByteBuf buf, PapermakingBoardCraftingRecipe recipe) {
			buf.writeInt(recipe.getIngredients().size());
			for (Ingredient ing : recipe.getIngredients()) {
				ing.toNetwork(buf);
			}
			buf.writeItemStack(recipe.getResultItem(null), false);
		}
	}
}
