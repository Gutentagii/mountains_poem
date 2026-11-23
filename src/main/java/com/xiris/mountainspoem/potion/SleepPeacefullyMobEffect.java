
package com.xiris.mountainspoem.potion;

import com.xiris.mountainspoem.MountainsPoemMod;
import com.xiris.mountainspoem.init.MountainsPoemModParticleTypes;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.tags.TagKey;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;

import java.util.Comparator;
import java.util.List;

public class SleepPeacefullyMobEffect extends MobEffect {
	public SleepPeacefullyMobEffect() {
		super(MobEffectCategory.NEUTRAL, -16777114);
	}

	@Override
	public void applyEffectTick(LivingEntity entity, int amplifier) {
        LevelAccessor world = entity.level();
        double x = entity.getX();
        double y = entity.getY();
        double z = entity.getZ();
        final Vec3 _center = new Vec3(x, y, z);
        List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(24 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
        for (Entity entityiterator : _entfound) {
            if (entityiterator.getType().is(TagKey.create(Registries.ENTITY_TYPE, ResourceLocation.fromNamespaceAndPath(MountainsPoemMod.MOD_ID,"nightmare")))) {
                if (!(world instanceof Level _lvl1 && _lvl1.isDay())) {
                    entityiterator.hurt(new DamageSource(world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(DamageTypes.MAGIC)), 2);
                    if (world instanceof ServerLevel _level)
                        _level.sendParticles(MountainsPoemModParticleTypes.SACRIFICE_R.get(), x, y, z, 1, 0, 0, 0, 1);
                } else {
                    if (Math.random() < 0.7) {
                        entityiterator.setSecondsOnFire(15);
                        if (entityiterator instanceof Mob _entity)
                            _entity.setTarget(_entity);
                    }
                    if (world instanceof ServerLevel _level)
                        _level.sendParticles(MountainsPoemModParticleTypes.SACRIFICE_Q.get(), x, y, z, 3, 0, 0, 0, 1);
                }
            }
        }
    }

	@Override
	public boolean isDurationEffectTick(int duration, int amplifier) {
		return true;
	}
}
