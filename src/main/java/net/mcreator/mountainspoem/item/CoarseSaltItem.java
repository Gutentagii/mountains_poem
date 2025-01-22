
package net.mcreator.mountainspoem.item;

public class CoarseSaltItem extends Item {
	public CoarseSaltItem() {
		super(new Item.Properties().stacksTo(64).rarity(Rarity.COMMON).food((new FoodProperties.Builder()).nutrition(1).saturationMod(0.5f).alwaysEat().build()));
	}
}
