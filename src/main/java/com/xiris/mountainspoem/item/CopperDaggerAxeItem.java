
package com.xiris.mountainspoem.item;

import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.LevelAccessor;

public class CopperDaggerAxeItem extends SwordItem {
	public CopperDaggerAxeItem() {
		super(new Tier() {
			public int getUses() {
				return 460;
			}

			public float getSpeed() {
				return 4f;
			}

			public float getAttackDamageBonus() {
				return 4f;
			}

			public int getLevel() {
				return 1;
			}

			public int getEnchantmentValue() {
				return 16;
			}

			public Ingredient getRepairIngredient() {
				return Ingredient.of(ItemTags.create(ResourceLocation.fromNamespaceAndPath("forge", "ingots/copper")));
			}
		}, 3, -3.2f, new Item.Properties());
	}

	@Override
	public boolean hurtEnemy(ItemStack itemstack, LivingEntity entity, LivingEntity sourceentity) {
		boolean retval = super.hurtEnemy(itemstack, entity, sourceentity);
        LevelAccessor world = entity.level();
        if ((Entity) entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
            if (Math.random() < 0.4) {
                if (entity.getType().is(TagKey.create(Registries.ENTITY_TYPE, ResourceLocation.fromNamespaceAndPath("minecraft", "undead"))))
                    _entity.addEffect(new MobEffectInstance(MobEffects.HEAL, Mth.nextInt(RandomSource.create(), 1, 8), 0));
                else
                    _entity.addEffect(new MobEffectInstance(MobEffects.HARM, Mth.nextInt(RandomSource.create(), 1, 8), 0));
            }
        if (Math.random() < 0.3) {
            ((Entity) entity).hurt(new DamageSource(world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(DamageTypes.PLAYER_ATTACK)), Mth.nextInt(RandomSource.create(), 2, 5));
            if (world instanceof ServerLevel _level)
                _level.sendParticles(ParticleTypes.CRIT, entity.getX(), entity.getY(), entity.getZ(), 8, 1, 1, 1, 1);
        }
        return retval;
	}
}
