package net.mcreator.mountainspoem.procedures;

import net.mcreator.mountainspoem.entity.WhiteMonkeyEntity;

public class WhiteMonkeyDangShanDianJiZhongShiTiShiProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if (entity instanceof WhiteMonkeyEntity) {
			((WhiteMonkeyEntity) entity).setAnimation("hurt");
		}
	}
}
