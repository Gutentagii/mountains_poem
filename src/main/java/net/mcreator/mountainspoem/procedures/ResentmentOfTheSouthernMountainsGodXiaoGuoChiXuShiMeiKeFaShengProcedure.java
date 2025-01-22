package net.mcreator.mountainspoem.procedures;

import net.mcreator.mountainspoem.init.MountainsPoemModEntities;

public class ResentmentOfTheSouthernMountainsGodXiaoGuoChiXuShiMeiKeFaShengProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if (entity.getType().is(TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation("mountains_poem:resentment_resistance_mobs"))) == false) {
			if (Math.random() < 0.009) {
				if (Math.random() < 0.7) {
					if (world instanceof ServerLevel _level) {
						Entity entityToSpawn = MountainsPoemModEntities.SOUTHERN_MOUNTAINS_GOD_HEAD.get().spawn(_level, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
						if (entityToSpawn != null) {
							entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
						}
					}
				} else {
					if (world instanceof ServerLevel _level) {
						Entity entityToSpawn = MountainsPoemModEntities.FURIOUS_SOUTHERN_MOUNTAINS_GOD_HEAD.get().spawn(_level, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
						if (entityToSpawn != null) {
							entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
						}
					}
				}
			}
		}
	}
}
