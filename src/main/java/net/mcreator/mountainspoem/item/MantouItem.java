
package net.mcreator.mountainspoem.item;

public class MantouItem extends Item {
	public MantouItem() {
		super(new Item.Properties().stacksTo(64).rarity(Rarity.COMMON).food((new FoodProperties.Builder()).nutrition(4).saturationMod(1f).build()));
	}
}
