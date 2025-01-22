
package net.mcreator.mountainspoem.item;

import com.google.common.collect.Iterables;
import net.mcreator.mountainspoem.procedures.WhiteArmorXiongJiaShiJianMeiYouXiKeProcedure;
import net.mcreator.mountainspoem.init.MountainsPoemModItems;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;

public abstract class WhiteArmorItem extends ArmorItem {
	public WhiteArmorItem(ArmorItem.Type type, Item.Properties properties) {
		super(new ArmorMaterial() {
			@Override
			public int getDurabilityForType(ArmorItem.@NotNull Type type) {
				return new int[]{13, 15, 16, 11}[type.getSlot().getIndex()] * 15;
			}

			@Override
			public int getDefenseForType(ArmorItem.@NotNull Type type) {
				return new int[]{2, 6, 5, 2}[type.getSlot().getIndex()];
			}

			@Override
			public int getEnchantmentValue() {
				return 9;
			}

			@Override
			public @NotNull SoundEvent getEquipSound() {
				return SoundEvents.EMPTY;
			}

			@Override
			public @NotNull Ingredient getRepairIngredient() {
				return Ingredient.of(new ItemStack(MountainsPoemModItems.WHITE_FOX_FUR.get()));
			}

			@Override
			public @NotNull String getName() {
				return "white_fox_coat";
			}

			@Override
			public float getToughness() {
				return 0f;
			}

			@Override
			public float getKnockbackResistance() {
				return 0f;
			}
		}, type, properties);
	}

	public static class Chestplate extends WhiteArmorItem {
		public Chestplate() {
			super(ArmorItem.Type.CHESTPLATE, new Item.Properties());
		}

		@Override
		public String getArmorTexture(ItemStack stack, Entity entity, EquipmentSlot slot, String type) {
			return "mountains_poem:textures/models/armor/white_layer_1.png";
		}

		@Override
		public void inventoryTick(@NotNull ItemStack itemstack, @NotNull Level world, @NotNull Entity entity, int slot, boolean selected) {
			super.inventoryTick(itemstack, world, entity, slot, selected);
			if (entity instanceof Player player && Iterables.contains(player.getArmorSlots(), itemstack)) {
				WhiteArmorXiongJiaShiJianMeiYouXiKeProcedure.execute(entity);
			}
		}
	}
}
