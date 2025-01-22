package net.mcreator.mountainspoem.procedures;

import net.mcreator.mountainspoem.init.MountainsPoemModParticleTypes;
import net.mcreator.mountainspoem.init.MountainsPoemModItems;

public class PhonehaungProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity sourceentity) {
		if (sourceentity == null)
			return;
		if ((sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == MountainsPoemModItems.JINYU_JADE.get()) {
			if (Math.random() < 0.7) {
				world.addParticle((SimpleParticleType) (MountainsPoemModParticleTypes.FENG_HUANG.get()), x, y, z, 0, 1, 0);
			}
		}
	}
}
