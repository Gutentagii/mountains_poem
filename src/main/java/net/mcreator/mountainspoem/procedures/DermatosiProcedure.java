package net.mcreator.mountainspoem.procedures;

import net.minecraftforge.eventbus.api.Event;

import net.mcreator.mountainspoem.init.MountainsPoemModMobEffects;

@Mod.EventBusSubscriber
public class DermatosiProcedure {
	@SubscribeEvent
	public static void onUseItemStart(LivingEntityUseItemEvent.Start event) {
		if (event != null && event.getEntity() != null) {
			execute(event, event.getEntity().level(), event.getEntity());
		}
	}

	public static void execute(LevelAccessor world, Entity entity) {
		execute(null, world, entity);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		if (entity instanceof LivingEntity _livEnt0 && _livEnt0.hasEffect(MountainsPoemModMobEffects.DERMATOSIS.get())) {
			entity.hurt(new DamageSource(world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(DamageTypes.GENERIC)), (float) 0.5);
		}
	}
}
