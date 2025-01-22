package net.mcreator.mountainspoem.procedures;

public class BloodCopperYueGongJuChuXianZaiWuPinLanShiMeiKeFaShengProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if (entity instanceof ServerPlayer _serverPlayer)
			_serverPlayer.awardRecipesByKey(new ResourceLocation[]{new ResourceLocation("mountains_poem:copper_yue_2")});
	}
}
