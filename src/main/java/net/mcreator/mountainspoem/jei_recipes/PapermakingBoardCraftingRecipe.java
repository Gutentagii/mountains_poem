package net.mcreator.mountainspoem.jei_recipes;

import mezz.jei.api.recipe.RecipeType;

import javax.annotation.Nullable;

import java.lang.reflect.Type;

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
		if (pLevel.isClientSide()) {
			return false;
		}
		return false;
		//return recipeItems.get(0).test(pContainer.getItem(1));
	}

	@Override
	public NonNullList<Ingredient> getIngredients() {
		return recipeItems;
	}

	@Override
	public ItemStack assemble(SimpleContainer pContainer, RegistryAccess access) {
		return output;
	}

	@Override
	public boolean canCraftInDimensions(int pWidth, int pHeight) {
		return true;
	}

	@Override
	public ItemStack getResultItem(RegistryAccess access) {
		return output.copy();
	}

	@Override
	public ResourceLocation getId() {
		return id;
	}

	@Override
	public RecipeType<?> getType() {
		return Type.INSTANCE;
	}

	@Override
	public RecipeSerializer<?> getSerializer() {
		return Serializer.INSTANCE;
	}

	public static class Type implements RecipeType<PapermakingBoardCraftingRecipe> {
		private Type() {
		}

		public static final Type INSTANCE = new Type();
		public static final String ID = "papermaking_board_crafting";
	}

	public static class Serializer implements RecipeSerializer<PapermakingBoardCraftingRecipe> {
		public static final Serializer INSTANCE = new Serializer();
		public static final ResourceLocation ID = new ResourceLocation("mountains_poem", "papermaking_board_crafting");

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
			for (int i = 0; i < inputs.size(); i++) {
				inputs.set(i, Ingredient.fromNetwork(buf));
			}
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
