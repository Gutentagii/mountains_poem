
package net.mcreator.mountainspoem.item;

public class BigCarrotsItem extends Item {
	public BigCarrotsItem() {
		super(new Item.Properties().stacksTo(64).rarity(Rarity.COMMON).food((new FoodProperties.Builder()).nutrition(5).saturationMod(0.3f).build()));
	}
}
