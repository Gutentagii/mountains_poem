package net.mcreator.mountainspoem.procedures;

public class ZuoCowYouJiShiTiShiProcedure {
	public static void execute(Entity sourceentity) {
		if (sourceentity == null)
			return;
		if (sourceentity.isShiftKeyDown()) {
			sourceentity.stopRiding();
		}
	}
}
