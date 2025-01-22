
package net.mcreator.mountainspoem.item;

import net.mcreator.mountainspoem.procedures.JufuHumerusGlalivesProcedure;
import net.mcreator.mountainspoem.procedures.JufuHumerusGlaiveShiTiHuiDongWuPinShiProcedure;
import net.mcreator.mountainspoem.procedures.JufuHumerusGlaiveGongJuChuXianZaiWuPinLanShiMeiKeFaShengProcedure;
import net.mcreator.mountainspoem.init.MountainsPoemModItems;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;

public class JufuHumerusGlaiveItem extends SwordItem {
	public JufuHumerusGlaiveItem() {
		super(new Tier() {
			public int getUses() {
				return 360;
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
				return 2;
			}

			public @NotNull Ingredient getRepairIngredient() {
				return Ingredient.of(new ItemStack(MountainsPoemModItems.JUFU_HUMERUS.get()));
			}
		}, 3, -3f, new Item.Properties());
	}

	@Override
	public boolean hurtEnemy(@NotNull ItemStack itemstack, @NotNull LivingEntity entity, @NotNull LivingEntity sourceentity) {
		boolean retval = super.hurtEnemy(itemstack, entity, sourceentity);
		JufuHumerusGlalivesProcedure.execute(entity.level(), entity.getX(), entity.getY(), entity.getZ(), entity);
		return retval;
	}

	@Override
	public boolean onEntitySwing(ItemStack itemstack, LivingEntity entity) {
		boolean retval = super.onEntitySwing(itemstack, entity);
		JufuHumerusGlaiveShiTiHuiDongWuPinShiProcedure.execute(entity.level(), entity.getX(), entity.getY(), entity.getZ(), entity, itemstack);
		return retval;
	}

	@Override
	public void inventoryTick(@NotNull ItemStack itemstack, @NotNull Level world, @NotNull Entity entity, int slot, boolean selected) {
		super.inventoryTick(itemstack, world, entity, slot, selected);
		JufuHumerusGlaiveGongJuChuXianZaiWuPinLanShiMeiKeFaShengProcedure.execute(entity);
	}
}
