package com.xiris.mountainspoem.item;

import com.xiris.mountainspoem.init.MountainsPoemModBlocks;
import com.xiris.mountainspoem.init.MountainsPoemModItems;
import com.xiris.mountainspoem.init.MountainsPoemModParticleTypes;
import net.minecraft.commands.arguments.EntityAnchorArgument;
import net.minecraft.core.BlockPos;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.monster.*;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.Vec3;

import java.util.List;

import static net.minecraft.world.level.block.WeatheringCopper.WeatherState.*;

public class BLOOD_COPPER_AXE extends AxeItem {
    public BLOOD_COPPER_AXE() {
        super(new Tier() {
            public int getUses() {
                return 3044;
            }

            public float getSpeed() {
                return 10f;
            }

            public float getAttackDamageBonus() {
                return 9f;
            }

            public int getLevel() {
                return 5;
            }

            public int getEnchantmentValue() {
                return 20;
            }

            public Ingredient getRepairIngredient() {
                return Ingredient.of();
            }
        }, 1, -3f, new Item.Properties());
    }

    private int ShakeTime = 0;

    private LivingEntity shakeT;

    @Override
    public void inventoryTick(ItemStack stack, Level world, Entity entity, int slot, boolean selected) {
        super.inventoryTick(stack, world, entity, slot, selected);

        if (ShakeTime > 0 && world.isClientSide() && entity instanceof Player player) {
            RandomSource random = RandomSource.create();

            for (Player ignored : world.getEntitiesOfClass(Player.class, shakeT.getBoundingBox().inflate(10))) {
                Vec3 eyePos = player.getEyePosition(1.0F);
                Vec3 lookVec = player.getLookAngle();

                double offsetX = Mth.nextDouble(random, -0.4, 0.4);
                double offsetY = Mth.nextDouble(random, -0.4, 0.4);
                double offsetZ = Mth.nextDouble(random, -0.4, 0.4);

                Vec3 targetPos = eyePos.add(lookVec.scale(5.0D)).add(offsetX, offsetY, offsetZ);
                player.lookAt(EntityAnchorArgument.Anchor.EYES, targetPos);
            }

            ShakeTime--;
        }
    }

    @Override
    public boolean hurtEnemy(ItemStack itemstack, LivingEntity target, LivingEntity attacker) {
        boolean retval = super.hurtEnemy(itemstack, target, attacker);

        if (retval && !target.level().isClientSide() && attacker instanceof Player player) {
            Level world = target.level();
            RandomSource random = RandomSource.create();

            if (world.isClientSide) {
                ShakeTime = Mth.nextInt(random, 30, 40);
            }

            for (int i = 0; i < 4; i++) {
                double x = target.getX() + (random.nextDouble() - 0.5) * 3.0D;
                double y = target.getY() + random.nextDouble() * 2.0D;
                double z = target.getZ() + (random.nextDouble() - 0.5) * 3.0D;
                world.addParticle(MountainsPoemModParticleTypes.SACRIFICE_P.get(), x, y, z, 2, 3, 2);
            }

            if (target instanceof Zombie
                    || target instanceof Skeleton
                    || target instanceof WitherSkeleton
                    || target instanceof ZombifiedPiglin
                    || target instanceof Phantom) {
                target.setSecondsOnFire(15);
            }
        }

        return retval;
    }
}