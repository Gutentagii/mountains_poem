package net.mcreator.mountainspoem.procedures;

import net.mcreator.mountainspoem.init.MountainsPoemModEntities;
import net.mcreator.mountainspoem.entity.HuiHorseEntity;

public class Mobs1AProcedure {
	public static Entity execute(LevelAccessor world) {
		return world instanceof Level _level ? new HuiHorseEntity(MountainsPoemModEntities.HUN_HORSE.get(), _level) : null;
	}
}
