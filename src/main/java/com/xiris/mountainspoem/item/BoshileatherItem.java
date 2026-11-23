
package com.xiris.mountainspoem.item;

import com.xiris.mountainspoem.init.MountainsPoemModItems;
import com.xiris.mountainspoem.init.MountainsPoemModMobEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.level.Level;

public class BoshileatherItem extends Item {
	public BoshileatherItem() {
		super(new Item.Properties().stacksTo(64).rarity(Rarity.UNCOMMON));
	}

	@Override
	public void inventoryTick(ItemStack itemstack, Level world, Entity entity, int slot, boolean selected) {
		super.inventoryTick(itemstack, world, entity, slot, selected);
		if (selected) {
            if (entity instanceof LivingEntity _entity)
                _entity.removeEffect(MountainsPoemModMobEffects.LOST_SOULS.get());
        }
        if (entity instanceof LivingEntity living && (living.getMainHandItem().is(MountainsPoemModItems.BOYI_LEATHER.get()) || living.getOffhandItem().is(MountainsPoemModItems.BOYI_LEATHER.get())))
            if (!living.level().isClientSide())
                living.addEffect(new MobEffectInstance(MountainsPoemModMobEffects.BOYI_BLESSING.get(), 200, 2));
    }
}
