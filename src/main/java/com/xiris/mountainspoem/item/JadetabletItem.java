
package com.xiris.mountainspoem.item;

import com.xiris.mountainspoem.MountainsPoemMod;
import com.xiris.mountainspoem.init.MountainsPoemModItems;
import com.xiris.mountainspoem.init.MountainsPoemModMobEffects;
import net.minecraft.advancements.Advancement;
import net.minecraft.advancements.AdvancementProgress;
import net.minecraft.client.Minecraft;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.tags.ItemTags;
import net.minecraft.util.RandomSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;

public class JadetabletItem extends Item {
    public JadetabletItem() {
        super(new Item.Properties()
                .durability(20)
                .rarity(Rarity.UNCOMMON)
        );
    }

    public boolean onEntitySwing(ItemStack itemstack, Entity entity) {
        LevelAccessor world = entity.level();
        double x = entity.getX();
        double y = entity.getY();
        double z = entity.getZ();

        if (entity instanceof LivingEntity _livEnt) {
            ItemStack mainHand = _livEnt.getMainHandItem();
            if (mainHand.getItem() == MountainsPoemModItems.JADETABLET.get()) {
                if (_livEnt.getOffhandItem().getItem() == MountainsPoemModItems.LUSHU_LEATHER.get()) {
                    if (world.isClientSide())
                        Minecraft.getInstance().gameRenderer.displayItemActivation(_livEnt.getOffhandItem());
                    _livEnt.getOffhandItem().shrink(1);

                    if (world instanceof ServerLevel _level) {
                        EntityType.LIGHTNING_BOLT.spawn(_level, BlockPos.containing(x, y, z), MobSpawnType.TRIGGERED);
                    }

                    if (Math.random() < 0.2 && !entity.level().isClientSide()) {
                        ((LivingEntity) entity).addEffect(new MobEffectInstance(MountainsPoemModMobEffects.LUSHU_HEART.get(), 200, 0));
                    }

                    hurtItem(itemstack, _livEnt);
                }

                if (_livEnt.getOffhandItem().is(ItemTags.create(ResourceLocation.fromNamespaceAndPath(MountainsPoemMod.MOD_ID, "combat_xuan_shells")))) {
                    if (world.isClientSide())
                        Minecraft.getInstance().gameRenderer.displayItemActivation(_livEnt.getOffhandItem());
                    _livEnt.getOffhandItem().shrink(1);

                    if (world instanceof ServerLevel _level) {
                        EntityType.LIGHTNING_BOLT.spawn(_level, BlockPos.containing(x, y, z), MobSpawnType.TRIGGERED);
                    }

                    if (!entity.level().isClientSide()) {
                        ((LivingEntity) entity).addEffect(new MobEffectInstance(MobEffects.DAMAGE_BOOST, 6000, 0));
                        ((LivingEntity) entity).addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 6000, 0));
                        ((LivingEntity) entity).addEffect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 6000, 2));
                    }

                    hurtItem(itemstack, _livEnt);
                }
            }
        }
        if (entity instanceof LivingEntity) {
            return super.onEntitySwing(itemstack, (LivingEntity) entity);
        }
        return false;
    }


    private void hurtItem(ItemStack stack, LivingEntity entity) {
        if (stack.hurt(1, RandomSource.create(), entity instanceof ServerPlayer ? (ServerPlayer) entity : null)) {
            stack.shrink(1);
            stack.setDamageValue(0);
        }
    }

    @Override
    public void inventoryTick(ItemStack itemstack, Level world, Entity entity, int slot, boolean selected) {
        super.inventoryTick(itemstack, world, entity, slot, selected);
        if (selected) {
            if (itemstack.getMaxDamage() <= itemstack.getDamageValue())
                itemstack.shrink(1);
            grantAdvancement(entity);
        }
    }

    private void grantAdvancement(Entity entity) {
        if (entity instanceof ServerPlayer _player) {
            Advancement advancement = _player.server.getAdvancements().getAdvancement(ResourceLocation.fromNamespaceAndPath(MountainsPoemMod.MOD_ID, "lucky_tool"));
            if (advancement != null) {
                AdvancementProgress ap = _player.getAdvancements().getOrStartProgress(advancement);
                if (!ap.isDone()) {
                    for (String criteria : ap.getRemainingCriteria()) {
                        _player.getAdvancements().award(advancement, criteria);
                    }
                }
            }
        }
    }
}