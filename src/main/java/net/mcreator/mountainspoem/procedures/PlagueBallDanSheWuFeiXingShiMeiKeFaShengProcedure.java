package net.mcreator.mountainspoem.procedures;

import net.mcreator.mountainspoem.init.MountainsPoemModParticleTypes;

public class PlagueBallDanSheWuFeiXingShiMeiKeFaShengProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		if (world instanceof ServerLevel _level)
			_level.sendParticles((SimpleParticleType) (MountainsPoemModParticleTypes.PLAGUES.get()), x, y, z, 5, 3, 3, 3, 1);
	}
}
