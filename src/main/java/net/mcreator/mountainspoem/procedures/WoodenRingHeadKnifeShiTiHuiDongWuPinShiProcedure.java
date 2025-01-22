package net.mcreator.mountainspoem.procedures;

public class WoodenRingHeadKnifeShiTiHuiDongWuPinShiProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		if (world instanceof Level _level) {
			if (!_level.isClientSide()) {
				_level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("mountains_poem:ring_head_sword_wave")), SoundSource.NEUTRAL, 1, 1);
			} else {
				_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("mountains_poem:ring_head_sword_wave")), SoundSource.NEUTRAL, 1, 1, false);
			}
		}
	}
}
