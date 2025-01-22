package net.mcreator.mountainspoem.procedures;

import net.minecraftforge.eventbus.api.Event;

import net.mcreator.mountainspoem.init.MountainsPoemModParticleTypes;
import net.mcreator.mountainspoem.init.MountainsPoemModItems;
import net.mcreator.mountainspoem.init.MountainsPoemModEntities;

@Mod.EventBusSubscriber
public class DeathJadePendantRightClickProcedure {
	@SubscribeEvent
	public static void onRightClickBlock(PlayerInteractEvent.RightClickBlock event) {
		if (event.getHand() != event.getEntity().getUsedItemHand())
			return;
		execute(event, event.getLevel(), event.getPos().getX(), event.getPos().getY(), event.getPos().getZ(), event.getEntity());
	}

	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		execute(null, world, x, y, z, entity);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == MountainsPoemModItems.THE_UNDER.get()) {
			if (entity instanceof LivingEntity _entity)
				_entity.swing(InteractionHand.MAIN_HAND, true);
			if (world instanceof ServerLevel _level)
				_level.sendParticles((SimpleParticleType) (MountainsPoemModParticleTypes.SACRIFICE_P.get()), x, y, z, 5, 1, 1, 1, 1);
			if (world instanceof ServerLevel _level)
				_level.sendParticles((SimpleParticleType) (MountainsPoemModParticleTypes.THE_UNDER_WORLD.get()), x, y, z, 5, 1, 1, 1, 1);
			if (world instanceof Level _level) {
				if (!_level.isClientSide()) {
					_level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("mountains_poem:the_under_portal_ambient")), SoundSource.NEUTRAL, 1, 1);
				} else {
					_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("mountains_poem:the_under_portal_ambient")), SoundSource.NEUTRAL, 1, 1, false);
				}
			}
			if (world instanceof ServerLevel _level) {
				Entity entityToSpawn = MountainsPoemModEntities.SOUL_SHARD.get().spawn(_level, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
				if (entityToSpawn != null) {
					entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
				}
			}
		}
	}
}
