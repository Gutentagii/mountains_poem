package com.xiris.mountainspoem.init;

import com.xiris.mountainspoem.MountainsPoemMod;
import com.xiris.mountainspoem.block.entity.*;
//import dev.architectury.registry.registries.DeferredRegister;
//import dev.architectury.registry.registries.RegistrySupplier;
//import dev.architectury.registry.registries.RegistrySupplier;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class MountainsPoemModBlockEntities {
    public static final DeferredRegister<BlockEntityType<?>> REGISTRY =
            DeferredRegister.create(Registries.BLOCK_ENTITY_TYPE, MountainsPoemMod.MOD_ID);

    public static final Supplier<BlockEntityType<JianmeibambooBlockEntity>> JIANMEIBAMBOO = REGISTRY.register("jianmeibamboo", () -> BlockEntityType.Builder.of(JianmeibambooBlockEntity::new, MountainsPoemModBlocks.JIANMEIBAMBOO.get()).build(null));
    public static final Supplier<BlockEntityType<GuiBasketBlockEntity>> GUI_BASKET = REGISTRY.register("gui_basket", () -> BlockEntityType.Builder.of(GuiBasketBlockEntity::new, MountainsPoemModBlocks.GUI_BASKET.get()).build(null));
    public static final Supplier<BlockEntityType<SacrificialTableBlockEntity>> SACRIFICIAL_TABLE = REGISTRY.register("sacrificial_table", () -> BlockEntityType.Builder.of(SacrificialTableBlockEntity::new, MountainsPoemModBlocks.SACRIFICIAL_TABLE.get()).build(null));
    public static final Supplier<BlockEntityType<HollowMudBricksBlockEntity>> HOLLOW_MUD_BRICKS = REGISTRY.register("hollow_mud_bricks", () -> BlockEntityType.Builder.of(HollowMudBricksBlockEntity::new, MountainsPoemModBlocks.HOLLOW_MUD_BRICKS.get()).build(null));
    public static final Supplier<BlockEntityType<WhiteJianGrassMatCoveredSacrificialTableBlockEntity>> WHITE_JIAN_GRASS_MAT_COVERED_SACRIFICIAL_TABLE = REGISTRY.register("white_jian_grass_mat_covered_sacrificial_table", () -> BlockEntityType.Builder.of(WhiteJianGrassMatCoveredSacrificialTableBlockEntity::new, MountainsPoemModBlocks.WHITE_JIAN_GRASS_MAT_COVERED_SACRIFICIAL_TABLE.get()).build(null));
    public static final Supplier<BlockEntityType<JadeCarverBlockEntity>> JADE_CARVER = REGISTRY.register("jade_carver", () -> BlockEntityType.Builder.of(JadeCarverBlockEntity::new, MountainsPoemModBlocks.JADE_CARVER.get()).build(null));
    public static final Supplier<BlockEntityType<CopperZunBottleBlockEntity>> COPPER_ZUN_BOTTLE = REGISTRY.register("copper_zun_bottle", () -> BlockEntityType.Builder.of(CopperZunBottleBlockEntity::new, MountainsPoemModBlocks.COPPER_ZUN_BOTTLE.get()).build(null));
    public static final Supplier<BlockEntityType<CopperGuiBlockEntity>> COPPER_GUI = REGISTRY.register("copper_gui", () -> BlockEntityType.Builder.of(CopperGuiBlockEntity::new, MountainsPoemModBlocks.COPPER_GUI.get()).build(null));
    public static final Supplier<BlockEntityType<CopperDouWithSauceBlockEntity>> COPPER_DOU_WITH_SAUCE = REGISTRY.register("copper_dou_with_sauce", () -> BlockEntityType.Builder.of(CopperDouWithSauceBlockEntity::new, MountainsPoemModBlocks.COPPER_DOU_CHANGFU_CHICKEN_SAUCE.get()).build(null));

    private static <T extends BlockEntity> RegistryObject<BlockEntityType<T>> register(String name, Supplier<Block> block, BlockEntityType.BlockEntitySupplier<T> supplier) {
        return REGISTRY.register(name, () -> BlockEntityType.Builder.of(supplier, block.get()).build(null));
    }
}
