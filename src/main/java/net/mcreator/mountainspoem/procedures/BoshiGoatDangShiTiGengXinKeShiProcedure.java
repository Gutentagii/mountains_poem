package net.mcreator.mountainspoem.procedures;

import net.mcreator.mountainspoem.entity.BoshiGoatEntity;

public class BoshiGoatDangShiTiGengXinKeShiProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if (entity.isSprinting() == true) {
			if (entity instanceof BoshiGoatEntity) {
				((BoshiGoatEntity) entity).setAnimation("sprint");
			}
		}
		if (Math.random() < 0.1) {
			if (Math.random() < 0.14) {
				if (entity instanceof BoshiGoatEntity) {
					((BoshiGoatEntity) entity).setAnimation("hide");
				}
			} else {
				if (Math.random() > 0.95) {
					if (entity instanceof BoshiGoatEntity) {
						((BoshiGoatEntity) entity).setAnimation("play");
					}
				}
			}
		}
	}
}
