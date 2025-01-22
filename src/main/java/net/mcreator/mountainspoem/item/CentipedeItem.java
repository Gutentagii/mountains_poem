
package net.mcreator.mountainspoem.item;

public class CentipedeItem extends Item {
	public CentipedeItem() {
		super(new Item.Properties().stacksTo(64).rarity(Rarity.COMMON).food((new FoodProperties.Builder()).nutrition(2).saturationMod(0.2f).meat().build()));
	}
}
