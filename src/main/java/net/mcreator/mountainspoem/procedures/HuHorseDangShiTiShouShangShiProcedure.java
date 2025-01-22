package net.mcreator.mountainspoem.procedures;

import net.mcreator.mountainspoem.entity.HuHorseEntity;

public class HuHorseDangShiTiShouShangShiProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if (entity instanceof HuHorseEntity) {
			((HuHorseEntity) entity).setAnimation("hurt");
		}
	}
}
