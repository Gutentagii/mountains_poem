
package com.xiris.mountainspoem.potion;

import com.xiris.mountainspoem.MountainsPoemMod;
import net.minecraft.advancements.Advancement;
import net.minecraft.advancements.AdvancementProgress;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.ExperienceOrb;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;

public class LushuHeartMobEffect extends MobEffect {
	public LushuHeartMobEffect() {
		super(MobEffectCategory.BENEFICIAL, -3394816);
	}

	@Override
	public void applyEffectTick(LivingEntity entity, int amplifier) {
        LevelAccessor world = entity.level();
        double x = entity.getX();
        double y = entity.getY();
        double z = entity.getZ();
        if (entity.isShiftKeyDown()) {
Player _plr = (Player) entity;
if (_plr.getFoodData().getFoodLevel() >= 15) {
Player _player = (Player) entity;
_player.causeFoodExhaustion(10);
                if (world instanceof ServerLevel _level)
                    _level.addFreshEntity(new ExperienceOrb(_level, x, y, z, 2));
                if (world instanceof Level _level)
                    _level.playSound(null, x, y, z, SoundEvents.PIG_STEP, SoundSource.NEUTRAL, 4, 1);
                world.addParticle(ParticleTypes.HEART, x, y, z, 0, 2, 0);
                if ((Entity) entity instanceof ServerPlayer player) {
                    Advancement advancement = player.server.getAdvancements().getAdvancement(ResourceLocation.fromNamespaceAndPath(MountainsPoemMod.MOD_ID,"pigman"));
                    AdvancementProgress ap = player.getAdvancements().getOrStartProgress(advancement);
                    if (!ap.isDone())
                        for (String criteria : ap.getRemainingCriteria())
                            player.getAdvancements().award(advancement, criteria);
                }
            }
        }
    }

	@Override
	public boolean isDurationEffectTick(int duration, int amplifier) {
		return true;
	}
}
