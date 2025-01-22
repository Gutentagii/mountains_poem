package net.mcreator.mountainspoem.procedures;

import net.mcreator.mountainspoem.init.MountainsPoemModItems;
import net.mcreator.mountainspoem.entity.HuHorseEntity;
import net.mcreator.mountainspoem.MountainsPoemMod;

import java.util.concurrent.atomic.AtomicReference;
import java.util.List;
import java.util.Comparator;

public class HuHorseDangShiTiGengXinKeShiProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if ((entity instanceof TamableAnimal _tamEnt ? _tamEnt.isTame() : false) && (entity instanceof LivingEntity _livEnt1 && _livEnt1.isBaby()) == false
				&& ((entity instanceof HuHorseEntity animatable ? animatable.getTexture() : "null").equals("water_horse_diamond") || (entity instanceof HuHorseEntity animatable ? animatable.getTexture() : "null").equals("water_horse_gold")
						|| (entity instanceof HuHorseEntity animatable ? animatable.getTexture() : "null").equals("water_horse_iron") || (entity instanceof HuHorseEntity animatable ? animatable.getTexture() : "null").equals("water_horse_saddle")
						|| (entity instanceof HuHorseEntity animatable ? animatable.getTexture() : "null").equals("water_horse_netherite")
						|| (entity instanceof HuHorseEntity animatable ? animatable.getTexture() : "null").equals("water_horse_blood_copper"))) {
			if (entity.isVehicle()) {
				{
					final Vec3 _center = new Vec3(x, y, z);
					List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(1 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
					for (Entity entityiterator : _entfound) {
						if (entityiterator instanceof HuHorseEntity == false && (entityiterator == (entity.getControllingPassenger())) == false) {
							if (entityiterator.getBbHeight() >= 3 && entityiterator.getBbWidth() >= 3) {
								entityiterator.hurt(new DamageSource(world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(ResourceKey.create(Registries.DAMAGE_TYPE, new ResourceLocation("mountains_poem:bump"))), entity),
										2);
								entityiterator.setDeltaMovement(new Vec3(0, 0.2, 0));
								if (entity instanceof HuHorseEntity) {
									((HuHorseEntity) entity).setAnimation("crash");
								}
								if (entityiterator instanceof ServerPlayer _player) {
									Advancement _adv = _player.server.getAdvancements().getAdvancement(new ResourceLocation("mountains_poem:bumped_by_a_water_horse"));
									AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
									if (!_ap.isDone()) {
										for (String criteria : _ap.getRemainingCriteria())
											_player.getAdvancements().award(_adv, criteria);
									}
								}
							}
							if (entityiterator.getBbHeight() < 3 && entityiterator.getBbWidth() < 3) {
								entityiterator.hurt(new DamageSource(world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(ResourceKey.create(Registries.DAMAGE_TYPE, new ResourceLocation("mountains_poem:bump"))), entity),
										8);
								entityiterator.setDeltaMovement(new Vec3(0, 0.3, 0));
								if (entity instanceof HuHorseEntity) {
									((HuHorseEntity) entity).setAnimation("crash");
								}
								if (entityiterator instanceof ServerPlayer _player) {
									Advancement _adv = _player.server.getAdvancements().getAdvancement(new ResourceLocation("mountains_poem:bumped_by_a_water_horse"));
									AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
									if (!_ap.isDone()) {
										for (String criteria : _ap.getRemainingCriteria())
											_player.getAdvancements().award(_adv, criteria);
									}
								}
							}
						}
					}
				}
			}
		} else {
			if ((entity instanceof HuHorseEntity animatable ? animatable.getTexture() : "null").equals("water_horse")) {
				if (entity instanceof LivingEntity _entity)
					_entity.removeEffect(MobEffects.DAMAGE_RESISTANCE);
			}
			for (Entity entityiterator : entity.getIndirectPassengers()) {
				if (Math.random() < 0.08) {
					if (entity instanceof TamableAnimal _toTame && entityiterator instanceof Player _owner)
						_toTame.tame(_owner);
					if (world instanceof ServerLevel _level)
						_level.sendParticles(ParticleTypes.HEART, x, y, z, 5, 1, 1, 1, 1);
					if (entityiterator instanceof ServerPlayer _player) {
						Advancement _adv = _player.server.getAdvancements().getAdvancement(new ResourceLocation("minecraft:husbandry/tame_an_animal"));
						AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
						if (!_ap.isDone()) {
							for (String criteria : _ap.getRemainingCriteria())
								_player.getAdvancements().award(_adv, criteria);
						}
					}
				} else {
					entityiterator.stopRiding();
					for (int index0 = 0; index0 < 3; index0++) {
						if (entity instanceof HuHorseEntity) {
							((HuHorseEntity) entity).setAnimation("play");
						}
					}
					if (world instanceof Level _level) {
						if (!_level.isClientSide()) {
							_level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.horse.angry")), SoundSource.NEUTRAL, 1, 3);
						} else {
							_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.horse.angry")), SoundSource.NEUTRAL, 1, 3, false);
						}
					}
					if (world instanceof ServerLevel _level)
						_level.sendParticles(ParticleTypes.SMOKE, x, y, z, 5, 2, 2, 2, 1);
					entityiterator.setShiftKeyDown(true);
					entity.setDeltaMovement(new Vec3(0.2, 0, 0.2));
					entityiterator.setDeltaMovement(new Vec3(0, 0.2, 0));
					MountainsPoemMod.queueServerWork(10, () -> {
						entityiterator.setShiftKeyDown(false);
					});
				}
			}
		}
		if ((new Object() {
			public ItemStack getItemStack(int sltid, Entity entity) {
				AtomicReference<ItemStack> _retval = new AtomicReference<>(ItemStack.EMPTY);
				entity.getCapability(ForgeCapabilities.ITEM_HANDLER, null).ifPresent(capability -> {
					_retval.set(capability.getStackInSlot(sltid).copy());
				});
				return _retval.get();
			}
		}.getItemStack(0, entity)).getItem() == MountainsPoemModItems.IRON_WATER_HORSE_ARMOR.get()) {
			if (entity instanceof HuHorseEntity animatable)
				animatable.setTexture("water_horse_iron");
		}
		if ((new Object() {
			public ItemStack getItemStack(int sltid, Entity entity) {
				AtomicReference<ItemStack> _retval = new AtomicReference<>(ItemStack.EMPTY);
				entity.getCapability(ForgeCapabilities.ITEM_HANDLER, null).ifPresent(capability -> {
					_retval.set(capability.getStackInSlot(sltid).copy());
				});
				return _retval.get();
			}
		}.getItemStack(0, entity)).getItem() == MountainsPoemModItems.GOLDEN_WATER_HORSE_ARMOR.get()) {
			if (entity instanceof HuHorseEntity animatable)
				animatable.setTexture("water_horse_gold");
		}
		if ((new Object() {
			public ItemStack getItemStack(int sltid, Entity entity) {
				AtomicReference<ItemStack> _retval = new AtomicReference<>(ItemStack.EMPTY);
				entity.getCapability(ForgeCapabilities.ITEM_HANDLER, null).ifPresent(capability -> {
					_retval.set(capability.getStackInSlot(sltid).copy());
				});
				return _retval.get();
			}
		}.getItemStack(0, entity)).getItem() == Items.SADDLE) {
			if (entity instanceof HuHorseEntity animatable)
				animatable.setTexture("water_horse_saddle");
		}
		if ((new Object() {
			public ItemStack getItemStack(int sltid, Entity entity) {
				AtomicReference<ItemStack> _retval = new AtomicReference<>(ItemStack.EMPTY);
				entity.getCapability(ForgeCapabilities.ITEM_HANDLER, null).ifPresent(capability -> {
					_retval.set(capability.getStackInSlot(sltid).copy());
				});
				return _retval.get();
			}
		}.getItemStack(0, entity)).getItem() == MountainsPoemModItems.DIAMOND_WATER_HORSE_ARMOR.get()) {
			if (entity instanceof HuHorseEntity animatable)
				animatable.setTexture("water_horse_diamond");
		}
		if ((new Object() {
			public ItemStack getItemStack(int sltid, Entity entity) {
				AtomicReference<ItemStack> _retval = new AtomicReference<>(ItemStack.EMPTY);
				entity.getCapability(ForgeCapabilities.ITEM_HANDLER, null).ifPresent(capability -> {
					_retval.set(capability.getStackInSlot(sltid).copy());
				});
				return _retval.get();
			}
		}.getItemStack(0, entity)).getItem() == MountainsPoemModItems.NETHERITE_WATER_HORSE_ARMOR.get()) {
			if (entity instanceof HuHorseEntity animatable)
				animatable.setTexture("water_horse_netherite");
		}
		if ((new Object() {
			public ItemStack getItemStack(int sltid, Entity entity) {
				AtomicReference<ItemStack> _retval = new AtomicReference<>(ItemStack.EMPTY);
				entity.getCapability(ForgeCapabilities.ITEM_HANDLER, null).ifPresent(capability -> {
					_retval.set(capability.getStackInSlot(sltid).copy());
				});
				return _retval.get();
			}
		}.getItemStack(0, entity)).getItem() == MountainsPoemModItems.BLOOD_COPPER_WATER_HORSE_ARMOR.get()) {
			if (entity instanceof HuHorseEntity animatable)
				animatable.setTexture("water_horse_blood_copper");
		}
		if ((entity instanceof HuHorseEntity animatable ? animatable.getTexture() : "null").equals("water_horse_diamond")) {
			if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
				_entity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 60, 3, false, false));
			if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
				_entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 60, 0, false, false));
		}
		if ((entity instanceof HuHorseEntity animatable ? animatable.getTexture() : "null").equals("water_horse_iron")) {
			if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
				_entity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 60, 1, false, false));
			if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
				_entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 60, 0, false, false));
		}
		if ((entity instanceof HuHorseEntity animatable ? animatable.getTexture() : "null").equals("water_horse_gold")) {
			if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
				_entity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 60, 0, false, false));
			if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
				_entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 60, 0, false, false));
		}
		if ((entity instanceof HuHorseEntity animatable ? animatable.getTexture() : "null").equals("water_horse_netherite")) {
			if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
				_entity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 60, 3, false, false));
			if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
				_entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 60, 1, false, false));
			if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
				_entity.addEffect(new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 60, 3, false, false));
		}
		if ((entity instanceof HuHorseEntity animatable ? animatable.getTexture() : "null").equals("water_horse_blood_copper")) {
			if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
				_entity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 60, 4, false, false));
			if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
				_entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 60, 1, false, false));
		}
		if ((entity instanceof HuHorseEntity animatable ? animatable.getTexture() : "null").equals("water_horse_saddle")) {
			if (entity instanceof LivingEntity _entity)
				_entity.removeEffect(MobEffects.DAMAGE_RESISTANCE);
		}
	}
}
