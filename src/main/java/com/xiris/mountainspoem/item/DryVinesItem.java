
package com.xiris.mountainspoem.item;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;

public class DryVinesItem extends Item {
	public DryVinesItem() {
		super(new Item.Properties().stacksTo(64).rarity(Rarity.COMMON));
	}
}
