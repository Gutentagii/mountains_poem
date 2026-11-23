
package com.xiris.mountainspoem.item;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;

public class YellowClothItem extends Item {
	public YellowClothItem() {
		super(new Item.Properties().stacksTo(64).rarity(Rarity.COMMON));
	}
}
