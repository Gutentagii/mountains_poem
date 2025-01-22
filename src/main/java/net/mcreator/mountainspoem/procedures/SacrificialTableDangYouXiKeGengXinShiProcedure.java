package net.mcreator.mountainspoem.procedures;

import net.mcreator.mountainspoem.init.MountainsPoemModParticleTypes;
import net.minecraft.server.level.ServerLevel;
import org.jetbrains.annotations.NotNull;

public class SacrificialTableDangYouXiKeGengXinShiProcedure {
	public static void execute(@NotNull ServerLevel world, double x, double y, double z) {
		if (Math.random() < 0.4) {
			if (world instanceof ServerLevel _level)
				_level.sendParticles((SimpleParticleType) (MountainsPoemModParticleTypes.SACRIFICE_P.get()), x, y, z, 5, 2, 3, 2, 1);
		} else {
			if (Math.random() > 0.8) {
				if (world instanceof ServerLevel _level)
					_level.sendParticles((SimpleParticleType) (MountainsPoemModParticleTypes.SACRIFICE_Q.get()), x, y, z, 5, 2, 3, 2, 1);
			} else if (Math.random() >= 0.4 && Math.random() <= 0.8) {
				if (world instanceof ServerLevel _level)
					_level.sendParticles((SimpleParticleType) (MountainsPoemModParticleTypes.SACRIFICE_R.get()), x, y, z, 5, 2, 3, 2, 1);
			}
		}
	}
}
