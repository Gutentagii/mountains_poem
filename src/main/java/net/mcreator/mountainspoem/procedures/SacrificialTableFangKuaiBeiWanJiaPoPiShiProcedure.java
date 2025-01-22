package net.mcreator.mountainspoem.procedures;

import net.mcreator.mountainspoem.init.MountainsPoemModParticleTypes;
import net.minecraft.world.level.Level;

public class SacrificialTableFangKuaiBeiWanJiaPoPiShiProcedure {
	public static void execute(Level world, double x, double y, double z) {
		if (world instanceof ServerLevel _level)
			_level.sendParticles((SimpleParticleType) (MountainsPoemModParticleTypes.SACRIFICE_N.get()), x, y, z, 5, 3, 3, 3, 1);
	}
}
