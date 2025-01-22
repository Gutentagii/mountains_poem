package net.mcreator.mountainspoem.procedures;

public class FuriousSouthernMountainsGodHeadDangShiTiSiWangShiProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		if (world instanceof Level _level && !_level.isClientSide())
			_level.explode(null, x, y, z, 1, Level.ExplosionInteraction.MOB);
	}
}
