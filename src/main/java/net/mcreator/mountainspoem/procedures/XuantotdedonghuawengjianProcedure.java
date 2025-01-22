package net.mcreator.mountainspoem.procedures;

import net.mcreator.mountainspoem.entity.XuanTortoiseEntity;

public class XuantotdedonghuawengjianProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if (entity instanceof LivingEntity _livEnt0 && _livEnt0.isBaby()) {
			if ((((XuanTortoiseEntity) entity).animationprocedure).equals("idle")) {
				if (entity instanceof XuanTortoiseEntity) {
					((XuanTortoiseEntity) entity).setAnimation("idle2");
				}
			}
			if ((((XuanTortoiseEntity) entity).animationprocedure).equals("attack")) {
				if (entity instanceof XuanTortoiseEntity) {
					((XuanTortoiseEntity) entity).setAnimation("attack2");
				}
			}
			if ((((XuanTortoiseEntity) entity).animationprocedure).equals("walk")) {
				if (entity instanceof XuanTortoiseEntity) {
					((XuanTortoiseEntity) entity).setAnimation("walk2");
				}
			}
			if ((((XuanTortoiseEntity) entity).animationprocedure).equals("swim")) {
				if (entity instanceof XuanTortoiseEntity) {
					((XuanTortoiseEntity) entity).setAnimation("swim2");
				}
			}
		}
	}
}
