package net.mcreator.mountainspoem.procedures;

import net.mcreator.mountainspoem.entity.LeiEntity;

public class LeiYouJiShiTiShiProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, Entity sourceentity) {
		if (entity == null || sourceentity == null)
			return;
		if ((sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).is(ItemTags.create(new ResourceLocation("mountains_poem:lei_foods")))) {
			if (sourceentity instanceof LivingEntity _entity)
				_entity.swing(InteractionHand.MAIN_HAND, true);
			(sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).shrink(1);
			if (world instanceof Level _level) {
				if (!_level.isClientSide()) {
					_level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("mountains_poem:lei")), SoundSource.NEUTRAL, 1, 2);
				} else {
					_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("mountains_poem:lei")), SoundSource.NEUTRAL, 1, 2, false);
				}
			}
			if (entity instanceof LivingEntity _livEnt6 && _livEnt6.isBaby() && (entity instanceof LeiEntity animatable ? animatable.getTexture() : "null").equals("lei_lion_3")
					&& (entity instanceof LeiEntity animatable ? animatable.getTexture() : "null").equals("lei_lion_6")) {
				if (world instanceof ServerLevel _level)
					_level.sendParticles(ParticleTypes.HEART, x, y, z, 5, 3, 3, 3, 1);
				if (Math.random() < 0.7) {
					if (entity instanceof LeiEntity) {
						((LeiEntity) entity).setAnimation("thanks");
					}
				}
			} else {
				if (world instanceof ServerLevel _level)
					_level.sendParticles(ParticleTypes.HEART, x, y, z, 5, 3, 3, 3, 1);
				if (Math.random() < 0.3) {
					if (entity instanceof LeiEntity) {
						((LeiEntity) entity).setAnimation("hello");
					}
				}
			}
		}
		if ((entity instanceof LeiEntity animatable ? animatable.getTexture() : "null").equals("lei_lion") || (entity instanceof LeiEntity animatable ? animatable.getTexture() : "null").equals("lei_lion_2")) {
			if ((sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).is(ItemTags.create(new ResourceLocation("forge:shears")))) {
				if (sourceentity instanceof LivingEntity _entity)
					_entity.swing(InteractionHand.MAIN_HAND, true);
				{
					ItemStack _ist = (sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY);
					if (_ist.hurt(1, RandomSource.create(), null)) {
						_ist.shrink(1);
						_ist.setDamageValue(0);
					}
				}
				if (entity instanceof LeiEntity) {
					((LeiEntity) entity).setAnimation("hair");
				}
				if (!world.isClientSide() && world.getServer() != null) {
					BlockPos _bpLootTblWorld = BlockPos.containing(x, y, z);
					for (ItemStack itemstackiterator : world.getServer().getLootData().getLootTable(new ResourceLocation("mountains_poem:lei_hair_1"))
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
				if (world instanceof Level _level) {
					if (!_level.isClientSide()) {
						_level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("mountains_poem:lei_2")), SoundSource.NEUTRAL, 1, 1);
					} else {
						_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("mountains_poem:lei_2")), SoundSource.NEUTRAL, 1, 1, false);
					}
				}
				if (entity instanceof LeiEntity animatable)
					animatable.setTexture("lei_lion_3");
				if (sourceentity instanceof ServerPlayer _player) {
					Advancement _adv = _player.server.getAdvancements().getAdvancement(new ResourceLocation("mountains_poem:sour_bread"));
					AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
					if (!_ap.isDone()) {
						for (String criteria : _ap.getRemainingCriteria())
							_player.getAdvancements().award(_adv, criteria);
					}
				}
			}
		}
		if ((entity instanceof LeiEntity animatable ? animatable.getTexture() : "null").equals("lei_lion_4") || (entity instanceof LeiEntity animatable ? animatable.getTexture() : "null").equals("lei_lion_5")) {
			if ((sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).is(ItemTags.create(new ResourceLocation("forge:shears")))) {
				if (sourceentity instanceof LivingEntity _entity)
					_entity.swing(InteractionHand.MAIN_HAND, true);
				{
					ItemStack _ist = (sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY);
					if (_ist.hurt(1, RandomSource.create(), null)) {
						_ist.shrink(1);
						_ist.setDamageValue(0);
					}
				}
				if (entity instanceof LeiEntity) {
					((LeiEntity) entity).setAnimation("hair");
				}
				if (!world.isClientSide() && world.getServer() != null) {
					BlockPos _bpLootTblWorld = BlockPos.containing(x, y, z);
					for (ItemStack itemstackiterator : world.getServer().getLootData().getLootTable(new ResourceLocation("mountains_poem:lei_hair_2"))
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
				if (world instanceof Level _level) {
					if (!_level.isClientSide()) {
						_level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("mountains_poem:lei_2")), SoundSource.NEUTRAL, 1, 1);
					} else {
						_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("mountains_poem:lei_2")), SoundSource.NEUTRAL, 1, 1, false);
					}
				}
				if (entity instanceof LeiEntity animatable)
					animatable.setTexture("lei_lion_6");
				if (sourceentity instanceof ServerPlayer _player) {
					Advancement _adv = _player.server.getAdvancements().getAdvancement(new ResourceLocation("mountains_poem:a_bread"));
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
