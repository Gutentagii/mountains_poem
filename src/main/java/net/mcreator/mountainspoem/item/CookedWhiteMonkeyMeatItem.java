
package net.mcreator.mountainspoem.item;

public class CookedWhiteMonkeyMeatItem extends Item {
	public CookedWhiteMonkeyMeatItem() {
		super(new Item.Properties().stacksTo(64).rarity(Rarity.COMMON).food((new FoodProperties.Builder()).nutrition(7).saturationMod(0.8f).meat().build()));
	}
}
