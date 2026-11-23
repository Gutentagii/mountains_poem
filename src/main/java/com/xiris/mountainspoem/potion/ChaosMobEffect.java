
package com.xiris.mountainspoem.potion;

import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;

public class ChaosMobEffect extends MobEffect {
	public ChaosMobEffect() {
		super(MobEffectCategory.HARMFUL, -15397876);
	}

	@Override
	public void applyEffectTick(LivingEntity entity, int amplifier) {
        entity.clearFire();
        entity.setYRot(0);
        entity.setXRot(40);
        ((Entity) entity).setYBodyRot(entity.getYRot());
        ((Entity) entity).setYHeadRot(entity.getYRot());
        entity.yRotO = entity.getYRot();
        entity.xRotO = entity.getXRot();
        if ((Entity) entity instanceof LivingEntity living) {
            living.yBodyRotO = living.getYRot();
            living.yHeadRotO = living.getYRot();
            if (!living.level().isClientSide())
                living.addEffect(new MobEffectInstance(MobEffects.WITHER, 3, 2, false, false));
        }
        entity.setSecondsOnFire(1);
    }

	@Override
	public boolean isDurationEffectTick(int duration, int amplifier) {
		return true;
	}
}
