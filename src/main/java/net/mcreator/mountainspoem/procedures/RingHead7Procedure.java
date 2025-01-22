package net.mcreator.mountainspoem.procedures;

public class RingHead7Procedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if (entity instanceof ServerPlayer _serverPlayer)
			_serverPlayer.awardRecipesByKey(new ResourceLocation[]{new ResourceLocation("mountains_poem:ring_head_knife_7")});
	}
}
