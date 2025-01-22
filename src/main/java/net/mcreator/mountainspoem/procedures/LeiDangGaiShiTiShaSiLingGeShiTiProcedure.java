package net.mcreator.mountainspoem.procedures;

import net.mcreator.mountainspoem.entity.LeiEntity;

public class LeiDangGaiShiTiShaSiLingGeShiTiProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if (Math.random() < 0.9) {
			if ((entity instanceof LeiEntity animatable ? animatable.getTexture() : "null").equals("lei_lion")) {
				if (entity instanceof LeiEntity animatable)
					animatable.setTexture("lei_lion_2");
			}
			if ((entity instanceof LeiEntity animatable ? animatable.getTexture() : "null").equals("lei_lion_4")) {
				if (entity instanceof LeiEntity animatable)
					animatable.setTexture("lei_lion_5");
			}
		}
		if (Math.random() < 0.3) {
			if (entity instanceof LeiEntity) {
				((LeiEntity) entity).setAnimation("play");
			}
			if (world instanceof Level _level) {
				if (!_level.isClientSide()) {
					_level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("mountains_poem:lei")), SoundSource.NEUTRAL, 1, 1);
				} else {
					_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("mountains_poem:lei")), SoundSource.NEUTRAL, 1, 1, false);
				}
			}
		}
	}
}
