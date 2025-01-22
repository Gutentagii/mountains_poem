package net.mcreator.mountainspoem.procedures;

public class WhiteArmorXiongJiaShiJianMeiYouXiKeProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		entity.setTicksFrozen(0);
	}
}
