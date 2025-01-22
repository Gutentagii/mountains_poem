
package net.mcreator.mountainspoem.init;

import mezz.jei.api.registration.IRecipeRegistration;
import mezz.jei.api.constants.VanillaTypes;
import mezz.jei.api.JeiPlugin;
import mezz.jei.api.IModPlugin;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;

import java.util.List;

@JeiPlugin
public class MountainsPoemModJeiInformation implements IModPlugin {
	@Override
	public ResourceLocation getPluginUid() {
		return new ResourceLocation("mountains_poem:information");
	}

	@Override
	public void registerRecipes(IRecipeRegistration registration) {
		registration.addIngredientInfo(List.of(new ItemStack(MountainsPoemModBlocks.SACRIFICIAL_TABLE.get())), VanillaTypes.ITEM_STACK, Component.translatable("jei.mountains_poem.block_1"));
		registration.addIngredientInfo(List.of(new ItemStack(MountainsPoemModBlocks.WHITE_JIAN_GRASS_MAT_COVERED_SACRIFICIAL_TABLE.get())), VanillaTypes.ITEM_STACK, Component.translatable("jei.mountains_poem.block_2"));
		registration.addIngredientInfo(List.of(new ItemStack(MountainsPoemModItems.THE_SOUTHERN_MOUNTAIN_JADE_PENDANT.get())), VanillaTypes.ITEM_STACK, Component.translatable("jei.mountains_poem.jade_pendant_1"));
		registration.addIngredientInfo(List.of(new ItemStack(MountainsPoemModItems.THE_SECOND_SOUTHERN_MOUNTAIN_JADE_PENDANT.get())), VanillaTypes.ITEM_STACK, Component.translatable("jei.mountains_poem.jade_pendant_2"));
		registration.addIngredientInfo(List.of(new ItemStack(MountainsPoemModItems.COLD_CRIMSON_FUNGUS_SALAD.get())), VanillaTypes.ITEM_STACK, Component.translatable("jei.mountains_poem.item_1"));
		registration.addIngredientInfo(List.of(new ItemStack(MountainsPoemModBlocks.GUI_BASKET.get()), new ItemStack(MountainsPoemModBlocks.COPPER_GUI.get())), VanillaTypes.ITEM_STACK, Component.translatable("jei.mountains_poem.block_3"));
		registration.addIngredientInfo(List.of(new ItemStack(MountainsPoemModItems.BOYI_LEATHER.get())), VanillaTypes.ITEM_STACK, Component.translatable("jei.mountains_poem.item_2"));
		registration.addIngredientInfo(List.of(new ItemStack(MountainsPoemModItems.THE_NINTH_CENTRAL_MOUNTAIN_JADE_PENDANT.get())), VanillaTypes.ITEM_STACK, Component.translatable("jei.mountains_poem.jade_pendant_3"));
		registration.addIngredientInfo(List.of(new ItemStack(MountainsPoemModItems.SOAKED_PLANTS_BUCKET.get())), VanillaTypes.ITEM_STACK, Component.translatable("jei.mountains_poem.item_3"));
		registration.addIngredientInfo(List.of(new ItemStack(MountainsPoemModItems.LEI_MEAT_SAUCE.get()), new ItemStack(MountainsPoemModItems.BOYI_MEAT_SAUCE.get()), new ItemStack(MountainsPoemModItems.CHANGFU_CHICKEN_SAUCE.get())),
				VanillaTypes.ITEM_STACK, Component.translatable("jei.mountains_poem.item_4"));
		registration.addIngredientInfo(List.of(new ItemStack(MountainsPoemModBlocks.HOLLOW_MUD_BRICKS.get())), VanillaTypes.ITEM_STACK, Component.translatable("jei.mountains_poem.item_5"));
		registration.addIngredientInfo(List.of(new ItemStack(MountainsPoemModBlocks.UNDER_FLOWER.get())), VanillaTypes.ITEM_STACK, Component.translatable("jei.mountains_poem.item_6"));
		registration.addIngredientInfo(List.of(new ItemStack(MountainsPoemModItems.PAPER_PULP_BUCKET.get())), VanillaTypes.ITEM_STACK, Component.translatable("jei.mountains_poem.item_7"));
		registration.addIngredientInfo(List.of(new ItemStack(MountainsPoemModItems.WOODEN_MESH.get()), new ItemStack(MountainsPoemModItems.BAMBOO_MESH.get()), new ItemStack(MountainsPoemModItems.BAMBOO_MESH_WITH_PAPER_PULP.get()),
				new ItemStack(MountainsPoemModItems.WOODEN_MESH_WITH_PAPER_PULP.get())), VanillaTypes.ITEM_STACK, Component.translatable("jei.mountains_poem.item_8"));
		registration.addIngredientInfo(List.of(new ItemStack(MountainsPoemModBlocks.RED_LANTERN.get()), new ItemStack(MountainsPoemModBlocks.WHITE_LANTERN.get()), new ItemStack(MountainsPoemModBlocks.BLUE_LANTERN.get()),
				new ItemStack(MountainsPoemModBlocks.CYAN_LANTERN.get()), new ItemStack(MountainsPoemModBlocks.LIGHT_BLUE_LANTERN.get()), new ItemStack(MountainsPoemModBlocks.ORANGE_LANTERN.get()),
				new ItemStack(MountainsPoemModBlocks.YELLOW_LANTERN.get()), new ItemStack(MountainsPoemModBlocks.GREEN_LANTERN.get()), new ItemStack(MountainsPoemModBlocks.LIME_LANTERN.get()),
				new ItemStack(MountainsPoemModBlocks.PURPLE_LANTERN.get()), new ItemStack(MountainsPoemModBlocks.GRAY_LANTERN.get()), new ItemStack(MountainsPoemModBlocks.LIGHT_GRAY_LANTERN.get()),
				new ItemStack(MountainsPoemModBlocks.MAGENTA_LANTERN.get())), VanillaTypes.ITEM_STACK, Component.translatable("jei.mountains_poem.block_4"));
	}
}
