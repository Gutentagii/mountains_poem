package com.xiris.mountainspoem.util;

import com.xiris.mountainspoem.entity.StoneEntity;
import com.xiris.mountainspoem.init.MountainsPoemModEntities;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.level.Level;

public class EntityUtils {
    public static Projectile getArrow(Level level, Entity shooter, float damage, int knockback, int secondOnFire) {
        AbstractArrow entityToSpawn = new StoneEntity(MountainsPoemModEntities.STONE.get(), level);
        entityToSpawn.setOwner(shooter);
        entityToSpawn.setBaseDamage(damage);
        entityToSpawn.setKnockback(knockback);
        entityToSpawn.setSilent(true);
        if (secondOnFire > 0) entityToSpawn.setSecondsOnFire(secondOnFire);
        entityToSpawn.setCritArrow(true);
        entityToSpawn.pickup = AbstractArrow.Pickup.ALLOWED;
        return entityToSpawn;
    }
}
