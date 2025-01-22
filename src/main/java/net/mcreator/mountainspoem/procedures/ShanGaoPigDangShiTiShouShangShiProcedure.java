package net.mcreator.mountainspoem.procedures;

import net.mcreator.mountainspoem.entity.ShanGaoPigEntity;

public class ShanGaoPigDangShiTiShouShangShiProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if (entity instanceof ShanGaoPigEntity) {
			((ShanGaoPigEntity) entity).setAnimation("hurt");
		}
	}
}
