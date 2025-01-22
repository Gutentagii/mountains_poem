package net.mcreator.mountainspoem.procedures;

import net.mcreator.mountainspoem.entity.BoshiGoatEntity;

public class BoshiGoatDangGaiShiTiShaSiLingGeShiTiProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if (Math.random() < 0.06) {
			for (int index0 = 0; index0 < 6; index0++) {
				if (entity instanceof BoshiGoatEntity) {
					((BoshiGoatEntity) entity).setAnimation("dance");
				}
			}
		}
	}
}
