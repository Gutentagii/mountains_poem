package net.mcreator.mountainspoem.procedures;

import net.mcreator.mountainspoem.entity.ZuoCowEntity;

public class ZuoCowDangShiTiShouShangShiProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if (entity instanceof ZuoCowEntity) {
			((ZuoCowEntity) entity).setAnimation("hurt");
		}
	}
}
