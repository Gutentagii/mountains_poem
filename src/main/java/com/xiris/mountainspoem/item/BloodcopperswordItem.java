
package com.xiris.mountainspoem.item;

import com.xiris.mountainspoem.init.MountainsPoemModItems;
import com.xiris.mountainspoem.init.MountainsPoemModParticleTypes;
import net.minecraft.commands.arguments.EntityAnchorArgument;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.monster.*;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;

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

			public Ingredient getRepairIngredient() {
				return Ingredient.of(new ItemStack(MountainsPoemModItems.BLOODCOPPERPLATE.get()));
			}
		}, 3, -3f, new Item.Properties().fireResistant());
	}

    private int ShakeTime = 0;

    private LivingEntity shakeT;

    @Override
    public boolean hurtEnemy(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        if (!target.level().isClientSide() && attacker instanceof Player player) {
            Level world = target.level();
            RandomSource random = world.random;

            shakeT = target;
            if (world.isClientSide) {
                ShakeTime = Mth.nextInt(random, 30, 40);
            }

            for (int i = 0; i < 4; i++) {
                double x = target.getX() + (random.nextDouble() - 0.5) * 2.5D;
                double y = target.getY() + random.nextDouble() * 2.2D;
                double z = target.getZ() + (random.nextDouble() - 0.5) * 2.5D;
                world.addParticle(MountainsPoemModParticleTypes.SACRIFICE_H.get(), x, y, z, 0, 0.1, 0);
            }

            if (target instanceof Zombie || target instanceof Skeleton || target instanceof WitherSkeleton
                    || target instanceof ZombifiedPiglin || target instanceof Phantom) {
                target.setSecondsOnFire(15);
            }

            if (target instanceof Player targetPlayer) {
                targetPlayer.addEffect(new MobEffectInstance(MobEffects.WEAKNESS, 15 * 20, 0, false, true));
            }
        }

        return super.hurtEnemy(stack, target, attacker);
    }

    @Override
    public void inventoryTick(ItemStack stack, Level world, Entity entity, int slot, boolean selected) {
        super.inventoryTick(stack, world, entity, slot, selected);

        if (ShakeTime > 0 && world.isClientSide() && entity instanceof Player player && shakeT != null) {
            RandomSource random = RandomSource.create();

            for (Player p : world.getEntitiesOfClass(Player.class, shakeT.getBoundingBox().inflate(10.0D))) {
                Vec3 eye = p.getEyePosition(1.0F);
                Vec3 look = p.getLookAngle();

                double ox = Mth.nextDouble(random, -0.4, 0.4);
                double oy = Mth.nextDouble(random, -0.4, 0.4);
                double oz = Mth.nextDouble(random, -0.4, 0.4);

                Vec3 targetPos = eye.add(look.scale(5.0D)).add(ox, oy, oz);
                p.lookAt(EntityAnchorArgument.Anchor.EYES, targetPos);
            }
            ShakeTime--;
        }
    }
}
