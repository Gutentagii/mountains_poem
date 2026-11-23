package com.xiris.mountainspoem.entity;

import com.xiris.mountainspoem.MountainsPoemMod;
import com.xiris.mountainspoem.init.*;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.BlockParticleOption;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraft.world.level.storage.loot.LootParams;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;
import net.minecraft.world.level.storage.loot.parameters.LootContextParams;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.network.PlayMessages;
import org.jetbrains.annotations.Nullable;
import software.bernie.geckolib.animatable.GeoEntity;
import software.bernie.geckolib.core.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.core.animation.AnimatableManager;
import software.bernie.geckolib.core.animation.AnimationController;
import software.bernie.geckolib.core.animation.AnimationState;
import software.bernie.geckolib.core.animation.RawAnimation;
import software.bernie.geckolib.core.object.PlayState;
import software.bernie.geckolib.util.GeckoLibUtil;

import java.util.List;

public class WhiteMonkeyEntity extends Animal implements GeoEntity {
	public static final EntityDataAccessor<Boolean> SHOOT = SynchedEntityData.defineId(WhiteMonkeyEntity.class, EntityDataSerializers.BOOLEAN);
	public static final EntityDataAccessor<String> ANIMATION = SynchedEntityData.defineId(WhiteMonkeyEntity.class, EntityDataSerializers.STRING);
	public static final EntityDataAccessor<String> TEXTURE = SynchedEntityData.defineId(WhiteMonkeyEntity.class, EntityDataSerializers.STRING);
	private final AnimatableInstanceCache cache = GeckoLibUtil.createInstanceCache(this);
	private boolean swinging;
	private boolean lastloop;
	private long lastSwing;
	public String animationprocedure = "empty";

	public WhiteMonkeyEntity(EntityType<WhiteMonkeyEntity> type, Level world) {
		super(type, world);
        this.xpReward = 0;
        this.setNoAi(false);
	}

    public WhiteMonkeyEntity(PlayMessages.SpawnEntity packet, Level world) {
        this(MountainsPoemModEntities.WHITE_APE.get(), world);
    }

	@Override
	protected void defineSynchedData() {
		super.defineSynchedData();
		this.entityData.define(SHOOT, false);
		this.entityData.define(ANIMATION, "undefined");
		this.entityData.define(TEXTURE, "white_ape");
	}

	public void setTexture(String texture) {
		this.entityData.set(TEXTURE, texture);
	}

	public String getTexture() {
		return this.entityData.get(TEXTURE);
	}

    @Override
    protected void registerGoals() {
        super.registerGoals();
        this.goalSelector.addGoal(1, new MeleeAttackGoal(this, 1.2, false) {
            @Override
            protected double getAttackReachSqr(LivingEntity entity) {
                return this.mob.getBbWidth() * this.mob.getBbWidth() + entity.getBbWidth() * entity.getBbWidth();
            }
            @Override
            public boolean canUse() {
                if (this.mob.getTarget() instanceof Player player && player.isCreative()) {
                    return false;
                }
                return super.canUse();
            }
        });
        this.goalSelector.addGoal(2, new RandomStrollGoal(this, 1.0D, 20));
        this.goalSelector.addGoal(3, new TemptGoal(this, 1, Ingredient.of(MountainsPoemModItems.GOLDEN_YAN_FRUIT.get()), false));
        this.targetSelector.addGoal(4, new HurtByTargetGoal(this).setAlertOthers(WhiteMonkeyEntity.class));
        this.goalSelector.addGoal(5, new RandomLookAroundGoal(this));
        this.goalSelector.addGoal(6, new FloatGoal(this));
        this.goalSelector.addGoal(7, new BreedGoal(this, 1));
        this.goalSelector.addGoal(8, new FollowParentGoal(this, 0.8));
    }

	@Override
	public MobType getMobType() {
		return MobType.UNDEFINED;
	}

	protected void dropCustomDeathLoot(DamageSource source, int looting, boolean recentlyHitIn) {
		super.dropCustomDeathLoot(source, looting, recentlyHitIn);
		this.spawnAtLocation(new ItemStack(MountainsPoemModItems.WHITE_APE_MEAT.get()));

        if (!this.level().isClientSide() && Math.random() < 0.3) {
            this.spawnAtLocation(new ItemStack(MountainsPoemModItems.WHITE_APE_CURVED_NAILS.get()));
        }
	}

	@Override
	public SoundEvent getAmbientSound() {
		return MountainsPoemModSounds.WHITE_MONKEYS.get();
	}

	@Override
	public SoundEvent getHurtSound(DamageSource ds) {
		return MountainsPoemModSounds.MONKEY_HURT.get();
	}

	@Override
	public SoundEvent getDeathSound() {
		return MountainsPoemModSounds.MONKEY_HURT.get();
	}

	@Override
	public void thunderHit(ServerLevel serverWorld, LightningBolt lightningBolt) {
		super.thunderHit(serverWorld, lightningBolt);
        if ((Entity) this instanceof WhiteMonkeyEntity monkey)
            monkey.setAnimation("hurt");
    }

    @Override
    public boolean hurt(DamageSource source, float amount) {
        boolean hurt = super.hurt(source, amount);
        if (hurt && !level().isClientSide() && level() instanceof ServerLevel serverLevel) {
            Entity attacker = source.getEntity();
            if (attacker instanceof LivingEntity livingAttacker && !(attacker instanceof WhiteMonkeyEntity)) {

                if (livingAttacker instanceof Player player && player.isCreative()) {
                    return hurt;
                }

                setTarget(livingAttacker);

                List<WhiteMonkeyEntity> allies = serverLevel.getEntitiesOfClass(WhiteMonkeyEntity.class, getBoundingBox().inflate(20));
                for (WhiteMonkeyEntity monkey : allies) {
                    if (monkey != this) {
                        monkey.setTarget(livingAttacker);
                        monkey.getNavigation().moveTo(livingAttacker, 1.2D);
                    }
                }

                if (allies.size() <= 1 && getHealth() <= 10.0F) {
                    this.animationprocedure = "play";

                    List<WhiteMonkeyEntity> farAllies = serverLevel.getEntitiesOfClass(WhiteMonkeyEntity.class, getBoundingBox().inflate(100));
                    for (WhiteMonkeyEntity monkey : farAllies) {
                        if (monkey != this) {
                            monkey.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 50 * 20, 0));
                            monkey.setTarget(livingAttacker);
                            monkey.getNavigation().moveTo(this, 1.2D);
                        }
                    }
                }
            }
        }
        return hurt;
    }

	@Override
	public void die(DamageSource source) {
		super.die(source);
		LevelAccessor world = this.level();
		double x = this.getX();
		double y = this.getY();
		double z = this.getZ();
        if (!this.isBaby()) {
			if (this.isOnFire()) {
				if (!world.isClientSide() && world.getServer() != null) {
					BlockPos _bpLootTblWorld = BlockPos.containing(x, y, z);
					for (ItemStack itemstackiterator : world.getServer().getLootData().getLootTable(ResourceLocation.fromNamespaceAndPath(MountainsPoemMod.MOD_ID,"entities/bai_yuan_2"))
							.getRandomItems(new LootParams.Builder((ServerLevel) world).withParameter(LootContextParams.ORIGIN, Vec3.atCenterOf(_bpLootTblWorld)).withParameter(LootContextParams.BLOCK_STATE, world.getBlockState(_bpLootTblWorld))
									.withOptionalParameter(LootContextParams.BLOCK_ENTITY, world.getBlockEntity(_bpLootTblWorld)).create(LootContextParamSets.EMPTY))) {
						if (world instanceof ServerLevel _level) {
							ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, itemstackiterator);
							entityToSpawn.setPickUpDelay(0);
							entityToSpawn.setUnlimitedLifetime();
							_level.addFreshEntity(entityToSpawn);
						}
					}
				}
			} else {
				if (!world.isClientSide() && world.getServer() != null) {
					BlockPos _bpLootTblWorld = BlockPos.containing(x, y, z);
					for (ItemStack itemstackiterator : world.getServer().getLootData().getLootTable(ResourceLocation.fromNamespaceAndPath(MountainsPoemMod.MOD_ID,"entities/bai_yuan_1"))
							.getRandomItems(new LootParams.Builder((ServerLevel) world).withParameter(LootContextParams.ORIGIN, Vec3.atCenterOf(_bpLootTblWorld)).withParameter(LootContextParams.BLOCK_STATE, world.getBlockState(_bpLootTblWorld))
									.withOptionalParameter(LootContextParams.BLOCK_ENTITY, world.getBlockEntity(_bpLootTblWorld)).create(LootContextParamSets.EMPTY))) {
						if (world instanceof ServerLevel _level) {
							ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, itemstackiterator);
							entityToSpawn.setPickUpDelay(0);
							entityToSpawn.setUnlimitedLifetime();
							_level.addFreshEntity(entityToSpawn);
						}
					}
				}
			}
		}
	}

	@Override
	public SpawnGroupData finalizeSpawn(ServerLevelAccessor world, DifficultyInstance difficulty, MobSpawnType reason, @Nullable SpawnGroupData livingdata, @Nullable CompoundTag tag) {
		SpawnGroupData retval = super.finalizeSpawn(world, difficulty, reason, livingdata, tag);
		if ((Entity) this instanceof WhiteMonkeyEntity monkey && monkey.isBaby())
			switch (monkey.animationprocedure) {
				case "idle" -> monkey.setAnimation("idle2");
				case "attack" -> monkey.setAnimation("attack2");
				case "walk" -> monkey.setAnimation("walk2");
				case "sprint" -> monkey.setAnimation("sprint2");
				case "dead" -> monkey.setAnimation("dead2");
				case "swim" -> monkey.setAnimation("swim2");
			}
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

    private int PICKCD = 0;
    private int CDTime = -1;

    @Override
    public void baseTick() {
        super.baseTick();
        Level world = this.level();

        if (!world.isClientSide()) {
            if (PICKCD > 0) PICKCD--;

            if (CDTime > 0) {
                CDTime--;
            } else if (CDTime == 0) {
                CDTime = -1;
                int count = 3 + random.nextInt(2);
                for (int i = 0; i < count; i++) {
                    this.spawnAtLocation(new ItemStack(MountainsPoemModItems.YAN_FRUIT.get()));
                }
            }

            if (PICKCD == 0 && this.isAlive() && !this.isDeadOrDying()) {
                BlockPos pos = this.blockPosition();
                boolean hasYanLeaves = SC(pos.above());
                boolean onGrass = world.getBlockState(pos.below()).is(Blocks.DIRT_PATH) || world.getBlockState(pos.below()).is(Blocks.GRASS_BLOCK);

                if (hasYanLeaves && onGrass) {
                    PICKCD = 200 + random.nextInt(101);
                    if (Math.random() < 0.1) {
                        Pick((ServerLevel) world);
                    }
                }
            }
        }

        if (world.getLevelData().isRaining() && Math.random() < 0.1 && this.isBaby() && this.isInWaterRainOrBubble()) {
            for (int i = 0; i < 10; i++)
                this.setAnimation("play");
        }

        if (this.isSprinting())
            this.setAnimation("sprint");

        this.refreshDimensions();
    }

    private boolean SC(BlockPos center) {
        for (int x = -1; x <= 1; x++) {
            for (int y = -1; y <= 1; y++) {
                for (int z = -1; z <= 1; z++) {
                    BlockState state = this.level().getBlockState(center.offset(x, y, z));
                    if (state.is(MountainsPoemModBlocks.FRUITFUL_YAN_LEAVES.get())) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private void Pick(ServerLevel _level) {
        if (!this.level().isClientSide()) {
            this.animationprocedure = "pick";
            BlockPos pos = this.blockPosition().below();
            BlockState state = _level.getBlockState(pos);
            BlockParticleOption particle = new BlockParticleOption(ParticleTypes.BLOCK, state);

            for (int i = 0; i < 4; i++) {
                double x = this.getX() + (random.nextDouble() - 0.5) * 0.5;
                double y = this.getY();
                double z = this.getZ() + (random.nextDouble() - 0.5) * 0.5;

                _level.sendParticles(particle, x, y, z, 1, 0.1, 0.1, 0.1, 0);
            }
            this.CDTime = 60;
        }
    }

    @Override
    public InteractionResult interactAt(Player player, Vec3 vec, InteractionHand hand) {
        Level world = this.level();
        ItemStack stack = player.getItemInHand(hand);

        if (!world.isClientSide() && world instanceof ServerLevel _level) {
            if (stack.is(Items.BRUSH)) {
                player.startUsingItem(hand);
                stack.hurtAndBreak(1, player, p -> p.broadcastBreakEvent(hand));

                for (int i = 0; i < 4; i++) {
                    double x = getX() + (random.nextDouble() - 0.5);
                    double y = getY() + random.nextDouble() * 1.5;
                    double z = getZ() + (random.nextDouble() - 0.5);
                    _level.sendParticles(MountainsPoemModParticleTypes.SACRIFICE_M.get(),
                            x, y, z, 1, 0, 0, 0, 0.1);
                }

                if (random.nextFloat() < 0.2F) {
                    int count = 1 + random.nextInt(2);
                    spawnAtLocation(MountainsPoemModItems.YAN_FRUIT.get(), count);
                }
                return InteractionResult.SUCCESS;
            }

            if (stack.is(Items.SHEARS)) {
                stack.hurtAndBreak(1, player, p -> p.broadcastBreakEvent(hand));
                if (random.nextFloat() < 0.8F) {
                    spawnAtLocation(MountainsPoemModItems.WHITE_APE_CURVED_NAILS.get());
                }
                return InteractionResult.SUCCESS;
            }
        }

        return super.interactAt(player, vec, hand);
    }

	@Override
	public EntityDimensions getDimensions(Pose p_33597_) {
		return super.getDimensions(p_33597_).scale((float) 1);
	}

	@Override
	public AgeableMob getBreedOffspring(ServerLevel serverWorld, AgeableMob ageable) {
		WhiteMonkeyEntity retval = MountainsPoemModEntities.WHITE_APE.get().create(serverWorld);
		retval.finalizeSpawn(serverWorld, serverWorld.getCurrentDifficultyAt(retval.blockPosition()), MobSpawnType.BREEDING, null, null);
		return retval;
	}

	@Override
	public boolean isFood(ItemStack stack) {
		return List.of(MountainsPoemModItems.YAN_FRUIT.get(), MountainsPoemModItems.GOLDEN_YAN_FRUIT.get()).contains(stack.getItem());
	}

	@Override
	public void aiStep() {
		super.aiStep();
		this.updateSwingTime();
	}

	public static void init() {
		SpawnPlacements.register(MountainsPoemModEntities.WHITE_APE.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES,
				(entityType, world, reason, pos, random) -> (world.getBlockState(pos.below()).is(BlockTags.ANIMALS_SPAWNABLE_ON) && world.getRawBrightness(pos, 0) > 8));
	}

	public static AttributeSupplier.Builder createAttributes() {
		AttributeSupplier.Builder builder = Mob.createMobAttributes();
		builder = builder.add(Attributes.MOVEMENT_SPEED, 0.3);
		builder = builder.add(Attributes.MAX_HEALTH, 30);
		builder = builder.add(Attributes.ARMOR, 0);
		builder = builder.add(Attributes.ATTACK_DAMAGE, 18);
		builder = builder.add(Attributes.FOLLOW_RANGE, 16);
		return builder;
	}

	private PlayState movementPredicate(AnimationState event) {
		if (this.animationprocedure.equals("empty")) {
			if ((event.isMoving() || !(event.getLimbSwingAmount() > -0.15F && event.getLimbSwingAmount() < 0.15F))

			) {
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
        if (!this.animationprocedure.equals("empty")) {
            event.setAndContinue(RawAnimation.begin().thenPlay(this.animationprocedure));
            this.animationprocedure = "empty";
            return PlayState.CONTINUE;
        }
        return PlayState.STOP;
    }

	@Override
	protected void tickDeath() {
		++this.deathTime;
		if (this.deathTime == 20) {
			this.remove(WhiteMonkeyEntity.RemovalReason.KILLED);
			this.dropExperience();
			LevelAccessor world = this.level();
			if (Math.random() < 0.3)
				if (world instanceof ServerLevel _level)
					_level.addFreshEntity(new ExperienceOrb(_level, this.getX(), this.getY(), this.getZ(), 2));
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
