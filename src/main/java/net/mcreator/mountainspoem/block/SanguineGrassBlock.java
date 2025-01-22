
package net.mcreator.mountainspoem.block;

import net.mcreator.mountainspoem.procedures.ScarletThornsShengWuWanJiaYuZhiWuXiangZhuangShiProcedure;
import net.mcreator.mountainspoem.init.MountainsPoemModBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.FlowerBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.MapColor;
import net.minecraftforge.common.PlantType;
import org.jetbrains.annotations.NotNull;

public class SanguineGrassBlock extends FlowerBlock {
	public SanguineGrassBlock() {
		super(() -> MobEffects.DARKNESS, 100, BlockBehaviour.Properties.of().mapColor(MapColor.PLANT).sound(SoundType.GRASS).strength(1f, 1f).noCollission().offsetType(BlockBehaviour.OffsetType.XZ).pushReaction(PushReaction.DESTROY));
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
	public boolean mayPlaceOn(BlockState groundState, @NotNull BlockGetter worldIn, @NotNull BlockPos pos) {
		return groundState.is(MountainsPoemModBlocks.SANGUINE_SAND.get()) || groundState.is(MountainsPoemModBlocks.UNDER_GRASS_BLOCK.get()) || groundState.is(MountainsPoemModBlocks.UNDER_DIRT.get()) || groundState.is(Blocks.NETHERRACK)
				|| groundState.is(Blocks.CRIMSON_NYLIUM) || groundState.is(Blocks.WARPED_NYLIUM) || groundState.is(MountainsPoemModBlocks.SANGUINE_SOIL.get());
	}

	@Override
	public boolean canSurvive(@NotNull BlockState blockstate, LevelReader worldIn, BlockPos pos) {
		BlockPos blockpos = pos.below();
		BlockState groundState = worldIn.getBlockState(blockpos);
		return this.mayPlaceOn(groundState, worldIn, blockpos);
	}

	@Override
	public PlantType getPlantType(BlockGetter world, BlockPos pos) {
		return PlantType.NETHER;
	}

	@Override
	public void entityInside(@NotNull BlockState blockstate, @NotNull Level world, @NotNull BlockPos pos, @NotNull Entity entity) {
		super.entityInside(blockstate, world, pos, entity);
		ScarletThornsShengWuWanJiaYuZhiWuXiangZhuangShiProcedure.execute(world, entity);
	}

	@Override
	public void stepOn(@NotNull Level world, @NotNull BlockPos pos, @NotNull BlockState blockstate, @NotNull Entity entity) {
		super.stepOn(world, pos, blockstate, entity);
		ScarletThornsShengWuWanJiaYuZhiWuXiangZhuangShiProcedure.execute(world, entity);
	}
}
