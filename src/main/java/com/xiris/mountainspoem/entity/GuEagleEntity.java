package com.xiris.mountainspoem.entity;

import com.xiris.mountainspoem.MountainsPoemMod;
import com.xiris.mountainspoem.init.MountainsPoemModEntities;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.Difficulty;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.control.FlyingMoveControl;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.ai.navigation.FlyingPathNavigation;
import net.minecraft.world.entity.ai.navigation.PathNavigation;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraft.world.phys.Vec3;
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

import java.util.EnumSet;

public class GuEagleEntity extends Animal implements GeoEntity {
	public static final EntityDataAccessor<Boolean> SHOOT = SynchedEntityData.defineId(GuEagleEntity.class, EntityDataSerializers.BOOLEAN);
	public static final EntityDataAccessor<String> ANIMATION = SynchedEntityData.defineId(GuEagleEntity.class, EntityDataSerializers.STRING);
	public static final EntityDataAccessor<String> TEXTURE = SynchedEntityData.defineId(GuEagleEntity.class, EntityDataSerializers.STRING);
	private final AnimatableInstanceCache cache = GeckoLibUtil.createInstanceCache(this);
	private boolean swinging;
	private boolean lastloop;
	private long lastSwing;
	public String animationprocedure = "empty";

	public GuEagleEntity(EntityType<GuEagleEntity> type, Level world) {
		super(type, world);
        this.xpReward = 0;
        this.setNoAi(false);
		this.moveControl = new FlyingMoveControl(this, 10, true);
	}

    public GuEagleEntity(PlayMessages.SpawnEntity packet, Level world) {
        this(MountainsPoemModEntities.GU_EAGLE.get(), world);
    }

	@Override
	protected void defineSynchedData() {
		super.defineSynchedData();
		this.entityData.define(SHOOT, false);
		this.entityData.define(ANIMATION, "undefined");
		this.entityData.define(TEXTURE, "gu_diao");
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
        this.goalSelector.addGoal(1, new RandomLookAroundGoal(this));
        this.targetSelector.addGoal(2, new HurtByTargetGoal(this).setAlertOthers());

        this.goalSelector.addGoal(3, new Goal() {
            {
                this.setFlags(EnumSet.of(Goal.Flag.MOVE));
            }

            public boolean canUse() {
                LivingEntity target = GuEagleEntity.this.getTarget();
                if (target == null) return false;
                if (target instanceof Player player && (player.isCreative() || player.isSpectator())) {
                    GuEagleEntity.this.setTarget(null);
                    return false;
                }
                return !GuEagleEntity.this.getMoveControl().hasWanted();
            }

            @Override
            public boolean canContinueToUse() {
                LivingEntity target = GuEagleEntity.this.getTarget();
                if (target == null || !target.isAlive()) return false;
                if (target instanceof Player player && (player.isCreative() || player.isSpectator())) {
                    GuEagleEntity.this.setTarget(null);
                    return false;
                }
                return GuEagleEntity.this.getMoveControl().hasWanted();
            }

            @Override
            public void start() {
                LivingEntity livingentity = GuEagleEntity.this.getTarget();
                if (livingentity == null) return;
                Vec3 vec3d = livingentity.getEyePosition(1);
                GuEagleEntity.this.moveControl.setWantedPosition(vec3d.x, vec3d.y, vec3d.z, 1.6);
            }

            @Override
            public void tick() {
                LivingEntity livingentity = GuEagleEntity.this.getTarget();
                if (livingentity == null) return;

                if (livingentity instanceof Player player && (player.isCreative() || player.isSpectator())) {
                    GuEagleEntity.this.setTarget(null);
                    return;
                }

                if (GuEagleEntity.this.getBoundingBox().intersects(livingentity.getBoundingBox())) {
                    GuEagleEntity.this.doHurtTarget(livingentity);
                } else {
                    double d0 = GuEagleEntity.this.distanceToSqr(livingentity);
                    if (d0 < 32) {
                        Vec3 vec3d = livingentity.getEyePosition(1);
                        GuEagleEntity.this.moveControl.setWantedPosition(vec3d.x, vec3d.y, vec3d.z, 1.6);
                    }
                }
            }
        });

        this.targetSelector.addGoal(4, new NearestAttackableTargetGoal<>(this, Player.class, 10, true, false, null) {
            @Override
            public boolean canUse() {
                LivingEntity target = this.mob.getTarget();
                if (target instanceof Player player && (player.isCreative() || player.isSpectator())) {
                    return false;
                }
                return super.canUse();
            }

            @Override
            public boolean canContinueToUse() {
                LivingEntity target = this.mob.getTarget();
                if (target instanceof Player player && (player.isCreative() || player.isSpectator())) {
                    return false;
                }
                return super.canContinueToUse();
            }
        });

        this.targetSelector.addGoal(5, new NearestAttackableTargetGoal<>(this, ServerPlayer.class, 10, true, false, null) {
            @Override
            public boolean canUse() {
                LivingEntity target = this.mob.getTarget();
                if (target instanceof Player player && (player.isCreative() || player.isSpectator())) {
                    return false;
                }
                return super.canUse();
            }

            @Override
            public boolean canContinueToUse() {
                LivingEntity target = this.mob.getTarget();
                if (target instanceof Player player && (player.isCreative() || player.isSpectator())) {
                    return false;
                }
                return super.canContinueToUse();
            }
        });

        this.targetSelector.addGoal(6, new NearestAttackableTargetGoal<>(this, LeiEntity.class, false, true));
        this.targetSelector.addGoal(7, new NearestAttackableTargetGoal<>(this, FenghuangPhoenixEntity.class, false, true));

        this.goalSelector.addGoal(8, new RandomStrollGoal(this, 1, 20) {
            @Override
            protected Vec3 getPosition() {
                RandomSource random = GuEagleEntity.this.getRandom();
                double dir_x = GuEagleEntity.this.getX() + ((random.nextFloat() * 2 - 1) * 16);
                double dir_y = GuEagleEntity.this.getY() + ((random.nextFloat() * 2 - 1) * 16);
                double dir_z = GuEagleEntity.this.getZ() + ((random.nextFloat() * 2 - 1) * 16);
                return new Vec3(dir_x, dir_y, dir_z);
            }
        });

        this.goalSelector.addGoal(9, new BreedGoal(this, 1));
        this.goalSelector.addGoal(10, new FollowParentGoal(this, 0.8));
        this.goalSelector.addGoal(11, new RandomSwimmingGoal(this, 1.2, 40));
    }

	@Override
	public MobType getMobType() {
		return MobType.WATER;
	}

	protected void dropCustomDeathLoot(DamageSource source, int looting, boolean recentlyHitIn) {
		super.dropCustomDeathLoot(source, looting, recentlyHitIn);
		this.spawnAtLocation(new ItemStack(Items.FEATHER));
	}

	@Override
	public SoundEvent getAmbientSound() {
		return ForgeRegistries.SOUND_EVENTS.getValue(ResourceLocation.fromNamespaceAndPath(MountainsPoemMod.MOD_ID,"gu_eagle"));
	}

	@Override
	public SoundEvent getHurtSound(DamageSource ds) {
		return ForgeRegistries.SOUND_EVENTS.getValue(ResourceLocation.fromNamespaceAndPath("minecraft", "entity.generic.hurt"));
	}

	@Override
	public SoundEvent getDeathSound() {
		return ForgeRegistries.SOUND_EVENTS.getValue(ResourceLocation.fromNamespaceAndPath("minecraft", "entity.generic.death"));
	}

	@Override
	public boolean causeFallDamage(float l, float d, DamageSource source) {
		return false;
	}

	@Override
	public boolean hurt(DamageSource source, float amount) {
		if ((Entity) this instanceof GuEagleEntity eagle)
			eagle.setAnimation("hurt");
		if (source.is(DamageTypes.DROWN))
			return false;
		return super.hurt(source, amount);
	}

	@Override
	public SpawnGroupData finalizeSpawn(ServerLevelAccessor world, DifficultyInstance difficulty, MobSpawnType reason, @Nullable SpawnGroupData livingdata, @Nullable CompoundTag tag) {
		SpawnGroupData retval = super.finalizeSpawn(world, difficulty, reason, livingdata, tag);
		double x = this.getX();
		double y = this.getY();
		double z = this.getZ();
		if (world.getBiome(BlockPos.containing(x, y, z)).is(ResourceLocation.fromNamespaceAndPath("minecraft", "snowy_plains")))
			if ((Entity) this instanceof GuEagleEntity animatable)
				animatable.setTexture("gu_diao_2");
		if (world.getBiome(BlockPos.containing(x, y, z)).is(ResourceLocation.fromNamespaceAndPath("minecraft", "old_growth_pine_taiga")))
			if ((Entity) this instanceof GuEagleEntity animatable)
				animatable.setTexture("gu_diao_3");
		if (world.getBiome(BlockPos.containing(x, y, z)).is(ResourceLocation.fromNamespaceAndPath("minecraft", "taiga")))
			if ((Entity) this instanceof GuEagleEntity animatable)
				animatable.setTexture("gu_diao_3");
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
	public void awardKillScore(Entity entity, int score, DamageSource damageSource) {
		super.awardKillScore(entity, score, damageSource);
        if (Math.random() < 0.7)
            for (int index0 = 0; index0 < (int) Mth.nextDouble(RandomSource.create(), 4, 8); index0++)
                if (entity instanceof GuEagleEntity eagle)
                    eagle.setAnimation("dance2");
    }

	@Override
	public void baseTick() {
		super.baseTick();
		LevelAccessor world = this.level();
		if ((Entity) this instanceof LivingEntity _livEnt0 && _livEnt0.isBaby() && !this.onGround())
			if (Math.random() < 0.2)
				for (int index0 = 0; index0 < 5; index0++)
					if ((Entity) this instanceof GuEagleEntity eagle)
						eagle.setAnimation("play");
		if (this.onGround() && world.getLevelData().isThundering())
			if (Math.random() < 0.21)
				for (int i = 0; i < 5; i++)
					if ((Entity) this instanceof GuEagleEntity eagle)
						eagle.setAnimation("dance");
		this.refreshDimensions();
	}

	@Override
	public EntityDimensions getDimensions(Pose p_33597_) {
		return super.getDimensions(p_33597_).scale((float) 1);
	}

	@Override
	public AgeableMob getBreedOffspring(ServerLevel serverWorld, AgeableMob ageable) {
		GuEagleEntity retval = MountainsPoemModEntities.GU_EAGLE.get().create(serverWorld);
		retval.finalizeSpawn(serverWorld, serverWorld.getCurrentDifficultyAt(retval.blockPosition()), MobSpawnType.BREEDING, null, null);
		return retval;
	}

	@Override
	public boolean isFood(ItemStack stack) {
        stack.getItem();
        return false;
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
		SpawnPlacements.register(MountainsPoemModEntities.GU_EAGLE.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES,
				(entityType, world, reason, pos, random) -> (world.getDifficulty() != Difficulty.PEACEFUL && Monster.isDarkEnoughToSpawn(world, pos, random) && Mob.checkMobSpawnRules(entityType, world, reason, pos, random)));
	}

	public static AttributeSupplier.Builder createAttributes() {
		AttributeSupplier.Builder builder = Mob.createMobAttributes();
		builder = builder.add(Attributes.MOVEMENT_SPEED, 0.5);
		builder = builder.add(Attributes.MAX_HEALTH, 30);
		builder = builder.add(Attributes.ARMOR, 0);
		builder = builder.add(Attributes.ATTACK_DAMAGE, 8);
		builder = builder.add(Attributes.FOLLOW_RANGE, 30);
		builder = builder.add(Attributes.FLYING_SPEED, 0.5);
		builder = builder.add(ForgeMod.SWIM_SPEED.get(), 0.5);
		return builder;
	}

	private PlayState movementPredicate(AnimationState event) {
		if (this.animationprocedure.equals("empty")) {
			if ((event.isMoving() || !(event.getLimbSwingAmount() > -0.15F && event.getLimbSwingAmount() < 0.15F)) && this.onGround() && !this.isAggressive()) {
				return event.setAndContinue(RawAnimation.begin().thenLoop("walk"));
			}
			if (this.isDeadOrDying()) {
				return event.setAndContinue(RawAnimation.begin().thenPlay("dead"));
			}
			if (this.isInWaterOrBubble()) {
				return event.setAndContinue(RawAnimation.begin().thenLoop("fly"));
			}
			if (!this.onGround()) {
				return event.setAndContinue(RawAnimation.begin().thenLoop("fly"));
			}
			if (this.isAggressive() && event.isMoving()) {
				return event.setAndContinue(RawAnimation.begin().thenLoop("fly2"));
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
		if (this.deathTime == 40) {
			this.remove(GuEagleEntity.RemovalReason.KILLED);
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
