package net.mcreator.mountainspoem.procedures;

import net.mcreator.mountainspoem.entity.QingGenBirdEntity;

public class QingGenBirdDangShiTiGengXinKeShiProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if ((entity.getDisplayName().getString()).equals("haoz_daha") || (entity.getDisplayName().getString()).equals("\u9F20\u5927\u54C8\u4E0D\u54C8") || (entity.getDisplayName().getString()).equals("daha")
				|| (entity.getDisplayName().getString()).equals("\u5927\u54C8")) {
			if (entity instanceof QingGenBirdEntity animatable)
				animatable.setTexture("shu_da");
		} else {
			if ((entity.getDisplayName().getString()).equals("blue_jay")) {
				if (entity instanceof QingGenBirdEntity animatable)
					animatable.setTexture("qingen2");
			} else {
				if (entity instanceof QingGenBirdEntity animatable)
					animatable.setTexture("qingen");
			}
		}
		if (entity.onGround()) {
			if (entity instanceof QingGenBirdEntity) {
				((QingGenBirdEntity) entity).setAnimation("idle");
			}
		}
	}
}
