package net.mcreator.mountainspoem.procedures;

import net.mcreator.mountainspoem.entity.RiverMermanEntity;

public class RiverMermanShiTiChuShiShengChengShiProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if (Math.random() < 0.7) {
			if (entity instanceof RiverMermanEntity animatable)
				animatable.setTexture("merman1");
		} else {
			if (entity instanceof RiverMermanEntity animatable)
				animatable.setTexture("merman2");
		}
	}
}
