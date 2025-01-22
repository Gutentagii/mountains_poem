package net.mcreator.mountainspoem.procedures;

import net.mcreator.mountainspoem.entity.JufuEntity;

public class JufuDangShiTiGengXinKeShiProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if ((entity.getDisplayName().getString()).equals("\u5409\u5409") || (entity.getDisplayName().getString()).equals("\u5409\u5409\u56FD\u738B") || (entity.getDisplayName().getString()).equals("jiji")
				|| (entity.getDisplayName().getString()).equals("\u0434\u0436\u0438\u0434\u0436\u0438")) {
			if (entity instanceof JufuEntity animatable)
				animatable.setTexture("jiji");
		} else {
			if (entity instanceof JufuEntity animatable)
				animatable.setTexture("jufu");
		}
	}
}
