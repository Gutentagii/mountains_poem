
package com.xiris.mountainspoem.init;

import com.xiris.mountainspoem.MountainsPoemMod;
import mezz.jei.api.IModPlugin;
import mezz.jei.api.JeiPlugin;
import mezz.jei.api.constants.RecipeTypes;
import mezz.jei.api.recipe.vanilla.IJeiBrewingRecipe;
import mezz.jei.api.recipe.vanilla.IVanillaRecipeFactory;
import mezz.jei.api.registration.IRecipeRegistration;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.alchemy.PotionUtils;
import net.minecraft.world.item.alchemy.Potions;

import java.util.ArrayList;
import java.util.List;

@JeiPlugin
public class MountainsPoemModBrewingRecipes implements IModPlugin {
	@Override
	public ResourceLocation getPluginUid() {
		return ResourceLocation.fromNamespaceAndPath(MountainsPoemMod.MOD_ID,"brewing_recipes");
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
        ingredientStack = new ArrayList<>(
                BuiltInRegistries.ITEM.getOrCreateTag(ItemTags.create(ResourceLocation.fromNamespaceAndPath(MountainsPoemMod.MOD_ID, "sanguine_plants_item")))
                        .stream()
                        .map(item -> new ItemStack(item.value()))
                        .toList()
        );
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
