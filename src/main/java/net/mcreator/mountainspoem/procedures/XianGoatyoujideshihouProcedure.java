package net.mcreator.mountainspoem.procedures;

import net.mcreator.mountainspoem.entity.XianGoatEntity;

public class XianGoatyoujideshihouProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, Entity sourceentity) {
		if (entity == null || sourceentity == null)
			return;
		if ((sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == Blocks.MOSS_CARPET.asItem()) {
			if ((entity instanceof XianGoatEntity animatable ? animatable.getTexture() : "null").equals("xian_goat_1")) {
				if (entity instanceof XianGoatEntity animatable)
					animatable.setTexture("xian_goat_1_b");
				if (world instanceof Level _level) {
					if (!_level.isClientSide()) {
						_level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.grass.place")), SoundSource.NEUTRAL, 1, 1);
					} else {
						_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.grass.place")), SoundSource.NEUTRAL, 1, 1, false);
					}
				}
				if (sourceentity instanceof Player _player) {
					ItemStack _stktoremove = new ItemStack(Blocks.MOSS_CARPET);
					_player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), 1, _player.inventoryMenu.getCraftSlots());
				}
			}
			if ((entity instanceof XianGoatEntity animatable ? animatable.getTexture() : "null").equals("xian_goat_2")) {
				if (entity instanceof XianGoatEntity animatable)
					animatable.setTexture("xian_goat_2_b");
				if (world instanceof Level _level) {
					if (!_level.isClientSide()) {
						_level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.grass.place")), SoundSource.NEUTRAL, 1, 1);
					} else {
						_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.grass.place")), SoundSource.NEUTRAL, 1, 1, false);
					}
				}
				if (sourceentity instanceof Player _player) {
					ItemStack _stktoremove = new ItemStack(Blocks.MOSS_CARPET);
					_player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), 1, _player.inventoryMenu.getCraftSlots());
				}
			}
			if ((entity instanceof XianGoatEntity animatable ? animatable.getTexture() : "null").equals("xian_goat_3")) {
				if (entity instanceof XianGoatEntity animatable)
					animatable.setTexture("xian_goat_3_b");
				if (world instanceof Level _level) {
					if (!_level.isClientSide()) {
						_level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.grass.place")), SoundSource.NEUTRAL, 1, 1);
					} else {
						_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.grass.place")), SoundSource.NEUTRAL, 1, 1, false);
					}
				}
				if (sourceentity instanceof Player _player) {
					ItemStack _stktoremove = new ItemStack(Blocks.MOSS_CARPET);
					_player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), 1, _player.inventoryMenu.getCraftSlots());
				}
			}
			if ((entity instanceof XianGoatEntity animatable ? animatable.getTexture() : "null").equals("xian_goat_4")) {
				if (entity instanceof XianGoatEntity animatable)
					animatable.setTexture("xian_goat_4_b");
				if (world instanceof Level _level) {
					if (!_level.isClientSide()) {
						_level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.azalea_leaves.place")), SoundSource.NEUTRAL, 1, 1);
					} else {
						_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.azalea_leaves.place")), SoundSource.NEUTRAL, 1, 1, false);
					}
				}
				if (sourceentity instanceof Player _player) {
					ItemStack _stktoremove = new ItemStack(Blocks.MOSS_CARPET);
					_player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), 1, _player.inventoryMenu.getCraftSlots());
				}
			}
			if (sourceentity instanceof LivingEntity _entity)
				_entity.swing(InteractionHand.MAIN_HAND, true);
		}
		if ((sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == Items.SHEARS) {
			if ((entity instanceof XianGoatEntity animatable ? animatable.getTexture() : "null").equals("xian_goat_1_b")) {
				if (entity instanceof XianGoatEntity animatable)
					animatable.setTexture("xian_goat_1");
				if (world instanceof Level _level) {
					if (!_level.isClientSide()) {
						_level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.azalea_leaves.break")), SoundSource.NEUTRAL, 1, 1);
					} else {
						_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.azalea_leaves.break")), SoundSource.NEUTRAL, 1, 1, false);
					}
				}
				if (world instanceof ServerLevel _level) {
					ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, new ItemStack(Blocks.MOSS_CARPET));
					entityToSpawn.setPickUpDelay(1);
					entityToSpawn.setUnlimitedLifetime();
					_level.addFreshEntity(entityToSpawn);
				}
			}
			if ((entity instanceof XianGoatEntity animatable ? animatable.getTexture() : "null").equals("xian_goat_2_b")) {
				if (entity instanceof XianGoatEntity animatable)
					animatable.setTexture("xian_goat_2");
				if (world instanceof Level _level) {
					if (!_level.isClientSide()) {
						_level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.azalea_leaves.break")), SoundSource.NEUTRAL, 1, 1);
					} else {
						_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.azalea_leaves.break")), SoundSource.NEUTRAL, 1, 1, false);
					}
				}
				if (world instanceof ServerLevel _level) {
					ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, new ItemStack(Blocks.MOSS_CARPET));
					entityToSpawn.setPickUpDelay(1);
					entityToSpawn.setUnlimitedLifetime();
					_level.addFreshEntity(entityToSpawn);
				}
			}
			if ((entity instanceof XianGoatEntity animatable ? animatable.getTexture() : "null").equals("xian_goat_3_b")) {
				if (entity instanceof XianGoatEntity animatable)
					animatable.setTexture("xian_goat_3");
				if (world instanceof Level _level) {
					if (!_level.isClientSide()) {
						_level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.azalea_leaves.break")), SoundSource.NEUTRAL, 1, 1);
					} else {
						_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.azalea_leaves.break")), SoundSource.NEUTRAL, 1, 1, false);
					}
				}
				if (world instanceof ServerLevel _level) {
					ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, new ItemStack(Blocks.MOSS_CARPET));
					entityToSpawn.setPickUpDelay(1);
					entityToSpawn.setUnlimitedLifetime();
					_level.addFreshEntity(entityToSpawn);
				}
			}
			if ((entity instanceof XianGoatEntity animatable ? animatable.getTexture() : "null").equals("xian_goat_4_b")) {
				if (entity instanceof XianGoatEntity animatable)
					animatable.setTexture("xian_goat_4");
				if (world instanceof Level _level) {
					if (!_level.isClientSide()) {
						_level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.azalea_leaves.break")), SoundSource.NEUTRAL, 1, 1);
					} else {
						_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.azalea_leaves.break")), SoundSource.NEUTRAL, 1, 1, false);
					}
				}
				if (world instanceof ServerLevel _level) {
					ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, new ItemStack(Blocks.MOSS_CARPET));
					entityToSpawn.setPickUpDelay(1);
					entityToSpawn.setUnlimitedLifetime();
					_level.addFreshEntity(entityToSpawn);
				}
			}
			if (sourceentity instanceof LivingEntity _entity)
				_entity.swing(InteractionHand.MAIN_HAND, true);
		}
	}
}
