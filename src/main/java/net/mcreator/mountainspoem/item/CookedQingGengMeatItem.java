
package net.mcreator.mountainspoem.item;

public class CookedQingGengMeatItem extends Item {
	public CookedQingGengMeatItem() {
		super(new Item.Properties().stacksTo(64).rarity(Rarity.COMMON).food((new FoodProperties.Builder()).nutrition(7).saturationMod(1f).meat().build()));
	}
}
