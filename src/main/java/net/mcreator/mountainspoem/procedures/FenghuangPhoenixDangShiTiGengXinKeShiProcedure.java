package net.mcreator.mountainspoem.procedures;

import net.mcreator.mountainspoem.init.MountainsPoemModParticleTypes;
import net.mcreator.mountainspoem.entity.FenghuangPhoenixEntity;

public class FenghuangPhoenixDangShiTiGengXinKeShiProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if ((((FenghuangPhoenixEntity) entity).animationprocedure).equals("fly")) {
			if (world instanceof ServerLevel _level)
				_level.sendParticles((SimpleParticleType) (MountainsPoemModParticleTypes.FENG_HUANG.get()), x, y, z, 5, 3, 3, 3, 1);
		}
	}
}
