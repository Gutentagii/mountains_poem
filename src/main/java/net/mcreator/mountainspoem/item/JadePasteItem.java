
package net.mcreator.mountainspoem.item;

public class JadePasteItem extends Item {
	public JadePasteItem() {
		super(new Item.Properties().stacksTo(64).rarity(Rarity.UNCOMMON).food((new FoodProperties.Builder()).nutrition(6).saturationMod(4f).build()));
	}
}
