
package net.mcreator.mountainspoem.item;

public class SaltItem extends Item {
	public SaltItem() {
		super(new Item.Properties().stacksTo(64).rarity(Rarity.COMMON).food((new FoodProperties.Builder()).nutrition(2).saturationMod(0.6f).alwaysEat().build()));
	}
}
