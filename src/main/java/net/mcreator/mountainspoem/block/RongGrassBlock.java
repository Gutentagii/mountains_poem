
package net.mcreator.mountainspoem.block;

import net.mcreator.mountainspoem.procedures.RongGrassZhiWuBeiWanJiaPoPiShiProcedure;
import net.mcreator.mountainspoem.procedures.RongGrassGuFenChengGongShiYongShiProcedure;

public class RongGrassBlock extends FlowerBlock implements BonemealableBlock {
	public RongGrassBlock() {
		super(() -> MobEffects.DAMAGE_BOOST, 100, BlockBehaviour.Properties.of().mapColor(MapColor.PLANT).sound(SoundType.GRASS).instabreak().noCollission().offsetType(BlockBehaviour.OffsetType.XZ).pushReaction(PushReaction.DESTROY));
	}

	@Override
	public int getEffectDuration() {
		return 100;
	}

	@Override
	public int getFlammability(BlockState state, BlockGetter world, BlockPos pos, Direction face) {
		return 100;
	}

	@Override
	public int getFireSpreadSpeed(BlockState state, BlockGetter world, BlockPos pos, Direction face) {
		return 60;
	}

	@Override
	public boolean onDestroyedByPlayer(BlockState blockstate, Level world, BlockPos pos, Player entity, boolean willHarvest, FluidState fluid) {
		boolean retval = super.onDestroyedByPlayer(blockstate, world, pos, entity, willHarvest, fluid);
		RongGrassZhiWuBeiWanJiaPoPiShiProcedure.execute(world, pos.getX(), pos.getY(), pos.getZ());
		return retval;
	}

	@Override
	public boolean isValidBonemealTarget(LevelReader worldIn, BlockPos pos, BlockState blockstate, boolean clientSide) {
		return true;
	}

	@Override
	public boolean isBonemealSuccess(Level world, RandomSource random, BlockPos pos, BlockState blockstate) {
		return true;
	}

	@Override
	public void performBonemeal(ServerLevel world, RandomSource random, BlockPos pos, BlockState blockstate) {
		RongGrassGuFenChengGongShiYongShiProcedure.execute(world, pos.getX(), pos.getY(), pos.getZ());
	}
}
