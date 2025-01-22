
/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.mountainspoem.init;

import net.minecraft.world.item.ItemStack;
import net.minecraftforge.event.furnace.FurnaceFuelBurnTimeEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber
public class MountainsPoemModFuels {
	@SubscribeEvent
	public static void furnaceFuelBurnTimeEvent(FurnaceFuelBurnTimeEvent event) {
		ItemStack itemstack = event.getItemStack();
		if (itemstack.getItem() == MountainsPoemModBlocks.YAN_STAIRS.get().asItem())
			event.setBurnTime(800);
		else if (itemstack.getItem() == MountainsPoemModBlocks.YAN_SLAB.get().asItem())
			event.setBurnTime(800);
		else if (itemstack.getItem() == MountainsPoemModBlocks.STRIPPED_YAN_LOG.get().asItem())
			event.setBurnTime(1000);
		else if (itemstack.getItem() == MountainsPoemModBlocks.YAN_FENCE.get().asItem())
			event.setBurnTime(800);
		else if (itemstack.getItem() == MountainsPoemModBlocks.SHATANG_PRESSURE_PLATE.get().asItem())
			event.setBurnTime(800);
		else if (itemstack.getItem() == MountainsPoemModBlocks.SHATANG_STAIRS.get().asItem())
			event.setBurnTime(800);
		else if (itemstack.getItem() == MountainsPoemModBlocks.SHATANG_SLAB.get().asItem())
			event.setBurnTime(800);
		else if (itemstack.getItem() == MountainsPoemModBlocks.SHATANG_FENCE.get().asItem())
			event.setBurnTime(800);
		else if (itemstack.getItem() == MountainsPoemModBlocks.SHATANG_FENCE_GATE.get().asItem())
			event.setBurnTime(800);
		else if (itemstack.getItem() == MountainsPoemModBlocks.SHATANG_BUTTON.get().asItem())
			event.setBurnTime(800);
		else if (itemstack.getItem() == MountainsPoemModBlocks.GUI_BASKET.get().asItem())
			event.setBurnTime(400);
	}
}
