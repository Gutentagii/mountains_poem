package net.mcreator.mountainspoem.procedures;

import net.mcreator.mountainspoem.entity.QingGenBirdEntity;

public class QingGenBirdDangShiTiShouShangShiProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if (entity instanceof QingGenBirdEntity) {
			((QingGenBirdEntity) entity).setAnimation("hurt");
		}
	}
}
