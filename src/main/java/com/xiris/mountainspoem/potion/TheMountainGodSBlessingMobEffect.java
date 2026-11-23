
package com.xiris.mountainspoem.potion;

import com.xiris.mountainspoem.init.MountainsPoemModMobEffects;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;

public class TheMountainGodSBlessingMobEffect extends MobEffect {
	public TheMountainGodSBlessingMobEffect() {
		super(MobEffectCategory.BENEFICIAL, -11958351);
	}

	@Override
	public void applyEffectTick(LivingEntity entity, int amplifier) {
        entity.clearFire();
        if ((Entity) entity instanceof LivingEntity _entity) {
            _entity.removeEffect(MountainsPoemModMobEffects.EVIL_QI.get());
            if(!_entity.level().isClientSide()){
                _entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 2, 0));
                _entity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_BOOST, 2, 0));
            }
        }
    }

	@Override
	public boolean isDurationEffectTick(int duration, int amplifier) {
		return true;
	}
}
