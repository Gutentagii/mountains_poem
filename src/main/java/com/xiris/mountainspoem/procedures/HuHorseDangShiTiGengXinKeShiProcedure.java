package com.xiris.mountainspoem.procedures;

import com.xiris.mountainspoem.MountainsPoemMod;
import com.xiris.mountainspoem.entity.HuHorseEntity;
import com.xiris.mountainspoem.init.MountainsPoemModItems;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.common.capabilities.ForgeCapabilities;

import java.util.*;

public class HuHorseDangShiTiGengXinKeShiProcedure {
    private static final Map<UUID, Integer> PASSENGER_SHIFT_TIMER = new HashMap<>();

    public static void execute(Level world, double x, double y, double z, HuHorseEntity entity) {
        if (world.isClientSide()) return;

        ItemStack armorItem = ItemStack.EMPTY;
        var cap = entity.getCapability(ForgeCapabilities.ITEM_HANDLER);
        if (cap.isPresent()) {
            armorItem = cap.resolve().get().getStackInSlot(0);
        }

        String oldTexture = entity.getTexture();
        String newTexture;

        if (armorItem.is(MountainsPoemModItems.IRON_WATER_HORSE_ARMOR.get())) {
            newTexture = "water_horse_iron";
        } else if (armorItem.is(MountainsPoemModItems.GOLDEN_WATER_HORSE_ARMOR.get())) {
            newTexture = "water_horse_gold";
        } else if (armorItem.is(Items.SADDLE)) {
            newTexture = "water_horse_saddle";
        } else if (armorItem.is(MountainsPoemModItems.DIAMOND_WATER_HORSE_ARMOR.get())) {
            newTexture = "water_horse_diamond";
        } else if (armorItem.is(MountainsPoemModItems.NETHERITE_WATER_HORSE_ARMOR.get())) {
            newTexture = "water_horse_netherite";
        } else if (armorItem.is(MountainsPoemModItems.BLOOD_COPPER_WATER_HORSE_ARMOR.get())) {
            newTexture = "water_horse_blood_copper";
        } else {
            newTexture = "water_horse";
        }

        if (!oldTexture.equals(newTexture)) {
            entity.setTexture(newTexture);
        }

        switch (entity.getTexture()) {
            case "water_horse_diamond" -> {
                entity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 60, 3, false, false));
                entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 60, 0, false, false));
            }
            case "water_horse_iron" -> {
                entity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 60, 1, false, false));
                entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 60, 0, false, false));
            }
            case "water_horse_gold" -> {
                entity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 60, 0, false, false));
                entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 60, 0, false, false));
            }
            case "water_horse_netherite" -> {
                entity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 60, 3, false, false));
                entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 60, 1, false, false));
                entity.addEffect(new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 60, 3, false, false));
            }
            case "water_horse_blood_copper" -> {
                entity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 60, 4, false, false));
                entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 60, 1, false, false));
            }
            case "water_horse", "water_horse_saddle" ->
                    entity.removeEffect(MobEffects.DAMAGE_RESISTANCE);
        }

        boolean hasSaddleOrArmor = !entity.getTexture().equals("water_horse");

        if (entity.isTame() && !entity.isBaby() && entity.isVehicle() && hasSaddleOrArmor) {
            Vec3 _center = new Vec3(x, y, z);
            List<Entity> _entfound = world.getEntitiesOfClass(Entity.class,
                    new AABB(_center, _center).inflate(entity.getBbWidth() * 0.8d, entity.getBbHeight() * 0.5d, entity.getBbWidth() * 0.8d));
            for (Entity entityiterator : _entfound) {
                if (!(entityiterator instanceof HuHorseEntity) && entityiterator != entity.getControllingPassenger()) {
                    DamageSource damageSource = new DamageSource(world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE)
                            .getHolderOrThrow(ResourceKey.create(Registries.DAMAGE_TYPE, ResourceLocation.fromNamespaceAndPath(MountainsPoemMod.MOD_ID, "bump"))), entity);
                    if (entityiterator.getBbHeight() >= 3 && entityiterator.getBbWidth() >= 3) {
                        entityiterator.hurt(damageSource, 2);
                        entityiterator.setDeltaMovement(new Vec3(0, 0.2, 0));
                    } else {
                        entityiterator.hurt(damageSource, 8);
                        entityiterator.setDeltaMovement(new Vec3(0, 0.3, 0));
                    }
                    entity.setAnimation("crash");
                }
            }
        } else if (entity.isVehicle() && !entity.isTame()) {
            for (Entity passenger : entity.getIndirectPassengers()) {
                if (Math.random() < 0.08) {
                    if (passenger instanceof Player owner) {
                        entity.tame(owner);
                    }
                    if (world instanceof ServerLevel) {
                        ((ServerLevel) world).sendParticles(ParticleTypes.HEART, x, y + 1D, z, 5, 1, 1, 1, 0);
                    }
                } else {
                    passenger.stopRiding();
                    entity.setAnimation("play");
                    world.playSound(null, x, y, z, SoundEvents.HORSE_ANGRY, SoundSource.NEUTRAL, 1.0F, 3.0F);
                    if (world instanceof ServerLevel) {
                        ((ServerLevel) world).sendParticles(ParticleTypes.SMOKE, x, y + 1D, z, 5, 2, 2, 2, 0);
                    }
                    passenger.setShiftKeyDown(true);
                    PASSENGER_SHIFT_TIMER.put(passenger.getUUID(), 10);
                }
            }
        }
        List<UUID> removeList = new ArrayList<>();
        for (Map.Entry<UUID, Integer> entry : PASSENGER_SHIFT_TIMER.entrySet()) {
            UUID uuid = entry.getKey();
            int time = entry.getValue() - 1;
            if (time <= 0) {
                removeList.add(uuid);
            } else {
                PASSENGER_SHIFT_TIMER.put(uuid, time);
            }
        }
        for (UUID uuid : removeList) {
            PASSENGER_SHIFT_TIMER.remove(uuid);
        }
    }
}