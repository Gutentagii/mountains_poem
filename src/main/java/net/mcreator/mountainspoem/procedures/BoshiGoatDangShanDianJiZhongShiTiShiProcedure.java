package net.mcreator.mountainspoem.procedures;

import net.mcreator.mountainspoem.entity.BoshiGoatEntity;

public class BoshiGoatDangShanDianJiZhongShiTiShiProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if (Math.random() < 0.03) {
			if (entity instanceof BoshiGoatEntity animatable)
				animatable.setTexture("boshi_goat3");
		}
	}
}
