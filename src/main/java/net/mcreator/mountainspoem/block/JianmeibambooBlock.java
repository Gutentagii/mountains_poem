
package net.mcreator.mountainspoem.block;

import net.mcreator.mountainspoem.init.MountainsPoemModBlocks;
import net.mcreator.mountainspoem.block.entity.JianmeibambooBlockEntity;
import net.minecraft.client.renderer.BiomeColors;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.GrassColor;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.EntityBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.SugarCaneBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.material.PushReaction;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.common.ForgeHooks;
import net.minecraftforge.common.PlantType;
import org.jetbrains.annotations.NotNull;

public class JianmeibambooBlock extends SugarCaneBlock implements EntityBlock {
	public JianmeibambooBlock() {
		super(BlockBehaviour.Properties.of().mapColor(MapColor.PLANT).randomTicks().sound(SoundType.BAMBOO).instabreak().noOcclusion().dynamicShape().offsetType(BlockBehaviour.OffsetType.XZ).pushReaction(PushReaction.DESTROY));
	}

	@Override
	public @NotNull VoxelShape getShape(BlockState state, @NotNull BlockGetter world, @NotNull BlockPos pos, @NotNull CollisionContext context) {
		Vec3 offset = state.getOffset(world, pos);
		return box(6, 0, 6, 12, 16, 12).move(offset.x, offset.y, offset.z);
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
	public @NotNull PlantType getPlantType(@NotNull BlockGetter world, @NotNull BlockPos pos) {
		return PlantType.PLAINS;
	}

	@Override
	public void randomTick(@NotNull BlockState blockstate, ServerLevel world, BlockPos pos, RandomSource random) {
		if (world.isEmptyBlock(pos.above())) {
			int i = 1;
			for (; world.getBlockState(pos.below(i)).is(this); ++i);
			if (i < 14) {
				int j = blockstate.getValue(AGE);
				if (ForgeHooks.onCropsGrowPre(world, pos, blockstate, true)) {
					if (j == 15) {
						world.setBlockAndUpdate(pos.above(), defaultBlockState());
						world.setBlock(pos, blockstate.setValue(AGE, 0), 4);
					} else {
						world.setBlock(pos, blockstate.setValue(AGE, j + 1), 4);
					}
				}
			}
		}
	}

	@Override
	public BlockEntity newBlockEntity(@NotNull BlockPos pos, @NotNull BlockState state) {
		return new JianmeibambooBlockEntity(pos, state);
	}

	@Override
	public boolean triggerEvent(@NotNull BlockState state, @NotNull Level world, @NotNull BlockPos pos, int eventID, int eventParam) {
		super.triggerEvent(state, world, pos, eventID, eventParam);
		BlockEntity blockEntity = world.getBlockEntity(pos);
		return blockEntity != null && blockEntity.triggerEvent(eventID, eventParam);
	}

	@OnlyIn(Dist.CLIENT)
	public static void blockColorLoad(BlockEvent.RegisterColorHandlersEvent event) {
		event.getBlockColors().register((bs, world, pos, index) -> {
			return world != null && pos != null ? BiomeColors.getAverageGrassColor(world, pos) : GrassColor.get(0.5D, 1.0D);
		}, MountainsPoemModBlocks.JIANMEIBAMBOO.get());
	}

	@OnlyIn(Dist.CLIENT)
	public static void itemColorLoad(RegisterColorHandlersEvent.Item event) {
		event.getItemColors().register((stack, index) -> {
			return GrassColor.get(0.5D, 1.0D);
		}, MountainsPoemModBlocks.JIANMEIBAMBOO.get());
	}
}
