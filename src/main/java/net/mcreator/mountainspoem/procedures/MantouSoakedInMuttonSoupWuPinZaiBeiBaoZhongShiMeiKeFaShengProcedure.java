package net.mcreator.mountainspoem.procedures;

public class MantouSoakedInMuttonSoupWuPinZaiBeiBaoZhongShiMeiKeFaShengProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if (entity instanceof ServerPlayer _serverPlayer)
			_serverPlayer.awardRecipesByKey(new ResourceLocation[]{new ResourceLocation("mountains_poem:mantou_soaked_in_mutton_soup_item")});
		if (ModList.get().isLoaded("farmersdelight")) {
			if (entity instanceof ServerPlayer _serverPlayer)
				_serverPlayer.awardRecipesByKey(new ResourceLocation[]{new ResourceLocation("farmersdelight:cooking/mantou_soaked_in_mutton_soup")});
		}
	}
}
