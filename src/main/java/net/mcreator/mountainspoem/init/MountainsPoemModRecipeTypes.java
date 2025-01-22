package net.mcreator.mountainspoem.init;

import net.mcreator.mountainspoem.jei_recipes.PapermakingBoardCraftingRecipe;
import net.mcreator.mountainspoem.jei_recipes.DryingBoardCraftingRecipe;
import net.mcreator.mountainspoem.jei_recipes.DippingSauceRecipe;
import net.mcreator.mountainspoem.MountainsPoemMod;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLConstructModEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

@Mod.EventBusSubscriber(modid = MountainsPoemMod.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class MountainsPoemModRecipeTypes {
	public static final DeferredRegister<RecipeSerializer<?>> SERIALIZERS = DeferredRegister.create(ForgeRegistries.RECIPE_SERIALIZERS, "mountains_poem");

	@SubscribeEvent
	public static void register(FMLConstructModEvent event) {
		IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
		event.enqueueWork(() -> {
			SERIALIZERS.register(bus);
			SERIALIZERS.register("dipping_sauce", () -> DippingSauceRecipe.Serializer.INSTANCE);
			SERIALIZERS.register("papermaking_board_crafting", () -> PapermakingBoardCraftingRecipe.Serializer.INSTANCE);
			SERIALIZERS.register("drying_board_crafting", () -> DryingBoardCraftingRecipe.Serializer.INSTANCE);
		});
	}
}
