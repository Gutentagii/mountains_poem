package net.mcreator.mountainspoem.procedures;

import net.mcreator.mountainspoem.init.MountainsPoemModBlocks;

public class BoyiMeatSauceYouJiFangKuaiShiProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, ItemStack itemstack) {
		if (entity == null)
			return;
		if (entity.isShiftKeyDown()) {
			if (world.getBlockState(BlockPos.containing(x, y, z)).getBlock() instanceof IPlantable _plant1 && _plant1.getPlantType(world, BlockPos.containing(x, y, z)) == PlantType.PLAINS) {
				{
					BlockPos _pos = BlockPos.containing(x, y, z);
					Block.dropResources(world.getBlockState(_pos), world, BlockPos.containing(x, y, z), null);
					world.destroyBlock(_pos, false);
				}
				world.setBlock(BlockPos.containing(x, y, z), MountainsPoemModBlocks.COPPER_DOU_BOYI_MEAT_SAUCE.get().defaultBlockState(), 3);
			} else {
				if (world.getBlockState(BlockPos.containing(x, y + 1, z)).getBlock() instanceof IPlantable _plant4 && _plant4.getPlantType(world, BlockPos.containing(x, y + 1, z)) == PlantType.PLAINS) {
					{
						BlockPos _pos = BlockPos.containing(x, y + 1, z);
						Block.dropResources(world.getBlockState(_pos), world, BlockPos.containing(x, y, z), null);
						world.destroyBlock(_pos, false);
					}
					world.setBlock(BlockPos.containing(x, y + 1, z), MountainsPoemModBlocks.COPPER_DOU_BOYI_MEAT_SAUCE.get().defaultBlockState(), 3);
				} else {
					world.setBlock(BlockPos.containing(x, y + 1, z), MountainsPoemModBlocks.COPPER_DOU_BOYI_MEAT_SAUCE.get().defaultBlockState(), 3);
				}
			}
			itemstack.shrink(1);
			if (entity instanceof LivingEntity _entity)
				_entity.swing(InteractionHand.MAIN_HAND, true);
		}
	}
}
