package net.mcreator.mountainspoem.procedures;

import net.mcreator.mountainspoem.entity.NineTailedFoxEntity;

public class HujiuweiAnimattionProcedure {
	public static void execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		if (entity instanceof LivingEntity _livEnt0 && _livEnt0.isBaby()) {
			if (Math.random() < 0.4) {
				if (entity instanceof NineTailedFoxEntity animatable)
					animatable.setTexture("hujiuwei2");
			}
		}
		if (world.getLevelData().isRaining()) {
			if (Math.random() < 0.4 && (entity instanceof LivingEntity _livEnt3 && _livEnt3.isBaby()) == false) {
				if (entity instanceof NineTailedFoxEntity animatable)
					animatable.setTexture("hujiuwei3");
			}
		}
	}
}
