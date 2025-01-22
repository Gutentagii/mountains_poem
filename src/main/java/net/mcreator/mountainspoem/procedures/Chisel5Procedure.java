package net.mcreator.mountainspoem.procedures;

public class Chisel5Procedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if (entity instanceof ServerPlayer _serverPlayer)
			_serverPlayer.awardRecipesByKey(new ResourceLocation[]{new ResourceLocation("mountains_poem:stone_shaping_chisel_5")});
	}
}
