
package com.xiris.mountainspoem.item;

import com.xiris.mountainspoem.init.MountainsPoemModItems;
import com.xiris.mountainspoem.init.MountainsPoemModMobEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.crafting.Ingredient;

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

			public Ingredient getRepairIngredient() {
				return Ingredient.of(new ItemStack(MountainsPoemModItems.LEI_TEETH.get()));
			}
		}, 3, -2.5f, new Item.Properties());
	}

	@Override
	public boolean hurtEnemy(ItemStack itemstack, LivingEntity entity, LivingEntity sourceentity) {
		boolean retval = super.hurtEnemy(itemstack, entity, sourceentity);
        if (Math.random() < 0.7)
            if ((Entity) entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
                _entity.addEffect(new MobEffectInstance(MountainsPoemModMobEffects.PESTILENCE.get(), 300, 0));
        return retval;
	}
}
