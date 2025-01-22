
package net.mcreator.mountainspoem.item;

import net.mcreator.mountainspoem.procedures.LeiTeethSwordShiTiBeiGongJuJiZhongShiProcedure;
import net.mcreator.mountainspoem.init.MountainsPoemModItems;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.crafting.Ingredient;
import org.jetbrains.annotations.NotNull;

public class LeiTeethSwordItem extends SwordItem {
	public LeiTeethSwordItem() {
		super(new Tier() {
			public int getUses() {
				return 64;
			}

			public float getSpeed() {
				return 4f;
			}

			public float getAttackDamageBonus() {
				return 5f;
			}

			public int getLevel() {
				return 1;
			}

			public int getEnchantmentValue() {
				return 2;
			}

			public @NotNull Ingredient getRepairIngredient() {
				return Ingredient.of(new ItemStack(MountainsPoemModItems.LEI_TEETH.get()));
			}
		}, 3, -2.5f, new Item.Properties());
	}

	@Override
	public boolean hurtEnemy(@NotNull ItemStack itemstack, @NotNull LivingEntity entity, @NotNull LivingEntity sourceentity) {
		boolean retval = super.hurtEnemy(itemstack, entity, sourceentity);
		LeiTeethSwordShiTiBeiGongJuJiZhongShiProcedure.execute(entity);
		return retval;
	}
}
