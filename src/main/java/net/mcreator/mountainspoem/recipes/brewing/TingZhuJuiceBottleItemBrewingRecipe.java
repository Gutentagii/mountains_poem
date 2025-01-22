
package net.mcreator.mountainspoem.recipes.brewing;

import net.mcreator.mountainspoem.init.MountainsPoemModItems;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.alchemy.PotionUtils;
import net.minecraft.world.item.alchemy.Potions;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.common.brewing.BrewingRecipeRegistry;
import net.minecraftforge.common.brewing.IBrewingRecipe;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import org.jetbrains.annotations.NotNull;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class TingZhuJuiceBottleItemBrewingRecipe implements IBrewingRecipe {
	@SubscribeEvent
	public static void init(FMLCommonSetupEvent event) {
		event.enqueueWork(() -> BrewingRecipeRegistry.addRecipe(new TingZhuJuiceBottleItemBrewingRecipe()));
	}

	@Override
	public boolean isInput(@NotNull ItemStack input) {
		return Ingredient.of(new ItemStack(MountainsPoemModItems.TING_ZHU_JUICE_BOTTLE.get())).test(input);
	}

	@Override
	public boolean isIngredient(@NotNull ItemStack ingredient) {
		return Ingredient.of(new ItemStack(Items.FERMENTED_SPIDER_EYE)).test(ingredient);
	}

	@Override
	public @NotNull ItemStack getOutput(@NotNull ItemStack input, @NotNull ItemStack ingredient) {
		if (isInput(input) && isIngredient(ingredient)) {
			return PotionUtils.setPotion(new ItemStack(Items.POTION), Potions.HARMING);
		}
		return ItemStack.EMPTY;
	}
}
