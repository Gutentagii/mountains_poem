
package net.mcreator.mountainspoem.item;

import net.mcreator.mountainspoem.init.MountainsPoemModItems;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.registries.ForgeRegistries;
import org.jetbrains.annotations.NotNull;

import java.util.Objects;

public abstract class XuanhelmetItem extends ArmorItem {
	public XuanhelmetItem(ArmorItem.Type type, Item.Properties properties) {
		super(new ArmorMaterial() {
			@Override
			public int getDurabilityForType(ArmorItem.@NotNull Type type) {
				return new int[]{13, 15, 16, 11}[type.getSlot().getIndex()] * 25;
			}

			@Override
			public int getDefenseForType(ArmorItem.@NotNull Type type) {
				return new int[]{2, 5, 6, 3}[type.getSlot().getIndex()];
			}

			@Override
			public int getEnchantmentValue() {
				return 20;
			}

			@Override
			public @NotNull SoundEvent getEquipSound() {
				return Objects.requireNonNull(ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("item.armor.equip_turtle")));
			}

			@Override
			public @NotNull Ingredient getRepairIngredient() {
				return Ingredient.of(new ItemStack(MountainsPoemModItems.XUAN_SCALE.get()));
			}

			@Override
			public @NotNull String getName() {
				return "xuanhelmet";
			}

			@Override
			public float getToughness() {
				return 1f;
			}

			@Override
			public float getKnockbackResistance() {
				return 0f;
			}
		}, type, properties);
	}

	public static class Helmet extends XuanhelmetItem {
		public Helmet() {
			super(ArmorItem.Type.HELMET, new Item.Properties());
		}

		@Override
		public String getArmorTexture(ItemStack stack, Entity entity, EquipmentSlot slot, String type) {
			return "mountains_poem:textures/entities/xuan_layer.png";
		}
	}
}
