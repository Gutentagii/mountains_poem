package net.mcreator.mountainspoem.procedures;

import net.mcreator.mountainspoem.init.MountainsPoemModParticleTypes;
import net.mcreator.mountainspoem.entity.ImperialExaminationGhostEntity;

public class ImperialExaminationGhostDangShiTiGengXinKeShiProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if ((world.getBlockState(BlockPos.containing(entity.getLookAngle().x, entity.getLookAngle().y, entity.getLookAngle().z))).is(BlockTags.create(new ResourceLocation("mountains_poem:bookshelf")))) {
			if (entity instanceof ImperialExaminationGhostEntity) {
				((ImperialExaminationGhostEntity) entity).setAnimation("wave");
			}
			world.destroyBlock(BlockPos.containing(entity.getLookAngle().x, entity.getLookAngle().y, entity.getLookAngle().z), false);
			if (world instanceof ServerLevel _level)
				_level.sendParticles((SimpleParticleType) (MountainsPoemModParticleTypes.MAGIC.get()), x, y, z, 5, 3, 3, 3, 1);
			if (world instanceof ServerLevel _level)
				_level.sendParticles((SimpleParticleType) (MountainsPoemModParticleTypes.XIANGYUN.get()), (entity.getLookAngle().x), (entity.getLookAngle().y), (entity.getLookAngle().z), 5, 1, 1, 1, 1);
		}
	}
}
