package net.mcreator.mountainspoem.procedures;

import net.mcreator.mountainspoem.init.MountainsPoemModItems;
import net.minecraft.advancements.Advancement;
import net.minecraft.advancements.AdvancementProgress;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraftforge.items.ItemHandlerHelper;

public class PapermakingBoardYouJiFangKuaiShiProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if (((world.getBlockState(BlockPos.containing(x, y, z))).getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip1 ? (world.getBlockState(BlockPos.containing(x, y, z))).getValue(_getip1) : -1) == 1) {
			if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == MountainsPoemModItems.WOODEN_MESH.get()) {
				{
					int _value = 0;
					BlockPos _pos = BlockPos.containing(x, y, z);
					BlockState _bs = world.getBlockState(_pos);
					if (_bs.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _integerProp && _integerProp.getPossibleValues().contains(_value))
						world.setBlock(_pos, _bs.setValue(_integerProp, _value), 3);
				}
				if (entity instanceof Player _player) {
					ItemStack _setstack = new ItemStack(MountainsPoemModItems.WOODEN_MESH_WITH_PAPER_PULP.get()).copy();
					_setstack.setCount(1);
					ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
				}
				if (entity instanceof ServerPlayer _player) {
					Advancement _adv = _player.server.getAdvancements().getAdvancement(new ResourceLocation("mountains_poem:get_papermaking"));
                    AdvancementProgress _ap = null;
                    if (_adv != null) {
                        _ap = _player.getAdvancements().getOrStartProgress(_adv);
                    }
                    if (_ap != null && !_ap.isDone()) {
                        for (String criteria : _ap.getRemainingCriteria())
                            _player.getAdvancements().award(_adv, criteria);
                    }
                }
			}
			if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == MountainsPoemModItems.BAMBOO_MESH.get()) {
				{
					int _value = 0;
					BlockPos _pos = BlockPos.containing(x, y, z);
					BlockState _bs = world.getBlockState(_pos);
					if (_bs.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _integerProp && _integerProp.getPossibleValues().contains(_value))
						world.setBlock(_pos, _bs.setValue(_integerProp, _value), 3);
				}
				if (entity instanceof Player _player) {
					ItemStack _setstack = new ItemStack(MountainsPoemModItems.BAMBOO_MESH_WITH_PAPER_PULP.get()).copy();
					_setstack.setCount(1);
					ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
				}
				if (entity instanceof ServerPlayer _player) {
					Advancement _adv = _player.server.getAdvancements().getAdvancement(new ResourceLocation("mountains_poem:get_papermaking"));
                    AdvancementProgress _ap = null;
                    if (_adv != null) {
                        _ap = _player.getAdvancements().getOrStartProgress(_adv);
                    }
                    if (_ap != null && !_ap.isDone()) {
                        for (String criteria : _ap.getRemainingCriteria())
                            _player.getAdvancements().award(_adv, criteria);
                    }
                }
			}
		}
		if (((world.getBlockState(BlockPos.containing(x, y, z))).getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip13 ? (world.getBlockState(BlockPos.containing(x, y, z))).getValue(_getip13) : -1) == 0) {
			if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == MountainsPoemModItems.PAPER_PULP_BUCKET.get()) {
				if (entity instanceof ServerPlayer _player) {
					Advancement _adv = _player.server.getAdvancements().getAdvancement(new ResourceLocation("mountains_poem:get_papermaking"));
                    AdvancementProgress _ap = null;
                    if (_adv != null) {
                        _ap = _player.getAdvancements().getOrStartProgress(_adv);
                    }
                    if (_ap != null && !_ap.isDone()) {
                        for (String criteria : _ap.getRemainingCriteria())
                            _player.getAdvancements().award(_adv, criteria);
                    }
                }
			} else {
				if (entity instanceof Player _player && !_player.level().isClientSide())
					_player.displayClientMessage(Component.literal((Component.translatable("prompt.papermaking_board").getString())), true);
			}
		}
	}
}
