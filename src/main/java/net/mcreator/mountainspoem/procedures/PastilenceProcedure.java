package net.mcreator.mountainspoem.procedures;

import net.mcreator.mountainspoem.init.MountainsPoemModEntities;

public class PastilenceProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		if (world.getLevelData().isThundering()) {
			if (Math.random() < 0.01) {
				if (world instanceof ServerLevel _level1 && _level1.isVillage(BlockPos.containing(x, y, z))) {
					if (world instanceof ServerLevel _level) {
						Entity entityToSpawn = MountainsPoemModEntities.GU_EAGLE.get().spawn(_level, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
						if (entityToSpawn != null) {
							entityToSpawn.setDeltaMovement(0, 0, 0);
						}
					}
					if (world instanceof ServerLevel _level) {
						Entity entityToSpawn = MountainsPoemModEntities.GU_EAGLE.get().spawn(_level, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
						if (entityToSpawn != null) {
							entityToSpawn.setDeltaMovement(0, 0, 0);
						}
					}
					if (world instanceof ServerLevel _level) {
						LightningBolt entityToSpawn = EntityType.LIGHTNING_BOLT.create(_level);
						entityToSpawn.moveTo(Vec3.atBottomCenterOf(BlockPos.containing(x, y, z)));
						entityToSpawn.setVisualOnly(true);
						_level.addFreshEntity(entityToSpawn);
					}
					if (world instanceof ServerLevel _level) {
						Entity entityToSpawn = MountainsPoemModEntities.FEI_BULL.get().spawn(_level, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
						if (entityToSpawn != null) {
							entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
						}
					}
				}
			}
		}
	}
}
