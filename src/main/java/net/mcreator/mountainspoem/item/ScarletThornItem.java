
package net.mcreator.mountainspoem.item;

import net.minecraft.world.entity.ai.attributes.Attributes;

import net.mcreator.mountainspoem.procedures.ScarletThornsShengWuWanJiaYuZhiWuXiangZhuangShiProcedure;
import net.mcreator.mountainspoem.procedures.ScarletThornWuPinZaiBeiBaoZhongShiMeiKeFaShengProcedure;

public class ScarletThornItem extends Item {
	public ScarletThornItem() {
		super(new Item.Properties().stacksTo(64).rarity(Rarity.COMMON).food((new FoodProperties.Builder()).nutrition(5).saturationMod(2.5f).alwaysEat().build()));
	}

	@Override
	public Multimap<Attribute, AttributeModifier> getDefaultAttributeModifiers(EquipmentSlot equipmentSlot) {
		if (equipmentSlot == EquipmentSlot.MAINHAND) {
			ImmutableMultimap.Builder<Attribute, AttributeModifier> builder = ImmutableMultimap.builder();
			builder.putAll(super.getDefaultAttributeModifiers(equipmentSlot));
			builder.put(Attributes.ATTACK_DAMAGE, new AttributeModifier(BASE_ATTACK_DAMAGE_UUID, "Item modifier", 0.5d, AttributeModifier.Operation.ADDITION));
			builder.put(Attributes.ATTACK_SPEED, new AttributeModifier(BASE_ATTACK_SPEED_UUID, "Item modifier", -2.4, AttributeModifier.Operation.ADDITION));
			return builder.build();
		}
		return super.getDefaultAttributeModifiers(equipmentSlot);
	}

	@Override
	public ItemStack finishUsingItem(ItemStack itemstack, Level world, LivingEntity entity) {
		ItemStack retval = super.finishUsingItem(itemstack, world, entity);
		double x = entity.getX();
		double y = entity.getY();
		double z = entity.getZ();
		ScarletThornsShengWuWanJiaYuZhiWuXiangZhuangShiProcedure.execute(world, entity);
		return retval;
	}

	@Override
	public boolean hurtEnemy(ItemStack itemstack, LivingEntity entity, LivingEntity sourceentity) {
		boolean retval = super.hurtEnemy(itemstack, entity, sourceentity);
		ScarletThornsShengWuWanJiaYuZhiWuXiangZhuangShiProcedure.execute(entity.level(), entity);
		return retval;
	}

	@Override
	public void inventoryTick(ItemStack itemstack, Level world, Entity entity, int slot, boolean selected) {
		super.inventoryTick(itemstack, world, entity, slot, selected);
		ScarletThornWuPinZaiBeiBaoZhongShiMeiKeFaShengProcedure.execute(entity);
	}
}
