package net.mcreator.mountainspoem;

import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.fml.util.thread.SidedThreadGroups;
import net.minecraftforge.network.NetworkEvent;
import net.minecraftforge.network.NetworkRegistry;
import net.minecraftforge.network.simple.SimpleChannel;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

import net.mcreator.mountainspoem.init.MountainsPoemModVillagerProfessions;
import net.mcreator.mountainspoem.init.MountainsPoemModTabs;
import net.mcreator.mountainspoem.init.MountainsPoemModSounds;
import net.mcreator.mountainspoem.init.MountainsPoemModPotions;
import net.mcreator.mountainspoem.init.MountainsPoemModParticleTypes;
import net.mcreator.mountainspoem.init.MountainsPoemModPaintings;
import net.mcreator.mountainspoem.init.MountainsPoemModMobEffects;
import net.mcreator.mountainspoem.init.MountainsPoemModMenus;
import net.mcreator.mountainspoem.init.MountainsPoemModItems;
import net.mcreator.mountainspoem.init.MountainsPoemModEntities;
import net.mcreator.mountainspoem.init.MountainsPoemModEnchantments;
import net.mcreator.mountainspoem.init.MountainsPoemModBlocks;
import net.mcreator.mountainspoem.init.MountainsPoemModBlockEntities;

import java.util.function.Supplier;
import java.util.function.Function;
import java.util.function.BiConsumer;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.List;
import java.util.Collection;
import java.util.ArrayList;
import java.util.AbstractMap;

@Mod("mountains_poem")
public class MountainsPoemMod {
	public static final Logger LOGGER = LogManager.getLogger(MountainsPoemMod.class);
	public static final String MODID = "mountains_poem";

	public MountainsPoemMod() {
		// Start of user code block mod constructor
		// End of user code block mod constructor
		MinecraftForge.EVENT_BUS.register(this);
		IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
		MountainsPoemModSounds.REGISTRY.register(bus);
		MountainsPoemModBlocks.REGISTRY.register(bus);
		MountainsPoemModBlockEntities.REGISTRY.register(bus);
		MountainsPoemModItems.REGISTRY.register(bus);
		MountainsPoemModEntities.REGISTRY.register(bus);
		MountainsPoemModEnchantments.REGISTRY.register(bus);
		MountainsPoemModTabs.REGISTRY.register(bus);

		MountainsPoemModMobEffects.REGISTRY.register(bus);
		MountainsPoemModPotions.REGISTRY.register(bus);
		MountainsPoemModPaintings.REGISTRY.register(bus);
		MountainsPoemModParticleTypes.REGISTRY.register(bus);
		MountainsPoemModVillagerProfessions.PROFESSIONS.register(bus);
		MountainsPoemModMenus.REGISTRY.register(bus);
		// Start of user code block mod init
		// End of user code block mod init
	}

	// Start of user code block mod methods
	// End of user code block mod methods
	private static final String PROTOCOL_VERSION = "1";
	public static final SimpleChannel PACKET_HANDLER = NetworkRegistry.newSimpleChannel(new ResourceLocation(MODID, MODID), () -> PROTOCOL_VERSION, PROTOCOL_VERSION::equals, PROTOCOL_VERSION::equals);
	private static int messageID = 0;

	public static <T> void addNetworkMessage(Class<T> messageType, BiConsumer<T, FriendlyByteBuf> encoder, Function<FriendlyByteBuf, T> decoder, BiConsumer<T, Supplier<NetworkEvent.Context>> messageConsumer) {
		PACKET_HANDLER.registerMessage(messageID, messageType, encoder, decoder, messageConsumer);
		messageID++;
	}

	private static final Collection<AbstractMap.SimpleEntry<Runnable, Integer>> workQueue = new ConcurrentLinkedQueue<>();

	public static void queueServerWork(int tick, Runnable action) {
		if (Thread.currentThread().getThreadGroup() == SidedThreadGroups.SERVER)
			workQueue.add(new AbstractMap.SimpleEntry<>(action, tick));
	}

	@SubscribeEvent
	public void tick(TickEvent.ServerTickEvent event) {
		if (event.phase == TickEvent.Phase.END) {
			List<AbstractMap.SimpleEntry<Runnable, Integer>> actions = new ArrayList<>();
			workQueue.forEach(work -> {
				work.setValue(work.getValue() - 1);
				if (work.getValue() == 0)
					actions.add(work);
			});
			actions.forEach(e -> e.getKey().run());
			workQueue.removeAll(actions);
		}
	}
}
