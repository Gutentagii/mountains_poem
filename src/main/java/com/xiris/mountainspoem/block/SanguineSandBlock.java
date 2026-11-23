package com.xiris.mountainspoem.block;

import com.xiris.mountainspoem.MountainsPoemMod;
import com.xiris.mountainspoem.init.MountainsPoemModEnchantments;
import com.xiris.mountainspoem.init.MountainsPoemModItems;
import com.xiris.mountainspoem.init.MountainsPoemModMobEffects;
import net.minecraft.core.BlockPos;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;

public class SanguineSandBlock extends Block {
    public SanguineSandBlock() {
        super(BlockBehaviour.Properties.of().instrument(NoteBlockInstrument.SNARE).sound(SoundType.SAND).strength(1f, 10f));
    }

    @Override
    public int getLightBlock(BlockState state, BlockGetter worldIn, BlockPos pos) {
        return 15;
    }

    @Override
    public void attack(BlockState blockstate, Level world, BlockPos pos, Player entity) {
        super.attack(blockstate, world, pos, entity);
        if (!entity.level().isClientSide()) {
            entity.addEffect(new MobEffectInstance(MountainsPoemModMobEffects.DERMATOSIS.get(), 2, 1));
            entity.addEffect(new MobEffectInstance(MountainsPoemModMobEffects.DEHYDRATION.get(), 2, 1));
        }
    }

    @Override
    public void entityInside(BlockState blockstate, Level world, BlockPos pos, Entity entity) {
        super.entityInside(blockstate, world, pos, entity);
        if (entity instanceof LivingEntity living)
            if (living.getItemBySlot(EquipmentSlot.HEAD).getItem() == MountainsPoemModItems.XUAN_HELMET_HELMET.get()
                    || living.getItemBySlot(EquipmentSlot.HEAD).is(ItemTags.create(ResourceLocation.fromNamespaceAndPath(MountainsPoemMod.MOD_ID, "under_iron_armors")))
                    || living.getItemBySlot(EquipmentSlot.LEGS).is(ItemTags.create(ResourceLocation.fromNamespaceAndPath(MountainsPoemMod.MOD_ID, "under_iron_armors")))
                    || living.getItemBySlot(EquipmentSlot.CHEST).is(ItemTags.create(ResourceLocation.fromNamespaceAndPath(MountainsPoemMod.MOD_ID, "under_iron_armors")))
                    || living.getItemBySlot(EquipmentSlot.FEET).is(ItemTags.create(ResourceLocation.fromNamespaceAndPath(MountainsPoemMod.MOD_ID, "under_iron_armors")))
                    || EnchantmentHelper.getItemEnchantmentLevel(MountainsPoemModEnchantments.SOUL_STRENGTH.get(), living.getItemBySlot(EquipmentSlot.FEET)) != 0
                    || entity.getType().is(TagKey.create(Registries.ENTITY_TYPE, ResourceLocation.fromNamespaceAndPath(MountainsPoemMod.MOD_ID, "sanguine_sand_walkable")))) {
                if (entity instanceof Mob _entity)
                    _entity.getNavigation().moveTo(pos.getX(), pos.getY(), pos.getZ(), 3);
            } else if (!living.level().isClientSide()) {
                living.addEffect(new MobEffectInstance(MountainsPoemModMobEffects.DERMATOSIS.get(), 2, 1));
                living.addEffect(new MobEffectInstance(MountainsPoemModMobEffects.DEHYDRATION.get(), 2, 1));
            }
    }

    @Override
    public void stepOn(Level world, BlockPos pos, BlockState blockstate, Entity entity) {
        super.stepOn(world, pos, blockstate, entity);
        if (entity instanceof LivingEntity living)
            if (living.getItemBySlot(EquipmentSlot.HEAD).getItem() == MountainsPoemModItems.XUAN_HELMET_HELMET.get()
                    || living.getItemBySlot(EquipmentSlot.HEAD).is(ItemTags.create(ResourceLocation.fromNamespaceAndPath(MountainsPoemMod.MOD_ID, "under_iron_armors")))
                    || living.getItemBySlot(EquipmentSlot.LEGS).is(ItemTags.create(ResourceLocation.fromNamespaceAndPath(MountainsPoemMod.MOD_ID, "under_iron_armors")))
                    || living.getItemBySlot(EquipmentSlot.CHEST).is(ItemTags.create(ResourceLocation.fromNamespaceAndPath(MountainsPoemMod.MOD_ID, "under_iron_armors")))
                    || living.getItemBySlot(EquipmentSlot.FEET).is(ItemTags.create(ResourceLocation.fromNamespaceAndPath(MountainsPoemMod.MOD_ID, "under_iron_armors")))
                    || EnchantmentHelper.getItemEnchantmentLevel(MountainsPoemModEnchantments.SOUL_STRENGTH.get(), living.getItemBySlot(EquipmentSlot.FEET)) != 0
                    || entity.getType().is(TagKey.create(Registries.ENTITY_TYPE, ResourceLocation.fromNamespaceAndPath(MountainsPoemMod.MOD_ID, "sanguine_sand_walkable")))) {
                if (entity instanceof Mob _entity)
                    _entity.getNavigation().moveTo(pos.getX(), pos.getY(), pos.getZ(), 3);
            } else if (!living.level().isClientSide()) {
                living.addEffect(new MobEffectInstance(MountainsPoemModMobEffects.DERMATOSIS.get(), 2, 1));
                living.addEffect(new MobEffectInstance(MountainsPoemModMobEffects.DEHYDRATION.get(), 2, 1));
            }
    }
}
