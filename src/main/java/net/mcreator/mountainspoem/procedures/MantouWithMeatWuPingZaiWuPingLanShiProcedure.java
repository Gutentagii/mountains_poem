package net.mcreator.mountainspoem.procedures;

public class MantouWithMeatWuPingZaiWuPingLanShiProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if (entity instanceof ServerPlayer _serverPlayer)
			_serverPlayer.awardRecipesByKey(new ResourceLocation[]{new ResourceLocation("mountains_poem:mantou_with_meat")});
	}
}
