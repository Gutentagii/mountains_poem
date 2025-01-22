
package net.mcreator.mountainspoem.block;

import net.mcreator.mountainspoem.procedures.SanguineSandShiTiZaiFangKuaiShangXingZouShiProcedure;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import org.jetbrains.annotations.NotNull;

public class SanguineSandBlock extends Block {
	public SanguineSandBlock() {
		super(BlockBehaviour.Properties.of().instrument(NoteBlockInstrument.SNARE).sound(SoundType.SAND).strength(1f, 10f));
	}

	@Override
	public int getLightBlock(@NotNull BlockState state, @NotNull BlockGetter worldIn, @NotNull BlockPos pos) {
		return 15;
	}

	@Override
	public void attack(@NotNull BlockState blockstate, @NotNull Level world, @NotNull BlockPos pos, @NotNull Player entity) {
		super.attack(blockstate, world, pos, entity);
		SanguineSandShiTiZaiFangKuaiShangXingZouShiProcedure.execute(pos.getX(), pos.getY(), pos.getZ(), entity);
	}

	@Override
	public void entityInside(@NotNull BlockState blockstate, @NotNull Level world, @NotNull BlockPos pos, @NotNull Entity entity) {
		super.entityInside(blockstate, world, pos, entity);
		SanguineSandShiTiZaiFangKuaiShangXingZouShiProcedure.execute(pos.getX(), pos.getY(), pos.getZ(), entity);
	}

	@Override
	public void stepOn(@NotNull Level world, @NotNull BlockPos pos, @NotNull BlockState blockstate, @NotNull Entity entity) {
		super.stepOn(world, pos, blockstate, entity);
		SanguineSandShiTiZaiFangKuaiShangXingZouShiProcedure.execute(pos.getX(), pos.getY(), pos.getZ(), entity);
	}
}
