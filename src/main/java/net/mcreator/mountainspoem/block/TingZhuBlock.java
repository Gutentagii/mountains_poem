
package net.mcreator.mountainspoem.block;

import net.mcreator.mountainspoem.procedures.TingZhuShengWuWanJiaYuZhiWuXiangZhuangShiProcedure;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.DoublePlantBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.material.PushReaction;
import net.minecraftforge.common.PlantType;
import org.jetbrains.annotations.NotNull;

public class TingZhuBlock extends DoublePlantBlock {
	public TingZhuBlock() {
		super(BlockBehaviour.Properties.of().mapColor(MapColor.PLANT).sound(SoundType.GRASS).instabreak().noCollission().offsetType(BlockBehaviour.OffsetType.XZ).pushReaction(PushReaction.DESTROY));
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
	public PlantType getPlantType(BlockGetter world, BlockPos pos) {
		return PlantType.PLAINS;
	}

	@Override
	public void entityInside(@NotNull BlockState blockstate, @NotNull Level world, @NotNull BlockPos pos, @NotNull Entity entity) {
		super.entityInside(blockstate, world, pos, entity);
		TingZhuShengWuWanJiaYuZhiWuXiangZhuangShiProcedure.execute(entity);
	}

	@Override
	public boolean onDestroyedByPlayer(BlockState blockstate, Level world, BlockPos pos, Player entity, boolean willHarvest, FluidState fluid) {
		boolean retval = super.onDestroyedByPlayer(blockstate, world, pos, entity, willHarvest, fluid);
		TingZhuShengWuWanJiaYuZhiWuXiangZhuangShiProcedure.execute(entity);
		return retval;
	}
}
