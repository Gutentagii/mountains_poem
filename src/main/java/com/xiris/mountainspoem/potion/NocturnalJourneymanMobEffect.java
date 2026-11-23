
package com.xiris.mountainspoem.potion;

import com.xiris.mountainspoem.entity.XuanTortoiseEntity;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.AttributeMap;

public class NocturnalJourneymanMobEffect extends MobEffect {
	public NocturnalJourneymanMobEffect() {
		super(MobEffectCategory.BENEFICIAL, -1257);
	}

	@Override
	public void applyEffectTick(LivingEntity entity, int amplifier) {
		if ((Entity) entity instanceof LivingEntity _entity && !_entity.level().isClientSide()) {
			_entity.addEffect(new MobEffectInstance(MobEffects.NIGHT_VISION, 60, 2, false, false));
			_entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 60, 2, false, false));
			_entity.addEffect(new MobEffectInstance(MobEffects.JUMP, 60, 2, false, false));
		}
	}

	@Override
	public void removeAttributeModifiers(LivingEntity entity, AttributeMap attributeMap, int amplifier) {
		super.removeAttributeModifiers(entity, attributeMap, amplifier);
        entity.level();
        if (entity instanceof XuanTortoiseEntity) {
            if (!entity.level().isClientSide())
                entity.discard();
        }
    }

	@Override
	public boolean isDurationEffectTick(int duration, int amplifier) {
		return true;
	}
}
