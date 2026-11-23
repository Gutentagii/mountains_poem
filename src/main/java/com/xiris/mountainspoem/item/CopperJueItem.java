
package com.xiris.mountainspoem.item;

import com.xiris.mountainspoem.init.MountainsPoemModItems;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;

public class CopperJueItem extends Item {
	public CopperJueItem() {
		super(new Item.Properties().stacksTo(64).rarity(Rarity.COMMON));
	}

	@Override
	public InteractionResultHolder<ItemStack> use(Level world, Player entity, InteractionHand hand) {
		InteractionResultHolder<ItemStack> ar = super.use(world, entity, hand);
        double x = entity.getX();
        double y = entity.getY();
        double z = entity.getZ();
        ItemStack itemstack = ar.getObject();
        if ((((LevelAccessor) world).getBlockState(BlockPos.containing(x, y, z))).is(BlockTags.create(ResourceLocation.fromNamespaceAndPath("forge", "water_container")))
                || (((LevelAccessor) world).getBlockState(BlockPos.containing(x, y, z))).is(BlockTags.create(ResourceLocation.fromNamespaceAndPath("minecraft", "water_block")))
                || (((LevelAccessor) world).getBlockState(BlockPos.containing(x, y + 1, z))).is(BlockTags.create(ResourceLocation.fromNamespaceAndPath("minecraft", "water_block")))) {
            itemstack.shrink(1);
            ((Player) entity).getInventory().placeItemBackInInventory(new ItemStack(MountainsPoemModItems.WATER_COPPER_JUE.get()));
            ((LivingEntity) entity).swing(InteractionHand.MAIN_HAND, true);
        }
        return ar;
	}

	@Override
	public InteractionResult useOn(UseOnContext context) {
		super.useOn(context);
        LevelAccessor world = context.getLevel();
        double x = context.getClickedPos().getX();
        double y = context.getClickedPos().getY();
        double z = context.getClickedPos().getZ();
        Player entity = context.getPlayer();
        ItemStack itemstack = context.getItemInHand();
        if ((world.getBlockState(BlockPos.containing(x, y, z))).is(BlockTags.create(ResourceLocation.fromNamespaceAndPath("forge", "water_container")))
                || (world.getBlockState(BlockPos.containing(x, y, z))).is(BlockTags.create(ResourceLocation.fromNamespaceAndPath("minecraft", "water_block")))
                || (world.getBlockState(BlockPos.containing(x, y + 1, z))).is(BlockTags.create(ResourceLocation.fromNamespaceAndPath("minecraft", "water_block")))) {
            itemstack.shrink(1);
Player _player = entity;
_player.getInventory().placeItemBackInInventory(new ItemStack(MountainsPoemModItems.WATER_COPPER_JUE.get()));
LivingEntity _entity = entity;
_entity.swing(InteractionHand.MAIN_HAND, true);
        }
        return InteractionResult.SUCCESS;
	}
}
