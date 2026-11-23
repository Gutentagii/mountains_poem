
package com.xiris.mountainspoem.item;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;

public class DarkFeatherItem extends Item {
	public DarkFeatherItem() {
		super(new Item.Properties().stacksTo(64).rarity(Rarity.UNCOMMON));
	}
}
