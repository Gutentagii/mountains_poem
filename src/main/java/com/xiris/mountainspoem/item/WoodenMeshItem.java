
package com.xiris.mountainspoem.item;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;

public class WoodenMeshItem extends Item {
	public WoodenMeshItem() {
		super(new Item.Properties().stacksTo(64).rarity(Rarity.COMMON));
	}
}
