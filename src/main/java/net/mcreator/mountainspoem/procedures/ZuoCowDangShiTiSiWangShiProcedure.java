package net.mcreator.mountainspoem.procedures;

import net.mcreator.mountainspoem.entity.ZuoCowEntity;

public class ZuoCowDangShiTiSiWangShiProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if ((entity instanceof ZuoCowEntity animatable ? animatable.getTexture() : "null").equals("zuo_cow_2") || (entity instanceof ZuoCowEntity animatable ? animatable.getTexture() : "null").equals("zuo_cow_black_2")
				|| (entity instanceof ZuoCowEntity animatable ? animatable.getTexture() : "null").equals("zuo_cow_brown_2") || (entity instanceof ZuoCowEntity animatable ? animatable.getTexture() : "null").equals("zuo_cow_white_2")) {
			if (world instanceof ServerLevel _level) {
				ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, new ItemStack(Items.SADDLE));
				entityToSpawn.setPickUpDelay(1);
				entityToSpawn.setUnlimitedLifetime();
				_level.addFreshEntity(entityToSpawn);
			}
		}
		if (entity.isOnFire()) {
			if (!world.isClientSide() && world.getServer() != null) {
				BlockPos _bpLootTblWorld = BlockPos.containing(x, y, z);
				for (ItemStack itemstackiterator : world.getServer().getLootData().getLootTable(new ResourceLocation("mountains_poem:entities/zuo_2"))
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
				for (ItemStack itemstackiterator : world.getServer().getLootData().getLootTable(new ResourceLocation("mountains_poem:entities/zuo_1"))
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
