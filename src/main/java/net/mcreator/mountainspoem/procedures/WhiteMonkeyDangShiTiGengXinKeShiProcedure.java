package net.mcreator.mountainspoem.procedures;

import net.mcreator.mountainspoem.entity.WhiteMonkeyEntity;

public class WhiteMonkeyDangShiTiGengXinKeShiProcedure {
	public static void execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		if (world.getLevelData().isRaining() && Math.random() < 0.1 && entity instanceof LivingEntity _livEnt1 && _livEnt1.isBaby() && entity.isInWaterRainOrBubble()) {
			for (int index0 = 0; index0 < 10; index0++) {
				if (entity instanceof WhiteMonkeyEntity) {
					((WhiteMonkeyEntity) entity).setAnimation("play");
				}
			}
		}
		if (entity.isSprinting() == true) {
			if (entity instanceof WhiteMonkeyEntity) {
				((WhiteMonkeyEntity) entity).setAnimation("sprint");
			}
		}
	}
}
