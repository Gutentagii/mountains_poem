package net.mcreator.mountainspoem.procedures;

public class WhiteMonkeyDangXiaoShiShiJianDaoShiProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		if (Math.random() < 0.3) {
			if (world instanceof ServerLevel _level)
				_level.addFreshEntity(new ExperienceOrb(_level, x, y, z, 2));
		}
	}
}
