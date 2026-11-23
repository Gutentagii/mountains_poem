
package com.xiris.mountainspoem.potion;

import com.xiris.mountainspoem.MountainsPoemMod;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.TamableAnimal;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;

import java.util.Comparator;
import java.util.List;

public class LostSoulsMobEffect extends MobEffect {
	public LostSoulsMobEffect() {
		super(MobEffectCategory.HARMFUL, -15500954);
	}

	@Override
	public void applyEffectTick(LivingEntity entity, int amplifier) {
        LevelAccessor world = entity.level();
        double x = entity.getX();
        double y = entity.getY();
        double z = entity.getZ();
        if ((world.getBlockState(BlockPos.containing(x, y, z))).is(BlockTags.create(ResourceLocation.fromNamespaceAndPath(MountainsPoemMod.MOD_ID,"souls_block")))) {
            entity.setInvisible(true);
        } else {
            final Vec3 _center = new Vec3(x, y, z);
            List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(80 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
            for (Entity entityiterator : _entfound) {
                if (entityiterator instanceof TamableAnimal _tamIsTamedBy && (Entity) entity instanceof LivingEntity _livEnt && _tamIsTamedBy.isOwnedBy(_livEnt))
                    entity.makeStuckInBlock(Blocks.AIR.defaultBlockState(), new Vec3(0.25, 0.05, 0.25));
                else if (entityiterator instanceof Mob _entity && (Entity) entity instanceof LivingEntity _ent)
                    _entity.setTarget(_ent);
            }
        }
    }

	@Override
	public boolean isDurationEffectTick(int duration, int amplifier) {
		return true;
	}
}
