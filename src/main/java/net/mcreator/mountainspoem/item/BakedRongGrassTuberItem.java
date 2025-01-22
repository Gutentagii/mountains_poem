
package net.mcreator.mountainspoem.item;

public class BakedRongGrassTuberItem extends Item {
	public BakedRongGrassTuberItem() {
		super(new Item.Properties().stacksTo(64).rarity(Rarity.COMMON).food((new FoodProperties.Builder()).nutrition(7).saturationMod(0.8f).build()));
	}
}
