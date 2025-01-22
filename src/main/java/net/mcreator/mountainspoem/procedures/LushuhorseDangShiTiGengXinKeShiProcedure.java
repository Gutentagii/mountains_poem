package net.mcreator.mountainspoem.procedures;

import net.mcreator.mountainspoem.entity.LushuhorseEntity;

public class LushuhorseDangShiTiGengXinKeShiProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if (entity instanceof LivingEntity _livEnt0 && _livEnt0.isBaby()) {
			if (entity instanceof LushuhorseEntity animatable)
				animatable.setTexture("lushu2");
		} else {
			if (entity instanceof LushuhorseEntity animatable)
				animatable.setTexture("lushu");
		}
		if (Math.random() < 0.3 && (((LushuhorseEntity) entity).animationprocedure).equals("idle")) {
			if (entity instanceof LushuhorseEntity) {
				((LushuhorseEntity) entity).setAnimation("ear");
			}
		}
		if (Math.random() > 0.7 && (((LushuhorseEntity) entity).animationprocedure).equals("idle")) {
			if (entity instanceof LushuhorseEntity) {
				((LushuhorseEntity) entity).setAnimation("play");
			}
		}
		if (Math.random() == 0.3 && (((LushuhorseEntity) entity).animationprocedure).equals("idle")) {
			if (entity instanceof LushuhorseEntity) {
				((LushuhorseEntity) entity).setAnimation("hurt");
			}
		}
	}
}
