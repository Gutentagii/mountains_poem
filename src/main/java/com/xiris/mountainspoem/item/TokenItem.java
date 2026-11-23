
package com.xiris.mountainspoem.item;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;

public class TokenItem extends Item {
	public TokenItem() {
		super(new Item.Properties().stacksTo(64).rarity(Rarity.RARE));
	}
}
