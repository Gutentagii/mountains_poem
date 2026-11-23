package com.xiris.mountainspoem.entity;

import com.xiris.mountainspoem.init.MountainsPoemModEntities;
import com.xiris.mountainspoem.init.MountainsPoemModItems;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.FloatGoal;
import net.minecraft.world.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.world.entity.ai.goal.RandomLookAroundGoal;
import net.minecraft.world.entity.ai.goal.RandomStrollGoal;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.Heightmap;
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

import java.util.List;
import java.util.Objects;

public class ShanGaoPigEntity extends Animal implements GeoEntity {
	public static final EntityDataAccessor<Boolean> SHOOT = SynchedEntityData.defineId(ShanGaoPigEntity.class, EntityDataSerializers.BOOLEAN);
	public static final EntityDataAccessor<String> ANIMATION = SynchedEntityData.defineId(ShanGaoPigEntity.class, EntityDataSerializers.STRING);
	public static final EntityDataAccessor<String> TEXTURE = SynchedEntityData.defineId(ShanGaoPigEntity.class, EntityDataSerializers.STRING);
	private final AnimatableInstanceCache cache = GeckoLibUtil.createInstanceCache(this);
	private boolean swinging;
	private boolean lastloop;
	private long lastSwing;
	public String animationprocedure = "empty";

	public ShanGaoPigEntity(EntityType<ShanGaoPigEntity> type, Level world) {
		super(type, world);
        this.xpReward = 0;
        this.setNoAi(false);
	}

    public ShanGaoPigEntity(PlayMessages.SpawnEntity packet, Level world) {
        this(MountainsPoemModEntities.SHAN_GAO_PIG.get(), world);
    }

	@Override
	protected void defineSynchedData() {
		super.defineSynchedData();
		this.entityData.define(SHOOT, false);
		this.entityData.define(ANIMATION, "undefined");
		this.entityData.define(TEXTURE, "shan_gao_pig");
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
				return this.mob.getBbWidth() * this.mob.getBbWidth() + entity.getBbWidth();
			}
		});
		this.goalSelector.addGoal(2, new RandomStrollGoal(this, 1.0D, 20));
		this.targetSelector.addGoal(3, new HurtByTargetGoal(this));
		this.goalSelector.addGoal(4, new RandomLookAroundGoal(this));
		this.goalSelector.addGoal(5, new FloatGoal(this));
	}

	@Override
	public MobType getMobType() {
		return MobType.UNDEFINED;
	}

	@Override
	public SoundEvent getAmbientSound() {
		return ForgeRegistries.SOUND_EVENTS.getValue(ResourceLocation.fromNamespaceAndPath("minecraft", "entity.pig.ambient"));
	}

	@Override
	public void playStepSound(BlockPos pos, BlockState blockIn) {
		this.playSound(Objects.requireNonNull(ForgeRegistries.SOUND_EVENTS.getValue(ResourceLocation.fromNamespaceAndPath("minecraft", "entity.pig.step"))), 0.15f, 1);
	}

	@Override
	public SoundEvent getHurtSound(DamageSource ds) {
		return ForgeRegistries.SOUND_EVENTS.getValue(ResourceLocation.fromNamespaceAndPath("minecraft", "entity.pig.hurt"));
	}

	@Override
	public SoundEvent getDeathSound() {
		return ForgeRegistries.SOUND_EVENTS.getValue(ResourceLocation.fromNamespaceAndPath("minecraft", "entity.pig.death"));
	}

	@Override
	public boolean hurt(DamageSource source, float amount) {
        if ((Entity) this instanceof ShanGaoPigEntity pig)
            pig.setAnimation("hurt");
        return super.hurt(source, amount);
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
		double x = this.getX();
		double y = this.getY();
		double z = this.getZ();
		Entity entity = this;
		Level world = this.level();

		if (sourceentity.isShiftKeyDown() && (Entity) sourceentity instanceof LivingEntity living && entity instanceof ShanGaoPigEntity animatable) {
			if (living.getMainHandItem().getItem() == Items.RED_DYE) {
				animatable.setTexture("shan_gao_pig_1");
				living.getMainHandItem().shrink(1);
			}
			if (living.getMainHandItem().getItem() == Items.ORANGE_DYE) {
				animatable.setTexture("shan_gao_pig_2");
				living.getMainHandItem().shrink(1);
			}
			if (living.getMainHandItem().getItem() == Items.YELLOW_DYE) {
				animatable.setTexture("shan_gao_pig_3");
				living.getMainHandItem().shrink(1);
			}
			if (living.getMainHandItem().getItem() == Items.GREEN_DYE) {
				animatable.setTexture("shan_gao_pig_4");
				living.getMainHandItem().shrink(1);
			}
			if (living.getMainHandItem().getItem() == Items.CYAN_DYE) {
				animatable.setTexture("shan_gao_pig_5");
				living.getMainHandItem().shrink(1);
			}
			if (living.getMainHandItem().getItem() == Items.LIGHT_BLUE_DYE) {
				animatable.setTexture("shan_gao_pig_6");
				living.getMainHandItem().shrink(1);
			}
			if (living.getMainHandItem().getItem() == Items.PURPLE_DYE) {
				animatable.setTexture("shan_gao_pig_7");
				living.getMainHandItem().shrink(1);
			}
			if (living.getMainHandItem().getItem() == Items.GRAY_DYE) {
				animatable.setTexture("shan_gao_pig_8");
				living.getMainHandItem().shrink(1);
			}
			if (living.getMainHandItem().getItem() == Items.BROWN_DYE) {
				animatable.setTexture("shan_gao_pig_9");
				living.getMainHandItem().shrink(1);
			}
			if (living.getMainHandItem().getItem() == Items.LIGHT_GRAY_DYE) {
				animatable.setTexture("shan_gao_pig_10");
				living.getMainHandItem().shrink(1);
			}
			if (living.getMainHandItem().getItem() == Items.PINK_DYE) {
				animatable.setTexture("shan_gao_pig_11");
				living.getMainHandItem().shrink(1);
			}
			if (living.getMainHandItem().getItem() == Items.BLACK_DYE) {
				animatable.setTexture("shan_gao_pig_12");
				living.getMainHandItem().shrink(1);
			}
			if (living.getMainHandItem().getItem() == Items.LIME_DYE) {
				animatable.setTexture("shan_gao_pig_13");
				living.getMainHandItem().shrink(1);
			}
			if (living.getMainHandItem().getItem() == Items.BLUE_DYE) {
				animatable.setTexture("shan_gao_pig_14");
				living.getMainHandItem().shrink(1);
			}
			if (living.getMainHandItem().getItem() == Items.WATER_BUCKET) {
				animatable.setTexture("shan_gao_pig");
				living.getMainHandItem().shrink(1);
			}
			if (living.getMainHandItem().getItem() == Items.MAGENTA_DYE) {
				animatable.setTexture("shan_gao_pig_11");
				living.getMainHandItem().shrink(1);
			}
			if (living.getMainHandItem().getItem() == Items.BONE_MEAL) {
				animatable.setTexture("shan_gao_pig_15");
				living.getMainHandItem().shrink(1);
			}
			if ((Entity) sourceentity instanceof LivingEntity _entity)
				_entity.swing(InteractionHand.MAIN_HAND, true);
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
		return super.getDimensions(p_33597_).scale((float) 1);
	}

	@Override
	public AgeableMob getBreedOffspring(ServerLevel serverWorld, AgeableMob ageable) {
		ShanGaoPigEntity retval = MountainsPoemModEntities.SHAN_GAO_PIG.get().create(serverWorld);
		retval.finalizeSpawn(serverWorld, serverWorld.getCurrentDifficultyAt(retval.blockPosition()), MobSpawnType.BREEDING, null, null);
		return retval;
	}

	@Override
	public boolean isFood(ItemStack stack) {
		return List.of(MountainsPoemModItems.YAN_FRUIT.get(), MountainsPoemModItems.DANFRUIT.get(), MountainsPoemModItems.SHATANG_FRUIT.get(), Items.APPLE).contains(stack.getItem());
	}

	@Override
	public void aiStep() {
		super.aiStep();
		this.updateSwingTime();
	}

	public static void init() {
		SpawnPlacements.register(MountainsPoemModEntities.SHAN_GAO_PIG.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES,
				(entityType, world, reason, pos, random) -> (world.getBlockState(pos.below()).is(BlockTags.ANIMALS_SPAWNABLE_ON) && world.getRawBrightness(pos, 0) > 8));
	}

	public static AttributeSupplier.Builder createAttributes() {
		AttributeSupplier.Builder builder = Mob.createMobAttributes();
		builder = builder.add(Attributes.MOVEMENT_SPEED, 0.2);
		builder = builder.add(Attributes.MAX_HEALTH, 20);
		builder = builder.add(Attributes.ARMOR, 0);
		builder = builder.add(Attributes.ATTACK_DAMAGE, 2);
		builder = builder.add(Attributes.FOLLOW_RANGE, 16);
		return builder;
	}

	private PlayState movementPredicate(AnimationState event) {
		if (this.animationprocedure.equals("empty")) {
			if ((event.isMoving() || !(event.getLimbSwingAmount() > -0.15F && event.getLimbSwingAmount() < 0.15F))

			) {
				return event.setAndContinue(RawAnimation.begin().thenLoop("walk"));
			}
			if (this.isInWaterOrBubble()) {
				return event.setAndContinue(RawAnimation.begin().thenLoop("swim"));
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
			this.remove(ShanGaoPigEntity.RemovalReason.KILLED);
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
