package com.xiris.mountainspoem.init;

import com.mojang.datafixers.util.Either;
import com.mojang.datafixers.util.Pair;
import com.xiris.mountainspoem.MountainsPoemMod;
import net.minecraft.core.Holder;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.MinecraftServer;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.Climate;
import net.minecraft.world.level.biome.MultiNoiseBiomeSource;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.chunk.ChunkGenerator;
import net.minecraft.world.level.dimension.BuiltinDimensionTypes;
import net.minecraft.world.level.dimension.LevelStem;
import net.minecraft.world.level.levelgen.*;
import net.minecraft.world.level.levelgen.placement.CaveSurface;
import net.minecraftforge.event.server.ServerAboutToStartEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

@Mod.EventBusSubscriber
public class MountainsPoemModBiomes {
    private static Field PARAMETERS_FIELD;
    private static Field GENERATOR_FIELD;

    static {
        try {
            PARAMETERS_FIELD = MultiNoiseBiomeSource.class.getDeclaredField("parameters");
            PARAMETERS_FIELD.setAccessible(true);

            GENERATOR_FIELD = LevelStem.class.getDeclaredField("generator");
            GENERATOR_FIELD.setAccessible(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @SubscribeEvent
    public static void onServerAboutToStart(ServerAboutToStartEvent event) {
        MinecraftServer server = event.getServer();
        Registry<LevelStem> levelStems = server.registryAccess().registryOrThrow(Registries.LEVEL_STEM);
        Registry<Biome> biomes = server.registryAccess().registryOrThrow(Registries.BIOME);

        for (LevelStem stem : levelStems) {
//            if (stem.type().is(BuiltinDimensionTypes.OVERWORLD)) {
//                try {
//                    ChunkGenerator original = stem.generator();
//                    if (original instanceof NoiseBasedChunkGenerator noiseGen) {
//                        NoiseGeneratorSettings settings = noiseGen.generatorSettings().value();
//                        MultiNoiseBiomeSource originalSource = (MultiNoiseBiomeSource) original.getBiomeSource();
//
//                        Object obj = PARAMETERS_FIELD.get(originalSource);
//                        Either<Climate.ParameterList<Holder<Biome>>, Climate.ParameterPoint> either =
//                                (Either<Climate.ParameterList<Holder<Biome>>, Climate.ParameterPoint>) obj;
//
//                        Climate.ParameterList<Holder<Biome>> params = either.left().orElseThrow();
//                        List<Pair<Climate.ParameterPoint, Holder<Biome>>> list = new ArrayList<>(params.values());
//
//                        addBiome(list, biomes, "yanforest", -0.5005f,0.5f,-0.5f,0.2f,0.03f,0.3001f,-0.1f,0.78f,0,0.8f,1f);
//                        addBiome(list, biomes, "yanforest", -0.5005f,0.5f,-0.5f,0.2f,0.03f,0.3001f,-0.1f,0.78f,1,0.8f,1f);
//                        addBiome(list, biomes, "newjiangforest", 0.2f,0.55f,-1.5f,0,0.1f,0.3f,0.05f,0.45f,0,-1.0001f,0.7f);
//                        addBiome(list, biomes, "newjiangforest", 0.2f,0.55f,-1.5f,0,0.1f,0.3f,0.05f,0.45f,1,-1.0001f,0.7f);
//                        addBiome(list, biomes, "jianmei_bamboo_jungle", 0.3f,0.5f,0.2f,0.5f,0.3f,0.8f,-0.5f,0.5f,0,-1,1f);
//                        addBiome(list, biomes, "jianmei_bamboo_jungle", 0.3f,0.5f,0.2f,0.5f,0.3f,0.8f,-0.5f,0.5f,1,-1,1f);
//                        addBiome(list, biomes, "shatang_forest", 0.25f,0.55f,-0.1f,1f,0.3f,0.6f,0.05f,0.45f,0,0,1f);
//                        addBiome(list, biomes, "shatang_forest", 0.25f,0.55f,-0.1f,1f,0.3f,0.6f,0.05f,0.45f,1,0,1f);
//                        addBiome(list, biomes, "pan_forest", 0.2f,0.5501f,0.1f,0.8f,-0.1f,0.1f,0.2f,1f,0,0,1f);
//                        addBiome(list, biomes, "pan_forest", 0.2f,0.5501f,0.1f,0.8f,-0.1f,0.1f,0.2f,1f,1,0,1f);
//                        addBiome(list, biomes, "peach_blossom_forest", 0.6f,0.9f,-0.11f,0.03f,-0.1f,0.55f,0.05f,1f,0,0.4f,1f);
//                        addBiome(list, biomes, "peach_blossom_forest", 0.6f,0.9f,-0.11f,0.03f,-0.1f,0.55f,0.05f,1f,1,0.4f,1f);
//                        addBiome(list, biomes, "huang_guan_forest", -0.1f,1.2f,-0.5f,0.5f,0.3f,0.6f,0.3f,0.5f,0,0.2f,1f);
//                        addBiome(list, biomes, "huang_guan_forest", -0.1f,1.2f,-0.5f,0.5f,0.3f,0.6f,0.3f,0.5f,1,0.2f,1f);
//                        addBiome(list, biomes, "dark_taiga", 0.1f,0.5f,0.1f,0.5f,0.1f,0.5f,0.1f,0.5f,0,-1,1f);
//                        addBiome(list, biomes, "dark_taiga", 0.1f,0.5f,0.1f,0.5f,0.1f,0.5f,0.1f,0.5f,1,-1,1f);
//                        addBiome(list, biomes, "green_rock_mountains", 0,0.5f,0.1f,0.5f,0.608f,1f,0.55f,1f,0,0,1f);
//                        addBiome(list, biomes, "green_rock_mountains", 0,0.5f,0.1f,0.5f,0.608f,1f,0.55f,1f,1,0,1f);
//                        addBiome(list, biomes, "old_growth_yan_forest", -0.5005f,0.5f,0.1f,0.5f,0,1.0001f,0.1f,0.55f,0,0.8f,1.33f);
//                        addBiome(list, biomes, "old_growth_yan_forest", -0.5005f,0.5f,0.1f,0.5f,0,1.0001f,0.1f,0.55f,1,0.8f,1.33f);
//
//                        List<SurfaceRules.RuleSource> rules = new ArrayList<>();
//                        rules.add(preliminary(key("yanforest"), Blocks.GRASS_BLOCK.defaultBlockState(), Blocks.DIRT.defaultBlockState()));
//                        rules.add(preliminary(key("newjiangforest"), Blocks.GRASS_BLOCK.defaultBlockState(), Blocks.DIRT.defaultBlockState()));
//                        rules.add(preliminary(key("jianmei_bamboo_jungle"), MountainsPoemModBlocks.LUSH_GRASS_BLOCK.get().defaultBlockState(), MountainsPoemModBlocks.LUSH_DIRT.get().defaultBlockState()));
//                        rules.add(preliminary(key("shatang_forest"), Blocks.GRASS_BLOCK.defaultBlockState(), Blocks.DIRT.defaultBlockState()));
//                        rules.add(preliminary(key("pan_forest"), Blocks.GRASS_BLOCK.defaultBlockState(), Blocks.DIRT.defaultBlockState()));
//                        rules.add(preliminary(key("peach_blossom_forest"), Blocks.GRASS_BLOCK.defaultBlockState(), Blocks.DIRT.defaultBlockState()));
//                        rules.add(preliminary(key("huang_guan_forest"), Blocks.GRASS_BLOCK.defaultBlockState(), Blocks.DIRT.defaultBlockState()));
//                        rules.add(preliminary(key("dark_taiga"), Blocks.GRASS_BLOCK.defaultBlockState(), Blocks.DIRT.defaultBlockState()));
//                        rules.add(preliminary(key("green_rock_mountains"), Blocks.STONE.defaultBlockState(), Blocks.STONE.defaultBlockState()));
//                        rules.add(preliminary(key("old_growth_yan_forest"), MountainsPoemModBlocks.LUSH_GRASS_BLOCK.get().defaultBlockState(), MountainsPoemModBlocks.LUSH_DIRT.get().defaultBlockState()));
//                        rules.add(settings.surfaceRule());
//
//                        NoiseGeneratorSettings newSettings = new NoiseGeneratorSettings(
//                                settings.noiseSettings(), settings.defaultBlock(), settings.defaultFluid(),
//                                settings.noiseRouter(), SurfaceRules.sequence(rules.toArray(SurfaceRules.RuleSource[]::new)),
//                                settings.spawnTarget(), settings.seaLevel(), settings.disableMobGeneration(),
//                                settings.aquifersEnabled(), settings.oreVeinsEnabled(), settings.useLegacyRandomSource()
//                        );
//
//                        MultiNoiseBiomeSource newSource = MultiNoiseBiomeSource.createFromList(new Climate.ParameterList<>(list));
//                        NoiseBasedChunkGenerator newGen = new NoiseBasedChunkGenerator(
//                                newSource,
//                                Holder.direct(newSettings)
//                        );
//
//                        GENERATOR_FIELD.set(stem, newGen);
//                    }
//                } catch (Exception e) {
//                    e.printStackTrace();
//                }
//            }

            if (stem.type().is(BuiltinDimensionTypes.NETHER)) {
                try {
                    ChunkGenerator original = stem.generator();
                    if (original instanceof NoiseBasedChunkGenerator noiseGen) {
                        NoiseGeneratorSettings settings = noiseGen.generatorSettings().value();
                        MultiNoiseBiomeSource originalSource = (MultiNoiseBiomeSource) original.getBiomeSource();

                        Object obj = PARAMETERS_FIELD.get(originalSource);
                        Either<Climate.ParameterList<Holder<Biome>>, Climate.ParameterPoint> either =
                                (Either<Climate.ParameterList<Holder<Biome>>, Climate.ParameterPoint>) obj;

                        Climate.ParameterList<Holder<Biome>> params = either.left().orElseThrow();
                        List<Pair<Climate.ParameterPoint, Holder<Biome>>> list = new ArrayList<>(params.values());

                        addBiome(list, biomes, "ancient_battlefields", 0.4999f,1f,0.1f,0.3f,0.3f,0.6f,-0.5f,0.5f,0,-0.1f,0.6f);
                        addBiome(list, biomes, "ancient_battlefields", 0.4999f,1f,0.1f,0.3f,0.3f,0.6f,-0.5f,0.5f,1,-0.1f,0.6f);
                        addBiome(list, biomes, "under_rock_hill", -0.5f,0.5f,0.8f,1f,0.7f,1.1f,0.1f,0.5002f,0,-1f,1f);
                        addBiome(list, biomes, "under_rock_hill", -0.5f,0.5f,0.8f,1f,0.7f,1.1f,0.1f,0.5002f,1,-1f,1f);

                        List<SurfaceRules.RuleSource> rules = new ArrayList<>();
                        rules.add(anySurface(key("ancient_battlefields"), MountainsPoemModBlocks.UNDER_GRASS_BLOCK.get().defaultBlockState(), MountainsPoemModBlocks.UNDER_DIRT.get().defaultBlockState()));
                        rules.add(anySurface(key("under_rock_hill"), MountainsPoemModBlocks.UNDER_ROCK.get().defaultBlockState(), MountainsPoemModBlocks.UNDER_ROCK.get().defaultBlockState()));
                        rules.add(settings.surfaceRule());

                        NoiseGeneratorSettings newSettings = new NoiseGeneratorSettings(
                                settings.noiseSettings(), settings.defaultBlock(), settings.defaultFluid(),
                                settings.noiseRouter(), SurfaceRules.sequence(rules.toArray(SurfaceRules.RuleSource[]::new)),
                                settings.spawnTarget(), settings.seaLevel(), settings.disableMobGeneration(),
                                settings.aquifersEnabled(), settings.oreVeinsEnabled(), settings.useLegacyRandomSource()
                        );

                        MultiNoiseBiomeSource newSource = MultiNoiseBiomeSource.createFromList(new Climate.ParameterList<>(list));
                        NoiseBasedChunkGenerator newGen = new NoiseBasedChunkGenerator(
                                newSource,
                                Holder.direct(newSettings)
                        );

                        GENERATOR_FIELD.set(stem, newGen);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private static void addBiome(List<Pair<Climate.ParameterPoint, Holder<Biome>>> list, Registry<Biome> registry, String name,
                                 float tMin, float tMax, float hMin, float hMax, float cMin, float cMax,
                                 float eMin, float eMax, float weird, float rMin, float rMax) {
        ResourceKey<Biome> key = key(name);
        if (!registry.containsKey(key)) return;
        list.add(Pair.of(
                new Climate.ParameterPoint(
                        Climate.Parameter.span(tMin, tMax),
                        Climate.Parameter.span(hMin, hMax),
                        Climate.Parameter.span(cMin, cMax),
                        Climate.Parameter.span(eMin, eMax),
                        Climate.Parameter.point(weird),
                        Climate.Parameter.span(rMin, rMax),
                        0
                ),
                registry.getHolderOrThrow(key)
        ));
    }

    private static SurfaceRules.RuleSource preliminary(ResourceKey<Biome> b, BlockState g, BlockState u) {
        return SurfaceRules.ifTrue(SurfaceRules.isBiome(b),
                SurfaceRules.ifTrue(SurfaceRules.abovePreliminarySurface(),
                        SurfaceRules.sequence(
                                SurfaceRules.ifTrue(SurfaceRules.stoneDepthCheck(0, false, CaveSurface.FLOOR),
                                        SurfaceRules.sequence(SurfaceRules.ifTrue(SurfaceRules.waterBlockCheck(-1, 0), SurfaceRules.state(g)), SurfaceRules.state(u))),
                                SurfaceRules.ifTrue(SurfaceRules.stoneDepthCheck(0, true, CaveSurface.FLOOR), SurfaceRules.state(u)))));
    }

    private static SurfaceRules.RuleSource anySurface(ResourceKey<Biome> b, BlockState g, BlockState u) {
        return SurfaceRules.ifTrue(SurfaceRules.isBiome(b),
                SurfaceRules.sequence(
                        SurfaceRules.ifTrue(SurfaceRules.stoneDepthCheck(0, false, CaveSurface.FLOOR),
                                SurfaceRules.sequence(SurfaceRules.ifTrue(SurfaceRules.waterBlockCheck(-1, 0), SurfaceRules.state(g)), SurfaceRules.state(u))),
                        SurfaceRules.ifTrue(SurfaceRules.stoneDepthCheck(0, true, CaveSurface.FLOOR), SurfaceRules.state(u))));
    }

    private static ResourceKey<Biome> key(String name) {
        return ResourceKey.create(Registries.BIOME, ResourceLocation.fromNamespaceAndPath(MountainsPoemMod.MOD_ID, name));
    }
}