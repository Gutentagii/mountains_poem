package com.xiris.mountainspoem.entity;

import com.xiris.mountainspoem.MountainsPoemMod;
import net.minecraft.world.entity.LightningBolt;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import com.xiris.mountainspoem.init.MountainsPoemModEntities;
import com.xiris.mountainspoem.init.MountainsPoemModItems;
import com.xiris.mountainspoem.init.MountainsPoemModMobEffects;
import com.xiris.mountainspoem.init.MountainsPoemModParticleTypes;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.RandomSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.entity.projectile.ItemSupplier;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.EntityHitResult;
import net.minecraftforge.network.PlayMessages;
import net.minecraftforge.registries.ForgeRegistries;

@OnlyIn(value = Dist.CLIENT, _interface = ItemSupplier.class)
public class PlagueBallEntity extends AbstractArrow implements ItemSupplier {
	public static final ItemStack PROJECTILE_ITEM = new ItemStack(MountainsPoemModItems.PLAGUE_HORN.get());

	public PlagueBallEntity(EntityType<? extends PlagueBallEntity> type, Level world) {
		super(type, world);
	}

    public PlagueBallEntity(PlayMessages.SpawnEntity packet, Level world) {
        this(MountainsPoemModEntities.PLAGUE_BALL.get(), world);
    }

	public PlagueBallEntity(EntityType<? extends PlagueBallEntity> type, double x, double y, double z, Level world) {
		super(type, x, y, z, world);
	}

	public PlagueBallEntity(EntityType<? extends PlagueBallEntity> type, LivingEntity entity, Level world) {
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
		if (entityHitResult.getEntity() instanceof LivingEntity _entity && !_entity.level().isClientSide())
			_entity.addEffect(new MobEffectInstance(MountainsPoemModMobEffects.PESTILENCE.get(), 60, 1));
	}

	@Override
	public void onHitBlock(BlockHitResult blockHitResult) {
		super.onHitBlock(blockHitResult);
		LevelAccessor world = this.level();
		double x = blockHitResult.getBlockPos().getX();
		double y = blockHitResult.getBlockPos().getY();
		double z = blockHitResult.getBlockPos().getZ();
        if (!world.isClientSide() && world instanceof ServerLevel serverLevel) {
            LightningBolt lightning = EntityType.LIGHTNING_BOLT.create(serverLevel);
            if (lightning != null) {
                lightning.moveTo(x, y, z);
                serverLevel.addFreshEntity(lightning);
            }
        }
	}

	@Override
	public void tick() {
		super.tick();
        LevelAccessor world = this.level();
        if (world instanceof ServerLevel _level)
            _level.sendParticles(MountainsPoemModParticleTypes.PLAGUES.get(), this.getX(), this.getY(), this.getZ(), 5, 3, 3, 3, 1);
        if (this.inGround)
			this.discard();
	}

	public static PlagueBallEntity shoot(Level world, LivingEntity entity, RandomSource source) {
		return shoot(world, entity, source, 1.8f, 5.1, 10);
	}

	public static PlagueBallEntity shoot(Level world, LivingEntity entity, RandomSource source, float pullingPower) {
		return shoot(world, entity, source, pullingPower * 1.8f, 5.1, 10);
	}

	public static PlagueBallEntity shoot(Level world, LivingEntity entity, RandomSource random, float power, double damage, int knockback) {
		PlagueBallEntity entityarrow = new PlagueBallEntity(MountainsPoemModEntities.PLAGUE_BALL.get(), entity, world);
		entityarrow.shoot(entity.getViewVector(1).x, entity.getViewVector(1).y, entity.getViewVector(1).z, power * 2, 0);
		entityarrow.setSilent(true);
		entityarrow.setCritArrow(false);
		entityarrow.setBaseDamage(damage);
		entityarrow.setKnockback(knockback);
		entityarrow.setSecondsOnFire(100);
		world.addFreshEntity(entityarrow);
		world.playSound(null, entity.getX(), entity.getY(), entity.getZ(), ForgeRegistries.SOUND_EVENTS.getValue(ResourceLocation.fromNamespaceAndPath(MountainsPoemMod.MOD_ID,"fei_bull")), SoundSource.PLAYERS, 1, 1f / (random.nextFloat() * 0.5f + 1) + (power / 2));
		return entityarrow;
	}

	public static PlagueBallEntity shoot(LivingEntity entity, LivingEntity target) {
		PlagueBallEntity entityarrow = new PlagueBallEntity(MountainsPoemModEntities.PLAGUE_BALL.get(), entity, entity.level());
		double dx = target.getX() - entity.getX();
		double dy = target.getY() + target.getEyeHeight() - 1.1;
		double dz = target.getZ() - entity.getZ();
		entityarrow.shoot(dx, dy - entityarrow.getY() + Math.hypot(dx, dz) * 0.2F, dz, 1.8f * 2, 12.0F);
		entityarrow.setSilent(true);
		entityarrow.setBaseDamage(5.1);
		entityarrow.setKnockback(10);
		entityarrow.setCritArrow(false);
		entityarrow.setSecondsOnFire(100);
		entity.level().addFreshEntity(entityarrow);
		entity.level().playSound(null, entity.getX(), entity.getY(), entity.getZ(), ForgeRegistries.SOUND_EVENTS.getValue(ResourceLocation.fromNamespaceAndPath(MountainsPoemMod.MOD_ID,"fei_bull")), SoundSource.PLAYERS, 1, 1f / (RandomSource.create().nextFloat() * 0.5f + 1));
		return entityarrow;
	}
}
