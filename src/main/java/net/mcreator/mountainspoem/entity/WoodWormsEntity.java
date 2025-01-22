
package net.mcreator.mountainspoem.entity;

import software.bernie.geckolib.util.GeckoLibUtil;
import software.bernie.geckolib.core.object.PlayState;
import software.bernie.geckolib.core.animation.RawAnimation;
import software.bernie.geckolib.core.animation.AnimationState;
import software.bernie.geckolib.core.animation.AnimationController;
import software.bernie.geckolib.core.animation.AnimatableManager;
import software.bernie.geckolib.core.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.animatable.GeoEntity;

import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.network.PlayMessages;
import net.minecraftforge.network.NetworkHooks;

import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.monster.EnderMan;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.RemoveBlockGoal;
import net.minecraft.world.entity.ai.goal.RandomStrollGoal;
import net.minecraft.world.entity.ai.goal.RandomLookAroundGoal;
import net.minecraft.world.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.world.entity.ai.goal.FloatGoal;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.SpawnPlacements;
import net.minecraft.world.entity.SpawnGroupData;
import net.minecraft.world.entity.Pose;
import net.minecraft.world.entity.MobType;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.EntityDimensions;
import net.minecraft.world.entity.AgeableMob;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.tags.BlockTags;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.protocol.game.ClientGamePacketListener;
import net.minecraft.network.protocol.Packet;
import net.minecraft.nbt.CompoundTag;

import net.mcreator.mountainspoem.procedures.WoodwormssProcedure;
import net.mcreator.mountainspoem.init.MountainsPoemModItems;
import net.mcreator.mountainspoem.init.MountainsPoemModEntities;
import net.mcreator.mountainspoem.init.MountainsPoemModBlocks;

import javax.annotation.Nullable;

import java.util.List;

public class WoodWormsEntity extends Animal implements GeoEntity {
	public static final EntityDataAccessor<Boolean> SHOOT = SynchedEntityData.defineId(WoodWormsEntity.class, EntityDataSerializers.BOOLEAN);
	public static final EntityDataAccessor<String> ANIMATION = SynchedEntityData.defineId(WoodWormsEntity.class, EntityDataSerializers.STRING);
	public static final EntityDataAccessor<String> TEXTURE = SynchedEntityData.defineId(WoodWormsEntity.class, EntityDataSerializers.STRING);
	private final AnimatableInstanceCache cache = GeckoLibUtil.createInstanceCache(this);
	private boolean swinging;
	private boolean lastloop;
	private long lastSwing;
	public String animationprocedure = "empty";

	public WoodWormsEntity(PlayMessages.SpawnEntity packet, Level world) {
		this(MountainsPoemModEntities.WOOD_WORMS.get(), world);
	}

	public WoodWormsEntity(EntityType<WoodWormsEntity> type, Level world) {
		super(type, world);
		xpReward = 0;
		setNoAi(false);
	}

	@Override
	protected void defineSynchedData() {
		super.defineSynchedData();
		this.entityData.define(SHOOT, false);
		this.entityData.define(ANIMATION, "undefined");
		this.entityData.define(TEXTURE, "wood_worms_1");
	}

	public void setTexture(String texture) {
		this.entityData.set(TEXTURE, texture);
	}

	public String getTexture() {
		return this.entityData.get(TEXTURE);
	}

	@Override
	public Packet<ClientGamePacketListener> getAddEntityPacket() {
		return NetworkHooks.getEntitySpawningPacket(this);
	}

	@Override
	protected void registerGoals() {
		super.registerGoals();
		this.goalSelector.addGoal(1, new MeleeAttackGoal(this, 1.2, true) {
			@Override
			protected double getAttackReachSqr(LivingEntity entity) {
				return this.mob.getBbWidth() * this.mob.getBbWidth() + entity.getBbWidth();
			}
		});
		this.goalSelector.addGoal(2, new RemoveBlockGoal(MountainsPoemModBlocks.PAN_LOG.get(), this, 1, (int) 2));
		this.goalSelector.addGoal(3, new RemoveBlockGoal(MountainsPoemModBlocks.PAN_PLANKS.get(), this, 1, (int) 2));
		this.goalSelector.addGoal(4, new RemoveBlockGoal(MountainsPoemModBlocks.PAN_WOOD.get(), this, 1, (int) 2));
		this.goalSelector.addGoal(5, new RemoveBlockGoal(MountainsPoemModBlocks.HUANG_GUAN_LOG.get(), this, 1, (int) 2));
		this.goalSelector.addGoal(6, new RemoveBlockGoal(MountainsPoemModBlocks.HUANG_GUAN_PLANKS.get(), this, 1, (int) 2));
		this.goalSelector.addGoal(7, new RemoveBlockGoal(MountainsPoemModBlocks.HUANG_GUAN_WOOD.get(), this, 1, (int) 2));
		this.goalSelector.addGoal(8, new RemoveBlockGoal(MountainsPoemModBlocks.YANLOG.get(), this, 1, (int) 2));
		this.goalSelector.addGoal(9, new RemoveBlockGoal(MountainsPoemModBlocks.YAN_PLANKS.get(), this, 1, (int) 2));
		this.goalSelector.addGoal(10, new RemoveBlockGoal(MountainsPoemModBlocks.YANWOOD.get(), this, 1, (int) 2));
		this.goalSelector.addGoal(11, new RemoveBlockGoal(MountainsPoemModBlocks.SHATANG_LOG.get(), this, 1, (int) 2));
		this.goalSelector.addGoal(12, new RemoveBlockGoal(MountainsPoemModBlocks.SHATANG_PLANKS.get(), this, 1, (int) 2));
		this.goalSelector.addGoal(13, new RemoveBlockGoal(MountainsPoemModBlocks.SHATANG_WOOD.get(), this, 1, (int) 2));
		this.goalSelector.addGoal(14, new RemoveBlockGoal(Blocks.BIRCH_LOG, this, 1, (int) 2));
		this.goalSelector.addGoal(15, new RemoveBlockGoal(Blocks.BIRCH_PLANKS, this, 1, (int) 2));
		this.goalSelector.addGoal(16, new RemoveBlockGoal(Blocks.BIRCH_WOOD, this, 1, (int) 2));
		this.goalSelector.addGoal(17, new RemoveBlockGoal(Blocks.OAK_SAPLING, this, 1, (int) 2));
		this.goalSelector.addGoal(18, new RemoveBlockGoal(Blocks.BIRCH_SAPLING, this, 1, (int) 2));
		this.goalSelector.addGoal(19, new RemoveBlockGoal(Blocks.JUNGLE_SAPLING, this, 1, (int) 2));
		this.goalSelector.addGoal(20, new RemoveBlockGoal(Blocks.SPRUCE_SAPLING, this, 1, (int) 2));
		this.goalSelector.addGoal(21, new RemoveBlockGoal(Blocks.OAK_LOG, this, 1, (int) 2));
		this.goalSelector.addGoal(22, new RemoveBlockGoal(Blocks.CHERRY_SAPLING, this, 1, (int) 2));
		this.goalSelector.addGoal(23, new RemoveBlockGoal(Blocks.JUNGLE_LOG, this, 1, (int) 2));
		this.goalSelector.addGoal(24, new RemoveBlockGoal(Blocks.MANGROVE_PROPAGULE, this, 1, (int) 2));
		this.goalSelector.addGoal(25, new RemoveBlockGoal(Blocks.JUNGLE_PLANKS, this, 1, (int) 2));
		this.goalSelector.addGoal(26, new RemoveBlockGoal(Blocks.DARK_OAK_SAPLING, this, 1, (int) 2));
		this.goalSelector.addGoal(27, new RemoveBlockGoal(Blocks.JUNGLE_WOOD, this, 1, (int) 2));
		this.goalSelector.addGoal(28, new RemoveBlockGoal(Blocks.ACACIA_SAPLING, this, 1, (int) 2));
		this.goalSelector.addGoal(29, new RemoveBlockGoal(Blocks.ACACIA_LOG, this, 1, (int) 2));
		this.goalSelector.addGoal(30, new RemoveBlockGoal(Blocks.ACACIA_PLANKS, this, 1, (int) 2));
		this.goalSelector.addGoal(31, new RemoveBlockGoal(Blocks.ACACIA_WOOD, this, 1, (int) 2));
		this.goalSelector.addGoal(32, new RemoveBlockGoal(Blocks.DARK_OAK_LOG, this, 1, (int) 2));
		this.goalSelector.addGoal(33, new RemoveBlockGoal(Blocks.DARK_OAK_PLANKS, this, 1, (int) 2));
		this.goalSelector.addGoal(34, new RemoveBlockGoal(Blocks.DARK_OAK_WOOD, this, 1, (int) 2));
		this.goalSelector.addGoal(35, new RemoveBlockGoal(Blocks.SPRUCE_LOG, this, 1, (int) 2));
		this.goalSelector.addGoal(36, new RemoveBlockGoal(Blocks.OAK_WOOD, this, 1, (int) 2));
		this.goalSelector.addGoal(37, new RemoveBlockGoal(Blocks.OAK_PLANKS, this, 1, (int) 2));
		this.goalSelector.addGoal(38, new RemoveBlockGoal(Blocks.MANGROVE_LOG, this, 1, (int) 2));
		this.goalSelector.addGoal(39, new RemoveBlockGoal(Blocks.MANGROVE_WOOD, this, 1, (int) 2));
		this.goalSelector.addGoal(40, new RemoveBlockGoal(Blocks.MANGROVE_PLANKS, this, 1, (int) 2));
		this.goalSelector.addGoal(41, new RemoveBlockGoal(Blocks.CHERRY_LOG, this, 1, (int) 2));
		this.goalSelector.addGoal(42, new RemoveBlockGoal(Blocks.CHERRY_WOOD, this, 1, (int) 2));
		this.goalSelector.addGoal(43, new RemoveBlockGoal(Blocks.CHERRY_PLANKS, this, 1, (int) 2));
		this.goalSelector.addGoal(44, new RemoveBlockGoal(Blocks.CRIMSON_STEM, this, 1, (int) 2));
		this.goalSelector.addGoal(45, new RemoveBlockGoal(Blocks.CRIMSON_PLANKS, this, 1, (int) 2));
		this.goalSelector.addGoal(46, new RemoveBlockGoal(Blocks.CRIMSON_HYPHAE, this, 1, (int) 2));
		this.goalSelector.addGoal(47, new RemoveBlockGoal(Blocks.CRIMSON_FUNGUS, this, 1, (int) 2));
		this.goalSelector.addGoal(48, new RemoveBlockGoal(Blocks.SPRUCE_PLANKS, this, 1, (int) 2));
		this.goalSelector.addGoal(49, new RemoveBlockGoal(Blocks.SPRUCE_LOG, this, 1, (int) 2));
		this.goalSelector.addGoal(50, new RemoveBlockGoal(Blocks.SPRUCE_WOOD, this, 1, (int) 2));
		this.goalSelector.addGoal(51, new RemoveBlockGoal(Blocks.WARPED_STEM, this, 1, (int) 2));
		this.goalSelector.addGoal(52, new RemoveBlockGoal(Blocks.WARPED_HYPHAE, this, 1, (int) 2));
		this.goalSelector.addGoal(53, new RemoveBlockGoal(Blocks.WARPED_PLANKS, this, 1, (int) 2));
		this.goalSelector.addGoal(54, new RemoveBlockGoal(Blocks.WARPED_FUNGUS, this, 1, (int) 2));
		this.goalSelector.addGoal(55, new RemoveBlockGoal(Blocks.CHORUS_PLANT, this, 1, (int) 2));
		this.goalSelector.addGoal(56, new RemoveBlockGoal(Blocks.CHORUS_FLOWER, this, 1, (int) 2));
		this.targetSelector.addGoal(57, new NearestAttackableTargetGoal(this, EnderMan.class, true, false));
		this.goalSelector.addGoal(58, new RandomStrollGoal(this, 1));
		this.targetSelector.addGoal(59, new HurtByTargetGoal(this).setAlertOthers());
		this.goalSelector.addGoal(60, new RandomLookAroundGoal(this));
		this.goalSelector.addGoal(61, new FloatGoal(this));
	}

	@Override
	public MobType getMobType() {
		return MobType.UNDEFINED;
	}

	protected void dropCustomDeathLoot(DamageSource source, int looting, boolean recentlyHitIn) {
		super.dropCustomDeathLoot(source, looting, recentlyHitIn);
		this.spawnAtLocation(new ItemStack(MountainsPoemModItems.WOODS_WORMS.get()));
	}

	@Override
	public SoundEvent getHurtSound(DamageSource ds) {
		return ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.generic.hurt"));
	}

	@Override
	public SoundEvent getDeathSound() {
		return ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.generic.death"));
	}

	@Override
	public SpawnGroupData finalizeSpawn(ServerLevelAccessor world, DifficultyInstance difficulty, MobSpawnType reason, @Nullable SpawnGroupData livingdata, @Nullable CompoundTag tag) {
		SpawnGroupData retval = super.finalizeSpawn(world, difficulty, reason, livingdata, tag);
		WoodwormssProcedure.execute(world, this.getX(), this.getY(), this.getZ(), this);
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
	public AgeableMob getBreedOffspring(ServerLevel serverWorld, AgeableMob ageable) {
		WoodWormsEntity retval = MountainsPoemModEntities.WOOD_WORMS.get().create(serverWorld);
		retval.finalizeSpawn(serverWorld, serverWorld.getCurrentDifficultyAt(retval.blockPosition()), MobSpawnType.BREEDING, null, null);
		return retval;
	}

	@Override
	public boolean isFood(ItemStack stack) {
		return List.of(MountainsPoemModBlocks.PAN_LOG.get().asItem(), MountainsPoemModBlocks.SHATANG_LOG.get().asItem(), Blocks.OAK_LOG.asItem()).contains(stack.getItem());
	}

	@Override
	public void aiStep() {
		super.aiStep();
		this.updateSwingTime();
	}

	public static void init() {
		SpawnPlacements.register(MountainsPoemModEntities.WOOD_WORMS.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES,
				(entityType, world, reason, pos, random) -> (world.getBlockState(pos.below()).is(BlockTags.ANIMALS_SPAWNABLE_ON) && world.getRawBrightness(pos, 0) > 8));
	}

	public static AttributeSupplier.Builder createAttributes() {
		AttributeSupplier.Builder builder = Mob.createMobAttributes();
		builder = builder.add(Attributes.MOVEMENT_SPEED, 0.3);
		builder = builder.add(Attributes.MAX_HEALTH, 2);
		builder = builder.add(Attributes.ARMOR, 0);
		builder = builder.add(Attributes.ATTACK_DAMAGE, 1);
		builder = builder.add(Attributes.FOLLOW_RANGE, 7);
		return builder;
	}

	private PlayState movementPredicate(AnimationState event) {
		if (this.animationprocedure.equals("empty")) {
			if ((event.isMoving() || !(event.getLimbSwingAmount() > -0.15F && event.getLimbSwingAmount() < 0.15F))

			) {
				return event.setAndContinue(RawAnimation.begin().thenLoop("walk"));
			}
			return event.setAndContinue(RawAnimation.begin().thenLoop("idle"));
		}
		return PlayState.STOP;
	}

	private PlayState procedurePredicate(AnimationState event) {
		if (!animationprocedure.equals("empty") && event.getController().getAnimationState() == AnimationController.State.STOPPED) {
			event.getController().setAnimation(RawAnimation.begin().thenPlay(this.animationprocedure));
			if (event.getController().getAnimationState() == AnimationController.State.STOPPED) {
				this.animationprocedure = "empty";
				event.getController().forceAnimationReset();
			}
		} else if (animationprocedure.equals("empty")) {
			return PlayState.STOP;
		}
		return PlayState.CONTINUE;
	}

	@Override
	protected void tickDeath() {
		++this.deathTime;
		if (this.deathTime == 20) {
			this.remove(WoodWormsEntity.RemovalReason.KILLED);
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
