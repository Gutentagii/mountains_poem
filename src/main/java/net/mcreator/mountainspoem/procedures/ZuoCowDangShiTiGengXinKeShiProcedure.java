package net.mcreator.mountainspoem.procedures;

import net.mcreator.mountainspoem.entity.ZuoCowEntity;
import net.mcreator.mountainspoem.MountainsPoemMod;

public class ZuoCowDangShiTiGengXinKeShiProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if ((entity instanceof ZuoCowEntity animatable ? animatable.getTexture() : "null").equals("zuo_cow_2") || (entity instanceof ZuoCowEntity animatable ? animatable.getTexture() : "null").equals("zuo_cow_black_2")
				|| (entity instanceof ZuoCowEntity animatable ? animatable.getTexture() : "null").equals("zuo_cow_brown_2") || (entity instanceof ZuoCowEntity animatable ? animatable.getTexture() : "null").equals("zuo_cow_white_2")) {
			entity.setSprinting(true);
		} else {
			for (Entity entityiterator : entity.getIndirectPassengers()) {
				entityiterator.stopRiding();
				entity.setSprinting(false);
				if (world instanceof ServerLevel _level)
					_level.sendParticles(ParticleTypes.LARGE_SMOKE, x, y, z, 5, 3, 3, 3, 1);
				entityiterator.setShiftKeyDown(true);
				MountainsPoemMod.queueServerWork(10, () -> {
					entityiterator.setShiftKeyDown(false);
				});
			}
		}
	}
}
