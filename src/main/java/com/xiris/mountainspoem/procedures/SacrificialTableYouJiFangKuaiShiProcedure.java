package com.xiris.mountainspoem.procedures;

import com.xiris.mountainspoem.MountainsPoemMod;
import com.xiris.mountainspoem.entity.SouthMountainGodEntity;
import com.xiris.mountainspoem.init.*;
import com.xiris.mountainspoem.util.BlockStateUtil;
import com.xiris.mountainspoem.init.*;
import net.minecraft.core.BlockPos;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.common.capabilities.ForgeCapabilities;
import net.minecraftforge.items.IItemHandlerModifiable;

import java.util.Comparator;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

public class SacrificialTableYouJiFangKuaiShiProcedure {
    public static void execute(Level world, double x, double y, double z, Player entity) {
        BlockPos pos = BlockPos.containing(x, y, z);
        if (entity.getMainHandItem().getItem() == MountainsPoemModBlocks.WHITE_JIAN_GRASS_MAT.get().asItem() && world.getBlockState(pos).getBlock() == MountainsPoemModBlocks.SACRIFICIAL_TABLE.get()) {
            entity.getMainHandItem().shrink(1);
            if (world instanceof ServerLevel _level) {
                if (_level instanceof ServerLevel) {
                    net.minecraft.world.entity.EntityType.LIGHTNING_BOLT.spawn(
                        (ServerLevel)_level,
                        BlockPos.containing(x, y, z),
                        MobSpawnType.TRIGGERED
                    );
                }
                _level.sendParticles(MountainsPoemModParticleTypes.SACRIFICE_A.get(), x, y, z, 8, 3, 3, 3, 1);
            }
            BlockStateUtil.replaceBlock(world, pos, MountainsPoemModBlocks.WHITE_JIAN_GRASS_MAT_COVERED_SACRIFICIAL_TABLE.get(), true);
        }
        if (entity.getMainHandItem().getItem() == MountainsPoemModItems.BOTTLE_OF_SOUL_SHARDS.get()) {
            entity.getMainHandItem().shrink(1);
            if (world instanceof ServerLevel _level) {
                if (_level instanceof ServerLevel) {
                    net.minecraft.world.entity.EntityType.LIGHTNING_BOLT.spawn(
                        (ServerLevel)_level,
                        BlockPos.containing(x, y, z),
                        MobSpawnType.TRIGGERED
                    );
                }
                if (Math.random() < 0.5)
                    MountainsPoemModEntities.WANDERING_GHOST.get().spawn(_level, pos, MobSpawnType.MOB_SUMMONED);
                else if (Math.random() < 0.5)
                    MountainsPoemModEntities.IMPERIAL_EXAMINATION_GHOST.get().spawn(_level, pos, MobSpawnType.MOB_SUMMONED);
                else if (Math.random() < 0.5)
                    MountainsPoemModEntities.UNDER_GHOST.get().spawn(_level, pos, MobSpawnType.MOB_SUMMONED);
                else
                    MountainsPoemModEntities.HANGED_GHOST.get().spawn(_level, pos, MobSpawnType.MOB_SUMMONED);
                _level.sendParticles(MountainsPoemModParticleTypes.SACRIFICE_E.get(), x, y, z, 8, 3, 3, 3, 1);
            }
        }
        if (entity.getMainHandItem().getItem() == Items.SHEARS && world.getBlockState(pos).getBlock() == MountainsPoemModBlocks.WHITE_JIAN_GRASS_MAT_COVERED_SACRIFICIAL_TABLE.get()) {
            ItemStack stack = entity.getMainHandItem();
            if (stack.hurt(1, RandomSource.create(), null)) {
                stack.shrink(1);
                stack.setDamageValue(0);
            }
            if (world instanceof ServerLevel _level) {
                if (_level instanceof ServerLevel) {
                    net.minecraft.world.entity.EntityType.LIGHTNING_BOLT.spawn(
                            (ServerLevel)_level,
                            BlockPos.containing(x, y, z),
                            MobSpawnType.TRIGGERED
                    );
                }
                _level.sendParticles(MountainsPoemModParticleTypes.SACRIFICE_A.get(), x, y, z, 8, 3, 3, 3, 1);
            }
            BlockStateUtil.replaceBlock(world, pos, MountainsPoemModBlocks.SACRIFICIAL_TABLE.get(), true);
            if (world instanceof ServerLevel _level)
                _level.addFreshEntity(new net.minecraft.world.entity.item.ItemEntity(
                        _level, x, y, z,
                        MountainsPoemModBlocks.WHITE_JIAN_GRASS_MAT.get().asItem().getDefaultInstance()
                ));
        }
        if (entity.getMainHandItem().is(ItemTags.create(ResourceLocation.fromNamespaceAndPath(MountainsPoemMod.MOD_ID, "sacrifcial_tools")))
                && entity.getOffhandItem().getItem() == MountainsPoemModItems.THE_SOUTHERN_MOUNTAIN_JADE_PENDANT.get()
                && world.getBlockState(pos).getBlock() == MountainsPoemModBlocks.WHITE_JIAN_GRASS_MAT_COVERED_SACRIFICIAL_TABLE.get()
                && world.getBlockState(BlockPos.containing(x, y + 1, z)).is(BlockTags.create(ResourceLocation.fromNamespaceAndPath(MountainsPoemMod.MOD_ID, "gui_block"))) && (new Object() {
            public ItemStack getItemStack(LevelAccessor world, BlockPos pos, int slotid) {
                AtomicReference<ItemStack> _retval = new AtomicReference<>(ItemStack.EMPTY);
                BlockEntity _ent = world.getBlockEntity(pos);
                if (_ent != null)
                    _ent.getCapability(ForgeCapabilities.ITEM_HANDLER, null).ifPresent(capability -> _retval.set(capability.getStackInSlot(slotid).copy()));
                return _retval.get();
            }
        }.getItemStack(world, BlockPos.containing(x, y + 1, z), 0)).is(ItemTags.create(ResourceLocation.fromNamespaceAndPath("forge", "rice"))) && new Object() {
            public int getAmount(LevelAccessor world, BlockPos pos, int slotid) {
                AtomicInteger _retval = new AtomicInteger(0);
                BlockEntity _ent = world.getBlockEntity(pos);
                if (_ent != null)
                    _ent.getCapability(ForgeCapabilities.ITEM_HANDLER, null).ifPresent(capability -> _retval.set(capability.getStackInSlot(slotid).getCount()));
                return _retval.get();
            }
        }.getAmount(world, BlockPos.containing(x, y + 1, z), 0) >= 64 && (world.getBlockState(BlockPos.containing(x, y - 1, z))).getBlock() == MountainsPoemModBlocks.HOLLOW_MUD_BRICKS.get() && (new Object() {
            public ItemStack getItemStack(LevelAccessor world, BlockPos pos, int slotid) {
                AtomicReference<ItemStack> _retval = new AtomicReference<>(ItemStack.EMPTY);
                BlockEntity _ent = world.getBlockEntity(pos);
                if (_ent != null)
                    _ent.getCapability(ForgeCapabilities.ITEM_HANDLER, null).ifPresent(capability -> _retval.set(capability.getStackInSlot(slotid).copy()));
                return _retval.get();
            }
        }.getItemStack(world, BlockPos.containing(x, y - 1, z), 0)).is(ItemTags.create(ResourceLocation.fromNamespaceAndPath(MountainsPoemMod.MOD_ID, "common_food_2"))) && (new Object() {
            public ItemStack getItemStack(LevelAccessor world, BlockPos pos, int slotid) {
                AtomicReference<ItemStack> _retval = new AtomicReference<>(ItemStack.EMPTY);
                BlockEntity _ent = world.getBlockEntity(pos);
                if (_ent != null)
                    _ent.getCapability(ForgeCapabilities.ITEM_HANDLER, null).ifPresent(capability -> _retval.set(capability.getStackInSlot(slotid).copy()));
                return _retval.get();
            }
        }.getItemStack(world, BlockPos.containing(x, y - 1, z), 1)).is(ItemTags.create(ResourceLocation.fromNamespaceAndPath(MountainsPoemMod.MOD_ID, "common_food_2"))) && (new Object() {
            public ItemStack getItemStack(LevelAccessor world, BlockPos pos, int slotid) {
                AtomicReference<ItemStack> _retval = new AtomicReference<>(ItemStack.EMPTY);
                BlockEntity _ent = world.getBlockEntity(pos);
                if (_ent != null)
                    _ent.getCapability(ForgeCapabilities.ITEM_HANDLER, null).ifPresent(capability -> _retval.set(capability.getStackInSlot(slotid).copy()));
                return _retval.get();
            }
        }.getItemStack(world, BlockPos.containing(x, y - 1, z), 2)).is(ItemTags.create(ResourceLocation.fromNamespaceAndPath(MountainsPoemMod.MOD_ID, "common_food_2"))) && (new Object() {
            public ItemStack getItemStack(LevelAccessor world, BlockPos pos, int slotid) {
                AtomicReference<ItemStack> _retval = new AtomicReference<>(ItemStack.EMPTY);
                BlockEntity _ent = world.getBlockEntity(pos);
                if (_ent != null)
                    _ent.getCapability(ForgeCapabilities.ITEM_HANDLER, null).ifPresent(capability -> _retval.set(capability.getStackInSlot(slotid).copy()));
                return _retval.get();
            }
        }.getItemStack(world, BlockPos.containing(x, y - 1, z), 3)).getItem() == MountainsPoemModItems.JADETABLET.get() && (new Object() {
            public ItemStack getItemStack(LevelAccessor world, BlockPos pos, int slotid) {
                AtomicReference<ItemStack> _retval = new AtomicReference<>(ItemStack.EMPTY);
                BlockEntity _ent = world.getBlockEntity(pos);
                if (_ent != null)
                    _ent.getCapability(ForgeCapabilities.ITEM_HANDLER, null).ifPresent(capability -> _retval.set(capability.getStackInSlot(slotid).copy()));
                return _retval.get();
            }
        }.getItemStack(world, BlockPos.containing(x, y - 1, z), 4)).is(ItemTags.create(ResourceLocation.fromNamespaceAndPath(MountainsPoemMod.MOD_ID, "common_xuan_shells"))) && new Object() {
            public int getAmount(LevelAccessor world, BlockPos pos, int slotid) {
                AtomicInteger _retval = new AtomicInteger(0);
                BlockEntity _ent = world.getBlockEntity(pos);
                if (_ent != null)
                    _ent.getCapability(ForgeCapabilities.ITEM_HANDLER, null).ifPresent(capability -> _retval.set(capability.getStackInSlot(slotid).getCount()));
                return _retval.get();
            }
        }.getAmount(world, BlockPos.containing(x, y - 1, z), 0) >= 16 && new Object() {
            public int getAmount(LevelAccessor world, BlockPos pos, int slotid) {
                AtomicInteger _retval = new AtomicInteger(0);
                BlockEntity _ent = world.getBlockEntity(pos);
                if (_ent != null)
                    _ent.getCapability(ForgeCapabilities.ITEM_HANDLER, null).ifPresent(capability -> _retval.set(capability.getStackInSlot(slotid).getCount()));
                return _retval.get();
            }
        }.getAmount(world, BlockPos.containing(x, y - 1, z), 1) >= 16 && new Object() {
            public int getAmount(LevelAccessor world, BlockPos pos, int slotid) {
                AtomicInteger _retval = new AtomicInteger(0);
                BlockEntity _ent = world.getBlockEntity(pos);
                if (_ent != null)
                    _ent.getCapability(ForgeCapabilities.ITEM_HANDLER, null).ifPresent(capability -> _retval.set(capability.getStackInSlot(slotid).getCount()));
                return _retval.get();
            }
        }.getAmount(world, BlockPos.containing(x, y - 1, z), 2) >= 16 && new Object() {
            public int getAmount(LevelAccessor world, BlockPos pos, int slotid) {
                AtomicInteger _retval = new AtomicInteger(0);
                BlockEntity _ent = world.getBlockEntity(pos);
                if (_ent != null)
                    _ent.getCapability(ForgeCapabilities.ITEM_HANDLER, null).ifPresent(capability -> _retval.set(capability.getStackInSlot(slotid).getCount()));
                return _retval.get();
            }
        }.getAmount(world, BlockPos.containing(x, y - 1, z), 3) > 0) {
            entity.swing(InteractionHand.MAIN_HAND, true);
            if (Math.random() < 0.3) {
                entity.getOffhandItem().shrink(1);
            }
            {
                ItemStack _ist = entity.getMainHandItem();
                if (_ist.hurt(1, RandomSource.create(), null)) {
                    _ist.shrink(1);
                    _ist.setDamageValue(0);
                }
            }
            {
                BlockEntity _ent = world.getBlockEntity(BlockPos.containing(x, y + 1, z));
                if (_ent != null) {
                    final int _slotid = 0;
                    final int _amount = 64;
                    _ent.getCapability(ForgeCapabilities.ITEM_HANDLER, null).ifPresent(capability -> {
                        if (capability instanceof IItemHandlerModifiable) {
                            ItemStack _stk = capability.getStackInSlot(_slotid).copy();
                            _stk.shrink(_amount);
                            ((IItemHandlerModifiable) capability).setStackInSlot(_slotid, _stk);
                        }
                    });
                }
            }
            {
                BlockEntity _ent = world.getBlockEntity(BlockPos.containing(x, y - 1, z));
                if (_ent != null) {
                    final int _slotid = 0;
                    final int _amount = 16;
                    _ent.getCapability(ForgeCapabilities.ITEM_HANDLER, null).ifPresent(capability -> {
                        if (capability instanceof IItemHandlerModifiable) {
                            ItemStack _stk = capability.getStackInSlot(_slotid).copy();
                            _stk.shrink(_amount);
                            ((IItemHandlerModifiable) capability).setStackInSlot(_slotid, _stk);
                        }
                    });
                }
            }
            {
                BlockEntity _ent = world.getBlockEntity(BlockPos.containing(x, y - 1, z));
                if (_ent != null) {
                    final int _slotid = 1;
                    final int _amount = 16;
                    _ent.getCapability(ForgeCapabilities.ITEM_HANDLER, null).ifPresent(capability -> {
                        if (capability instanceof IItemHandlerModifiable) {
                            ItemStack _stk = capability.getStackInSlot(_slotid).copy();
                            _stk.shrink(_amount);
                            ((IItemHandlerModifiable) capability).setStackInSlot(_slotid, _stk);
                        }
                    });
                }
            }
            {
                BlockEntity _ent = world.getBlockEntity(BlockPos.containing(x, y - 1, z));
                if (_ent != null) {
                    final int _slotid = 2;
                    final int _amount = 16;
                    _ent.getCapability(ForgeCapabilities.ITEM_HANDLER, null).ifPresent(capability -> {
                        if (capability instanceof IItemHandlerModifiable) {
                            ItemStack _stk = capability.getStackInSlot(_slotid).copy();
                            _stk.shrink(_amount);
                            ((IItemHandlerModifiable) capability).setStackInSlot(_slotid, _stk);
                        }
                    });
                }
            }
            {
                BlockEntity _ent = world.getBlockEntity(BlockPos.containing(x, y - 1, z));
                if (_ent != null) {
                    final int _slotid = 3;
                    final int _amount = 16;
                    _ent.getCapability(ForgeCapabilities.ITEM_HANDLER, null).ifPresent(capability -> {
                        if (capability instanceof IItemHandlerModifiable) {
                            ItemStack _stk = capability.getStackInSlot(_slotid).copy();
                            _stk.shrink(_amount);
                            ((IItemHandlerModifiable) capability).setStackInSlot(_slotid, _stk);
                        }
                    });
                }
            }
            if (world instanceof ServerLevel _level)
                _level.sendParticles(MountainsPoemModParticleTypes.SACRIFICE_C.get(), x, y, z, 11, 3, 3, 3, 1);
            if (world instanceof ServerLevel _level)
                _level.sendParticles(MountainsPoemModParticleTypes.GUI_A.get(), x, (y + 1), z, 8, 3, 3, 3, 1);
            if (Math.random() < 0.5) {
                if (world instanceof ServerLevel _level) {
                    LightningBolt entityToSpawn = EntityType.LIGHTNING_BOLT.create(_level);
                    entityToSpawn.moveTo(Vec3.atBottomCenterOf(pos));
                    entityToSpawn.setVisualOnly(true);
                    _level.addFreshEntity(entityToSpawn);
                }
                if (world instanceof ServerLevel _level) {
                    Entity entityToSpawn = MountainsPoemModEntities.SOUTH_MOUNTAIN_GOD.get().spawn(_level, BlockPos.containing(x, y + 3, z), MobSpawnType.MOB_SUMMONED);
                    if (entityToSpawn != null) {
                    }
                }
                {
                    final Vec3 _center = new Vec3(x, (y + 3), z);
                    List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(1 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
                    for (Entity entityiterator : _entfound) {
                        if ((new Object() {
                            public ItemStack getItemStack(LevelAccessor world, BlockPos pos, int slotid) {
                                AtomicReference<ItemStack> _retval = new AtomicReference<>(ItemStack.EMPTY);
                                BlockEntity _ent = world.getBlockEntity(pos);
                                if (_ent != null)
                                    _ent.getCapability(ForgeCapabilities.ITEM_HANDLER, null).ifPresent(capability -> _retval.set(capability.getStackInSlot(slotid).copy()));
                                return _retval.get();
                            }
                        }.getItemStack(world, BlockPos.containing(x, y - 1, z), 4)).getItem() == MountainsPoemModItems.TRIUMPH_XUAN_SHELLS.get()) {
                            if (entityiterator instanceof SouthMountainGodEntity animatable)
                                animatable.setTexture("south_god_1e");
                        }
                        if ((new Object() {
                            public ItemStack getItemStack(LevelAccessor world, BlockPos pos, int slotid) {
                                AtomicReference<ItemStack> _retval = new AtomicReference<>(ItemStack.EMPTY);
                                BlockEntity _ent = world.getBlockEntity(pos);
                                if (_ent != null)
                                    _ent.getCapability(ForgeCapabilities.ITEM_HANDLER, null).ifPresent(capability -> _retval.set(capability.getStackInSlot(slotid).copy()));
                                return _retval.get();
                            }
                        }.getItemStack(world, BlockPos.containing(x, y - 1, z), 4)).getItem() == MountainsPoemModItems.CHIVALROUS_XUAN_SHELLS.get()) {
                            if (entityiterator instanceof SouthMountainGodEntity animatable)
                                animatable.setTexture("south_god_1f");
                        }
                        if ((new Object() {
                            public ItemStack getItemStack(LevelAccessor world, BlockPos pos, int slotid) {
                                AtomicReference<ItemStack> _retval = new AtomicReference<>(ItemStack.EMPTY);
                                BlockEntity _ent = world.getBlockEntity(pos);
                                if (_ent != null)
                                    _ent.getCapability(ForgeCapabilities.ITEM_HANDLER, null).ifPresent(capability -> _retval.set(capability.getStackInSlot(slotid).copy()));
                                return _retval.get();
                            }
                        }.getItemStack(world, BlockPos.containing(x, y - 1, z), 4)).getItem() == MountainsPoemModItems.HARVEST_XUAN_SHELLS.get()) {
                            if (entityiterator instanceof SouthMountainGodEntity animatable)
                                animatable.setTexture("south_god_1d");
                        }
                        if ((new Object() {
                            public ItemStack getItemStack(LevelAccessor world, BlockPos pos, int slotid) {
                                AtomicReference<ItemStack> _retval = new AtomicReference<>(ItemStack.EMPTY);
                                BlockEntity _ent = world.getBlockEntity(pos);
                                if (_ent != null)
                                    _ent.getCapability(ForgeCapabilities.ITEM_HANDLER, null).ifPresent(capability -> _retval.set(capability.getStackInSlot(slotid).copy()));
                                return _retval.get();
                            }
                        }.getItemStack(world, BlockPos.containing(x, y - 1, z), 4)).getItem() == MountainsPoemModItems.VITALITY_XUAN_SHELLS.get()) {
                            if (entityiterator instanceof SouthMountainGodEntity animatable)
                                animatable.setTexture("south_god_1c");
                        }
                        if ((new Object() {
                            public ItemStack getItemStack(LevelAccessor world, BlockPos pos, int slotid) {
                                AtomicReference<ItemStack> _retval = new AtomicReference<>(ItemStack.EMPTY);
                                BlockEntity _ent = world.getBlockEntity(pos);
                                if (_ent != null)
                                    _ent.getCapability(ForgeCapabilities.ITEM_HANDLER, null).ifPresent(capability -> _retval.set(capability.getStackInSlot(slotid).copy()));
                                return _retval.get();
                            }
                        }.getItemStack(world, BlockPos.containing(x, y - 1, z), 4)).getItem() == MountainsPoemModItems.RAIN_XUAN_SHELLS.get()) {
                            if (entityiterator instanceof SouthMountainGodEntity animatable)
                                animatable.setTexture("south_god_1b");
                        }
                        if ((new Object() {
                            public ItemStack getItemStack(LevelAccessor world, BlockPos pos, int slotid) {
                                AtomicReference<ItemStack> _retval = new AtomicReference<>(ItemStack.EMPTY);
                                BlockEntity _ent = world.getBlockEntity(pos);
                                if (_ent != null)
                                    _ent.getCapability(ForgeCapabilities.ITEM_HANDLER, null).ifPresent(capability -> _retval.set(capability.getStackInSlot(slotid).copy()));
                                return _retval.get();
                            }
                        }.getItemStack(world, BlockPos.containing(x, y - 1, z), 4)).getItem() == MountainsPoemModItems.THRONE_XUAN_SHELLS.get()) {
                            if (entityiterator instanceof SouthMountainGodEntity animatable)
                                animatable.setTexture("south_god_1");
                        }
                    }
                }
            } else {
                if (Math.random() < 0.5) {
                    {
                        final Vec3 _center = new Vec3(x, y, z);
                        List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(4 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
                        for (Entity entityiterator : _entfound) {
                            if (entityiterator.getType().is(TagKey.create(Registries.ENTITY_TYPE, ResourceLocation.fromNamespaceAndPath(MountainsPoemMod.MOD_ID, "human")))) {
                                if ((new Object() {
                                    public ItemStack getItemStack(LevelAccessor world, BlockPos pos, int slotid) {
                                        AtomicReference<ItemStack> _retval = new AtomicReference<>(ItemStack.EMPTY);
                                        BlockEntity _ent = world.getBlockEntity(pos);
                                        if (_ent != null)
                                            _ent.getCapability(ForgeCapabilities.ITEM_HANDLER, null).ifPresent(capability -> _retval.set(capability.getStackInSlot(slotid).copy()));
                                        return _retval.get();
                                    }
                                }.getItemStack(world, BlockPos.containing(x, y - 1, z), 4)).getItem() == MountainsPoemModItems.TRIUMPH_XUAN_SHELLS.get()) {
                                    if (entityiterator instanceof LivingEntity _entity && !_entity.level().isClientSide())
                                        _entity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_BOOST, 3000, 3));
                                    if (entityiterator instanceof LivingEntity _entity && !_entity.level().isClientSide())
                                        _entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 1500, 3));
                                    if (entityiterator instanceof LivingEntity _entity && !_entity.level().isClientSide())
                                        _entity.addEffect(new MobEffectInstance(MobEffects.HEALTH_BOOST, 1000, 3));
                                }
                                if ((new Object() {
                                    public ItemStack getItemStack(LevelAccessor world, BlockPos pos, int slotid) {
                                        AtomicReference<ItemStack> _retval = new AtomicReference<>(ItemStack.EMPTY);
                                        BlockEntity _ent = world.getBlockEntity(pos);
                                        if (_ent != null)
                                            _ent.getCapability(ForgeCapabilities.ITEM_HANDLER, null).ifPresent(capability -> _retval.set(capability.getStackInSlot(slotid).copy()));
                                        return _retval.get();
                                    }
                                }.getItemStack(world, BlockPos.containing(x, y - 1, z), 4)).getItem() == MountainsPoemModItems.CHIVALROUS_XUAN_SHELLS.get()) {
                                    if (entityiterator instanceof LivingEntity _entity && !_entity.level().isClientSide())
                                        _entity.addEffect(new MobEffectInstance(MobEffects.ABSORPTION, 3000, 3));
                                    if (entityiterator instanceof LivingEntity _entity && !_entity.level().isClientSide())
                                        _entity.addEffect(new MobEffectInstance(MobEffects.JUMP, 3000, 3));
                                }
                                if ((new Object() {
                                    public ItemStack getItemStack(LevelAccessor world, BlockPos pos, int slotid) {
                                        AtomicReference<ItemStack> _retval = new AtomicReference<>(ItemStack.EMPTY);
                                        BlockEntity _ent = world.getBlockEntity(pos);
                                        if (_ent != null)
                                            _ent.getCapability(ForgeCapabilities.ITEM_HANDLER, null).ifPresent(capability -> _retval.set(capability.getStackInSlot(slotid).copy()));
                                        return _retval.get();
                                    }
                                }.getItemStack(world, BlockPos.containing(x, y - 1, z), 4)).getItem() == MountainsPoemModItems.HARVEST_XUAN_SHELLS.get()) {
                                    if (entityiterator instanceof LivingEntity _entity && !_entity.level().isClientSide())
                                        _entity.addEffect(new MobEffectInstance(MountainsPoemModMobEffects.ABUNDANT.get(), 3000, 3));
                                }
                                if ((new Object() {
                                    public ItemStack getItemStack(LevelAccessor world, BlockPos pos, int slotid) {
                                        AtomicReference<ItemStack> _retval = new AtomicReference<>(ItemStack.EMPTY);
                                        BlockEntity _ent = world.getBlockEntity(pos);
                                        if (_ent != null)
                                            _ent.getCapability(ForgeCapabilities.ITEM_HANDLER, null).ifPresent(capability -> _retval.set(capability.getStackInSlot(slotid).copy()));
                                        return _retval.get();
                                    }
                                }.getItemStack(world, BlockPos.containing(x, y - 1, z), 4)).getItem() == MountainsPoemModItems.VITALITY_XUAN_SHELLS.get()) {
                                    if (entityiterator instanceof LivingEntity _entity && !_entity.level().isClientSide())
                                        _entity.addEffect(new MobEffectInstance(MountainsPoemModMobEffects.LUSH.get(), 3000, 3));
                                }
                                if ((new Object() {
                                    public ItemStack getItemStack(LevelAccessor world, BlockPos pos, int slotid) {
                                        AtomicReference<ItemStack> _retval = new AtomicReference<>(ItemStack.EMPTY);
                                        BlockEntity _ent = world.getBlockEntity(pos);
                                        if (_ent != null)
                                            _ent.getCapability(ForgeCapabilities.ITEM_HANDLER, null).ifPresent(capability -> _retval.set(capability.getStackInSlot(slotid).copy()));
                                        return _retval.get();
                                    }
                                }.getItemStack(world, BlockPos.containing(x, y - 1, z), 4)).getItem() == MountainsPoemModItems.RAIN_XUAN_SHELLS.get()) {
                                    if (entityiterator instanceof LivingEntity _entity && !_entity.level().isClientSide())
                                        _entity.addEffect(new MobEffectInstance(MountainsPoemModMobEffects.HYDRATED_SKIN.get(), 3000, 3));
                                }
                                if ((new Object() {
                                    public ItemStack getItemStack(LevelAccessor world, BlockPos pos, int slotid) {
                                        AtomicReference<ItemStack> _retval = new AtomicReference<>(ItemStack.EMPTY);
                                        BlockEntity _ent = world.getBlockEntity(pos);
                                        if (_ent != null)
                                            _ent.getCapability(ForgeCapabilities.ITEM_HANDLER, null).ifPresent(capability -> _retval.set(capability.getStackInSlot(slotid).copy()));
                                        return _retval.get();
                                    }
                                }.getItemStack(world, BlockPos.containing(x, y - 1, z), 4)).getItem() == MountainsPoemModItems.THRONE_XUAN_SHELLS.get()) {
                                    if (entityiterator instanceof LivingEntity _entity && !_entity.level().isClientSide())
                                        _entity.addEffect(new MobEffectInstance(MountainsPoemModMobEffects.THE_MOUNTAIN_GOD_S_BLESSING.get(), 3000, 3));
                                }
                            }
                        }
                    }
                } else {
                    if (world instanceof ServerLevel _level) {
                        LightningBolt entityToSpawn = EntityType.LIGHTNING_BOLT.create(_level);
                        entityToSpawn.moveTo(Vec3.atBottomCenterOf(pos));
                        _level.addFreshEntity(entityToSpawn);
                    }
                }
                if (Math.random() < 0.4) {
                    if (world instanceof ServerLevel _level) {
                        Entity entityToSpawn = MountainsPoemModEntities.FENGHUANG_PHOENIX.get().spawn(_level, pos, MobSpawnType.MOB_SUMMONED);
                        if (entityToSpawn != null) {
                            entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
                        }
                    }
                }
            }
            {
                BlockEntity _ent = world.getBlockEntity(BlockPos.containing(x, y - 1, z));
                if (_ent != null) {
                    final int _slotid = 4;
                    final int _amount = 1;
                    _ent.getCapability(ForgeCapabilities.ITEM_HANDLER, null).ifPresent(capability -> {
                        if (capability instanceof IItemHandlerModifiable) {
                            ItemStack _stk = capability.getStackInSlot(_slotid).copy();
                            _stk.shrink(_amount);
                            ((IItemHandlerModifiable) capability).setStackInSlot(_slotid, _stk);
                        }
                    });
                }
            }
        }
        if (entity.getMainHandItem().is(ItemTags.create(ResourceLocation.fromNamespaceAndPath(MountainsPoemMod.MOD_ID, "sacrifcial_tools")))
                && entity.getOffhandItem().getItem() == MountainsPoemModItems.THE_SECOND_SOUTHERN_MOUNTAIN_JADE_PENDANT.get()
                && world.getBlockState(pos).is(BlockTags.create(ResourceLocation.fromNamespaceAndPath(MountainsPoemMod.MOD_ID, "sacrificial_table_block")))
                && world.getBlockState(BlockPos.containing(x, y + 1, z)).is(BlockTags.create(ResourceLocation.fromNamespaceAndPath(MountainsPoemMod.MOD_ID, "gui_block"))) && (new Object() {
            public ItemStack getItemStack(LevelAccessor world, BlockPos pos, int slotid) {
                AtomicReference<ItemStack> _retval = new AtomicReference<>(ItemStack.EMPTY);
                BlockEntity _ent = world.getBlockEntity(pos);
                if (_ent != null)
                    _ent.getCapability(ForgeCapabilities.ITEM_HANDLER, null).ifPresent(capability -> _retval.set(capability.getStackInSlot(slotid).copy()));
                return _retval.get();
            }
        }.getItemStack(world, BlockPos.containing(x, y + 1, z), 0)).is(ItemTags.create(ResourceLocation.fromNamespaceAndPath("forge", "rice"))) && new Object() {
            public int getAmount(LevelAccessor world, BlockPos pos, int slotid) {
                AtomicInteger _retval = new AtomicInteger(0);
                BlockEntity _ent = world.getBlockEntity(pos);
                if (_ent != null)
                    _ent.getCapability(ForgeCapabilities.ITEM_HANDLER, null).ifPresent(capability -> _retval.set(capability.getStackInSlot(slotid).getCount()));
                return _retval.get();
            }
        }.getAmount(world, BlockPos.containing(x, y + 1, z), 0) >= 64 && (world.getBlockState(BlockPos.containing(x, y - 1, z))).getBlock() == MountainsPoemModBlocks.HOLLOW_MUD_BRICKS.get() && (new Object() {
            public ItemStack getItemStack(LevelAccessor world, BlockPos pos, int slotid) {
                AtomicReference<ItemStack> _retval = new AtomicReference<>(ItemStack.EMPTY);
                BlockEntity _ent = world.getBlockEntity(pos);
                if (_ent != null)
                    _ent.getCapability(ForgeCapabilities.ITEM_HANDLER, null).ifPresent(capability -> _retval.set(capability.getStackInSlot(slotid).copy()));
                return _retval.get();
            }
        }.getItemStack(world, BlockPos.containing(x, y - 1, z), 0)).is(ItemTags.create(ResourceLocation.fromNamespaceAndPath(MountainsPoemMod.MOD_ID, "common_food"))) && (new Object() {
            public ItemStack getItemStack(LevelAccessor world, BlockPos pos, int slotid) {
                AtomicReference<ItemStack> _retval = new AtomicReference<>(ItemStack.EMPTY);
                BlockEntity _ent = world.getBlockEntity(pos);
                if (_ent != null)
                    _ent.getCapability(ForgeCapabilities.ITEM_HANDLER, null).ifPresent(capability -> _retval.set(capability.getStackInSlot(slotid).copy()));
                return _retval.get();
            }
        }.getItemStack(world, BlockPos.containing(x, y - 1, z), 1)).is(ItemTags.create(ResourceLocation.fromNamespaceAndPath(MountainsPoemMod.MOD_ID, "common_food"))) && (new Object() {
            public ItemStack getItemStack(LevelAccessor world, BlockPos pos, int slotid) {
                AtomicReference<ItemStack> _retval = new AtomicReference<>(ItemStack.EMPTY);
                BlockEntity _ent = world.getBlockEntity(pos);
                if (_ent != null)
                    _ent.getCapability(ForgeCapabilities.ITEM_HANDLER, null).ifPresent(capability -> _retval.set(capability.getStackInSlot(slotid).copy()));
                return _retval.get();
            }
        }.getItemStack(world, BlockPos.containing(x, y - 1, z), 2)).is(ItemTags.create(ResourceLocation.fromNamespaceAndPath(MountainsPoemMod.MOD_ID, "common_food"))) && (new Object() {
            public ItemStack getItemStack(LevelAccessor world, BlockPos pos, int slotid) {
                AtomicReference<ItemStack> _retval = new AtomicReference<>(ItemStack.EMPTY);
                BlockEntity _ent = world.getBlockEntity(pos);
                if (_ent != null)
                    _ent.getCapability(ForgeCapabilities.ITEM_HANDLER, null).ifPresent(capability -> _retval.set(capability.getStackInSlot(slotid).copy()));
                return _retval.get();
            }
        }.getItemStack(world, BlockPos.containing(x, y - 1, z), 3)).getItem() == MountainsPoemModItems.MP_JADE_RING.get() && (new Object() {
            public ItemStack getItemStack(LevelAccessor world, BlockPos pos, int slotid) {
                AtomicReference<ItemStack> _retval = new AtomicReference<>(ItemStack.EMPTY);
                BlockEntity _ent = world.getBlockEntity(pos);
                if (_ent != null)
                    _ent.getCapability(ForgeCapabilities.ITEM_HANDLER, null).ifPresent(capability -> _retval.set(capability.getStackInSlot(slotid).copy()));
                return _retval.get();
            }
        }.getItemStack(world, BlockPos.containing(x, y - 1, z), 4)).is(ItemTags.create(ResourceLocation.fromNamespaceAndPath(MountainsPoemMod.MOD_ID, "special_xuan_shells"))) && new Object() {
            public int getAmount(LevelAccessor world, BlockPos pos, int slotid) {
                AtomicInteger _retval = new AtomicInteger(0);
                BlockEntity _ent = world.getBlockEntity(pos);
                if (_ent != null)
                    _ent.getCapability(ForgeCapabilities.ITEM_HANDLER, null).ifPresent(capability -> _retval.set(capability.getStackInSlot(slotid).getCount()));
                return _retval.get();
            }
        }.getAmount(world, BlockPos.containing(x, y - 1, z), 0) >= 16 && new Object() {
            public int getAmount(LevelAccessor world, BlockPos pos, int slotid) {
                AtomicInteger _retval = new AtomicInteger(0);
                BlockEntity _ent = world.getBlockEntity(pos);
                if (_ent != null)
                    _ent.getCapability(ForgeCapabilities.ITEM_HANDLER, null).ifPresent(capability -> _retval.set(capability.getStackInSlot(slotid).getCount()));
                return _retval.get();
            }
        }.getAmount(world, BlockPos.containing(x, y - 1, z), 1) >= 16 && new Object() {
            public int getAmount(LevelAccessor world, BlockPos pos, int slotid) {
                AtomicInteger _retval = new AtomicInteger(0);
                BlockEntity _ent = world.getBlockEntity(pos);
                if (_ent != null)
                    _ent.getCapability(ForgeCapabilities.ITEM_HANDLER, null).ifPresent(capability -> _retval.set(capability.getStackInSlot(slotid).getCount()));
                return _retval.get();
            }
        }.getAmount(world, BlockPos.containing(x, y - 1, z), 2) >= 16 && new Object() {
            public int getAmount(LevelAccessor world, BlockPos pos, int slotid) {
                AtomicInteger _retval = new AtomicInteger(0);
                BlockEntity _ent = world.getBlockEntity(pos);
                if (_ent != null)
                    _ent.getCapability(ForgeCapabilities.ITEM_HANDLER, null).ifPresent(capability -> _retval.set(capability.getStackInSlot(slotid).getCount()));
                return _retval.get();
            }
        }.getAmount(world, BlockPos.containing(x, y - 1, z), 3) >= 10) {
            entity.swing(InteractionHand.MAIN_HAND, true);
            if (Math.random() < 0.3) {
                entity.getOffhandItem().shrink(1);
            }
            {
                ItemStack _ist = entity.getMainHandItem();
                if (_ist.hurt(1, RandomSource.create(), null)) {
                    _ist.shrink(1);
                    _ist.setDamageValue(0);
                }
            }
            {
                BlockEntity _ent = world.getBlockEntity(BlockPos.containing(x, y + 1, z));
                if (_ent != null) {
                    final int _slotid = 0;
                    final int _amount = 64;
                    _ent.getCapability(ForgeCapabilities.ITEM_HANDLER, null).ifPresent(capability -> {
                        if (capability instanceof IItemHandlerModifiable) {
                            ItemStack _stk = capability.getStackInSlot(_slotid).copy();
                            _stk.shrink(_amount);
                            ((IItemHandlerModifiable) capability).setStackInSlot(_slotid, _stk);
                        }
                    });
                }
            }
            {
                BlockEntity _ent = world.getBlockEntity(BlockPos.containing(x, y - 1, z));
                if (_ent != null) {
                    final int _slotid = 0;
                    final int _amount = 16;
                    _ent.getCapability(ForgeCapabilities.ITEM_HANDLER, null).ifPresent(capability -> {
                        if (capability instanceof IItemHandlerModifiable) {
                            ItemStack _stk = capability.getStackInSlot(_slotid).copy();
                            _stk.shrink(_amount);
                            ((IItemHandlerModifiable) capability).setStackInSlot(_slotid, _stk);
                        }
                    });
                }
            }
            {
                BlockEntity _ent = world.getBlockEntity(BlockPos.containing(x, y - 1, z));
                if (_ent != null) {
                    final int _slotid = 1;
                    final int _amount = 16;
                    _ent.getCapability(ForgeCapabilities.ITEM_HANDLER, null).ifPresent(capability -> {
                        if (capability instanceof IItemHandlerModifiable) {
                            ItemStack _stk = capability.getStackInSlot(_slotid).copy();
                            _stk.shrink(_amount);
                            ((IItemHandlerModifiable) capability).setStackInSlot(_slotid, _stk);
                        }
                    });
                }
            }
            {
                BlockEntity _ent = world.getBlockEntity(BlockPos.containing(x, y - 1, z));
                if (_ent != null) {
                    final int _slotid = 2;
                    final int _amount = 16;
                    _ent.getCapability(ForgeCapabilities.ITEM_HANDLER, null).ifPresent(capability -> {
                        if (capability instanceof IItemHandlerModifiable) {
                            ItemStack _stk = capability.getStackInSlot(_slotid).copy();
                            _stk.shrink(_amount);
                            ((IItemHandlerModifiable) capability).setStackInSlot(_slotid, _stk);
                        }
                    });
                }
            }
            {
                BlockEntity _ent = world.getBlockEntity(BlockPos.containing(x, y - 1, z));
                if (_ent != null) {
                    final int _slotid = 3;
                    final int _amount = 10;
                    _ent.getCapability(ForgeCapabilities.ITEM_HANDLER, null).ifPresent(capability -> {
                        if (capability instanceof IItemHandlerModifiable) {
                            ItemStack _stk = capability.getStackInSlot(_slotid).copy();
                            _stk.shrink(_amount);
                            ((IItemHandlerModifiable) capability).setStackInSlot(_slotid, _stk);
                        }
                    });
                }
            }
            if (world instanceof ServerLevel _level)
                _level.sendParticles(MountainsPoemModParticleTypes.SACRIFICE_C.get(), x, y, z, 11, 3, 3, 3, 1);
            if (world instanceof ServerLevel _level)
                _level.sendParticles(MountainsPoemModParticleTypes.GUI_C.get(), x, (y + 1), z, 8, 3, 3, 3, 1);
            if (Math.random() < 0.5) {
                if (world instanceof ServerLevel _level) {
                    LightningBolt entityToSpawn = EntityType.LIGHTNING_BOLT.create(_level);
                    entityToSpawn.moveTo(Vec3.atBottomCenterOf(pos));
                    entityToSpawn.setVisualOnly(true);
                    _level.addFreshEntity(entityToSpawn);
                }
                if (world instanceof ServerLevel _level) {
                    Entity entityToSpawn = MountainsPoemModEntities.SOUTH_SECOND_MOUNTAINS_GOD.get().spawn(_level, BlockPos.containing(x, y + 3, z), MobSpawnType.MOB_SUMMONED);
                    if (entityToSpawn != null) {
                    }
                }
                {
                    final Vec3 _center = new Vec3(x, (y + 3), z);
                    List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(1 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
                    for (Entity entityiterator : _entfound) {
                        if ((new Object() {
                            public ItemStack getItemStack(LevelAccessor world, BlockPos pos, int slotid) {
                                AtomicReference<ItemStack> _retval = new AtomicReference<>(ItemStack.EMPTY);
                                BlockEntity _ent = world.getBlockEntity(pos);
                                if (_ent != null)
                                    _ent.getCapability(ForgeCapabilities.ITEM_HANDLER, null).ifPresent(capability -> _retval.set(capability.getStackInSlot(slotid).copy()));
                                return _retval.get();
                            }
                        }.getItemStack(world, BlockPos.containing(x, y - 1, z), 4)).getItem() == MountainsPoemModItems.TRIUMPH_XUAN_SHELLS.get()) {
                            if (entityiterator instanceof SouthMountainGodEntity animatable)
                                animatable.setTexture("south_second_mountains_god");
                        }
                        if ((new Object() {
                            public ItemStack getItemStack(LevelAccessor world, BlockPos pos, int slotid) {
                                AtomicReference<ItemStack> _retval = new AtomicReference<>(ItemStack.EMPTY);
                                BlockEntity _ent = world.getBlockEntity(pos);
                                if (_ent != null)
                                    _ent.getCapability(ForgeCapabilities.ITEM_HANDLER, null).ifPresent(capability -> _retval.set(capability.getStackInSlot(slotid).copy()));
                                return _retval.get();
                            }
                        }.getItemStack(world, BlockPos.containing(x, y - 1, z), 4)).getItem() == MountainsPoemModItems.HUNT_XUAN_SHELLS.get()) {
                            if (entityiterator instanceof SouthMountainGodEntity animatable)
                                animatable.setTexture("south_second_mountains_god4");
                        }
                        if ((new Object() {
                            public ItemStack getItemStack(LevelAccessor world, BlockPos pos, int slotid) {
                                AtomicReference<ItemStack> _retval = new AtomicReference<>(ItemStack.EMPTY);
                                BlockEntity _ent = world.getBlockEntity(pos);
                                if (_ent != null)
                                    _ent.getCapability(ForgeCapabilities.ITEM_HANDLER, null).ifPresent(capability -> _retval.set(capability.getStackInSlot(slotid).copy()));
                                return _retval.get();
                            }
                        }.getItemStack(world, BlockPos.containing(x, y - 1, z), 4)).getItem() == MountainsPoemModItems.HARVEST_XUAN_SHELLS.get()) {
                            if (entityiterator instanceof SouthMountainGodEntity animatable)
                                animatable.setTexture("south_second_mountains_god3");
                        }
                        if ((new Object() {
                            public ItemStack getItemStack(LevelAccessor world, BlockPos pos, int slotid) {
                                AtomicReference<ItemStack> _retval = new AtomicReference<>(ItemStack.EMPTY);
                                BlockEntity _ent = world.getBlockEntity(pos);
                                if (_ent != null)
                                    _ent.getCapability(ForgeCapabilities.ITEM_HANDLER, null).ifPresent(capability -> _retval.set(capability.getStackInSlot(slotid).copy()));
                                return _retval.get();
                            }
                        }.getItemStack(world, BlockPos.containing(x, y - 1, z), 4)).getItem() == MountainsPoemModItems.WISDOM_XUAN_SHELLS.get()) {
                            if (entityiterator instanceof SouthMountainGodEntity animatable)
                                animatable.setTexture("south_second_mountains_god2");
                        }
                        if ((new Object() {
                            public ItemStack getItemStack(LevelAccessor world, BlockPos pos, int slotid) {
                                AtomicReference<ItemStack> _retval = new AtomicReference<>(ItemStack.EMPTY);
                                BlockEntity _ent = world.getBlockEntity(pos);
                                if (_ent != null)
                                    _ent.getCapability(ForgeCapabilities.ITEM_HANDLER, null).ifPresent(capability -> _retval.set(capability.getStackInSlot(slotid).copy()));
                                return _retval.get();
                            }
                        }.getItemStack(world, BlockPos.containing(x, y - 1, z), 4)).getItem() == MountainsPoemModItems.RAIN_XUAN_SHELLS.get()) {
                            if (entityiterator instanceof SouthMountainGodEntity animatable)
                                animatable.setTexture("south_second_mountains_god3");
                        }
                        if ((new Object() {
                            public ItemStack getItemStack(LevelAccessor world, BlockPos pos, int slotid) {
                                AtomicReference<ItemStack> _retval = new AtomicReference<>(ItemStack.EMPTY);
                                BlockEntity _ent = world.getBlockEntity(pos);
                                if (_ent != null)
                                    _ent.getCapability(ForgeCapabilities.ITEM_HANDLER, null).ifPresent(capability -> _retval.set(capability.getStackInSlot(slotid).copy()));
                                return _retval.get();
                            }
                        }.getItemStack(world, BlockPos.containing(x, y - 1, z), 4)).getItem() == MountainsPoemModItems.HEALTH_XUAN_SHELLS.get()) {
                            if (entityiterator instanceof SouthMountainGodEntity animatable)
                                animatable.setTexture("south_second_mountains_god4");
                        }
                    }
                }
            } else {
                if (Math.random() < 0.4) {
                    if (world instanceof ServerLevel _level) {
                        Entity entityToSpawn = MountainsPoemModEntities.FENGHUANG_PHOENIX.get().spawn(_level, pos, MobSpawnType.MOB_SUMMONED);
                        if (entityToSpawn != null) {
                            entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
                        }
                    }
                }
                if (Math.random() < 0.6) {
                    {
                        final Vec3 _center = new Vec3(x, y, z);
                        List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(4 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
                        for (Entity entityiterator : _entfound) {
                            if (entityiterator.getType().is(TagKey.create(Registries.ENTITY_TYPE, ResourceLocation.fromNamespaceAndPath(MountainsPoemMod.MOD_ID, "human")))) {
                                if ((new Object() {
                                    public ItemStack getItemStack(LevelAccessor world, BlockPos pos, int slotid) {
                                        AtomicReference<ItemStack> _retval = new AtomicReference<>(ItemStack.EMPTY);
                                        BlockEntity _ent = world.getBlockEntity(pos);
                                        if (_ent != null)
                                            _ent.getCapability(ForgeCapabilities.ITEM_HANDLER, null).ifPresent(capability -> _retval.set(capability.getStackInSlot(slotid).copy()));
                                        return _retval.get();
                                    }
                                }.getItemStack(world, BlockPos.containing(x, y - 1, z), 4)).getItem() == MountainsPoemModItems.TRIUMPH_XUAN_SHELLS.get()) {
                                    if (entityiterator instanceof LivingEntity _entity && !_entity.level().isClientSide())
                                        _entity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_BOOST, 3000, 3));
                                    if (entityiterator instanceof LivingEntity _entity && !_entity.level().isClientSide())
                                        _entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 1500, 3));
                                    if (entityiterator instanceof LivingEntity _entity && !_entity.level().isClientSide())
                                        _entity.addEffect(new MobEffectInstance(MobEffects.HEALTH_BOOST, 1000, 3));
                                }
                                if ((new Object() {
                                    public ItemStack getItemStack(LevelAccessor world, BlockPos pos, int slotid) {
                                        AtomicReference<ItemStack> _retval = new AtomicReference<>(ItemStack.EMPTY);
                                        BlockEntity _ent = world.getBlockEntity(pos);
                                        if (_ent != null)
                                            _ent.getCapability(ForgeCapabilities.ITEM_HANDLER, null).ifPresent(capability -> _retval.set(capability.getStackInSlot(slotid).copy()));
                                        return _retval.get();
                                    }
                                }.getItemStack(world, BlockPos.containing(x, y - 1, z), 4)).getItem() == MountainsPoemModItems.WISDOM_XUAN_SHELLS.get()) {
                                    if (entityiterator instanceof LivingEntity _entity && !_entity.level().isClientSide())
                                        _entity.addEffect(new MobEffectInstance(MobEffects.LUCK, 3000, 3));
                                    if (entityiterator instanceof LivingEntity _entity && !_entity.level().isClientSide())
                                        _entity.addEffect(new MobEffectInstance(MobEffects.JUMP, 3000, 3));
                                }
                                if ((new Object() {
                                    public ItemStack getItemStack(LevelAccessor world, BlockPos pos, int slotid) {
                                        AtomicReference<ItemStack> _retval = new AtomicReference<>(ItemStack.EMPTY);
                                        BlockEntity _ent = world.getBlockEntity(pos);
                                        if (_ent != null)
                                            _ent.getCapability(ForgeCapabilities.ITEM_HANDLER, null).ifPresent(capability -> _retval.set(capability.getStackInSlot(slotid).copy()));
                                        return _retval.get();
                                    }
                                }.getItemStack(world, BlockPos.containing(x, y - 1, z), 4)).getItem() == MountainsPoemModItems.HARVEST_XUAN_SHELLS.get()) {
                                    if (entityiterator instanceof LivingEntity _entity && !_entity.level().isClientSide())
                                        _entity.addEffect(new MobEffectInstance(MountainsPoemModMobEffects.ABUNDANT.get(), 3000, 3));
                                }
                                if ((new Object() {
                                    public ItemStack getItemStack(LevelAccessor world, BlockPos pos, int slotid) {
                                        AtomicReference<ItemStack> _retval = new AtomicReference<>(ItemStack.EMPTY);
                                        BlockEntity _ent = world.getBlockEntity(pos);
                                        if (_ent != null)
                                            _ent.getCapability(ForgeCapabilities.ITEM_HANDLER, null).ifPresent(capability -> _retval.set(capability.getStackInSlot(slotid).copy()));
                                        return _retval.get();
                                    }
                                }.getItemStack(world, BlockPos.containing(x, y - 1, z), 4)).getItem() == MountainsPoemModItems.HEALTH_XUAN_SHELLS.get()) {
                                    if (entityiterator instanceof LivingEntity _entity && !_entity.level().isClientSide())
                                        _entity.addEffect(new MobEffectInstance(MobEffects.HEALTH_BOOST, 3000, 3));
                                }
                                if ((new Object() {
                                    public ItemStack getItemStack(LevelAccessor world, BlockPos pos, int slotid) {
                                        AtomicReference<ItemStack> _retval = new AtomicReference<>(ItemStack.EMPTY);
                                        BlockEntity _ent = world.getBlockEntity(pos);
                                        if (_ent != null)
                                            _ent.getCapability(ForgeCapabilities.ITEM_HANDLER, null).ifPresent(capability -> _retval.set(capability.getStackInSlot(slotid).copy()));
                                        return _retval.get();
                                    }
                                }.getItemStack(world, BlockPos.containing(x, y - 1, z), 4)).getItem() == MountainsPoemModItems.RAIN_XUAN_SHELLS.get()) {
                                    if (entityiterator instanceof LivingEntity _entity && !_entity.level().isClientSide())
                                        _entity.addEffect(new MobEffectInstance(MountainsPoemModMobEffects.HYDRATED_SKIN.get(), 3000, 3));
                                }
                                if ((new Object() {
                                    public ItemStack getItemStack(LevelAccessor world, BlockPos pos, int slotid) {
                                        AtomicReference<ItemStack> _retval = new AtomicReference<>(ItemStack.EMPTY);
                                        BlockEntity _ent = world.getBlockEntity(pos);
                                        if (_ent != null)
                                            _ent.getCapability(ForgeCapabilities.ITEM_HANDLER, null).ifPresent(capability -> _retval.set(capability.getStackInSlot(slotid).copy()));
                                        return _retval.get();
                                    }
                                }.getItemStack(world, BlockPos.containing(x, y - 1, z), 4)).getItem() == MountainsPoemModItems.HUNT_XUAN_SHELLS.get()) {
                                    if (entityiterator instanceof LivingEntity _entity && !_entity.level().isClientSide())
                                        _entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 3000, 3));
                                    if (entityiterator instanceof LivingEntity _entity && !_entity.level().isClientSide())
                                        _entity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_BOOST, 1500, 3));
                                    if (entityiterator instanceof LivingEntity _entity && !_entity.level().isClientSide())
                                        _entity.addEffect(new MobEffectInstance(MobEffects.JUMP, 1500, 3));
                                }
                            }
                        }
                    }
                } else {
                    if (world instanceof ServerLevel _level) {
                        LightningBolt entityToSpawn = EntityType.LIGHTNING_BOLT.create(_level);
                        entityToSpawn.moveTo(Vec3.atBottomCenterOf(pos));
                        _level.addFreshEntity(entityToSpawn);
                    }
                }
            }
        }
        if (entity.getMainHandItem().is(ItemTags.create(ResourceLocation.fromNamespaceAndPath(MountainsPoemMod.MOD_ID, "sacrifcial_tools")))
                && entity.getOffhandItem().getItem() == MountainsPoemModItems.THE_NINTH_CENTRAL_MOUNTAIN_JADE_PENDANT.get()
                && world.getBlockState(pos).is(BlockTags.create(ResourceLocation.fromNamespaceAndPath(MountainsPoemMod.MOD_ID, "sacrificial_table_block")))
                && world.getBlockState(BlockPos.containing(x, y + 1, z)).is(BlockTags.create(ResourceLocation.fromNamespaceAndPath(MountainsPoemMod.MOD_ID, "gui_block"))) && (new Object() {
            public ItemStack getItemStack(LevelAccessor world, BlockPos pos, int slotid) {
                AtomicReference<ItemStack> _retval = new AtomicReference<>(ItemStack.EMPTY);
                BlockEntity _ent = world.getBlockEntity(pos);
                if (_ent != null)
                    _ent.getCapability(ForgeCapabilities.ITEM_HANDLER, null).ifPresent(capability -> _retval.set(capability.getStackInSlot(slotid).copy()));
                return _retval.get();
            }
        }.getItemStack(world, BlockPos.containing(x, y + 1, z), 0)).is(ItemTags.create(ResourceLocation.fromNamespaceAndPath("forge", "rice"))) && new Object() {
            public int getAmount(LevelAccessor world, BlockPos pos, int slotid) {
                AtomicInteger _retval = new AtomicInteger(0);
                BlockEntity _ent = world.getBlockEntity(pos);
                if (_ent != null)
                    _ent.getCapability(ForgeCapabilities.ITEM_HANDLER, null).ifPresent(capability -> _retval.set(capability.getStackInSlot(slotid).getCount()));
                return _retval.get();
            }
        }.getAmount(world, BlockPos.containing(x, y + 1, z), 0) >= 64 && (world.getBlockState(BlockPos.containing(x, y - 1, z))).getBlock() == MountainsPoemModBlocks.HOLLOW_MUD_BRICKS.get() && (new Object() {
            public ItemStack getItemStack(LevelAccessor world, BlockPos pos, int slotid) {
                AtomicReference<ItemStack> _retval = new AtomicReference<>(ItemStack.EMPTY);
                BlockEntity _ent = world.getBlockEntity(pos);
                if (_ent != null)
                    _ent.getCapability(ForgeCapabilities.ITEM_HANDLER, null).ifPresent(capability -> _retval.set(capability.getStackInSlot(slotid).copy()));
                return _retval.get();
            }
        }.getItemStack(world, BlockPos.containing(x, y - 1, z), 0)).is(ItemTags.create(ResourceLocation.fromNamespaceAndPath(MountainsPoemMod.MOD_ID, "common_food_3"))) && (new Object() {
            public ItemStack getItemStack(LevelAccessor world, BlockPos pos, int slotid) {
                AtomicReference<ItemStack> _retval = new AtomicReference<>(ItemStack.EMPTY);
                BlockEntity _ent = world.getBlockEntity(pos);
                if (_ent != null)
                    _ent.getCapability(ForgeCapabilities.ITEM_HANDLER, null).ifPresent(capability -> _retval.set(capability.getStackInSlot(slotid).copy()));
                return _retval.get();
            }
        }.getItemStack(world, BlockPos.containing(x, y - 1, z), 1)).is(ItemTags.create(ResourceLocation.fromNamespaceAndPath(MountainsPoemMod.MOD_ID, "common_food_3"))) && (new Object() {
            public ItemStack getItemStack(LevelAccessor world, BlockPos pos, int slotid) {
                AtomicReference<ItemStack> _retval = new AtomicReference<>(ItemStack.EMPTY);
                BlockEntity _ent = world.getBlockEntity(pos);
                if (_ent != null)
                    _ent.getCapability(ForgeCapabilities.ITEM_HANDLER, null).ifPresent(capability -> _retval.set(capability.getStackInSlot(slotid).copy()));
                return _retval.get();
            }
        }.getItemStack(world, BlockPos.containing(x, y - 1, z), 2)).is(ItemTags.create(ResourceLocation.fromNamespaceAndPath(MountainsPoemMod.MOD_ID, "common_food_3"))) && (new Object() {
            public ItemStack getItemStack(LevelAccessor world, BlockPos pos, int slotid) {
                AtomicReference<ItemStack> _retval = new AtomicReference<>(ItemStack.EMPTY);
                BlockEntity _ent = world.getBlockEntity(pos);
                if (_ent != null)
                    _ent.getCapability(ForgeCapabilities.ITEM_HANDLER, null).ifPresent(capability -> _retval.set(capability.getStackInSlot(slotid).copy()));
                return _retval.get();
            }
        }.getItemStack(world, BlockPos.containing(x, y - 1, z), 3)).getItem() == MountainsPoemModItems.MP_JADE_RING.get() && (new Object() {
            public ItemStack getItemStack(LevelAccessor world, BlockPos pos, int slotid) {
                AtomicReference<ItemStack> _retval = new AtomicReference<>(ItemStack.EMPTY);
                BlockEntity _ent = world.getBlockEntity(pos);
                if (_ent != null)
                    _ent.getCapability(ForgeCapabilities.ITEM_HANDLER, null).ifPresent(capability -> _retval.set(capability.getStackInSlot(slotid).copy()));
                return _retval.get();
            }
        }.getItemStack(world, BlockPos.containing(x, y - 1, z), 4)).is(ItemTags.create(ResourceLocation.fromNamespaceAndPath(MountainsPoemMod.MOD_ID, "special_xuan_shells"))) && new Object() {
            public int getAmount(LevelAccessor world, BlockPos pos, int slotid) {
                AtomicInteger _retval = new AtomicInteger(0);
                BlockEntity _ent = world.getBlockEntity(pos);
                if (_ent != null)
                    _ent.getCapability(ForgeCapabilities.ITEM_HANDLER, null).ifPresent(capability -> _retval.set(capability.getStackInSlot(slotid).getCount()));
                return _retval.get();
            }
        }.getAmount(world, BlockPos.containing(x, y - 1, z), 0) >= 16 && new Object() {
            public int getAmount(LevelAccessor world, BlockPos pos, int slotid) {
                AtomicInteger _retval = new AtomicInteger(0);
                BlockEntity _ent = world.getBlockEntity(pos);
                if (_ent != null)
                    _ent.getCapability(ForgeCapabilities.ITEM_HANDLER, null).ifPresent(capability -> _retval.set(capability.getStackInSlot(slotid).getCount()));
                return _retval.get();
            }
        }.getAmount(world, BlockPos.containing(x, y - 1, z), 1) >= 16 && new Object() {
            public int getAmount(LevelAccessor world, BlockPos pos, int slotid) {
                AtomicInteger _retval = new AtomicInteger(0);
                BlockEntity _ent = world.getBlockEntity(pos);
                if (_ent != null)
                    _ent.getCapability(ForgeCapabilities.ITEM_HANDLER, null).ifPresent(capability -> _retval.set(capability.getStackInSlot(slotid).getCount()));
                return _retval.get();
            }
        }.getAmount(world, BlockPos.containing(x, y - 1, z), 2) >= 16 && new Object() {
            public int getAmount(LevelAccessor world, BlockPos pos, int slotid) {
                AtomicInteger _retval = new AtomicInteger(0);
                BlockEntity _ent = world.getBlockEntity(pos);
                if (_ent != null)
                    _ent.getCapability(ForgeCapabilities.ITEM_HANDLER, null).ifPresent(capability -> _retval.set(capability.getStackInSlot(slotid).getCount()));
                return _retval.get();
            }
        }.getAmount(world, BlockPos.containing(x, y - 1, z), 3) >= 10) {
            entity.swing(InteractionHand.MAIN_HAND, true);
            if (Math.random() < 0.3) {
                entity.getOffhandItem().shrink(1);
            }
            {
                ItemStack _ist = entity.getMainHandItem();
                if (_ist.hurt(1, RandomSource.create(), null)) {
                    _ist.shrink(1);
                    _ist.setDamageValue(0);
                }
            }
            {
                BlockEntity _ent = world.getBlockEntity(BlockPos.containing(x, y + 1, z));
                if (_ent != null) {
                    final int _slotid = 0;
                    final int _amount = 64;
                    _ent.getCapability(ForgeCapabilities.ITEM_HANDLER, null).ifPresent(capability -> {
                        if (capability instanceof IItemHandlerModifiable) {
                            ItemStack _stk = capability.getStackInSlot(_slotid).copy();
                            _stk.shrink(_amount);
                            ((IItemHandlerModifiable) capability).setStackInSlot(_slotid, _stk);
                        }
                    });
                }
            }
            {
                BlockEntity _ent = world.getBlockEntity(BlockPos.containing(x, y - 1, z));
                if (_ent != null) {
                    final int _slotid = 0;
                    final int _amount = 16;
                    _ent.getCapability(ForgeCapabilities.ITEM_HANDLER, null).ifPresent(capability -> {
                        if (capability instanceof IItemHandlerModifiable) {
                            ItemStack _stk = capability.getStackInSlot(_slotid).copy();
                            _stk.shrink(_amount);
                            ((IItemHandlerModifiable) capability).setStackInSlot(_slotid, _stk);
                        }
                    });
                }
            }
            {
                BlockEntity _ent = world.getBlockEntity(BlockPos.containing(x, y - 1, z));
                if (_ent != null) {
                    final int _slotid = 1;
                    final int _amount = 16;
                    _ent.getCapability(ForgeCapabilities.ITEM_HANDLER, null).ifPresent(capability -> {
                        if (capability instanceof IItemHandlerModifiable) {
                            ItemStack _stk = capability.getStackInSlot(_slotid).copy();
                            _stk.shrink(_amount);
                            ((IItemHandlerModifiable) capability).setStackInSlot(_slotid, _stk);
                        }
                    });
                }
            }
            {
                BlockEntity _ent = world.getBlockEntity(BlockPos.containing(x, y - 1, z));
                if (_ent != null) {
                    final int _slotid = 2;
                    final int _amount = 16;
                    _ent.getCapability(ForgeCapabilities.ITEM_HANDLER, null).ifPresent(capability -> {
                        if (capability instanceof IItemHandlerModifiable) {
                            ItemStack _stk = capability.getStackInSlot(_slotid).copy();
                            _stk.shrink(_amount);
                            ((IItemHandlerModifiable) capability).setStackInSlot(_slotid, _stk);
                        }
                    });
                }
            }
            {
                BlockEntity _ent = world.getBlockEntity(BlockPos.containing(x, y - 1, z));
                if (_ent != null) {
                    final int _slotid = 3;
                    final int _amount = 10;
                    _ent.getCapability(ForgeCapabilities.ITEM_HANDLER, null).ifPresent(capability -> {
                        if (capability instanceof IItemHandlerModifiable) {
                            ItemStack _stk = capability.getStackInSlot(_slotid).copy();
                            _stk.shrink(_amount);
                            ((IItemHandlerModifiable) capability).setStackInSlot(_slotid, _stk);
                        }
                    });
                }
            }
            if (world instanceof ServerLevel _level)
                _level.sendParticles(MountainsPoemModParticleTypes.SACRIFICE_E.get(), x, y, z, 11, 3, 3, 3, 1);
            if (world instanceof ServerLevel _level)
                _level.sendParticles(MountainsPoemModParticleTypes.GUI_B.get(), x, (y + 1), z, 8, 3, 3, 3, 1);
            if (Math.random() < 0.5) {
                if (world instanceof ServerLevel _level) {
                    LightningBolt entityToSpawn = EntityType.LIGHTNING_BOLT.create(_level);
                    entityToSpawn.moveTo(Vec3.atBottomCenterOf(pos));
                    entityToSpawn.setVisualOnly(true);
                    _level.addFreshEntity(entityToSpawn);
                }
                if (world instanceof ServerLevel _level) {
                    Entity entityToSpawn = MountainsPoemModEntities.LOONG_HEAD_HORSE_BODY_GOD.get().spawn(_level, BlockPos.containing(x, y + 3, z), MobSpawnType.MOB_SUMMONED);
                    if (entityToSpawn != null) {
                    }
                }
            } else {
                if (Math.random() < 0.4) {
                    if (world instanceof ServerLevel _level) {
                        Entity entityToSpawn = MountainsPoemModEntities.FENGHUANG_PHOENIX.get().spawn(_level, pos, MobSpawnType.MOB_SUMMONED);
                        if (entityToSpawn != null) {
                            entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
                        }
                    }
                }
                if (Math.random() < 0.6) {
                    {
                        final Vec3 _center = new Vec3(x, y, z);
                        List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(4 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
                        for (Entity entityiterator : _entfound) {
                            if (entityiterator.getType().is(TagKey.create(Registries.ENTITY_TYPE, ResourceLocation.fromNamespaceAndPath(MountainsPoemMod.MOD_ID, "human")))) {
                                if (entityiterator instanceof LivingEntity _entity && !_entity.level().isClientSide())
                                    _entity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_BOOST, 3000, 3));
                                if (entityiterator instanceof LivingEntity _entity && !_entity.level().isClientSide())
                                    _entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 1500, 3));
                                if (entityiterator instanceof LivingEntity _entity && !_entity.level().isClientSide())
                                    _entity.addEffect(new MobEffectInstance(MobEffects.HEALTH_BOOST, 1000, 3));
                                if (entityiterator instanceof LivingEntity _entity && !_entity.level().isClientSide())
                                    _entity.addEffect(new MobEffectInstance(MobEffects.LUCK, 3000, 3));
                                if (entityiterator instanceof LivingEntity _entity && !_entity.level().isClientSide())
                                    _entity.addEffect(new MobEffectInstance(MobEffects.JUMP, 3000, 3));
                            }
                        }
                    }
                } else {
                    if (world instanceof ServerLevel _level) {
                        LightningBolt entityToSpawn = EntityType.LIGHTNING_BOLT.create(_level);
                        entityToSpawn.moveTo(Vec3.atBottomCenterOf(pos));
                        _level.addFreshEntity(entityToSpawn);
                    }
                }
            }
        }
    }
}
