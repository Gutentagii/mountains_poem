package net.mcreator.mountainspoem.procedures;

import net.mcreator.mountainspoem.init.MountainsPoemModEntities;
import net.mcreator.mountainspoem.entity.HuHorseEntity;

public class Mobs1Procedure {
	public static Entity execute(LevelAccessor world) {
		return world instanceof Level _level ? new HuHorseEntity(MountainsPoemModEntities.WATER_HORSE.get(), _level) : null;
	}
}
