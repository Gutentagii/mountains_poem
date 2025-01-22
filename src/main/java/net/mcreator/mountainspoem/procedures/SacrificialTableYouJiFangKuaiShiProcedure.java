package net.mcreator.mountainspoem.procedures;

import net.mcreator.mountainspoem.init.MountainsPoemModParticleTypes;
import net.mcreator.mountainspoem.init.MountainsPoemModMobEffects;
import net.mcreator.mountainspoem.init.MountainsPoemModItems;
import net.mcreator.mountainspoem.init.MountainsPoemModEntities;
import net.mcreator.mountainspoem.init.MountainsPoemModBlocks;
import net.mcreator.mountainspoem.entity.SouthMountainGodEntity;

import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.Map;
import java.util.List;
import java.util.Comparator;

public class SacrificialTableYouJiFangKuaiShiProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == MountainsPoemModBlocks.WHITE_JIAN_GRASS_MAT.get().asItem()
				&& (world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == MountainsPoemModBlocks.SACRIFICIAL_TABLE.get()) {
			(entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).shrink(1);
			if (world instanceof ServerLevel _level) {
				LightningBolt entityToSpawn = EntityType.LIGHTNING_BOLT.create(_level);
				entityToSpawn.moveTo(Vec3.atBottomCenterOf(BlockPos.containing(x, y, z)));
				entityToSpawn.setVisualOnly(true);
				_level.addFreshEntity(entityToSpawn);
			}
			if (world instanceof ServerLevel _level)
				_level.sendParticles((SimpleParticleType) (MountainsPoemModParticleTypes.SACRIFICE_A.get()), x, y, z, 8, 3, 3, 3, 1);
			{
				BlockPos _bp = BlockPos.containing(x, y, z);
				BlockState _bs = MountainsPoemModBlocks.WHITE_JIAN_GRASS_MAT_COVERED_SACRIFICIAL_TABLE.get().defaultBlockState();
				BlockState _bso = world.getBlockState(_bp);
				for (Map.Entry<Property<?>, Comparable<?>> entry : _bso.getValues().entrySet()) {
					Property _property = _bs.getBlock().getStateDefinition().getProperty(entry.getKey().getName());
					if (_property != null && _bs.getValue(_property) != null)
						try {
							_bs = _bs.setValue(_property, (Comparable) entry.getValue());
						} catch (Exception e) {
						}
				}
				BlockEntity _be = world.getBlockEntity(_bp);
				CompoundTag _bnbt = null;
				if (_be != null) {
					_bnbt = _be.saveWithFullMetadata();
					_be.setRemoved();
				}
				world.setBlock(_bp, _bs, 3);
				if (_bnbt != null) {
					_be = world.getBlockEntity(_bp);
					if (_be != null) {
						try {
							_be.load(_bnbt);
						} catch (Exception ignored) {
						}
					}
				}
			}
		}
		if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == MountainsPoemModItems.BOTTLE_OF_SOUL_SHARDS.get()) {
			(entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).shrink(1);
			if (world instanceof ServerLevel _level) {
				LightningBolt entityToSpawn = EntityType.LIGHTNING_BOLT.create(_level);
				entityToSpawn.moveTo(Vec3.atBottomCenterOf(BlockPos.containing(x, y, z)));
				entityToSpawn.setVisualOnly(true);
				_level.addFreshEntity(entityToSpawn);
			}
			if (Math.random() < 0.5) {
				if (world instanceof ServerLevel _level) {
					Entity entityToSpawn = MountainsPoemModEntities.WANDERING_GHOST.get().spawn(_level, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
					if (entityToSpawn != null) {
					}
				}
			} else {
				if (Math.random() < 0.5) {
					if (world instanceof ServerLevel _level) {
						Entity entityToSpawn = MountainsPoemModEntities.IMPERIAL_EXAMINATION_GHOST.get().spawn(_level, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
						if (entityToSpawn != null) {
						}
					}
				} else {
					if (Math.random() < 0.5) {
						if (world instanceof ServerLevel _level) {
							Entity entityToSpawn = MountainsPoemModEntities.UNDER_GHOST.get().spawn(_level, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
							if (entityToSpawn != null) {
							}
						}
					} else {
						if (world instanceof ServerLevel _level) {
							Entity entityToSpawn = MountainsPoemModEntities.HANGED_GHOST.get().spawn(_level, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
							if (entityToSpawn != null) {
							}
						}
					}
				}
			}
			if (world instanceof ServerLevel _level)
				_level.sendParticles((SimpleParticleType) (MountainsPoemModParticleTypes.SACRIFICE_E.get()), x, y, z, 8, 3, 3, 3, 1);
		}
		if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == Items.SHEARS
				&& (world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == MountainsPoemModBlocks.WHITE_JIAN_GRASS_MAT_COVERED_SACRIFICIAL_TABLE.get()) {
			{
				ItemStack _ist = (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY);
				if (_ist.hurt(1, RandomSource.create(), null)) {
					_ist.shrink(1);
					_ist.setDamageValue(0);
				}
			}
			if (world instanceof ServerLevel _level) {
				LightningBolt entityToSpawn = EntityType.LIGHTNING_BOLT.create(_level);
				entityToSpawn.moveTo(Vec3.atBottomCenterOf(BlockPos.containing(x, y, z)));
				entityToSpawn.setVisualOnly(true);
				_level.addFreshEntity(entityToSpawn);
			}
			if (world instanceof ServerLevel _level)
				_level.sendParticles((SimpleParticleType) (MountainsPoemModParticleTypes.SACRIFICE_A.get()), x, y, z, 8, 3, 3, 3, 1);
			{
				BlockPos _bp = BlockPos.containing(x, y, z);
				BlockState _bs = MountainsPoemModBlocks.SACRIFICIAL_TABLE.get().defaultBlockState();
				BlockState _bso = world.getBlockState(_bp);
				for (Map.Entry<Property<?>, Comparable<?>> entry : _bso.getValues().entrySet()) {
					Property _property = _bs.getBlock().getStateDefinition().getProperty(entry.getKey().getName());
					if (_property != null && _bs.getValue(_property) != null)
						try {
							_bs = _bs.setValue(_property, (Comparable) entry.getValue());
						} catch (Exception e) {
						}
				}
				BlockEntity _be = world.getBlockEntity(_bp);
				CompoundTag _bnbt = null;
				if (_be != null) {
					_bnbt = _be.saveWithFullMetadata();
					_be.setRemoved();
				}
				world.setBlock(_bp, _bs, 3);
				if (_bnbt != null) {
					_be = world.getBlockEntity(_bp);
					if (_be != null) {
						try {
							_be.load(_bnbt);
						} catch (Exception ignored) {
						}
					}
				}
			}
			if (world instanceof ServerLevel _level) {
				ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, new ItemStack(MountainsPoemModBlocks.WHITE_JIAN_GRASS_MAT.get()));
				entityToSpawn.setPickUpDelay(0);
				entityToSpawn.setUnlimitedLifetime();
				_level.addFreshEntity(entityToSpawn);
			}
		}
		if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).is(ItemTags.create(new ResourceLocation("mountains_poem:sacrifcial_tools")))
				&& (entity instanceof LivingEntity _livEnt ? _livEnt.getOffhandItem() : ItemStack.EMPTY).getItem() == MountainsPoemModItems.THE_SOUTHERN_MOUNTAIN_JADE_PENDANT.get()
				&& (world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == MountainsPoemModBlocks.WHITE_JIAN_GRASS_MAT_COVERED_SACRIFICIAL_TABLE.get()
				&& (world.getBlockState(BlockPos.containing(x, y + 1, z))).is(BlockTags.create(new ResourceLocation("mountains_poem:gui_block"))) && (new Object() {
					public ItemStack getItemStack(LevelAccessor world, BlockPos pos, int slotid) {
						AtomicReference<ItemStack> _retval = new AtomicReference<>(ItemStack.EMPTY);
						BlockEntity _ent = world.getBlockEntity(pos);
						if (_ent != null)
							_ent.getCapability(ForgeCapabilities.ITEM_HANDLER, null).ifPresent(capability -> _retval.set(capability.getStackInSlot(slotid).copy()));
						return _retval.get();
					}
				}.getItemStack(world, BlockPos.containing(x, y + 1, z), 0)).is(ItemTags.create(new ResourceLocation("forge:rice"))) && new Object() {
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
				}.getItemStack(world, BlockPos.containing(x, y - 1, z), 0)).is(ItemTags.create(new ResourceLocation("mountains_poem:common_food_2"))) && (new Object() {
					public ItemStack getItemStack(LevelAccessor world, BlockPos pos, int slotid) {
						AtomicReference<ItemStack> _retval = new AtomicReference<>(ItemStack.EMPTY);
						BlockEntity _ent = world.getBlockEntity(pos);
						if (_ent != null)
							_ent.getCapability(ForgeCapabilities.ITEM_HANDLER, null).ifPresent(capability -> _retval.set(capability.getStackInSlot(slotid).copy()));
						return _retval.get();
					}
				}.getItemStack(world, BlockPos.containing(x, y - 1, z), 1)).is(ItemTags.create(new ResourceLocation("mountains_poem:common_food_2"))) && (new Object() {
					public ItemStack getItemStack(LevelAccessor world, BlockPos pos, int slotid) {
						AtomicReference<ItemStack> _retval = new AtomicReference<>(ItemStack.EMPTY);
						BlockEntity _ent = world.getBlockEntity(pos);
						if (_ent != null)
							_ent.getCapability(ForgeCapabilities.ITEM_HANDLER, null).ifPresent(capability -> _retval.set(capability.getStackInSlot(slotid).copy()));
						return _retval.get();
					}
				}.getItemStack(world, BlockPos.containing(x, y - 1, z), 2)).is(ItemTags.create(new ResourceLocation("mountains_poem:common_food_2"))) && (new Object() {
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
				}.getItemStack(world, BlockPos.containing(x, y - 1, z), 4)).is(ItemTags.create(new ResourceLocation("mountains_poem:common_xuan_shells"))) && new Object() {
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
			if (entity instanceof LivingEntity _entity)
				_entity.swing(InteractionHand.MAIN_HAND, true);
			if (Math.random() < 0.3) {
				(entity instanceof LivingEntity _livEnt ? _livEnt.getOffhandItem() : ItemStack.EMPTY).shrink(1);
			}
			{
				ItemStack _ist = (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY);
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
				_level.sendParticles((SimpleParticleType) (MountainsPoemModParticleTypes.SACRIFICE_C.get()), x, y, z, 11, 3, 3, 3, 1);
			if (world instanceof ServerLevel _level)
				_level.sendParticles((SimpleParticleType) (MountainsPoemModParticleTypes.GUI_A.get()), x, (y + 1), z, 8, 3, 3, 3, 1);
			if (Math.random() < 0.5) {
				if (world instanceof ServerLevel _level) {
					LightningBolt entityToSpawn = EntityType.LIGHTNING_BOLT.create(_level);
					entityToSpawn.moveTo(Vec3.atBottomCenterOf(BlockPos.containing(x, y, z)));
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
							if (entityiterator.getType().is(TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation("mountains_poem:human")))) {
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
						entityToSpawn.moveTo(Vec3.atBottomCenterOf(BlockPos.containing(x, y, z)));;
						_level.addFreshEntity(entityToSpawn);
					}
				}
				if (Math.random() < 0.4) {
					if (world instanceof ServerLevel _level) {
						Entity entityToSpawn = MountainsPoemModEntities.FENGHUANG_PHOENIX.get().spawn(_level, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
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
		if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).is(ItemTags.create(new ResourceLocation("mountains_poem:sacrifcial_tools")))
				&& (entity instanceof LivingEntity _livEnt ? _livEnt.getOffhandItem() : ItemStack.EMPTY).getItem() == MountainsPoemModItems.THE_SECOND_SOUTHERN_MOUNTAIN_JADE_PENDANT.get()
				&& (world.getBlockState(BlockPos.containing(x, y, z))).is(BlockTags.create(new ResourceLocation("mountains_poem:sacrificial_table_block")))
				&& (world.getBlockState(BlockPos.containing(x, y + 1, z))).is(BlockTags.create(new ResourceLocation("mountains_poem:gui_block"))) && (new Object() {
					public ItemStack getItemStack(LevelAccessor world, BlockPos pos, int slotid) {
						AtomicReference<ItemStack> _retval = new AtomicReference<>(ItemStack.EMPTY);
						BlockEntity _ent = world.getBlockEntity(pos);
						if (_ent != null)
							_ent.getCapability(ForgeCapabilities.ITEM_HANDLER, null).ifPresent(capability -> _retval.set(capability.getStackInSlot(slotid).copy()));
						return _retval.get();
					}
				}.getItemStack(world, BlockPos.containing(x, y + 1, z), 0)).is(ItemTags.create(new ResourceLocation("forge:rice"))) && new Object() {
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
				}.getItemStack(world, BlockPos.containing(x, y - 1, z), 0)).is(ItemTags.create(new ResourceLocation("mountains_poem:common_food"))) && (new Object() {
					public ItemStack getItemStack(LevelAccessor world, BlockPos pos, int slotid) {
						AtomicReference<ItemStack> _retval = new AtomicReference<>(ItemStack.EMPTY);
						BlockEntity _ent = world.getBlockEntity(pos);
						if (_ent != null)
							_ent.getCapability(ForgeCapabilities.ITEM_HANDLER, null).ifPresent(capability -> _retval.set(capability.getStackInSlot(slotid).copy()));
						return _retval.get();
					}
				}.getItemStack(world, BlockPos.containing(x, y - 1, z), 1)).is(ItemTags.create(new ResourceLocation("mountains_poem:common_food"))) && (new Object() {
					public ItemStack getItemStack(LevelAccessor world, BlockPos pos, int slotid) {
						AtomicReference<ItemStack> _retval = new AtomicReference<>(ItemStack.EMPTY);
						BlockEntity _ent = world.getBlockEntity(pos);
						if (_ent != null)
							_ent.getCapability(ForgeCapabilities.ITEM_HANDLER, null).ifPresent(capability -> _retval.set(capability.getStackInSlot(slotid).copy()));
						return _retval.get();
					}
				}.getItemStack(world, BlockPos.containing(x, y - 1, z), 2)).is(ItemTags.create(new ResourceLocation("mountains_poem:common_food"))) && (new Object() {
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
				}.getItemStack(world, BlockPos.containing(x, y - 1, z), 4)).is(ItemTags.create(new ResourceLocation("mountains_poem:special_xuan_shells"))) && new Object() {
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
			if (entity instanceof LivingEntity _entity)
				_entity.swing(InteractionHand.MAIN_HAND, true);
			if (Math.random() < 0.3) {
				(entity instanceof LivingEntity _livEnt ? _livEnt.getOffhandItem() : ItemStack.EMPTY).shrink(1);
			}
			{
				ItemStack _ist = (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY);
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
				_level.sendParticles((SimpleParticleType) (MountainsPoemModParticleTypes.SACRIFICE_C.get()), x, y, z, 11, 3, 3, 3, 1);
			if (world instanceof ServerLevel _level)
				_level.sendParticles((SimpleParticleType) (MountainsPoemModParticleTypes.GUI_C.get()), x, (y + 1), z, 8, 3, 3, 3, 1);
			if (Math.random() < 0.5) {
				if (world instanceof ServerLevel _level) {
					LightningBolt entityToSpawn = EntityType.LIGHTNING_BOLT.create(_level);
					entityToSpawn.moveTo(Vec3.atBottomCenterOf(BlockPos.containing(x, y, z)));
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
						Entity entityToSpawn = MountainsPoemModEntities.FENGHUANG_PHOENIX.get().spawn(_level, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
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
							if (entityiterator.getType().is(TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation("mountains_poem:human")))) {
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
						entityToSpawn.moveTo(Vec3.atBottomCenterOf(BlockPos.containing(x, y, z)));;
						_level.addFreshEntity(entityToSpawn);
					}
				}
			}
		}
		if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).is(ItemTags.create(new ResourceLocation("mountains_poem:sacrifcial_tools")))
				&& (entity instanceof LivingEntity _livEnt ? _livEnt.getOffhandItem() : ItemStack.EMPTY).getItem() == MountainsPoemModItems.THE_NINTH_CENTRAL_MOUNTAIN_JADE_PENDANT.get()
				&& (world.getBlockState(BlockPos.containing(x, y, z))).is(BlockTags.create(new ResourceLocation("mountains_poem:sacrificial_table_block")))
				&& (world.getBlockState(BlockPos.containing(x, y + 1, z))).is(BlockTags.create(new ResourceLocation("mountains_poem:gui_block"))) && (new Object() {
					public ItemStack getItemStack(LevelAccessor world, BlockPos pos, int slotid) {
						AtomicReference<ItemStack> _retval = new AtomicReference<>(ItemStack.EMPTY);
						BlockEntity _ent = world.getBlockEntity(pos);
						if (_ent != null)
							_ent.getCapability(ForgeCapabilities.ITEM_HANDLER, null).ifPresent(capability -> _retval.set(capability.getStackInSlot(slotid).copy()));
						return _retval.get();
					}
				}.getItemStack(world, BlockPos.containing(x, y + 1, z), 0)).is(ItemTags.create(new ResourceLocation("forge:rice"))) && new Object() {
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
				}.getItemStack(world, BlockPos.containing(x, y - 1, z), 0)).is(ItemTags.create(new ResourceLocation("mountains_poem:common_food_3"))) && (new Object() {
					public ItemStack getItemStack(LevelAccessor world, BlockPos pos, int slotid) {
						AtomicReference<ItemStack> _retval = new AtomicReference<>(ItemStack.EMPTY);
						BlockEntity _ent = world.getBlockEntity(pos);
						if (_ent != null)
							_ent.getCapability(ForgeCapabilities.ITEM_HANDLER, null).ifPresent(capability -> _retval.set(capability.getStackInSlot(slotid).copy()));
						return _retval.get();
					}
				}.getItemStack(world, BlockPos.containing(x, y - 1, z), 1)).is(ItemTags.create(new ResourceLocation("mountains_poem:common_food_3"))) && (new Object() {
					public ItemStack getItemStack(LevelAccessor world, BlockPos pos, int slotid) {
						AtomicReference<ItemStack> _retval = new AtomicReference<>(ItemStack.EMPTY);
						BlockEntity _ent = world.getBlockEntity(pos);
						if (_ent != null)
							_ent.getCapability(ForgeCapabilities.ITEM_HANDLER, null).ifPresent(capability -> _retval.set(capability.getStackInSlot(slotid).copy()));
						return _retval.get();
					}
				}.getItemStack(world, BlockPos.containing(x, y - 1, z), 2)).is(ItemTags.create(new ResourceLocation("mountains_poem:common_food_3"))) && (new Object() {
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
				}.getItemStack(world, BlockPos.containing(x, y - 1, z), 4)).is(ItemTags.create(new ResourceLocation("mountains_poem:special_xuan_shells"))) && new Object() {
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
			if (entity instanceof LivingEntity _entity)
				_entity.swing(InteractionHand.MAIN_HAND, true);
			if (Math.random() < 0.3) {
				(entity instanceof LivingEntity _livEnt ? _livEnt.getOffhandItem() : ItemStack.EMPTY).shrink(1);
			}
			{
				ItemStack _ist = (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY);
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
				_level.sendParticles((SimpleParticleType) (MountainsPoemModParticleTypes.SACRIFICE_E.get()), x, y, z, 11, 3, 3, 3, 1);
			if (world instanceof ServerLevel _level)
				_level.sendParticles((SimpleParticleType) (MountainsPoemModParticleTypes.GUI_B.get()), x, (y + 1), z, 8, 3, 3, 3, 1);
			if (Math.random() < 0.5) {
				if (world instanceof ServerLevel _level) {
					LightningBolt entityToSpawn = EntityType.LIGHTNING_BOLT.create(_level);
					entityToSpawn.moveTo(Vec3.atBottomCenterOf(BlockPos.containing(x, y, z)));
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
						Entity entityToSpawn = MountainsPoemModEntities.FENGHUANG_PHOENIX.get().spawn(_level, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
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
							if (entityiterator.getType().is(TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation("mountains_poem:human")))) {
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
						entityToSpawn.moveTo(Vec3.atBottomCenterOf(BlockPos.containing(x, y, z)));;
						_level.addFreshEntity(entityToSpawn);
					}
				}
			}
		}
	}
}
