
package com.xiris.mountainspoem.item;

import com.xiris.mountainspoem.MountainsPoemMod;
import net.minecraft.advancements.Advancement;
import net.minecraft.advancements.AdvancementProgress;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.ExperienceOrb;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.animal.Pig;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;

import java.util.List;

public class LushuLeatherItem extends Item {
	public LushuLeatherItem() {
		super(new Item.Properties().stacksTo(64).rarity(Rarity.COMMON));
	}

	@Override
	public void appendHoverText(ItemStack itemstack, Level world, List<Component> list, TooltipFlag flag) {
		super.appendHoverText(itemstack, world, list, flag);
		list.add(Component.translatable("item.mountains_poem.item.decsr.lushu_leather"));
	}

    @Override
    public boolean onEntitySwing(ItemStack itemstack, LivingEntity entity) {
        boolean retval = super.onEntitySwing(itemstack, entity);

        if (!(entity instanceof Player player)) {
            return retval;
        }

        LevelAccessor world = entity.level();
        double x = entity.getX();
        double y = entity.getY();
        double z = entity.getZ();

        if (player.getFoodData().getFoodLevel() >= 15) {
            if (!world.isClientSide()) {
                player.causeFoodExhaustion(10);

                if (world instanceof ServerLevel serverLevel) {
                    serverLevel.addFreshEntity(new ExperienceOrb(serverLevel, x, y, z, 2));

                    Pig pig = EntityType.PIG.create(serverLevel);
                    if (pig != null) {
                        pig.moveTo(x, y, z, serverLevel.getRandom().nextFloat() * 360.0F, 0.0F);
                        serverLevel.addFreshEntity(pig);
                    }
                }

                itemstack.shrink(1);
                player.getCooldowns().addCooldown(itemstack.getItem(), 20);

                if (world instanceof Level level) {
                    level.playSound(null, x, y, z, SoundEvents.PIG_STEP, SoundSource.PLAYERS, 4.0F, 1.0F);
                }

                if (player instanceof ServerPlayer serverPlayer) {
                    Advancement adv = serverPlayer.server.getAdvancements()
                            .getAdvancement(ResourceLocation.fromNamespaceAndPath(MountainsPoemMod.MOD_ID, "pigman"));
                    if (adv != null) {
                        AdvancementProgress ap = serverPlayer.getAdvancements().getOrStartProgress(adv);
                        if (!ap.isDone()) {
                            for (String criteria : ap.getRemainingCriteria()) {
                                serverPlayer.getAdvancements().award(adv, criteria);
                            }
                        }
                    }
                }
            }
            else {
                world.addParticle(ParticleTypes.HEART, x, y, z, 0, 2, 0);
            }
        }

        return retval;
    }

	@Override
	public void inventoryTick(ItemStack itemstack, Level world, Entity entity, int slot, boolean selected) {
		super.inventoryTick(itemstack, world, entity, slot, selected);
		if (selected) {
            if (itemstack.getMaxDamage() < itemstack.getDamageValue())
                itemstack.shrink(1);
        }
        if (itemstack.getMaxDamage() < itemstack.getDamageValue())
            itemstack.shrink(1);
    }
}
