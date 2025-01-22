package net.mcreator.mountainspoem.procedures;

public class GingerGetRecipeProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if (entity instanceof ServerPlayer _serverPlayer)
			_serverPlayer.awardRecipesByKey(new ResourceLocation[]{new ResourceLocation("mountains_poem:item_ginger_slices")});
		if (ModList.get().isLoaded("farmersdelight")) {
			if (entity instanceof ServerPlayer _serverPlayer)
				_serverPlayer.awardRecipesByKey(new ResourceLocation[]{new ResourceLocation("farmersdelight:cutting/ginger_slices")});
		}
	}
}
