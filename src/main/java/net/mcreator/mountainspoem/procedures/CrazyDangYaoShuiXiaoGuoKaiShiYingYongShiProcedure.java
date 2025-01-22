package net.mcreator.mountainspoem.procedures;

public class CrazyDangYaoShuiXiaoGuoKaiShiYingYongShiProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		entity.setSecondsOnFire(5);
		entity.setShiftKeyDown(true);
	}
}
