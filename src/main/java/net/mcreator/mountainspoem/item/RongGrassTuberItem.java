
package net.mcreator.mountainspoem.item;

public class RongGrassTuberItem extends Item {
	public RongGrassTuberItem() {
		super(new Item.Properties().stacksTo(64).rarity(Rarity.COMMON).food((new FoodProperties.Builder()).nutrition(6).saturationMod(0.5f).build()));
	}
}
