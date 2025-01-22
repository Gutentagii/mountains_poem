
package net.mcreator.mountainspoem.item;

public class WoodsWormsItem extends Item {
	public WoodsWormsItem() {
		super(new Item.Properties().stacksTo(64).rarity(Rarity.COMMON).food((new FoodProperties.Builder()).nutrition(2).saturationMod(0.3f).meat().build()));
	}
}
