package net.mcreator.mountainspoem.procedures;

import net.mcreator.mountainspoem.entity.HuHorseEntity;

public class HuHorseShiTiChuShiShengChengShiProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if (Math.random() < 0.3) {
			if (entity instanceof HuHorseEntity animatable)
				animatable.setTexture("water_horse");
		}
	}
}
