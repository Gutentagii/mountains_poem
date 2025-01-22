
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.mountainspoem.init;

import com.google.common.collect.ImmutableSet;
import net.mcreator.mountainspoem.MountainsPoemMod;
import net.minecraft.core.Holder;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.entity.ai.village.poi.PoiType;
import net.minecraft.world.entity.ai.village.poi.PoiTypes;
import net.minecraft.world.entity.npc.VillagerProfession;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegisterEvent;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;
import java.util.function.Predicate;
import java.util.Optional;
import java.util.Map;
import java.util.HashMap;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class MountainsPoemModVillagerProfessions {
	private static final Map<String, ProfessionPoiType> POI_TYPES = new HashMap<>();
	public static final DeferredRegister<VillagerProfession> PROFESSIONS = DeferredRegister.create(ForgeRegistries.VILLAGER_PROFESSIONS, MountainsPoemMod.MODID);
	public static final RegistryObject<VillagerProfession> COPPER_SMITH = registerProfession("copper_smith", () -> MountainsPoemModBlocks.GILDED_COPPER_BLOCK.get(),
			() -> ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.copper.hit")));
	public static final RegistryObject<VillagerProfession> JADE_MASON = registerProfession("jade_mason", () -> MountainsPoemModBlocks.JADE_CARVER.get(), () -> ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.stone.hit")));
	public static final RegistryObject<VillagerProfession> HUAXIA_SORCERER = registerProfession("huaxia_sorcerer", () -> MountainsPoemModBlocks.SACRIFICIAL_TABLE.get(),
			() -> ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.candle.extinguish")));

	private static RegistryObject<VillagerProfession> registerProfession(String name, Supplier<Block> block, Supplier<SoundEvent> soundEvent) {
		POI_TYPES.put(name, new ProfessionPoiType(block, null));
		return PROFESSIONS.register(name, () -> {
			Predicate<Holder<PoiType>> poiPredicate = poiTypeHolder -> (POI_TYPES.get(name).poiType != null) && (poiTypeHolder.get() == POI_TYPES.get(name).poiType.get());
			return new VillagerProfession(MountainsPoemMod.MODID + ":" + name, poiPredicate, poiPredicate, ImmutableSet.of(), ImmutableSet.of(), soundEvent.get());
		});
	}

	@SubscribeEvent
	public static void registerProfessionPointsOfInterest(RegisterEvent event) {
		event.register(ForgeRegistries.Keys.POI_TYPES, registerHelper -> {
			for (Map.Entry<String, ProfessionPoiType> entry : POI_TYPES.entrySet()) {
				Block block = entry.getValue().block.get();
				String name = entry.getKey();
				Optional<Holder<PoiType>> existingCheck = PoiTypes.forState(block.defaultBlockState());
				if (existingCheck.isPresent()) {
					MountainsPoemMod.LOGGER.error("Skipping villager profession " + name + " that uses POI block " + block + " that is already in use by " + existingCheck);
					continue;
				}
				PoiType poiType = new PoiType(ImmutableSet.copyOf(block.getStateDefinition().getPossibleStates()), 1, 1);
				registerHelper.register(name, poiType);
				entry.getValue().poiType = ForgeRegistries.POI_TYPES.getHolder(poiType).get();
			}
		});
	}

	private static class ProfessionPoiType {
		final Supplier<Block> block;
		Holder<PoiType> poiType;

		ProfessionPoiType(Supplier<Block> block, Holder<PoiType> poiType) {
			this.block = block;
			this.poiType = poiType;
		}
	}
}
