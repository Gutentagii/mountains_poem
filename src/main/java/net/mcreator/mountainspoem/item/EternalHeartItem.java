
package net.mcreator.mountainspoem.item;

public class EternalHeartItem extends Item {
	public EternalHeartItem() {
		super(new Item.Properties().stacksTo(64).rarity(Rarity.RARE).food((new FoodProperties.Builder()).nutrition(5).saturationMod(0.6f).meat().build()));
	}
}
