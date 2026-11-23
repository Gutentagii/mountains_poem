
package com.xiris.mountainspoem.item;

import com.xiris.mountainspoem.MountainsPoemMod;
import com.xiris.mountainspoem.entity.BronzeDevourerEntity;
import com.xiris.mountainspoem.init.MountainsPoemModBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.tags.TagKey;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;

public class PeachwoodSwordItem extends SwordItem {
	public PeachwoodSwordItem() {
		super(new Tier() {
			public int getUses() {
				return 63;
			}

			public float getSpeed() {
				return 4f;
			}

			public float getAttackDamageBonus() {
				return 4f;
			}

			public int getLevel() {
				return 1;
			}

			public int getEnchantmentValue() {
				return 2;
			}

			public Ingredient getRepairIngredient() {
				return Ingredient.of(new ItemStack(MountainsPoemModBlocks.PEACH_BLOSSOM_PLANKS.get()));
			}
		}, 3, -2.2f, new Item.Properties());
	}

	@Override
	public boolean hurtEnemy(ItemStack itemstack, LivingEntity entity, LivingEntity sourceentity) {
		boolean retval = super.hurtEnemy(itemstack, entity, sourceentity);
		LevelAccessor world = entity.level();
		if (entity.getType().is(TagKey.create(Registries.ENTITY_TYPE, ResourceLocation.fromNamespaceAndPath(MountainsPoemMod.MOD_ID,"ghost"))))
			if ((Entity) entity instanceof LivingEntity _entity && !_entity.level().isClientSide()) {
				_entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 300, 1));
				_entity.addEffect(new MobEffectInstance(MobEffects.WEAKNESS, 300, 2));
			}
		if (entity instanceof BronzeDevourerEntity) {
			if (!entity.level().isClientSide()) entity.discard();
			world.setBlock(BlockPos.containing(entity.getX(), entity.getY(), entity.getZ()), MountainsPoemModBlocks.SPOOKY_BRONZE_DEVOURER_STATUE.get().defaultBlockState(), 3);
		}
		return retval;
	}

	@Override
	public void inventoryTick(ItemStack itemstack, Level world, Entity entity, int slot, boolean selected) {
		super.inventoryTick(itemstack, world, entity, slot, selected);
        if (entity instanceof ServerPlayer _serverPlayer)
            _serverPlayer.awardRecipesByKey(new ResourceLocation[]{ResourceLocation.fromNamespaceAndPath(MountainsPoemMod.MOD_ID,"peachwood_sword")});
    }
}
