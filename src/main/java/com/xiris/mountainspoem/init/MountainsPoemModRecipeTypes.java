package com.xiris.mountainspoem.init;

//import dev.architectury.registry.registries.DeferredRegister;
import com.xiris.mountainspoem.MountainsPoemMod;
import com.xiris.mountainspoem.jei_recipes.DippingSauceRecipe;
import com.xiris.mountainspoem.jei_recipes.DryingBoardCraftingRecipe;
import com.xiris.mountainspoem.jei_recipes.PapermakingBoardCraftingRecipe;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraftforge.registries.DeferredRegister;

public class MountainsPoemModRecipeTypes {
    public static final DeferredRegister<RecipeSerializer<?>> SERIALIZERS =
            DeferredRegister.create(Registries.RECIPE_SERIALIZER, MountainsPoemMod.MOD_ID);

    static {
        SERIALIZERS.register("dipping_sauce", () -> DippingSauceRecipe.Serializer.INSTANCE);
        SERIALIZERS.register("papermaking_board_crafting", () -> PapermakingBoardCraftingRecipe.Serializer.INSTANCE);
        SERIALIZERS.register("drying_board_crafting", () -> DryingBoardCraftingRecipe.Serializer.INSTANCE);
    }
}
