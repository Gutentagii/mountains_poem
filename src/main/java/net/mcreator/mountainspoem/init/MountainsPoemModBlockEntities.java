
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.mountainspoem.init;

import net.mcreator.mountainspoem.block.entity.ZunbottleBlockEntity;
import net.mcreator.mountainspoem.block.entity.WhiteJianGrassMatCoveredSacrificialTableBlockEntity;
import net.mcreator.mountainspoem.block.entity.SacrificialTableBlockEntity;
import net.mcreator.mountainspoem.block.entity.JianmeibambooBlockEntity;
import net.mcreator.mountainspoem.block.entity.JadeCarverBlockEntity;
import net.mcreator.mountainspoem.block.entity.HollowMudBricksBlockEntity;
import net.mcreator.mountainspoem.block.entity.GuiBasketBlockEntity;
import net.mcreator.mountainspoem.block.entity.CopperZunBottleZhiBlockEntity;
import net.mcreator.mountainspoem.block.entity.CopperZunBottleZhengBlockEntity;
import net.mcreator.mountainspoem.block.entity.CopperZunBottleSouthMountainsGodBlockEntity;
import net.mcreator.mountainspoem.block.entity.CopperZunBottlePiglinBlockEntity;
import net.mcreator.mountainspoem.block.entity.CopperZunBottleLongChiBlockEntity;
import net.mcreator.mountainspoem.block.entity.CopperZunBottleLeiBlockEntity;
import net.mcreator.mountainspoem.block.entity.CopperZunBottleEnderDragonBlockEntity;
import net.mcreator.mountainspoem.block.entity.CopperZunBottleChickenBlockEntity;
import net.mcreator.mountainspoem.block.entity.CopperZunBottleChangfuBlockEntity;
import net.mcreator.mountainspoem.block.entity.CopperZunBottleBoshiBlockEntity;
import net.mcreator.mountainspoem.block.entity.CopperZunBottleBlockEntity;
import net.mcreator.mountainspoem.block.entity.CopperGuiBlockEntity;
import net.mcreator.mountainspoem.block.entity.CopperDouLeiMeatSauceBlockEntity;
import net.mcreator.mountainspoem.block.entity.CopperDouChangfuChickenSauceBlockEntity;
import net.mcreator.mountainspoem.block.entity.CopperDouBoyiMeatSauceBlockEntity;
import net.mcreator.mountainspoem.MountainsPoemMod;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class MountainsPoemModBlockEntities {
	public static final DeferredRegister<BlockEntityType<?>> REGISTRY = DeferredRegister.create(ForgeRegistries.BLOCK_ENTITY_TYPES, MountainsPoemMod.MODID);
	public static final RegistryObject<BlockEntityType<?>> JIANMEIBAMBOO = register("jianmeibamboo", MountainsPoemModBlocks.JIANMEIBAMBOO, JianmeibambooBlockEntity::new);
	public static final RegistryObject<BlockEntityType<?>> ZUNBOTTLE = register("zunbottle", MountainsPoemModBlocks.ZUNBOTTLE, ZunbottleBlockEntity::new);
	public static final RegistryObject<BlockEntityType<?>> GUI_BASKET = register("gui_basket", MountainsPoemModBlocks.GUI_BASKET, GuiBasketBlockEntity::new);
	public static final RegistryObject<BlockEntityType<?>> SACRIFICIAL_TABLE = register("sacrificial_table", MountainsPoemModBlocks.SACRIFICIAL_TABLE, SacrificialTableBlockEntity::new);
	public static final RegistryObject<BlockEntityType<?>> HOLLOW_MUD_BRICKS = register("hollow_mud_bricks", MountainsPoemModBlocks.HOLLOW_MUD_BRICKS, HollowMudBricksBlockEntity::new);
	public static final RegistryObject<BlockEntityType<?>> WHITE_JIAN_GRASS_MAT_COVERED_SACRIFICIAL_TABLE = register("white_jian_grass_mat_covered_sacrificial_table", MountainsPoemModBlocks.WHITE_JIAN_GRASS_MAT_COVERED_SACRIFICIAL_TABLE,
			WhiteJianGrassMatCoveredSacrificialTableBlockEntity::new);
	public static final RegistryObject<BlockEntityType<?>> JADE_CARVER = register("jade_carver", MountainsPoemModBlocks.JADE_CARVER, JadeCarverBlockEntity::new);
	public static final RegistryObject<BlockEntityType<?>> COPPER_ZUN_BOTTLE = register("copper_zun_bottle", MountainsPoemModBlocks.COPPER_ZUN_BOTTLE, CopperZunBottleBlockEntity::new);
	public static final RegistryObject<BlockEntityType<?>> COPPER_ZUN_BOTTLE_BOYI = register("copper_zun_bottle_boyi", MountainsPoemModBlocks.COPPER_ZUN_BOTTLE_BOYI, CopperZunBottleBoshiBlockEntity::new);
	public static final RegistryObject<BlockEntityType<?>> COPPER_ZUN_BOTTLE_CHANGFU = register("copper_zun_bottle_changfu", MountainsPoemModBlocks.COPPER_ZUN_BOTTLE_CHANGFU, CopperZunBottleChangfuBlockEntity::new);
	public static final RegistryObject<BlockEntityType<?>> COPPER_ZUN_BOTTLE_CHICKEN = register("copper_zun_bottle_chicken", MountainsPoemModBlocks.COPPER_ZUN_BOTTLE_CHICKEN, CopperZunBottleChickenBlockEntity::new);
	public static final RegistryObject<BlockEntityType<?>> COPPER_ZUN_BOTTLE_PIGLIN = register("copper_zun_bottle_piglin", MountainsPoemModBlocks.COPPER_ZUN_BOTTLE_PIGLIN, CopperZunBottlePiglinBlockEntity::new);
	public static final RegistryObject<BlockEntityType<?>> COPPER_GUI = register("copper_gui", MountainsPoemModBlocks.COPPER_GUI, CopperGuiBlockEntity::new);
	public static final RegistryObject<BlockEntityType<?>> COPPER_DOU_LEI_MEAT_SAUCE = register("copper_dou_lei_meat_sauce", MountainsPoemModBlocks.COPPER_DOU_LEI_MEAT_SAUCE, CopperDouLeiMeatSauceBlockEntity::new);
	public static final RegistryObject<BlockEntityType<?>> COPPER_DOU_BOYI_MEAT_SAUCE = register("copper_dou_boyi_meat_sauce", MountainsPoemModBlocks.COPPER_DOU_BOYI_MEAT_SAUCE, CopperDouBoyiMeatSauceBlockEntity::new);
	public static final RegistryObject<BlockEntityType<?>> COPPER_DOU_CHANGFU_CHICKEN_SAUCE = register("copper_dou_changfu_chicken_sauce", MountainsPoemModBlocks.COPPER_DOU_CHANGFU_CHICKEN_SAUCE, CopperDouChangfuChickenSauceBlockEntity::new);
	public static final RegistryObject<BlockEntityType<?>> COPPER_ZUN_BOTTLE_LEI = register("copper_zun_bottle_lei", MountainsPoemModBlocks.COPPER_ZUN_BOTTLE_LEI, CopperZunBottleLeiBlockEntity::new);
	public static final RegistryObject<BlockEntityType<?>> COPPER_ZUN_BOTTLE_LONG_CHI = register("copper_zun_bottle_long_chi", MountainsPoemModBlocks.COPPER_ZUN_BOTTLE_LONG_CHI, CopperZunBottleLongChiBlockEntity::new);
	public static final RegistryObject<BlockEntityType<?>> COPPER_ZUN_BOTTLE_ZHENG = register("copper_zun_bottle_zheng", MountainsPoemModBlocks.COPPER_ZUN_BOTTLE_ZHENG, CopperZunBottleZhengBlockEntity::new);
	public static final RegistryObject<BlockEntityType<?>> COPPER_ZUN_BOTTLE_ENDER_DRAGON = register("copper_zun_bottle_ender_dragon", MountainsPoemModBlocks.COPPER_ZUN_BOTTLE_ENDER_DRAGON, CopperZunBottleEnderDragonBlockEntity::new);
	public static final RegistryObject<BlockEntityType<?>> COPPER_ZUN_BOTTLE_SOUTH_MOUNTAINS_GOD = register("copper_zun_bottle_south_mountains_god", MountainsPoemModBlocks.COPPER_ZUN_BOTTLE_SOUTH_MOUNTAINS_GOD,
			CopperZunBottleSouthMountainsGodBlockEntity::new);
	public static final RegistryObject<BlockEntityType<?>> COPPER_ZUN_BOTTLE_ZHI = register("copper_zun_bottle_zhi", MountainsPoemModBlocks.COPPER_ZUN_BOTTLE_ZHI, CopperZunBottleZhiBlockEntity::new);

	private static RegistryObject<BlockEntityType<?>> register(String registryname, RegistryObject<Block> block, BlockEntityType.BlockEntitySupplier<?> supplier) {
		return REGISTRY.register(registryname, () -> BlockEntityType.Builder.of(supplier, block.get()).build(null));
	}
}
