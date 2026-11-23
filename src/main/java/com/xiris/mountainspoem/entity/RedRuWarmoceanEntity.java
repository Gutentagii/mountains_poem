package com.xiris.mountainspoem.entity;

import com.xiris.mountainspoem.MountainsPoemMod;
import com.xiris.mountainspoem.init.MountainsPoemModEntities;
import com.xiris.mountainspoem.init.MountainsPoemModItems;
import net.minecraft.core.BlockPos;
import net.minecraft.core.registries.Registries;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.util.Mth;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.control.MoveControl;
import net.minecraft.world.entity.ai.goal.BreathAirGoal;
import net.minecraft.world.entity.ai.goal.FollowBoatGoal;
import net.minecraft.world.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.world.entity.ai.goal.RandomSwimmingGoal;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.ai.navigation.PathNavigation;
import net.minecraft.world.entity.ai.navigation.WaterBoundPathNavigation;
import net.minecraft.world.entity.animal.frog.Frog;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraft.world.level.pathfinder.BlockPathTypes;
import net.minecraft.world.level.storage.loot.LootParams;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;
import net.minecraft.world.level.storage.loot.parameters.LootContextParams;
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

import java.util.Objects;

public class RedRuWarmoceanEntity extends PathfinderMob implements GeoEntity {
    public static final EntityDataAccessor<Boolean> SHOOT = SynchedEntityData.defineId(RedRuWarmoceanEntity.class, EntityDataSerializers.BOOLEAN);
    public static final EntityDataAccessor<String> ANIMATION = SynchedEntityData.defineId(RedRuWarmoceanEntity.class, EntityDataSerializers.STRING);
    public static final EntityDataAccessor<String> TEXTURE = SynchedEntityData.defineId(RedRuWarmoceanEntity.class, EntityDataSerializers.STRING);
    private final AnimatableInstanceCache cache = GeckoLibUtil.createInstanceCache(this);
    private boolean swinging;
    private long lastSwing;
    public String animationprocedure = "empty";

    public RedRuWarmoceanEntity(EntityType<RedRuWarmoceanEntity> type, Level world) {
        super(type, world);
        this.xpReward = 10;
        this.setNoAi(false);
        this.setPathfindingMalus(BlockPathTypes.WATER, 0);
        this.moveControl = new MoveControl(this) {
            @Override
            public void tick() {
                if (RedRuWarmoceanEntity.this.isInWater())
                    RedRuWarmoceanEntity.this.setDeltaMovement(RedRuWarmoceanEntity.this.getDeltaMovement().add(0, 0.005, 0));
                if (this.operation == MoveControl.Operation.MOVE_TO && !RedRuWarmoceanEntity.this.getNavigation().isDone()) {
                    double dx = this.wantedX - RedRuWarmoceanEntity.this.getX();
                    double dy = this.wantedY - RedRuWarmoceanEntity.this.getY();
                    double dz = this.wantedZ - RedRuWarmoceanEntity.this.getZ();
                    float f = (float) (Mth.atan2(dz, dx) * (180 / Math.PI)) - 90;
                    float f1 = (float) (this.speedModifier * RedRuWarmoceanEntity.this.getAttribute(Attributes.MOVEMENT_SPEED).getValue());
                    RedRuWarmoceanEntity.this.setYRot(this.rotlerp(RedRuWarmoceanEntity.this.getYRot(), f, 10));
                    RedRuWarmoceanEntity.this.yBodyRot = RedRuWarmoceanEntity.this.getYRot();
                    RedRuWarmoceanEntity.this.yHeadRot = RedRuWarmoceanEntity.this.getYRot();
                    if (RedRuWarmoceanEntity.this.isInWater()) {
                        RedRuWarmoceanEntity.this.setSpeed((float) RedRuWarmoceanEntity.this.getAttribute(Attributes.MOVEMENT_SPEED).getValue());
                        float f2 = -(float) (Mth.atan2(dy, (float) Math.sqrt(dx * dx + dz * dz)) * (180 / Math.PI));
                        f2 = Mth.clamp(Mth.wrapDegrees(f2), -85, 85);
                        RedRuWarmoceanEntity.this.setXRot(this.rotlerp(RedRuWarmoceanEntity.this.getXRot(), f2, 5));
                        float f3 = Mth.cos(RedRuWarmoceanEntity.this.getXRot() * (float) (Math.PI / 180.0));
                        RedRuWarmoceanEntity.this.setZza(f3 * f1);
                        RedRuWarmoceanEntity.this.setYya((float) (f1 * dy));
                    } else {
                        RedRuWarmoceanEntity.this.setSpeed(f1 * 0.05F);
                    }
                } else {
                    RedRuWarmoceanEntity.this.setSpeed(0);
                    RedRuWarmoceanEntity.this.setYya(0);
                    RedRuWarmoceanEntity.this.setZza(0);
                }
            }
        };
    }

    public RedRuWarmoceanEntity(PlayMessages.SpawnEntity packet, Level world) {
        this(MountainsPoemModEntities.RED_RU.get(), world);
    }

    @Override
    protected void defineSynchedData() {
        super.defineSynchedData();
        this.entityData.define(SHOOT, false);
        this.entityData.define(ANIMATION, "undefined");
        this.entityData.define(TEXTURE, "red_ru_common");
    }

    public void setTexture(String texture) {
        this.entityData.set(TEXTURE, texture);
    }

    public String getTexture() {
        return this.entityData.get(TEXTURE);
    }

    @Override
    protected PathNavigation createNavigation(Level world) {
        return new WaterBoundPathNavigation(this, world);
    }

    @Override
    protected void registerGoals() {
        super.registerGoals();
        this.goalSelector.addGoal(1, new RandomSwimmingGoal(this, 5, 40));
        this.targetSelector.addGoal(3, new NearestAttackableTargetGoal<>(this, Frog.class, false, true));
        this.goalSelector.addGoal(4, new BreathAirGoal(this));
        this.goalSelector.addGoal(5, new MeleeAttackGoal(this, 2.2, true) {
            @Override
            protected double getAttackReachSqr(LivingEntity entity) {
                return this.mob.getBbWidth() * this.mob.getBbWidth() + entity.getBbWidth();
            }
        });
        this.targetSelector.addGoal(6, new HurtByTargetGoal(this).setAlertOthers());
        this.goalSelector.addGoal(7, new FollowBoatGoal(this));
    }

    @Override
    public MobType getMobType() {
        return MobType.WATER;
    }

    @Override
    protected void dropCustomDeathLoot(DamageSource source, int looting, boolean recentlyHitIn) {
        super.dropCustomDeathLoot(source, looting, recentlyHitIn);
        this.spawnAtLocation(new ItemStack(MountainsPoemModItems.RED_RU_FISH.get()));
    }

    @Override
    public SoundEvent getAmbientSound() {
        return ForgeRegistries.SOUND_EVENTS.getValue(ResourceLocation.fromNamespaceAndPath(MountainsPoemMod.MOD_ID,"red_ru"));
    }

    @Override
    public void playStepSound(BlockPos pos, BlockState blockIn) {
        this.playSound(Objects.requireNonNull(ForgeRegistries.SOUND_EVENTS.getValue(ResourceLocation.fromNamespaceAndPath("minecraft", "entity.fish.swim"))), 0.15f, 1);
    }

    @Override
    public SoundEvent getHurtSound(DamageSource ds) {
        return ForgeRegistries.SOUND_EVENTS.getValue(ResourceLocation.fromNamespaceAndPath("minecraft", "entity.tropical_fish.hurt"));
    }

    @Override
    public SoundEvent getDeathSound() {
        return ForgeRegistries.SOUND_EVENTS.getValue(ResourceLocation.fromNamespaceAndPath("minecraft", "entity.generic.death"));
    }

    @Override
    public void die(DamageSource source) {
        super.die(source);
        LevelAccessor world = this.level();
        double x = this.getX();
        double y = this.getY();
        double z = this.getZ();

        if (!world.isClientSide() && world instanceof ServerLevel serverLevel) {
            String path = this.isOnFire() ? "entities/red_ru_2" : "entities/red_ru_1";
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
        this.setAirSupply(400);

        if (world.getBiome(BlockPos.containing(x, y, z)).is(ResourceLocation.fromNamespaceAndPath(MountainsPoemMod.MOD_ID,"deleted_mod_element")))
            this.setTexture("red_ru_hot");
        if (world.getBiome(BlockPos.containing(x, y, z)).is(ResourceLocation.fromNamespaceAndPath("minecraft", "swamp")))
            this.setTexture("red_ru_hot");
        if (world.getBiome(BlockPos.containing(x, y, z)).is(ResourceLocation.fromNamespaceAndPath("minecraft", "mangrove_swamp")))
            this.setTexture("red_ru_hot_2");
        if (world.getBiome(BlockPos.containing(x, y, z)).is(ResourceLocation.fromNamespaceAndPath("minecraft", "lush_caves")))
            this.setTexture("red_ru_common_2");
        if (world.getBiome(BlockPos.containing(x, y, z)).is(ResourceLocation.fromNamespaceAndPath("minecraft", "lukewarm_ocean")))
            this.setTexture("red_ru_common_3");
        if (world.getBiome(BlockPos.containing(x, y, z)).is(ResourceLocation.fromNamespaceAndPath("minecraft", "deep_lukewarm_ocean")))
            this.setTexture("red_ru_common_3");
        if (world.getBiome(BlockPos.containing(x, y, z)).is(ResourceLocation.fromNamespaceAndPath("minecraft", "frozen_river")))
            this.setTexture("red_ru_cold_2");
        if (world.getBiome(BlockPos.containing(x, y, z)).is(ResourceLocation.fromNamespaceAndPath("minecraft", "frozen_peaks")))
            this.setTexture("red_ru_cold_2");
        if (world.getBiome(BlockPos.containing(x, y, z)).is(ResourceLocation.fromNamespaceAndPath("minecraft", "deep_cold_ocean")))
            this.setTexture("red_ru_cold_2");
        if (world.getBiome(BlockPos.containing(x, y, z)).is(ResourceLocation.fromNamespaceAndPath("minecraft", "deep_frozen_ocean")))
            this.setTexture("red_ru_cold_3");
        if (world.getBiome(BlockPos.containing(x, y, z)).is(ResourceLocation.fromNamespaceAndPath("minecraft", "frozen_ocean")))
            this.setTexture("red_ru_cold_3");
        if (world.getBiome(BlockPos.containing(x, y, z)).is(ResourceLocation.fromNamespaceAndPath("minecraft", "cold_ocean")))
            this.setTexture("red_ru_cold_2");
        if (world.getBiome(BlockPos.containing(x, y, z)).is(ResourceLocation.fromNamespaceAndPath("minecraft", "snowy_plains")))
            this.setTexture("red_ru_cold");

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
        LevelAccessor world = this.level();
        if (this.isInWaterOrBubble())
            this.clearFire();
        else
            this.hurt(new DamageSource(world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(DamageTypes.DRY_OUT)), 0.1F);
        this.refreshDimensions();
    }

    @Override
    public EntityDimensions getDimensions(Pose pose) {
        return super.getDimensions(pose).scale(1.0F);
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
    public void aiStep() {
        super.aiStep();
        this.updateSwingTime();
    }

    public static void init() {
        SpawnPlacements.register(MountainsPoemModEntities.RED_RU.get(),
                SpawnPlacements.Type.IN_WATER,
                Heightmap.Types.MOTION_BLOCKING_NO_LEAVES,
                (entityType, world, reason, pos, random) ->
                        world.getBlockState(pos).is(Blocks.WATER) && world.getBlockState(pos.above()).is(Blocks.WATER)
        );
    }

    // 属性（已修复）
    public static AttributeSupplier.Builder createAttributes() {
        return Mob.createMobAttributes()
                .add(Attributes.MOVEMENT_SPEED, 0.3D)
                .add(Attributes.MAX_HEALTH, 15.0D)
                .add(Attributes.ARMOR, 0.0D)
                .add(Attributes.ATTACK_DAMAGE, 3.0D)
                .add(Attributes.FOLLOW_RANGE, 16.0D)
                .add(ForgeMod.SWIM_SPEED.get(), 0.3D);
    }

    // 动画
    private PlayState movementPredicate(AnimationState<?> event) {
        if (this.animationprocedure.equals("empty")) {
            if (event.isMoving() || this.isInWaterOrBubble())
                return event.setAndContinue(RawAnimation.begin().thenLoop("swim"));
            if (this.isDeadOrDying())
                return event.setAndContinue(RawAnimation.begin().thenPlay("dead"));
            return event.setAndContinue(RawAnimation.begin().thenLoop("idle"));
        }
        return PlayState.STOP;
    }

    private PlayState attackingPredicate(AnimationState<?> event) {
        if (this.getAttackAnim(event.getPartialTick()) > 0 && !this.swinging) {
            this.swinging = true;
            this.lastSwing = this.level().getGameTime();
        }
        if (this.swinging && this.lastSwing + 7L <= this.level().getGameTime())
            this.swinging = false;

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
        }
        return PlayState.CONTINUE;
    }

    @Override
    protected void tickDeath() {
        ++this.deathTime;
        if (this.deathTime == 20) {
            this.remove(RemovalReason.KILLED);
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