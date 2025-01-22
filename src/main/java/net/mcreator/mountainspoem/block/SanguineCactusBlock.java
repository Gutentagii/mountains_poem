
package net.mcreator.mountainspoem.block;

import net.minecraftforge.common.PlantType;
import net.minecraftforge.common.ForgeHooks;

import net.minecraft.world.phys.shapes.VoxelShape;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.level.storage.loot.LootParams;
import net.minecraft.world.level.material.PushReaction;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.SugarCaneBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.Entity;
import net.minecraft.util.RandomSource;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.network.chat.Component;
import net.minecraft.core.Direction;
import net.minecraft.core.BlockPos;

import net.mcreator.mountainspoem.procedures.ScarletThornsShengWuWanJiaYuZhiWuXiangZhuangShiProcedure;
import net.mcreator.mountainspoem.procedures.SanguineCactusDangPiLinFangKuaiGengXinShiProcedure;
import net.mcreator.mountainspoem.init.MountainsPoemModBlocks;

import java.util.List;
import java.util.Collections;

public class SanguineCactusBlock extends SugarCaneBlock {
	public SanguineCactusBlock() {
		super(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_RED).randomTicks().sound(SoundType.WOOD).strength(3f, 1f).noOcclusion().dynamicShape().offsetType(BlockBehaviour.OffsetType.NONE).pushReaction(PushReaction.DESTROY));
	}

	@Override
	public VoxelShape getShape(BlockState state, BlockGetter world, BlockPos pos, CollisionContext context) {
		Vec3 offset = state.getOffset(world, pos);
		return box(2, 0, 2, 14, 16, 14).move(offset.x, offset.y, offset.z);
	}

	@Override
	public void appendHoverText(ItemStack itemstack, BlockGetter world, List<Component> list, TooltipFlag flag) {
		super.appendHoverText(itemstack, world, list, flag);
	}

	@Override
	public int getFireSpreadSpeed(BlockState state, BlockGetter world, BlockPos pos, Direction face) {
		return 5;
	}

	@Override
	public List<ItemStack> getDrops(BlockState state, LootParams.Builder builder) {
		List<ItemStack> dropsOriginal = super.getDrops(state, builder);
		if (!dropsOriginal.isEmpty())
			return dropsOriginal;
		return Collections.singletonList(new ItemStack(this));
	}

	@Override
	public boolean canSurvive(BlockState blockstate, LevelReader worldIn, BlockPos pos) {
		BlockPos blockpos = pos.below();
		BlockState groundState = worldIn.getBlockState(blockpos);
		return groundState.is(this) || groundState.is(MountainsPoemModBlocks.SANGUINE_SAND.get()) || groundState.is(MountainsPoemModBlocks.UNDER_GRASS_BLOCK.get()) || groundState.is(MountainsPoemModBlocks.UNDER_DIRT.get())
				|| groundState.is(Blocks.NETHERRACK) || groundState.is(Blocks.CRIMSON_NYLIUM) || groundState.is(Blocks.WARPED_NYLIUM);
	}

	@Override
	public PlantType getPlantType(BlockGetter world, BlockPos pos) {
		return PlantType.NETHER;
	}

@Override
public void randomTick(BlockState blockstate, ServerLevel world, BlockPos blockpos, RandomSource random) {
    if (world.isEmptyBlock(blockpos.above())) {
        int i = 1;
        for (; world.getBlockState(blockpos.below(i)).is(this); ++i);
        if (i < 5) {
            int j = blockstate.getValue(AGE);
            if (ForgeHooks.onCropsGrowPre(world, blockpos, blockstate, true)) {
                if (random.nextInt((int)(25.0F / getGrowthSpeed(world, blockpos)) + 1) == 0) {
                    if (j == 6) {
                        world.setBlockAndUpdate(blockpos.above(), defaultBlockState());
                        world.setBlock(blockpos, blockstate.setValue(AGE, 0), 4);
                    } else {
                        world.setBlock(blockpos, blockstate.setValue(AGE, j + 1), 4);
                    }
                    ForgeHooks.onCropsGrowPost(world, blockpos, blockstate);
                }
            }
        }
    }
}

	@Override
	public void neighborChanged(BlockState blockstate, Level world, BlockPos pos, Block neighborBlock, BlockPos fromPos, boolean moving) {
		super.neighborChanged(blockstate, world, pos, neighborBlock, fromPos, moving);
		SanguineCactusDangPiLinFangKuaiGengXinShiProcedure.execute(world, pos.getX(), pos.getY(), pos.getZ());
	}

	@Override
	public void entityInside(BlockState blockstate, Level world, BlockPos pos, Entity entity) {
		super.entityInside(blockstate, world, pos, entity);
		ScarletThornsShengWuWanJiaYuZhiWuXiangZhuangShiProcedure.execute(world, entity);
	 }

    private float getGrowthSpeed(BlockGetter worldIn, BlockPos pos) {
        float growth = 1.0F;
        BlockPos blockpos = pos.below();
        BlockState state = worldIn.getBlockState(blockpos);
        if (state.is(MountainsPoemModBlocks.SANGUINE_SAND.get()) || state.is(Blocks.NETHERRACK)) {
            growth = 3.0F;
        }
        return growth;
    }
}