package net.mcreator.mountainspoem.procedures;

import net.mcreator.mountainspoem.entity.ZhiEntity;

public class ZhiShiTiChuShiShengChengShiProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if (Math.random() < 0.2) {
			if (entity instanceof ZhiEntity animatable)
				animatable.setTexture("zhi_3");
		}
	}
}
