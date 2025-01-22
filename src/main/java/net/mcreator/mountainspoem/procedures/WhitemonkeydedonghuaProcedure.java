package net.mcreator.mountainspoem.procedures;

import net.mcreator.mountainspoem.entity.WhiteMonkeyEntity;

public class WhitemonkeydedonghuaProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if (entity instanceof LivingEntity _livEnt0 && _livEnt0.isBaby()) {
			if ((((WhiteMonkeyEntity) entity).animationprocedure).equals("idle")) {
				if (entity instanceof WhiteMonkeyEntity) {
					((WhiteMonkeyEntity) entity).setAnimation("idle2");
				}
			}
			if ((((WhiteMonkeyEntity) entity).animationprocedure).equals("attack")) {
				if (entity instanceof WhiteMonkeyEntity) {
					((WhiteMonkeyEntity) entity).setAnimation("attack2");
				}
			}
			if ((((WhiteMonkeyEntity) entity).animationprocedure).equals("walk")) {
				if (entity instanceof WhiteMonkeyEntity) {
					((WhiteMonkeyEntity) entity).setAnimation("walk2");
				}
			}
			if ((((WhiteMonkeyEntity) entity).animationprocedure).equals("sprint")) {
				if (entity instanceof WhiteMonkeyEntity) {
					((WhiteMonkeyEntity) entity).setAnimation("sprint2");
				}
			}
			if ((((WhiteMonkeyEntity) entity).animationprocedure).equals("dead")) {
				if (entity instanceof WhiteMonkeyEntity) {
					((WhiteMonkeyEntity) entity).setAnimation("dead2");
				}
			}
			if ((((WhiteMonkeyEntity) entity).animationprocedure).equals("swim")) {
				if (entity instanceof WhiteMonkeyEntity) {
					((WhiteMonkeyEntity) entity).setAnimation("swim2");
				}
			}
		}
	}
}
