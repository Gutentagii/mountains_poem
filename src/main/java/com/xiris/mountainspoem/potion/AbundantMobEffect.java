
package com.xiris.mountainspoem.potion;

import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;

public class AbundantMobEffect extends MobEffect {
    public AbundantMobEffect() {
        super(MobEffectCategory.BENEFICIAL, -3381760);
    }

    @Override
    public void applyEffectTick(LivingEntity entity, int amplifier) {
        if (entity instanceof Player player)
            player.getFoodData().setSaturation(40);
    }

    @Override
    public boolean isDurationEffectTick(int duration, int amplifier) {
        return true;
    }
}
