package net.mcreator.mountainspoem.procedures;

public class SoulShardDangShiTiSiWangShiProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		world.addParticle(ParticleTypes.SOUL_FIRE_FLAME, x, y, z, 0, 1, 0);
	}
}
