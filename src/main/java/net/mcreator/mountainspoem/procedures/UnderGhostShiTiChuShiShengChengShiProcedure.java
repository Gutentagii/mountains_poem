package net.mcreator.mountainspoem.procedures;

import net.mcreator.mountainspoem.entity.UnderGhostEntity;

public class UnderGhostShiTiChuShiShengChengShiProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if (Math.random() < 0.3) {
			if (entity instanceof UnderGhostEntity animatable)
				animatable.setTexture("under_ghost_2");
		}
	}
}
