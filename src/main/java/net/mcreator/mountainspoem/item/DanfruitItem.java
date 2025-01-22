
package net.mcreator.mountainspoem.item;

public class DanfruitItem extends Item {
	public DanfruitItem() {
		super(new Item.Properties().stacksTo(64).rarity(Rarity.COMMON).food((new FoodProperties.Builder()).nutrition(20).saturationMod(0.3f).build()));
	}
}
