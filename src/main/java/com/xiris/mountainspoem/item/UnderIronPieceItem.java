
package com.xiris.mountainspoem.item;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;

public class UnderIronPieceItem extends Item {
	public UnderIronPieceItem() {
		super(new Item.Properties().stacksTo(64).rarity(Rarity.UNCOMMON));
	}
}
