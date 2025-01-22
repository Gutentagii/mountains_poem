package net.mcreator.mountainspoem.procedures;

import net.mcreator.mountainspoem.entity.NineTailedFoxEntity;

public class NineTailedFoxDangShanDianJiZhongShiTiShiProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if (Math.random() < 0.2) {
			if (entity instanceof NineTailedFoxEntity animatable)
				animatable.setTexture("hujiuwei4");
		}
	}
}
