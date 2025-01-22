
package net.mcreator.mountainspoem.item;

public class CookedRedRuFishItem extends Item {
	public CookedRedRuFishItem() {
		super(new Item.Properties().stacksTo(64).rarity(Rarity.COMMON).food((new FoodProperties.Builder()).nutrition(4).saturationMod(1.2f).build()));
	}
}
