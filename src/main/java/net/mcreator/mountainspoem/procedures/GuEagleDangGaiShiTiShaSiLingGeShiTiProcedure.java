package net.mcreator.mountainspoem.procedures;

import net.mcreator.mountainspoem.entity.GuEagleEntity;

public class GuEagleDangGaiShiTiShaSiLingGeShiTiProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if (Math.random() < 0.7) {
			for (int index0 = 0; index0 < (int) Mth.nextDouble(RandomSource.create(), 4, 8); index0++) {
				if (entity instanceof GuEagleEntity) {
					((GuEagleEntity) entity).setAnimation("dance2");
				}
			}
		}
	}
}
