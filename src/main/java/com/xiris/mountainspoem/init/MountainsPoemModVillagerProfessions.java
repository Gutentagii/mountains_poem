package com.xiris.mountainspoem.init;

import com.google.common.collect.ImmutableSet;
import com.xiris.mountainspoem.MountainsPoemMod;
import net.minecraft.core.Holder;
import net.minecraft.core.registries.Registries;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.entity.ai.village.poi.PoiType;
import net.minecraft.world.entity.npc.VillagerProfession;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegisterEvent;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.function.Supplier;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, modid = MountainsPoemMod.MOD_ID)
public class MountainsPoemModVillagerProfessions {
    private static final Map<String, ProfessionPoiType> POI_TYPES = new HashMap<>();

    public static final DeferredRegister<VillagerProfession> PROFESSIONS = DeferredRegister.create(Registries.VILLAGER_PROFESSION, MountainsPoemMod.MOD_ID);

    public static final Supplier<VillagerProfession> COPPER_SMITH = registerProfession("copper_smith", MountainsPoemModBlocks.GILDED_COPPER_BLOCK, () -> SoundEvents.COPPER_HIT);
    public static final Supplier<VillagerProfession> JADE_MASON = registerProfession("jade_mason", MountainsPoemModBlocks.JADE_CARVER, () -> SoundEvents.STONE_HIT);
    public static final Supplier<VillagerProfession> HUAXIA_SORCERER = registerProfession("huaxia_sorcerer", MountainsPoemModBlocks.SACRIFICIAL_TABLE, () -> SoundEvents.CANDLE_EXTINGUISH);

    private static Supplier<VillagerProfession> registerProfession(String name, Supplier<Block> block, Supplier<SoundEvent> soundEvent) {
        POI_TYPES.put(name, new ProfessionPoiType(block, null));
        return PROFESSIONS.register(name, () -> {
            Predicate<Holder<PoiType>> poiPredicate = poiTypeHolder ->
                    (POI_TYPES.get(name).poiType != null) && (poiTypeHolder == POI_TYPES.get(name).poiType);
            return new VillagerProfession(
                    MountainsPoemMod.MOD_ID + ":" + name,
                    poiPredicate, poiPredicate,
                    ImmutableSet.of(),
                    ImmutableSet.of(),
                    soundEvent.get()
            );
        });
    }

    @SubscribeEvent
    public static void registerProfessionPointsOfInterest(RegisterEvent event) {
        event.register(ForgeRegistries.Keys.POI_TYPES, helper -> {
            for (Map.Entry<String, ProfessionPoiType> entry : POI_TYPES.entrySet()) {
                Block block = entry.getValue().block.get();
                String name = entry.getKey();

                Optional<Holder<PoiType>> existingCheck = net.minecraft.world.entity.ai.village.poi.PoiTypes.forState(block.defaultBlockState());
                if (existingCheck.isPresent()) {
                    MountainsPoemMod.LOGGER.error("Skipping villager profession {}: POI block {} is already used", name, block);
                    continue;
                }

                PoiType poiType = new PoiType(ImmutableSet.copyOf(block.getStateDefinition().getPossibleStates()), 1, 1);
                helper.register(name, poiType);

                entry.getValue().poiType = ForgeRegistries.POI_TYPES.getHolder(poiType).orElseThrow();
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