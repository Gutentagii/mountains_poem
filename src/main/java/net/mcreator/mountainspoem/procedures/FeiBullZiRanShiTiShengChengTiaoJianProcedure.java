package net.mcreator.mountainspoem.procedures;

import net.mcreator.mountainspoem.init.MountainsPoemModEntities;

public class FeiBullZiRanShiTiShengChengTiaoJianProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		if (world instanceof ServerLevel _level0 && _level0.isRaided(BlockPos.containing(x, y, z)) && world instanceof ServerLevel _level1 && _level1.isVillage(BlockPos.containing(x, y, z))) {
			if (Math.random() < 0.3) {
				if (world instanceof ServerLevel _level) {
					LightningBolt entityToSpawn = EntityType.LIGHTNING_BOLT.create(_level);
					entityToSpawn.moveTo(Vec3.atBottomCenterOf(BlockPos.containing(x, y, z)));;
					_level.addFreshEntity(entityToSpawn);
				}
				if (world instanceof ServerLevel _level) {
					Entity entityToSpawn = MountainsPoemModEntities.FEI_BULL.get().spawn(_level, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
					if (entityToSpawn != null) {
					}
				}
			}
		}
	}
}
