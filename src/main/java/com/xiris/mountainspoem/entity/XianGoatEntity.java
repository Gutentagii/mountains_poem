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
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
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

import java.util.List;
import java.util.Objects;

public class XianGoatEntity extends Animal implements GeoEntity {
	public static final EntityDataAccessor<Boolean> SHOOT = SynchedEntityData.defineId(XianGoatEntity.class, EntityDataSerializers.BOOLEAN);
	public static final EntityDataAccessor<String> ANIMATION = SynchedEntityData.defineId(XianGoatEntity.class, EntityDataSerializers.STRING);
	public static final EntityDataAccessor<String> TEXTURE = SynchedEntityData.defineId(XianGoatEntity.class, EntityDataSerializers.STRING);
	private final AnimatableInstanceCache cache = GeckoLibUtil.createInstanceCache(this);
	private boolean swinging;
	private boolean lastloop;
	private long lastSwing;
	public String animationprocedure = "empty";

	public XianGoatEntity(EntityType<XianGoatEntity> type, Level world) {
		super(type, world);
        this.xpReward = 0;
        this.setNoAi(false);
	}

    public XianGoatEntity(PlayMessages.SpawnEntity packet, Level world) {
        this(MountainsPoemModEntities.XIAN_GOAT.get(), world);
    }

	@Override
	protected void defineSynchedData() {
		super.defineSynchedData();
		this.entityData.define(SHOOT, false);
		this.entityData.define(ANIMATION, "undefined");
		this.entityData.define(TEXTURE, "xian_goat_1");
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
		this.goalSelector.addGoal(1, new PanicGoal(this, 1));
		this.goalSelector.addGoal(2, new RandomStrollGoal(this, 1.0D, 20));
		this.goalSelector.addGoal(3, new AvoidEntityGoal<>(this, LeiEntity.class, (float) 6, 1, 1.2));
		this.goalSelector.addGoal(4, new EatBlockGoal(this));
		this.goalSelector.addGoal(5, new RandomLookAroundGoal(this));
		this.goalSelector.addGoal(6, new FloatGoal(this));
		this.goalSelector.addGoal(7, new BreedGoal(this, 1));
		this.goalSelector.addGoal(8, new FollowParentGoal(this, 0.8));
	}

	@Override
	public MobType getMobType() {
		return MobType.UNDEFINED;
	}

	@Override
	public SoundEvent getAmbientSound() {
		return ForgeRegistries.SOUND_EVENTS.getValue(ResourceLocation.fromNamespaceAndPath("minecraft", "entity.goat.ambient"));
	}

	@Override
	public void playStepSound(BlockPos pos, BlockState blockIn) {
		this.playSound(Objects.requireNonNull(ForgeRegistries.SOUND_EVENTS.getValue(ResourceLocation.fromNamespaceAndPath("minecraft", "entity.goat.step"))), 0.15f, 1);
	}

	@Override
	public SoundEvent getHurtSound(DamageSource ds) {
		return ForgeRegistries.SOUND_EVENTS.getValue(ResourceLocation.fromNamespaceAndPath("minecraft", "entity.goat.hurt"));
	}

	@Override
	public SoundEvent getDeathSound() {
		return ForgeRegistries.SOUND_EVENTS.getValue(ResourceLocation.fromNamespaceAndPath("minecraft", "entity.goat.death"));
	}

    @Override
    public void die(DamageSource source) {
        super.die(source);
        LevelAccessor world = this.level();
        double x = this.getX();
        double y = this.getY();
        double z = this.getZ();

        if (world instanceof ServerLevel serverLevel) {
            String path = this.isOnFire() ? "entities/xian_2" : "entities/xian_1";
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
	public SpawnGroupData finalizeSpawn(ServerLevelAccessor world, DifficultyInstance difficulty, MobSpawnType reason, @Nullable SpawnGroupData livingdata, @Nullable CompoundTag tag) {
		SpawnGroupData retval = super.finalizeSpawn(world, difficulty, reason, livingdata, tag);
        double x = this.getX();
        double y = this.getY();
        double z = this.getZ();
        if ((Entity) this instanceof XianGoatEntity animatable)
            if (world.getBiome(BlockPos.containing(x, y, z)).is(ResourceLocation.fromNamespaceAndPath("minecraft", "savanna")))
                animatable.setTexture("xian_goat_2");
            else if (world.getBiome(BlockPos.containing(x, y, z)).is(ResourceLocation.fromNamespaceAndPath("minecraft", "snowy_plains")))
                animatable.setTexture("xian_goat_3");
            else if (world.getBiome(BlockPos.containing(x, y, z)).is(ResourceLocation.fromNamespaceAndPath("minecraft", "jagged_peaks")))
                animatable.setTexture("xian_goat_3");
            else if (world.getBiome(BlockPos.containing(x, y, z)).is(ResourceLocation.fromNamespaceAndPath("minecraft", "snowy_slopes")))
                animatable.setTexture("xian_goat_3");
            else if (world.getBiome(BlockPos.containing(x, y, z)).is(ResourceLocation.fromNamespaceAndPath("minecraft", "meadow")))
                animatable.setTexture("xian_goat_2");
            else if (world.getBiome(BlockPos.containing(x, y, z)).is(ResourceLocation.fromNamespaceAndPath("minecraft", "jungle")))
                if (Math.random() < 0.7) animatable.setTexture("xian_goat_4_b");
                else animatable.setTexture("xian_goat_4");
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
    public InteractionResult mobInteract(Player sourceentity, InteractionHand hand) {
        ItemStack itemstack = sourceentity.getItemInHand(hand);
        InteractionResult retval = InteractionResult.sidedSuccess(this.level().isClientSide());
        super.mobInteract(sourceentity, hand);
        double x = this.getX();
        double y = this.getY();
        double z = this.getZ();
        Level world = this.level();

        if (sourceentity.getMainHandItem().is(Blocks.MOSS_CARPET.asItem())) {
            if (this.getTexture().equals("xian_goat_1")) {
                this.setTexture("xian_goat_1_b");
                world.playSound(null, x, y, z, SoundEvents.GRASS_PLACE, sourceentity.getSoundSource(), 1, 1);
                sourceentity.getInventory().clearOrCountMatchingItems(p -> p.is(Blocks.MOSS_CARPET.asItem()), 1, sourceentity.inventoryMenu.getCraftSlots());
            }
            if (this.getTexture().equals("xian_goat_2")) {
                this.setTexture("xian_goat_2_b");
                world.playSound(null, x, y, z, SoundEvents.GRASS_PLACE, sourceentity.getSoundSource(), 1, 1);
                sourceentity.getInventory().clearOrCountMatchingItems(p -> p.is(Blocks.MOSS_CARPET.asItem()), 1, sourceentity.inventoryMenu.getCraftSlots());
            }
            if (this.getTexture().equals("xian_goat_3")) {
                this.setTexture("xian_goat_3_b");
                world.playSound(null, x, y, z, SoundEvents.GRASS_PLACE, sourceentity.getSoundSource(), 1, 1);
                sourceentity.getInventory().clearOrCountMatchingItems(p -> p.is(Blocks.MOSS_CARPET.asItem()), 1, sourceentity.inventoryMenu.getCraftSlots());
            }
            if (this.getTexture().equals("xian_goat_4")) {
                this.setTexture("xian_goat_4_b");
                world.playSound(null, x, y, z, SoundEvents.AZALEA_LEAVES_BREAK, sourceentity.getSoundSource(), 1, 1);
                sourceentity.getInventory().clearOrCountMatchingItems(p -> p.is(Blocks.MOSS_CARPET.asItem()), 1, sourceentity.inventoryMenu.getCraftSlots());
            }
            sourceentity.swing(InteractionHand.MAIN_HAND, true);
        }
        if (sourceentity.getMainHandItem().is(Items.SHEARS)) {
            boolean success = false;
            if (this.getTexture().equals("xian_goat_1_b")) {
                this.setTexture("xian_goat_1");
                success = true;
            } else if (this.getTexture().equals("xian_goat_2_b")) {
                this.setTexture("xian_goat_2");
                success = true;
            } else if (this.getTexture().equals("xian_goat_3_b")) {
                this.setTexture("xian_goat_3");
                success = true;
            } else if (this.getTexture().equals("xian_goat_4_b")) {
                this.setTexture("xian_goat_4");
                success = true;
            }

            if (success) {
                world.playSound(null, x, y, z, SoundEvents.AZALEA_LEAVES_BREAK, sourceentity.getSoundSource(), 1, 1);
                if (world instanceof ServerLevel serverLevel) {
                    ItemEntity item = new ItemEntity(serverLevel, x, y, z, Blocks.MOSS_CARPET.asItem().getDefaultInstance());
                    serverLevel.addFreshEntity(item);
                }
                sourceentity.swing(InteractionHand.MAIN_HAND, true);
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
		return super.getDimensions(p_33597_).scale((float) 1);
	}

	@Override
	public AgeableMob getBreedOffspring(ServerLevel serverWorld, AgeableMob ageable) {
		XianGoatEntity retval = MountainsPoemModEntities.XIAN_GOAT.get().create(serverWorld);
		retval.finalizeSpawn(serverWorld, serverWorld.getCurrentDifficultyAt(retval.blockPosition()), MobSpawnType.BREEDING, null, null);
		return retval;
	}

	@Override
	public boolean isFood(ItemStack stack) {
		return List.of(Items.SWEET_BERRIES, Items.GLOW_BERRIES).contains(stack.getItem());
	}

	@Override
	public void aiStep() {
		super.aiStep();
		this.updateSwingTime();
	}

	public static void init() {
		SpawnPlacements.register(MountainsPoemModEntities.XIAN_GOAT.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES,
				(entityType, world, reason, pos, random) -> (world.getBlockState(pos.below()).is(BlockTags.ANIMALS_SPAWNABLE_ON) && world.getRawBrightness(pos, 0) > 8));
	}

	public static AttributeSupplier.Builder createAttributes() {
		AttributeSupplier.Builder builder = Mob.createMobAttributes();
		builder = builder.add(Attributes.MOVEMENT_SPEED, 0.33);
		builder = builder.add(Attributes.MAX_HEALTH, 60);
		builder = builder.add(Attributes.ARMOR, 0);
		builder = builder.add(Attributes.ATTACK_DAMAGE, 3);
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
				return event.setAndContinue(RawAnimation.begin().thenLoop("walk"));
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
			this.remove(XianGoatEntity.RemovalReason.KILLED);
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
