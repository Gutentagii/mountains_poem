package net.mcreator.mountainspoem.procedures;

import net.mcreator.mountainspoem.init.MountainsPoemModParticleTypes;
import net.mcreator.mountainspoem.entity.SouthMountainGodEntity;

public class SouthMountainGodDangShiTiSiWangShiProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if (world instanceof ServerLevel _level)
			_level.addFreshEntity(new ExperienceOrb(_level, x, y, z, 150));
		if ((entity instanceof SouthMountainGodEntity animatable ? animatable.getTexture() : "null").equals("south_god_1")) {
			if (!world.isClientSide() && world.getServer() != null) {
				for (ItemStack itemstackiterator : world.getServer().getLootData().getLootTable(new ResourceLocation("mountains_poem:entities/first_sm_1"))
						.getRandomItems(new LootParams.Builder((ServerLevel) world).create(LootContextParamSets.EMPTY))) {
					if (world instanceof ServerLevel _level) {
						ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, itemstackiterator);
						entityToSpawn.setPickUpDelay(0);
						entityToSpawn.setUnlimitedLifetime();
						_level.addFreshEntity(entityToSpawn);
					}
				}
			}
			if (world instanceof ServerLevel _level)
				_level.sendParticles((SimpleParticleType) (MountainsPoemModParticleTypes.SACRIFICE_A.get()), x, y, z, Mth.nextInt(RandomSource.create(), 10, 18), 5, 5, 5, 1);
			if (world instanceof ServerLevel _level) {
				LightningBolt entityToSpawn = EntityType.LIGHTNING_BOLT.create(_level);
				entityToSpawn.moveTo(Vec3.atBottomCenterOf(BlockPos.containing(x, y, z)));
				entityToSpawn.setVisualOnly(true);
				_level.addFreshEntity(entityToSpawn);
			}
		}
		if ((entity instanceof SouthMountainGodEntity animatable ? animatable.getTexture() : "null").equals("south_god_1b")) {
			if (!world.isClientSide() && world.getServer() != null) {
				for (ItemStack itemstackiterator : world.getServer().getLootData().getLootTable(new ResourceLocation("mountains_poem:entities/first_sm_1b"))
						.getRandomItems(new LootParams.Builder((ServerLevel) world).create(LootContextParamSets.EMPTY))) {
					if (world instanceof ServerLevel _level) {
						ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, itemstackiterator);
						entityToSpawn.setPickUpDelay(0);
						entityToSpawn.setUnlimitedLifetime();
						_level.addFreshEntity(entityToSpawn);
					}
				}
			}
			if (world instanceof ServerLevel _level)
				_level.sendParticles((SimpleParticleType) (MountainsPoemModParticleTypes.SACRIFICE_A.get()), x, y, z, Mth.nextInt(RandomSource.create(), 10, 18), 5, 5, 5, 1);
			if (world instanceof ServerLevel _level) {
				LightningBolt entityToSpawn = EntityType.LIGHTNING_BOLT.create(_level);
				entityToSpawn.moveTo(Vec3.atBottomCenterOf(BlockPos.containing(x, y, z)));
				entityToSpawn.setVisualOnly(true);
				_level.addFreshEntity(entityToSpawn);
			}
		}
		if ((entity instanceof SouthMountainGodEntity animatable ? animatable.getTexture() : "null").equals("south_god_1c")) {
			if (!world.isClientSide() && world.getServer() != null) {
				for (ItemStack itemstackiterator : world.getServer().getLootData().getLootTable(new ResourceLocation("mountains_poem:entities/first_sm_1c"))
						.getRandomItems(new LootParams.Builder((ServerLevel) world).create(LootContextParamSets.EMPTY))) {
					if (world instanceof ServerLevel _level) {
						ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, itemstackiterator);
						entityToSpawn.setPickUpDelay(0);
						entityToSpawn.setUnlimitedLifetime();
						_level.addFreshEntity(entityToSpawn);
					}
				}
			}
			if (world instanceof ServerLevel _level)
				_level.sendParticles((SimpleParticleType) (MountainsPoemModParticleTypes.SACRIFICE_A.get()), x, y, z, Mth.nextInt(RandomSource.create(), 10, 18), 5, 5, 5, 1);
			if (world instanceof ServerLevel _level) {
				LightningBolt entityToSpawn = EntityType.LIGHTNING_BOLT.create(_level);
				entityToSpawn.moveTo(Vec3.atBottomCenterOf(BlockPos.containing(x, y, z)));
				entityToSpawn.setVisualOnly(true);
				_level.addFreshEntity(entityToSpawn);
			}
		}
		if ((entity instanceof SouthMountainGodEntity animatable ? animatable.getTexture() : "null").equals("south_god_1d")) {
			if (!world.isClientSide() && world.getServer() != null) {
				for (ItemStack itemstackiterator : world.getServer().getLootData().getLootTable(new ResourceLocation("mountains_poem:entities/first_sm_1d"))
						.getRandomItems(new LootParams.Builder((ServerLevel) world).create(LootContextParamSets.EMPTY))) {
					if (world instanceof ServerLevel _level) {
						ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, itemstackiterator);
						entityToSpawn.setPickUpDelay(0);
						entityToSpawn.setUnlimitedLifetime();
						_level.addFreshEntity(entityToSpawn);
					}
				}
			}
			if (world instanceof ServerLevel _level)
				_level.sendParticles((SimpleParticleType) (MountainsPoemModParticleTypes.SACRIFICE_A.get()), x, y, z, Mth.nextInt(RandomSource.create(), 10, 18), 5, 5, 5, 1);
			if (world instanceof ServerLevel _level) {
				LightningBolt entityToSpawn = EntityType.LIGHTNING_BOLT.create(_level);
				entityToSpawn.moveTo(Vec3.atBottomCenterOf(BlockPos.containing(x, y, z)));
				entityToSpawn.setVisualOnly(true);
				_level.addFreshEntity(entityToSpawn);
			}
		}
		if ((entity instanceof SouthMountainGodEntity animatable ? animatable.getTexture() : "null").equals("south_god_1e")) {
			if (!world.isClientSide() && world.getServer() != null) {
				for (ItemStack itemstackiterator : world.getServer().getLootData().getLootTable(new ResourceLocation("mountains_poem:entities/first_sm_1e"))
						.getRandomItems(new LootParams.Builder((ServerLevel) world).create(LootContextParamSets.EMPTY))) {
					if (world instanceof ServerLevel _level) {
						ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, itemstackiterator);
						entityToSpawn.setPickUpDelay(0);
						entityToSpawn.setUnlimitedLifetime();
						_level.addFreshEntity(entityToSpawn);
					}
				}
			}
			if (world instanceof ServerLevel _level)
				_level.sendParticles((SimpleParticleType) (MountainsPoemModParticleTypes.SACRIFICE_A.get()), x, y, z, Mth.nextInt(RandomSource.create(), 10, 18), 5, 5, 5, 1);
			if (world instanceof ServerLevel _level) {
				LightningBolt entityToSpawn = EntityType.LIGHTNING_BOLT.create(_level);
				entityToSpawn.moveTo(Vec3.atBottomCenterOf(BlockPos.containing(x, y, z)));
				entityToSpawn.setVisualOnly(true);
				_level.addFreshEntity(entityToSpawn);
			}
		}
	}
}
