package com.xiris.mountainspoem.entity;

import com.xiris.mountainspoem.MountainsPoemMod;
import com.xiris.mountainspoem.init.MountainsPoemModEntities;
import com.xiris.mountainspoem.init.MountainsPoemModSounds;
import com.xiris.mountainspoem.procedures.*;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
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
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.ai.goal.target.OwnerHurtByTargetGoal;
import net.minecraft.world.entity.animal.Chicken;
import net.minecraft.world.entity.animal.Cow;
import net.minecraft.world.entity.animal.Sheep;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.SpawnEggItem;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.ServerLevelAccessor;
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

import java.util.Objects;

public class LeiEntity extends TamableAnimal implements GeoEntity {
    public static final EntityDataAccessor<Boolean> SHOOT = SynchedEntityData.defineId(LeiEntity.class, EntityDataSerializers.BOOLEAN);
    public static final EntityDataAccessor<String> ANIMATION = SynchedEntityData.defineId(LeiEntity.class, EntityDataSerializers.STRING);
    public static final EntityDataAccessor<String> TEXTURE = SynchedEntityData.defineId(LeiEntity.class, EntityDataSerializers.STRING);
    private final AnimatableInstanceCache cache = GeckoLibUtil.createInstanceCache(this);
    private boolean swinging;
    private boolean lastloop;
    private long lastSwing;
    public String animationprocedure = "empty";

    public LeiEntity(EntityType<LeiEntity> type, Level world) {
        super(type, world);
        this.xpReward = 5;
        this.setNoAi(false);
    }

    public LeiEntity(PlayMessages.SpawnEntity packet, Level world) {
        this(MountainsPoemModEntities.LEI.get(), world);
    }

    @Override
    protected void defineSynchedData() {
        super.defineSynchedData();
        this.entityData.define(SHOOT, false);
        this.entityData.define(ANIMATION, "undefined");
        this.entityData.define(TEXTURE, "lei_lion");
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
        this.goalSelector.addGoal(1, new RandomStrollGoal(this, 1.0D, 20));
        this.goalSelector.addGoal(2, new MeleeAttackGoal(this, 1.5, true) {
            @Override
            protected double getAttackReachSqr(LivingEntity entity) {
                return this.mob.getBbWidth() * this.mob.getBbWidth() + entity.getBbWidth();
            }
        });
        this.goalSelector.addGoal(3, new RandomLookAroundGoal(this));
        this.goalSelector.addGoal(4, new FloatGoal(this));
        this.targetSelector.addGoal(5, new HurtByTargetGoal(this).setAlertOthers());
        this.goalSelector.addGoal(6, new BreedGoal(this, 1));
        this.goalSelector.addGoal(7, new FollowParentGoal(this, 0.8));
        this.goalSelector.addGoal(8, new FollowOwnerGoal(this, 1, 10, 2, false));
        this.goalSelector.addGoal(9, new OwnerHurtByTargetGoal(this));
        this.targetSelector.addGoal(10, new NearestAttackableTargetGoal<>(this, Sheep.class, true, false));
        this.targetSelector.addGoal(11, new NearestAttackableTargetGoal<>(this, BoshiGoatEntity.class, true, false));
        this.targetSelector.addGoal(12, new NearestAttackableTargetGoal<>(this, ChangfuChickenPlainsEntity.class, true, false));
        this.targetSelector.addGoal(13, new NearestAttackableTargetGoal<>(this, HuHorseEntity.class, true, false));
        this.targetSelector.addGoal(14, new NearestAttackableTargetGoal<>(this, ZuoCowEntity.class, true, false));
        this.targetSelector.addGoal(15, new NearestAttackableTargetGoal<>(this, XianGoatEntity.class, true, false));
        this.targetSelector.addGoal(16, new NearestAttackableTargetGoal<>(this, WhiteMonkeyEntity.class, true, false));
        this.targetSelector.addGoal(17, new NearestAttackableTargetGoal<>(this, Cow.class, true, false));
        this.targetSelector.addGoal(18, new NearestAttackableTargetGoal<>(this, LongChiEntity.class, true, false));
        this.targetSelector.addGoal(19, new NearestAttackableTargetGoal<>(this, MinQuBirdEntity.class, true, false));
        this.targetSelector.addGoal(20, new NearestAttackableTargetGoal<>(this, HuiHorseEntity.class, true, false));
        this.targetSelector.addGoal(21, new NearestAttackableTargetGoal<>(this, LushuhorseEntity.class, true, false));
        this.targetSelector.addGoal(22, new NearestAttackableTargetGoal<>(this, Chicken.class, true, false));
    }

    @Override
    public MobType getMobType() {
        return MobType.UNDEFINED;
    }

    @Override
    public SoundEvent getAmbientSound() {
        return ForgeRegistries.SOUND_EVENTS.getValue(ResourceLocation.fromNamespaceAndPath(MountainsPoemMod.MOD_ID,"lei_ambient"));
    }

    @Override
    public SoundEvent getHurtSound(DamageSource ds) {
        return ForgeRegistries.SOUND_EVENTS.getValue(ResourceLocation.fromNamespaceAndPath(MountainsPoemMod.MOD_ID,"lei_hurt"));
    }

    @Override
    public SoundEvent getDeathSound() {
        return ForgeRegistries.SOUND_EVENTS.getValue(ResourceLocation.fromNamespaceAndPath(MountainsPoemMod.MOD_ID,"lei_death"));
    }

    @Override
    public void die(DamageSource source) {
        super.die(source);
        LevelAccessor world = this.level();
        double x = this.getX();
        double y = this.getY();
        double z = this.getZ();

        if (!this.isBaby() && world instanceof ServerLevel serverWorld) {
            if (this.getTexture().equals("lei_lion_6") || this.getTexture().equals("lei_lion_3")) {
                dropLoot(serverWorld, x, y, z, this.isOnFire() ? "lei_b" : "lei_a");
            } else {
                if (this.getTexture().equals("lei_lion") || this.getTexture().equals("lei_lion_2")) {
                    dropLoot(serverWorld, x, y, z, this.isOnFire() ? "entities/leis_2" : "entities/leis_1");
                } else if (this.getTexture().equals("lei_lion_4") || this.getTexture().equals("lei_lion_5")) {
                    dropLoot(serverWorld, x, y, z, this.isOnFire() ? "entities/leis_4" : "entities/leis_3");
                }
            }
        }
    }


    private void dropLoot(ServerLevel level, double x, double y, double z, String path) {
        ResourceLocation lootTable = ResourceLocation.fromNamespaceAndPath(MountainsPoemMod.MOD_ID, path);

        LootParams params = new LootParams.Builder(level)
                .withParameter(LootContextParams.ORIGIN, new Vec3(x, y, z))
                .withParameter(LootContextParams.THIS_ENTITY, this)
                .create(LootContextParamSets.CHEST);

        level.getServer().getLootData().getLootTable(lootTable)
                .getRandomItems(params)
                .forEach(stack -> {
                    ItemEntity item = new ItemEntity(level, x, y, z, stack);
                    level.addFreshEntity(item);
                });
    }

    @Override
    public SpawnGroupData finalizeSpawn(ServerLevelAccessor world, DifficultyInstance difficulty, MobSpawnType reason, @Nullable SpawnGroupData livingdata, @Nullable CompoundTag tag) {
        SpawnGroupData retval = super.finalizeSpawn(world, difficulty, reason, livingdata, tag);
        if (world.getBiome(BlockPos.containing(this.getX(), this.getY(), this.getZ())).is(ResourceLocation.fromNamespaceAndPath(MountainsPoemMod.MOD_ID, "shatang_forest"))) {
            this.setTexture("lei_lion_4");
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

    @Override
    public InteractionResult mobInteract(Player sourceentity, InteractionHand hand) {
        ItemStack itemstack = sourceentity.getItemInHand(hand);
        InteractionResult retval = InteractionResult.sidedSuccess(this.level().isClientSide());

        if (itemstack.getItem() instanceof SpawnEggItem) {
            retval = super.mobInteract(sourceentity, hand);
        } else if (this.level().isClientSide()) {
            retval = (this.isTame() && this.isOwnedBy(sourceentity) || this.isFood(itemstack))
                    ? InteractionResult.SUCCESS
                    : InteractionResult.PASS;
        } else {
            if (this.isTame()) {
                if (this.isOwnedBy(sourceentity)) {
                    if (itemstack.isEdible() && this.isFood(itemstack) && this.getHealth() < this.getMaxHealth()) {
                        this.usePlayerItem(sourceentity, hand, itemstack);
                        this.heal((float) itemstack.getItem().getFoodProperties().getNutrition());
                        retval = InteractionResult.SUCCESS;
                    } else if (this.isFood(itemstack) && this.getHealth() < this.getMaxHealth()) {
                        this.usePlayerItem(sourceentity, hand, itemstack);
                        this.heal(4);
                        retval = InteractionResult.SUCCESS;
                    } else {
                        retval = super.mobInteract(sourceentity, hand);
                    }
                }
            } else if (this.isFood(itemstack)) {
                this.usePlayerItem(sourceentity, hand, itemstack);
                if (this.random.nextInt(3) == 0 && !net.minecraftforge.event.ForgeEventFactory.onAnimalTame(this, sourceentity)) {
                    this.tame(sourceentity);
                    this.level().broadcastEntityEvent(this, (byte) 7);
                } else {
                    this.level().broadcastEntityEvent(this, (byte) 6);
                }
                this.setPersistenceRequired();
                retval = InteractionResult.SUCCESS;
            } else {
                retval = super.mobInteract(sourceentity, hand);
                if (retval == InteractionResult.SUCCESS || retval == InteractionResult.CONSUME)
                    this.setPersistenceRequired();
            }
        }

        double x = this.getX();
        double y = this.getY();
        double z = this.getZ();
        Level world = this.level();

        // 喂食
        if (sourceentity.getMainHandItem().is(ItemTags.create(ResourceLocation.fromNamespaceAndPath(MountainsPoemMod.MOD_ID, "lei_foods")))) {
            sourceentity.swing(InteractionHand.MAIN_HAND, true);
            sourceentity.getMainHandItem().shrink(1);

            if (!world.isClientSide()) {
                world.playSound(null, x, y, z, MountainsPoemModSounds.LEI.get(), SoundSource.NEUTRAL, 1, 2);
            }

            if (this.isBaby() && (this.getTexture().equals("lei_lion_3") || this.getTexture().equals("lei_lion_6"))) {
                if (world instanceof ServerLevel _level)
                    _level.sendParticles(ParticleTypes.HEART, x, y, z, 5, 3, 3, 3, 1);
                if (Math.random() < 0.7)
                    this.setAnimation("thanks");
            } else {
                if (world instanceof ServerLevel _level)
                    _level.sendParticles(ParticleTypes.HEART, x, y, z, 5, 3, 3, 3, 1);
                if (Math.random() < 0.3)
                    this.setAnimation("hello");
            }
        }

        // 剪毛 1
        if ((this.getTexture().equals("lei_lion") || this.getTexture().equals("lei_lion_2"))) {
            if (sourceentity.getMainHandItem().is(ItemTags.create(ResourceLocation.fromNamespaceAndPath("forge", "shears")))) {
                sourceentity.swing(InteractionHand.MAIN_HAND, true);
                ItemStack stack = sourceentity.getMainHandItem();
                if (stack.hurt(1, RandomSource.create(), null)) {
                    stack.shrink(1);
                    stack.setDamageValue(0);
                }
                this.setAnimation("hair");

                if (world instanceof ServerLevel serverWorld)
                    dropLoot(serverWorld, x, y, z, "lei_hair_1");

                if (!world.isClientSide()) {
                    world.playSound(null, x, y, z, MountainsPoemModSounds.LEI_2.get(), SoundSource.NEUTRAL, 1, 1);
                }

                this.setTexture("lei_lion_3");
            }
        }

        // 剪毛 2
        if ((this.getTexture().equals("lei_lion_4") || this.getTexture().equals("lei_lion_5"))) {
            if (sourceentity.getMainHandItem().is(ItemTags.create(ResourceLocation.fromNamespaceAndPath("forge", "shears")))) {
                sourceentity.swing(InteractionHand.MAIN_HAND, true);
                ItemStack stack = sourceentity.getMainHandItem();
                if (stack.hurt(1, RandomSource.create(), null)) {
                    stack.shrink(1);
                    stack.setDamageValue(0);
                }
                this.setAnimation("hair");

                if (world instanceof ServerLevel serverWorld)
                    dropLoot(serverWorld, x, y, z, "lei_hair_2");

                if (!world.isClientSide()) {
                    world.playSound(null, x, y, z, MountainsPoemModSounds.LEI_2.get(), SoundSource.NEUTRAL, 1, 1);
                }

                this.setTexture("lei_lion_6");
            }
        }

        return retval;
    }

    @Override
    public void awardKillScore(Entity entity, int score, DamageSource damageSource) {
        super.awardKillScore(entity, score, damageSource);
        LevelAccessor world = this.level();

        if (Math.random() < 0.9) {
            if (entity instanceof LeiEntity animatable && animatable.getTexture().equals("lei_lion"))
                animatable.setTexture("lei_lion_2");
            if (entity instanceof LeiEntity animatable && animatable.getTexture().equals("lei_lion_4"))
                animatable.setTexture("lei_lion_5");
        }
        if (Math.random() < 0.3) {
            if (entity instanceof LeiEntity lei)
                lei.setAnimation("play");
            if (world instanceof Level _level && !_level.isClientSide())
                _level.playSound(null, this.getX(), this.getY(), this.getZ(), MountainsPoemModSounds.LEI.get(), SoundSource.NEUTRAL, 1, 1);
        }
    }

    @Override
    public void baseTick() {
        super.baseTick();
        LevelAccessor world = this.level();

        if (this.animationprocedure.equals("idle")) {
            if (Math.random() < 0.2)
                this.setAnimation("play");
            if (Math.random() < 0.2 && !(world instanceof Level _lvl2 && _lvl2.isDay()))
                this.setAnimation("hello");
            if (this.isSprinting())
                this.setAnimation("sprint");
            if (this.getTexture().equals("lei_lion_5") || this.getTexture().equals("lei_lion_2")) {
                this.setHealth(this.getMaxHealth() + 10);
                if (!world.isClientSide())
                    this.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 3, 2, false, false));
            }
            if (this.isInWater()) {
                if (this.getTexture().equals("lei_lion_2"))
                    this.setTexture("lei_lion");
                if (this.getTexture().equals("lei_lion_5"))
                    this.setTexture("lei_lion_4");
            }
            if (Math.random() < 0.01) {
                if (this.getTexture().equals("lei_lion_6") && Math.random() < 0.6)
                    this.setTexture("lei_lion_4");
                if (this.getTexture().equals("lei_lion_3") && Math.random() < 0.6)
                    this.setTexture("lei_lion");
            }
        }
        this.refreshDimensions();
    }

    @Override
    public EntityDimensions getDimensions(Pose p_33597_) {
        return super.getDimensions(p_33597_).scale(1F);
    }

    @Override
    public AgeableMob getBreedOffspring(ServerLevel serverWorld, AgeableMob ageable) {
        LeiEntity retval = MountainsPoemModEntities.LEI.get().create(serverWorld);
        retval.finalizeSpawn(serverWorld, serverWorld.getCurrentDifficultyAt(retval.blockPosition()), MobSpawnType.BREEDING, null, null);
        return retval;
    }

    @Override
    public boolean isFood(ItemStack stack) {
        return Objects.equals(Items.BEEF, stack.getItem());
    }

    @Override
    public void aiStep() {
        super.aiStep();
        this.updateSwingTime();
    }

    public static void init() {
        SpawnPlacements.register(MountainsPoemModEntities.LEI.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES,
                (entityType, world, reason, pos, random) -> (world.getBlockState(pos.below()).is(BlockTags.ANIMALS_SPAWNABLE_ON) && world.getRawBrightness(pos, 0) > 8));
    }

    public static AttributeSupplier.Builder createAttributes() {
        return Mob.createMobAttributes()
                .add(Attributes.MOVEMENT_SPEED, 0.2)
                .add(Attributes.MAX_HEALTH, 50)
                .add(Attributes.ARMOR, 0.6)
                .add(Attributes.ATTACK_DAMAGE, 6)
                .add(Attributes.FOLLOW_RANGE, 40)
                .add(Attributes.ATTACK_KNOCKBACK, 0.1);
    }

    private PlayState movementPredicate(AnimationState<?> event) {
        if (this.animationprocedure.equals("empty")) {
            if ((event.isMoving() || !(event.getLimbSwingAmount() > -0.15F && event.getLimbSwingAmount() < 0.15F)) && !this.isAggressive()) {
                return event.setAndContinue(RawAnimation.begin().thenLoop("walk"));
            }
            if (this.isDeadOrDying()) {
                return event.setAndContinue(RawAnimation.begin().thenPlay("dead"));
            }
            if (this.isInWaterOrBubble()) {
                return event.setAndContinue(RawAnimation.begin().thenLoop("walk"));
            }
            if (this.isSprinting()) {
                return event.setAndContinue(RawAnimation.begin().thenLoop("sprint"));
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
        if (this.deathTime == 15) {
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