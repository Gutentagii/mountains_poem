package com.xiris.mountainspoem.entity;

import com.xiris.mountainspoem.MountainsPoemMod;
import com.xiris.mountainspoem.init.MountainsPoemModEntities;
import com.xiris.mountainspoem.init.MountainsPoemModItems;
import com.xiris.mountainspoem.init.MountainsPoemModSounds;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.damagesource.DamageSource;
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
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraft.world.level.storage.loot.LootParams;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;
import net.minecraft.world.level.storage.loot.parameters.LootContextParams;
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

import java.util.EnumSet;
import java.util.List;

public class QingGenBirdEntity extends Animal implements GeoEntity {
	public static final EntityDataAccessor<Boolean> SHOOT = SynchedEntityData.defineId(QingGenBirdEntity.class, EntityDataSerializers.BOOLEAN);
	public static final EntityDataAccessor<String> ANIMATION = SynchedEntityData.defineId(QingGenBirdEntity.class, EntityDataSerializers.STRING);
	public static final EntityDataAccessor<String> TEXTURE = SynchedEntityData.defineId(QingGenBirdEntity.class, EntityDataSerializers.STRING);
	private final AnimatableInstanceCache cache = GeckoLibUtil.createInstanceCache(this);
	private boolean swinging;
	private boolean lastloop;
	private long lastSwing;
	public String animationprocedure = "empty";

	public QingGenBirdEntity(EntityType<QingGenBirdEntity> type, Level world) {
		super(type, world);
        this.xpReward = 0;
        this.setNoAi(false);
		this.moveControl = new FlyingMoveControl(this, 10, true);
	}

    public QingGenBirdEntity(PlayMessages.SpawnEntity packet, Level world) {
        this(MountainsPoemModEntities.QING_GENG_BIRD.get(), world);
    }

	@Override
	protected void defineSynchedData() {
		super.defineSynchedData();
		this.entityData.define(SHOOT, false);
		this.entityData.define(ANIMATION, "undefined");
		this.entityData.define(TEXTURE, "qingen");
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
		this.goalSelector.addGoal(1, new Goal() {
			{
				this.setFlags(EnumSet.of(Goal.Flag.MOVE));
			}

			public boolean canUse() {
                return QingGenBirdEntity.this.getTarget() != null && !QingGenBirdEntity.this.getMoveControl().hasWanted();
			}

			@Override
			public boolean canContinueToUse() {
				return QingGenBirdEntity.this.getMoveControl().hasWanted() && QingGenBirdEntity.this.getTarget() != null && QingGenBirdEntity.this.getTarget().isAlive();
			}

			@Override
			public void start() {
				LivingEntity livingentity = QingGenBirdEntity.this.getTarget();
				Vec3 vec3d = livingentity.getEyePosition(1);
				QingGenBirdEntity.this.moveControl.setWantedPosition(vec3d.x, vec3d.y, vec3d.z, 1);
			}

			@Override
			public void tick() {
				LivingEntity livingentity = QingGenBirdEntity.this.getTarget();
				if (QingGenBirdEntity.this.getBoundingBox().intersects(livingentity.getBoundingBox())) {
					QingGenBirdEntity.this.doHurtTarget(livingentity);
				} else {
					double d0 = QingGenBirdEntity.this.distanceToSqr(livingentity);
					if (d0 < 16) {
						Vec3 vec3d = livingentity.getEyePosition(1);
						QingGenBirdEntity.this.moveControl.setWantedPosition(vec3d.x, vec3d.y, vec3d.z, 1);
					}
				}
			}
		});
		this.targetSelector.addGoal(2, new NearestAttackableTargetGoal(this, WoodWormsEntity.class, true, false));
		this.goalSelector.addGoal(3, new RandomStrollGoal(this, 1.2, 20) {
			@Override
			protected Vec3 getPosition() {
				RandomSource random = QingGenBirdEntity.this.getRandom();
				double dir_x = QingGenBirdEntity.this.getX() + ((random.nextFloat() * 2 - 1) * 16);
				double dir_y = QingGenBirdEntity.this.getY() + ((random.nextFloat() * 2 - 1) * 16);
				double dir_z = QingGenBirdEntity.this.getZ() + ((random.nextFloat() * 2 - 1) * 16);
				return new Vec3(dir_x, dir_y, dir_z);
			}
		});
		this.goalSelector.addGoal(4, new FollowParentGoal(this, 0.8));
		this.goalSelector.addGoal(5, new BreedGoal(this, 1));
		this.targetSelector.addGoal(6, new HurtByTargetGoal(this).setAlertOthers());
		this.goalSelector.addGoal(7, new RandomLookAroundGoal(this));
		this.goalSelector.addGoal(8, new RandomStrollGoal(this, 0.8));
		this.goalSelector.addGoal(9, new TemptGoal(this, 1, Ingredient.of(MountainsPoemModItems.WOODS_WORMS.get()), true));
		this.goalSelector.addGoal(10, new PanicGoal(this, 1));
		this.goalSelector.addGoal(11, new PanicGoal(this, 0.8));
	}

	@Override
	public MobType getMobType() {
		return MobType.UNDEFINED;
	}

	@Override
	public SoundEvent getAmbientSound() {
		return ForgeRegistries.SOUND_EVENTS.getValue(ResourceLocation.fromNamespaceAndPath(MountainsPoemMod.MOD_ID,"qing_geng"));
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
		if ((Entity) this instanceof QingGenBirdEntity bird)
			bird.setAnimation("hurt");
		return super.hurt(source, amount);
	}

	@Override
	public void die(DamageSource source) {
		super.die(source);
        LevelAccessor world = this.level();
        double x = this.getX();
        double y = this.getY();
        double z = this.getZ();

        if (!this.isBaby() && !world.isClientSide() && world instanceof ServerLevel serverLevel) {
            String path = this.isOnFire() ? "entities/qing_geng_2" : "entities/qing_geng_1";
            ResourceLocation lootTable = ResourceLocation.fromNamespaceAndPath(MountainsPoemMod.MOD_ID, path);

            LootParams params = new LootParams.Builder(serverLevel)
                    .withParameter(LootContextParams.ORIGIN, new Vec3(x, y, z))
                    .withParameter(LootContextParams.THIS_ENTITY, this)
                    .create(LootContextParamSets.CHEST);

            serverLevel.getServer().getLootData().getLootTable(lootTable)
                    .getRandomItems(params)
                    .forEach(stack -> {
                        ItemEntity item = new ItemEntity(serverLevel, x, y, z, stack);
                        serverLevel.addFreshEntity(item);
                    });
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
		double x = this.getX();
		double y = this.getY();
		double z = this.getZ();
		Entity entity = this;
		Level world = this.level();

		if ((Entity) sourceentity instanceof LivingEntity living&&living.getMainHandItem().is(ItemTags.create(ResourceLocation.fromNamespaceAndPath("minecraft", "fishes")))) {
			if (Math.random() < 0.7)
				for (int i = 0; i < 8; i++) {
					if (entity instanceof QingGenBirdEntity bird)
						bird.setAnimation("dance");
					if ((LevelAccessor) world instanceof Level _level)
                        world.playSound(null, x, y, z, MountainsPoemModSounds.QINGGEN.get(), SoundSource.NEUTRAL, 1, 1.2f);
				}
			living.getMainHandItem().shrink(1);
			if ((Entity) sourceentity instanceof LivingEntity _entity)
				_entity.swing(InteractionHand.MAIN_HAND, true);
		}
		return retval;
	}

	@Override
	public void baseTick() {
		super.baseTick();
		if ((Entity) this instanceof QingGenBirdEntity animatable)
			if (this.onGround())
				animatable.setAnimation("idle");
			else if ((this.getDisplayName().getString()).equals("haoz_daha") || (this.getDisplayName().getString()).equals("鼠大哈不哈") || (this.getDisplayName().getString()).equals("daha")
					|| (this.getDisplayName().getString()).equals("大哈"))
				animatable.setTexture("shu_da");
			else if ((this.getDisplayName().getString()).equals("blue_jay"))
				animatable.setTexture("qingen2");
			else
				animatable.setTexture("qingen");
		this.refreshDimensions();
	}

	@Override
	public EntityDimensions getDimensions(Pose p_33597_) {
		return super.getDimensions(p_33597_).scale((float) 1);
	}

	@Override
	public AgeableMob getBreedOffspring(ServerLevel serverWorld, AgeableMob ageable) {
		QingGenBirdEntity retval = MountainsPoemModEntities.QING_GENG_BIRD.get().create(serverWorld);
		retval.finalizeSpawn(serverWorld, serverWorld.getCurrentDifficultyAt(retval.blockPosition()), MobSpawnType.BREEDING, null, null);
		return retval;
	}

	@Override
	public boolean isFood(ItemStack stack) {
		return List.of(MountainsPoemModItems.WOODS_WORMS.get(), Items.SALMON, Items.COD, Items.TROPICAL_FISH).contains(stack.getItem());
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
		SpawnPlacements.register(MountainsPoemModEntities.QING_GENG_BIRD.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES,
				(entityType, world, reason, pos, random) -> (world.getBlockState(pos.below()).is(BlockTags.ANIMALS_SPAWNABLE_ON) && world.getRawBrightness(pos, 0) > 8));
	}

	public static AttributeSupplier.Builder createAttributes() {
		AttributeSupplier.Builder builder = Mob.createMobAttributes();
		builder = builder.add(Attributes.MOVEMENT_SPEED, 0.3);
		builder = builder.add(Attributes.MAX_HEALTH, 25);
		builder = builder.add(Attributes.ARMOR, 0);
		builder = builder.add(Attributes.ATTACK_DAMAGE, 3);
		builder = builder.add(Attributes.FOLLOW_RANGE, 16);
		builder = builder.add(Attributes.FLYING_SPEED, 0.3);
		return builder;
	}

	private PlayState movementPredicate(AnimationState event) {
		if (this.animationprocedure.equals("empty")) {
			if ((event.isMoving() || !(event.getLimbSwingAmount() > -0.15F && event.getLimbSwingAmount() < 0.15F))

			) {
				return event.setAndContinue(RawAnimation.begin().thenLoop("fly"));
			}
			if (this.isDeadOrDying()) {
				return event.setAndContinue(RawAnimation.begin().thenPlay("fly"));
			}
			if (this.isInWaterOrBubble()) {
				return event.setAndContinue(RawAnimation.begin().thenLoop(""));
			}
			return event.setAndContinue(RawAnimation.begin().thenLoop("idle"));
		}
		return PlayState.STOP;
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
			this.remove(QingGenBirdEntity.RemovalReason.KILLED);
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
		data.add(new AnimationController<>(this, "procedure", 4, this::procedurePredicate));
	}

	@Override
	public AnimatableInstanceCache getAnimatableInstanceCache() {
		return this.cache;
	}
}
