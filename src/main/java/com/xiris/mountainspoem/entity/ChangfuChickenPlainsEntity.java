package com.xiris.mountainspoem.entity;

import com.xiris.mountainspoem.MountainsPoemMod;
import com.xiris.mountainspoem.init.*;
import net.minecraft.advancements.Advancement;
import net.minecraft.advancements.AdvancementProgress;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.network.protocol.game.ClientboundOpenScreenPacket;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.RandomSource;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.animal.Chicken;
import net.minecraft.world.entity.animal.Fox;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.monster.Silverfish;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.ServerLevelAccessor;
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

import java.awt.*;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.net.URLConnection;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class ChangfuChickenPlainsEntity extends Animal implements GeoEntity {
    public static final EntityDataAccessor<Boolean> SHOOT = SynchedEntityData.defineId(ChangfuChickenPlainsEntity.class, EntityDataSerializers.BOOLEAN);
    public static final EntityDataAccessor<String> ANIMATION = SynchedEntityData.defineId(ChangfuChickenPlainsEntity.class, EntityDataSerializers.STRING);
    public static final EntityDataAccessor<String> TEXTURE = SynchedEntityData.defineId(ChangfuChickenPlainsEntity.class, EntityDataSerializers.STRING);
    private final AnimatableInstanceCache cache = GeckoLibUtil.createInstanceCache(this);
    private boolean swinging;
    private boolean lastloop;
    private long lastSwing;
    public String animationprocedure = "empty";
    private Chicken boundChicken;
    private final Map<Chicken, Integer> QboundChicken = new HashMap<>();


    public ChangfuChickenPlainsEntity(EntityType<ChangfuChickenPlainsEntity> type, Level world) {
        super(type, world);
        this.xpReward = 10;
        this.setNoAi(false);
    }

    public ChangfuChickenPlainsEntity(PlayMessages.SpawnEntity packet, Level world) {
        this(MountainsPoemModEntities.CHANGFU_CHICKEN.get(), world);
    }

    @Override
    protected void defineSynchedData() {
        super.defineSynchedData();
        this.entityData.define(SHOOT, false);
        this.entityData.define(ANIMATION, "undefined");
        this.entityData.define(TEXTURE, "changfu_chicken");
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
        this.goalSelector.addGoal(2, new MeleeAttackGoal(this, 1.2D, true) {
            @Override
            protected double getAttackReachSqr(LivingEntity entity) {
                return Math.pow(this.mob.getBbWidth() * 2.0F + entity.getBbWidth(), 2);
            }
        });

        this.targetSelector.addGoal(1, new NearestAttackableTargetGoal<>(this, Player.class, true,
                livingEntity -> {
                    if (!(livingEntity instanceof Player player)) return false;
                    ItemStack mainHand = player.getMainHandItem();
                    if (mainHand.isEmpty()) return false;

                    boolean holdsChicken = mainHand.is(Items.CHICKEN) || mainHand.is(MountainsPoemModItems.CHANGFU_CHICKEN.get());
                    boolean isNotCreative = !player.isCreative();
                    boolean isClose = this.distanceTo(player) < 12.0D;
                    boolean isAttackerOfBoundChicken = boundChicken != null && livingEntity.getLastHurtMob() == boundChicken;

                    return (holdsChicken && isNotCreative && isClose) || isAttackerOfBoundChicken;
                }
        ));

        this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, Fox.class, true, livingEntity -> {
            if (livingEntity.getLastHurtMob() == this) return true;
            return boundChicken != null && livingEntity.getLastHurtMob() == boundChicken;
        }));

        this.targetSelector.addGoal(3, new NearestAttackableTargetGoal<>(this, Silverfish.class, true, true));
        this.targetSelector.addGoal(4, new NearestAttackableTargetGoal<>(this, WoodWormsEntity.class, true, true));
        this.goalSelector.addGoal(1, new FloatGoal(this));
        this.goalSelector.addGoal(3, new BreedGoal(this, 1.0D));
        this.goalSelector.addGoal(4, new FollowParentGoal(this, 0.8D));
        this.goalSelector.addGoal(5, new RandomStrollGoal(this, 1.0D));
        this.goalSelector.addGoal(6, new RandomLookAroundGoal(this));
        this.targetSelector.addGoal(10, new HurtByTargetGoal(this).setAlertOthers());
    }

    @Override
    public MobType getMobType() {
        return MobType.UNDEFINED;
    }

    @Override
    public SoundEvent getAmbientSound() {
        return ForgeRegistries.SOUND_EVENTS.getValue(ResourceLocation.fromNamespaceAndPath(MountainsPoemMod.MOD_ID,"changfu_bird"));
    }

    @Override
    public boolean isFood(ItemStack stack) {
        Item item = stack.getItem();
        return item == Items.WHEAT || item == Items.SUGAR_CANE;
    }

    @Override
    public boolean canBeLeashed(Player player) {
        return true;
    }

    @Override
    public void playStepSound(BlockPos pos, BlockState blockIn) {
        this.playSound(Objects.requireNonNull(ForgeRegistries.SOUND_EVENTS.getValue(ResourceLocation.fromNamespaceAndPath("minecraft", "entity.chicken.step"))), 0.15f, 1);
    }

    private int LenChicken;

    private void SChicken() {
        if (this.boundChicken != null && this.boundChicken.isAlive()) {
            if (this.distanceToSqr(this.boundChicken) > 80 * 80) {
                this.boundChicken = null;
            } else {
                return;
            }
        }

        if (this.LenChicken-- > 0) return;
        this.LenChicken = 40;

        for (Chicken chicken : this.level().getEntitiesOfClass(Chicken.class, this.getBoundingBox().inflate(16.0D), entity -> {
            return entity.isAlive() && !isChickenBoundByOther(entity);
        })) {
            this.boundChicken = chicken;
            break;
        }
    }

    private boolean isChickenBoundByOther(Chicken chicken) {
        for (ChangfuChickenPlainsEntity entity : this.level().getEntitiesOfClass(ChangfuChickenPlainsEntity.class, chicken.getBoundingBox().inflate(80))) {
            if (entity != this && entity.boundChicken == chicken) {
                return true;
            }
        }
        return false;
    }

    private void controlBoundChicken() {
        if (this.boundChicken == null || !this.boundChicken.isAlive()) {
            return;
        }

        LivingEntity target = this.getTarget();
        if (target == null || !target.isAlive()) {
            if (this.boundChicken.distanceToSqr(this) > 4.0D) {
                this.boundChicken.getNavigation().moveTo(this, 1.0D);
            }
            return;
        }

        this.boundChicken.getNavigation().moveTo(target, 1.0D);

        int cooldown = QboundChicken.getOrDefault(this.boundChicken, 0);

        if (cooldown > 0) {
            QboundChicken.put(this.boundChicken, cooldown - 1);
            return;
        }

        if (this.boundChicken.distanceToSqr(target) <= 2.25D) {
            DamageSource damageSource = this.boundChicken.damageSources().mobAttack(this.boundChicken);
            if (target.hurt(damageSource, 1.0F)) {
                this.boundChicken.swing(InteractionHand.MAIN_HAND, true);
                QboundChicken.put(this.boundChicken, 40);
            }
        }
    }

    @Override
    public SoundEvent getHurtSound(DamageSource ds) {
        return ForgeRegistries.SOUND_EVENTS.getValue(ResourceLocation.fromNamespaceAndPath("minecraft","entity.generic.hurt"));
    }

    @Override
    public SoundEvent getDeathSound() {
        return ForgeRegistries.SOUND_EVENTS.getValue(ResourceLocation.fromNamespaceAndPath("minecraft","entity.generic.death"));
    }

    @Override
    public boolean hurt(DamageSource source, float amount) {
        if (source.is(DamageTypes.FALL))
            return false;

        boolean hurt = super.hurt(source, amount);

        if (hurt && !this.level().isClientSide() && this.random.nextFloat() < 0.4F) {
            long chickenCount = this.level().getEntitiesOfClass(Chicken.class, this.getBoundingBox().inflate(10.0D)).size();
            int heal = (int) Math.min(chickenCount, 4);

            if (heal > 0) {
                this.heal(heal);
            }

            for (int i = 0; i < 4; i++) {
                double x = this.getX() + (this.random.nextDouble() - 0.5D) * 1.5D;
                double y = this.getY() + this.random.nextDouble() * 1.5D;
                double z = this.getZ() + (this.random.nextDouble() - 0.5D) * 1.5D;
                this.level().addParticle(MountainsPoemModParticleTypes.SACRIFICE_N.get(), x, y, z, 0, 0, 0);
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
                    for (ItemStack itemstackiterator : world.getServer().getLootData().getLootTable(ResourceLocation.fromNamespaceAndPath(MountainsPoemMod.MOD_ID,"entities/changfu_2"))
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
                    for (ItemStack itemstackiterator : world.getServer().getLootData().getLootTable(ResourceLocation.fromNamespaceAndPath(MountainsPoemMod.MOD_ID,"entities/changfu_1"))
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
        this.removeAllEffects();
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

        if (sourceentity.getMainHandItem().is(MountainsPoemModItems.TEETH_GRAVER.get()) && sourceentity.getOffhandItem().is(MountainsPoemModItems.XUAN_SHELLS.get())) {
            sourceentity.getOffhandItem().shrink(1);

            if (!world.isClientSide()) {
                ItemEntity item = new ItemEntity(world, x, y, z, new ItemStack(MountainsPoemModItems.ENGRAVED_XUAN_SHELLS_CHANGFU.get()));
                world.addFreshEntity(item);

                world.playSound(null, x, y, z, MountainsPoemModSounds.CARVED_SHELLS.get(), SoundSource.PLAYERS, 1, 1);
            }

            if (!sourceentity.getAbilities().instabuild) {
                ItemStack stack = sourceentity.getMainHandItem();
                if (stack.hurt(1, RandomSource.create(), null)) {
                    stack.shrink(1);
                    stack.setDamageValue(0);
                }
            }

            sourceentity.swing(InteractionHand.MAIN_HAND, true);
            if (sourceentity instanceof ServerPlayer _player) {
                Advancement advancement = _player.server.getAdvancements().getAdvancement(ResourceLocation.fromNamespaceAndPath(MountainsPoemMod.MOD_ID,"engrave_xuan_shells"));
                AdvancementProgress ap = _player.getAdvancements().getOrStartProgress(advancement);
                if (!ap.isDone())
                    for (String criteria : ap.getRemainingCriteria())
                        _player.getAdvancements().award(advancement, criteria);
            }
        }
        return retval;
    }

    @Override
    public void baseTick() {
        super.baseTick();
        if (this.getDisplayName().getString().equals("IKUN"))
            this.setTexture("changfu_ikun");
        else if (this.getDisplayName().getString().equals("kfc") || this.getDisplayName().getString().equals("KFC")) {
            this.setTexture("changfu_kfc");
        } else
            this.setTexture("changfu_chicken");

        SChicken();

        controlBoundChicken();

        this.refreshDimensions();
    }


    @Override
    public EntityDimensions getDimensions(Pose p_33597_) {
        return super.getDimensions(p_33597_).scale(1.0F);
    }

    @Override
    public AgeableMob getBreedOffspring(ServerLevel serverWorld, AgeableMob ageable) {
        ChangfuChickenPlainsEntity retval = MountainsPoemModEntities.CHANGFU_CHICKEN.get().create(serverWorld);
        retval.finalizeSpawn(serverWorld, serverWorld.getCurrentDifficultyAt(retval.blockPosition()), MobSpawnType.BREEDING, null, null);
        return retval;
    }

    @Override
    public void aiStep() {
        super.aiStep();

        for (Map.Entry<Chicken, Integer> entry : QboundChicken.entrySet()) {
            Chicken chicken = entry.getKey();
            int cooldown = entry.getValue();

            if (chicken.isAlive()) {
                entry.setValue(cooldown - 1);
            } else {
                QboundChicken.remove(chicken);
            }
        }

        this.updateSwingTime();
    }

    public static void init() {
        SpawnPlacements.register(MountainsPoemModEntities.CHANGFU_CHICKEN.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES,
                (entityType, world, reason, pos, random) -> (world.getBlockState(pos.below()).is(BlockTags.ANIMALS_SPAWNABLE_ON) && world.getRawBrightness(pos, 0) > 8));
    }

    public static AttributeSupplier.Builder createAttributes() {
        return Mob.createMobAttributes()
                .add(Attributes.MOVEMENT_SPEED, 0.3)
                .add(Attributes.MAX_HEALTH, 45)
                .add(Attributes.ARMOR, 0)
                .add(Attributes.ATTACK_DAMAGE, 3)
                .add(Attributes.FOLLOW_RANGE, 32);
    }

    private PlayState movementPredicate(AnimationState<?> event) {
        if (this.animationprocedure.equals("empty")) {
            if (event.isMoving() || !(event.getLimbSwingAmount() > -0.15F && event.getLimbSwingAmount() < 0.15F)) {
                return event.setAndContinue(RawAnimation.begin().thenLoop("walk"));
            }
            if (this.isDeadOrDying()) {
                return event.setAndContinue(RawAnimation.begin().thenPlay("dead"));
            }
            if (this.isInWaterOrBubble()) {
                return event.setAndContinue(RawAnimation.begin().thenLoop("swim"));
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
        if (this.deathTime == 60) {
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