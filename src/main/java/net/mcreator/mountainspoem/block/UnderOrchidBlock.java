
package net.mcreator.mountainspoem.block;

import net.mcreator.mountainspoem.procedures.UnderOrchidShengWuWanJiaYuZhiWuXiangZhuangShiProcedure;
import net.mcreator.mountainspoem.init.MountainsPoemModBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.DoublePlantBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.DoubleBlockHalf;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.material.PushReaction;
import net.minecraftforge.common.PlantType;
import org.jetbrains.annotations.NotNull;

public class UnderOrchidBlock extends DoublePlantBlock {
	public UnderOrchidBlock() {
		super(BlockBehaviour.Properties.of().mapColor(MapColor.PLANT).sound(SoundType.GRASS).strength(1f, 1f).hasPostProcess((bs, br, bp) -> true).emissiveRendering((bs, br, bp) -> true).lightLevel(s -> 3).noCollission()
				.offsetType(BlockBehaviour.OffsetType.XZ).pushReaction(PushReaction.DESTROY));
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
	public boolean mayPlaceOn(BlockState groundState, @NotNull BlockGetter worldIn, @NotNull BlockPos pos) {
		return groundState.is(MountainsPoemModBlocks.SANGUINE_SAND.get()) || groundState.is(MountainsPoemModBlocks.UNDER_GRASS_BLOCK.get()) || groundState.is(MountainsPoemModBlocks.UNDER_DIRT.get()) || groundState.is(Blocks.NETHERRACK)
				|| groundState.is(Blocks.CRIMSON_NYLIUM) || groundState.is(Blocks.WARPED_NYLIUM) || groundState.is(MountainsPoemModBlocks.SANGUINE_SOIL.get());
	}

	@Override
	public boolean canSurvive(BlockState blockstate, LevelReader worldIn, BlockPos pos) {
		BlockPos blockpos = pos.below();
		BlockState groundState = worldIn.getBlockState(blockpos);
		if (blockstate.getValue(HALF) == DoubleBlockHalf.UPPER)
			return groundState.is(this) && groundState.getValue(HALF) == DoubleBlockHalf.LOWER;
		else
			return this.mayPlaceOn(groundState, worldIn, blockpos);
	}

	@Override
	public PlantType getPlantType(BlockGetter world, BlockPos pos) {
		return PlantType.NETHER;
	}

	@Override
	public void entityInside(@NotNull BlockState blockstate, @NotNull Level world, @NotNull BlockPos pos, @NotNull Entity entity) {
		super.entityInside(blockstate, world, pos, entity);
		UnderOrchidShengWuWanJiaYuZhiWuXiangZhuangShiProcedure.execute(entity);
	}

	@Override
	public boolean onDestroyedByPlayer(BlockState blockstate, Level world, BlockPos pos, Player entity, boolean willHarvest, FluidState fluid) {
		boolean retval = super.onDestroyedByPlayer(blockstate, world, pos, entity, willHarvest, fluid);
		UnderOrchidShengWuWanJiaYuZhiWuXiangZhuangShiProcedure.execute(entity);
		return retval;
	}

	@Override
	public void attack(@NotNull BlockState blockstate, @NotNull Level world, @NotNull BlockPos pos, @NotNull Player entity) {
		super.attack(blockstate, world, pos, entity);
		UnderOrchidShengWuWanJiaYuZhiWuXiangZhuangShiProcedure.execute(entity);
	}

	@Override
	public void setPlacedBy(@NotNull Level world, @NotNull BlockPos pos, @NotNull BlockState blockstate, @NotNull LivingEntity entity, ItemStack itemstack) {
		super.setPlacedBy(world, pos, blockstate, entity, itemstack);
		UnderOrchidShengWuWanJiaYuZhiWuXiangZhuangShiProcedure.execute(entity);
	}

	@Override
	public void stepOn(@NotNull Level world, @NotNull BlockPos pos, @NotNull BlockState blockstate, @NotNull Entity entity) {
		super.stepOn(world, pos, blockstate, entity);
		UnderOrchidShengWuWanJiaYuZhiWuXiangZhuangShiProcedure.execute(entity);
	}
}
