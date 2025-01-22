package net.mcreator.mountainspoem.procedures;

import net.mcreator.mountainspoem.init.MountainsPoemModParticleTypes;

import java.util.List;
import java.util.Comparator;

public class SleepPeacefullyXiaoGuoChiXuShiMeiKeFaShengProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		{
			final Vec3 _center = new Vec3(x, y, z);
			List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(24 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
			for (Entity entityiterator : _entfound) {
				if (entityiterator.getType().is(TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation("mountains_poem:nightmare")))) {
					if ((world instanceof Level _lvl1 && _lvl1.isDay()) == false) {
						entityiterator.hurt(new DamageSource(world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(DamageTypes.MAGIC)), 2);
						if (world instanceof ServerLevel _level)
							_level.sendParticles((SimpleParticleType) (MountainsPoemModParticleTypes.SACRIFICE_R.get()), x, y, z, 1, 0, 0, 0, 1);
					} else {
						if (Math.random() < 0.7) {
							entityiterator.setSecondsOnFire(15);
							if (entityiterator instanceof Mob _entity && entityiterator instanceof LivingEntity _ent)
								_entity.setTarget(_ent);
						}
						if (world instanceof ServerLevel _level)
							_level.sendParticles((SimpleParticleType) (MountainsPoemModParticleTypes.SACRIFICE_Q.get()), x, y, z, 3, 0, 0, 0, 1);
					}
				}
			}
		}
	}
}
