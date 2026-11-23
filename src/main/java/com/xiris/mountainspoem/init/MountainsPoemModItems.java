
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package com.xiris.mountainspoem.init;

import com.xiris.mountainspoem.entity.BronzeDevourerEntity;
import com.xiris.mountainspoem.item.*;
//import dev.architectury.core.item.ArchitecturySpawnEggItem;
//import dev.architectury.registry.registries.DeferredRegister;
//import dev.architectury.registry.registries.RegistrySupplier;
import com.xiris.mountainspoem.MountainsPoemMod;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.ForgeSpawnEggItem;
import net.minecraftforge.fml.common.Mod;
import net.minecraft.world.item.SpawnEggItem;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import org.jetbrains.annotations.Nullable;

import java.util.function.Supplier;

@Mod.EventBusSubscriber(modid = MountainsPoemMod.MOD_ID)
public class MountainsPoemModItems {
    public static final DeferredRegister<Item> REGISTRY = DeferredRegister.create(ForgeRegistries.ITEMS, MountainsPoemMod.MOD_ID);

    public static final RegistryObject<SpawnEggItem> RED_RU_SPAWN_EGG = REGISTRY.register("red_ru_spawn_egg",
            () -> new ForgeSpawnEggItem(
                    MountainsPoemModEntities.RED_RU,
                    -10092544,
                    -13434880,
                    new Item.Properties().stacksTo(64)
            )
    );
    public static final RegistryObject<SpawnEggItem> LEI_SPAWN_EGG = REGISTRY.register("lei_spawn_egg",
            () -> new ForgeSpawnEggItem(MountainsPoemModEntities.LEI, -16764109, -16751002, new Item.Properties().stacksTo(64))
    );
    public static final RegistryObject<SpawnEggItem> XUAN_TORTOISE_SPAWN_EGG = REGISTRY.register("xuan_tortoise_spawn_egg",
            () -> new ForgeSpawnEggItem(MountainsPoemModEntities.XUAN_TORTOISE, -15000805, -41449, new Item.Properties().stacksTo(64))
    );
    public static final RegistryObject<SpawnEggItem> CHANGFU_CHICKEN_SPAWN_EGG = REGISTRY.register("changfu_chicken_spawn_egg",
            () -> new ForgeSpawnEggItem(MountainsPoemModEntities.CHANGFU_CHICKEN, -4292332, -10092544, new Item.Properties().stacksTo(64))
    );
    public static final RegistryObject<SpawnEggItem> LUFISH_SPAWN_EGG = REGISTRY.register("lufish_spawn_egg",
            () -> new ForgeSpawnEggItem(MountainsPoemModEntities.LUFISH, -10092544, -9231353, new Item.Properties().stacksTo(64))
    );
    public static final RegistryObject<SpawnEggItem> WOOD_WORMS_SPAWN_EGG = REGISTRY.register("wood_worms_spawn_egg",
            () -> new ForgeSpawnEggItem(MountainsPoemModEntities.WOOD_WORMS, -7501495, -10326996, new Item.Properties().stacksTo(64))
    );
    public static final RegistryObject<SpawnEggItem> BOYI_GOAT_SPAWN_EGG = REGISTRY.register("boyi_goat_spawn_egg",
            () -> new ForgeSpawnEggItem(MountainsPoemModEntities.BOYI_GOAT, -2825748, -13952502, new Item.Properties().stacksTo(64))
    );
    public static final RegistryObject<SpawnEggItem> WHITE_APE_SPAWN_EGG = REGISTRY.register("white_ape_spawn_egg",
            () -> new ForgeSpawnEggItem(MountainsPoemModEntities.WHITE_APE, -1907998, -15461356, new Item.Properties().stacksTo(64))
    );
    public static final RegistryObject<SpawnEggItem> NINE_TAILED_FOX_SPAWN_EGG = REGISTRY.register("nine_tailed_fox_spawn_egg",
            () -> new ForgeSpawnEggItem(MountainsPoemModEntities.NINE_TAILED_FOX, -1574407, -8543589, new Item.Properties().stacksTo(64))
    );
    public static final RegistryObject<SpawnEggItem> GU_EAGLE_SPAWN_EGG = REGISTRY.register("gu_eagle_spawn_egg",
            () -> new ForgeSpawnEggItem(MountainsPoemModEntities.GU_EAGLE, -16751002, -13743281, new Item.Properties().stacksTo(64))
    );
    public static final RegistryObject<SpawnEggItem> FEI_BULL_SPAWN_EGG = REGISTRY.register("fei_bull_spawn_egg",
            () -> new ForgeSpawnEggItem(MountainsPoemModEntities.FEI_BULL, -9406663, -15199732, new Item.Properties().stacksTo(64))
    );
    public static final RegistryObject<SpawnEggItem> LUSHUHORSE_SPAWN_EGG = REGISTRY.register("lushuhorse_spawn_egg",
            () -> new ForgeSpawnEggItem(MountainsPoemModEntities.LUSHUHORSE, -2724839, -14155005, new Item.Properties().stacksTo(64))
    );
    public static final RegistryObject<SpawnEggItem> ZUO_COW_SPAWN_EGG = REGISTRY.register("zuo_cow_spawn_egg",
            () -> new ForgeSpawnEggItem(MountainsPoemModEntities.ZUO_COW, -4286899, -13299702, new Item.Properties().stacksTo(64))
    );
    public static final RegistryObject<SpawnEggItem> MIN_QU_BIRD_SPAWN_EGG = REGISTRY.register("min_qu_bird_spawn_egg",
            () -> new ForgeSpawnEggItem(MountainsPoemModEntities.MIN_QU_BIRD, -16448765, -1739718, new Item.Properties().stacksTo(64))
    );
    public static final RegistryObject<SpawnEggItem> XIAN_GOAT_SPAWN_EGG = REGISTRY.register("xian_goat_spawn_egg",
            () -> new ForgeSpawnEggItem(MountainsPoemModEntities.XIAN_GOAT, -2897720, -13492717, new Item.Properties().stacksTo(64))
    );
    public static final RegistryObject<SpawnEggItem> ZHI_SPAWN_EGG = REGISTRY.register("zhi_spawn_egg",
            () -> new ForgeSpawnEggItem(MountainsPoemModEntities.ZHI, -26368, -1916798, new Item.Properties().stacksTo(64))
    );
    public static final RegistryObject<SpawnEggItem> FENGHUANG_PHOENIX_SPAWN_EGG = REGISTRY.register("fenghuang_phoenix_spawn_egg",
            () -> new ForgeSpawnEggItem(MountainsPoemModEntities.FENGHUANG_PHOENIX, -13395712, -52480, new Item.Properties().stacksTo(64))
    );
    public static final RegistryObject<SpawnEggItem> ZHENG_SPAWN_EGG = REGISTRY.register("zheng_spawn_egg",
            () -> new ForgeSpawnEggItem(MountainsPoemModEntities.ZHENG, -1615049, -13235456, new Item.Properties().stacksTo(64)));
    public static final RegistryObject<SpawnEggItem> AO_YIN_SPAWN_EGG = REGISTRY.register("ao_yin_spawn_egg",
            () -> new ForgeSpawnEggItem(MountainsPoemModEntities.AO_YIN, -16317440, -16777216, new Item.Properties().stacksTo(64)));
    public static final RegistryObject<SpawnEggItem> WATER_HORSE_SPAWN_EGG = REGISTRY.register("water_horse_spawn_egg",
            () -> new ForgeSpawnEggItem(MountainsPoemModEntities.WATER_HORSE, -13871258, -16312788, new Item.Properties().stacksTo(64))
    );
    public static final RegistryObject<SpawnEggItem> QING_GENG_BIRD_SPAWN_EGG = REGISTRY.register("qing_geng_bird_spawn_egg",
            () -> new ForgeSpawnEggItem(MountainsPoemModEntities.QING_GENG_BIRD, -13382656, -16724788, new Item.Properties().stacksTo(64))
    );
    public static final RegistryObject<SpawnEggItem> HUN_HORSE_SPAWN_EGG = REGISTRY.register("hun_horse_spawn_egg",
            () -> new ForgeSpawnEggItem(MountainsPoemModEntities.HUN_HORSE, -5927295, -10990525, new Item.Properties().stacksTo(64))
    );
    public static final RegistryObject<SpawnEggItem> HUA_SNAKE_SPAWN_EGG = REGISTRY.register("hua_snake_spawn_egg",
            () -> new ForgeSpawnEggItem(MountainsPoemModEntities.HUA_SNAKE, -39424, -16750951, new Item.Properties().stacksTo(64))
    );
    public static final RegistryObject<SpawnEggItem> RIVER_MERMAN_SPAWN_EGG = REGISTRY.register("river_merman_spawn_egg",
            () -> new ForgeSpawnEggItem(MountainsPoemModEntities.RIVER_MERMAN, -16751002, -11975869, new Item.Properties().stacksTo(64))
    );
    public static final RegistryObject<SpawnEggItem> SHAN_GAO_PIG_SPAWN_EGG = REGISTRY.register("shan_gao_pig_spawn_egg",
            () -> new ForgeSpawnEggItem(MountainsPoemModEntities.SHAN_GAO_PIG, -39322, -13434880, new Item.Properties().stacksTo(64))
    );
    public static final RegistryObject<SpawnEggItem> HANGED_GHOST_SPAWN_EGG = REGISTRY.register("hanged_ghost_spawn_egg",
            () -> new ForgeSpawnEggItem(MountainsPoemModEntities.HANGED_GHOST, -5182999, -5128514, new Item.Properties().stacksTo(64))
    );
    public static final RegistryObject<SpawnEggItem> IMPERIAL_EXAMINATION_GHOST_SPAWN_EGG = REGISTRY.register("imperial_examination_ghost_spawn_egg",
            () -> new ForgeSpawnEggItem(MountainsPoemModEntities.IMPERIAL_EXAMINATION_GHOST, -6750208, -16777216, new Item.Properties().stacksTo(64))
    );
    public static final RegistryObject<SpawnEggItem> WANDERING_GHOST_SPAWN_EGG = REGISTRY.register("wandering_ghost_spawn_egg",
            () -> new ForgeSpawnEggItem(MountainsPoemModEntities.WANDERING_GHOST, -7303056, -6177610, new Item.Properties().stacksTo(64))
    );
    public static final RegistryObject<SpawnEggItem> HUAN_SPAWN_EGG = REGISTRY.register("huan_spawn_egg",
            () -> new ForgeSpawnEggItem(MountainsPoemModEntities.HUAN, -15516606, -1313875, new Item.Properties().stacksTo(64))
    );
    public static final RegistryObject<SpawnEggItem> UNDER_GHOST_SPAWN_EGG = REGISTRY.register("under_ghost_spawn_egg",
            () -> new ForgeSpawnEggItem(MountainsPoemModEntities.UNDER_GHOST, -3022161, -15853311, new Item.Properties().stacksTo(64))
    );
    public static final RegistryObject<SpawnEggItem> SOUL_SHARD_SPAWN_EGG = REGISTRY.register("soul_shard_spawn_egg",
            () -> new ForgeSpawnEggItem(MountainsPoemModEntities.SOUL_SHARD, -10381160, -3421237, new Item.Properties().stacksTo(64))
    );
    public static final RegistryObject<SpawnEggItem> LONG_CHI_SPAWN_EGG = REGISTRY.register("long_chi_spawn_egg",
            () -> new ForgeSpawnEggItem(MountainsPoemModEntities.LONG_CHI, -5332895, -7840204, new Item.Properties().stacksTo(64))
    );
    public static final RegistryObject<SpawnEggItem> ZHU_HUAI_SPAWN_EGG = REGISTRY.register("zhu_huai_spawn_egg",
            () -> new ForgeSpawnEggItem(MountainsPoemModEntities.ZHU_HUAI, -7175089, -15132391, new Item.Properties().stacksTo(64))
    );
    public static final RegistryObject<SpawnEggItem> JUFU_SPAWN_EGG = REGISTRY.register("jufu_spawn_egg",
            () -> new ForgeSpawnEggItem(MountainsPoemModEntities.JUFU, -1454165, -9818076, new Item.Properties().stacksTo(64))
    );
    public static final RegistryObject<SpawnEggItem> CRIMSON_XUAN_TORTOISE_SPAWN_EGG = REGISTRY.register("crimson_xuan_tortoise_spawn_egg",
            () -> new ForgeSpawnEggItem(MountainsPoemModEntities.CRIMSON_XUAN_TORTOISE, -15000805, -6750208, new Item.Properties().stacksTo(64))
    );
    public static final RegistryObject<SpawnEggItem> LOONG_HEAD_HORSE_BODY_GOD_SPAWN_EGG = REGISTRY.register("loong_head_horse_body_god_spawn_egg",
            () -> new ForgeSpawnEggItem(MountainsPoemModEntities.LOONG_HEAD_HORSE_BODY_GOD, -3637993, -2765930, new Item.Properties().stacksTo(64))
    );
    public static final RegistryObject<SpawnEggItem> SOUTHERN_MOUNTAINS_GOD_HEAD_SPAWN_EGG = REGISTRY.register("southern_mountains_god_head_spawn_egg",
            () -> new ForgeSpawnEggItem(MountainsPoemModEntities.SOUTHERN_MOUNTAINS_GOD_HEAD, -10128525, -12437191, new Item.Properties().stacksTo(64))
    );
    public static final RegistryObject<SpawnEggItem> FURIOUS_SOUTHERN_MOUNTAINS_GOD_HEAD_SPAWN_EGG = REGISTRY.register("furious_southern_mountains_god_head_spawn_egg",
            () -> new ForgeSpawnEggItem(MountainsPoemModEntities.FURIOUS_SOUTHERN_MOUNTAINS_GOD_HEAD, -6581369, -10477536, new Item.Properties().stacksTo(64))
    );
    public static final RegistryObject<SpawnEggItem> BRONZE_DEVOURER_SPAWN_EGG = REGISTRY.register("bronze_devourer_spawn_egg",
            () -> new ForgeSpawnEggItem(MountainsPoemModEntities.BRONZE_DEVOURER, -4682920, -13282754, new Item.Properties().stacksTo(64))
    );


    public static final RegistryObject<Item> BRONZE_DEVOURER_EXPOSED_SPAWN_EGG = REGISTRY.register("bronze_devourer_exposed_spawn_egg",
            () -> new ForgeSpawnEggItem(
                    MountainsPoemModEntities.BRONZE_DEVOURER,
                    -4682920,
                    -13282754,
                    new Item.Properties().stacksTo(64)
            ) {
                @Override
                public InteractionResult useOn(UseOnContext context) {
                    if (!context.getLevel().isClientSide) {
                        BlockPos pos = context.getClickedPos().above();
                        Entity entity = MountainsPoemModEntities.BRONZE_DEVOURER.get().create(context.getLevel());
                        entity.getPersistentData().putBoolean("Exposed", true);
                        entity.setPos(pos.getX() + 0.5, pos.getY(), pos.getZ() + 0.5);
                        context.getLevel().addFreshEntity(entity);
                        if (!context.getPlayer().isCreative()) {
                            context.getItemInHand().shrink(1);
                        }
                    }
                    return InteractionResult.SUCCESS;
                }
            }
    );

    public static final RegistryObject<Item> BRONZE_DEVOURER_WEATHERED_SPAWN_EGG = REGISTRY.register("bronze_devourer_weathered_spawn_egg",
            () -> new ForgeSpawnEggItem(MountainsPoemModEntities.BRONZE_DEVOURER, -4682920, -13282754, new Item.Properties().stacksTo(64)) {
                @Override
                public InteractionResult useOn(UseOnContext context) {
                    if (!context.getLevel().isClientSide()) {
                        BlockPos pos = context.getClickedPos().above();
                        Entity entity = MountainsPoemModEntities.BRONZE_DEVOURER.get().create(context.getLevel());
                        entity.getPersistentData().putBoolean("Exposed", true);
                        entity.getPersistentData().putBoolean("Weathered", true);
                        entity.setPos(pos.getX() + 0.5, pos.getY(), pos.getZ() + 0.5);
                        context.getLevel().addFreshEntity(entity);
                        if (!context.getPlayer().isCreative()) context.getItemInHand().shrink(1);
                    }
                    return InteractionResult.SUCCESS;
                }
            }
    );

    public static final RegistryObject<Item> BRONZE_DEVOURER_WAXED_SPAWN_EGG = REGISTRY.register("bronze_devourer_waxed_spawn_egg",
            () -> new ForgeSpawnEggItem(MountainsPoemModEntities.BRONZE_DEVOURER, -4682920, -13282754, new Item.Properties().stacksTo(64)) {
                @Override
                public InteractionResult useOn(UseOnContext context) {
                    if (!context.getLevel().isClientSide()) {
                        BlockPos pos = context.getClickedPos().above();
                        Entity entity = MountainsPoemModEntities.BRONZE_DEVOURER.get().create(context.getLevel());
                        entity.getPersistentData().putBoolean("Waxed", true);
                        entity.setPos(pos.getX() + 0.5, pos.getY(), pos.getZ() + 0.5);
                        context.getLevel().addFreshEntity(entity);
                        if (!context.getPlayer().isCreative()) context.getItemInHand().shrink(1);
                    }
                    return InteractionResult.SUCCESS;
                }
            }
    );

    public static final RegistryObject<Item> BRONZE_DEVOURER_EXPOSED_WAXED_SPAWN_EGG = REGISTRY.register("bronze_devourer_exposed_waxed_spawn_egg",
            () -> new ForgeSpawnEggItem(MountainsPoemModEntities.BRONZE_DEVOURER, -4682920, -13282754, new Item.Properties().stacksTo(64)) {
                @Override
                public InteractionResult useOn(UseOnContext context) {
                    if (!context.getLevel().isClientSide()) {
                        BlockPos pos = context.getClickedPos().above();
                        Entity entity = MountainsPoemModEntities.BRONZE_DEVOURER.get().create(context.getLevel());
                        entity.getPersistentData().putBoolean("Exposed", true);
                        entity.getPersistentData().putBoolean("Waxed", true);
                        entity.setPos(pos.getX() + 0.5, pos.getY(), pos.getZ() + 0.5);
                        context.getLevel().addFreshEntity(entity);
                        if (!context.getPlayer().isCreative()) context.getItemInHand().shrink(1);
                    }
                    return InteractionResult.SUCCESS;
                }
            }
    );

    public static final RegistryObject<Item> BRONZE_DEVOURER_WEATHERED_WAXED_SPAWN_EGG = REGISTRY.register("bronze_devourer_weathered_waxed_spawn_egg",
            () -> new ForgeSpawnEggItem(MountainsPoemModEntities.BRONZE_DEVOURER, -4682920, -13282754, new Item.Properties().stacksTo(64)) {
                @Override
                public InteractionResult useOn(UseOnContext context) {
                    if (!context.getLevel().isClientSide()) {
                        BlockPos pos = context.getClickedPos().above();
                        Entity entity = MountainsPoemModEntities.BRONZE_DEVOURER.get().create(context.getLevel());
                        entity.getPersistentData().putBoolean("Exposed", true);
                        entity.getPersistentData().putBoolean("Weathered", true);
                        entity.getPersistentData().putBoolean("Waxed", true);
                        entity.setPos(pos.getX() + 0.5, pos.getY(), pos.getZ() + 0.5);
                        context.getLevel().addFreshEntity(entity);
                        if (!context.getPlayer().isCreative()) context.getItemInHand().shrink(1);
                    }
                    return InteractionResult.SUCCESS;
                }
            }
    );

    public static final RegistryObject<Item> BOYI_LEATHER = REGISTRY.register("boyi_leather", BoshileatherItem::new);
    public static final RegistryObject<Item> JIANMEIBAMBOO = block(MountainsPoemModBlocks.JIANMEIBAMBOO);
    public static final RegistryObject<Item> BLOODCOPPER = REGISTRY.register("bloodcopper", BloodcopperItem::new);
    public static final RegistryObject<Item> BLOODCOPPERPLATE = REGISTRY.register("bloodcopperplate", BloodcopperplateItem::new);
    public static final RegistryObject<Item> YAN_LOG = block(MountainsPoemModBlocks.YAN_LOG);
    public static final RegistryObject<Item> YAN_LEAVES = block(MountainsPoemModBlocks.YAN_LEAVES);
    public static final RegistryObject<Item> WHITEJADE = REGISTRY.register("whitejade", WhitejadeItem::new);
    public static final RegistryObject<Item> GREENJADE = REGISTRY.register("greenjade", GreenjadeItem::new);
    public static final RegistryObject<Item> MP_JADE_RING = REGISTRY.register("mp_jade_ring", IuikhuanItem::new);
    public static final RegistryObject<Item> JADETABLET = REGISTRY.register("jadetablet", JadetabletItem::new);
    public static final RegistryObject<Item> RED_CLOTH = REGISTRY.register("red_cloth", RedclothItem::new);
    public static final RegistryObject<Item> RED_CLOTH_PIECE = REGISTRY.register("red_cloth_piece", RedclothpieceItem::new);
    public static final RegistryObject<Item> BLOOD_COPPER_SWORD = REGISTRY.register("blood_copper_sword", BloodcopperswordItem::new);
    public static final RegistryObject<Item> JADEPIECE = REGISTRY.register("jadepiece", JadepieceItem::new);
    public static final RegistryObject<Item> XUN_LEAVES = block(MountainsPoemModBlocks.XUN_LEAVES);
    public static final RegistryObject<Item> XUN_LEAVES_BERRIES = REGISTRY.register("xun_leaves_berries", XunyearberryItem::new);
    public static final RegistryObject<Item> GILDED_COPPER_BLOCK = block(MountainsPoemModBlocks.GILDED_COPPER_BLOCK);
    public static final RegistryObject<Item> JIANG_LOG = block(MountainsPoemModBlocks.JIANG_LOG);
    public static final RegistryObject<Item> JIANG_LEAVES = block(MountainsPoemModBlocks.JIANG_LEAVES);
    public static final RegistryObject<Item> XUAN_SCALE = REGISTRY.register("xuan_scale", XuanscaleItem::new);
    public static final RegistryObject<Item> XUAN_HELMET_HELMET = REGISTRY.register("xuan_scute_helmet", XuanhelmetItem.Helmet::new);
    public static final RegistryObject<Item> BLOOD_COPPER_ORE = block(MountainsPoemModBlocks.BLOOD_COPPER_ORE);
    public static final RegistryObject<Item> YAN_PLANKS = block(MountainsPoemModBlocks.YAN_PLANKS);
    public static final RegistryObject<Item> YAN_STAIRS = block(MountainsPoemModBlocks.YAN_STAIRS);
    public static final RegistryObject<Item> YAN_SLAB = block(MountainsPoemModBlocks.YAN_SLAB);
    public static final RegistryObject<Item> YAN_FENCE = block(MountainsPoemModBlocks.YAN_FENCE);
    public static final RegistryObject<Item> YAN_FENCE_GATE = block(MountainsPoemModBlocks.YAN_FENCE_GATE);
    public static final RegistryObject<Item> YAN_PRESSURE_PLATE = block(MountainsPoemModBlocks.YAN_PRESSURE_PLATE);
    public static final RegistryObject<Item> YAN_BUTTON = block(MountainsPoemModBlocks.YAN_BUTTON);
    public static final RegistryObject<Item> YAN_WOOD = block(MountainsPoemModBlocks.YAN_WOOD);
    public static final RegistryObject<Item> JIANG_PLANKS = block(MountainsPoemModBlocks.JIANG_PLANKS);
    public static final RegistryObject<Item> JIANG_STAIRS = block(MountainsPoemModBlocks.JIANG_STAIRS);
    public static final RegistryObject<Item> JIANG_SLAB = block(MountainsPoemModBlocks.JIANG_SLAB);
    public static final RegistryObject<Item> JIANG_FENCE = block(MountainsPoemModBlocks.JIANG_FENCE);
    public static final RegistryObject<Item> JIANG_FENCE_GATE = block(MountainsPoemModBlocks.JIANG_FENCE_GATE);
    public static final RegistryObject<Item> JIANG_PRESSURE_PLATE = block(MountainsPoemModBlocks.JIANG_PRESSURE_PLATE);
    public static final RegistryObject<Item> JIANG_BUTTON = block(MountainsPoemModBlocks.JIANG_BUTTON);
    public static final RegistryObject<Item> JADE_ORE = block(MountainsPoemModBlocks.JADE_ORE);
    public static final RegistryObject<Item> JIANG_WOOD = block(MountainsPoemModBlocks.JIANG_WOOD);
    public static final RegistryObject<Item> HUANG_GUAN_WOOD = block(MountainsPoemModBlocks.HUANG_GUAN_WOOD);
    public static final RegistryObject<Item> HUANG_GUAN_LOG = block(MountainsPoemModBlocks.HUANG_GUAN_LOG);
    public static final RegistryObject<Item> HUANG_GUAN_PLANKS = block(MountainsPoemModBlocks.HUANG_GUAN_PLANKS);
    public static final RegistryObject<Item> HUANG_GUAN_LEAVES = block(MountainsPoemModBlocks.HUANG_GUAN_LEAVES);
    public static final RegistryObject<Item> HUANG_GUAN_STAIRS = block(MountainsPoemModBlocks.HUANG_GUAN_STAIRS);
    public static final RegistryObject<Item> HUANG_GUAN_SLAB = block(MountainsPoemModBlocks.HUANG_GUAN_SLAB);
    public static final RegistryObject<Item> HUANG_GUAN_FENCE = block(MountainsPoemModBlocks.HUANG_GUAN_FENCE);
    public static final RegistryObject<Item> HUANG_GUAN_FENCE_GATE = block(MountainsPoemModBlocks.HUANG_GUAN_FENCE_GATE);
    public static final RegistryObject<Item> HUANG_GUAN_PRESSURE_PLATE = block(MountainsPoemModBlocks.HUANG_GUAN_PRESSURE_PLATE);
    public static final RegistryObject<Item> HUANG_GUAN_BUTTON = block(MountainsPoemModBlocks.HUANG_GUAN_BUTTON);
    public static final RegistryObject<Item> SHATANG_WOOD = block(MountainsPoemModBlocks.SHATANG_WOOD);
    public static final RegistryObject<Item> SHATANG_LOG = block(MountainsPoemModBlocks.SHATANG_LOG);
    public static final RegistryObject<Item> SHATANG_PLANKS = block(MountainsPoemModBlocks.SHATANG_PLANKS);
    public static final RegistryObject<Item> SHATANG_LEAVES = block(MountainsPoemModBlocks.SHATANG_LEAVES);
    public static final RegistryObject<Item> SHATANG_STAIRS = block(MountainsPoemModBlocks.SHATANG_STAIRS);
    public static final RegistryObject<Item> SHATANG_SLAB = block(MountainsPoemModBlocks.SHATANG_SLAB);
    public static final RegistryObject<Item> SHATANG_FENCE = block(MountainsPoemModBlocks.SHATANG_FENCE);
    public static final RegistryObject<Item> SHATANG_FENCE_GATE = block(MountainsPoemModBlocks.SHATANG_FENCE_GATE);
    public static final RegistryObject<Item> SHATANG_PRESSURE_PLATE = block(MountainsPoemModBlocks.SHATANG_PRESSURE_PLATE);
    public static final RegistryObject<Item> SHATANG_BUTTON = block(MountainsPoemModBlocks.SHATANG_BUTTON);
    public static final RegistryObject<Item> PAN_WOOD = block(MountainsPoemModBlocks.PAN_WOOD);
    public static final RegistryObject<Item> PAN_LOG = block(MountainsPoemModBlocks.PAN_LOG);
    public static final RegistryObject<Item> PAN_PLANKS = block(MountainsPoemModBlocks.PAN_PLANKS);
    public static final RegistryObject<Item> PAN_LEAVES = block(MountainsPoemModBlocks.PAN_LEAVES);
    public static final RegistryObject<Item> PAN_STAIRS = block(MountainsPoemModBlocks.PAN_STAIRS);
    public static final RegistryObject<Item> PAN_SLAB = block(MountainsPoemModBlocks.PAN_SLAB);
    public static final RegistryObject<Item> PAN_FENCE = block(MountainsPoemModBlocks.PAN_FENCE);
    public static final RegistryObject<Item> PAN_FENCE_GATE = block(MountainsPoemModBlocks.PAN_FENCE_GATE);
    public static final RegistryObject<Item> PAN_PRESSURE_PLATE = block(MountainsPoemModBlocks.PAN_PRESSURE_PLATE);
    public static final RegistryObject<Item> PAN_BUTTON = block(MountainsPoemModBlocks.PAN_BUTTON);
    public static final RegistryObject<Item> DUHENG_FLOWER = doubleBlock(MountainsPoemModBlocks.DUHENG_FLOWER);
    public static final RegistryObject<Item> ALGAE_JADE_BLOCK = block(MountainsPoemModBlocks.ALGAE_JADE_BLOCK);
    public static final RegistryObject<Item> JADE_BLOCK = block(MountainsPoemModBlocks.JADE_BLOCK);
    public static final RegistryObject<Item> SHATANG_FRUIT = REGISTRY.register("shatang_fruit", ShatangFruitItem::new);
    public static final RegistryObject<Item> LEI_TEETH = REGISTRY.register("lei_teeth", LeiTeethItem::new);
    public static final RegistryObject<Item> DANFRUIT = REGISTRY.register("danfruit", DanfruitItem::new);
    public static final RegistryObject<Item> WHITE_FOX_MEAT = REGISTRY.register("white_fox_meat", WhiteFoxMeatItem::new);
    public static final RegistryObject<Item> WHITE_APE_MEAT = REGISTRY.register("white_ape_meat", WhiteMonkeyMeatItem::new);
    public static final RegistryObject<Item> JADE_PASTE = REGISTRY.register("jade_paste", JadePasteItem::new);
    public static final RegistryObject<Item> JADE_PASTE_BUCKET = REGISTRY.register("jade_paste_bucket", JadePasteBucketItem::new);
    public static final RegistryObject<Item> WOODS_WORMS = REGISTRY.register("woods_worms", WoodsWormsItem::new);
    //public static final RegistryObject<Item> BIG_CARROTS = REGISTRY.register("big_carrots", BigCarrotsItem::new);
    public static final RegistryObject<Item> JIANG_STICK = REGISTRY.register("jiang_stick", NewjaingstickItem::new);
    public static final RegistryObject<Item> JADE_BUTTON = block(MountainsPoemModBlocks.JADE_BUTTON);
    public static final RegistryObject<Item> CARNELIAN = REGISTRY.register("carnelian", CarnelianItem::new);
    public static final RegistryObject<Item> YAN_FRUIT = REGISTRY.register("yan_fruit", YanFruitItem::new);
    public static final RegistryObject<Item> RED_RU_FISH = REGISTRY.register("red_ru_fish", RedRuFishItem::new);
    public static final RegistryObject<Item> COOKED_RED_RU_FISH = REGISTRY.register("cooked_red_ru_fish", CookedRedRuFishItem::new);
    public static final RegistryObject<Item> COOKED_WHITE_APE_MEAT = REGISTRY.register("cooked_white_ape_meat", CookedWhiteMonkeyMeatItem::new);
    public static final RegistryObject<Item> COOKED_FOX_MEAT = REGISTRY.register("cooked_fox_meat", CookedFoxMeatItem::new);
    public static final RegistryObject<Item> WHITE_FOX_FUR = REGISTRY.register("white_fox_fur", WhiteFoxLeatherItem::new);
    public static final RegistryObject<Item> YAN_TRAPDOOR = block(MountainsPoemModBlocks.YAN_TRAPDOOR);
    public static final RegistryObject<Item> JIANG_TRAPDOOR = block(MountainsPoemModBlocks.JIANG_TRAPDOOR);
    public static final RegistryObject<Item> JIANG_DOOR = doubleBlock(MountainsPoemModBlocks.JIANG_DOOR);
    public static final RegistryObject<Item> YAN_DOOR = doubleBlock(MountainsPoemModBlocks.YAN_DOOR);
    public static final RegistryObject<Item> SHATANG_TRAPDOOR = block(MountainsPoemModBlocks.SHATANG_TRAPDOOR);
    public static final RegistryObject<Item> SHATANG_DOOR = doubleBlock(MountainsPoemModBlocks.SHATANG_DOOR);
    public static final RegistryObject<Item> PAN_TRAPDOOR = block(MountainsPoemModBlocks.PAN_TRAPDOOR);
    public static final RegistryObject<Item> PAN_DOOR = doubleBlock(MountainsPoemModBlocks.PAN_DOOR);
    public static final RegistryObject<Item> HUANG_GUAN_TRAPDOOR = block(MountainsPoemModBlocks.HUANG_GUAN_TRAPDOOR);
    public static final RegistryObject<Item> HUANG_GUAN_DOOR = doubleBlock(MountainsPoemModBlocks.HUANG_GUAN_DOOR);
    public static final RegistryObject<Item> PEACH_BLOSSOM_WOOD = block(MountainsPoemModBlocks.PEACH_BLOSSOM_WOOD);
    public static final RegistryObject<Item> PEACH_BLOSSOM_LOG = block(MountainsPoemModBlocks.PEACH_BLOSSOM_LOG);
    public static final RegistryObject<Item> PEACH_BLOSSOM_PLANKS = block(MountainsPoemModBlocks.PEACH_BLOSSOM_PLANKS);
    public static final RegistryObject<Item> PEACH_BLOSSOM_LEAVES = block(MountainsPoemModBlocks.PEACH_BLOSSOM_LEAVES);
    public static final RegistryObject<Item> PEACH_BLOSSOM_STAIRS = block(MountainsPoemModBlocks.PEACH_BLOSSOM_STAIRS);
    public static final RegistryObject<Item> PEACH_BLOSSOM_SLAB = block(MountainsPoemModBlocks.PEACH_BLOSSOM_SLAB);
    public static final RegistryObject<Item> PEACH_BLOSSOM_FENCE = block(MountainsPoemModBlocks.PEACH_BLOSSOM_FENCE);
    public static final RegistryObject<Item> PEACH_BLOSSOM_FENCE_GATE = block(MountainsPoemModBlocks.PEACH_BLOSSOM_FENCE_GATE);
    public static final RegistryObject<Item> PEACH_BLOSSOM_PRESSURE_PLATE = block(MountainsPoemModBlocks.PEACH_BLOSSOM_PRESSURE_PLATE);
    public static final RegistryObject<Item> PEACH_BLOSSOM_BUTTON = block(MountainsPoemModBlocks.PEACH_BLOSSOM_BUTTON);
    public static final RegistryObject<Item> PEACH_BLOSSOM_DOOR = doubleBlock(MountainsPoemModBlocks.PEACH_BLOSSOM_DOOR);
    public static final RegistryObject<Item> PEACH_BLOSSOM_TRAPDOOR = block(MountainsPoemModBlocks.PEACH_BLOSSOM_TRAPDOOR);
    public static final RegistryObject<Item> TOKEN = REGISTRY.register("token", TokenItem::new);
    public static final RegistryObject<Item> PLAGUE_HORN = REGISTRY.register("plague_horn", PlagueHornItem::new);
    public static final RegistryObject<Item> LUSH_DIRT = block(MountainsPoemModBlocks.LUSH_DIRT);
    public static final RegistryObject<Item> LUSH_GRASS_BLOCK = block(MountainsPoemModBlocks.LUSH_GRASS_BLOCK);
    public static final RegistryObject<Item> DARK_SPRUCE_LOG = block(MountainsPoemModBlocks.DARK_SPRUCE_LOG);
    public static final RegistryObject<Item> JINYU_JADE = REGISTRY.register("jinyu_jade", JinyuJadeItem::new);
    public static final RegistryObject<Item> STRIPPED_YAN_LOG = block(MountainsPoemModBlocks.STRIPPED_YAN_LOG);
    public static final RegistryObject<Item> STRIPPED_HUANG_GUAN_LOG = block(MountainsPoemModBlocks.STRIPPED_HUANG_GUAN_LOG);
    public static final RegistryObject<Item> STRIPPED_SHATANG_LOG = block(MountainsPoemModBlocks.STRIPPED_SHATANG_LOG);
    public static final RegistryObject<Item> STRIPPED_JIANG_LOG = block(MountainsPoemModBlocks.STRIPPED_JIANG_LOG);
    public static final RegistryObject<Item> STRIPPED_PAN_LOG = block(MountainsPoemModBlocks.STRIPPED_PAN_LOG);
    public static final RegistryObject<Item> STRIPPED_PEACH_BLOSSOM_LOG = block(MountainsPoemModBlocks.STRIPPED_PEACH_BLOSSOM_LOG);
    public static final RegistryObject<Item> STRIPPED_YAN_WOOD = block(MountainsPoemModBlocks.STRIPPED_YAN_WOOD);
    public static final RegistryObject<Item> STRIPPED_HUANG_GUAN_WOOD = block(MountainsPoemModBlocks.STRIPPED_HUANG_GUAN_WOOD);
    public static final RegistryObject<Item> STRIPPED_JIANG_WOOD = block(MountainsPoemModBlocks.STRIPPED_JIANG_WOOD);
    public static final RegistryObject<Item> STRIPPED_SHA_TANG_WOOD = block(MountainsPoemModBlocks.STRIPPED_SHA_TANG_WOOD);
    public static final RegistryObject<Item> STRIPPED_PAN_WOOD = block(MountainsPoemModBlocks.STRIPPED_PAN_WOOD);
    public static final RegistryObject<Item> STRIPPED_PEACH_BLOSSOM_WOOD = block(MountainsPoemModBlocks.STRIPPED_PEACH_BLOSSOM_WOOD);
    public static final RegistryObject<Item> WHITE_FOX_COAT = REGISTRY.register("white_fox_coat", WhiteArmorItem.Chestplate::new);
    public static final RegistryObject<Item> UNDER_ROCK = block(MountainsPoemModBlocks.UNDER_ROCK);
    public static final RegistryObject<Item> UNDER_ROCK_BRICKS = block(MountainsPoemModBlocks.UNDER_ROCK_BRICKS);
    public static final RegistryObject<Item> UNDER_DIRT = block(MountainsPoemModBlocks.UNDER_DIRT);
    public static final RegistryObject<Item> UNDER_GRASS_BLOCK = block(MountainsPoemModBlocks.UNDER_GRASS_BLOCK);
    public static final RegistryObject<Item> HUN_MEAT = REGISTRY.register("hun_meat", HunMeatItem::new);
    public static final RegistryObject<Item> COOKED_HUN_MEAT = REGISTRY.register("cooked_hun_meat", CookedHunMeatItem::new);
    public static final RegistryObject<Item> DIP_OIL_VINES = REGISTRY.register("dip_oil_vines", DipOilVinesItem::new);
    public static final RegistryObject<Item> DIP_OIL_VINES_PLATE = REGISTRY.register("dip_oil_vines_plate", DipOilVinesPlateItem::new);
    public static final Supplier<VinesArmorsItem> VINES_ARMORS_HELMET = REGISTRY.register("vines_armors_helmet", () -> new VinesArmorsItem(ArmorItem.Type.HELMET, new Item.Properties()));
    public static final Supplier<VinesArmorsItem> VINES_ARMORS_CHESTPLATE = REGISTRY.register("vines_armors_chestplate", () -> new VinesArmorsItem(ArmorItem.Type.CHESTPLATE, new Item.Properties()));
    public static final RegistryObject<Item> LEI_MEAT = REGISTRY.register("lei_meat", LeiMeatItem::new);
    public static final RegistryObject<Item> COOKED_LEI_MEAT = REGISTRY.register("cooked_lei_meat", CookedLeiMeatItem::new);
    public static final RegistryObject<Item> CHANGFU_CHICKEN = REGISTRY.register("changfu_chicken", ChangfuChickenItem::new);
    public static final RegistryObject<Item> COOKED_CHANGFU_CHICKEN = REGISTRY.register("cooked_changfu_chicken", CookedChangfuChickenItem::new);
    public static final RegistryObject<Item> WET_DIP_OIL_VINES = REGISTRY.register("wet_dip_oil_vines", WetDipOilVinesItem::new);
    public static final RegistryObject<Item> QING_GENG_MEAT = REGISTRY.register("qing_geng_meat", QingGengMeatItem::new);
    public static final RegistryObject<Item> COOKED_QING_GENG_MEAT = REGISTRY.register("cooked_qing_geng_meat", CookedQingGengMeatItem::new);
    public static final RegistryObject<Item> LEI_MANE = REGISTRY.register("lei_mane", LeiManeItem::new);
    public static final RegistryObject<Item> LUSHU_HORSE_HAIR = REGISTRY.register("lushu_horse_hair", LushuHorseHairItem::new);
    public static final RegistryObject<Item> XIAN_GOAT_FAT = REGISTRY.register("xian_goat_fat", XianGoatFatItem::new);
    public static final RegistryObject<Item> XIAN_GOAT_OIL_BOTTLE = REGISTRY.register("xian_goat_oil_bottle", AnimalOilBottleItem::new);
    public static final RegistryObject<Item> DRY_VINES = REGISTRY.register("dry_vines", DryVinesItem::new);
    public static final RegistryObject<Item> KNOWLEDGE_BAMBOO_SLIPS = REGISTRY.register("knowledge_bamboo_slips", KnowledgeBambooSlipsItem::new);
    public static final RegistryObject<Item> PLAGUE_HALBERD = REGISTRY.register("plague_halberd", PlagueHalberdItem::new);
    public static final RegistryObject<Item> BOYI_LEG = REGISTRY.register("boyi_leg", RawBoshiLegItem::new);
    public static final RegistryObject<Item> COOKED_BOYI_LEG = REGISTRY.register("cooked_boyi_leg", CookedBoshiLegItem::new);
    public static final RegistryObject<Item> RAW_LUFISH = REGISTRY.register("raw_lufish", RawLufishItem::new);
    public static final RegistryObject<Item> COOKED_LUFISH = REGISTRY.register("cooked_lufish", CookedLufishItem::new);
    public static final RegistryObject<Item> SANGUINE_SAND = block(MountainsPoemModBlocks.SANGUINE_SAND);
    public static final RegistryObject<Item> WUTIAO_GRASS = block(MountainsPoemModBlocks.WUTIAO_GRASS);
    public static final RegistryObject<Item> RONG_GRASS_TUBER = REGISTRY.register("rong_grass_tuber", RongGrassTuberItem::new);
    public static final RegistryObject<Item> RONG_GRASS = block(MountainsPoemModBlocks.RONG_GRASS);
    public static final RegistryObject<Item> ZHUYU_GRASS = block(MountainsPoemModBlocks.ZHUYU_GRASS);
    public static final RegistryObject<Item> UNDER_IRON_PIECE = REGISTRY.register("under_iron_piece", UnderIronPieceItem::new);
    public static final RegistryObject<Item> UNDER_IRONS = REGISTRY.register("under_irons", UnderIronsItem::new);
    public static final RegistryObject<Item> UNDER_IRON_ORE = block(MountainsPoemModBlocks.UNDER_IRON_ORE);
    public static final RegistryObject<Item> PUREED_RONG_GRASS_TUBER = REGISTRY.register("pureed_rong_grass_tuber", PureedRongGrassTuberItem::new);
    public static final RegistryObject<Item> GUI_BASKET = block(MountainsPoemModBlocks.GUI_BASKET);
    public static final RegistryObject<Item> UNDER_ROCK_GOLD_ORE = block(MountainsPoemModBlocks.UNDER_ROCK_GOLD_ORE);
    public static final RegistryObject<Item> ZHUYU_AND_ONION_SOUP = REGISTRY.register("zhuyu_and_onion_soup", ZhuyuAndOnionSoupInAWoodenBowlItem::new);
    public static final RegistryObject<Item> GREEN_ROCK = block(MountainsPoemModBlocks.GREEN_ROCK);
    public static final RegistryObject<Item> BROWN_LEI_MANE = REGISTRY.register("brown_lei_mane", BrownLeiManeItem::new);
    public static final RegistryObject<Item> ZHENG_SALIVA = REGISTRY.register("zheng_saliva", ZhengSalivaItem::new);
    public static final RegistryObject<Item> SACRIFICIAL_TABLE = block(MountainsPoemModBlocks.SACRIFICIAL_TABLE);
    public static final RegistryObject<Item> WHITE_JIAN_GRASS_MAT = block(MountainsPoemModBlocks.WHITE_JIAN_GRASS_MAT);
    public static final RegistryObject<Item> HOLLOW_MUD_BRICKS = block(MountainsPoemModBlocks.HOLLOW_MUD_BRICKS);
    public static final RegistryObject<Item> UNDER_ROCK_STAIRS = block(MountainsPoemModBlocks.UNDER_ROCK_STAIRS);
    public static final RegistryObject<Item> UNDER_ROCK_SLAB = block(MountainsPoemModBlocks.UNDER_ROCK_SLAB);
    public static final RegistryObject<Item> UNDER_ROCK_FENCE = block(MountainsPoemModBlocks.UNDER_ROCK_FENCE);
    public static final RegistryObject<Item> UNDER_ROCK_WALL = block(MountainsPoemModBlocks.UNDER_ROCK_WALL);
    public static final RegistryObject<Item> UNDER_ROCK_BRICK_STAIRS = block(MountainsPoemModBlocks.UNDER_ROCK_BRICK_STAIRS);
    public static final RegistryObject<Item> UNDER_ROCK_BRICK_SLAB = block(MountainsPoemModBlocks.UNDER_ROCK_BRICK_SLAB);
    public static final RegistryObject<Item> UNDER_ROCK_BRICK_WALL = block(MountainsPoemModBlocks.UNDER_ROCK_BRICK_WALL);
    public static final RegistryObject<Item> UNDER_ROCK_BRICK_FENCE = block(MountainsPoemModBlocks.UNDER_ROCK_BRICK_FENCE);
    public static final RegistryObject<Item> WHITE_JIAN_GRASS_MAT_COVERED_SACRIFICIAL_TABLE = block(MountainsPoemModBlocks.WHITE_JIAN_GRASS_MAT_COVERED_SACRIFICIAL_TABLE);
    public static final RegistryObject<Item> XUAN_SHELLS = REGISTRY.register("xuan_shells", XuanShellsItem::new);
    public static final RegistryObject<Item> TRIUMPH_XUAN_SHELLS = REGISTRY.register("triumph_xuan_shells", TriumphXuanShellsItem::new);
    public static final RegistryObject<Item> CHIVALROUS_XUAN_SHELLS = REGISTRY.register("chivalrous_xuan_shells", ChivalrousXuanShellsItem::new);
    public static final RegistryObject<Item> HARVEST_XUAN_SHELLS = REGISTRY.register("harvest_xuan_shells", HarvestXuanShellsItem::new);
    public static final RegistryObject<Item> VITALITY_XUAN_SHELLS = REGISTRY.register("vitality_xuan_shells", VitalityXuanShellsItem::new);
    public static final RegistryObject<Item> RAIN_XUAN_SHELLS = REGISTRY.register("rain_xuan_shells", RainXuanShellsItem::new);
    public static final RegistryObject<Item> THRONE_XUAN_SHELLS = REGISTRY.register("throne_xuan_shells", ThroneXuanShellsItem::new);
    public static final RegistryObject<Item> GU_EAGLE_FEATHER = REGISTRY.register("gu_eagle_feather", GuEagleFeatherItem::new);
    public static final RegistryObject<Item> THE_SOUTHERN_MOUNTAIN_JADE_PENDANT = REGISTRY.register("the_southern_mountain_jade_pendant", TheSouthernMountainJadePendantItem::new);
    public static final RegistryObject<Item> WHITE_JIAN_GRASS = block(MountainsPoemModBlocks.WHITE_JIAN_GRASS);
    public static final RegistryObject<Item> JADE_CONG = block(MountainsPoemModBlocks.JADE_CONG);
    public static final RegistryObject<Item> SAILING_XUAN_SHELLS = REGISTRY.register("sailing_xuan_shells", SailingXuanShellsItem::new);
    public static final RegistryObject<Item> HUNT_XUAN_SHELLS = REGISTRY.register("hunt_xuan_shells", HuntXuanShellsItem::new);
    public static final RegistryObject<Item> HEALTH_XUAN_SHELLS = REGISTRY.register("health_xuan_shells", HealthXuanShellsItem::new);
    public static final RegistryObject<Item> IMMORTALITY_XUAN_SHELLS = REGISTRY.register("immortality_xuan_shells", ImmortalityXuanShellsItem::new);
    public static final RegistryObject<Item> WISDOM_XUAN_SHELLS = REGISTRY.register("wisdom_xuan_shells", WisdomXuanShellsItem::new);
    public static final RegistryObject<Item> EVENTIDE_HORN = REGISTRY.register("eventide_horn", EventideHornItem::new);
    public static final RegistryObject<Item> ICY_FANGS = REGISTRY.register("icy_fangs", IcyFangsItem::new);
    //public static final RegistryObject<Item> FLASHING_FUR = REGISTRY.register("flashing_fur", FlashingFurItem::new);
    //public static final RegistryObject<Item> VITALITY_FEATHER = REGISTRY.register("vitality_feather", VitalityFeatherItem::new);
    //public static final RegistryObject<Item> TWISTED_CLAWS = REGISTRY.register("twisted_claws", TwistedClawsItem::new);
    public static final RegistryObject<Item> ETERNAL_HEART = REGISTRY.register("eternal_heart", EternalHeartItem::new);
    //public static final RegistryObject<Item> DARK_FEATHER = REGISTRY.register("dark_feather", DarkFeatherItem::new);
    public static final RegistryObject<Item> INFERIOR_JADE = REGISTRY.register("inferior_jade", InferiorJadeItem::new);
    public static final RegistryObject<Item> UNDER_IRON_SWORD = REGISTRY.register("under_iron_sword", UnderIronSwordItem::new);
    public static final RegistryObject<Item> SCINTILLATION_ENGRAVED_XUAN_SHELLS = REGISTRY.register("scintillation_engraved_xuan_shells", ScintillationEngravedXuanShellsItem::new);
    public static final RegistryObject<Item> GANLIN_ENGRAVED_XUAN_SHELLS = REGISTRY.register("ganlin_engraved_xuan_shells", GanlinEngravedXuanShellsItem::new);
    public static final RegistryObject<Item> DAZZLING_STAR_ENGRAVED_XUAN_SHELLS = REGISTRY.register("dazzling_star_engraved_xuan_shells", DazzlingStarEngravedXuanShellsItem::new);
    public static final RegistryObject<Item> RUST_ENGRAVED_XUAN_SHELLS = REGISTRY.register("rust_engraved_xuan_shells", RustEngravedXuanShellsItem::new);
    public static final RegistryObject<Item> SCARLET_TWILIGHT_ENGRAVED_XUAN_SHELLS = REGISTRY.register("scarlet_twilight_engraved_xuan_shells", ScarletTwilightEngravedXuanShellsItem::new);
    public static final RegistryObject<Item> DUSTY_SOIL_ENGRAVED_XUAN_SHELLS = REGISTRY.register("dusty_soil_engraved_xuan_shells", DustySoilEngravedXuanShellsItem::new);
    public static final RegistryObject<Item> WHITE_CLOTH = REGISTRY.register("white_cloth", WhiteClothItem::new);
    public static final RegistryObject<Item> JADE_CARVER = block(MountainsPoemModBlocks.JADE_CARVER);
    public static final RegistryObject<Item> LUSHU_LEATHER = REGISTRY.register("lushu_leather", LushuLeatherItem::new);
    public static final RegistryObject<Item> WROUGHT_PATTERN_ZUN = REGISTRY.register("wrought_pattern_zun", WroughtPatternZunItem::new);
    public static final RegistryObject<Item> BLANK_TOTEM_SCROLLS = REGISTRY.register("blank_totem_scrolls", BlankTotemScrollsItem::new);
    public static final RegistryObject<Item> BOYI_TOTEM_SCROLLS = REGISTRY.register("boyi_totem_scrolls", BoshiTotemScrollsItem::new);
    public static final RegistryObject<Item> CHANGFU_TOTEM_SCROLLS = REGISTRY.register("changfu_totem_scrolls", ChangfuTotemScrollsItem::new);
    public static final RegistryObject<Item> COPPER_ZUN_BOTTLE = block(MountainsPoemModBlocks.COPPER_ZUN_BOTTLE);
    public static final RegistryObject<Item> UNDER_ROCK_QUARTZ_ORE = block(MountainsPoemModBlocks.UNDER_ROCK_QUARTZ_ORE);
    public static final RegistryObject<Item> PLAGUE_HORN_CORE = REGISTRY.register("plague_horn_core", PlagueHornCoreItem::new);
    public static final RegistryObject<Item> TEETH_GRAVER = REGISTRY.register("teeth_graver", TeethGraverItem::new);
    public static final RegistryObject<Item> THE_SECOND_SOUTHERN_MOUNTAIN_JADE_PENDANT = REGISTRY.register("the_second_southern_mountain_jade_pendant", TheSecondSouthernMountainJadePendantItem::new);
    public static final RegistryObject<Item> ZHUYU_GRASS_JUICE = REGISTRY.register("zhuyu_grass_juice", ZhuyuGrassJuiceItem::new);
    public static final RegistryObject<Item> LEI_STEW = REGISTRY.register("lei_stew", LeiStewInAWoodenBowlItem::new);
    public static final RegistryObject<Item> BLOCK_OF_UNDER_IRON = block(MountainsPoemModBlocks.BLOCK_OF_UNDER_IRON);
    public static final RegistryObject<Item> BLOCK_OF_BLOOD_COPPER = block(MountainsPoemModBlocks.BLOCK_OF_BLOOD_COPPER);
    public static final RegistryObject<Item> DEEPSLATE_JADE_ORE = block(MountainsPoemModBlocks.DEEPSLATE_JADE_ORE);
    public static final RegistryObject<Item> DEEPSLATE_BLOOD_COPPER_ORE = block(MountainsPoemModBlocks.DEEPSLATE_BLOOD_COPPER_ORE);
    public static final RegistryObject<Item> PEACH_BLOSSOM_STICK = REGISTRY.register("peach_blossom_stick", PeachBlossomStickItem::new);
    public static final RegistryObject<Item> RESENTFUL_LEAD = REGISTRY.register("resentful_lead", ResentfulLeadItem::new);
    public static final RegistryObject<Item> GREEN_JADE_BLOCK = block(MountainsPoemModBlocks.GREEN_JADE_BLOCK);
    public static final RegistryObject<Item> ALGAE_JADE = REGISTRY.register("algae_jade", AlgaeJadeItem::new);
    public static final RegistryObject<Item> COPPER_ZUN_BOTTLE_BOYI = block(MountainsPoemModBlocks.COPPER_ZUN_BOTTLE_BOYI);
    public static final RegistryObject<Item> COPPER_ZUN_BOTTLE_CHANGFU = block(MountainsPoemModBlocks.COPPER_ZUN_BOTTLE_CHANGFU);
    public static final RegistryObject<Item> ENGRAVED_XUAN_SHELLS_CHANGFU = REGISTRY.register("engraved_xuan_shells_changfu", EngravedXuanShellsChangfuItem::new);
    public static final RegistryObject<Item> ENGRAVED_XUAN_SHELLS_BOYI = REGISTRY.register("engraved_xuan_shells_boyi", EngravedXuanShellsBoshiItem::new);
    public static final RegistryObject<Item> SCARLET_THORNS = block(MountainsPoemModBlocks.SCARLET_THORNS);
    public static final RegistryObject<Item> BLOODTHIRSTY_THORNS = doubleBlock(MountainsPoemModBlocks.BLOODTHIRSTY_THORNS);
    //public static final Supplier<TheBloodCopperItem> BLOOD_COPPER_HELMET = REGISTRY.register("blood_copper_helmet", () -> new TheBloodCopperItem(ArmorItem.Type.HELMET, new Item.Properties()));
    //public static final Supplier<TheBloodCopperItem> BLOOD_COPPER_CHESTPLATE = REGISTRY.register("blood_copper_chestplate", () -> new TheBloodCopperItem(ArmorItem.Type.CHESTPLATE, new Item.Properties()));
    public static final RegistryObject<Item> BLOOD_COPPER_HELMET = REGISTRY.register("blood_copper_helmet", TheBloodCopperArmorsArmorItem.Helmet::new);
    public static final RegistryObject<Item> BLOOD_COPPER_CHESTPLATE = REGISTRY.register("blood_copper_chestplate", TheBloodCopperArmorsArmorItem.Chestplate::new);
    public static final RegistryObject<Item> BLOOD_COPPER_LEGGINGS = REGISTRY.register("blood_copper_leggings", TheBloodCopperArmorsArmorItem.Leggings::new);
    public static final RegistryObject<Item> BLOOD_COPPER_BOOTS = REGISTRY.register("blood_copper_boots", TheBloodCopperArmorsArmorItem.Boots::new);
    public static final RegistryObject<Item> AO_YIN_FUR_COAT_CHESTPLATE = REGISTRY.register("ao_yin_fur_coat_chestplate", AoYinFurCoatArmorItem.Chestplate::new);
    //public static final Supplier<UnderIronItem> UNDER_IRON_HELMET = REGISTRY.register("under_iron_helmet", () -> new UnderIronItem(ArmorItem.Type.HELMET, new Item.Properties()));
    //public static final Supplier<UnderIronItem> UNDER_IRON_CHESTPLATE = REGISTRY.register("under_iron_chestplate", () -> new UnderIronItem(ArmorItem.Type.CHESTPLATE, new Item.Properties()));
    public static final RegistryObject<Item> UNDER_IRON_HELMET = REGISTRY.register("under_iron_helmet", UnderIrontItem.Helmet::new);
    public static final RegistryObject<Item> UNDER_IRON_CHESTPLATE = REGISTRY.register("under_iron_chestplate", UnderIrontItem.Chestplate::new);
    public static final RegistryObject<Item> UNDER_IRON_LEGGINGS = REGISTRY.register("under_iron_leggings", UnderIrontItem.Leggings::new);
    public static final RegistryObject<Item> UNDER_IRON_BOOTS = REGISTRY.register("under_iron_boots", UnderIrontItem.Boots::new);
    public static final RegistryObject<Item> WHITE_FOX_TAIL = REGISTRY.register("white_fox_tail", WhiteFoxTailItem::new);
    public static final RegistryObject<Item> THE_UNDER = REGISTRY.register("the_under", TheUnderItem::new);
    public static final RegistryObject<Item> SCARLET_THORN = REGISTRY.register("scarlet_thorn", ScarletThornItem::new);
    public static final RegistryObject<Item> UNDER_GRASS = block(MountainsPoemModBlocks.UNDER_GRASS);
    public static final RegistryObject<Item> WROUGHT_PATTERN_JUE = REGISTRY.register("wrought_pattern_jue", WroughtPatternJueItem::new);
    public static final RegistryObject<Item> COPPER_JUE = REGISTRY.register("copper_jue", CopperJueItem::new);
    public static final RegistryObject<Item> WATER_COPPER_JUE = REGISTRY.register("water_copper_jue", WaterCopperJueItem::new);
    public static final RegistryObject<Item> ZHUYU_COPPER_JUE = REGISTRY.register("zhuyu_copper_jue", ZhuyuCopperJueItem::new);
    public static final RegistryObject<Item> COPPER_SMALL_DING = block(MountainsPoemModBlocks.COPPER_SMALL_DING);
    public static final RegistryObject<Item> WROUGHT_PATTERN_SMALL_DING = REGISTRY.register("wrought_pattern_small_ding", WroughtPatternSmallDingItem::new);
    public static final RegistryObject<Item> MILK_COPPER_JUE = REGISTRY.register("milk_copper_jue", MilkCopperJueItem::new);
    public static final RegistryObject<Item> BOTTLE_OF_SOUL_SHARDS = REGISTRY.register("bottle_of_soul_shards", BottleOfSoulShardsItem::new);
    public static final RegistryObject<Item> UNDER_ARMOR_TRIM_SMITHING_TEMPLATE = REGISTRY.register("under_armor_trim_smithing_template", UnderArmorTrimSmithingTemplateItem::new);
    public static final RegistryObject<Item> SANGUINE_GRASS = block(MountainsPoemModBlocks.SANGUINE_GRASS);
    public static final RegistryObject<Item> UNDER_FLOWER = block(MountainsPoemModBlocks.UNDER_FLOWER);
    public static final RegistryObject<Item> SANGUINE_FLOWER = block(MountainsPoemModBlocks.SANGUINE_FLOWER);
    public static final RegistryObject<Item> SANGUINE_CACTUS = block(MountainsPoemModBlocks.SANGUINE_CACTUS);
    public static final RegistryObject<Item> TING_ZHU = doubleBlock(MountainsPoemModBlocks.TING_ZHU);
    public static final RegistryObject<Item> TING_ZHU_JUICE_BOTTLE = REGISTRY.register("ting_zhu_juice_bottle", TingZhuJuiceBottleItem::new);
    public static final RegistryObject<Item> TING_ZHU_JUICE_COPPER_JUE = REGISTRY.register("ting_zhu_juice_copper_jue", TingZhuJuiceCopperJueItem::new);
    public static final RegistryObject<Item> SANGUINE_SOIL = block(MountainsPoemModBlocks.SANGUINE_SOIL);
    public static final RegistryObject<Item> BLOOD_COPPER_INGOT = REGISTRY.register("blood_copper_ingot", BloodCopperIngotItem::new);
    public static final RegistryObject<Item> LEI_TEETH_SWORD = REGISTRY.register("lei_teeth_sword", LeiTeethSwordItem::new);
    public static final RegistryObject<Item> WRAPPED_CHANGFU_CHICKEN = REGISTRY.register("wrapped_changfu_chicken", WrappedChangfuChickenItem::new);
    public static final RegistryObject<Item> CHANGFU_CHICKEN_WRAPPED_IN_MUD = REGISTRY.register("changfu_chicken_wrapped_in_mud", ChangfuChickenWrappedInMudItem::new);
    public static final RegistryObject<Item> CHANGFU_CHICKEN_WRAPPED_IN_BURNT_MUD = REGISTRY.register("changfu_chicken_wrapped_in_burnt_mud", ChangfuChickenWrappedInBurntMudItem::new);
    public static final RegistryObject<Item> CONCOCTED_CHANGFU_CHICKEN = REGISTRY.register("concocted_changfu_chicken", ConcoctedChangfuChickenItem::new);
    public static final RegistryObject<Item> GINGER = REGISTRY.register("ginger", GingerItem::new);
    public static final RegistryObject<Item> GINGER_SLICES = REGISTRY.register("ginger_slices", GingerSlicesItem::new);
    public static final RegistryObject<Item> GREEN_ONION = REGISTRY.register("green_onion", GreenOnionItem::new);
    public static final RegistryObject<Item> GARLIC = REGISTRY.register("garlic", GarlicItem::new);
    public static final RegistryObject<Item> GARLIC_CLOVES = REGISTRY.register("garlic_cloves", GarlicClovesItem::new);
    public static final RegistryObject<Item> CHOPPED_GREEN_ONION = REGISTRY.register("chopped_green_onion", ChoppedGreenOnionItem::new);
    public static final RegistryObject<Item> WROUGHT_PATTERN_DOU = REGISTRY.register("wrought_pattern_dou", WroughtPatternDouItem::new);
    public static final RegistryObject<Item> LEI_MEAT_SAUCE = REGISTRY.register("lei_meat_sauce", LeiMeatSauceItem::new);
    public static final RegistryObject<Item> COPPER_DOU = block(MountainsPoemModBlocks.COPPER_DOU);
    public static final RegistryObject<Item> BOYI_MEAT_SAUCE = REGISTRY.register("boyi_meat_sauce", BoyiMeatSauceItem::new);
    public static final RegistryObject<Item> RICE = REGISTRY.register("rice", RiceItem::new);
    public static final RegistryObject<Item> SHATANG_FRUIT_COOKIE = REGISTRY.register("shatang_fruit_cookie", ShatangFruitCookieItem::new);
    public static final RegistryObject<Item> MOONCAKE_CRUST = REGISTRY.register("mooncake_crust", MooncakeCrustItem::new);
    public static final RegistryObject<Item> MOONCAKE_GINGER = REGISTRY.register("mooncake_ginger", MooncakeGingerItem::new);
    public static final RegistryObject<Item> SACRIFICE_ARMOR_TRIM_SMITHING_TEMPLATE = REGISTRY.register("sacrifice_armor_trim_smithing_template", SacrificeArmorTrimSmithingTemplateItem::new);
    public static final RegistryObject<Item> UNBAKED_MOONCAKE_GINGER = REGISTRY.register("unbaked_mooncake_ginger", UnbakedMooncakeGingerItem::new);
    public static final RegistryObject<Item> MOONCAKE_FRUITS = REGISTRY.register("mooncake_fruits", MooncakeFruitsItem::new);
    public static final RegistryObject<Item> UNBAKED_MOONCAKE_FRUITS = REGISTRY.register("unbaked_mooncake_fruits", UnbakedMooncakeFruitsItem::new);
    public static final RegistryObject<Item> MOONCAKE_CENTIPEDE = REGISTRY.register("mooncake_centipede", MooncakeCentipedeItem::new);
    public static final RegistryObject<Item> UNBAKED_MOONCAKE_CENTIPEDE = REGISTRY.register("unbaked_mooncake_centipede", UnbakedMooncakeCentipedeItem::new);
    public static final RegistryObject<Item> CENTIPEDE = REGISTRY.register("centipede", CentipedeItem::new);
    public static final RegistryObject<Item> COPPER_ZUN_BOTTLE_CHICKEN = block(MountainsPoemModBlocks.COPPER_ZUN_BOTTLE_CHICKEN);
    public static final RegistryObject<Item> ENGRAVED_XUAN_SHELLS_PIGLIN = REGISTRY.register("engraved_xuan_shells_piglin", EngravedXuanShellsPiglinItem::new);
    public static final RegistryObject<Item> ENGRAVED_XUAN_SHELLS_CHICKEN = REGISTRY.register("engraved_xuan_shells_chicken", EngravedXuanShellsChickenItem::new);
    public static final RegistryObject<Item> PIGLIN_TOTEM_SCROLLS = REGISTRY.register("piglin_totem_scrolls", PiglinTotemScrollsItem::new);
    public static final RegistryObject<Item> CHICKEN_TOTEM_SCROLLS = REGISTRY.register("chicken_totem_scrolls", ChickenTotemScrollsItem::new);
    public static final RegistryObject<Item> COPPER_YUE = REGISTRY.register("copper_yue", CopperYueItem::new);
    public static final RegistryObject<Item> WROUGHT_PATTERN_YUE = REGISTRY.register("wrought_pattern_yue", WroughtPatternYueItem::new);
    public static final RegistryObject<Item> COPPER_ZUN_BOTTLE_PIGLIN = block(MountainsPoemModBlocks.COPPER_ZUN_BOTTLE_PIGLIN);
    public static final RegistryObject<Item> COPPER_GUI = block(MountainsPoemModBlocks.COPPER_GUI);
    public static final RegistryObject<Item> WROUGHT_PATTERN_GUI = REGISTRY.register("wrought_pattern_gui", WroughtPatternGuiItem::new);
    public static final RegistryObject<Item> COPPER_DAGGER_AXE = REGISTRY.register("copper_dagger_axe", CopperDaggerAxeItem::new);
    public static final RegistryObject<Item> WROUGHT_PATTERN_DAGGER_AXE = REGISTRY.register("wrought_pattern_dagger_axe", WroughtPatternDaggerAxeItem::new);
    public static final RegistryObject<Item> LONG_CHI_MEAT = REGISTRY.register("long_chi_meat", LongChiMeatItem::new);
    public static final RegistryObject<Item> COOKED_LONG_CHI_MEAT = REGISTRY.register("cooked_long_chi_meat", CookedLongChiMeatItem::new);
    public static final RegistryObject<Item> MOONCAKE_EGG_YOLK = REGISTRY.register("mooncake_egg_yolk", MooncakeEggYolkItem::new);
    public static final RegistryObject<Item> UNBAKED_MOONCAKE_EGG_YOLK = REGISTRY.register("unbaked_mooncake_egg_yolk", UnbakedMooncakeEggYolkItem::new);
    public static final RegistryObject<Item> COBBLED_GREEN_ROCK = block(MountainsPoemModBlocks.COBBLED_GREEN_ROCK);
    public static final RegistryObject<Item> ELDER_LOONG_ARMOR_TRIM_SMITHING_TEMPLATE = REGISTRY.register("elder_loong_armor_trim_smithing_template", ElderLoongArmorTrimSmithingTemplateItem::new);
    public static final RegistryObject<Item> MANTOU = REGISTRY.register("mantou", MantouItem::new);
    public static final RegistryObject<Item> SWEET_RICE_CAKE = REGISTRY.register("sweet_rice_cake", SweetRiceCakeItem::new);
    public static final RegistryObject<Item> COPPER_DOU_LEI_MEAT_SAUCE = block(MountainsPoemModBlocks.COPPER_DOU_LEI_MEAT_SAUCE);
    public static final RegistryObject<Item> MANTOU_WITH_LEI_MEAT_SAUCE = REGISTRY.register("mantou_with_lei_meat_sauce", MantouWithLeiMeatSauceItem::new);
    public static final RegistryObject<Item> MANTOU_WITH_BOYI_MEAT_SAUCE = REGISTRY.register("mantou_with_boyi_meat_sauce", MantouWithBoyiMeatSauceItem::new);
    public static final RegistryObject<Item> COPPER_DOU_BOYI_MEAT_SAUCE = block(MountainsPoemModBlocks.COPPER_DOU_BOYI_MEAT_SAUCE);
    public static final RegistryObject<Item> MANTOU_SOAKED_IN_MUTTON_SOUP = REGISTRY.register("mantou_soaked_in_mutton_soup", MantouSoakedInMuttonSoupItem::new);
    public static final RegistryObject<Item> MANTOU_WITH_MEAT = REGISTRY.register("mantou_with_meat", MantouWithMeatItem::new);
    public static final RegistryObject<Item> COOKED_RICE = REGISTRY.register("cooked_rice", CookedRiceItem::new);
    public static final RegistryObject<Item> RAW_RICE = REGISTRY.register("raw_rice", RawRiceItem::new);
    public static final RegistryObject<Item> CHANGFU_CHICKEN_SAUCE = REGISTRY.register("changfu_chicken_sauce", ChangfuChickenSauceItem::new);
    public static final RegistryObject<Item> COPPER_DOU_CHANGFU_CHICKEN_SAUCE = block(MountainsPoemModBlocks.COPPER_DOU_CHANGFU_CHICKEN_SAUCE);
    public static final RegistryObject<Item> COOKED_RICE_WITH_LEI_MEAT_SAUCE = REGISTRY.register("cooked_rice_with_lei_meat_sauce", CookedRiceWithLeiMeatSauceItem::new);
    public static final RegistryObject<Item> MANTOU_WITH_CHANGFU_CHICKEN_SAUCE = REGISTRY.register("mantou_with_changfu_chicken_sauce", MantouWithChangfuChickenSauceItem::new);
    public static final RegistryObject<Item> COOKED_RICE_WITH_CHANGFU_CHICKEN_SAUCE = REGISTRY.register("cooked_rice_with_changfu_chicken_sauce", CookedRiceWithChangfuChickenSauceItem::new);
    public static final RegistryObject<Item> COOKED_RICE_WITH_BOYI_MEAT_SAUCE = REGISTRY.register("cooked_rice_with_boyi_meat_sauce", CookedRiceWithBoyiMeatSauceItem::new);
    public static final RegistryObject<Item> ICY_FANGS_MACE = REGISTRY.register("icy_fangs_mace", IcyFangsMaceItem::new);
    public static final RegistryObject<Item> PEACHWOOD_SWORD = REGISTRY.register("peachwood_sword", PeachwoodSwordItem::new);
    public static final RegistryObject<Item> MOONCAKE_HONEY = REGISTRY.register("mooncake_honey", MooncakeHoneyItem::new);
    public static final RegistryObject<Item> UNBAKED_MOONCAKE_HONEY = REGISTRY.register("unbaked_mooncake_honey", UnbakedMooncakeHoneyItem::new);
    
    public static final RegistryObject<Item> COLD_CRIMSON_FUNGUS_SALAD = REGISTRY.register("cold_crimson_fungus_salad", ColdCrimsonFungusSaladItem::new);
    public static final RegistryObject<Item> ANCIENT_FIVE_NUTS_MOONCAKE = REGISTRY.register("ancient_five_nuts_mooncake", AncientFiveNutsMooncakeItem::new);
    public static final RegistryObject<Item> UNBAKED_ANCIENT_FIVE_NUTS_MOONCAKE = REGISTRY.register("unbaked_ancient_five_nuts_mooncake", BakedAncientFiveNutsMooncakeItem::new);
    public static final RegistryObject<Item> SANGUINE_MOONCAKE = REGISTRY.register("sanguine_mooncake", SanguineMooncakeItem::new);
    public static final RegistryObject<Item> UNBAKED_SANGUINE_MOONCAKE = REGISTRY.register("unbaked_sanguine_mooncake", UnbakedSanguineMooncakeItem::new);
    public static final RegistryObject<Item> UNDER_FLOWER_MOONCAKE = REGISTRY.register("under_flower_mooncake", UnderFlowerMooncakeItem::new);
    public static final RegistryObject<Item> UNBAKED_UNDER_FLOWER_MOONCAKE = REGISTRY.register("unbaked_under_flower_mooncake", UnbakedUnderFlowerMooncakeItem::new);
    public static final RegistryObject<Item> ETERNAL_HEART_MOONCAKE = REGISTRY.register("eternal_heart_mooncake", EternalHeartMooncakeItem::new);
    public static final RegistryObject<Item> UNBAKED_ETERNAL_HEART_MOONCAKE = REGISTRY.register("unbaked_eternal_heart_mooncake", UnbakedEternalHeartMooncakeItem::new);
    public static final RegistryObject<Item> DARK_CUISINE_MOONCAKE = REGISTRY.register("dark_cuisine_mooncake", DarkCuisineMooncakeItem::new);
    public static final RegistryObject<Item> CLASSIC_SUPER_DARK_CUISINE_MOONCAKE = REGISTRY.register("classic_super_dark_cuisine_mooncake", ClassicSuperDarkCuisineMooncakeItem::new);
    public static final RegistryObject<Item> UNBAKED_CUISINE_MOONCAKE = REGISTRY.register("unbaked_cuisine_mooncake", UnbakedCuisineMooncakeItem::new);
    public static final RegistryObject<Item> YING_YANG_FLOWER = doubleBlock(MountainsPoemModBlocks.YING_YANG_FLOWER);
    public static final RegistryObject<Item> UNDER_ORCHID = doubleBlock(MountainsPoemModBlocks.UNDER_ORCHID);
    public static final RegistryObject<Item> BLOODTHIRSTY_CHRYSANTHEMUM = block(MountainsPoemModBlocks.BLOODTHIRSTY_CHRYSANTHEMUM);
    public static final RegistryObject<Item> BRONZE_JUG = block(MountainsPoemModBlocks.BRONZE_JUG);
    public static final RegistryObject<Item> BRONZE_XUAN = block(MountainsPoemModBlocks.BRONZE_XUAN);
    
    public static final RegistryObject<Item> THE_NINTH_CENTRAL_MOUNTAIN_JADE_PENDANT = REGISTRY.register("the_ninth_central_mountain_jade_pendant", TheNinthCentralMountainJadePendantItem::new);
    public static final RegistryObject<Item> LEI_TOTEM_SCROLLS = REGISTRY.register("lei_totem_scrolls", LeiTotemScrollsItem::new);
    public static final RegistryObject<Item> COPPER_ZUN_BOTTLE_LEI = block(MountainsPoemModBlocks.COPPER_ZUN_BOTTLE_LEI);
    public static final RegistryObject<Item> ENGRAVED_XUAN_SHELLS_LEI = REGISTRY.register("engraved_xuan_shells_lei", EngravedXuanShellsLeiItem::new);
    public static final RegistryObject<Item> LONG_CHI_TOTEM_SCROLLS = REGISTRY.register("long_chi_totem_scrolls", LongChiTotemScrollsItem::new);
    public static final RegistryObject<Item> COPPER_ZUN_BOTTLE_LONG_CHI = block(MountainsPoemModBlocks.COPPER_ZUN_BOTTLE_LONG_CHI);
    public static final RegistryObject<Item> ENGRAVED_XUAN_SHELLS_LONG_CHI = REGISTRY.register("engraved_xuan_shells_long_chi", EngravedXuanShellsLongChiItem::new);
    public static final RegistryObject<Item> ZHENG_TOTEM_SCROLLS = REGISTRY.register("zheng_totem_scrolls", ZhengTotemScrollsItem::new);
    public static final RegistryObject<Item> COPPER_ZUN_BOTTLE_ZHENG = block(MountainsPoemModBlocks.COPPER_ZUN_BOTTLE_ZHENG);
    public static final RegistryObject<Item> ENGRAVED_XUAN_SHELLS_ZHENG = REGISTRY.register("engraved_xuan_shells_zheng", EngravedXuanShellsZhengItem::new);
    public static final RegistryObject<Item> CARNELIAN_ORE = block(MountainsPoemModBlocks.CARNELIAN_ORE);
    public static final RegistryObject<Item> DEEPSLATE_CARNELIAN_ORE = block(MountainsPoemModBlocks.DEEPSLATE_CARNELIAN_ORE);
    public static final RegistryObject<Item> ENDER_DRAGON_TOTEM_SCROLLS = REGISTRY.register("ender_dragon_totem_scrolls", EnderDragonTotemScrollsItem::new);
    public static final RegistryObject<Item> SOUTH_MOUNTAINS_GOD_TOTEM_SCROLLS = REGISTRY.register("south_mountains_god_totem_scrolls", SouthMountainsGodTotemScrollsItem::new);
    public static final RegistryObject<Item> ENGRAVED_XUAN_SHELLS_ENDER_DRAGON = REGISTRY.register("engraved_xuan_shells_ender_dragon", EngravedXuanShellsEnderDragonItem::new);
    public static final RegistryObject<Item> COPPER_ZUN_BOTTLE_ENDER_DRAGON = block(MountainsPoemModBlocks.COPPER_ZUN_BOTTLE_ENDER_DRAGON);
    public static final RegistryObject<Item> COPPER_ZUN_BOTTLE_SOUTH_MOUNTAINS_GOD = block(MountainsPoemModBlocks.COPPER_ZUN_BOTTLE_SOUTH_MOUNTAINS_GOD);
    public static final RegistryObject<Item> ENGRAVED_XUAN_SHELLS_ZHI = REGISTRY.register("engraved_xuan_shells_zhi", EngravedXuanShellsZhiItem::new);
    public static final RegistryObject<Item> ZHI_TOTEM_SCROLLS = REGISTRY.register("zhi_totem_scrolls", ZhiTotemScrollsItem::new);
    public static final RegistryObject<Item> COPPER_ZUN_BOTTLE_ZHI = block(MountainsPoemModBlocks.COPPER_ZUN_BOTTLE_ZHI);
    public static final RegistryObject<Item> CARNELIAN_BLOCK = block(MountainsPoemModBlocks.CARNELIAN_BLOCK);
    public static final RegistryObject<Item> FRUITFUL_YAN_LEAVES = block(MountainsPoemModBlocks.FRUITFUL_YAN_LEAVES);
    public static final RegistryObject<Item> JUFU_HUMERUS = REGISTRY.register("jufu_humerus", JufuHumerusItem::new);
    public static final RegistryObject<Item> DIRT_WITH_RONG_GRASS_TUBERS = block(MountainsPoemModBlocks.DIRT_WITH_RONG_GRASS_TUBERS);
    public static final RegistryObject<Item> XUN_LEAVES_BERRY = block(MountainsPoemModBlocks.XUN_LEAVES_BERRY);
    public static final RegistryObject<Item> GOLDEN_XUN_LEAVES_BERRIES = REGISTRY.register("golden_xun_leaves_berries", GoldenXunLeavesBerriesItem::new);
    public static final RegistryObject<Item> GOLDEN_YAN_FRUIT = REGISTRY.register("golden_yan_fruit", GoldenYanFruitItem::new);
    public static final RegistryObject<Item> BAKED_RONG_GRASS_TUBER = REGISTRY.register("baked_rong_grass_tuber", BakedRongGrassTuberItem::new);
    
    
    public static final RegistryObject<Item> FRUITFUL_SHATANG_LEAVES = block(MountainsPoemModBlocks.FRUITFUL_SHATANG_LEAVES);
    public static final RegistryObject<Item> THROWER_ARMOR_TRIM_SMITHING_TEMPLATE = REGISTRY.register("thrower_armor_trim_smithing_template", ThrowerArmorTrimSmithingTemplateItem::new);
    public static final RegistryObject<Item> GOLDEN_SHATANG_FRUIT = REGISTRY.register("golden_shatang_fruit", GoldenShatangFruitItem::new);
    public static final RegistryObject<Item> GOLDEN_WATER_HORSE_ARMOR = REGISTRY.register("golden_water_horse_armor", GoldenWaterHorseArmorItem::new);
    public static final RegistryObject<Item> DIAMOND_WATER_HORSE_ARMOR = REGISTRY.register("diamond_water_horse_armor", DiamondWaterHorseArmorItem::new);
    public static final RegistryObject<Item> IRON_WATER_HORSE_ARMOR = REGISTRY.register("iron_water_horse_armor", IronWaterHorseArmorItem::new);
    public static final RegistryObject<Item> WATER_HORSE_MANE = REGISTRY.register("water_horse_mane", WaterHorseManeItem::new);
    public static final RegistryObject<Item> NETHERITE_WATER_HORSE_ARMOR = REGISTRY.register("netherite_water_horse_armor", NetheriteWaterHorseArmorItem::new);
    public static final RegistryObject<Item> BLOOD_COPPER_WATER_HORSE_ARMOR = REGISTRY.register("blood_copper_water_horse_armor", BloodCopperWaterHorseArmorItem::new);
    public static final RegistryObject<Item> JUFU_HUMERUS_GLAIVE = REGISTRY.register("jufu_humerus_glaive", JufuHumerusGlaiveItem::new);
    public static final RegistryObject<Item> BLOOD_COPPER_YUE = REGISTRY.register("blood_copper_yue", BloodCopperYueItem::new);
    public static final RegistryObject<Item> BLOOD_COPPER_UPGRADE_SMITHING_TEMPLATE = REGISTRY.register("blood_copper_upgrade_smithing_template", BloodCopperUpgradeSmithingTemplateItem::new);
    public static final RegistryObject<Item> BLOOD_COPPER_DAGGER_AXE = REGISTRY.register("blood_copper_dagger_axe", BloodCopperDaggerAxeItem::new);
    public static final RegistryObject<Item> SANGUINE_GLASS = block(MountainsPoemModBlocks.SANGUINE_GLASS);
    public static final RegistryObject<Item> WOODEN_RING_HEAD_KNIFE = REGISTRY.register("wooden_ring_head_knife", WoodenRingHeadKnifeItem::new);
    public static final RegistryObject<Item> STONE_RING_HEAD_KNIFE = REGISTRY.register("stone_ring_head_knife", StoneRingHeadKnifeItem::new);
    public static final RegistryObject<Item> GOLDEN_RING_HEAD_KNIFE = REGISTRY.register("golden_ring_head_knife", GoldenRingHeadKnifeItem::new);
    public static final RegistryObject<Item> DIAMOND_RING_HEAD_KNIFE = REGISTRY.register("diamond_ring_head_knife", DiamondRingHeadKnifeItem::new);
    public static final RegistryObject<Item> NETHERITE_RING_HEAD_KNIFE = REGISTRY.register("netherite_ring_head_knife", NetheriteRingHeadKnifeItem::new);
    public static final RegistryObject<Item> BLOOD_COPPER_RING_HEAD_KNIFE = REGISTRY.register("blood_copper_ring_head_knife", BloodCopperRingHeadKnifeItem::new);
    public static final RegistryObject<Item> UNDER_IRON_RING_HEAD_KNIFE = REGISTRY.register("under_iron_ring_head_knife", UnderIronRingHeadKnifeItem::new);
    public static final RegistryObject<Item> IRON_RING_HEAD_KNIFE = REGISTRY.register("iron_ring_head_knife", IronRingHeadKnifeItem::new);
    public static final RegistryObject<Item> STONE_SHAPING_CHISEL = REGISTRY.register("stone_shaping_chisel", StoneShapingChiselItem::new);
    public static final RegistryObject<Item> IRON_SHAPING_CHISEL = REGISTRY.register("iron_shaping_chisel", IronShapingChiselItem::new);
    public static final RegistryObject<Item> GOLDEN_SHAPING_CHISEL = REGISTRY.register("golden_shaping_chisel", GoldenShapingChiselItem::new);
    public static final RegistryObject<Item> DIAMOND_SHAPING_CHISEL = REGISTRY.register("diamond_shaping_chisel", DiamondShapingChiselItem::new);
    public static final RegistryObject<Item> NETHERITE_SHAPING_CHISEL = REGISTRY.register("netherite_shaping_chisel", NetheriteShapingChiselItem::new);
    public static final RegistryObject<Item> BRONZE_DEVOURER_STATUE = block(MountainsPoemModBlocks.BRONZE_DEVOURER_STATUE);
    public static final RegistryObject<Item> BRONZE_DEVOURER_STATUE_EXPOSED = block(MountainsPoemModBlocks.BRONZE_DEVOURER_STATUE_EXPOSED);
    public static final RegistryObject<Item> BRONZE_DEVOURER_STATUE_EXPOSED_WAXED = block(MountainsPoemModBlocks.BRONZE_DEVOURER_STATUE_EXPOSED_WAXED);
    public static final RegistryObject<Item> BRONZE_DEVOURER_STATUE_WEATHERED = block(MountainsPoemModBlocks.BRONZE_DEVOURER_STATUE_WEATHERED);
    public static final RegistryObject<Item> BRONZE_DEVOURER_STATUE_WEATHERED_WAXED = block(MountainsPoemModBlocks.BRONZE_DEVOURER_STATUE_WEATHERED_WAXED);
    public static final RegistryObject<Item> BRONZE_DEVOURER_STATUE_WAXED = block(MountainsPoemModBlocks.BRONZE_DEVOURER_STATUE_WAXED);
    public static final RegistryObject<Item> SPOOKY_BRONZE_DEVOURER_STATUE = block(MountainsPoemModBlocks.SPOOKY_BRONZE_DEVOURER_STATUE);
    public static final RegistryObject<Item> SPOOKY_BRONZE_DEVOURER_STATUE_PIECE = REGISTRY.register("spooky_bronze_devourer_statue_piece", SpookyBronzeDevourerStatuePieceItem::new);
    public static final Supplier<BronzeDevourerPieceItem> BRONZE_DEVOURER_PIECE_HELMET = REGISTRY.register("bronze_devourer_piece_helmet", () -> new BronzeDevourerPieceItem(ArmorItem.Type.HELMET, new Item.Properties()));
    public static final Supplier<BronzeDevourerPieceItem> BRONZE_DEVOURER_PIECE_CHESTPLATE = REGISTRY.register("bronze_devourer_piece_chestplate", () -> new BronzeDevourerPieceItem(ArmorItem.Type.CHESTPLATE, new Item.Properties()));
    public static final RegistryObject<Item> RED_LANTERN = block(MountainsPoemModBlocks.RED_LANTERN);
    public static final RegistryObject<Item> WOODEN_FRAME = REGISTRY.register("wooden_frame", WoodenFrameItem::new);
    public static final RegistryObject<Item> BAMBOO_FRAME = REGISTRY.register("bamboo_frame", BambooFrameItem::new);
    public static final RegistryObject<Item> YELLOW_CLOTH = REGISTRY.register("yellow_cloth", YellowClothItem::new);
    public static final RegistryObject<Item> GRAY_CLOTH = REGISTRY.register("gray_cloth", GrayClothItem::new);
    public static final RegistryObject<Item> PURPLE_CLOTH = REGISTRY.register("purple_cloth", PurpleClothItem::new);
    public static final RegistryObject<Item> PINK_CLOTH = REGISTRY.register("pink_cloth", PinkClothItem::new);
    public static final RegistryObject<Item> BLUE_CLOTH = REGISTRY.register("blue_cloth", BlueClothItem::new);
    public static final RegistryObject<Item> BLACK_CLOTH = REGISTRY.register("black_cloth", BlackClothItem::new);
    public static final RegistryObject<Item> CYAN_CLOTH = REGISTRY.register("cyan_cloth", CyanClothItem::new);
    public static final RegistryObject<Item> BROWN_CLOTH = REGISTRY.register("brown_cloth", BrownClothItem::new);
    public static final RegistryObject<Item> GREEN_CLOTH = REGISTRY.register("green_cloth", GreenClothItem::new);
    public static final RegistryObject<Item> LIGHT_BLUE_CLOTH = REGISTRY.register("light_blue_cloth", LightBlueClothItem::new);
    public static final RegistryObject<Item> LIME_CLOTH = REGISTRY.register("lime_cloth", LimeClothItem::new);
    public static final RegistryObject<Item> MAGENTA_CLOTH = REGISTRY.register("magenta_cloth", MagentaClothItem::new);
    public static final RegistryObject<Item> LIGHT_GRAY_CLOTH = REGISTRY.register("light_gray_cloth", LightGrayClothItem::new);
    public static final RegistryObject<Item> ORANGE_CLOTH = REGISTRY.register("orange_cloth", OrangeClothItem::new);
    public static final RegistryObject<Item> WHITE_LANTERN = block(MountainsPoemModBlocks.WHITE_LANTERN);
    public static final RegistryObject<Item> BLUE_LANTERN = block(MountainsPoemModBlocks.BLUE_LANTERN);
    public static final RegistryObject<Item> CYAN_LANTERN = block(MountainsPoemModBlocks.CYAN_LANTERN);
    public static final RegistryObject<Item> LIGHT_BLUE_LANTERN = block(MountainsPoemModBlocks.LIGHT_BLUE_LANTERN);
    public static final RegistryObject<Item> ORANGE_LANTERN = block(MountainsPoemModBlocks.ORANGE_LANTERN);
    public static final RegistryObject<Item> YELLOW_LANTERN = block(MountainsPoemModBlocks.YELLOW_LANTERN);
    public static final RegistryObject<Item> GREEN_LANTERN = block(MountainsPoemModBlocks.GREEN_LANTERN);
    public static final RegistryObject<Item> LIME_LANTERN = block(MountainsPoemModBlocks.LIME_LANTERN);
    public static final RegistryObject<Item> PURPLE_LANTERN = block(MountainsPoemModBlocks.PURPLE_LANTERN);
    public static final RegistryObject<Item> MAGENTA_LANTERN = block(MountainsPoemModBlocks.MAGENTA_LANTERN);
    public static final RegistryObject<Item> GRAY_LANTERN = block(MountainsPoemModBlocks.GRAY_LANTERN);
    public static final RegistryObject<Item> LIGHT_GRAY_LANTERN = block(MountainsPoemModBlocks.LIGHT_GRAY_LANTERN);
    public static final RegistryObject<Item> BROWN_LANTERN = block(MountainsPoemModBlocks.BROWN_LANTERN);
    public static final RegistryObject<Item> BLACK_LANTERN = block(MountainsPoemModBlocks.BLACK_LANTERN);
    public static final RegistryObject<Item> SOAKED_PLANTS_BUCKET = REGISTRY.register("soaked_plants_bucket", SoakedPlantsBucketItem::new);
    public static final RegistryObject<Item> PAPER_PULP_BUCKET = REGISTRY.register("paper_pulp_bucket", PaperPulpBucketItem::new);
    public static final RegistryObject<Item> DRYING_BOARD = block(MountainsPoemModBlocks.DRYING_BOARD);
    public static final RegistryObject<Item> PAPERMAKING_BOARD = block(MountainsPoemModBlocks.PAPERMAKING_BOARD);
    public static final RegistryObject<Item> BAMBOO_MESH = REGISTRY.register("bamboo_mesh", BambooMeshItem::new);
    public static final RegistryObject<Item> WOODEN_MESH = REGISTRY.register("wooden_mesh", WoodenMeshItem::new);
    public static final RegistryObject<Item> BAMBOO_MESH_WITH_PAPER_PULP = REGISTRY.register("bamboo_mesh_with_paper_pulp", BambooMeshWithPaperPulpItem::new);
    public static final RegistryObject<Item> WOODEN_MESH_WITH_PAPER_PULP = REGISTRY.register("wooden_mesh_with_paper_pulp", WoodenMeshWithPaperPulpItem::new);
    public static final RegistryObject<Item> PINK_LANTERN = block(MountainsPoemModBlocks.PINK_LANTERN);
    public static final RegistryObject<Item> SALINE_ORE = block(MountainsPoemModBlocks.SALINE_ORE);
    public static final RegistryObject<Item> COARSE_SALT = REGISTRY.register("coarse_salt", CoarseSaltItem::new);
    public static final RegistryObject<Item> SALT = REGISTRY.register("salt", SaltItem::new);
    public static final RegistryObject<Item> SALT_BLCOK = block(MountainsPoemModBlocks.SALT_BLCOK);
    public static final RegistryObject<Item> COARSE_SALT_BLOCK = block(MountainsPoemModBlocks.COARSE_SALT_BLOCK);
    public static final RegistryObject<Item> WHITE_JIAN_GRASS_BLOCK = block(MountainsPoemModBlocks.WHITE_JIAN_GRASS_BLOCK);
    public static final RegistryObject<Item> AO_YIN_FUR = REGISTRY.register("ao_yin_fur",
            () -> new Item(new Item.Properties().stacksTo(64).rarity(Rarity.COMMON))
    );
    public static final RegistryObject<Item> WHITE_APE_CURVED_NAILS = REGISTRY.register("white_ape_curved_nails",
            () -> new Item(new Item.Properties().stacksTo(64).rarity(Rarity.COMMON))
    );

    public static final RegistryObject<Item> WHITE_APE_CLIMBING_HOOK = REGISTRY.register("white_ape_climbing_hook", WhiteApeClimbingHookItem::new);

    public static final RegistryObject<Item> BLOOD_COPPER_AXE = REGISTRY.register("blood_copper_axe", BLOOD_COPPER_AXE::new);
    public static final RegistryObject<Item> BLOOD_COPPER_HOE = REGISTRY.register("blood_copper_hoe", BLOOD_COPPER_HOE::new);
    public static final RegistryObject<Item> BLOOD_COPPER_PICKAXE = REGISTRY.register("blood_copper_pickaxe", BLOOD_COPPER_PICKAXE::new);
    public static final RegistryObject<Item> BLOOD_COPPER_SHOVEL = REGISTRY.register("blood_copper_shovel", BLOOD_COPPER_SHOVEL::new);

    public static final Supplier<BambooGreenNineTailedFoxHanfuItem> BAMBOO_GREEN_NINE_TAILED_FOX_HANFU_HELMET = REGISTRY.register("bamboo_green_nine_tailed_fox_hanfu_helmet",
            () -> new BambooGreenNineTailedFoxHanfuItem(ArmorItem.Type.HELMET, new Item.Properties()));
    public static final Supplier<BambooGreenNineTailedFoxHanfuItem> BAMBOO_GREEN_NINE_TAILED_FOX_HANFU_CHESTPLATE = REGISTRY.register("bamboo_green_nine_tailed_fox_hanfu_chestplate",
            () -> new BambooGreenNineTailedFoxHanfuItem(ArmorItem.Type.CHESTPLATE, new Item.Properties()));
    public static final Supplier<BambooGreenNineTailedFoxHanfuItem> BAMBOO_GREEN_NINE_TAILED_FOX_HANFU_LEGGINGS = REGISTRY.register("bamboo_green_nine_tailed_fox_hanfu_leggings",
            () -> new BambooGreenNineTailedFoxHanfuItem(ArmorItem.Type.LEGGINGS, new Item.Properties()));
    public static final Supplier<MugwortGreenNineTailedFoxHanfuItem> MUGWORT_GREEN_NINE_TAILED_FOX_HANFU_HELMET = REGISTRY.register("mugwort_green_nine_tailed_fox_hanfu_helmet",
            () -> new MugwortGreenNineTailedFoxHanfuItem(ArmorItem.Type.HELMET, new Item.Properties()));
    public static final Supplier<MugwortGreenNineTailedFoxHanfuItem> MUGWORT_GREEN_NINE_TAILED_FOX_HANFU_CHESTPLATE = REGISTRY.register("mugwort_green_nine_tailed_fox_hanfu_chestplate",
            () -> new MugwortGreenNineTailedFoxHanfuItem(ArmorItem.Type.CHESTPLATE, new Item.Properties()));
    public static final Supplier<MugwortGreenNineTailedFoxHanfuItem> MUGWORT_GREEN_NINE_TAILED_FOX_HANFU_LEGGINGS = REGISTRY.register("mugwort_green_nine_tailed_fox_hanfu_leggings",
            () -> new MugwortGreenNineTailedFoxHanfuItem(ArmorItem.Type.LEGGINGS, new Item.Properties()));
    public static final Supplier<PeachRedNineTailedFoxHanfuItem> PEACH_RED_NINE_TAILED_FOX_HANFU_HELMET = REGISTRY.register("peach_red_nine_tailed_fox_hanfu_helmet",
            () -> new PeachRedNineTailedFoxHanfuItem(ArmorItem.Type.HELMET, new Item.Properties()));
    public static final Supplier<PeachRedNineTailedFoxHanfuItem> PEACH_RED_NINE_TAILED_FOX_HANFU_CHESTPLATE = REGISTRY.register("peach_red_nine_tailed_fox_hanfu_chestplate",
            () -> new PeachRedNineTailedFoxHanfuItem(ArmorItem.Type.CHESTPLATE, new Item.Properties()));
    public static final Supplier<PeachRedNineTailedFoxHanfuItem> PEACH_RED_NINE_TAILED_FOX_HANFU_LEGGINGS = REGISTRY.register("peach_red_nine_tailed_fox_hanfu_leggings",
            () -> new PeachRedNineTailedFoxHanfuItem(ArmorItem.Type.LEGGINGS, new Item.Properties()));
    public static final Supplier<JunBlackNineTailedFoxHanfuItem> JUN_BLACK_NINE_TAILED_FOX_HANFU_HELMET = REGISTRY.register("jun_black_nine_tailed_fox_hanfu_helmet",
            () -> new JunBlackNineTailedFoxHanfuItem(ArmorItem.Type.HELMET, new Item.Properties()));
    public static final Supplier<JunBlackNineTailedFoxHanfuItem> JUN_BLACK_NINE_TAILED_FOX_HANFU_CHESTPLATE = REGISTRY.register("jun_black_nine_tailed_fox_hanfu_chestplate",
            () -> new JunBlackNineTailedFoxHanfuItem(ArmorItem.Type.CHESTPLATE, new Item.Properties()));
    public static final Supplier<JunBlackNineTailedFoxHanfuItem> JUN_BLACK_NINE_TAILED_FOX_HANFU_LEGGINGS = REGISTRY.register("jun_black_nine_tailed_fox_hanfu_leggings",
            () -> new JunBlackNineTailedFoxHanfuItem(ArmorItem.Type.LEGGINGS, new Item.Properties()));

    // Start of user code block custom items
    // End of user code block custom items
    private static RegistryObject<Item> block(RegistryObject<Block> block) {
        return REGISTRY.register(block.getId().getPath(), () -> new BlockItem(block.get(), new Item.Properties()));
    }

    private static RegistryObject<Item> doubleBlock(RegistryObject<Block> block) {
        return REGISTRY.register(block.getId().getPath(), () -> new DoubleHighBlockItem(block.get(), new Item.Properties()));
    }
}
