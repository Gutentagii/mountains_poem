package net.mcreator.mountainspoem.procedures;

import net.mcreator.mountainspoem.entity.LushuhorseEntity;

public class LushudedonghuaProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if (entity instanceof LivingEntity _livEnt0 && _livEnt0.isBaby()) {
			if ((((LushuhorseEntity) entity).animationprocedure).equals("idle")) {
				if (entity instanceof LushuhorseEntity) {
					((LushuhorseEntity) entity).setAnimation("idle2");
				}
			}
			if ((((LushuhorseEntity) entity).animationprocedure).equals("walk")) {
				if (entity instanceof LushuhorseEntity) {
					((LushuhorseEntity) entity).setAnimation("walk2");
				}
			}
			if ((((LushuhorseEntity) entity).animationprocedure).equals("dead")) {
				if (entity instanceof LushuhorseEntity) {
					((LushuhorseEntity) entity).setAnimation("dead2");
				}
			}
		}
	}
}
