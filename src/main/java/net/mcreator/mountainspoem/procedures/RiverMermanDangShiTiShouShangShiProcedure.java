package net.mcreator.mountainspoem.procedures;

import net.mcreator.mountainspoem.entity.RiverMermanEntity;

public class RiverMermanDangShiTiShouShangShiProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if (entity instanceof RiverMermanEntity) {
			((RiverMermanEntity) entity).setAnimation("hurt");
		}
	}
}
