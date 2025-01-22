package net.mcreator.mountainspoem.procedures;

import net.mcreator.mountainspoem.entity.GuEagleEntity;

public class GuEagleDangShiTiShouShangShiProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if (entity instanceof GuEagleEntity) {
			((GuEagleEntity) entity).setAnimation("hurt");
		}
	}
}
