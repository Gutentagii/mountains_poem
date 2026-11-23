
package com.xiris.mountainspoem.jei_recipes;

import mezz.jei.api.constants.VanillaTypes;
import mezz.jei.api.gui.builder.IRecipeLayoutBuilder;
import mezz.jei.api.gui.drawable.IDrawable;
import mezz.jei.api.helpers.IGuiHelper;
import mezz.jei.api.recipe.IFocusGroup;
import mezz.jei.api.recipe.RecipeIngredientRole;
import mezz.jei.api.recipe.category.IRecipeCategory;
import com.xiris.mountainspoem.MountainsPoemMod;
import com.xiris.mountainspoem.init.MountainsPoemModItems;
import com.xiris.mountainspoem.init.MountainsPoemModJeiPlugin;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;

public class DippingSauceRecipeCategory implements IRecipeCategory<DippingSauceRecipe> {
	public final static ResourceLocation UID = ResourceLocation.fromNamespaceAndPath(MountainsPoemMod.MOD_ID, "dipping_sauce");
	public final static ResourceLocation TEXTURE = ResourceLocation.fromNamespaceAndPath(MountainsPoemMod.MOD_ID, "textures/screens/gui_background.png");
	private final IDrawable background;
	private final IDrawable icon;

	public DippingSauceRecipeCategory(IGuiHelper helper) {
		this.background = helper.createDrawable(TEXTURE, 0, 0, 72, 70);
		this.icon = helper.createDrawableIngredient(VanillaTypes.ITEM_STACK, new ItemStack(MountainsPoemModItems.LEI_MEAT_SAUCE.get()));
	}

	@Override
	public mezz.jei.api.recipe.RecipeType<DippingSauceRecipe> getRecipeType() {
		return MountainsPoemModJeiPlugin.DippingSauce_Type;
	}

	@Override
	public Component getTitle() {
		return Component.translatable("recipe.mountains_poem.dipping_sauce");
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
	public void setRecipe(IRecipeLayoutBuilder builder, DippingSauceRecipe recipe, IFocusGroup focuses) {
		builder.addSlot(RecipeIngredientRole.INPUT, 8, 13).addIngredients(recipe.getIngredients().get(0));
		builder.addSlot(RecipeIngredientRole.INPUT, 8, 42).addIngredients(recipe.getIngredients().get(1));
		builder.addSlot(RecipeIngredientRole.OUTPUT, 43, 30).addItemStack(recipe.getResultItem(null));
	}
}
