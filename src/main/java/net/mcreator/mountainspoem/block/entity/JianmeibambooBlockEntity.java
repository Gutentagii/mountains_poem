package net.mcreator.mountainspoem.block.entity;

import net.mcreator.mountainspoem.init.MountainsPoemModBlockEntities;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.protocol.game.ClientboundBlockEntityDataPacket;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.NotNull;

public class JianmeibambooBlockEntity extends BlockEntity {
	public JianmeibambooBlockEntity(BlockPos pos, BlockState state) {
		super(MountainsPoemModBlockEntities.JIANMEIBAMBOO.get(), pos, state);
	}

	@Override
	public ClientboundBlockEntityDataPacket getUpdatePacket() {
		return ClientboundBlockEntityDataPacket.create(this);
	}

	@Override
	public @NotNull CompoundTag getUpdateTag() {
		return this.saveWithFullMetadata();
	}
}
