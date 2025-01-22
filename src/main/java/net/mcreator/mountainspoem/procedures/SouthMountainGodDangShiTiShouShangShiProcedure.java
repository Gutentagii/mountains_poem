package net.mcreator.mountainspoem.procedures;

import net.mcreator.mountainspoem.init.MountainsPoemModParticleTypes;
import net.mcreator.mountainspoem.init.MountainsPoemModMobEffects;

import java.util.List;
import java.util.Comparator;

public class SouthMountainGodDangShiTiShouShangShiProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if (world instanceof ServerLevel _level)
			_level.sendParticles((SimpleParticleType) (MountainsPoemModParticleTypes.SACRIFICE_C.get()), x, y, z, 5, 3, 3, 3, 1);
		if (world instanceof ServerLevel _level)
			_level.sendParticles((SimpleParticleType) (MountainsPoemModParticleTypes.SACRIFICE_D.get()), x, y, z, 5, 3, 3, 3, 1);
		{
			final Vec3 _center = new Vec3(x, y, z);
			List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(40 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
			for (Entity entityiterator : _entfound) {
				if (entityiterator instanceof LivingEntity _entity && !_entity.level().isClientSide())
					_entity.addEffect(new MobEffectInstance(MobEffects.GLOWING, 60, 1));
				entityiterator.setInvisible(false);
				if (Math.random() < 0.7) {
					if (entityiterator instanceof LivingEntity _entity && !_entity.level().isClientSide())
						_entity.addEffect(new MobEffectInstance(MountainsPoemModMobEffects.RESENTMENT_OF_THE_SOUTHERN_MOUNTAINS_GOD.get(), 2000, 0));
				}
			}
		}
		if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
			_entity.addEffect(new MobEffectInstance(MountainsPoemModMobEffects.RESENTMENT_OF_THE_SOUTHERN_MOUNTAINS_GOD.get(), 60, 0, false, false));
	}
}
