package net.mcreator.mountainspoem.procedures;

import net.mcreator.mountainspoem.init.MountainsPoemModMobEffects;

import java.util.List;
import java.util.Comparator;

public class GuResistanceXiaoGuoChiXuShiMeiKeFaShengProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if (entity instanceof LivingEntity _entity)
			_entity.removeEffect(MountainsPoemModMobEffects.CRAZY.get());
		if (entity instanceof LivingEntity _entity)
			_entity.removeEffect(MountainsPoemModMobEffects.CHAOS.get());
		if (entity instanceof LivingEntity _entity)
			_entity.removeEffect(MountainsPoemModMobEffects.EVIL_QI.get());
		{
			final Vec3 _center = new Vec3(x, y, z);
			List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(8 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
			for (Entity entityiterator : _entfound) {
				if (entityiterator.getType().is(TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation("mountains_poem:ghost")))) {
					if (entityiterator instanceof LivingEntity _entity && !_entity.level().isClientSide())
						_entity.addEffect(new MobEffectInstance(MountainsPoemModMobEffects.CRAZY.get(), 60, 2));
				}
			}
		}
	}
}
