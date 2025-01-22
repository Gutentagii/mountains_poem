
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.mountainspoem.init;

import java.util.List;
import java.util.ArrayList;

import com.google.common.base.Suppliers;
import com.mojang.datafixers.util.Pair;
import net.minecraft.core.Holder;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.Climate;
import net.minecraft.world.level.biome.FeatureSorter;
import net.minecraft.world.level.biome.MultiNoiseBiomeSource;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.chunk.ChunkGenerator;
import net.minecraft.world.level.dimension.BuiltinDimensionTypes;
import net.minecraft.world.level.levelgen.NoiseBasedChunkGenerator;
import net.minecraft.world.level.levelgen.NoiseGeneratorSettings;
import net.minecraft.world.level.levelgen.SurfaceRules;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber
public class MountainsPoemModBiomes {
	@SubscribeEvent
	public static void onServerAboutToStart(ServerAboutToStartEvent event) {
		MinecraftServer server = event.getServer();
		Registry<DimensionType> dimensionTypeRegistry = server.registryAccess().registryOrThrow(Registries.DIMENSION_TYPE);
		Registry<LevelStem> levelStemTypeRegistry = server.registryAccess().registryOrThrow(Registries.LEVEL_STEM);
		Registry<Biome> biomeRegistry = server.registryAccess().registryOrThrow(Registries.BIOME);
		for (LevelStem levelStem : levelStemTypeRegistry.stream().toList()) {
			DimensionType dimensionType = levelStem.type().value();
			if (dimensionType == dimensionTypeRegistry.getOrThrow(BuiltinDimensionTypes.OVERWORLD)) {
				ChunkGenerator chunkGenerator = levelStem.generator();
				// Inject biomes to biome source
				if (chunkGenerator.getBiomeSource() instanceof MultiNoiseBiomeSource noiseSource) {
					List<Pair<Climate.ParameterPoint, Holder<Biome>>> parameters = new ArrayList<>(noiseSource.parameters().values());
					addParameterPoint(parameters, new Pair<>(new Climate.ParameterPoint(Climate.Parameter.span(-0.5005f, 0.5f), Climate.Parameter.span(-0.5f, 0.2f), Climate.Parameter.span(0.03f, 0.3001f), Climate.Parameter.span(-0.1f, 0.78f),
							Climate.Parameter.point(0.0f), Climate.Parameter.span(0.8f, 1f), 0), biomeRegistry.getHolderOrThrow(ResourceKey.create(Registries.BIOME, new ResourceLocation("mountains_poem", "yanforest")))));
					addParameterPoint(parameters, new Pair<>(new Climate.ParameterPoint(Climate.Parameter.span(-0.5005f, 0.5f), Climate.Parameter.span(-0.5f, 0.2f), Climate.Parameter.span(0.03f, 0.3001f), Climate.Parameter.span(-0.1f, 0.78f),
							Climate.Parameter.point(1.0f), Climate.Parameter.span(0.8f, 1f), 0), biomeRegistry.getHolderOrThrow(ResourceKey.create(Registries.BIOME, new ResourceLocation("mountains_poem", "yanforest")))));
					addParameterPoint(parameters, new Pair<>(new Climate.ParameterPoint(Climate.Parameter.span(0.2f, 0.55f), Climate.Parameter.span(-1.5f, 0f), Climate.Parameter.span(0.1f, 0.3f), Climate.Parameter.span(0.05f, 0.45f),
							Climate.Parameter.point(0.0f), Climate.Parameter.span(-1.0001f, 0.7f), 0), biomeRegistry.getHolderOrThrow(ResourceKey.create(Registries.BIOME, new ResourceLocation("mountains_poem", "newjiangforest")))));
					addParameterPoint(parameters, new Pair<>(new Climate.ParameterPoint(Climate.Parameter.span(0.2f, 0.55f), Climate.Parameter.span(-1.5f, 0f), Climate.Parameter.span(0.1f, 0.3f), Climate.Parameter.span(0.05f, 0.45f),
							Climate.Parameter.point(1.0f), Climate.Parameter.span(-1.0001f, 0.7f), 0), biomeRegistry.getHolderOrThrow(ResourceKey.create(Registries.BIOME, new ResourceLocation("mountains_poem", "newjiangforest")))));
					addParameterPoint(parameters, new Pair<>(new Climate.ParameterPoint(Climate.Parameter.span(0.3f, 0.5f), Climate.Parameter.span(0.2f, 0.5f), Climate.Parameter.span(0.3f, 0.8f), Climate.Parameter.span(-0.5f, 0.5f),
							Climate.Parameter.point(0.0f), Climate.Parameter.span(-1f, 1f), 0), biomeRegistry.getHolderOrThrow(ResourceKey.create(Registries.BIOME, new ResourceLocation("mountains_poem", "jianmei_bamboo_jungle")))));
					addParameterPoint(parameters, new Pair<>(new Climate.ParameterPoint(Climate.Parameter.span(0.3f, 0.5f), Climate.Parameter.span(0.2f, 0.5f), Climate.Parameter.span(0.3f, 0.8f), Climate.Parameter.span(-0.5f, 0.5f),
							Climate.Parameter.point(1.0f), Climate.Parameter.span(-1f, 1f), 0), biomeRegistry.getHolderOrThrow(ResourceKey.create(Registries.BIOME, new ResourceLocation("mountains_poem", "jianmei_bamboo_jungle")))));
					addParameterPoint(parameters, new Pair<>(new Climate.ParameterPoint(Climate.Parameter.span(0.25f, 0.55f), Climate.Parameter.span(-0.1f, 1f), Climate.Parameter.span(0.3f, 0.6f), Climate.Parameter.span(0.05f, 0.45f),
							Climate.Parameter.point(0.0f), Climate.Parameter.span(0f, 1f), 0), biomeRegistry.getHolderOrThrow(ResourceKey.create(Registries.BIOME, new ResourceLocation("mountains_poem", "shatang_forest")))));
					addParameterPoint(parameters, new Pair<>(new Climate.ParameterPoint(Climate.Parameter.span(0.25f, 0.55f), Climate.Parameter.span(-0.1f, 1f), Climate.Parameter.span(0.3f, 0.6f), Climate.Parameter.span(0.05f, 0.45f),
							Climate.Parameter.point(1.0f), Climate.Parameter.span(0f, 1f), 0), biomeRegistry.getHolderOrThrow(ResourceKey.create(Registries.BIOME, new ResourceLocation("mountains_poem", "shatang_forest")))));
					addParameterPoint(parameters, new Pair<>(new Climate.ParameterPoint(Climate.Parameter.span(0.2f, 0.5501f), Climate.Parameter.span(0.1f, 0.8f), Climate.Parameter.span(-0.1f, 0.1f), Climate.Parameter.span(0.2f, 1f),
							Climate.Parameter.point(0.0f), Climate.Parameter.span(0f, 1f), 0), biomeRegistry.getHolderOrThrow(ResourceKey.create(Registries.BIOME, new ResourceLocation("mountains_poem", "pan_forest")))));
					addParameterPoint(parameters, new Pair<>(new Climate.ParameterPoint(Climate.Parameter.span(0.2f, 0.5501f), Climate.Parameter.span(0.1f, 0.8f), Climate.Parameter.span(-0.1f, 0.1f), Climate.Parameter.span(0.2f, 1f),
							Climate.Parameter.point(1.0f), Climate.Parameter.span(0f, 1f), 0), biomeRegistry.getHolderOrThrow(ResourceKey.create(Registries.BIOME, new ResourceLocation("mountains_poem", "pan_forest")))));
					addParameterPoint(parameters, new Pair<>(new Climate.ParameterPoint(Climate.Parameter.span(0.6f, 0.9f), Climate.Parameter.span(-0.11f, 0.03f), Climate.Parameter.span(-0.1f, 0.55f), Climate.Parameter.span(0.05f, 1f),
							Climate.Parameter.point(0.0f), Climate.Parameter.span(0.4f, 1f), 0), biomeRegistry.getHolderOrThrow(ResourceKey.create(Registries.BIOME, new ResourceLocation("mountains_poem", "peach_blossom_forest")))));
					addParameterPoint(parameters, new Pair<>(new Climate.ParameterPoint(Climate.Parameter.span(0.6f, 0.9f), Climate.Parameter.span(-0.11f, 0.03f), Climate.Parameter.span(-0.1f, 0.55f), Climate.Parameter.span(0.05f, 1f),
							Climate.Parameter.point(1.0f), Climate.Parameter.span(0.4f, 1f), 0), biomeRegistry.getHolderOrThrow(ResourceKey.create(Registries.BIOME, new ResourceLocation("mountains_poem", "peach_blossom_forest")))));
					addParameterPoint(parameters, new Pair<>(new Climate.ParameterPoint(Climate.Parameter.span(-0.1f, 1.2f), Climate.Parameter.span(-0.5f, 0.5f), Climate.Parameter.span(0.3f, 0.6f), Climate.Parameter.span(0.3f, 0.5f),
							Climate.Parameter.point(0.0f), Climate.Parameter.span(0.2f, 1f), 0), biomeRegistry.getHolderOrThrow(ResourceKey.create(Registries.BIOME, new ResourceLocation("mountains_poem", "huang_guan_forest")))));
					addParameterPoint(parameters, new Pair<>(new Climate.ParameterPoint(Climate.Parameter.span(-0.1f, 1.2f), Climate.Parameter.span(-0.5f, 0.5f), Climate.Parameter.span(0.3f, 0.6f), Climate.Parameter.span(0.3f, 0.5f),
							Climate.Parameter.point(1.0f), Climate.Parameter.span(0.2f, 1f), 0), biomeRegistry.getHolderOrThrow(ResourceKey.create(Registries.BIOME, new ResourceLocation("mountains_poem", "huang_guan_forest")))));
					addParameterPoint(parameters, new Pair<>(new Climate.ParameterPoint(Climate.Parameter.span(0.1f, 0.5f), Climate.Parameter.span(0.1f, 0.5f), Climate.Parameter.span(0.1f, 0.5f), Climate.Parameter.span(0.1f, 0.5f),
							Climate.Parameter.point(0.0f), Climate.Parameter.span(-1f, 1f), 0), biomeRegistry.getHolderOrThrow(ResourceKey.create(Registries.BIOME, new ResourceLocation("mountains_poem", "dark_taiga")))));
					addParameterPoint(parameters, new Pair<>(new Climate.ParameterPoint(Climate.Parameter.span(0.1f, 0.5f), Climate.Parameter.span(0.1f, 0.5f), Climate.Parameter.span(0.1f, 0.5f), Climate.Parameter.span(0.1f, 0.5f),
							Climate.Parameter.point(1.0f), Climate.Parameter.span(-1f, 1f), 0), biomeRegistry.getHolderOrThrow(ResourceKey.create(Registries.BIOME, new ResourceLocation("mountains_poem", "dark_taiga")))));
					addParameterPoint(parameters, new Pair<>(new Climate.ParameterPoint(Climate.Parameter.span(0f, 0.5f), Climate.Parameter.span(0.1f, 0.5f), Climate.Parameter.span(0.608f, 1f), Climate.Parameter.span(0.55f, 1f),
							Climate.Parameter.point(0.0f), Climate.Parameter.span(0f, 1f), 0), biomeRegistry.getHolderOrThrow(ResourceKey.create(Registries.BIOME, new ResourceLocation("mountains_poem", "green_rock_mountains")))));
					addParameterPoint(parameters, new Pair<>(new Climate.ParameterPoint(Climate.Parameter.span(0f, 0.5f), Climate.Parameter.span(0.1f, 0.5f), Climate.Parameter.span(0.608f, 1f), Climate.Parameter.span(0.55f, 1f),
							Climate.Parameter.point(1.0f), Climate.Parameter.span(0f, 1f), 0), biomeRegistry.getHolderOrThrow(ResourceKey.create(Registries.BIOME, new ResourceLocation("mountains_poem", "green_rock_mountains")))));
					addParameterPoint(parameters, new Pair<>(new Climate.ParameterPoint(Climate.Parameter.span(-0.5005f, 0.5f), Climate.Parameter.span(0.1f, 0.5f), Climate.Parameter.span(0f, 1.0001f), Climate.Parameter.span(0.1f, 0.55f),
							Climate.Parameter.point(0.0f), Climate.Parameter.span(0.8f, 1.33f), 0), biomeRegistry.getHolderOrThrow(ResourceKey.create(Registries.BIOME, new ResourceLocation("mountains_poem", "old_growth_yan_forest")))));
					addParameterPoint(parameters, new Pair<>(new Climate.ParameterPoint(Climate.Parameter.span(-0.5005f, 0.5f), Climate.Parameter.span(0.1f, 0.5f), Climate.Parameter.span(0f, 1.0001f), Climate.Parameter.span(0.1f, 0.55f),
							Climate.Parameter.point(1.0f), Climate.Parameter.span(0.8f, 1.33f), 0), biomeRegistry.getHolderOrThrow(ResourceKey.create(Registries.BIOME, new ResourceLocation("mountains_poem", "old_growth_yan_forest")))));
					chunkGenerator.biomeSource = MultiNoiseBiomeSource.createFromList(new Climate.ParameterList<>(parameters));
					chunkGenerator.featuresPerStep = Suppliers
							.memoize(() -> FeatureSorter.buildFeaturesPerStep(List.copyOf(chunkGenerator.biomeSource.possibleBiomes()), biome -> chunkGenerator.generationSettingsGetter.apply(biome).features(), true));
				}
				// Inject surface rules
				if (chunkGenerator instanceof NoiseBasedChunkGenerator noiseGenerator) {
					NoiseGeneratorSettings noiseGeneratorSettings = noiseGenerator.settings.value();
					SurfaceRules.RuleSource currentRuleSource = noiseGeneratorSettings.surfaceRule();
					if (currentRuleSource instanceof SurfaceRules.SequenceRuleSource sequenceRuleSource) {
						List<SurfaceRules.RuleSource> surfaceRules = new ArrayList<>(sequenceRuleSource.sequence());
						addSurfaceRule(surfaceRules, 1, preliminarySurfaceRule(ResourceKey.create(Registries.BIOME, new ResourceLocation("mountains_poem", "yanforest")), Blocks.GRASS_BLOCK.defaultBlockState(), Blocks.DIRT.defaultBlockState(),
								Blocks.DIRT.defaultBlockState()));
						addSurfaceRule(surfaceRules, 1, preliminarySurfaceRule(ResourceKey.create(Registries.BIOME, new ResourceLocation("mountains_poem", "newjiangforest")), Blocks.GRASS_BLOCK.defaultBlockState(), Blocks.DIRT.defaultBlockState(),
								Blocks.DIRT.defaultBlockState()));
						addSurfaceRule(surfaceRules, 1, preliminarySurfaceRule(ResourceKey.create(Registries.BIOME, new ResourceLocation("mountains_poem", "jianmei_bamboo_jungle")), MountainsPoemModBlocks.LUSH_GRASS_BLOCK.get().defaultBlockState(),
								MountainsPoemModBlocks.LUSH_DIRT.get().defaultBlockState(), MountainsPoemModBlocks.LUSH_DIRT.get().defaultBlockState()));
						addSurfaceRule(surfaceRules, 1, preliminarySurfaceRule(ResourceKey.create(Registries.BIOME, new ResourceLocation("mountains_poem", "shatang_forest")), Blocks.GRASS_BLOCK.defaultBlockState(), Blocks.DIRT.defaultBlockState(),
								Blocks.DIRT.defaultBlockState()));
						addSurfaceRule(surfaceRules, 1, preliminarySurfaceRule(ResourceKey.create(Registries.BIOME, new ResourceLocation("mountains_poem", "pan_forest")), Blocks.GRASS_BLOCK.defaultBlockState(), Blocks.DIRT.defaultBlockState(),
								Blocks.DIRT.defaultBlockState()));
						addSurfaceRule(surfaceRules, 1, preliminarySurfaceRule(ResourceKey.create(Registries.BIOME, new ResourceLocation("mountains_poem", "peach_blossom_forest")), Blocks.GRASS_BLOCK.defaultBlockState(),
								Blocks.DIRT.defaultBlockState(), Blocks.DIRT.defaultBlockState()));
						addSurfaceRule(surfaceRules, 1, preliminarySurfaceRule(ResourceKey.create(Registries.BIOME, new ResourceLocation("mountains_poem", "huang_guan_forest")), Blocks.GRASS_BLOCK.defaultBlockState(), Blocks.DIRT.defaultBlockState(),
								Blocks.DIRT.defaultBlockState()));
						addSurfaceRule(surfaceRules, 1, preliminarySurfaceRule(ResourceKey.create(Registries.BIOME, new ResourceLocation("mountains_poem", "dark_taiga")), Blocks.GRASS_BLOCK.defaultBlockState(), Blocks.DIRT.defaultBlockState(),
								Blocks.DIRT.defaultBlockState()));
						addSurfaceRule(surfaceRules, 1, preliminarySurfaceRule(ResourceKey.create(Registries.BIOME, new ResourceLocation("mountains_poem", "green_rock_mountains")), Blocks.STONE.defaultBlockState(), Blocks.STONE.defaultBlockState(),
								Blocks.STONE.defaultBlockState()));
						addSurfaceRule(surfaceRules, 1, preliminarySurfaceRule(ResourceKey.create(Registries.BIOME, new ResourceLocation("mountains_poem", "old_growth_yan_forest")), MountainsPoemModBlocks.LUSH_GRASS_BLOCK.get().defaultBlockState(),
								MountainsPoemModBlocks.LUSH_DIRT.get().defaultBlockState(), MountainsPoemModBlocks.LUSH_DIRT.get().defaultBlockState()));
						NoiseGeneratorSettings moddedNoiseGeneratorSettings = new NoiseGeneratorSettings(noiseGeneratorSettings.noiseSettings(), noiseGeneratorSettings.defaultBlock(), noiseGeneratorSettings.defaultFluid(),
								noiseGeneratorSettings.noiseRouter(), SurfaceRules.sequence(surfaceRules.toArray(SurfaceRules.RuleSource[]::new)), noiseGeneratorSettings.spawnTarget(), noiseGeneratorSettings.seaLevel(),
								noiseGeneratorSettings.disableMobGeneration(), noiseGeneratorSettings.aquifersEnabled(), noiseGeneratorSettings.oreVeinsEnabled(), noiseGeneratorSettings.useLegacyRandomSource());
						noiseGenerator.settings = new Holder.Direct<>(moddedNoiseGeneratorSettings);
					}
				}
			}
			if (dimensionType == dimensionTypeRegistry.getOrThrow(BuiltinDimensionTypes.NETHER)) {
				ChunkGenerator chunkGenerator = levelStem.generator();
				// Inject biomes to biome source
				if (chunkGenerator.getBiomeSource() instanceof MultiNoiseBiomeSource noiseSource) {
					List<Pair<Climate.ParameterPoint, Holder<Biome>>> parameters = new ArrayList<>(noiseSource.parameters().values());
					addParameterPoint(parameters, new Pair<>(new Climate.ParameterPoint(Climate.Parameter.span(0.4999f, 1f), Climate.Parameter.span(0.1f, 0.3f), Climate.Parameter.span(0.3f, 0.6f), Climate.Parameter.span(-0.5f, 0.5f),
							Climate.Parameter.point(0.0f), Climate.Parameter.span(-0.1f, 0.6f), 0), biomeRegistry.getHolderOrThrow(ResourceKey.create(Registries.BIOME, new ResourceLocation("mountains_poem", "ancient_battlefields")))));
					addParameterPoint(parameters, new Pair<>(new Climate.ParameterPoint(Climate.Parameter.span(0.4999f, 1f), Climate.Parameter.span(0.1f, 0.3f), Climate.Parameter.span(0.3f, 0.6f), Climate.Parameter.span(-0.5f, 0.5f),
							Climate.Parameter.point(1.0f), Climate.Parameter.span(-0.1f, 0.6f), 0), biomeRegistry.getHolderOrThrow(ResourceKey.create(Registries.BIOME, new ResourceLocation("mountains_poem", "ancient_battlefields")))));
					addParameterPoint(parameters, new Pair<>(new Climate.ParameterPoint(Climate.Parameter.span(-0.5f, 0.5f), Climate.Parameter.span(0.8f, 1f), Climate.Parameter.span(0.7f, 1.1f), Climate.Parameter.span(0.1f, 0.5002f),
							Climate.Parameter.point(0.0f), Climate.Parameter.span(-1f, 1f), 0), biomeRegistry.getHolderOrThrow(ResourceKey.create(Registries.BIOME, new ResourceLocation("mountains_poem", "under_rock_hill")))));
					addParameterPoint(parameters, new Pair<>(new Climate.ParameterPoint(Climate.Parameter.span(-0.5f, 0.5f), Climate.Parameter.span(0.8f, 1f), Climate.Parameter.span(0.7f, 1.1f), Climate.Parameter.span(0.1f, 0.5002f),
							Climate.Parameter.point(1.0f), Climate.Parameter.span(-1f, 1f), 0), biomeRegistry.getHolderOrThrow(ResourceKey.create(Registries.BIOME, new ResourceLocation("mountains_poem", "under_rock_hill")))));
					chunkGenerator.biomeSource = MultiNoiseBiomeSource.createFromList(new Climate.ParameterList<>(parameters));
					chunkGenerator.featuresPerStep = Suppliers
							.memoize(() -> FeatureSorter.buildFeaturesPerStep(List.copyOf(chunkGenerator.biomeSource.possibleBiomes()), biome -> chunkGenerator.generationSettingsGetter.apply(biome).features(), true));
				}
				// Inject surface rules
				if (chunkGenerator instanceof NoiseBasedChunkGenerator noiseGenerator) {
					NoiseGeneratorSettings noiseGeneratorSettings = noiseGenerator.settings.value();
					SurfaceRules.RuleSource currentRuleSource = noiseGeneratorSettings.surfaceRule();
					if (currentRuleSource instanceof SurfaceRules.SequenceRuleSource sequenceRuleSource) {
						List<SurfaceRules.RuleSource> surfaceRules = new ArrayList<>(sequenceRuleSource.sequence());
						addSurfaceRule(surfaceRules, 2, anySurfaceRule(ResourceKey.create(Registries.BIOME, new ResourceLocation("mountains_poem", "ancient_battlefields")), MountainsPoemModBlocks.UNDER_GRASS_BLOCK.get().defaultBlockState(),
								MountainsPoemModBlocks.UNDER_DIRT.get().defaultBlockState(), MountainsPoemModBlocks.UNDER_DIRT.get().defaultBlockState()));
						addSurfaceRule(surfaceRules, 2, anySurfaceRule(ResourceKey.create(Registries.BIOME, new ResourceLocation("mountains_poem", "under_rock_hill")), MountainsPoemModBlocks.UNDER_ROCK.get().defaultBlockState(),
								MountainsPoemModBlocks.UNDER_ROCK.get().defaultBlockState(), MountainsPoemModBlocks.UNDER_ROCK.get().defaultBlockState()));
						NoiseGeneratorSettings moddedNoiseGeneratorSettings = new NoiseGeneratorSettings(noiseGeneratorSettings.noiseSettings(), noiseGeneratorSettings.defaultBlock(), noiseGeneratorSettings.defaultFluid(),
								noiseGeneratorSettings.noiseRouter(), SurfaceRules.sequence(surfaceRules.toArray(SurfaceRules.RuleSource[]::new)), noiseGeneratorSettings.spawnTarget(), noiseGeneratorSettings.seaLevel(),
								noiseGeneratorSettings.disableMobGeneration(), noiseGeneratorSettings.aquifersEnabled(), noiseGeneratorSettings.oreVeinsEnabled(), noiseGeneratorSettings.useLegacyRandomSource());
						noiseGenerator.settings = new Holder.Direct<>(moddedNoiseGeneratorSettings);
					}
				}
			}
		}
	}

	private static SurfaceRules.RuleSource preliminarySurfaceRule(ResourceKey<Biome> biomeKey, BlockState groundBlock, BlockState undergroundBlock, BlockState underwaterBlock) {
		return SurfaceRules.ifTrue(SurfaceRules.isBiome(biomeKey),
				SurfaceRules.ifTrue(SurfaceRules.abovePreliminarySurface(),
						SurfaceRules.sequence(
								SurfaceRules.ifTrue(SurfaceRules.stoneDepthCheck(0, false, 0, CaveSurface.FLOOR),
										SurfaceRules.sequence(SurfaceRules.ifTrue(SurfaceRules.waterBlockCheck(-1, 0), SurfaceRules.state(groundBlock)), SurfaceRules.state(underwaterBlock))),
								SurfaceRules.ifTrue(SurfaceRules.stoneDepthCheck(0, true, 0, CaveSurface.FLOOR), SurfaceRules.state(undergroundBlock)))));
	}

	private static SurfaceRules.RuleSource anySurfaceRule(ResourceKey<Biome> biomeKey, BlockState groundBlock, BlockState undergroundBlock, BlockState underwaterBlock) {
		return SurfaceRules.ifTrue(SurfaceRules.isBiome(biomeKey),
				SurfaceRules.sequence(
						SurfaceRules.ifTrue(SurfaceRules.stoneDepthCheck(0, false, 0, CaveSurface.FLOOR),
								SurfaceRules.sequence(SurfaceRules.ifTrue(SurfaceRules.waterBlockCheck(-1, 0), SurfaceRules.state(groundBlock)), SurfaceRules.state(underwaterBlock))),
						SurfaceRules.ifTrue(SurfaceRules.stoneDepthCheck(0, true, 0, CaveSurface.FLOOR), SurfaceRules.state(undergroundBlock))));
	}

	private static void addParameterPoint(List<Pair<Climate.ParameterPoint, Holder<Biome>>> parameters, Pair<Climate.ParameterPoint, Holder<Biome>> point) {
		if (!parameters.contains(point))
			parameters.add(point);
	}

	private static void addSurfaceRule(List<SurfaceRules.RuleSource> surfaceRules, int index, SurfaceRules.RuleSource rule) {
		if (!surfaceRules.contains(rule))
			surfaceRules.add(index, rule);
	}
}
