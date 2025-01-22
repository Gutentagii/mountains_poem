package net.mcreator.mountainspoem.procedures;

import net.mcreator.mountainspoem.init.MountainsPoemModBlocks;
import net.mcreator.mountainspoem.entity.BronzeDevourerEntity;

public class PeachwoodSwordShiTiBeiGongJuJiZhongShiProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if (entity.getType().is(TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation("mountains_poem:ghost")))) {
			if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
				_entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 300, 1));
			if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
				_entity.addEffect(new MobEffectInstance(MobEffects.WEAKNESS, 300, 2));
		}
		if (entity instanceof BronzeDevourerEntity) {
			if (!entity.level().isClientSide())
				entity.discard();
			world.setBlock(BlockPos.containing(x, y, z), MountainsPoemModBlocks.SPOOKY_BRONZE_DEVOURER_STATUE.get().defaultBlockState(), 3);
		}
	}
}
