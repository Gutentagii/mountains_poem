
package com.xiris.mountainspoem.item;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;

public class CyanClothItem extends Item {
	public CyanClothItem() {
		super(new Item.Properties().stacksTo(64).rarity(Rarity.COMMON));
	}
}
