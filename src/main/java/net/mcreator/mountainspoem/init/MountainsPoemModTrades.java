
/*
*	MCreator note: This file will be REGENERATED on each build.
*/
package net.mcreator.mountainspoem.init;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.common.BasicItemListing;
import net.minecraftforge.event.village.VillagerTradesEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.FORGE)
public class MountainsPoemModTrades {
	@SubscribeEvent
	public static void registerTrades(VillagerTradesEvent event) {
		if (event.getType() == MountainsPoemModVillagerProfessions.COPPER_SMITH.get()) {
			event.getTrades().get(1).add(new BasicItemListing(new ItemStack(Items.RAW_COPPER, 16),

					new ItemStack(Items.EMERALD, 17), 10, 10, 0.05f));
			event.getTrades().get(1).add(new BasicItemListing(new ItemStack(Items.COPPER_INGOT, 7),

					new ItemStack(Items.EMERALD, 14), 10, 10, 0.05f));
			event.getTrades().get(1).add(new BasicItemListing(new ItemStack(MountainsPoemModItems.BLOODCOPPER.get(), 8),

					new ItemStack(Items.EMERALD, 14), 10, 15, 0.05f));
			event.getTrades().get(1).add(new BasicItemListing(new ItemStack(MountainsPoemModItems.COPPER_JUE.get(), 16),

					new ItemStack(Items.EMERALD, 54), 10, 10, 0.05f));
			event.getTrades().get(2).add(new BasicItemListing(new ItemStack(Items.EMERALD, 8),

					new ItemStack(MountainsPoemModItems.WROUGHT_PATTERN_ZUN.get(), 3), 10, 5, 0.05f));
			event.getTrades().get(2).add(new BasicItemListing(new ItemStack(Items.EMERALD, 8),

					new ItemStack(MountainsPoemModItems.WROUGHT_PATTERN_JUE.get(), 3), 10, 5, 0.05f));
			event.getTrades().get(2).add(new BasicItemListing(new ItemStack(Items.EMERALD, 8),

					new ItemStack(MountainsPoemModItems.WROUGHT_PATTERN_SMALL_DING.get(), 3), 10, 5, 0.05f));
			event.getTrades().get(2).add(new BasicItemListing(new ItemStack(MountainsPoemModBlocks.COPPER_ZUN_BOTTLE.get(), 3),

					new ItemStack(Items.EMERALD, 32), 10, 5, 0.05f));
			event.getTrades().get(2).add(new BasicItemListing(new ItemStack(MountainsPoemModBlocks.COPPER_ZUN_BOTTLE_BOYI.get(), 3),

					new ItemStack(Items.EMERALD, 32), 10, 5, 0.05f));
			event.getTrades().get(2).add(new BasicItemListing(new ItemStack(MountainsPoemModBlocks.COPPER_ZUN_BOTTLE_CHANGFU.get()),

					new ItemStack(Items.EMERALD, 32), 10, 5, 0.05f));
			event.getTrades().get(2).add(new BasicItemListing(new ItemStack(MountainsPoemModBlocks.COPPER_SMALL_DING.get(), 3),

					new ItemStack(Items.EMERALD, 32), 10, 5, 0.05f));
			event.getTrades().get(2).add(new BasicItemListing(new ItemStack(MountainsPoemModBlocks.COPPER_GUI.get(), 8),

					new ItemStack(Items.EMERALD, 16), 10, 5, 0.05f));
			event.getTrades().get(3).add(new BasicItemListing(new ItemStack(Items.EMERALD, 18),

					new ItemStack(MountainsPoemModItems.WROUGHT_PATTERN_DOU.get(), 3), 10, 5, 0.05f));
			event.getTrades().get(3).add(new BasicItemListing(new ItemStack(Items.EMERALD, 18),

					new ItemStack(MountainsPoemModItems.WROUGHT_PATTERN_GUI.get(), 3), 10, 5, 0.05f));
			event.getTrades().get(3).add(new BasicItemListing(new ItemStack(Items.EMERALD, 8),

					new ItemStack(MountainsPoemModItems.BLOOD_COPPER_UPGRADE_SMITHING_TEMPLATE.get(), 3), 10, 5, 0.05f));
			event.getTrades().get(3).add(new BasicItemListing(new ItemStack(MountainsPoemModItems.BLOOD_COPPER_INGOT.get(), 14),

					new ItemStack(Items.EMERALD, 46), 10, 10, 0.05f));
			event.getTrades().get(3).add(new BasicItemListing(new ItemStack(MountainsPoemModBlocks.COPPER_DOU.get()),

					new ItemStack(Items.EMERALD, 18), 10, 10, 0.05f));
			event.getTrades().get(4).add(new BasicItemListing(new ItemStack(MountainsPoemModItems.BLOODCOPPERSWORD.get()),

					new ItemStack(Items.EMERALD, 16), 10, 15, 0.05f));
			event.getTrades().get(4).add(new BasicItemListing(new ItemStack(Items.EMERALD, 32),

					new ItemStack(MountainsPoemModItems.BLOODCOPPERPLATE.get(), 8), 10, 15, 0.05f));
			event.getTrades().get(4).add(new BasicItemListing(new ItemStack(Items.EMERALD, 16),

					new ItemStack(MountainsPoemModItems.WROUGHT_PATTERN_DAGGER_AXE.get(), 3), 10, 15, 0.05f));
			event.getTrades().get(4).add(new BasicItemListing(new ItemStack(Items.EMERALD, 16),

					new ItemStack(MountainsPoemModItems.WROUGHT_PATTERN_YUE.get(), 3), 10, 15, 0.05f));
			event.getTrades().get(3).add(new BasicItemListing(new ItemStack(MountainsPoemModItems.BOYI_TOTEM_SCROLLS.get()),

					new ItemStack(Items.EMERALD, 15), 10, 5, 0.05f));
			event.getTrades().get(3).add(new BasicItemListing(new ItemStack(MountainsPoemModItems.CHANGFU_TOTEM_SCROLLS.get()),

					new ItemStack(Items.EMERALD, 15), 10, 15, 0.05f));
			event.getTrades().get(4).add(new BasicItemListing(new ItemStack(MountainsPoemModItems.PIGLIN_TOTEM_SCROLLS.get()),

					new ItemStack(Items.EMERALD, 15), 10, 15, 0.05f));
			event.getTrades().get(4).add(new BasicItemListing(new ItemStack(MountainsPoemModItems.CHICKEN_TOTEM_SCROLLS.get()),

					new ItemStack(Items.EMERALD, 15), 10, 15, 0.05f));
			event.getTrades().get(4).add(new BasicItemListing(new ItemStack(MountainsPoemModItems.LEI_TOTEM_SCROLLS.get()),

					new ItemStack(Items.EMERALD, 15), 10, 15, 0.05f));
			event.getTrades().get(4).add(new BasicItemListing(new ItemStack(MountainsPoemModItems.LONG_CHI_TOTEM_SCROLLS.get()),

					new ItemStack(Items.EMERALD, 15), 10, 15, 0.05f));
			event.getTrades().get(5).add(new BasicItemListing(new ItemStack(MountainsPoemModItems.ZHENG_TOTEM_SCROLLS.get()),

					new ItemStack(Items.EMERALD, 15), 10, 15, 0.05f));
			event.getTrades().get(5).add(new BasicItemListing(new ItemStack(MountainsPoemModItems.ENDER_DRAGON_TOTEM_SCROLLS.get()),

					new ItemStack(Items.EMERALD, 15), 10, 15, 0.05f));
			event.getTrades().get(5).add(new BasicItemListing(new ItemStack(MountainsPoemModItems.SOUTH_MOUNTAINS_GOD_TOTEM_SCROLLS.get()),

					new ItemStack(Items.EMERALD, 15), 10, 15, 0.05f));
			event.getTrades().get(5).add(new BasicItemListing(new ItemStack(MountainsPoemModItems.ZHI_TOTEM_SCROLLS.get()),

					new ItemStack(Items.EMERALD, 15), 10, 15, 0.05f));
			event.getTrades().get(4).add(new BasicItemListing(new ItemStack(MountainsPoemModItems.BLOOD_COPPER_WATER_HORSE_ARMOR.get()),

					new ItemStack(Items.EMERALD, 13), 10, 15, 0.05f));
		}
		if (event.getType() == MountainsPoemModVillagerProfessions.HUAXIA_SORCERER.get()) {
			event.getTrades().get(1).add(new BasicItemListing(new ItemStack(MountainsPoemModItems.XUAN_SHELLS.get(), 15),

					new ItemStack(Items.EMERALD, 36), 10, 15, 0.05f));
			event.getTrades().get(1).add(new BasicItemListing(new ItemStack(MountainsPoemModItems.WATER_HORSE_MANE.get(), 8),

					new ItemStack(Items.EMERALD, 53), 10, 15, 0.05f));
			event.getTrades().get(1).add(new BasicItemListing(new ItemStack(MountainsPoemModItems.LEI_MANE.get(), 16),

					new ItemStack(Items.EMERALD, 27), 10, 15, 0.05f));
			event.getTrades().get(1).add(new BasicItemListing(new ItemStack(Items.EMERALD, 54),

					new ItemStack(MountainsPoemModItems.WISDOM_XUAN_SHELLS.get(), 3), 10, 25, 0.05f));
			event.getTrades().get(1).add(new BasicItemListing(new ItemStack(Items.EMERALD, 48),

					new ItemStack(MountainsPoemModItems.IMMORTALITY_XUAN_SHELLS.get(), 3), 10, 25, 0.05f));
			event.getTrades().get(2)
					.add(new BasicItemListing(new ItemStack(MountainsPoemModItems.GREENJADE.get(), 64), new ItemStack(MountainsPoemModItems.GREENJADE.get(), 32), new ItemStack(MountainsPoemModItems.DARK_FEATHER.get(), 4), 10, 15, 0.05f));
			event.getTrades().get(2).add(new BasicItemListing(new ItemStack(MountainsPoemModItems.GREENJADE.get(), 25),

					new ItemStack(MountainsPoemModItems.FLASHING_FUR.get(), 2), 10, 15, 0.05f));
			event.getTrades().get(2).add(new BasicItemListing(new ItemStack(MountainsPoemModItems.GREENJADE.get(), 44),

					new ItemStack(MountainsPoemModItems.ICY_FANGS.get(), 2), 10, 15, 0.05f));
			event.getTrades().get(2).add(new BasicItemListing(new ItemStack(MountainsPoemModItems.GREENJADE.get(), 44),

					new ItemStack(MountainsPoemModItems.TWISTED_CLAWS.get(), 3), 10, 15, 0.05f));
			event.getTrades().get(2).add(new BasicItemListing(new ItemStack(MountainsPoemModItems.GREENJADE.get(), 34),

					new ItemStack(MountainsPoemModItems.ETERNAL_HEART.get(), 2), 10, 15, 0.05f));
			event.getTrades().get(2).add(new BasicItemListing(new ItemStack(Items.EMERALD, 4),

					new ItemStack(MountainsPoemModItems.RED_RU_FISH.get(), 16), 10, 15, 0.05f));
			event.getTrades().get(3).add(new BasicItemListing(new ItemStack(MountainsPoemModItems.ZHENG_SALIVA.get()),

					new ItemStack(Items.EMERALD, 17), 10, 15, 0.05f));
			event.getTrades().get(3).add(new BasicItemListing(new ItemStack(MountainsPoemModItems.HUN_MEAT.get(), 32),

					new ItemStack(Items.EMERALD, 38), 10, 15, 0.05f));
			event.getTrades().get(3).add(new BasicItemListing(new ItemStack(MountainsPoemModItems.XUN_LEAVES_BERRIES.get(), 16),

					new ItemStack(Items.EMERALD, 27), 10, 25, 0.05f));
			event.getTrades().get(3).add(new BasicItemListing(new ItemStack(MountainsPoemModItems.GU_EAGLE_FEATHER.get(), 9),

					new ItemStack(Items.EMERALD, 34), 10, 25, 0.05f));
			event.getTrades().get(4).add(new BasicItemListing(new ItemStack(MountainsPoemModItems.WHITEJADE.get(), 11),

					new ItemStack(MountainsPoemModItems.CHIVALROUS_XUAN_SHELLS.get(), 7), 10, 25, 0.05f));
			event.getTrades().get(4).add(new BasicItemListing(new ItemStack(MountainsPoemModItems.WHITEJADE.get(), 14),

					new ItemStack(MountainsPoemModItems.HARVEST_XUAN_SHELLS.get(), 7), 10, 25, 0.05f));
			event.getTrades().get(4).add(new BasicItemListing(new ItemStack(MountainsPoemModItems.WHITEJADE.get(), 17),

					new ItemStack(MountainsPoemModItems.VITALITY_XUAN_SHELLS.get(), 7), 10, 25, 0.05f));
			event.getTrades().get(4).add(new BasicItemListing(new ItemStack(MountainsPoemModItems.WHITEJADE.get(), 16),

					new ItemStack(MountainsPoemModItems.RAIN_XUAN_SHELLS.get(), 7), 10, 25, 0.05f));
			event.getTrades().get(4).add(new BasicItemListing(new ItemStack(MountainsPoemModItems.WHITEJADE.get(), 11),

					new ItemStack(MountainsPoemModItems.THRONE_XUAN_SHELLS.get(), 7), 10, 25, 0.05f));
			event.getTrades().get(1).add(new BasicItemListing(new ItemStack(MountainsPoemModItems.THE_SOUTHERN_MOUNTAIN_JADE_PENDANT.get(), 5),

					new ItemStack(MountainsPoemModItems.WHITEJADE.get(), 19), 10, 15, 0.05f));
			event.getTrades().get(1).add(new BasicItemListing(new ItemStack(Items.EMERALD, 5),

					new ItemStack(MountainsPoemModBlocks.ZHUYU_GRASS.get(), 7), 10, 15, 0.05f));
			event.getTrades().get(1).add(new BasicItemListing(new ItemStack(Items.EMERALD, 7),

					new ItemStack(MountainsPoemModItems.WHITE_FOX_MEAT.get(), 12), 10, 15, 0.05f));
			event.getTrades().get(1).add(new BasicItemListing(new ItemStack(MountainsPoemModItems.JADEPIECE.get(), 8),

					new ItemStack(MountainsPoemModItems.LUSHU_LEATHER.get(), 6), 10, 15, 0.05f));
			event.getTrades().get(1).add(new BasicItemListing(new ItemStack(MountainsPoemModItems.JADEPIECE.get(), 16),

					new ItemStack(MountainsPoemModBlocks.JIANMEIBAMBOO.get(), 16), 10, 15, 0.05f));
			event.getTrades().get(2).add(new BasicItemListing(new ItemStack(Items.EMERALD, 15),

					new ItemStack(MountainsPoemModItems.XIAN_GOAT_FAT.get(), 17), 10, 15, 0.05f));
			event.getTrades().get(3).add(new BasicItemListing(new ItemStack(Items.EMERALD, 14),

					new ItemStack(MountainsPoemModItems.ZHENG_SALIVA.get(), 4), 10, 15, 0.05f));
			event.getTrades().get(3).add(new BasicItemListing(new ItemStack(MountainsPoemModItems.WHITEJADE.get(), 24),

					new ItemStack(MountainsPoemModBlocks.DUHENG_FLOWER.get()), 10, 15, 0.05f));
			event.getTrades().get(3).add(new BasicItemListing(new ItemStack(MountainsPoemModItems.WHITEJADE.get(), 9),

					new ItemStack(MountainsPoemModItems.QING_GENG_MEAT.get(), 32), 10, 15, 0.05f));
			event.getTrades().get(3).add(new BasicItemListing(new ItemStack(MountainsPoemModItems.WHITEJADE.get(), 24), new ItemStack(MountainsPoemModItems.JADETABLET.get()), new ItemStack(Blocks.SKELETON_SKULL, 3), 10, 15, 0.05f));
			event.getTrades().get(3).add(new BasicItemListing(new ItemStack(MountainsPoemModItems.WHITEJADE.get(), 19), new ItemStack(MountainsPoemModItems.JADETABLET.get()), new ItemStack(Items.ZOMBIE_HEAD, 3), 10, 15, 0.05f));
			event.getTrades().get(4).add(new BasicItemListing(new ItemStack(MountainsPoemModItems.WHITEJADE.get(), 21), new ItemStack(MountainsPoemModItems.JADETABLET.get()), new ItemStack(Items.CREEPER_HEAD, 3), 10, 15, 0.05f));
			event.getTrades().get(4).add(new BasicItemListing(new ItemStack(MountainsPoemModItems.WHITEJADE.get(), 32), new ItemStack(MountainsPoemModItems.JADETABLET.get()), new ItemStack(Blocks.PIGLIN_HEAD, 3), 10, 15, 0.05f));
			event.getTrades().get(4).add(new BasicItemListing(new ItemStack(MountainsPoemModItems.WHITEJADE.get(), 44), new ItemStack(MountainsPoemModItems.JADETABLET.get()), new ItemStack(Blocks.ZOMBIE_HEAD, 3), 10, 15, 0.05f));
			event.getTrades().get(2).add(new BasicItemListing(new ItemStack(Items.EMERALD, 16),

					new ItemStack(MountainsPoemModItems.SCINTILLATION_ENGRAVED_XUAN_SHELLS.get(), 3), 10, 13, 0.05f));
			event.getTrades().get(2).add(new BasicItemListing(new ItemStack(Items.EMERALD, 16),

					new ItemStack(MountainsPoemModItems.GANLIN_ENGRAVED_XUAN_SHELLS.get(), 3), 10, 13, 0.05f));
			event.getTrades().get(2).add(new BasicItemListing(new ItemStack(Items.EMERALD, 16),

					new ItemStack(MountainsPoemModItems.DAZZLING_STAR_ENGRAVED_XUAN_SHELLS.get(), 3), 10, 15, 0.05f));
			event.getTrades().get(2).add(new BasicItemListing(new ItemStack(Items.EMERALD, 16),

					new ItemStack(MountainsPoemModItems.RUST_ENGRAVED_XUAN_SHELLS.get(), 3), 10, 15, 0.05f));
			event.getTrades().get(2).add(new BasicItemListing(new ItemStack(Items.EMERALD, 16),

					new ItemStack(MountainsPoemModItems.SCARLET_TWILIGHT_ENGRAVED_XUAN_SHELLS.get(), 3), 10, 15, 0.05f));
			event.getTrades().get(2).add(new BasicItemListing(new ItemStack(Items.EMERALD, 16),

					new ItemStack(MountainsPoemModItems.DUSTY_SOIL_ENGRAVED_XUAN_SHELLS.get(), 3), 10, 15, 0.05f));
			event.getTrades().get(1).add(new BasicItemListing(new ItemStack(Items.EMERALD, 16),

					new ItemStack(MountainsPoemModItems.JUFU_HUMERUS.get(), 3), 10, 15, 0.05f));
			event.getTrades().get(1).add(new BasicItemListing(new ItemStack(Items.EMERALD, 16),

					new ItemStack(MountainsPoemModItems.ENGRAVED_XUAN_SHELLS_CHANGFU.get(), 3), 10, 15, 0.05f));
			event.getTrades().get(2).add(new BasicItemListing(new ItemStack(Items.EMERALD, 16),

					new ItemStack(MountainsPoemModItems.ENGRAVED_XUAN_SHELLS_BOYI.get(), 3), 10, 15, 0.05f));
			event.getTrades().get(2).add(new BasicItemListing(new ItemStack(Items.EMERALD, 16),

					new ItemStack(MountainsPoemModItems.HEALTH_XUAN_SHELLS.get(), 3), 10, 15, 0.05f));
			event.getTrades().get(4).add(new BasicItemListing(new ItemStack(Items.EMERALD, 16),

					new ItemStack(MountainsPoemModItems.HUNT_XUAN_SHELLS.get(), 3), 10, 15, 0.11f));
			event.getTrades().get(4).add(new BasicItemListing(new ItemStack(Items.EMERALD, 16),

					new ItemStack(MountainsPoemModItems.SAILING_XUAN_SHELLS.get(), 3), 10, 15, 0.09f));
			event.getTrades().get(4).add(new BasicItemListing(new ItemStack(Items.EMERALD, 32),

					new ItemStack(MountainsPoemModItems.SCARLET_THORN.get(), 8), 10, 15, 0.05f));
		}
		if (event.getType() == MountainsPoemModVillagerProfessions.JADE_MASON.get()) {
			event.getTrades().get(1).add(new BasicItemListing(new ItemStack(MountainsPoemModItems.WHITEJADE.get(), 16),

					new ItemStack(Items.EMERALD, 42), 10, 5, 0.05f));
			event.getTrades().get(1).add(new BasicItemListing(new ItemStack(MountainsPoemModItems.GREENJADE.get(), 16),

					new ItemStack(Items.EMERALD, 30), 10, 5, 0.05f));
			event.getTrades().get(1).add(new BasicItemListing(new ItemStack(MountainsPoemModItems.ALGAE_JADE.get(), 16),

					new ItemStack(Items.EMERALD, 24), 10, 5, 0.05f));
			event.getTrades().get(1).add(new BasicItemListing(new ItemStack(MountainsPoemModItems.INFERIOR_JADE.get(), 16),

					new ItemStack(Items.EMERALD, 16), 10, 5, 0.05f));
		}
		if (event.getType() == MountainsPoemModVillagerProfessions.JADE_MASON.get()) {
			event.getTrades().get(2).add(new BasicItemListing(new ItemStack(Items.EMERALD, 16),

					new ItemStack(MountainsPoemModItems.JADETABLET.get()), 10, 15, 0.05f));
			event.getTrades().get(2).add(new BasicItemListing(new ItemStack(Items.EMERALD, 16),

					new ItemStack(MountainsPoemModItems.JADE_PASTE.get()), 10, 15, 0.05f));
			event.getTrades().get(2).add(new BasicItemListing(new ItemStack(Items.EMERALD, 16),

					new ItemStack(MountainsPoemModItems.JADE_PASTE_BUCKET.get()), 10, 15, 0.05f));
			event.getTrades().get(2).add(new BasicItemListing(new ItemStack(Items.EMERALD, 16),

					new ItemStack(MountainsPoemModItems.MP_JADE_RING.get(), 32), 10, 5, 0.05f));
			event.getTrades().get(2).add(new BasicItemListing(new ItemStack(Items.EMERALD, 16),

					new ItemStack(MountainsPoemModItems.JADEPIECE.get()), 10, 5, 0.05f));
		}
		if (event.getType() == MountainsPoemModVillagerProfessions.JADE_MASON.get()) {
			event.getTrades().get(3).add(new BasicItemListing(new ItemStack(Items.EMERALD, 18),

					new ItemStack(MountainsPoemModItems.THE_SOUTHERN_MOUNTAIN_JADE_PENDANT.get(), 6), 10, 5, 0.05f));
			event.getTrades().get(3).add(new BasicItemListing(new ItemStack(Items.EMERALD, 18),

					new ItemStack(MountainsPoemModItems.THE_SECOND_SOUTHERN_MOUNTAIN_JADE_PENDANT.get(), 6), 10, 5, 0.05f));
			event.getTrades().get(3).add(new BasicItemListing(new ItemStack(Items.EMERALD, 18),

					new ItemStack(MountainsPoemModItems.THE_NINTH_CENTRAL_MOUNTAIN_JADE_PENDANT.get(), 6), 10, 5, 0.05f));
		}
		if (event.getType() == MountainsPoemModVillagerProfessions.JADE_MASON.get()) {
			event.getTrades().get(4).add(new BasicItemListing(new ItemStack(MountainsPoemModItems.WHITEJADE.get(), 8),

					new ItemStack(MountainsPoemModItems.GREENJADE.get(), 14), 10, 5, 0.05f));
			event.getTrades().get(1).add(new BasicItemListing(new ItemStack(MountainsPoemModItems.GREENJADE.get(), 14),

					new ItemStack(MountainsPoemModItems.ALGAE_JADE.get(), 32), 10, 5, 0.05f));
			event.getTrades().get(1).add(new BasicItemListing(new ItemStack(MountainsPoemModItems.ALGAE_JADE.get(), 8),

					new ItemStack(MountainsPoemModItems.JADEPIECE.get(), 32), 10, 5, 0.05f));
			event.getTrades().get(1).add(new BasicItemListing(new ItemStack(Items.EMERALD, 24),

					new ItemStack(MountainsPoemModItems.TOKEN.get(), 32), 10, 5, 0.05f));
		}
		if (event.getType() == MountainsPoemModVillagerProfessions.JADE_MASON.get()) {
			event.getTrades().get(5).add(new BasicItemListing(new ItemStack(Items.EMERALD, 16), new ItemStack(MountainsPoemModBlocks.UNDER_ROCK_BRICKS.get(), 6), new ItemStack(MountainsPoemModBlocks.JADE_CARVER.get(), 3), 10, 5, 0.05f));
			event.getTrades().get(5).add(new BasicItemListing(new ItemStack(Items.EMERALD, 11),

					new ItemStack(MountainsPoemModItems.JINYU_JADE.get(), 8), 10, 5, 0.05f));
			event.getTrades().get(5).add(new BasicItemListing(new ItemStack(Items.EMERALD, 14),

					new ItemStack(MountainsPoemModBlocks.JADE_CONG.get(), 3), 10, 5, 0.05f));
			event.getTrades().get(5).add(new BasicItemListing(new ItemStack(Items.EMERALD, 32),

					new ItemStack(MountainsPoemModBlocks.ALGAE_JADE_BLOCK.get(), 8), 10, 5, 0.05f));
		}
		if (event.getType() == VillagerProfession.FARMER) {
			event.getTrades().get(3).add(new BasicItemListing(new ItemStack(Items.EMERALD, 16),

					new ItemStack(MountainsPoemModItems.GREEN_ONION.get(), 28), 10, 5, 0.05f));
			event.getTrades().get(3).add(new BasicItemListing(new ItemStack(Items.EMERALD, 16),

					new ItemStack(MountainsPoemModItems.GINGER.get(), 28), 10, 5, 0.05f));
			event.getTrades().get(3).add(new BasicItemListing(new ItemStack(Items.EMERALD, 16),

					new ItemStack(MountainsPoemModItems.GARLIC.get(), 28), 10, 5, 0.05f));
		}
		if (event.getType() == VillagerProfession.BUTCHER) {
			event.getTrades().get(1).add(new BasicItemListing(new ItemStack(MountainsPoemModItems.LEI_MEAT.get(), 8),

					new ItemStack(Items.EMERALD, 11), 10, 8, 0.05f));
			event.getTrades().get(1).add(new BasicItemListing(new ItemStack(MountainsPoemModItems.BOYI_LEG.get(), 8),

					new ItemStack(Items.EMERALD, 21), 10, 8, 0.05f));
			event.getTrades().get(1).add(new BasicItemListing(new ItemStack(MountainsPoemModItems.WHITE_FOX_MEAT.get(), 8),

					new ItemStack(Items.EMERALD, 21), 10, 8, 0.05f));
			event.getTrades().get(1).add(new BasicItemListing(new ItemStack(MountainsPoemModItems.WHITE_MONKEY_MEAT.get(), 7),

					new ItemStack(Items.EMERALD, 13), 10, 8, 0.05f));
			event.getTrades().get(1).add(new BasicItemListing(new ItemStack(MountainsPoemModItems.HUN_MEAT.get(), 7),

					new ItemStack(Items.EMERALD, 13), 10, 8, 0.05f));
			event.getTrades().get(1).add(new BasicItemListing(new ItemStack(MountainsPoemModItems.QING_GENG_MEAT.get(), 7),

					new ItemStack(Items.EMERALD, 13), 10, 8, 0.05f));
			event.getTrades().get(1).add(new BasicItemListing(new ItemStack(MountainsPoemModItems.LEI_MEAT_SAUCE.get()),

					new ItemStack(Items.EMERALD, 34), 10, 15, 0.05f));
			event.getTrades().get(1).add(new BasicItemListing(new ItemStack(MountainsPoemModItems.BOYI_MEAT_SAUCE.get()),

					new ItemStack(Items.EMERALD, 34), 10, 15, 0.05f));
			event.getTrades().get(1).add(new BasicItemListing(new ItemStack(MountainsPoemModItems.LONG_CHI_MEAT.get(), 8),

					new ItemStack(Items.EMERALD, 11), 10, 8, 0.05f));
			event.getTrades().get(1).add(new BasicItemListing(new ItemStack(MountainsPoemModItems.CHANGFU_CHICKEN.get(), 8),

					new ItemStack(Items.EMERALD, 11), 10, 8, 0.05f));
			event.getTrades().get(1).add(new BasicItemListing(new ItemStack(MountainsPoemModItems.CHANGFU_CHICKEN_SAUCE.get()),

					new ItemStack(Items.EMERALD, 34), 10, 15, 0.05f));
		}
		if (event.getType() == VillagerProfession.BUTCHER) {
			event.getTrades().get(4).add(new BasicItemListing(new ItemStack(Items.BOWL), new ItemStack(Items.EMERALD, 32), new ItemStack(MountainsPoemModItems.ZHUYU_AND_ONION_SOUP.get()), 10, 15, 0.05f));
			event.getTrades().get(4).add(new BasicItemListing(new ItemStack(Items.EMERALD, 16),

					new ItemStack(MountainsPoemModItems.LEI_MEAT_SAUCE.get()), 10, 5, 0.05f));
			event.getTrades().get(4).add(new BasicItemListing(new ItemStack(Items.EMERALD, 14),

					new ItemStack(MountainsPoemModItems.BOYI_MEAT_SAUCE.get()), 10, 5, 0.05f));
		}
	}
}
