
package net.mcreator.mountainspoem.item;

import net.minecraft.client.model.HumanoidModel;
import net.minecraft.network.chat.Component;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.decoration.ArmorStand;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.Level;
import net.minecraftforge.client.extensions.common.IClientItemExtensions;
import org.jetbrains.annotations.NotNull;
import software.bernie.geckolib.util.GeckoLibUtil;
import software.bernie.geckolib.renderer.GeoArmorRenderer;
import software.bernie.geckolib.core.object.PlayState;
import software.bernie.geckolib.core.animation.RawAnimation;
import software.bernie.geckolib.core.animation.AnimationState;
import software.bernie.geckolib.core.animation.AnimationController;
import software.bernie.geckolib.core.animation.AnimatableManager;
import software.bernie.geckolib.core.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.constant.DataTickets;
import software.bernie.geckolib.animatable.GeoItem;

import net.minecraft.sounds.SoundEvent;

import net.mcreator.mountainspoem.procedures.VinesArmorsXiongJiaShiJianMeiYouXiKeProcedure;
import net.mcreator.mountainspoem.init.MountainsPoemModItems;
import net.mcreator.mountainspoem.client.renderer.VinesArmorsArmorRenderer;

import java.util.function.Consumer;
import java.util.List;

public class VinesArmorsItem extends ArmorItem implements GeoItem {
	private final AnimatableInstanceCache cache = GeckoLibUtil.createInstanceCache(this);
	public String animationprocedure = "empty";

	public VinesArmorsItem(ArmorItem.Type type, Item.Properties properties) {
		super(new ArmorMaterial() {
			@Override
			public int getDurabilityForType(ArmorItem.@NotNull Type type) {
				return new int[]{13, 15, 16, 11}[type.getSlot().getIndex()] * 27;
			}

			@Override
			public int getDefenseForType(ArmorItem.@NotNull Type type) {
				return new int[]{3, 6, 7, 3}[type.getSlot().getIndex()];
			}

			@Override
			public int getEnchantmentValue() {
				return 9;
			}

			@Override
			public @NotNull SoundEvent getEquipSound() {
				return SoundEvents.EMPTY;
			}

			@Override
			public @NotNull Ingredient getRepairIngredient() {
				return Ingredient.of(new ItemStack(MountainsPoemModItems.DIP_OIL_VINES_PLATE.get()));
			}

			@Override
			public @NotNull String getName() {
				return "vines_armors";
			}

			@Override
			public float getToughness() {
				return 0.2f;
			}

			@Override
			public float getKnockbackResistance() {
				return 0.1f;
			}
		}, type, properties);
	}

	@Override
	public void initializeClient(Consumer<net.minecraftforge.client.extensions.common.IClientItemExtensions> consumer) {
		consumer.accept(new IClientItemExtensions() {
			private GeoArmorRenderer<?> renderer;

			@Override
			public @NotNull HumanoidModel<?> getHumanoidArmorModel(LivingEntity livingEntity, ItemStack itemStack, EquipmentSlot equipmentSlot, HumanoidModel<?> original) {
				if (this.renderer == null)
					this.renderer = new VinesArmorsArmorRenderer();
				this.renderer.prepForRender(livingEntity, itemStack, equipmentSlot, original);
				return this.renderer;
			}
		});
	}

	@Override
	public void appendHoverText(@NotNull ItemStack itemstack, Level world, @NotNull List<Component> list, @NotNull TooltipFlag flag) {
		super.appendHoverText(itemstack, world, list, flag);
	}

	@Override
	public void onArmorTick(ItemStack itemstack, Level world, Player entity) {
		if (itemstack.getItem() instanceof VinesArmorsItem armor && armor.getType() == ArmorItem.Type.HELMET)
			VinesArmorsXiongJiaShiJianMeiYouXiKeProcedure.execute(entity);
		if (itemstack.getItem() instanceof VinesArmorsItem armor && armor.getType() == ArmorItem.Type.CHESTPLATE)
			VinesArmorsXiongJiaShiJianMeiYouXiKeProcedure.execute(entity);
	}

	private PlayState predicate(AnimationState event) {
		if (this.animationprocedure.equals("empty")) {
			event.getController().setAnimation(RawAnimation.begin().thenLoop("idle"));
			Entity entity = (Entity) event.getData(DataTickets.ENTITY);
			if (entity instanceof ArmorStand) {
				return PlayState.CONTINUE;
			}
			return PlayState.CONTINUE;
		}
		return PlayState.STOP;
	}

	private PlayState procedurePredicate(AnimationState event) {
		if (!this.animationprocedure.equals("empty") && event.getController().getAnimationState() == AnimationController.State.STOPPED) {
			event.getController().setAnimation(RawAnimation.begin().thenPlay(this.animationprocedure));
			if (event.getController().getAnimationState() == AnimationController.State.STOPPED) {
				this.animationprocedure = "empty";
				event.getController().forceAnimationReset();
			}
			Entity entity = (Entity) event.getData(DataTickets.ENTITY);
			if (entity instanceof ArmorStand) {
				return PlayState.CONTINUE;
			}
			return PlayState.CONTINUE;
		}
		return PlayState.CONTINUE;
	}

	@Override
	public void registerControllers(AnimatableManager.ControllerRegistrar data) {
		data.add(new AnimationController(this, "controller", 5, this::predicate));
		data.add(new AnimationController(this, "procedureController", 5, this::procedurePredicate));
	}

	@Override
	public AnimatableInstanceCache getAnimatableInstanceCache() {
		return this.cache;
	}
}
