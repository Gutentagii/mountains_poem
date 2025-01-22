package net.mcreator.mountainspoem.procedures;

import net.mcreator.mountainspoem.init.MountainsPoemModParticleTypes;
import net.mcreator.mountainspoem.init.MountainsPoemModMobEffects;
import net.mcreator.mountainspoem.init.MountainsPoemModItems;
import net.mcreator.mountainspoem.entity.SouthMountainGodEntity;

public class SouthMountainGodYouJiShiTiShiProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, Entity sourceentity) {
		if (entity == null || sourceentity == null)
			return;
		if ((sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == MountainsPoemModItems.TEETH_GRAVER.get()
				&& (sourceentity instanceof LivingEntity _livEnt ? _livEnt.getOffhandItem() : ItemStack.EMPTY).getItem() == MountainsPoemModItems.XUAN_SHELLS.get()) {
			if (sourceentity instanceof ServerPlayer _player) {
				Advancement _adv = _player.server.getAdvancements().getAdvancement(new ResourceLocation("mountains_poem:engrave_xuan_shells"));
				AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
				if (!_ap.isDone()) {
					for (String criteria : _ap.getRemainingCriteria())
						_player.getAdvancements().award(_adv, criteria);
				}
			}
			if (sourceentity instanceof LivingEntity _entity)
				_entity.swing(InteractionHand.MAIN_HAND, true);
			if ((entity instanceof SouthMountainGodEntity animatable ? animatable.getTexture() : "null").equals("south_god_1b")) {
				(sourceentity instanceof LivingEntity _livEnt ? _livEnt.getOffhandItem() : ItemStack.EMPTY).shrink(1);
				if (world instanceof ServerLevel _level) {
					ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, new ItemStack(MountainsPoemModItems.GANLIN_ENGRAVED_XUAN_SHELLS.get()));
					entityToSpawn.setPickUpDelay(0);
					entityToSpawn.setUnlimitedLifetime();
					_level.addFreshEntity(entityToSpawn);
				}
			}
			if ((entity instanceof SouthMountainGodEntity animatable ? animatable.getTexture() : "null").equals("south_god_1d")) {
				(sourceentity instanceof LivingEntity _livEnt ? _livEnt.getOffhandItem() : ItemStack.EMPTY).shrink(1);
				if (world instanceof ServerLevel _level) {
					ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, new ItemStack(MountainsPoemModItems.DAZZLING_STAR_ENGRAVED_XUAN_SHELLS.get()));
					entityToSpawn.setPickUpDelay(0);
					entityToSpawn.setUnlimitedLifetime();
					_level.addFreshEntity(entityToSpawn);
				}
			}
			if ((entity instanceof SouthMountainGodEntity animatable ? animatable.getTexture() : "null").equals("south_god_1e")) {
				(sourceentity instanceof LivingEntity _livEnt ? _livEnt.getOffhandItem() : ItemStack.EMPTY).shrink(1);
				if (world instanceof ServerLevel _level) {
					ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, new ItemStack(MountainsPoemModItems.RUST_ENGRAVED_XUAN_SHELLS.get()));
					entityToSpawn.setPickUpDelay(0);
					entityToSpawn.setUnlimitedLifetime();
					_level.addFreshEntity(entityToSpawn);
				}
			}
			if ((entity instanceof SouthMountainGodEntity animatable ? animatable.getTexture() : "null").equals("south_god_1")) {
				(sourceentity instanceof LivingEntity _livEnt ? _livEnt.getOffhandItem() : ItemStack.EMPTY).shrink(1);
				if (world instanceof ServerLevel _level) {
					ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, new ItemStack(MountainsPoemModItems.SCINTILLATION_ENGRAVED_XUAN_SHELLS.get()));
					entityToSpawn.setPickUpDelay(0);
					entityToSpawn.setUnlimitedLifetime();
					_level.addFreshEntity(entityToSpawn);
				}
			}
			if ((entity instanceof SouthMountainGodEntity animatable ? animatable.getTexture() : "null").equals("south_god_1f")) {
				(sourceentity instanceof LivingEntity _livEnt ? _livEnt.getOffhandItem() : ItemStack.EMPTY).shrink(1);
				if (world instanceof ServerLevel _level) {
					ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, new ItemStack(MountainsPoemModItems.SCARLET_TWILIGHT_ENGRAVED_XUAN_SHELLS.get()));
					entityToSpawn.setPickUpDelay(0);
					entityToSpawn.setUnlimitedLifetime();
					_level.addFreshEntity(entityToSpawn);
				}
			}
			if ((entity instanceof SouthMountainGodEntity animatable ? animatable.getTexture() : "null").equals("south_god_1c")) {
				(sourceentity instanceof LivingEntity _livEnt ? _livEnt.getOffhandItem() : ItemStack.EMPTY).shrink(1);
				if (world instanceof ServerLevel _level) {
					ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, new ItemStack(MountainsPoemModItems.DUSTY_SOIL_ENGRAVED_XUAN_SHELLS.get()));
					entityToSpawn.setPickUpDelay(0);
					entityToSpawn.setUnlimitedLifetime();
					_level.addFreshEntity(entityToSpawn);
				}
			}
			if (world instanceof Level _level) {
				if (!_level.isClientSide()) {
					_level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("mountains_poem:carved_shells")), SoundSource.NEUTRAL, 1, 1);
				} else {
					_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("mountains_poem:carved_shells")), SoundSource.NEUTRAL, 1, 1, false);
				}
			}
			if ((entity instanceof Player _plr ? _plr.getAbilities().instabuild : false) == false) {
				{
					ItemStack _ist = (sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY);
					if (_ist.hurt(1, RandomSource.create(), null)) {
						_ist.shrink(1);
						_ist.setDamageValue(0);
					}
				}
			}
		}
		if ((sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).is(ItemTags.create(new ResourceLocation("mountains_poem:jade")))
				&& (sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getCount() >= 32) {
			if ((entity instanceof SouthMountainGodEntity animatable ? animatable.getTexture() : "null").equals("south_god_1b")) {
				(sourceentity instanceof LivingEntity _livEnt ? _livEnt.getOffhandItem() : ItemStack.EMPTY).shrink(Mth.nextInt(RandomSource.create(), 16, 32));
				if (Math.random() < 0.3) {
					world.getLevelData().setRaining((world.getLevelData().isRaining() == false));
				} else {
					if (world instanceof ServerLevel _level)
						_level.sendParticles((SimpleParticleType) (MountainsPoemModParticleTypes.SACRIFICE_R.get()), x, y, z, 8, 3, 3, 3, 1);
				}
			}
			if ((entity instanceof SouthMountainGodEntity animatable ? animatable.getTexture() : "null").equals("south_god_1d")) {
				(sourceentity instanceof LivingEntity _livEnt ? _livEnt.getOffhandItem() : ItemStack.EMPTY).shrink(Mth.nextInt(RandomSource.create(), 16, 32));
				if (Math.random() < 0.3) {
					if (!world.isClientSide() && world.getServer() != null) {
						BlockPos _bpLootTblWorld = BlockPos.containing(x, y, z);
						for (ItemStack itemstackiterator : world.getServer().getLootData().getLootTable(new ResourceLocation("mountains_poem:gameplay/seeds"))
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
					if (world instanceof ServerLevel _level)
						_level.sendParticles((SimpleParticleType) (MountainsPoemModParticleTypes.SACRIFICE_R.get()), x, y, z, 8, 3, 3, 3, 1);
				}
			}
			if ((entity instanceof SouthMountainGodEntity animatable ? animatable.getTexture() : "null").equals("south_god_1e")) {
				(sourceentity instanceof LivingEntity _livEnt ? _livEnt.getOffhandItem() : ItemStack.EMPTY).shrink(Mth.nextInt(RandomSource.create(), 16, 32));
				if (Math.random() < 0.3) {
					if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
						_entity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_BOOST, 3000, 1));
					if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
						_entity.addEffect(new MobEffectInstance(MobEffects.HEALTH_BOOST, 1200, 1));
				} else {
					if (world instanceof ServerLevel _level)
						_level.sendParticles((SimpleParticleType) (MountainsPoemModParticleTypes.SACRIFICE_R.get()), x, y, z, 8, 3, 3, 3, 1);
				}
			}
			if ((entity instanceof SouthMountainGodEntity animatable ? animatable.getTexture() : "null").equals("south_god_1")) {
				if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
					_entity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_BOOST, 1200, 1));
				if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
					_entity.addEffect(new MobEffectInstance(MobEffects.LUCK, 1200, 1));
			}
			if ((entity instanceof SouthMountainGodEntity animatable ? animatable.getTexture() : "null").equals("south_god_1c")) {
				if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
					_entity.addEffect(new MobEffectInstance(MountainsPoemModMobEffects.LUSH.get(), 3000, 1));
			}
			if (world instanceof Level _level) {
				if (!_level.isClientSide()) {
					_level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("mountains_poem:carved_shells")), SoundSource.NEUTRAL, 1, 1);
				} else {
					_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("mountains_poem:carved_shells")), SoundSource.NEUTRAL, 1, 1, false);
				}
			}
			if (world instanceof ServerLevel _level)
				_level.sendParticles((SimpleParticleType) (MountainsPoemModParticleTypes.XIANGYUN.get()), x, y, z, 8, 2, 2, 2, 1);
			if (entity instanceof ServerPlayer _player) {
				Advancement _adv = _player.server.getAdvancements().getAdvancement(new ResourceLocation("mountains_poem:offer_some_treasures_to_the_mountain_god"));
				AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
				if (!_ap.isDone()) {
					for (String criteria : _ap.getRemainingCriteria())
						_player.getAdvancements().award(_adv, criteria);
				}
			}
			if (Math.random() < 0.1) {
				if (!entity.level().isClientSide())
					entity.discard();
				if (world instanceof ServerLevel _level) {
					LightningBolt entityToSpawn = EntityType.LIGHTNING_BOLT.create(_level);
					entityToSpawn.moveTo(Vec3.atBottomCenterOf(BlockPos.containing(x, y, z)));;
					_level.addFreshEntity(entityToSpawn);
				}
			}
		}
	}
}
