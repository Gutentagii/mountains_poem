
package com.xiris.mountainspoem.item;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;

public class BambooMeshItem extends Item {
	public BambooMeshItem() {
		super(new Item.Properties().stacksTo(64).rarity(Rarity.COMMON));
	}
}
