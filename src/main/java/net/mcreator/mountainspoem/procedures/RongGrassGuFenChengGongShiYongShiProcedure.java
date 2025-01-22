package net.mcreator.mountainspoem.procedures;

import net.mcreator.mountainspoem.init.MountainsPoemModBlocks;

import java.util.Map;

public class RongGrassGuFenChengGongShiYongShiProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		if (Math.random() < 0.2) {
			if ((world.getBlockState(BlockPos.containing(x, y - 1, z - 1))).is(BlockTags.create(new ResourceLocation("mountains_poem:rong_grass_replaceable")))) {
				{
					BlockPos _bp = BlockPos.containing(x, y - 1, z - 1);
					BlockState _bs = MountainsPoemModBlocks.DIRT_WITH_RONG_GRASS_TUBERS.get().defaultBlockState();
					BlockState _bso = world.getBlockState(_bp);
					for (Map.Entry<Property<?>, Comparable<?>> entry : _bso.getValues().entrySet()) {
						Property _property = _bs.getBlock().getStateDefinition().getProperty(entry.getKey().getName());
						if (_property != null && _bs.getValue(_property) != null)
							try {
								_bs = _bs.setValue(_property, (Comparable) entry.getValue());
							} catch (Exception e) {
							}
					}
					world.setBlock(_bp, _bs, 3);
				}
				if (Math.random() < 0.3) {
					if (world.isEmptyBlock(BlockPos.containing(x, y, z - 1))) {
						world.setBlock(BlockPos.containing(x, y, z - 1), MountainsPoemModBlocks.RONG_GRASS.get().defaultBlockState(), 3);
					}
				}
			}
		} else {
			if (Math.random() < 0.2) {
				if ((world.getBlockState(BlockPos.containing(x, y - 1, z + 1))).is(BlockTags.create(new ResourceLocation("mountains_poem:rong_grass_replaceable")))) {
					{
						BlockPos _bp = BlockPos.containing(x, y - 1, z + 1);
						BlockState _bs = MountainsPoemModBlocks.DIRT_WITH_RONG_GRASS_TUBERS.get().defaultBlockState();
						BlockState _bso = world.getBlockState(_bp);
						for (Map.Entry<Property<?>, Comparable<?>> entry : _bso.getValues().entrySet()) {
							Property _property = _bs.getBlock().getStateDefinition().getProperty(entry.getKey().getName());
							if (_property != null && _bs.getValue(_property) != null)
								try {
									_bs = _bs.setValue(_property, (Comparable) entry.getValue());
								} catch (Exception e) {
								}
						}
						world.setBlock(_bp, _bs, 3);
					}
					if (Math.random() < 0.3) {
						if (world.isEmptyBlock(BlockPos.containing(x, y, z + 1))) {
							world.setBlock(BlockPos.containing(x, y, z + 1), MountainsPoemModBlocks.RONG_GRASS.get().defaultBlockState(), 3);
						}
					}
				}
			} else {
				if (Math.random() < 0.2) {
					if ((world.getBlockState(BlockPos.containing(x + 1, y - 1, z))).is(BlockTags.create(new ResourceLocation("mountains_poem:rong_grass_replaceable")))) {
						{
							BlockPos _bp = BlockPos.containing(x + 1, y - 1, z);
							BlockState _bs = MountainsPoemModBlocks.DIRT_WITH_RONG_GRASS_TUBERS.get().defaultBlockState();
							BlockState _bso = world.getBlockState(_bp);
							for (Map.Entry<Property<?>, Comparable<?>> entry : _bso.getValues().entrySet()) {
								Property _property = _bs.getBlock().getStateDefinition().getProperty(entry.getKey().getName());
								if (_property != null && _bs.getValue(_property) != null)
									try {
										_bs = _bs.setValue(_property, (Comparable) entry.getValue());
									} catch (Exception e) {
									}
							}
							world.setBlock(_bp, _bs, 3);
						}
						if (Math.random() < 0.3) {
							if (world.isEmptyBlock(BlockPos.containing(x + 1, y, z))) {
								world.setBlock(BlockPos.containing(x + 1, y, z), MountainsPoemModBlocks.RONG_GRASS.get().defaultBlockState(), 3);
							}
						}
					}
				} else {
					if (Math.random() < 0.2) {
						if ((world.getBlockState(BlockPos.containing(x - 1, y - 1, z - 1))).is(BlockTags.create(new ResourceLocation("mountains_poem:rong_grass_replaceable")))) {
							{
								BlockPos _bp = BlockPos.containing(x - 1, y - 1, z - 1);
								BlockState _bs = MountainsPoemModBlocks.DIRT_WITH_RONG_GRASS_TUBERS.get().defaultBlockState();
								BlockState _bso = world.getBlockState(_bp);
								for (Map.Entry<Property<?>, Comparable<?>> entry : _bso.getValues().entrySet()) {
									Property _property = _bs.getBlock().getStateDefinition().getProperty(entry.getKey().getName());
									if (_property != null && _bs.getValue(_property) != null)
										try {
											_bs = _bs.setValue(_property, (Comparable) entry.getValue());
										} catch (Exception e) {
										}
								}
								world.setBlock(_bp, _bs, 3);
							}
							if (Math.random() < 0.3) {
								if (world.isEmptyBlock(BlockPos.containing(x - 1, y, z - 1))) {
									world.setBlock(BlockPos.containing(x - 1, y, z - 1), MountainsPoemModBlocks.RONG_GRASS.get().defaultBlockState(), 3);
								}
							}
						}
					} else {
						if (Math.random() < 0.2) {
							if ((world.getBlockState(BlockPos.containing(x - 1, y - 1, z + 1))).is(BlockTags.create(new ResourceLocation("mountains_poem:rong_grass_replaceable")))) {
								{
									BlockPos _bp = BlockPos.containing(x - 1, y - 1, z + 1);
									BlockState _bs = MountainsPoemModBlocks.DIRT_WITH_RONG_GRASS_TUBERS.get().defaultBlockState();
									BlockState _bso = world.getBlockState(_bp);
									for (Map.Entry<Property<?>, Comparable<?>> entry : _bso.getValues().entrySet()) {
										Property _property = _bs.getBlock().getStateDefinition().getProperty(entry.getKey().getName());
										if (_property != null && _bs.getValue(_property) != null)
											try {
												_bs = _bs.setValue(_property, (Comparable) entry.getValue());
											} catch (Exception e) {
											}
									}
									world.setBlock(_bp, _bs, 3);
								}
								if (Math.random() < 0.3) {
									if (world.isEmptyBlock(BlockPos.containing(x - 1, y, z + 1))) {
										world.setBlock(BlockPos.containing(x - 1, y, z + 1), MountainsPoemModBlocks.RONG_GRASS.get().defaultBlockState(), 3);
									}
								}
							}
						} else {
							if (Math.random() < 0.2) {
								if ((world.getBlockState(BlockPos.containing(x + 1, y - 1, z - 1))).is(BlockTags.create(new ResourceLocation("mountains_poem:rong_grass_replaceable")))) {
									{
										BlockPos _bp = BlockPos.containing(x + 1, y - 1, z - 1);
										BlockState _bs = MountainsPoemModBlocks.DIRT_WITH_RONG_GRASS_TUBERS.get().defaultBlockState();
										BlockState _bso = world.getBlockState(_bp);
										for (Map.Entry<Property<?>, Comparable<?>> entry : _bso.getValues().entrySet()) {
											Property _property = _bs.getBlock().getStateDefinition().getProperty(entry.getKey().getName());
											if (_property != null && _bs.getValue(_property) != null)
												try {
													_bs = _bs.setValue(_property, (Comparable) entry.getValue());
												} catch (Exception e) {
												}
										}
										world.setBlock(_bp, _bs, 3);
									}
									if (Math.random() < 0.3) {
										if (world.isEmptyBlock(BlockPos.containing(x + 1, y, z - 1))) {
											world.setBlock(BlockPos.containing(x + 1, y, z - 1), MountainsPoemModBlocks.RONG_GRASS.get().defaultBlockState(), 3);
										}
									}
								}
							} else {
								if (Math.random() < 0.2) {
									if ((world.getBlockState(BlockPos.containing(x + 1, y - 1, z + 1))).is(BlockTags.create(new ResourceLocation("mountains_poem:rong_grass_replaceable")))) {
										{
											BlockPos _bp = BlockPos.containing(x + 1, y - 1, z + 1);
											BlockState _bs = MountainsPoemModBlocks.DIRT_WITH_RONG_GRASS_TUBERS.get().defaultBlockState();
											BlockState _bso = world.getBlockState(_bp);
											for (Map.Entry<Property<?>, Comparable<?>> entry : _bso.getValues().entrySet()) {
												Property _property = _bs.getBlock().getStateDefinition().getProperty(entry.getKey().getName());
												if (_property != null && _bs.getValue(_property) != null)
													try {
														_bs = _bs.setValue(_property, (Comparable) entry.getValue());
													} catch (Exception e) {
													}
											}
											world.setBlock(_bp, _bs, 3);
										}
										if (Math.random() < 0.3) {
											if (world.isEmptyBlock(BlockPos.containing(x + 1, y, z + 1))) {
												world.setBlock(BlockPos.containing(x + 1, y, z + 1), MountainsPoemModBlocks.RONG_GRASS.get().defaultBlockState(), 3);
											}
										}
									}
								}
							}
						}
					}
				}
			}
		}
	}
}
