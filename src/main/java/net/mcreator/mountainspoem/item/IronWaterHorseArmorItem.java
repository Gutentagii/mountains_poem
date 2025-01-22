
package net.mcreator.mountainspoem.item;

import net.mcreator.mountainspoem.procedures.GoldenWaterHorseArmorWuPinZaiBeiBaoZhongShiMeiKeFaShengProcedure;

public class IronWaterHorseArmorItem extends Item {
	public IronWaterHorseArmorItem() {
		super(new Item.Properties().stacksTo(1).rarity(Rarity.COMMON));
	}

	@Override
	public int getEnchantmentValue() {
		return 14;
	}

	@Override
	public void inventoryTick(ItemStack itemstack, Level world, Entity entity, int slot, boolean selected) {
		super.inventoryTick(itemstack, world, entity, slot, selected);
		GoldenWaterHorseArmorWuPinZaiBeiBaoZhongShiMeiKeFaShengProcedure.execute(entity);
	}
}
