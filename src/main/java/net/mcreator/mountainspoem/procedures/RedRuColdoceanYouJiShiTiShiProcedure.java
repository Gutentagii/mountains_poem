package net.mcreator.mountainspoem.procedures;

import net.mcreator.mountainspoem.init.MountainsPoemModItems;

public class RedRuColdoceanYouJiShiTiShiProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity sourceentity) {
		if (sourceentity == null)
			return;
		if ((sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == MountainsPoemModItems.WOODS_WORMS.get() && world.isEmptyBlock(BlockPos.containing(x, y, z)) == false) {
			if (sourceentity instanceof Player _player) {
				ItemStack _stktoremove = new ItemStack(MountainsPoemModItems.WOODS_WORMS.get());
				_player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), 1, _player.inventoryMenu.getCraftSlots());
			}
			if (Math.random() < 0.01) {
				world.levelEvent(2001, BlockPos.containing(x, y, z), Block.getId((world.getBlockState(BlockPos.containing(x, y, z)))));
			}
			if (!world.isClientSide() && world.getServer() != null) {
				BlockPos _bpLootTblWorld = BlockPos.containing(x, y, z);
				for (ItemStack itemstackiterator : world.getServer().getLootData().getLootTable(new ResourceLocation("mod:entities/chuishayufind"))
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
