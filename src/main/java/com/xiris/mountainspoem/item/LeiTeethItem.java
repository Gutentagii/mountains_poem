
package com.xiris.mountainspoem.item;

import com.google.common.collect.ImmutableMultimap;
import com.google.common.collect.Multimap;
import com.xiris.mountainspoem.MountainsPoemMod;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.level.Level;

public class LeiTeethItem extends Item {
	public LeiTeethItem() {
		super(new Item.Properties().stacksTo(64).rarity(Rarity.COMMON));
	}

	@Override
	public Multimap<Attribute, AttributeModifier> getDefaultAttributeModifiers(EquipmentSlot equipmentSlot) {
		if (equipmentSlot == EquipmentSlot.MAINHAND) {
			ImmutableMultimap.Builder<Attribute, AttributeModifier> builder = ImmutableMultimap.builder();
			builder.putAll(super.getDefaultAttributeModifiers(equipmentSlot));
			builder.put(Attributes.ATTACK_DAMAGE, new AttributeModifier(BASE_ATTACK_DAMAGE_UUID, "Item modifier", 2d, AttributeModifier.Operation.ADDITION));
			builder.put(Attributes.ATTACK_SPEED, new AttributeModifier(BASE_ATTACK_SPEED_UUID, "Item modifier", -2.4, AttributeModifier.Operation.ADDITION));
			return builder.build();
		}
		return super.getDefaultAttributeModifiers(equipmentSlot);
	}

	@Override
	public void inventoryTick(ItemStack itemstack, Level world, Entity entity, int slot, boolean selected) {
		super.inventoryTick(itemstack, world, entity, slot, selected);
        if (entity instanceof ServerPlayer _serverPlayer) {
            _serverPlayer.awardRecipesByKey(new ResourceLocation[]{ResourceLocation.fromNamespaceAndPath(MountainsPoemMod.MOD_ID,"lei_arrows_crafting")});
            _serverPlayer.awardRecipesByKey(new ResourceLocation[]{ResourceLocation.fromNamespaceAndPath(MountainsPoemMod.MOD_ID,"bone_2")});
            _serverPlayer.awardRecipesByKey(new ResourceLocation[]{ResourceLocation.fromNamespaceAndPath(MountainsPoemMod.MOD_ID,"teeth_graver_item")});
        }
    }
}
