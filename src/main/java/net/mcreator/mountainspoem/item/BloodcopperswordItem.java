
package net.mcreator.mountainspoem.item;

import net.mcreator.mountainspoem.init.MountainsPoemModItems;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.crafting.Ingredient;
import org.jetbrains.annotations.NotNull;

public class BloodcopperswordItem extends SwordItem {
	public BloodcopperswordItem() {
		super(new Tier() {
			public int getUses() {
				return 1200;
			}

			public float getSpeed() {
				return 4f;
			}

			public float getAttackDamageBonus() {
				return 8f;
			}

			public int getLevel() {
				return 1;
			}

			public int getEnchantmentValue() {
				return 16;
			}

			public @NotNull Ingredient getRepairIngredient() {
				return Ingredient.of(new ItemStack(MountainsPoemModItems.BLOODCOPPERPLATE.get()));
			}
		}, 3, -3f, new Item.Properties().fireResistant());
	}
}
