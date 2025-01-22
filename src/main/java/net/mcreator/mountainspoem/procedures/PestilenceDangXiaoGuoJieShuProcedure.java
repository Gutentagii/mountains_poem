package net.mcreator.mountainspoem.procedures;

public class PestilenceDangXiaoGuoJieShuProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		entity.setMaxUpStep((float) (entity.getStepHeight() + 0.5));
	}
}
