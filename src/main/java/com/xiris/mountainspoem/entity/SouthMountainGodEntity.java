package com.xiris.mountainspoem.entity;

import com.xiris.mountainspoem.MountainsPoemMod;
import com.xiris.mountainspoem.init.*;
import com.xiris.mountainspoem.init.*;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerBossEvent;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.control.FlyingMoveControl;
import net.minecraft.world.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.world.entity.ai.goal.RandomLookAroundGoal;
import net.minecraft.world.entity.ai.goal.RandomStrollGoal;
import net.minecraft.world.entity.ai.goal.RandomSwimmingGoal;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.ai.navigation.FlyingPathNavigation;
import net.minecraft.world.entity.ai.navigation.PathNavigation;
import net.minecraft.world.entity.boss.enderdragon.EnderDragon;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.monster.EnderMan;
import net.minecraft.world.entity.monster.Phantom;
import net.minecraft.world.entity.monster.Skeleton;
import net.minecraft.world.entity.monster.Spider;
import net.minecraft.world.entity.monster.Zombie;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.ThrownPotion;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.storage.loot.LootParams;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;
import net.minecraft.world.level.storage.loot.parameters.LootContextParams;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.network.PlayMessages;
import net.minecraftforge.registries.ForgeRegistries;
import software.bernie.geckolib.animatable.GeoEntity;
import software.bernie.geckolib.core.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.core.animation.AnimatableManager;
import software.bernie.geckolib.core.animation.AnimationController;
import software.bernie.geckolib.core.animation.AnimationState;
import software.bernie.geckolib.core.animation.RawAnimation;
import software.bernie.geckolib.core.object.PlayState;
import software.bernie.geckolib.util.GeckoLibUtil;

import java.util.Comparator;
import java.util.List;
import java.util.Objects;

public class SouthMountainGodEntity extends PathfinderMob implements GeoEntity {
    public static final EntityDataAccessor<Boolean> SHOOT = SynchedEntityData.defineId(SouthMountainGodEntity.class, EntityDataSerializers.BOOLEAN);
    public static final EntityDataAccessor<String> ANIMATION = SynchedEntityData.defineId(SouthMountainGodEntity.class, EntityDataSerializers.STRING);
    public static final EntityDataAccessor<String> TEXTURE = SynchedEntityData.defineId(SouthMountainGodEntity.class, EntityDataSerializers.STRING);
    private final AnimatableInstanceCache cache = GeckoLibUtil.createInstanceCache(this);
    private boolean swinging;
    private boolean lastloop;
    private long lastSwing;
    public String animationprocedure = "empty";
    private final ServerBossEvent bossInfo = new ServerBossEvent(this.getDisplayName(), ServerBossEvent.BossBarColor.GREEN, ServerBossEvent.BossBarOverlay.NOTCHED_10);

    public SouthMountainGodEntity(EntityType<SouthMountainGodEntity> type, Level world) {
        super(type, world);
        this.xpReward = 45;
        this.setNoAi(false);
        this.setPersistenceRequired();
        this.moveControl = new FlyingMoveControl(this, 10, true);
    }

    public SouthMountainGodEntity(PlayMessages.SpawnEntity packet, Level world) {
        this(MountainsPoemModEntities.SOUTH_MOUNTAIN_GOD.get(), world);
    }

    @Override
    protected void defineSynchedData() {
        super.defineSynchedData();
        this.entityData.define(SHOOT, false);
        this.entityData.define(ANIMATION, "undefined");
        this.entityData.define(TEXTURE, "south_god_1");
    }

    public void setTexture(String texture) {
        this.entityData.set(TEXTURE, texture);
    }

    public String getTexture() {
        return this.entityData.get(TEXTURE);
    }

    @Override
    protected PathNavigation createNavigation(Level world) {
        return new FlyingPathNavigation(this, world);
    }

    @Override
    protected void registerGoals() {
        super.registerGoals();
        this.goalSelector.addGoal(1, new MeleeAttackGoal(this, 1.2, true) {
            @Override
            protected double getAttackReachSqr(LivingEntity entity) {
                return 3600;
            }
        });
        this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, Zombie.class, false, true));
        this.targetSelector.addGoal(3, new NearestAttackableTargetGoal<>(this, Skeleton.class, false, true));
        this.targetSelector.addGoal(4, new NearestAttackableTargetGoal<>(this, Spider.class, false, true));
        this.targetSelector.addGoal(5, new NearestAttackableTargetGoal<>(this, Phantom.class, false, true));
        this.targetSelector.addGoal(6, new NearestAttackableTargetGoal<>(this, EnderMan.class, false, true));
        this.targetSelector.addGoal(7, new NearestAttackableTargetGoal<>(this, EnderDragon.class, false, true));
        this.targetSelector.addGoal(8, new HurtByTargetGoal(this).setAlertOthers());
        this.goalSelector.addGoal(9, new RandomStrollGoal(this, 1.0D, 20));
        this.goalSelector.addGoal(10, new RandomStrollGoal(this, 1, 20) {
            @Override
            protected Vec3 getPosition() {
                RandomSource random = SouthMountainGodEntity.this.getRandom();
                double dir_x = SouthMountainGodEntity.this.getX() + ((random.nextFloat() * 2 - 1) * 16);
                double dir_y = SouthMountainGodEntity.this.getY() + ((random.nextFloat() * 2 - 1) * 16);
                double dir_z = SouthMountainGodEntity.this.getZ() + ((random.nextFloat() * 2 - 1) * 16);
                return new Vec3(dir_x, dir_y, dir_z);
            }
        });
        this.goalSelector.addGoal(11, new RandomSwimmingGoal(this, 1.2, 40));
        this.goalSelector.addGoal(12, new RandomLookAroundGoal(this));
    }

    @Override
    public MobType getMobType() {
        return MobType.UNDEFINED;
    }

    @Override
    public boolean removeWhenFarAway(double distanceToClosestPlayer) {
        return false;
    }

    @Override
    public SoundEvent getAmbientSound() {
        return ForgeRegistries.SOUND_EVENTS.getValue(ResourceLocation.fromNamespaceAndPath(MountainsPoemMod.MOD_ID,"south_god"));
    }

    @Override
    public void playStepSound(BlockPos pos, BlockState blockIn) {
        this.playSound(Objects.requireNonNull(ForgeRegistries.SOUND_EVENTS.getValue(ResourceLocation.fromNamespaceAndPath(MountainsPoemMod.MOD_ID, "south_god_step"))), 0.15f, 1);
    }

    @Override
    public SoundEvent getHurtSound(DamageSource ds) {
        return ForgeRegistries.SOUND_EVENTS.getValue(ResourceLocation.fromNamespaceAndPath(MountainsPoemMod.MOD_ID,"south_god_hurt"));
    }

    @Override
    public SoundEvent getDeathSound() {
        return ForgeRegistries.SOUND_EVENTS.getValue(ResourceLocation.fromNamespaceAndPath(MountainsPoemMod.MOD_ID,"south_god_dead"));
    }

    @Override
    public boolean causeFallDamage(float l, float d, DamageSource source) {
        return false;
    }

    @Override
    public boolean hurt(DamageSource source, float amount) {
        LevelAccessor world = this.level();
        double x = this.getX();
        double y = this.getY();
        double z = this.getZ();
        if (world instanceof ServerLevel _level) {
            _level.sendParticles(MountainsPoemModParticleTypes.SACRIFICE_C.get(), x, y, z, 5, 3, 3, 3, 1);
            _level.sendParticles(MountainsPoemModParticleTypes.SACRIFICE_D.get(), x, y, z, 5, 3, 3, 3, 1);
        }
        final Vec3 _center = new Vec3(x, y, z);
        List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(40d / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
        for (Entity entityiterator : _entfound) {
            if (entityiterator instanceof LivingEntity _entity && !_entity.level().isClientSide())
                _entity.addEffect(new MobEffectInstance(MobEffects.GLOWING, 60, 1));
            entityiterator.setInvisible(false);
            if (Math.random() < 0.7)
                if (entityiterator instanceof LivingEntity _entity && !_entity.level().isClientSide())
                    _entity.addEffect(new MobEffectInstance(MountainsPoemModMobEffects.RESENTMENT_OF_THE_SOUTHERN_MOUNTAINS_GOD.get(), 2000, 0));
        }
        if (!this.level().isClientSide())
            this.addEffect(new MobEffectInstance(MountainsPoemModMobEffects.RESENTMENT_OF_THE_SOUTHERN_MOUNTAINS_GOD.get(), 60, 0, false, false));
        if (source.is(DamageTypes.IN_FIRE))
            return false;
        if (source.getDirectEntity() instanceof ThrownPotion)
            return false;
        if (source.is(DamageTypes.FALL))
            return false;
        if (source.is(DamageTypes.CACTUS))
            return false;
        if (source.is(DamageTypes.DROWN))
            return false;
        if (source.is(DamageTypes.LIGHTNING_BOLT))
            return false;
        if (source.is(DamageTypes.EXPLOSION))
            return false;
        if (source.is(DamageTypes.FALLING_ANVIL))
            return false;
        if (source.is(DamageTypes.WITHER))
            return false;
        if (source.is(DamageTypes.WITHER_SKULL))
            return false;
        return super.hurt(source, amount);
    }

    @Override
    public void die(DamageSource source) {
        super.die(source);
        LevelAccessor world = this.level();
        double x = getX();
        double y = getY();
        double z = getZ();

        if (world instanceof ServerLevel serverLevel) {
            serverLevel.addFreshEntity(new ExperienceOrb(serverLevel, x, y, z, 150));

            String suffix = switch (getTexture()) {
                case "south_god_1" -> "_1";
                case "south_god_1b" -> "_1b";
                case "south_god_1c" -> "_1c";
                case "south_god_1d" -> "_1d";
                case "south_god_1e" -> "_1e";
                default -> "";
            };

            ResourceLocation lootTable = ResourceLocation.fromNamespaceAndPath(MountainsPoemMod.MOD_ID, "entities/first_sm" + suffix);
            LootParams params = new LootParams.Builder(serverLevel)
                    .withParameter(LootContextParams.ORIGIN, new Vec3(x, y, z))
                    .withParameter(LootContextParams.THIS_ENTITY, this)
                    .create(LootContextParamSets.CHEST);

            serverLevel.getServer().getLootData().getLootTable(lootTable)
                    .getRandomItems(params)
                    .forEach(stack -> serverLevel.addFreshEntity(new ItemEntity(serverLevel, x, y, z, stack)));

            serverLevel.sendParticles(
                    MountainsPoemModParticleTypes.SACRIFICE_A.get(),
                    x, y, z,
                    Mth.nextInt(random, 10, 18),
                    5, 5, 5, 1
            );

            // 召唤闪电
            LightningBolt lightning = EntityType.LIGHTNING_BOLT.create(serverLevel);
            if (lightning != null) {
                lightning.moveTo(x, y, z);
                serverLevel.addFreshEntity(lightning);
            }
        }
    }

    @Override
    public void addAdditionalSaveData(CompoundTag compound) {
        super.addAdditionalSaveData(compound);
        compound.putString("Texture", this.getTexture());
    }

    @Override
    public void readAdditionalSaveData(CompoundTag compound) {
        super.readAdditionalSaveData(compound);
        if (compound.contains("Texture"))
            this.setTexture(compound.getString("Texture"));
    }

    @Override
    public InteractionResult mobInteract(Player sourceentity, InteractionHand hand) {
        ItemStack itemstack = sourceentity.getItemInHand(hand);
        InteractionResult retval = InteractionResult.sidedSuccess(this.level().isClientSide());
        super.mobInteract(sourceentity, hand);
        double x = getX();
        double y = getY();
        double z = getZ();
        Level world = level();

        if (sourceentity.getMainHandItem().is(MountainsPoemModItems.TEETH_GRAVER.get()) &&
                sourceentity.getOffhandItem().is(MountainsPoemModItems.XUAN_SHELLS.get())) {
            sourceentity.swing(InteractionHand.MAIN_HAND, true);

            if (world instanceof ServerLevel serverLevel) {
                ItemStack reward = switch (getTexture()) {
                    case "south_god_1b" -> MountainsPoemModItems.GANLIN_ENGRAVED_XUAN_SHELLS.get().getDefaultInstance();
                    case "south_god_1d" -> MountainsPoemModItems.DAZZLING_STAR_ENGRAVED_XUAN_SHELLS.get().getDefaultInstance();
                    case "south_god_1e" -> MountainsPoemModItems.RUST_ENGRAVED_XUAN_SHELLS.get().getDefaultInstance();
                    case "south_god_1" -> MountainsPoemModItems.SCINTILLATION_ENGRAVED_XUAN_SHELLS.get().getDefaultInstance();
                    case "south_god_1f" -> MountainsPoemModItems.SCARLET_TWILIGHT_ENGRAVED_XUAN_SHELLS.get().getDefaultInstance();
                    case "south_god_1c" -> MountainsPoemModItems.DUSTY_SOIL_ENGRAVED_XUAN_SHELLS.get().getDefaultInstance();
                    default -> ItemStack.EMPTY;
                };

                if (!reward.isEmpty()) {
                    sourceentity.getOffhandItem().shrink(1);
                    serverLevel.addFreshEntity(new ItemEntity(serverLevel, x, y, z, reward));
                }
            }

            world.playSound(null, x, y, z, MountainsPoemModSounds.CARVED_SHELLS.get(), sourceentity.getSoundSource(), 1, 1);

            if (!sourceentity.getAbilities().instabuild) {
                ItemStack stack = sourceentity.getMainHandItem();
                if (stack.hurt(1, RandomSource.create(), null)) {
                    stack.shrink(1);
                    stack.setDamageValue(0);
                }
            }
        }

        if (sourceentity.getMainHandItem().is(ForgeRegistries.ITEMS.tags().createTagKey(ResourceLocation.fromNamespaceAndPath(MountainsPoemMod.MOD_ID, "jade"))) &&
                sourceentity.getMainHandItem().getCount() >= 32) {

            if (world instanceof ServerLevel serverLevel) {
                if (getTexture().equals("south_god_1b")) {
                    sourceentity.getOffhandItem().shrink(Mth.nextInt(random, 16, 32));
                    if (random.nextDouble() < 0.3) {
                        world.getLevelData().setRaining(!world.getLevelData().isRaining());
                    } else {
                        serverLevel.sendParticles(MountainsPoemModParticleTypes.SACRIFICE_R.get(), x, y, z, 8, 3, 3, 3, 1);
                    }
                }

                if (getTexture().equals("south_god_1d")) {
                    sourceentity.getOffhandItem().shrink(Mth.nextInt(random, 16, 32));
                    if (random.nextDouble() < 0.3) {
                        ResourceLocation loot = ResourceLocation.fromNamespaceAndPath(MountainsPoemMod.MOD_ID, "gameplay/seeds");
                        LootParams params = new LootParams.Builder(serverLevel)
                                .withParameter(LootContextParams.ORIGIN, new Vec3(x, y, z))
                                .create(LootContextParamSets.CHEST);
                        serverLevel.getServer().getLootData().getLootTable(loot)
                                .getRandomItems(params)
                                .forEach(stack -> serverLevel.addFreshEntity(new ItemEntity(serverLevel, x, y, z, stack)));
                    } else {
                        serverLevel.sendParticles(MountainsPoemModParticleTypes.SACRIFICE_R.get(), x, y, z, 8, 3, 3, 3, 1);
                    }
                }

                if (getTexture().equals("south_god_1e")) {
                    sourceentity.getOffhandItem().shrink(Mth.nextInt(random, 16, 32));
                    if (random.nextDouble() < 0.3) {
                        addEffect(new MobEffectInstance(MobEffects.DAMAGE_BOOST, 3000, 1));
                        addEffect(new MobEffectInstance(MobEffects.HEALTH_BOOST, 1200, 1));
                    } else {
                        serverLevel.sendParticles(MountainsPoemModParticleTypes.SACRIFICE_R.get(), x, y, z, 8, 3, 3, 3, 1);
                    }
                }

                if (getTexture().equals("south_god_1") && !world.isClientSide()) {
                    addEffect(new MobEffectInstance(MobEffects.DAMAGE_BOOST, 1200, 1));
                    addEffect(new MobEffectInstance(MobEffects.LUCK, 1200, 1));
                }

                if (getTexture().equals("south_god_1c") && !world.isClientSide()) {
                    addEffect(new MobEffectInstance(MountainsPoemModMobEffects.LUSH.get(), 3000, 1));
                }
            }

            world.playSound(null, x, y, z, MountainsPoemModSounds.CARVED_SHELLS.get(), sourceentity.getSoundSource(), 1, 1);

            if (world instanceof ServerLevel serverLevel) {
                serverLevel.sendParticles(MountainsPoemModParticleTypes.XIANGYUN.get(), x, y, z, 8, 2, 2, 2, 1);

                if (random.nextDouble() < 0.1) {
                    discard();
                    LightningBolt lightning = EntityType.LIGHTNING_BOLT.create(serverLevel);
                    if (lightning != null) {
                        lightning.moveTo(x, y, z);
                        serverLevel.addFreshEntity(lightning);
                    }
                }
            }
        }

        return retval;
    }

    @Override
    public void baseTick() {
        super.baseTick();
        this.refreshDimensions();
    }

    @Override
    public EntityDimensions getDimensions(Pose p_33597_) {
        return super.getDimensions(p_33597_).scale(1);
    }

    @Override
    public boolean canChangeDimensions() {
        return false;
    }

    @Override
    public void startSeenByPlayer(ServerPlayer player) {
        super.startSeenByPlayer(player);
        this.bossInfo.addPlayer(player);
    }

    @Override
    public void stopSeenByPlayer(ServerPlayer player) {
        super.stopSeenByPlayer(player);
        this.bossInfo.removePlayer(player);
    }

    @Override
    public void customServerAiStep() {
        super.customServerAiStep();
        this.bossInfo.setProgress(this.getHealth() / this.getMaxHealth());
    }

    @Override
    protected void checkFallDamage(double y, boolean onGroundIn, BlockState state, BlockPos pos) {
    }

    @Override
    public void setNoGravity(boolean ignored) {
        super.setNoGravity(true);
    }

    @Override
    public void aiStep() {
        super.aiStep();
        this.updateSwingTime();
        this.setNoGravity(true);
    }

    public static void init() {
    }

    public static AttributeSupplier.Builder createAttributes() {
        AttributeSupplier.Builder builder = Mob.createMobAttributes();
        builder = builder.add(Attributes.MOVEMENT_SPEED, 0.5);
        builder = builder.add(Attributes.MAX_HEALTH, 280);
        builder = builder.add(Attributes.ARMOR, 0);
        builder = builder.add(Attributes.ATTACK_DAMAGE, 35);
        builder = builder.add(Attributes.FOLLOW_RANGE, 90);
        builder = builder.add(Attributes.ATTACK_KNOCKBACK, 0.2);
        builder = builder.add(Attributes.FLYING_SPEED, 0.5);
        return builder;
    }

    private PlayState movementPredicate(AnimationState<?> event) {
        if (this.animationprocedure.equals("empty")) {
            if ((event.isMoving() || !(event.getLimbSwingAmount() > -0.15F && event.getLimbSwingAmount() < 0.15F)) && this.onGround() && !this.isAggressive()) {
                return event.setAndContinue(RawAnimation.begin().thenLoop("walk"));
            }
            if (this.isDeadOrDying()) {
                return event.setAndContinue(RawAnimation.begin().thenPlay("dead"));
            }
            if (this.isInWaterOrBubble()) {
                return event.setAndContinue(RawAnimation.begin().thenLoop("swim"));
            }
            if (this.isSprinting()) {
                return event.setAndContinue(RawAnimation.begin().thenLoop("sprint"));
            }
            if (!this.onGround()) {
                return event.setAndContinue(RawAnimation.begin().thenLoop("fly"));
            }
            if (this.isAggressive() && event.isMoving()) {
                return event.setAndContinue(RawAnimation.begin().thenLoop("sprint"));
            }
            return event.setAndContinue(RawAnimation.begin().thenLoop("idle"));
        }
        return PlayState.STOP;
    }

    private PlayState attackingPredicate(AnimationState<?> event) {
        double d1 = this.getX() - this.xOld;
        double d0 = this.getZ() - this.zOld;
        float velocity = (float) Math.sqrt(d1 * d1 + d0 * d0);
        if (this.getAttackAnim(event.getPartialTick()) > 0f && !this.swinging) {
            this.swinging = true;
            this.lastSwing = this.level().getGameTime();
        }
        if (this.swinging && this.lastSwing + 7L <= this.level().getGameTime()) {
            this.swinging = false;
        }
        if (this.swinging && event.getController().getAnimationState() == AnimationController.State.STOPPED) {
            event.getController().forceAnimationReset();
            return event.setAndContinue(RawAnimation.begin().thenPlay("attack"));
        }
        return PlayState.CONTINUE;
    }

    private PlayState procedurePredicate(AnimationState<?> event) {
        if (!this.animationprocedure.equals("empty") && event.getController().getAnimationState() == AnimationController.State.STOPPED) {
            event.getController().setAnimation(RawAnimation.begin().thenPlay(this.animationprocedure));
            if (event.getController().getAnimationState() == AnimationController.State.STOPPED) {
                this.animationprocedure = "empty";
                event.getController().forceAnimationReset();
            }
        } else if (this.animationprocedure.equals("empty")) {
            return PlayState.STOP;
        }
        return PlayState.CONTINUE;
    }

    @Override
    protected void tickDeath() {
        ++this.deathTime;
        if (this.deathTime == 20) {
            this.remove(SouthMountainGodEntity.RemovalReason.KILLED);
            this.dropExperience();
        }
    }

    public String getSyncedAnimation() {
        return this.entityData.get(ANIMATION);
    }

    public void setAnimation(String animation) {
        this.entityData.set(ANIMATION, animation);
    }

    @Override
    public void registerControllers(AnimatableManager.ControllerRegistrar data) {
        data.add(new AnimationController<>(this, "movement", 4, this::movementPredicate));
        data.add(new AnimationController<>(this, "attacking", 4, this::attackingPredicate));
        data.add(new AnimationController<>(this, "procedure", 4, this::procedurePredicate));
    }

    @Override
    public AnimatableInstanceCache getAnimatableInstanceCache() {
        return this.cache;
    }
}