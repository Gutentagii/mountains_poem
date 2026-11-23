
package com.xiris.mountainspoem.item;

import com.google.common.collect.ImmutableMultimap;
import com.google.common.collect.Multimap;
import com.xiris.mountainspoem.MountainsPoemMod;
import com.xiris.mountainspoem.init.MountainsPoemModItems;
import com.xiris.mountainspoem.init.MountainsPoemModMobEffects;
import com.xiris.mountainspoem.init.MountainsPoemModParticleTypes;
import com.xiris.mountainspoem.init.MountainsPoemModSounds;
import com.xiris.mountainspoem.item.renderer.PlagueHalberdItemRenderer;
import com.xiris.mountainspoem.util.EntityUtils;
import net.minecraft.client.renderer.BlockEntityWithoutLevelRenderer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundSource;
import net.minecraft.tags.ItemTags;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.item.*;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.client.extensions.common.IClientItemExtensions;
import software.bernie.geckolib.animatable.GeoItem;
import software.bernie.geckolib.core.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.core.animation.AnimatableManager;
import software.bernie.geckolib.core.animation.AnimationController;
import software.bernie.geckolib.core.animation.AnimationState;
import software.bernie.geckolib.core.animation.RawAnimation;
import software.bernie.geckolib.core.object.PlayState;
import software.bernie.geckolib.util.GeckoLibUtil;

import java.util.function.Consumer;

public class PlagueHalberdItem extends Item implements GeoItem {
	private final AnimatableInstanceCache cache = GeckoLibUtil.createInstanceCache(this);
	public String animationprocedure = "empty";
	public static ItemDisplayContext transformType;

	public PlagueHalberdItem() {
		super(new Item.Properties().durability(900).fireResistant().rarity(Rarity.RARE));
	}

	@Override
	public void initializeClient(Consumer<IClientItemExtensions> consumer) {
		super.initializeClient(consumer);
		consumer.accept(new IClientItemExtensions() {
			private final BlockEntityWithoutLevelRenderer renderer = new PlagueHalberdItemRenderer();

			@Override
			public BlockEntityWithoutLevelRenderer getCustomRenderer() {
				return this.renderer;
			}
		});
	}

	public void getTransformType(ItemDisplayContext type) {
		transformType = type;
	}

	private PlayState idlePredicate(AnimationState event) {
		if (transformType != null) {
			if (this.animationprocedure.equals("empty")) {
				event.getController().setAnimation(RawAnimation.begin().thenLoop("idle"));
				return PlayState.CONTINUE;
			}
		}
		return PlayState.STOP;
	}

	String prevAnim = "empty";

	private PlayState procedurePredicate(AnimationState event) {
		if (transformType != null) {
			if (!this.animationprocedure.equals("empty") && event.getController().getAnimationState() == AnimationController.State.STOPPED || (!this.animationprocedure.equals(this.prevAnim) && !this.animationprocedure.equals("empty"))) {
				if (!this.animationprocedure.equals(this.prevAnim))
					event.getController().forceAnimationReset();
				event.getController().setAnimation(RawAnimation.begin().thenPlay(this.animationprocedure));
				if (event.getController().getAnimationState() == AnimationController.State.STOPPED) {
					this.animationprocedure = "empty";
					event.getController().forceAnimationReset();
				}
			} else if (this.animationprocedure.equals("empty")) {
                this.prevAnim = "empty";
				return PlayState.STOP;
			}
		}
        this.prevAnim = this.animationprocedure;
		return PlayState.CONTINUE;
	}

	@Override
	public void registerControllers(AnimatableManager.ControllerRegistrar data) {
		AnimationController procedureController = new AnimationController(this, "procedureController", 0, this::procedurePredicate);
		data.add(procedureController);
		AnimationController idleController = new AnimationController(this, "idleController", 0, this::idlePredicate);
		data.add(idleController);
	}

	@Override
	public AnimatableInstanceCache getAnimatableInstanceCache() {
		return this.cache;
	}

	@Override
	public UseAnim getUseAnimation(ItemStack itemstack) {
		return UseAnim.SPEAR;
	}

	@Override
	public boolean hasCraftingRemainingItem() {
		return true;
	}

	@Override
	public ItemStack getCraftingRemainingItem(ItemStack itemstack) {
		ItemStack retval = new ItemStack(this);
		retval.setDamageValue(itemstack.getDamageValue() + 1);
		if (retval.getDamageValue() >= retval.getMaxDamage()) {
			return ItemStack.EMPTY;
		}
		return retval;
	}

	@Override
	public boolean isRepairable(ItemStack itemstack) {
		return false;
	}

	@Override
	public int getEnchantmentValue() {
		return 13;
	}

	@Override
	public Multimap<Attribute, AttributeModifier> getDefaultAttributeModifiers(EquipmentSlot equipmentSlot) {
		if (equipmentSlot == EquipmentSlot.MAINHAND) {
			ImmutableMultimap.Builder<Attribute, AttributeModifier> builder = ImmutableMultimap.builder();
			builder.putAll(super.getDefaultAttributeModifiers(equipmentSlot));
			builder.put(Attributes.ATTACK_DAMAGE, new AttributeModifier(BASE_ATTACK_DAMAGE_UUID, "Item modifier", 10d, AttributeModifier.Operation.ADDITION));
			builder.put(Attributes.ATTACK_SPEED, new AttributeModifier(BASE_ATTACK_SPEED_UUID, "Item modifier", -2.4, AttributeModifier.Operation.ADDITION));
			return builder.build();
		}
		return super.getDefaultAttributeModifiers(equipmentSlot);
	}

	@Override
	public InteractionResultHolder<ItemStack> use(Level world, Player entity, InteractionHand hand) {
		InteractionResultHolder<ItemStack> ar = super.use(world, entity, hand);
		ItemStack itemstack = ar.getObject();
		double x = entity.getX();
		double y = entity.getY();
		double z = entity.getZ();

		Vec3 pos = entity.position();
		double x1 = pos.x, y1 = pos.y, z1 = pos.z;
		if (entity.getMainHandItem().is(MountainsPoemModItems.PLAGUE_HALBERD.get())) {
			Level projectileLevel = entity.level();
			if (!projectileLevel.isClientSide()) {
				Projectile _entityToSpawn = EntityUtils.getArrow(projectileLevel, entity, 5, 1, 0);
				_entityToSpawn.setPos(entity.getX(), entity.getEyeY() - 0.1, entity.getZ());
				_entityToSpawn.shoot(entity.getLookAngle().x, entity.getLookAngle().y, entity.getLookAngle().z, 2, 0);
				projectileLevel.addFreshEntity(_entityToSpawn);
			}
			entity.getCooldowns().addCooldown(entity.getMainHandItem().getItem(), 10);
			if (itemstack.getItem() instanceof PlagueHalberdItem)
				itemstack.getOrCreateTag().putString("geckoAnim", "attack");
			entity.swing(InteractionHand.MAIN_HAND, true);
            world.playSound(null, x1, y1, z1, MountainsPoemModSounds.FEI_BULL_STEP.get(), SoundSource.NEUTRAL, 2, 1);
			if (entity.getOffhandItem().is(ItemTags.create(ResourceLocation.fromNamespaceAndPath(MountainsPoemMod.MOD_ID, "lucky_tools")))) {
				if (entity.getOffhandItem().isDamageableItem()) {
					ItemStack stack = entity.getOffhandItem();
					if (stack.hurt(3, RandomSource.create(), null)) {
						stack.shrink(1);
						stack.setDamageValue(0);
					}
					entity.swing(InteractionHand.OFF_HAND, true);
				} else {
					entity.getOffhandItem().shrink(1);
					entity.swing(InteractionHand.OFF_HAND, true);
                    world.playSound(null, x1, y1, z1, MountainsPoemModSounds.HALBERD.get(), SoundSource.NEUTRAL, 1, 1);
				}
			} else if (Math.random() < 0.7)
				if (!entity.level().isClientSide())
					entity.addEffect(new MobEffectInstance(MountainsPoemModMobEffects.PESTILENCE.get(), 200, 1));
		}
		return ar;
	}

	@Override
	public boolean onEntitySwing(ItemStack itemstack, LivingEntity entity) {
		boolean retval = super.onEntitySwing(itemstack, entity);
        LevelAccessor world = entity.level();
        double x = entity.getX();
        double y = entity.getY();
        double z = entity.getZ();
        if (world instanceof ServerLevel _level)
            _level.sendParticles(MountainsPoemModParticleTypes.PLAGUES.get(), x, y, z, 5, 3, 3, 3, 1);
        if (world instanceof Level _level)
            ((Level) world).playSound(null, x, y, z, MountainsPoemModSounds.HALBERD.get(), SoundSource.NEUTRAL, 1, 1);
        return retval;
	}
}
