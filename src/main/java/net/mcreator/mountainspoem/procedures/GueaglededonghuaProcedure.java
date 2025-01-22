package net.mcreator.mountainspoem.procedures;

import net.mcreator.mountainspoem.entity.GuEagleEntity;

public class GueaglededonghuaProcedure {
	public static void execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		if (entity instanceof LivingEntity _livEnt0 && _livEnt0.isBaby() && entity.onGround() == false) {
			if (Math.random() < 0.2) {
				for (int index0 = 0; index0 < 5; index0++) {
					if (entity instanceof GuEagleEntity) {
						((GuEagleEntity) entity).setAnimation("play");
					}
				}
			}
		}
		if (entity.onGround() == true && world.getLevelData().isThundering()) {
			if (Math.random() < 0.21) {
				for (int index1 = 0; index1 < 5; index1++) {
					if (entity instanceof GuEagleEntity) {
						((GuEagleEntity) entity).setAnimation("dance");
					}
				}
			}
		}
	}
}
