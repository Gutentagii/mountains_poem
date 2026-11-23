package com.xiris.mountainspoem.entity;

import com.xiris.mountainspoem.MountainsPoemMod;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import com.xiris.mountainspoem.init.MountainsPoemModEntities;
import com.xiris.mountainspoem.init.MountainsPoemModItems;
import com.xiris.mountainspoem.init.MountainsPoemModMobEffects;
import net.minecraft.advancements.Advancement;
import net.minecraft.advancements.AdvancementProgress;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.RandomSource;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.entity.projectile.ItemSupplier;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.EntityHitResult;
import net.minecraftforge.network.PlayMessages;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.Objects;

@OnlyIn(value = Dist.CLIENT, _interface = ItemSupplier.class)
public class GhostCordageEntity extends AbstractArrow implements ItemSupplier {
    public static final ItemStack PROJECTILE_ITEM = new ItemStack(MountainsPoemModItems.RESENTFUL_LEAD.get());

    public GhostCordageEntity(EntityType<? extends GhostCordageEntity> type, Level world) {
        super(type, world);
    }

    public GhostCordageEntity(PlayMessages.SpawnEntity packet, Level world) {
        this(MountainsPoemModEntities.GHOST_CORDAGE.get(), world);
    }

    public GhostCordageEntity(EntityType<? extends GhostCordageEntity> type, double x, double y, double z, Level world) {
        super(type, x, y, z, world);
    }

    public GhostCordageEntity(EntityType<? extends GhostCordageEntity> type, LivingEntity entity, Level world) {
        super(type, entity, world);
    }

    @Override
    @OnlyIn(Dist.CLIENT)
    public ItemStack getItem() {
        return PROJECTILE_ITEM;
    }

    @Override
    protected ItemStack getPickupItem() {
        return PROJECTILE_ITEM;
    }

    @Override
    protected void doPostHurtEffects(LivingEntity entity) {
        super.doPostHurtEffects(entity);
        entity.setArrowCount(entity.getArrowCount() - 1);
    }

    @Override
    public void onHitEntity(EntityHitResult entityHitResult) {
        super.onHitEntity(entityHitResult);
        LevelAccessor world = this.level();
        Entity entity = entityHitResult.getEntity();
        entity.hurt(new DamageSource(world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(DamageTypes.GENERIC)), 3);
        if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
            _entity.addEffect(new MobEffectInstance(MountainsPoemModMobEffects.SUFFOCATE.get(), 420, 2));
        if (entity instanceof ServerPlayer _player) {
            Advancement advancement = _player.server.getAdvancements().getAdvancement(ResourceLocation.fromNamespaceAndPath(MountainsPoemMod.MOD_ID,"hanged"));
            AdvancementProgress ap = null;
            if (advancement != null) {
                ap = _player.getAdvancements().getOrStartProgress(advancement);
            }
            if (ap != null && !ap.isDone()) for (String criteria : ap.getRemainingCriteria())
                _player.getAdvancements().award(advancement, criteria);
        }
    }

    @Override
    public void tick() {
        super.tick();
        if (this.inGround)
            this.discard();
    }

    public static GhostCordageEntity shoot(Level world, LivingEntity entity, RandomSource source) {
        return shoot(world, entity, source, 1f, 2, 5);
    }

    public static GhostCordageEntity shoot(Level world, LivingEntity entity, RandomSource source, float pullingPower) {
        return shoot(world, entity, source, pullingPower, 2, 5);
    }

    public static GhostCordageEntity shoot(Level world, LivingEntity entity, RandomSource random, float power, double damage, int knockback) {
        GhostCordageEntity entityarrow = new GhostCordageEntity(MountainsPoemModEntities.GHOST_CORDAGE.get(), entity, world);
        entityarrow.shoot(entity.getViewVector(1).x, entity.getViewVector(1).y, entity.getViewVector(1).z, power * 2, 0);
        entityarrow.setSilent(true);
        entityarrow.setCritArrow(true);
        entityarrow.setBaseDamage(damage);
        entityarrow.setKnockback(knockback);
        world.addFreshEntity(entityarrow);
        world.playSound(null, entity.getX(), entity.getY(), entity.getZ(), Objects.requireNonNull(ForgeRegistries.SOUND_EVENTS.getValue(ResourceLocation.fromNamespaceAndPath("minecraft", "block.mud.fall"))), SoundSource.PLAYERS, 1, 1f / (random.nextFloat() * 0.5f + 1) + (power / 2));
        return entityarrow;
    }

    public static GhostCordageEntity shoot(LivingEntity entity, LivingEntity target) {
        GhostCordageEntity entityarrow = new GhostCordageEntity(MountainsPoemModEntities.GHOST_CORDAGE.get(), entity, entity.level());
        double dx = target.getX() - entity.getX();
        double dy = target.getY() + target.getEyeHeight() - 1.1;
        double dz = target.getZ() - entity.getZ();
        entityarrow.shoot(dx, dy - entityarrow.getY() + Math.hypot(dx, dz) * 0.2F, dz, 1f * 2, 12.0F);
        entityarrow.setSilent(true);
        entityarrow.setBaseDamage(2);
        entityarrow.setKnockback(5);
        entityarrow.setCritArrow(true);
        entity.level().addFreshEntity(entityarrow);
        entity.level().playSound(null, entity.getX(), entity.getY(), entity.getZ(), Objects.requireNonNull(ForgeRegistries.SOUND_EVENTS.getValue(ResourceLocation.fromNamespaceAndPath("minecraft", "block.mud.fall"))), SoundSource.PLAYERS, 1, 1f / (RandomSource.create().nextFloat() * 0.5f + 1));
        return entityarrow;
    }
}
