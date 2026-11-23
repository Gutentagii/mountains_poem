
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package com.xiris.mountainspoem.init;

import com.xiris.mountainspoem.client.particle.*;
import com.xiris.mountainspoem.client.particle.*;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.RegisterParticleProvidersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class MountainsPoemModParticles {
	@SubscribeEvent
	public static void registerParticles(RegisterParticleProvidersEvent event) {
		event.registerSpriteSet(MountainsPoemModParticleTypes.FENG_HUANG.get(), FengHuangParticle::provider);
		event.registerSpriteSet(MountainsPoemModParticleTypes.PEACH_BLOSSOMS.get(), PeachBlossomsParticle::provider);
		event.registerSpriteSet(MountainsPoemModParticleTypes.PEACH_BLOSSOMS_2.get(), PeachBlossoms2Particle::provider);
		event.registerSpriteSet(MountainsPoemModParticleTypes.WATER_RIDE.get(), WaterRideParticle::provider);
		event.registerSpriteSet(MountainsPoemModParticleTypes.PLAGUES.get(), PlaguesParticle::provider);
		event.registerSpriteSet(MountainsPoemModParticleTypes.SACRIFICE_A.get(), SacrificeAParticle::provider);
		event.registerSpriteSet(MountainsPoemModParticleTypes.SACRIFICE_B.get(), SacrificeBParticle::provider);
		event.registerSpriteSet(MountainsPoemModParticleTypes.SACRIFICE_C.get(), SacrificeCParticle::provider);
		event.registerSpriteSet(MountainsPoemModParticleTypes.SACRIFICE_D.get(), SacrificeDParticle::provider);
		event.registerSpriteSet(MountainsPoemModParticleTypes.SACRIFICE_E.get(), SacrificeEParticle::provider);
		event.registerSpriteSet(MountainsPoemModParticleTypes.SACRIFICE_F.get(), SacrificeFParticle::provider);
		event.registerSpriteSet(MountainsPoemModParticleTypes.SACRIFICE_G.get(), SacrificeGParticle::provider);
		event.registerSpriteSet(MountainsPoemModParticleTypes.SACRIFICE_H.get(), SacrificeHParticle::provider);
		event.registerSpriteSet(MountainsPoemModParticleTypes.SACRIFICE_I.get(), SacrificeIParticle::provider);
		event.registerSpriteSet(MountainsPoemModParticleTypes.SACRIFICE_J.get(), SacrificeJParticle::provider);
		event.registerSpriteSet(MountainsPoemModParticleTypes.SACRIFICE_K.get(), SacrificeKParticle::provider);
		event.registerSpriteSet(MountainsPoemModParticleTypes.SACRIFICE_L.get(), SacrificeLParticle::provider);
		event.registerSpriteSet(MountainsPoemModParticleTypes.SACRIFICE_M.get(), SacrificeMParticle::provider);
		event.registerSpriteSet(MountainsPoemModParticleTypes.SACRIFICE_N.get(), SacrificeNParticle::provider);
		event.registerSpriteSet(MountainsPoemModParticleTypes.SACRIFICE_O.get(), SacrificeOParticle::provider);
		event.registerSpriteSet(MountainsPoemModParticleTypes.GUI_A.get(), GuiAParticle::provider);
		event.registerSpriteSet(MountainsPoemModParticleTypes.GUI_B.get(), GuiBParticle::provider);
		event.registerSpriteSet(MountainsPoemModParticleTypes.GUI_C.get(), GuiCParticle::provider);
		event.registerSpriteSet(MountainsPoemModParticleTypes.SACRIFICE_P.get(), SacrificePParticle::provider);
		event.registerSpriteSet(MountainsPoemModParticleTypes.SACRIFICE_Q.get(), SacrificeQParticle::provider);
		event.registerSpriteSet(MountainsPoemModParticleTypes.SACRIFICE_R.get(), SacrificeRParticle::provider);
		event.registerSpriteSet(MountainsPoemModParticleTypes.SHI.get(), ShiParticle::provider);
		event.registerSpriteSet(MountainsPoemModParticleTypes.SOULS_PIECE.get(), SoulsPieceParticle::provider);
		event.registerSpriteSet(MountainsPoemModParticleTypes.XIANGYUN.get(), XiangyunParticle::provider);
		event.registerSpriteSet(MountainsPoemModParticleTypes.THE_UNDER_WORLD.get(), TheUnderWorldParticle::provider);
		event.registerSpriteSet(MountainsPoemModParticleTypes.MAGIC.get(), MagicParticle::provider);
		event.registerSpriteSet(MountainsPoemModParticleTypes.SOUL_MAGIC.get(), SoulMagicParticle::provider);
		event.registerSpriteSet(MountainsPoemModParticleTypes.UNDER_BIOME.get(), UnderBiomeParticle::provider);
		event.registerSpriteSet(MountainsPoemModParticleTypes.ICE.get(), IceParticle::provider);
        	}
}
