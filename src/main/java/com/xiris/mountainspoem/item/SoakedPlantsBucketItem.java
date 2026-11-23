
package com.xiris.mountainspoem.item;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;

public class SoakedPlantsBucketItem extends Item {
	public SoakedPlantsBucketItem() {
		super(new Item.Properties().stacksTo(16).rarity(Rarity.COMMON));
	}
}
