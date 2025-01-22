
package net.mcreator.mountainspoem.item;

public class CookedLeiMeatItem extends Item {
	public CookedLeiMeatItem() {
		super(new Item.Properties().stacksTo(64).rarity(Rarity.COMMON).food((new FoodProperties.Builder()).nutrition(8).saturationMod(1f).meat().build()));
	}

	@Override
	public int getUseDuration(ItemStack itemstack) {
		return 28;
	}
}
