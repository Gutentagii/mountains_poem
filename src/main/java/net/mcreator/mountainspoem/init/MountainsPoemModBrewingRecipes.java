
package net.mcreator.mountainspoem.init;

import mezz.jei.api.registration.IRecipeRegistration;
import mezz.jei.api.recipe.vanilla.IVanillaRecipeFactory;
import mezz.jei.api.recipe.vanilla.IJeiBrewingRecipe;
import mezz.jei.api.constants.RecipeTypes;
import mezz.jei.api.JeiPlugin;
import mezz.jei.api.IModPlugin;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.alchemy.PotionUtils;
import net.minecraft.world.item.alchemy.Potions;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.Objects;
import java.util.stream.Collectors;
import java.util.List;
import java.util.ArrayList;

@JeiPlugin
public class MountainsPoemModBrewingRecipes implements IModPlugin {
	@Override
	public ResourceLocation getPluginUid() {
		return new ResourceLocation("mountains_poem:brewing_recipes");
	}

	@Override
	public void registerRecipes(IRecipeRegistration registration) {
		IVanillaRecipeFactory factory = registration.getVanillaRecipeFactory();
		List<IJeiBrewingRecipe> brewingRecipes = new ArrayList<>();
		ItemStack potion = new ItemStack(Items.POTION);
		ItemStack potion2 = new ItemStack(Items.POTION);
		List<ItemStack> ingredientStack = new ArrayList<>();
		List<ItemStack> inputStack = new ArrayList<>();
		ingredientStack.add(new ItemStack(MountainsPoemModItems.SHATANG_FRUIT.get()));
		PotionUtils.setPotion(potion, Potions.MUNDANE);
		PotionUtils.setPotion(potion2, Potions.WATER_BREATHING);
		brewingRecipes.add(factory.createBrewingRecipe(List.copyOf(ingredientStack), potion.copy(), potion2.copy()));
		ingredientStack.clear();
		ingredientStack.add(new ItemStack(MountainsPoemModItems.ZHENG_SALIVA.get()));
		PotionUtils.setPotion(potion, Potions.MUNDANE);
		PotionUtils.setPotion(potion2, MountainsPoemModPotions.STRANGE_ODOR.get());
		brewingRecipes.add(factory.createBrewingRecipe(List.copyOf(ingredientStack), potion.copy(), potion2.copy()));
		ingredientStack.clear();
		ingredientStack.add(new ItemStack(MountainsPoemModBlocks.ZHUYU_GRASS.get()));
		PotionUtils.setPotion(potion, Potions.WATER);
		brewingRecipes.add(factory.createBrewingRecipe(List.copyOf(ingredientStack), potion.copy(), new ItemStack(MountainsPoemModItems.ZHUYU_GRASS_JUICE.get())));
		ingredientStack.clear();
		ingredientStack.add(new ItemStack(MountainsPoemModBlocks.TING_ZHU.get()));
		PotionUtils.setPotion(potion, Potions.MUNDANE);
		PotionUtils.setPotion(potion2, Potions.POISON);
		brewingRecipes.add(factory.createBrewingRecipe(List.copyOf(ingredientStack), potion.copy(), potion2.copy()));
		ingredientStack.clear();
		ingredientStack.add(new ItemStack(Items.FERMENTED_SPIDER_EYE));
		inputStack.add(new ItemStack(MountainsPoemModItems.TING_ZHU_JUICE_BOTTLE.get()));
		PotionUtils.setPotion(potion, Potions.HARMING);
		brewingRecipes.add(factory.createBrewingRecipe(List.copyOf(ingredientStack), List.copyOf(inputStack), potion.copy()));
		ingredientStack.clear();
		inputStack.clear();
		ingredientStack = new ArrayList<ItemStack>(
				Objects.requireNonNull(ForgeRegistries.ITEMS.tags()).getTag(ItemTags.create(new ResourceLocation("mountains_poem:sanguine_plants_item"))).stream().map(item -> new ItemStack((Item) item)).collect(Collectors.toCollection(ArrayList::new)));
		PotionUtils.setPotion(potion, Potions.MUNDANE);
		PotionUtils.setPotion(potion2, Potions.STRONG_HARMING);
		brewingRecipes.add(factory.createBrewingRecipe(List.copyOf(ingredientStack), potion.copy(), potion2.copy()));
		ingredientStack.clear();
		ingredientStack.add(new ItemStack(MountainsPoemModItems.ZHENG_SALIVA.get()));
		PotionUtils.setPotion(potion, Potions.MUNDANE);
		PotionUtils.setPotion(potion2, MountainsPoemModPotions.STRANGE_ODOR.get());
		brewingRecipes.add(factory.createBrewingRecipe(List.copyOf(ingredientStack), potion.copy(), potion2.copy()));
		ingredientStack.clear();
		ingredientStack.add(new ItemStack(MountainsPoemModItems.WHITE_FOX_MEAT.get()));
		PotionUtils.setPotion(potion, Potions.MUNDANE);
		PotionUtils.setPotion(potion2, MountainsPoemModPotions.EVIL_QI_RESISTANCE.get());
		brewingRecipes.add(factory.createBrewingRecipe(List.copyOf(ingredientStack), potion.copy(), potion2.copy()));
		ingredientStack.clear();
		registration.addRecipes(RecipeTypes.BREWING, brewingRecipes);
	}
}
