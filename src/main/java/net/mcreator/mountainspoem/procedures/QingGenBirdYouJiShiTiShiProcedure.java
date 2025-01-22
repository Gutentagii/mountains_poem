package net.mcreator.mountainspoem.procedures;

import net.mcreator.mountainspoem.entity.QingGenBirdEntity;

public class QingGenBirdYouJiShiTiShiProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, Entity sourceentity) {
		if (entity == null || sourceentity == null)
			return;
		if ((sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).is(ItemTags.create(new ResourceLocation("minecraft:fishes")))) {
			if (Math.random() < 0.7) {
				for (int index0 = 0; index0 < 8; index0++) {
					if (entity instanceof QingGenBirdEntity) {
						((QingGenBirdEntity) entity).setAnimation("dance");
					}
					if (world instanceof Level _level) {
						if (!_level.isClientSide()) {
							_level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("mountains_poem:qinggen")), SoundSource.NEUTRAL, 1, (float) 1.2);
						} else {
							_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("mountains_poem:qinggen")), SoundSource.NEUTRAL, 1, (float) 1.2, false);
						}
					}
				}
			}
			(sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).shrink(1);
			if (sourceentity instanceof LivingEntity _entity)
				_entity.swing(InteractionHand.MAIN_HAND, true);
		}
	}
}
