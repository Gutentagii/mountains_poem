
package com.xiris.mountainspoem.item;

import com.google.common.collect.Iterables;
import com.xiris.mountainspoem.client.model.ModelAo_yin_fur_coat;
import com.xiris.mountainspoem.init.MountainsPoemModItems;
import net.minecraft.client.Minecraft;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.Level;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.client.extensions.common.IClientItemExtensions;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.Collections;
import java.util.Map;
import java.util.Objects;
import java.util.function.Consumer;

public abstract class AoYinFurCoatArmorItem extends ArmorItem {
	public AoYinFurCoatArmorItem(Type type, Properties properties) {
		super(new ArmorMaterial() {
			@Override
			public int getDurabilityForType(Type type) {
				return new int[]{13, 15, 16, 11}[type.getSlot().getIndex()] * 40;
			}

			@Override
			public int getDefenseForType(Type type) {
				return new int[]{4, 9, 8, 3}[type.getSlot().getIndex()];
			}

			@Override
			public int getEnchantmentValue() {
				return 22;
			}

			@Override
			public SoundEvent getEquipSound() {
				return Objects.requireNonNull(ForgeRegistries.SOUND_EVENTS.getValue(ResourceLocation.fromNamespaceAndPath("minecraft", "block.copper.hit")));
			}

			@Override
			public Ingredient getRepairIngredient() {
				return Ingredient.of(new ItemStack(MountainsPoemModItems.BLOODCOPPERPLATE.get()));
			}

			@Override
			public String getName() {
				return "ao_yin_fur_coat";
			}

			@Override
			public float getToughness() {
				return 2f;
			}

			@Override
			public float getKnockbackResistance() {
				return 1f;
			}
		}, type, properties);
	}

    public static class Chestplate extends UnderIrontItem {
        public Chestplate() {
            super(Type.CHESTPLATE, new Properties());
        }

        @Override
        public void initializeClient(Consumer<IClientItemExtensions> consumer) {
            consumer.accept(new IClientItemExtensions() {
                @Override
                @OnlyIn(Dist.CLIENT)
                public HumanoidModel getHumanoidArmorModel(LivingEntity living, ItemStack stack, EquipmentSlot slot, HumanoidModel defaultModel) {
                    HumanoidModel armorModel = new HumanoidModel(new ModelPart(Collections.emptyList(),
                            Map.of("body", new ModelAo_yin_fur_coat(Minecraft.getInstance().getEntityModels().bakeLayer(ModelAo_yin_fur_coat.LAYER_LOCATION)).bipedBody, "left_arm",
                                    new ModelAo_yin_fur_coat(Minecraft.getInstance().getEntityModels().bakeLayer(ModelAo_yin_fur_coat.LAYER_LOCATION)).bipedLeftArm, "right_arm",
                                    new ModelAo_yin_fur_coat(Minecraft.getInstance().getEntityModels().bakeLayer(ModelAo_yin_fur_coat.LAYER_LOCATION)).bipedRightArm, "head",
                                    new ModelPart(Collections.emptyList(), Collections.emptyMap()), "hat", new ModelPart(Collections.emptyList(), Collections.emptyMap()), "right_leg", new ModelPart(Collections.emptyList(), Collections.emptyMap()),
                                    "left_leg", new ModelPart(Collections.emptyList(), Collections.emptyMap()))));
                    armorModel.crouching = living.isShiftKeyDown();
                    armorModel.riding = defaultModel.riding;
                    armorModel.young = living.isBaby();
                    return armorModel;
                }
            });
        }

        @Override
        public String getArmorTexture(ItemStack stack, Entity entity, EquipmentSlot slot, String type) {
            return "mountains_poem:textures/entities/ao_yin_fur_coat.png";
        }

        @Override
        public void inventoryTick(ItemStack itemstack, Level world, Entity entity, int slot, boolean selected) {
            super.inventoryTick(itemstack, world, entity, slot, selected);

            if (entity instanceof Player player) {
                for (Mob mob : world.getEntitiesOfClass(Mob.class, player.getBoundingBox().inflate(10.0D))) {
                    if (mob.getTarget() == player) {
                        mob.setTarget(null);
                    }
                }
            }
        }
    }
}
