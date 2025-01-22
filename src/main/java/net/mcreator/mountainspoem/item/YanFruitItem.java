
package net.mcreator.mountainspoem.item;

public class YanFruitItem extends Item {
	public YanFruitItem() {
		super(new Item.Properties().stacksTo(64).rarity(Rarity.COMMON).food((new FoodProperties.Builder()).nutrition(2).saturationMod(0.3f).build()));
	}

	@Override
	public int getUseDuration(ItemStack itemstack) {
		return 24;
	}
}
