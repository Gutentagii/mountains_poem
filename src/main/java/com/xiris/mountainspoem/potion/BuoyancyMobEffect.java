
package com.xiris.mountainspoem.potion;

import com.iafenvoy.neptune.util.Timeout;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.Vec3;

public class BuoyancyMobEffect extends MobEffect {
	public BuoyancyMobEffect() {
		super(MobEffectCategory.BENEFICIAL, -9144189);
	}

	@Override
	public void applyEffectTick(LivingEntity entity, int amplifier) {
        LevelAccessor world = entity.level();
        if ((world.getFluidState(BlockPos.containing(entity.getX(), entity.getY(), entity.getZ())).createLegacyBlock()).is(BlockTags.create(ResourceLocation.fromNamespaceAndPath("minecraft", "water_block")))) {
Timeout.create(20, () -> entity.setDeltaMovement(new Vec3(0, 1, 0)));
}
    }

	@Override
	public boolean isDurationEffectTick(int duration, int amplifier) {
		return true;
	}
}
