package net.mcreator.mountainspoem.procedures;

import net.mcreator.mountainspoem.init.MountainsPoemModParticleTypes;

public class PeachBlossomLeavesDangYouXiKeGengXinShiProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		if (world.isEmptyBlock(BlockPos.containing(x, y - 1, z))) {
			if (Math.random() < 0.7) {
				if (world instanceof ServerLevel _level)
					_level.sendParticles((SimpleParticleType) (MountainsPoemModParticleTypes.PEACH_BLOSSOMS.get()), x, y, z, 3, 0.2, 0.2, 0.2, 0.5);
			} else {
				if (world instanceof ServerLevel _level)
					_level.sendParticles((SimpleParticleType) (MountainsPoemModParticleTypes.PEACH_BLOSSOMS_2.get()), x, y, z, 3, 0.2, 0.2, 0.2, 0.5);
			}
		}
	}
}
