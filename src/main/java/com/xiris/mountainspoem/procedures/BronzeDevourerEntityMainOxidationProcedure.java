package com.xiris.mountainspoem.procedures;

import com.xiris.mountainspoem.entity.BronzeDevourerEntity;
import net.minecraft.network.chat.Component;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.Level;

public class BronzeDevourerEntityMainOxidationProcedure {
    public static void execute(BronzeDevourerEntity entity) {
        if (entity == null || entity.level().isClientSide()) return;

        Level world = entity.level();
        RandomSource random = world.random;

        if (entity.getPersistentData().getBoolean("Waxed"))
            return;

        if (entity.getPersistentData().getBoolean("Weathered"))
            return;

        if (random.nextFloat() < 1.0F / 300.0F) {
            if (canOxidize(entity, world)) {
                upgradeOxidation(entity);
            }
        }

        if (!entity.getDisplayName().equals(Component.translatable("entity.mountains_poem.bronze_devourer"))
                || entity.getPersistentData().getBoolean("Weathered")
                || entity.getPersistentData().getBoolean("Exposed"))
        {
            Refresh(entity);
        }
    }

    public static void Refresh(BronzeDevourerEntity entity) {
        if (entity.level().isClientSide()) return;

        if (entity.getPersistentData().getBoolean("Weathered")) {
            entity.setCustomName(Component.translatable("entity.mountains_poem.bronze_devourer.weathered"));
            entity.setTexture("bronze_devourer_statue_3");
        }
        else if (entity.getPersistentData().getBoolean("Exposed")) {
            entity.setCustomName(Component.translatable("entity.mountains_poem.bronze_devourer.exposed"));
            entity.setTexture("bronze_devourer_statue_2");
        }
        else {
            entity.setCustomName(Component.nullToEmpty(""));
            entity.setTexture("bronze_devourer_statue");
        }
    }

    private static void upgradeOxidation(BronzeDevourerEntity entity) {
        if (entity.getPersistentData().getBoolean("Exposed")) {
            entity.getPersistentData().putBoolean("Weathered", true);
        }
        else {
            entity.getPersistentData().putBoolean("Exposed", true);
        }
    }

    private static boolean canOxidize(BronzeDevourerEntity entity, Level world) {
        int range = 4;
        long nearbyHigher = entity.level().getEntitiesOfClass(
                BronzeDevourerEntity.class,
                entity.getBoundingBox().inflate(range),
                e -> e != entity && !e.getPersistentData().getBoolean("Waxed")
        ).stream().filter(e -> {
            boolean thisExposed = entity.getPersistentData().getBoolean("Exposed");
            boolean thisWeathered = entity.getPersistentData().getBoolean("Weathered");
            boolean eExposed = e.getPersistentData().getBoolean("Exposed");
            boolean eWeathered = e.getPersistentData().getBoolean("Weathered");

            if (!thisExposed && eExposed) return true;
            return !thisWeathered && eWeathered;
        }).count();

        return nearbyHigher == 0;
    }
}