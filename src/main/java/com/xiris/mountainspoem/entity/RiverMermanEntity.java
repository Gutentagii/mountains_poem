package com.xiris.mountainspoem.entity;

import com.xiris.mountainspoem.init.MountainsPoemModEntities;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.tags.FluidTags;
import net.minecraft.util.Mth;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.control.MoveControl;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.ai.navigation.AmphibiousPathNavigation;
import net.minecraft.world.entity.ai.navigation.PathNavigation;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraft.world.level.pathfinder.BlockPathTypes;
import net.minecraftforge.common.ForgeMod;
import net.minecraftforge.network.PlayMessages;
import net.minecraftforge.registries.ForgeRegistries;
import org.jetbrains.annotations.Nullable;
import software.bernie.geckolib.animatable.GeoEntity;
import software.bernie.geckolib.core.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.core.animation.AnimatableManager;
import software.bernie.geckolib.core.animation.AnimationController;
import software.bernie.geckolib.core.animation.AnimationState;
import software.bernie.geckolib.core.animation.RawAnimation;
import software.bernie.geckolib.core.object.PlayState;
import software.bernie.geckolib.util.GeckoLibUtil;

import java.util.Objects;


//实在不会略 这个用的素AI
public class RiverMermanEntity extends Monster implements GeoEntity {
    public static final EntityDataAccessor<Boolean> SHOOT = SynchedEntityData.defineId(RiverMermanEntity.class, EntityDataSerializers.BOOLEAN);
    public static final EntityDataAccessor<String> ANIMATION = SynchedEntityData.defineId(RiverMermanEntity.class, EntityDataSerializers.STRING);
    public static final EntityDataAccessor<String> TEXTURE = SynchedEntityData.defineId(RiverMermanEntity.class, EntityDataSerializers.STRING);
    private final AnimatableInstanceCache cache = GeckoLibUtil.createInstanceCache(this);
    private boolean swinging;
    private long lastSwing;
    public String animationprocedure = "empty";

    public RiverMermanEntity(EntityType<RiverMermanEntity> type, Level world) {
        super(type, world);
        this.xpReward = 0;
        this.setNoAi(false);
        this.setPathfindingMalus(BlockPathTypes.WATER, -1.0F);
        this.setPathfindingMalus(BlockPathTypes.WALKABLE, 0);

        this.moveControl = new MoveControl(this) {
            @Override
            public void tick() {
                if (RiverMermanEntity.this.isInWater()) {
                    RiverMermanEntity.this.setDeltaMovement(RiverMermanEntity.this.getDeltaMovement().add(0, 0.005, 0));
                    if (this.operation == MoveControl.Operation.MOVE_TO && !RiverMermanEntity.this.getNavigation().isDone()) {
                        double dx = this.wantedX - RiverMermanEntity.this.getX();
                        double dy = this.wantedY - RiverMermanEntity.this.getY();
                        double dz = this.wantedZ - RiverMermanEntity.this.getZ();
                        float f = (float) (Mth.atan2(dz, dx) * (180 / Math.PI)) - 90;
                        float f1 = (float) (this.speedModifier * RiverMermanEntity.this.getAttribute(Attributes.MOVEMENT_SPEED).getValue());
                        RiverMermanEntity.this.setYRot(this.rotlerp(RiverMermanEntity.this.getYRot(), f, 10));
                        RiverMermanEntity.this.yBodyRot = RiverMermanEntity.this.getYRot();
                        RiverMermanEntity.this.yHeadRot = RiverMermanEntity.this.getYRot();
                        RiverMermanEntity.this.setSpeed((float) RiverMermanEntity.this.getAttribute(Attributes.MOVEMENT_SPEED).getValue());
                        float f2 = -(float) (Mth.atan2(dy, (float) Math.sqrt(dx * dx + dz * dz)) * (180 / Math.PI));
                        f2 = Mth.clamp(Mth.wrapDegrees(f2), -85, 85);
                        RiverMermanEntity.this.setXRot(this.rotlerp(RiverMermanEntity.this.getXRot(), f2, 5));
                        float f3 = Mth.cos(RiverMermanEntity.this.getXRot() * (float) (Math.PI / 180.0));
                        RiverMermanEntity.this.setZza(f3 * f1);
                        RiverMermanEntity.this.setYya((float) (f1 * dy));
                    } else {
                        RiverMermanEntity.this.setSpeed(0);
                        RiverMermanEntity.this.setYya(0);
                        RiverMermanEntity.this.setZza(0);
                    }
                } else {
                    if (this.operation == MoveControl.Operation.MOVE_TO) {
                        double dx = this.wantedX - RiverMermanEntity.this.getX();
                        double dz = this.wantedZ - RiverMermanEntity.this.getZ();
                        double dy = this.wantedY - RiverMermanEntity.this.getY();
                        double dist = Math.sqrt(dx * dx + dy * dy + dz * dz);

                        if (dist < 0.25) {
                            this.mob.setZza(0);
                            return;
                        }

                        float speed = (float) (this.speedModifier * RiverMermanEntity.this.getAttribute(Attributes.MOVEMENT_SPEED).getValue());
                        RiverMermanEntity.this.setSpeed(speed);

                        float targetYaw = (float) (Mth.atan2(dz, dx) * (180 / Math.PI)) - 90;
                        RiverMermanEntity.this.setYRot(this.rotlerp(RiverMermanEntity.this.getYRot(), targetYaw, 10));
                        RiverMermanEntity.this.yBodyRot = RiverMermanEntity.this.getYRot();
                    } else {
                        RiverMermanEntity.this.setSpeed(0);
                    }
                }
            }
        };
    }

    public RiverMermanEntity(PlayMessages.SpawnEntity packet, Level world) {
        this(MountainsPoemModEntities.RIVER_MERMAN.get(), world);
    }

    @Override
    protected void defineSynchedData() {
        super.defineSynchedData();
        this.entityData.define(SHOOT, false);
        this.entityData.define(ANIMATION, "undefined");
        this.entityData.define(TEXTURE, "merman1");
    }

    public void setTexture(String texture) {
        this.entityData.set(TEXTURE, texture);
    }

    public String getTexture() {
        return this.entityData.get(TEXTURE);
    }

    @Override
    protected PathNavigation createNavigation(Level world) {
        return new AmphibiousPathNavigation(this, world);
    }

    @Override
    protected void registerGoals() {
        super.registerGoals();

        this.targetSelector.addGoal(1, new NearestAttackableTargetGoal<>(this, Player.class, 10, true, false,
                livingEntity -> {
                    if (livingEntity instanceof Player player) {
                        return !player.isCreative() && !player.isSpectator();
                    }
                    return true;
                }));

        this.targetSelector.addGoal(2, new HurtByTargetGoal(this).setAlertOthers());

        this.goalSelector.addGoal(1, new MeleeAttackGoal(this, 1.2, false) {
            @Override
            protected double getAttackReachSqr(LivingEntity entity) {
                return this.mob.getBbWidth() * 2.0F * this.mob.getBbWidth() * 2.0F + entity.getBbWidth();
            }

            @Override
            public boolean canUse() {
                LivingEntity target = this.mob.getTarget();
                if (target instanceof Player player && (player.isCreative() || player.isSpectator())) {
                    this.mob.setTarget(null);
                    return false;
                }
                return super.canUse();
            }

            @Override
            public boolean canContinueToUse() {
                LivingEntity target = this.mob.getTarget();
                if (target == null || !target.isAlive()) return false;
                if (target instanceof Player player && (player.isCreative() || player.isSpectator())) {
                    this.mob.setTarget(null);
                    return false;
                }
                return super.canContinueToUse();
            }
        });

        this.goalSelector.addGoal(2, new RandomSwimmingGoal(this, 1.0, 40));

        this.goalSelector.addGoal(3, new RandomStrollGoal(this, 1.0, 60) {
            @Override
            public boolean canUse() {
                if (RiverMermanEntity.this.isInWater() && RiverMermanEntity.this.getFluidHeight(FluidTags.WATER) > 0.5) {
                    return false;
                }
                return super.canUse();
            }
        });

        this.goalSelector.addGoal(4, new RandomLookAroundGoal(this));
    }

    @Override
    public MobType getMobType() {
        return MobType.WATER;
    }

    @Override
    public SoundEvent getHurtSound(DamageSource ds) {
        return Objects.requireNonNull(ForgeRegistries.SOUND_EVENTS.getValue(ResourceLocation.fromNamespaceAndPath("minecraft", "entity.generic.hurt")));
    }

    @Override
    public SoundEvent getDeathSound() {
        return Objects.requireNonNull(ForgeRegistries.SOUND_EVENTS.getValue(ResourceLocation.fromNamespaceAndPath("minecraft", "entity.generic.death")));
    }

    @Override
    public boolean hurt(DamageSource source, float amount) {
        if ((Entity) this instanceof RiverMermanEntity merman)
            merman.setAnimation("hurt");
        return super.hurt(source, amount);
    }

    @Override
    public void die(DamageSource source) {
        super.die(source);
    }

    @Override
    public SpawnGroupData finalizeSpawn(ServerLevelAccessor world, DifficultyInstance difficulty, MobSpawnType reason, @Nullable SpawnGroupData livingdata, @Nullable CompoundTag tag) {
        SpawnGroupData retval = super.finalizeSpawn(world, difficulty, reason, livingdata, tag);
        if ((Entity) this instanceof RiverMermanEntity animatable)
            if (Math.random() < 0.7) animatable.setTexture("merman1");
            else animatable.setTexture("merman2");
        return retval;
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
    public void baseTick() {
        super.baseTick();
        this.refreshDimensions();

    }

    @Override
    public EntityDimensions getDimensions(Pose p_33597_) {
        return super.getDimensions(p_33597_).scale((float) 1);
    }

    @Override
    public boolean canBreatheUnderwater() {
        return true;
    }

    @Override
    public boolean checkSpawnObstruction(LevelReader world) {
        return world.isUnobstructed(this);
    }

    @Override
    public boolean isPushedByFluid() {
        return false;
    }

    public static void init() {
        SpawnPlacements.register(MountainsPoemModEntities.RIVER_MERMAN.get(), SpawnPlacements.Type.IN_WATER, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES,
                (entityType, world, reason, pos, random) -> (world.getBlockState(pos).is(Blocks.WATER) && world.getBlockState(pos.above()).is(Blocks.WATER)));
    }

    public static AttributeSupplier.Builder createAttributes() {
        AttributeSupplier.Builder builder = Mob.createMobAttributes();
        builder = builder.add(Attributes.MOVEMENT_SPEED, 0.3);
        builder = builder.add(Attributes.MAX_HEALTH, 40);
        builder = builder.add(Attributes.ARMOR, 0);
        builder = builder.add(Attributes.ATTACK_DAMAGE, 5);
        builder = builder.add(Attributes.FOLLOW_RANGE, 16);
        builder = builder.add(ForgeMod.SWIM_SPEED.get(), 0.5);
        return builder;
    }

    private PlayState movementPredicate(AnimationState event) {
        if (this.animationprocedure.equals("empty")) {
            if (this.isDeadOrDying()) {
                return event.setAndContinue(RawAnimation.begin().thenPlay("dead"));
            }
            if (this.isInWaterOrBubble()) {
                return event.setAndContinue(RawAnimation.begin().thenLoop("swim"));
            }
            if (this.getDeltaMovement().horizontalDistanceSqr() > 1.0E-6D) {
                return event.setAndContinue(RawAnimation.begin().thenLoop("walk"));
            }
            return event.setAndContinue(RawAnimation.begin().thenLoop("idle"));
        }
        return PlayState.STOP;
    }

    private PlayState attackingPredicate(AnimationState event) {
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

    private PlayState procedurePredicate(AnimationState event) {
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
            this.remove(RiverMermanEntity.RemovalReason.KILLED);
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